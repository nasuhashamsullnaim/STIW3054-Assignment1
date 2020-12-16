package my.example;

import java.util.Scanner;

public class PosLajuDelivery {
    public static void main(String[] args) {

        class MyRunnable implements Runnable {

            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + "");

                    Thread.sleep(300);
                    System.out.println(Thread.currentThread().getName() + "");
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
            }
        }

        MyRunnable MR = new MyRunnable();

        Scanner sc = new Scanner(System.in);
        int i = 0;
        int x = 0;
        int c = 0;
        double zone = 0, weight = 0, type = 0, domestic, surcharge, charge = 0, sum = 0;
        char town;

        System.out.printf("%50s", "Welcome to Pos Laju Malaysia!");
        System.out.println("\n****************************************************************");

        System.out.print("\nHow many time you want to use : ");
        int size = sc.nextInt();
        int[] choice = new int[size];

        System.out.print("\n-> Enter 1 - Next Day Delivery" + "\n-> Enter 2 - Same Day Delivery");
        System.out.println("\n-> Enter 3 - Prepaid Box and Envelope" + "\n-> Enter 4 - Pos Ekpress");

        while (i < choice.length && choice[i] != -1) {

            System.out.print("\n\nPlease enter your choice : ");
            choice[i] = sc.nextInt();
            if (choice[i] < 1 && choice[i] > 4) {
                System.out.println("Invalid choice!");
            }
            if (choice[i] == -1) {
                System.out.print("Ops! You have pushed stop button");
                charge = 0;
            }

            if (choice[i] == 1) {
                System.out.print("Please enter zone (1 to 5) : ");
                zone = sc.nextDouble();
                if (zone == 1) {
                    System.out.print("Please enter weight in gram : ");
                    weight = sc.nextInt();
                    if (weight <= 500 && weight <= 2000) {
                        charge = 4.90;
                    } else if (weight > 500 && weight <= 2000) {
                        charge = 4.90 + 0.8 * ((weight - 500) / 250);
                    } else if (weight > 2000 && weight <= 2500) {
                        charge = 10.50;
                    } else if (weight > 2500) {
                        charge = 10.50 + 0.50 * ((weight - 2500) / 500);
                    }
                } else if (zone == 2) {
                    System.out.print("Please enter weight in gram : ");
                    weight = sc.nextInt();
                    if (weight <= 500 && weight <= 2000) {
                        charge = 5.40;
                    } else if (weight > 500 && weight <= 2000) {
                        charge = 5.40 + 1.00 * ((weight - 500) / 250);
                    } else if (weight > 2000 && weight <= 2500) {
                        charge = 16.00;
                    } else if (weight > 2500) {
                        charge = 16.00 + 2.00 * ((weight - 2500) / 500);
                    }
                } else if (zone == 3) {
                    System.out.print("Please enter weight in gram : ");
                    weight = sc.nextInt();
                    if (weight <= 500 && weight <= 2000) {
                        charge = 6.90;
                    } else if (weight > 500 && weight <= 2000) {
                        charge = 6.90 + 1.50 * ((weight - 500) / 250);
                    } else if (weight > 2000 && weight <= 2500) {
                        charge = 21.00;
                    } else if (weight > 2500) {
                        charge = 21.00 + 3.00 * ((weight - 2500) / 500);
                    }
                } else if (zone == 4) {
                    System.out.print("Please enter weight in gram : ");
                    weight = sc.nextInt();
                    if (weight <= 500 && weight <= 2000) {
                        charge = 7.40;
                    } else if (weight > 500 && weight <= 2000) {
                        charge = 7.40 + 1.50 * ((weight - 500) / 250);
                    } else if (weight > 2000 && weight <= 2500) {
                        charge = 26.00;
                    } else if (weight > 2500) {
                        charge = (26.00 + 3.50 * ((weight - 2500) / 500));
                    }
                } else if (zone == 5) {
                    System.out.print("Please enter weight in gram : ");
                    weight = sc.nextInt();
                    if (weight <= 500 && weight <= 2000) {
                        charge = 7.90;
                    } else if (weight > 500 && weight <= 2000) {
                        charge = 7.90 + 2.00 * ((weight - 500) / 250);
                    } else if (weight > 2000 && weight <= 2500) {
                        charge = 31.00;
                    } else if (weight > 2500) {
                        charge = 31.00 + 4.00 * ((weight - 2500) / 500);
                    }
                } else {
                    System.out.println("\nOps! Invalid zone!");

                }

                System.out.printf("\n%10s%15s%15s", "Zone", "Weight(g)", "Charge(RM) \n");
                System.out.printf("\n%8.0f%13.0f%16.2f \n", zone, weight, charge);
                Thread th1 = new Thread(MR, "Thread 1");
                Thread th2 = new Thread(MR, "Thread 2");
                Thread th3 = new Thread(MR, "Thread 3");
                Thread th4 = new Thread(MR, "Thread 4");

                try {
                    for (x = 0; x < 3; x++) {
                        try {
                            Thread.sleep(500);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        System.out.println("Thread 1A = " + x);
                    }
                    th1.join();
                } catch (InterruptedException ie) {

                    ie.printStackTrace();
                }
                for (x = 10; x < 13; x++) {
                    try {
                        Thread.sleep(500);
                        th4.join();

                    } catch (InterruptedException ie) {

                        ie.printStackTrace();
                    }
                    System.out.println("Thread 4A = " + x);
                }

                try {
                    for (x = 0; x < 3; x++) {
                        try {
                            Thread.sleep(500);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        System.out.println("Thread 3A = " + x);
                    }
                    th3.join(500);

                } catch (InterruptedException ie) {

                    ie.printStackTrace();
                }

                for (x = 10; x < 13; x++) {
                    try {
                        Thread.sleep(500);
                        th2.join();

                    } catch (InterruptedException ie) {

                        ie.printStackTrace();
                    }
                    System.out.println("Thread 2A = " + x);
                }

            }

            if (choice[i] == 2) {
                System.out.println("> Enter a for local town");
                System.out.println("> Enter b for cross town");
                System.out.print("Please enter your town : ");
                town = sc.next().charAt(0);
                System.out.print("Please enter the weight in gram : ");
                weight = sc.nextDouble();

                if (town == 'a') {
                    if (weight < 500) {
                        domestic = 4.90;
                        surcharge = 6.00;
                        charge = domestic + surcharge;
                    } else if (weight >= 500 && weight < 750) {
                        domestic = 5.70;
                        surcharge = 6.00;
                        charge = domestic + surcharge;
                    } else if (weight >= 750 && weight <= 1000) {
                        domestic = 6.50;
                        surcharge = 6.00;
                        charge = domestic + surcharge;
                    }

                } else if (town == 'b') {
                    if (weight <= 500) {
                        domestic = 5.40;
                        surcharge = 7.50;
                        charge = domestic + surcharge;
                    } else if (weight > 500 && weight <= 750) {
                        domestic = 6.40;
                        surcharge = 7.50;
                        charge = domestic + surcharge;
                    } else if (weight > 750 && weight <= 1000) {
                        domestic = 7.40;
                        surcharge = 7.50;
                        charge = domestic + surcharge;
                    }

                } else {
                    System.out.print("Ops! Invalid input!");
                    charge = 0.00;
                }
                System.out.printf("\n%10s%15s%15s", "Town", "Weight(g)", "Charge(RM) \n");
                System.out.printf("\n%8s%15.0f%15.2f \n", town, weight, charge);

                Thread th1 = new Thread(MR, "Thread 1");
                Thread th2 = new Thread(MR, "Thread 2");
                Thread th3 = new Thread(MR, "Thread 3");
                Thread th4 = new Thread(MR, "Thread 4");

                try {
                    for (x = 0; x < 3; x++) {
                        try {
                            Thread.sleep(500);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        System.out.println("Thread 1B = " + x);
                    }
                    th1.join();
                } catch (InterruptedException ie) {

                    ie.printStackTrace();
                }
                for (x = 10; x < 13; x++) {
                    try {
                        Thread.sleep(500);
                        th4.join();

                    } catch (InterruptedException ie) {

                        ie.printStackTrace();
                    }
                    System.out.println("Thread 4B = " + x);
                }

                try {
                    for (x = 0; x < 3; x++) {
                        try {
                            Thread.sleep(500);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        System.out.println("Thread 3B = " + x);
                    }
                    th3.join(500);

                } catch (InterruptedException ie) {

                    ie.printStackTrace();
                }

                for (x = 10; x < 13; x++) {
                    try {
                        Thread.sleep(500);
                        th2.join();

                    } catch (InterruptedException ie) {

                        ie.printStackTrace();
                    }
                    System.out.println("Thread 2B = " + x);
                }

            }

            if (choice[i] == 3) {
                System.out.println("> Enter 1 for Envelope S" + "\n> Enter 2 for Envelope L");
                System.out.println("> Enter 3 for Prepaid Box S" + "\n> Enter 4 for Prepaid Box M");
                System.out.println("> Enter 5 for Prepaid box L");

                System.out.print("\nPlease enter type of package : ");
                type = sc.nextInt();
                System.out.print("Please enter weight in gram : ");
                weight = sc.nextDouble();

                if (type == 1) {
                    if (weight == 500) {
                        charge = 7.31;
                    }
                } else if (type == 2) {
                    if (weight == 1000) {
                        charge = 10.49;
                    }
                } else if (type == 3) {
                    if (weight == 2000) {
                        charge = 13.78;
                    }
                } else if (type == 4) {
                    if (weight == 5000) {
                        charge = 21.20;
                    }
                } else if (type == 5) {
                    if (weight == 10000) {
                        charge = 31.80;
                    }
                } else {
                    System.out.print("Invalid");
                    charge = 0;
                }
                System.out.printf("\n%10s%15s%15s", "Type", "Weight(g)", "Charge(RM) \n");
                System.out.printf("\n%8.0f%13.0f%15.2f \n", type, weight, charge);

                Thread th1 = new Thread(MR, "Thread 1");
                Thread th2 = new Thread(MR, "Thread 2");
                Thread th3 = new Thread(MR, "Thread 3");
                Thread th4 = new Thread(MR, "Thread 4");

                try {
                    for (x = 0; x < 3; x++) {
                        try {
                            Thread.sleep(500);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        System.out.println("Thread 1C = " + x);
                    }
                    th1.join();
                } catch (InterruptedException ie) {

                    ie.printStackTrace();
                }
                for (x = 10; x < 13; x++) {
                    try {
                        Thread.sleep(500);
                        th4.join();

                    } catch (InterruptedException ie) {

                        ie.printStackTrace();
                    }
                    System.out.println("Thread 4C = " + x);
                }

                try {
                    for (x = 0; x < 3; x++) {
                        try {
                            Thread.sleep(500);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        System.out.println("Thread 3C = " + x);
                    }
                    th3.join(500);

                } catch (InterruptedException ie) {

                    ie.printStackTrace();
                }

                for (x = 10; x < 13; x++) {
                    try {
                        Thread.sleep(500);
                        th2.join();

                    } catch (InterruptedException ie) {

                        ie.printStackTrace();
                    }
                    System.out.println("Thread 2C = " + x);
                }
            }

            if (choice[i] == 4) {
                System.out.print("> Enter 1 for LG" + "\n> Enter 2 for LE(CS)");
                System.out.println("\n> Enter 3 for LD(B4)" + "\n> Enter 4 for LK");

                System.out.print("\nPlease enter type of document : ");
                type = sc.nextDouble();
                System.out.print("Please enter weight in gram : ");
                weight = sc.nextDouble();

                if (type == 1 && weight == 100) {
                    charge = 3.18;
                } else if (type == 2 && weight == 250) {
                    charge = 3.71;
                } else if (type == 3 && weight == 500) {
                    charge = 4.77;
                } else if (type == 4 && weight == 1000) {
                    charge = 7.42;
                } else {
                    System.out.print("Invalid");
                }
                System.out.printf("\n" + "%10s%15s%15s", "Type", "Weight(g)", "charge(RM) \n");
                System.out.printf("\n%8.0f%12.0f%16.2f \n", type, weight, charge);

                Thread th1 = new Thread(MR, "Thread 1");
                Thread th2 = new Thread(MR, "Thread 2");
                Thread th3 = new Thread(MR, "Thread 3");
                Thread th4 = new Thread(MR, "Thread 4");

                try {
                    for (x = 0; x < 3; x++) {
                        try {
                            Thread.sleep(500);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        System.out.println("Thread 1D = " + x);
                    }
                    th1.join();
                } catch (InterruptedException ie) {

                    ie.printStackTrace();
                }
                for (x = 10; x < 13; x++) {
                    try {
                        Thread.sleep(500);
                        th4.join();

                    } catch (InterruptedException ie) {

                        ie.printStackTrace();
                    }
                    System.out.println("Thread 4D = " + x);
                }

                try {
                    for (x = 0; x < 3; x++) {
                        try {
                            Thread.sleep(500);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        System.out.println("Thread 3D = " + x);
                    }
                    th3.join(500);

                } catch (InterruptedException ie) {

                    ie.printStackTrace();
                }

                for (x = 10; x < 13; x++) {
                    try {
                        Thread.sleep(500);
                        th2.join();

                    } catch (InterruptedException ie) {

                        ie.printStackTrace();
                    }
                    System.out.println("Thread 2D = " + x);
                }
            }


            c = c + choice[i];
            sum = sum + charge;
            i = i + 1;


            System.out.print("\n\nTotal Charge : RM " + sum);
            System.out.println("\n\n**********************************************************************************");
            System.out.printf("%50s", " Thank You! :) ");
        }
    }
}

