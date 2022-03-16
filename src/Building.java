import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Building {
    public static int countOfFloors;
    public static int numberOfWishedFloor;
    public boolean isButtonPreset = false;

    public void setCountOfFloors() {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("|  Input the count of floors, which you want to have in the Building      |");
        System.out.println("----------------------------------------------------------------------------");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            countOfFloors = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            System.out.println("Only numeric values are allowed");
        }
    }

    public void callElevator() {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("|  Input the number of floor, where you want to get elevator, please       |");
        System.out.println("|  If you want to quit the program, input 100                              |");
        System.out.println("----------------------------------------------------------------------------");
        isButtonPreset = true;

        InputNumbersLogic inputNumbersLogic = new InputNumbersLogic();
        inputNumbersLogic.waitFourSeconds();
        numberOfWishedFloor= InputNumbersLogic.temp;
    }

    public void somebodyCallElevator() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("|  If somebody else want to call elevator on some floor, input the appropriated number, please  |");
        System.out.println("|  If you want to quit the program, input 100                                                   |");
        System.out.println("-------------------------------------------------------------------------------------------------");
    }
}
