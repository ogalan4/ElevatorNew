
public class Elevator {
    public static int currentFloor = 1;
    public static int wishedFloor = 0;

    public void waitUntilSomeAction() throws InterruptedException {
        if (wishedFloor == 0) {
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("|  The elevator is not moving now                                          |");
            System.out.println("|  And nobody wants to get elevator on some floor                          |");
            System.out.println("|  Input the number of floor, where you want to get elevator, please       |");
            System.out.println("|  If you want to quit the program, input 100                              |");
            System.out.println("----------------------------------------------------------------------------");
        } else {
            welcomeOnFloor();
            askNumberOfWishedFloor();
        }
    }

    public void askNumberOfWishedFloor() {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("|  Input the number of floor, which you want to get, please                |");
        System.out.println("|  If you want to quit the program, input 100                              |");
        System.out.println("----------------------------------------------------------------------------");
    }

    public void welcomeOnFloor() throws InterruptedException {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("|  Doors are open                                                          |");
        System.out.println("|  Welcome on the " + currentFloor + " floor                                                  |");
        System.out.println("|  Doors are closed                                                        |");
        System.out.println("----------------------------------------------------------------------------");
        Thread.sleep(2000);
    }
}
