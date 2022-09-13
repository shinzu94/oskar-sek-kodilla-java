package rps;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class RockPaperScissorsGame {
    private final int ROCK = 1;
    private final int PAPER = 2;
    private final int SCISSORS = 3;
    private final List<Integer> AVAILABLE_ACTION = Arrays.asList(ROCK, PAPER, SCISSORS);
    private final Character ENDGAME = 'x';
    private final Character NEWGAME = 'n';
    private final List<Character> AVAILABLE_ENDING_ACTION = Arrays.asList(ENDGAME, NEWGAME);
    private final Scanner IN;
    private final Random RANDOM;
    private int roundsToWin;
    private String playerName;
    private int playerResult;
    private int computerResult;

    public RockPaperScissorsGame() {
        IN = new Scanner(System.in);
        RANDOM = new Random();
    }


    public void initialize() {
        preparePlayerName();
        prepareRoundsNumber();
        printInstruction();
    }

    private void preparePlayerName() {
        System.out.println("Jak masz na imię?");
        playerName = IN.nextLine();
    }

    private void prepareRoundsNumber() {
        System.out.println("Po ilu wygranych ma zakończyć się gra?");
        roundsToWin = IN.nextInt();
    }


    private void printInstruction() {
        System.out.println("klawisz " + ROCK + " – zagranie \"kamień\",\n" +
                "klawisz " + PAPER + " – zagranie \"papier\",\n" +
                "klawisz " + SCISSORS + " – zagranie \"nożyce\",\n" +
                "klawisz x – zakończenie gry poprzedzone pytaniem \"Czy na pewno zakończyć grę?\",\n" +
                "klawisz n – uruchomienie gry od nowa poprzedzone pytaniem \"Czy na pewno zakończyć aktualną grę?\",");
    }

    public void play() {
        char endingAction;
        do {
            initializePlay();
            do {
                executeTurn();
            } while (!(playerResult == roundsToWin || computerResult == roundsToWin));

            System.out.println(playerName + " " + (playerResult > computerResult ? "Wygrałeś!" : "Przegrałeś!"));

            endingAction = checkEndingAction();
        } while (endingAction == NEWGAME);
    }

    private char checkEndingAction() {
        char endingAction;
        boolean confirm;
        do {
            System.out.println(playerName + " chcesz zakończyć grę(x) czy zagrać jeszcze raz(n)?");
            do {
                endingAction = IN.next().charAt(0);
            } while (!AVAILABLE_ENDING_ACTION.contains(endingAction));
            System.out.println(endingAction == ENDGAME
                    ? "Czy na pewno zakończyć grę? y/n"
                    : "Czy na pewno zakończyć aktualną grę? y/n");
            confirm = IN.next().charAt(0) == 'y';
        } while (!confirm);
        return endingAction;
    }

    private void executeTurn() {
        System.out.println("Wykonaj ruch");
        int playAction = preparePlayerAction();
        final int computerAction = RANDOM.nextInt(3) + 1;
        changeResults(playAction, computerAction);
        System.out.println(convertConstantToName(playAction) + " kontra " + convertConstantToName(computerAction));
        System.out.println("Wynik: " + playerResult + ":" + computerResult);
    }

    private void initializePlay() {
        playerResult = 0;
        computerResult = 0;
    }

    private int preparePlayerAction() {
        int playAction;
        do {
            playAction = IN.nextInt();
        } while (!AVAILABLE_ACTION.contains(playAction));
        return playAction;
    }

    private void changeResults(int playAction, int computerAction) {
        if (checkPlayerWin(computerAction, playAction)) {
            playerResult++;
        } else if (!checkDraw(computerAction, playAction)) {
            computerResult++;
        }
    }

    private boolean checkDraw(int computerAction, int action) {
        return computerAction == action;
    }

    private boolean checkPlayerWin(int computerAction, int action) {
        return (action == SCISSORS && computerAction == PAPER)
                || (action == PAPER && computerAction == ROCK)
                || (action == ROCK && computerAction == SCISSORS);
    }

    private String convertConstantToName(Integer constant) {
        switch (constant) {
            case ROCK:
                return "Kamień";
            case PAPER:
                return "Papier";
            case SCISSORS:
                return "Nożyczki";
            default:
                throw new RuntimeException();
        }
    }
}
