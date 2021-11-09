
public class Main {
    public static void main(String[] args) {
        Elevator elevator = new Elevator();
        Buillding buillding = new Buillding();

        buillding.setCountOfFloors();
        buillding.callElevator();

        while (true) {
            if (Elevator.temp != 100) {
                InputNumbersLogic inputNumbersLogic=new InputNumbersLogic();
                inputNumbersLogic.waitFourSeconds();
                elevator.wishedFloor= Elevator.temp;
                elevator.move();
            }
        }
    }
}

