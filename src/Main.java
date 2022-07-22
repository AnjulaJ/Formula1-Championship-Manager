import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class Main  {

    final static Scanner user_input = new Scanner(System.in);
    static ChampionshipManager formula = (ChampionshipManager) new Formula1ChampionshipManager();
    public static void main(String[] args) throws IOException {

        System.out.println(" ------- Formula 1 championship. -------  ");
        recover_data();
        randomRace();
        randomRace();
        randomRace();
        randomRace();
        gui();

        menu:
        while(true){
            System.out.println("MENU :");
            System.out.println("Enter \"1\" to Create a new driver.");
            System.out.println("Enter \"2\" to Delete a driver.");
            System.out.println("Enter \"3\" to Change the driver for an existing constructor team.");
            System.out.println("Enter \"4\" to Display the various statistics of a existing driver");
            System.out.println("Enter \"5\" to Display the Formula 1 Driver Table.");
            System.out.println("Enter \"6\" to add a Race.");
            System.out.println("Enter \"7\" to save data.");
            System.out.println("Enter \"8\" to Generate a Random Race");
            System.out.println("Enter \"9\" to open the GUI.");
            System.out.println("Enter \"0\" to exit");
            System.out.println("");

            System.out.print("Enter your option : ");
            Scanner input = new Scanner(System.in);
            int user_option = input.nextInt();


            switch (user_option) {
                case 1:
                    enter_a_new_driver();
                    break;
                case 2:
                    delete_a_driver();
                    break;
                case 3:
                    change_a_driver();
                    break;
                case 4:
                    statistics_of_a_driver();
                    break;
                case 5:
                    display_driver_table();
                    break;
                case 6:
                    add_Race();
                    break;
                case 7:
                    save_data();
                    break;
                case 8:
                    randomRace();
                    break;
                case 9:
                    gui();
                    break;
                case 0:
                    System.out.println("Exit");
                    break menu;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }

    private static void enter_a_new_driver() {

        Formula1Driver formula_add;
        System.out.println("------------------------");
        System.out.println("  A D D   A   D R I V E R  ");
        System.out.println("------------------------");

        int team_ID = formula.checkRandom();

        System.out.println("Enter the name of the Driver : ");
        String driver_name = user_input.nextLine();

        System.out.println("Enter the location of Driver: ");
        String driver_location = user_input.nextLine();

        System.out.println("Enter team name : ");
        String team_name = user_input.nextLine();

        formula_add=new Formula1Driver(driver_name,driver_location,team_name,team_ID);

        formula.add_driver(team_name,formula_add);

    }
    private static void delete_a_driver(){
        Formula1ChampionshipManager formula =new Formula1ChampionshipManager();
        System.out.println("-----------------------------");
        System.out.println("  D E L E T E   A   D R I V E R  ");
        System.out.println("-----------------------------");
        int num=0;
        while (num==0){
            try{
                System.out.print("Enter team id to delete : ");
                int id = user_input.nextInt();

                System.out.println("Warning! You have choose to delete the team id " + id + ". Enter  Y to continue or N to cancel");
                String choice = user_input.next().toLowerCase();
                if(choice.equalsIgnoreCase("y")) {
                    formula.delete_driver(id);
                    System.out.println("---------------------");
                    num=1;
                }
                else if(choice.equalsIgnoreCase("n")) {
                    System.out.println("*** cancelled deleting "+id+" **");
                    System.out.println("---------------------");
                    num=1;
                }
            }
            catch (Exception e){
                System.out.println("Invalid input. Please try again !");
                System.out.println("");
            }
        }



    }

    private static void change_a_driver(){
        System.out.println(".............Change Driver............");
        System.out.println("");
        System.out.println("Enter team name: ");
        String team_name = user_input.next().toLowerCase();
        System.out.println("Enter driver name to change: ");
        String driver_name = user_input.next().toLowerCase();
        formula.change_driver(team_name,driver_name);
    }

    private static void statistics_of_a_driver(){
        System.out.println("Enter driver name : ");
        String driver_name = user_input.next().toLowerCase();
        formula.display_statistics(driver_name);
    }

    private static void display_driver_table(){
        formula.Display_table();
    }


    private static void add_Race(){

        System.out.println("*** U P D A T E  S T A T I S T I C S ****");
        System.out.println("");

        int num=0;
        while(num==0) {
            try {
                System.out.print("Enter Day : ");
                int day = user_input.nextInt();
                if (day >= 1 && day <= 31) {
                    System.out.print("Enter month : ");
                    int month = user_input.nextInt();
                    if (month >= 1 && month <= 12) {
                        System.out.print("Enter year : ");
                        int year = user_input.nextInt();
                        String race_date=day+"/"+month+"/"+year;
                        formula.updateScore(race_date);

                    }
                    else {
                        System.out.println("invalid month");
                    }
                } else {
                    System.out.println("Day is invalid");
                } num=1;
            } catch (Exception e) {
                System.out.println("Invalid input");
                num=1;
            }
        }

    }

    private static void save_data() throws IOException {
        formula.save_to_file(Formula1ChampionshipManager.formula1);
    }

    private static void recover_data(){
        formula.load_data();
    }

    private static void gui(){
        formula.Gui();
    }

    private static void randomRace(){
        formula.generate_randomRace();
    }

}
