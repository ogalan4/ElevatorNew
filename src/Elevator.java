import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.PortUnreachableException;

public class Elevator extends Thread {
    public int currentFloor = 1;
    public int wishedFloor = 1;
    public static int temp;

    Buillding buillding = new Buillding();


    public void waitForAnyUserAcrion() {
        if (wishedFloor == 0 && Buillding.numberOfWishedFloor == 0) {
            waitUntilUserInputNumber();
        }
    }

    public void move() {
        wishedFloor = temp;
        if (currentFloor < wishedFloor && wishedFloor != 0) {
            moveUp();
        } else if (currentFloor > wishedFloor && wishedFloor != 0) {
            moveDown();
        }
//        currentFloor = wishedFloor;
//        wishedFloor = 0;
    }

    public void waitUntilUserInputNumber() {
        InputNumbersLogic inputNumbersLogic = new InputNumbersLogic();
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|  The elevator is not moving right nov                                      |");
        System.out.println("|  Nobody asks the elevator on some floor and nobody wants to get somewhere  |");
        System.out.println("------------------------------------------------------------------------------");
        buillding.callElevator();
        inputNumbersLogic.inputNumberOfFloor();
        move();
    }

    public void moveUp() {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("|  The elevator is moving up                                               |");
        System.out.println("----------------------------------------------------------------------------");
        for (int i = currentFloor; i < wishedFloor; i++) {
            welcomeOnFloorBDLogicUp(i);
            if (Buillding.numberOfWishedFloor == 0) {
                askSomebodyCallElevator();
            }
        }
        if (buillding.isWelcomeByLogic == false) {
            actionByElevatorGet();
            compareGoalsUp();
        }
    }

    public void moveDown() {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("|  The elevator is moving down                                             |");
        System.out.println("----------------------------------------------------------------------------");
        for (int i = currentFloor; i > wishedFloor; i--) {
            welcomeOnFloorBDLogicDown(i);
            if (Buillding.numberOfWishedFloor == 0) {
                askSomebodyCallElevator();
            }
        }
        if (buillding.isWelcomeByLogic == false) {
            actionByElevatorGet();
            compareGoalsDown();
        }
    }

    public void actionByElevatorGet() {
        InputNumbersLogic inputNumbersLogic = new InputNumbersLogic();
        welcomeOnFloor();
        currentFloor = wishedFloor;
        askNumberOfWishedFloor();
        inputNumbersLogic.waitFourSeconds();
        wishedFloor=temp;
    }

    public void welcomeOnFloorBDLogicUp(int i) {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("|  Elevator is moving through " + i + " floor                                      |");
        System.out.println("----------------------------------------------------------------------------");
        if ((i + 1) == Buillding.numberOfWishedFloor && Buillding.numberOfWishedFloor != 0) {
            buillding.welcomeONFloorByDyrection();
        }
    }

    public void welcomeOnFloorBDLogicDown(int i) {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("|  Elevator is moving through " + i + " floor                                      |");
        System.out.println("----------------------------------------------------------------------------");
        if ((i - 1) == Buillding.numberOfWishedFloor && Buillding.numberOfWishedFloor != 0) {
            buillding.welcomeONFloorByDyrection();
        }
    }

    public void compareGoalsUp() {
        if (currentFloor<wishedFloor&&wishedFloor < Buillding.numberOfWishedFloor) {
            wishedFloor = Buillding.numberOfWishedFloor;
            moveUp();
        }
    }

    public void compareGoalsDown() {
        if ((currentFloor>wishedFloor&&wishedFloor > Buillding.numberOfWishedFloor)||(wishedFloor==0&&currentFloor>Buillding.numberOfWishedFloor)) {
            wishedFloor = Buillding.numberOfWishedFloor;
            moveDown();
        }
    }

    public void askSomebodyCallElevator() {
        InputNumbersLogic inputNumbersLogic = new InputNumbersLogic();
        if (Buillding.numberOfWishedFloor == 0) {
            buillding.somebodyCallElevator();
            inputNumbersLogic.waitFourSeconds();
            Buillding.numberOfWishedFloor = temp;
            temp = 0;
            if (Buillding.numberOfWishedFloor != 0) {
                buillding.isWelcomeByLogic = false;
            }
        }
    }

    public void askNumberOfWishedFloor() {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("|  Input the number of floor, which you want to get, please                |");
        System.out.println("|  If you want to quit the program, input 100                              |");
        System.out.println("----------------------------------------------------------------------------");
    }

    public void welcomeOnFloor() {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("|  Doors are open                                                          |");
        System.out.println("|  Welcome on the " + wishedFloor + " floor                                                  |");
        System.out.println("|  Doors are closed                                                        |");
        System.out.println("----------------------------------------------------------------------------");
    }

    public void checkCorrectNumber() {
        InputNumbersLogic inputNumbersLogic = new InputNumbersLogic();
        if (temp < 0 || temp > Buillding.countOfFloors) {
            System.out.println("The number should be between 1 and " + Buillding.countOfFloors);
            temp = 0;
            ascRetryInputLogic();
            inputNumbersLogic.waitFourSeconds();
        }
    }

    public void ascRetryInputLogic() {
        if (Buillding.numberOfWishedFloor == 0) {
            buillding.callElevator();
        } else {
            askNumberOfWishedFloor();
        }
    }

    public void checkExit() {
        if (temp == 100) {
            System.exit(0);
        }
    }
}
