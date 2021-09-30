import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Buillding {
    public static int countOfFloors;
    public static int numberOfWishedFloor;
    public boolean isWelcomeByLogic = false;

    public void setCountOfFloors() {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("|  Input the count of floors, which you want to have in the Buillding      |");
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
    }

    public void somebodyCallElevator() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("|  If somebody else want to call elevator on some floor, input the appropriated number, please  |");
        System.out.println("|  If you want to quit the program, input 100                                                   |");
        System.out.println("-------------------------------------------------------------------------------------------------");
    }

    public void welcomeONFloorByDyrection() {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("|  Doors are open                                                          |");
        System.out.println("|  Welcome on the " + numberOfWishedFloor + " floor                                                  |");
        System.out.println("|  Doors are closed                                                        |");
        System.out.println("----------------------------------------------------------------------------");
        numberOfWishedFloor = 0;
        isWelcomeByLogic = true;
    }
}
