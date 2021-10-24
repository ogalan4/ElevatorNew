import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputNumbersLogic extends Thread {

    public void run() {
        inputNumberOfFloor();
    }

    public void waitFourSeconds() {
        start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void inputNumberOfFloor() {
        Elevator elevator = new Elevator();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            Elevator.temp = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            System.out.println("Only numeric values are allowed");
        }

        elevator.checkExit();
        elevator.checkCorrectNumber();
        elevator.checkSameNumber();
    }
}

