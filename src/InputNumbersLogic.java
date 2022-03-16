import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputNumbersLogic extends Thread {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Elevator elevator = new Elevator();
    Building building = new Building();
    public static int temp;

    public void run() {
        inputNumberOfFloor();
    }

    public void waitFourSeconds() {
        start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkExit();
        checkCorrectNumber();
        checkSameNumber();
    }

    public void inputNumberOfFloor() {
        try {
            temp = Integer.parseInt(reader.readLine());
            System.out.println(temp);
        } catch (Exception e) {
            System.out.println("Only numeric values are allowed");
        }
    }

    public void checkCorrectNumber() {
        InputNumbersLogic inputNumbersLogic = new InputNumbersLogic();
        if (temp < 1 || temp > Building.countOfFloors) {
            System.out.println("The number should be between 1 and " + Building.countOfFloors);
            temp = 0;
            ascRetryInputLogic();
            inputNumbersLogic.waitFourSeconds();
        }
    }

    public void ascRetryInputLogic() {
        if (Building.numberOfWishedFloor == 0) {
            building.callElevator();
        } else {
            elevator.askNumberOfWishedFloor();
        }
    }

    public void checkExit() {
        if (temp == 100) {
            System.exit(0);
        }
    }

    public void checkSameNumber() {
        InputNumbersLogic inputNumbersLogic = new InputNumbersLogic();
        if (Elevator.currentFloor == temp) {
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("|          You already are on " + Elevator.currentFloor + " floor                       |");
            System.out.println("|          Try again, please                                               |");
            System.out.println("----------------------------------------------------------------------------");
            inputNumbersLogic.waitFourSeconds();
        }
    }
}

