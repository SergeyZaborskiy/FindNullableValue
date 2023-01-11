package ru.rivc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rivc.pojo.Human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

@Service
public class
LotteryService {

    private final HumanListService humanListService;

    List<Human> applicantsList = Collections.synchronizedList(new ArrayList<>());

    CyclicBarrier cyclicBarrier;

    boolean isActive = true;

    @Autowired
    public LotteryService(HumanListService humanListService) {
        this.humanListService = humanListService;
    }

    public void runLottery(int numberOfApplicant) {


        //TODO stuff like in example below


        cyclicBarrier = new CyclicBarrier(numberOfApplicant, new CheckWinner());

        while (isActive) {

            Thread worker = new Thread(new ApplicantFinder());
            worker.start();

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }



    class ApplicantFinder implements Runnable {

        @Override
        public void run() {

            Human applicant = humanListService.getRandomHumanForLottery();

            applicantsList.add(applicant);

            System.out.println("applicant name is " + applicant.getName() + " with id " + applicant.getId());

            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Closing ApplicantFinder thread");
        }
    }


    class CheckWinner implements Runnable {

        @Override
        public void run() {

            Random random = new Random();

            Human winner = applicantsList.get(random.nextInt(applicantsList.size()));

            System.out.println("Lottery is complete");

            System.out.println("Winner is - " + winner.getName() + " with ID " + winner.getId());
        }
    }
}
