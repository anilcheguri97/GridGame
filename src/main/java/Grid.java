import java.util.Arrays;
import java.util.Scanner;

public class Grid {
    public static void printGrid(int a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws TossMatchException {
        int[][] a = new int[10][10];
        for (int[] ints : a) {
            Arrays.fill(ints, 0);
        }
        printGrid(a);

        boolean player1 = true;
        int player1_1 = 0;
        int player1_2 = 0;
        int player2_1 = 0;
        int player2_2 = 0;
        boolean play=true;
        while(play) {
            if (player1) {
                System.out.println("player 1 please place your piece");
                Scanner sc = new Scanner(System.in);
                System.out.println("please enter the number between 0-9");

                player1_1 = sc.nextInt();
                player1_2 = sc.nextInt();
                if (tossMatch(player1_1, player1_2, player2_1, player2_2)) {
                    a[player1_1][player1_2] = 1;
                    player1 = false;
                } else {
                    play=false;
                    throw new TossMatchException();
                }
            }
            if (!player1) {
                System.out.println("player 2 please place your piece");
                Scanner sc = new Scanner(System.in);
                System.out.println("please enter the number between 0-9");
                player2_1 = sc.nextInt();
                player2_2 = sc.nextInt();
                if (tossMatch(player1_1, player1_2, player2_1, player2_2)) {
                    a[player2_1][player2_2] = 2;
                    player1 = true;
                } else {
                    play = false;
                    throw new TossMatchException();
                }
            }
        }

        printGrid(a);
    }

    private static boolean tossMatch(int player1_1, int player1_2, int player2_1, int player2_2) {
        if (player1_1 == player2_1 && player1_2 != player2_2) {
            return true;
        } else if (player1_1 != player2_1 && player1_2 == player2_2) {
            return true;
        }
        else if (player1_1 != player2_1 && player1_2 != player2_2)
        {
            return true;
        }
        return false;
    }
}
