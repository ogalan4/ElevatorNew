
public class Elevator extends Thread {
    public int currentFloor = 1;
    public int wishedFloor = 0;
    public static int temp;
    public static int verificationTemp;
    Buillding buillding = new Buillding();

    public void move() {
        if (currentFloor < wishedFloor && wishedFloor != 0) {
            moveUp();
        } else if (currentFloor > wishedFloor && wishedFloor != 0) {
            moveDown();
        }
        waitUntilSomeAction();
     }

    public void waitUntilSomeAction(){
        if (wishedFloor == 0) {
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("|  The elevator is not moving now                                          |");
            System.out.println("|  And nobody wants to get elevator on some floor                          |");
            System.out.println("|  Input the number of floor, where you want to get elevator, please       |");
            System.out.println("|  If you want to quit the program, input 100                              |");
            System.out.println("----------------------------------------------------------------------------");

        }
        else welcomeOnFloor();
    }

    public void moveUp() {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("|  The elevator is moving up                                               |");
        System.out.println("----------------------------------------------------------------------------");
        for (int i = currentFloor; i < wishedFloor; i++) {
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("|  Elevator is moving through " + i + " floor                                      |");
            System.out.println("----------------------------------------------------------------------------");
            somebodyElseLogic();
            compareGoalsUp();
            checkFloorByDirection(i);

        }
        currentFloor = wishedFloor;
        wishedFloor=0;
    }

    public void somebodyElseLogic() {
        while (true) {
            if (buillding.isButtonPreset == false) {
                InputNumbersLogic inputNumbersLogic = new InputNumbersLogic();
                buillding.somebodyCallElevator();
                inputNumbersLogic.waitFourSeconds();
                Buillding.numberOfWishedFloor = temp;
                buillding.isButtonPreset = true;
            }
            break;
        }
    }

    public void compareGoalsUp() {
        if (Buillding.numberOfWishedFloor > wishedFloor && wishedFloor != 0) {
            temp = wishedFloor;
            wishedFloor = Buillding.numberOfWishedFloor;
            Buillding.numberOfWishedFloor = temp;
            temp = wishedFloor;
        }
    }

    public void compareGoalsDown() {
        if (Buillding.numberOfWishedFloor < wishedFloor && wishedFloor != 0) {
            temp = wishedFloor;
            wishedFloor = Buillding.numberOfWishedFloor;
            Buillding.numberOfWishedFloor = temp;
            temp = wishedFloor;
        }
    }

    public void checkFloorByDirection(int i) {
        InputNumbersLogic inputNumbersLogic = new InputNumbersLogic();
        if (currentFloor < wishedFloor) {
            if ((i + 1) == Buillding.numberOfWishedFloor) {
                currentFloor = (i + 1);
                welcomeOnFloor();
                askNumberOfWishedFloor();
                inputNumbersLogic.waitFourSeconds();
                Buillding.numberOfWishedFloor = temp;
                buillding.isButtonPreset = true;
            }
        } else if (currentFloor > wishedFloor) {
            if ((i - 1) == Buillding.numberOfWishedFloor) {
                currentFloor = (i + 1);
                welcomeOnFloor();
                askNumberOfWishedFloor();
                inputNumbersLogic.waitFourSeconds();
                Buillding.numberOfWishedFloor = temp;
                buillding.isButtonPreset = true;
            }
        }
    }

    public void moveDown() {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("|  The elevator is moving up                                               |");
        System.out.println("----------------------------------------------------------------------------");
        for (int i = currentFloor; i > wishedFloor; i--) {
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("|  Elevator is moving through " + i + " floor                                      |");
            System.out.println("----------------------------------------------------------------------------");
            somebodyElseLogic();
            compareGoalsDown();
            checkFloorByDirection(i);
        }
        currentFloor = wishedFloor;
        wishedFloor=0;
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
        System.out.println("|  Welcome on the " + currentFloor + " floor                                                  |");
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

    public void checkSameNumber() {
        InputNumbersLogic inputNumbersLogic = new InputNumbersLogic();
        if (currentFloor == temp) {
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("|          You already are on " + currentFloor + " floor                       |");
            System.out.println("|          Try again, please                                               |");
            System.out.println("----------------------------------------------------------------------------");
            inputNumbersLogic.waitFourSeconds();
            }
    }
}
