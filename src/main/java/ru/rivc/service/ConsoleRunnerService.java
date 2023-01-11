package ru.rivc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rivc.data.entity.HumanEntity;
import ru.rivc.data.repository.HumanEntityRepository;
import ru.rivc.pojo.Qualification;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

@Service
public class ConsoleRunnerService {
    private final int BAD_INPUT_TYPE = -1;
    private final int HUMAN_TO_PARTICIPATE_AT_LOTTERY = 5;
    private final HumanListService humanListService;

    private final LotteryService lotteryService;

    private final HumanEntityRepository humanEntityRepository;
    Scanner scanner = new Scanner(System.in);

    @Autowired
    public ConsoleRunnerService(HumanListService humanListService, LotteryService lotteryService, HumanEntityRepository humanEntityRepository) {
        this.humanListService = humanListService;
        this.lotteryService = lotteryService;
        this.humanEntityRepository = humanEntityRepository;
    }

    public void run() {
        while (true) {
            int userInput;

            System.out.println("***************");
            System.out.println("Insert command type:");
            System.out.println("1 to find by id;");
            System.out.println("2 to group by name;");
            System.out.println("3 to start lottery;");
            System.out.println("4 to run repository method;");
            System.out.println("0 to exit.");
            System.out.println("***************");

            userInput = checkUserInput();

            switch (userInput) {
                case 1 -> {
                    System.out.println("Insert user id");
                    try {
                        System.out.println(humanListService.findById(checkUserInput()).orElseThrow());
                    } catch (NoSuchElementException e) {
                        System.out.println("User not found");
                    }
                }
                case 2 -> {
                    System.out.println("Grouping adult humans");
                    System.out.println(humanListService.groupByName());
                }
                case 3 -> {
                    System.out.println("Starting lottery");
                    lotteryService.runLottery(HUMAN_TO_PARTICIPATE_AT_LOTTERY);
                }
                case 4 -> {
                    System.out.println("Searching");
                    System.out.println(getUsersBySearchQuery());

                }
                case 0 -> {
                    System.out.println("Shutdown our program");
                    return;
                }

                case BAD_INPUT_TYPE -> System.out.println("Wrong input, it's not are number");

                default -> System.out.println("Command type not found");

            }
        }
    }

    private int checkUserInput() {
        try {
            return Integer.parseInt(scanner.next());
        } catch (Exception e) {
            return BAD_INPUT_TYPE;
        }
    }

    private List<HumanEntity> getUsersBySearchQuery() {

        return humanEntityRepository.findAllByBirthdayBetweenAndQualification(
                LocalDate.of(1990, 1, 1),
                LocalDate.of(1992, 1, 1),
                Qualification.ENGINEER);

    }
}
