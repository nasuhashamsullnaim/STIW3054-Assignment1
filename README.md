## Student Info:
#### 1. Matric Number : 259265
#### 2. Name          : Nasuha binti Shamsull Naim

## Introduction :
This system is for pos laju delivery. It will make user choose type of delivery, type of package, input the weight of parcel and it will automatically calculate for the payment for user. Next, we implement a runnable and add 4 thread in each type of delivery for 5 seconds.


## Example of outputs : 

<img src="https://github.com/STIW3054-A192/stiw3054-assignment1-nasuhashamsullnaim/blob/master/images/assignment%201%20(output%201).png" width="500"/>
<img src="https://github.com/STIW3054-A192/stiw3054-assignment1-nasuhashamsullnaim/blob/master/images/assignment%201%20(output%202).png" width="500" />
<img src="https://github.com/STIW3054-A192/stiw3054-assignment1-nasuhashamsullnaim/blob/master/images/assignment%201%20(output%203).png" width="500"/>
<img src="https://github.com/STIW3054-A192/stiw3054-assignment1-nasuhashamsullnaim/blob/master/images/assignment%201%20(output%204).png" width="500"/>


### UML Diagram :

<img src="https://github.com/STIW3054-A192/stiw3054-assignment1-nasuhashamsullnaim/blob/master/images/assignment%201%20UML%20Diagram.png" width="500"/>


## Examples of your program  
```java
1. IMPLEMENT RUNNABLE

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
           
    
    2. CREATING THREAD
           
           Thread th1 = new Thread(MR, "Thread 1");
                    Thread th2 = new Thread(MR, "Thread 2");
                    Thread th3 = new Thread(MR, "Thread 3");
                    Thread th4 = new Thread(MR, "Thread 4");
                    
                    
   3. IMPLEMENT THREAD SLEEP
   
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
                    
                    
     4. DISPLAY THREAD NAME
               public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + "");

                        Thread.sleep(300);
                        System.out.println(Thread.currentThread().getName() + "");
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                }
