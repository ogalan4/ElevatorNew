import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputNumbersLogic extends Thread {
    InputStreamReader ireader=new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(ireader);

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
        verificateTemp();
    }

    public void inputNumberOfFloor() {
        Elevator elevator = new Elevator();
                try {
            Elevator.temp = Integer.parseInt(reader.readLine());
            System.out.println(Elevator.temp);

        } catch (Exception e) {
            System.out.println("Only numeric values are allowed");
        }

        elevator.checkExit();
        elevator.checkCorrectNumber();
        elevator.checkSameNumber();

    }

    public void verificateTemp(){
       if (Elevator.verificationTemp==Elevator.temp){
            Elevator.temp=0;
            Elevator.verificationTemp=0;
           }else Elevator.verificationTemp=Elevator.temp;
            }
}

