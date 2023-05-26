/*На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. И вывести Доску. Пример вывода доски 8x8*/

import javax.lang.model.util.ElementScanner14;

public class task3 {
    private static final int BOARD_SIZE = 10;
    private static final char QUEEN = '\u265B';

    private char[][] board;

    public task3() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        initializeBoard();
        fillLabels();
        fillBoard();
    }

    public void solve() {
        if (placeQueens(1)) {//был параметр 0
            displayBoard();
        } else {
            System.out.println("Невозможно найти решение.");
        }
    }

    private boolean placeQueens(int col) {
        if (col >= BOARD_SIZE-1) {
            return true; // Все ферзи размещены
        }

        for (int row = 1; row < BOARD_SIZE-1; row++) {
            if (isSafe(row, col)) {
                board[row][col] = QUEEN;

                if (placeQueens(col + 1)) {
                    return true; // Рекурсивный вызов для следующего столбца
                }
                board[row][col] = ((row + col) % 2 == 0) ? '\u25A1' : '\u25A0';// Откат, если не найдено решение
                
            }
        }

        return false; // Невозможно разместить ферзей в текущем столбце
    }

    private boolean isSafe(int row, int col) {
        // Проверка горизонтальной линии
        for (int i = 1; i < col; i++) {
            if (board[row][i] == QUEEN) {
                return false;
            }
        }

        // Проверка диагонали (левая верхняя)
        for (int i = row, j = col; i >= 1 && j >= 1; i--, j--) {
            if (board[i][j] == QUEEN) {
                return false;
            }
        }

        // Проверка диагонали (левая нижняя)
        for (int i = row, j = col; i < BOARD_SIZE-1 && j >= 1; i++, j--) {
            if (board[i][j] == QUEEN) {
                return false;
            }
        }

        return true;
    }

    private void initializeBoard() {
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                board[row][col] = ' ';
            }
        }
    }

    private void fillLabels() {
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        int number = 8;

        for (int col = 1; col <= 8; col++) {
            board[0][col] = letters[col - 1];
            board[9][col] = letters[col - 1];
            board[col][0] = (char) (number + '0');
            board[col][9] = (char) (number + '0');
            number--;
        }
    }

    private void fillBoard() {
        for (int row = 1; row <= 8; row++) {
            for (int col = 1; col <= 8; col++) {
                board[row][col] = ((row + col) % 2 == 0) ? '\u25A1' : '\u25A0';
            }
        }
    }

    private void displayBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if(board[i][j] == '\u265B') 
                System.out.print("\u001B[33m" + board[i][j] + "\u001B[0m" + " ");
                else
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //Очистка консоли
        clearScreen();
        task3 problem = new task3();
        problem.solve();
        System.out.println("\n\n\n");
    }