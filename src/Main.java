import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Elevator elevator = new Elevator();
        Buillding buillding = new Buillding();
//        InputNumbersLogic inputNumbersLogic = new InputNumbersLogic();

        buillding.setCountOfFloors();
        buillding.callElevator();
//        inputNumbersLogic.inputNumberOfFloor();

        while (true) {
            if (Elevator.temp != 100) {
                InputNumbersLogic inputNumbersLogic=new InputNumbersLogic();
                inputNumbersLogic.waitFourSeconds();
                elevator.wishedFloor= Elevator.temp;
                elevator.move();
//                elevator.currentFloor=elevator.wishedFloor;
//                if (buillding.isButtonPreset=true){
//                    elevator.askNumberOfWishedFloor();
//                }
            }
        }

//        while (true) {
//                if (elevator.temp != 100) {
////                InputNumbersLogic inputNumbersLogic1=new InputNumbersLogic();
//                elevator.waitForAnyUserAcrion();
//                elevator.move();
////                elevator.askNumberOfWishedFloor();
////                inputNumbersLogic1.waitFourSeconds();
//
//            }
//        }
    }
}

