package Kris.start.Money.step;

import java.util.Random;
import java.util.Scanner;
        public class Main {
            static final int SIZE = 3;
            static final char X_DOT = 'X';
            static final char O_DOT = 'O';
            static final char EMPTY = '.';
            static char[][] map;
            static final Scanner sc = new Scanner(System.in);
            static final Random rm = new Random();
            public static void main(String[] args) {
                inmap();
                printmap();
                while (true) {
                    humanturn();
                    printmap();
                    if (checkwin1()) {
                        System.out.println("Победа");
                        break;
                    }
                    if (full()) {
                        System.out.println("Ничья");
                        break;
                    }

                    robotturn();
                    printmap();
                    if (checkwin1()) {
                        System.out.println("Победа Роботов");
                        break;
                    }
                    if (full()) {
                        System.out.println("Ничья");
                        break;
                    }
                }
            }


            public static void humanturn() {
                int y;
                int x;
                do {
                    System.out.println("Введи координаты, X и Y");
                    x = sc.nextInt() - 1;
                    y = sc.nextInt() - 1;
                } while (!valid(y, x));
                map[y][x] = X_DOT;
            }


            public static void robotturn() {
                int y;
                int x;
                do {
                    y = rm.nextInt(SIZE);
                    x = rm.nextInt(SIZE);
                } while (!valid(y, x));
                map[y][x] = O_DOT;
            }


            public static boolean valid(int y, int x) {
                if (y < 0 || x < 0 || y >= SIZE || x >= SIZE) {
                    return false;
                }
                return map[y][x] == EMPTY;
            }

            public static void inmap() {
                map = new char[SIZE][SIZE];
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        map[i][j] = EMPTY;

                    }

                }
            }

            public static void printmap() {
                System.out.print("  ");
                for (int i = 0; i < SIZE; i++) {
                    System.out.printf("%d ", i + 1);
                }
                System.out.println();
                for (int i = 0; i < SIZE; i++) {
                    System.out.printf("%d ", i + 1);
                    for (int j = 0; j < SIZE; j++) {
                        System.out.printf("%c ", map[i][j]);
                    }
                    System.out.println();
                }
            }

            public static boolean full() {
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if (map[i][j] == EMPTY) {
                            return false;
                        }

                    }

                }
                return true;
            }

            public static boolean checkwin1() {
                for (int i = 0; i < SIZE; i++) {
                    if (map[0][i]== map[1][i]&&map[1][i]==map[2][i]&& map[0][i]!=EMPTY){
                        return true;
                    }if (map[i][0]== map[i][1]&&map[i][1]==map[i][2]&& map[i][0]!=EMPTY){
                        return true;
                    }
                    if (map[0][2]== map[1][1]&&map[1][1]==map[2][0]&& map[0][2]!=EMPTY) {
                        return true;
                    }if (map[0][0]== map[1][1]&&map[1][1]==map[2][2]&& map[0][0]!=EMPTY){
                        return true;
                    }
                }
                return false;
            }
        }



