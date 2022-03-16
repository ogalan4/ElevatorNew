public class MovingLogic {
    Building building = new Building();
    Elevator elevator = new Elevator();

    public void move() throws InterruptedException {
        crossDirectionMoving();
        if (Elevator.currentFloor < Elevator.wishedFloor && Elevator.wishedFloor != 0) {
            moveUp();
        } else if (Elevator.currentFloor > Elevator.wishedFloor && Elevator.wishedFloor != 0) {
            moveDown();
        }
        elevator.waitUntilSomeAction();
    }

    public void crossDirectionMoving() {
        Elevator.wishedFloor = InputNumbersLogic.temp;
        if (Building.numberOfWishedFloor < Elevator.currentFloor && Elevator.currentFloor < Elevator.wishedFloor || Building.numberOfWishedFloor > Elevator.currentFloor && Elevator.currentFloor > Elevator.wishedFloor) {
            Elevator.wishedFloor = Building.numberOfWishedFloor;
            Building.numberOfWishedFloor = InputNumbersLogic.temp;
        }
    }

    public void moveUp() throws InterruptedException {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("|  The elevator is moving up                                               |");
        System.out.println("----------------------------------------------------------------------------");
        Thread.sleep(2000);
        for (int i = Elevator.currentFloor; i < Elevator.wishedFloor; i++) {
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("|  Elevator is moving through " + i + " floor                                      |");
            System.out.println("----------------------------------------------------------------------------");
            Thread.sleep(2000);
            somebodyElseLogic();
            compareGoalsUp();
            checkFloorByDirection(i);

        }
        Elevator.currentFloor = Elevator.wishedFloor;
    }

    public void somebodyElseLogic() {
        if (!building.isButtonPreset) {
            InputNumbersLogic inputNumbersLogic = new InputNumbersLogic();
            building.somebodyCallElevator();
            inputNumbersLogic.waitFourSeconds();
            Building.numberOfWishedFloor = InputNumbersLogic.temp;
            building.isButtonPreset = true;
        }
    }

    public void compareGoalsUp() {
        if (Building.numberOfWishedFloor > Elevator.wishedFloor && Elevator.wishedFloor != 0) {
            InputNumbersLogic.temp = Elevator.wishedFloor;
            Elevator.wishedFloor = Building.numberOfWishedFloor;
            Building.numberOfWishedFloor = InputNumbersLogic.temp;
            InputNumbersLogic.temp = Elevator.wishedFloor;
        }
    }

    public void compareGoalsDown() {
        if (Building.numberOfWishedFloor < Elevator.wishedFloor && Elevator.wishedFloor != 0) {
            InputNumbersLogic.temp = Elevator.wishedFloor;
            Elevator.wishedFloor = Building.numberOfWishedFloor;
            Building.numberOfWishedFloor = InputNumbersLogic.temp;
            InputNumbersLogic.temp = Elevator.wishedFloor;
        }
    }

    public void checkFloorByDirection(int i) throws InterruptedException {
        InputNumbersLogic inputNumbersLogic = new InputNumbersLogic();
        if (Elevator.currentFloor < Elevator.wishedFloor) {
            if ((i + 1) == Building.numberOfWishedFloor) {
                Elevator.currentFloor = (i + 1);
                elevator.welcomeOnFloor();
                elevator.askNumberOfWishedFloor();
                inputNumbersLogic.waitFourSeconds();
                Building.numberOfWishedFloor = InputNumbersLogic.temp;
                building.isButtonPreset = true;
            }
        } else if (Elevator.currentFloor > Elevator.wishedFloor) {
            if ((i - 1) == Building.numberOfWishedFloor) {
                Elevator.currentFloor = (i - 1);
                elevator.welcomeOnFloor();
                elevator.askNumberOfWishedFloor();
                inputNumbersLogic.waitFourSeconds();
                Building.numberOfWishedFloor = InputNumbersLogic.temp;
                building.isButtonPreset = true;
            }
        }
    }

    public void moveDown() throws InterruptedException {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("|  The elevator is moving down                                               |");
        System.out.println("----------------------------------------------------------------------------");
        Thread.sleep(2000);
        for (int i = Elevator.currentFloor; i > Elevator.wishedFloor; i--) {
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("|  Elevator is moving through " + i + " floor                                      |");
            System.out.println("----------------------------------------------------------------------------");
            Thread.sleep(2000);
            somebodyElseLogic();
            compareGoalsDown();
            checkFloorByDirection(i);
        }
        Elevator.currentFloor = Elevator.wishedFloor;
    }

    public void moveUpByBuilding() throws InterruptedException {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("|  The elevator is moving up                                               |");
        System.out.println("----------------------------------------------------------------------------");
        Thread.sleep(2000);
        for (int i = Elevator.currentFloor; i <= Building.numberOfWishedFloor; i++) {
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("|  Elevator is moving through " + i + " floor                                      |");
            System.out.println("----------------------------------------------------------------------------");
            Thread.sleep(2000);
            }
        Elevator.currentFloor = Building.numberOfWishedFloor;
        elevator.welcomeOnFloor();
        elevator.askNumberOfWishedFloor();
    }
}
