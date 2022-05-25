public class Main {
    public static void main(String[] args) throws InterruptedException {
        Building building = new Building();
        MovingLogic movingLogic = new MovingLogic();

        building.setCountOfFloors();
        building.callElevator();
        movingLogic.moveUpByBuilding();
        while (true) {
            if (InputNumbersLogic.temp != 100) {
                InputNumbersLogic inputNumbersLogic=new InputNumbersLogic();
                inputNumbersLogic.waitFourSeconds();
                movingLogic.move();
            }
        }
      }
}

