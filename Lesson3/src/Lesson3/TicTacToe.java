package Lesson3;

        import java.util.Random;
        import java.util.Scanner;

public class TicTacToe {

    private static int fieldSizeY;
    private static int fieldSizeX;
    private static int winLength;
    private static char[][] field;

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final char HUMAN_DOT = 'X';
    private static final char AI_DOT = 'O';
    private static final char EMPTY_DOT = '.';

    private static void initMap() {
        System.out.println("Enter field size (ex. - \"3 3\")");
        fieldSizeY = SCANNER.nextInt();
        fieldSizeX = SCANNER.nextInt();
        field = new char[fieldSizeY][fieldSizeX];
        winLength = (fieldSizeY > 4 && fieldSizeY > 4) ? 4 : 3;
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = EMPTY_DOT;
            }
        }
    }

    private static void printMap() {
        System.out.println("-------");
        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print("|");
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }
    }

    private static void humanTurn() {
        int x;
        int y;
        do {
            y = SCANNER.nextInt() - 1;
            x = SCANNER.nextInt() - 1;
        } while (!(isValidCell(y, x) && isEmptyCell(y, x)));
        field[y][x] = HUMAN_DOT;
    }

    private static boolean isEmptyCell(int y, int x) {
        return field[y][x] == EMPTY_DOT;
    }

    private static boolean isValidCell(int y, int x) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    //Проверка на выигрыш-проигрыш на следующий ход
    //Возвращает кол-во ситуаций с выигрышем-проигрышем. Нужно для усложненного алгоритма.
    private static int aiTurnSimple(char c, int coords[]) {
        int retCount = 0;
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (!isEmptyCell(y, x)) continue;
                field[y][x] = c;
                if (checkWin(c)) {
                    if (coords != null) {
                        coords[0] = y;
                        coords[1] = x;
                    }
                    retCount++;
                }
                field[y][x] = EMPTY_DOT;
                }
            }
        return retCount;
        }

    //Создание-предотвращание ситуации с 2мя выигрышными вариантами на следующий ход,
    //Теоритически можно усложнять и дальше, но для этого надо предугадывать ходы соперника.
    //Я в общем уже не могу комп обыграть.
    private static int aiTurnComplex(char c, int[] coords) {
        int retCount = 0;
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (!isEmptyCell(y, x)) continue;
                field[y][x] = c;
                int simpleRet = aiTurnSimple(c, null);
                if (simpleRet >= 2) {
                    if (coords != null) {
                        coords[0] = y;
                        coords[1] = x;
                    }
                    retCount++;
                }
                field[y][x] = EMPTY_DOT;
            }
        }
        return retCount;
    }

    //Минус рандом. Стараемся ставить точку как можно ближе к центру.
    private static void aiMakeMove() {
        int x = fieldSizeX / 2;
        int y = fieldSizeY / 2;
        for (int i = 0; i < fieldSizeY * fieldSizeX; i++) {
            if (isEmptyCell(y, x)) break;
            y += i / 2;
            x += i % 2;
        }
        field[y][x] = AI_DOT;
    }

    private static void aiTurn() {
        int[] coords = {0, 0};
        if (isMapFull()) return;
        if (aiTurnSimple(AI_DOT, coords) > 0) {
            field[coords[0]][coords[1]] = AI_DOT;
            return;
        }
        if (aiTurnSimple(HUMAN_DOT, coords) > 0) {
            field[coords[0]][coords[1]] = AI_DOT;
            return;
        }
        if (aiTurnComplex(AI_DOT, coords) > 0) {
            field[coords[0]][coords[1]] = AI_DOT;
            return;
        }
        if (aiTurnComplex(HUMAN_DOT, coords) == 1) {
            field[coords[0]][coords[1]] = AI_DOT;
            return;
        }
        aiMakeMove();
    }

    private static boolean checkRow(char c, int y, int x) {
        if (x + winLength > fieldSizeX) return false;
        for (int i = 0; i < winLength; i++) {
            if (field[y][x + i] != c) return false;
        }
        return true;
    }

    private static boolean checkCol(char c, int y, int x) {
        if (y + winLength > fieldSizeY) return false;
        for (int i = 0; i < winLength; i++) {
            if (field[y + i][x] != c) return false;
        }
        return true;
    }

    private static boolean checkDiagLeft(char c, int y, int x) {
        if (x - winLength + 1 < 0 || y + winLength > fieldSizeY) return false;
        for (int i = 0; i < winLength; i++) {
            if (field[y + i][x - i] != c) return false;
        }
        return true;
    }

    private static boolean checkDiagRight(char c, int y, int x) {
        if (x + winLength > fieldSizeX || y + winLength > fieldSizeY) return false;
        for (int i = 0; i < winLength; i++) {
            if (field[y + i][x + i] != c) return false;
        }
        return true;
    }

    private static boolean checkWin(char c) {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] != c) continue;
                if (checkRow(c, y, x) == true) return true;
                if (checkCol(c, y, x) == true) return true;
                if (checkDiagLeft(c, y, x) == true) return true;
                if (checkDiagRight(c, y, x) == true) return true;
            }
        }
        return false;
    }

    private static boolean isMapFull() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isEmptyCell(y, x)) return false;
            }
        }
        return true;
    }

    private static boolean gameChecks(char dotType, String s) {
        if (checkWin(dotType)) {
            System.out.println(s);
            return true;
        }
        if (isMapFull()) {
            System.out.println("draw!");
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        while (true) {
            initMap();
            printMap();
            while (true) {
                humanTurn();
                printMap();
                if (gameChecks(HUMAN_DOT, "Human win!")) break;
                aiTurn();
                printMap();
                if (gameChecks(AI_DOT, "AI win!")) break;
            }
            System.out.println("y to play again");
            if (!SCANNER.next().equals("y"))
                break;
        }
        SCANNER.close();
    }
}

