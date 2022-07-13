import java.io.*;
import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Formula1ChampionshipManager  implements ChampionshipManager {
    public static ArrayList<Formula1Driver> formula1 = new ArrayList<>();
    Scanner user_input = new Scanner(System.in);

    @Override
    public void add_driver(String team_name,Formula1Driver formula_add) {

        int check_name=0;
        for (Formula1Driver sport : formula1) {
            if (sport.getDriver_name().equals(team_name)) {
                check_name = 1;
            }
        }

        if (check_name==1) {
            System.out.println("**----- This Driver is already added -----**");
        }
        else {
            formula1.add(formula_add);
            System.out.println("");
        }
    }

    @Override
    public void delete_driver(String name) {
        boolean name_found = false;

        for (Formula1Driver sport : formula1) {
            if (sport.getDriver_name().equals(name)) {
                name_found = true;
                formula1.remove(sport);
                System.out.print("**----- "+name+" has successfully deleted from the Formula1 Championship -----**");
                System.out.println("");
                break;
            }
        }
        if (!name_found) {

            System.out.println("**--- Invalid driver Name ---**");
        }
    }

    @Override
    public void change_driver(String team_name,String driver_name) {
        for (Formula1Driver sport : formula1) {
            if (sport.getDriver_team().equals(team_name)) {
                sport.setDriver_name(driver_name);
            }
        }
    }

    @Override
    public void updateScore(String race_date) {

        for (int i=1;i<=formula1.size();i++){

            System.out.println("Enter team name :");
            String team_n= user_input.next().toLowerCase();

            for (Formula1Driver sport : formula1){
                if (sport.getDriver_team().equals(team_n)){
                    System.out.println("Enter position : ");
                    int position=user_input.nextInt();
                    int point =sport.getNumber_of_points();

                    switch (position){
                        case 1:
                            int pos1 =sport.getNumber_of_first_positions();
                            sport.setNumber_of_first_positions(pos1=pos1+1);
                            sport.setNumber_of_points(point=point+25);

                            break;
                        case 2:
                            int pos2 =sport.getNumber_of_second_positions();
                            sport.setNumber_of_second_positions(pos2=pos2+1);
                            sport.setNumber_of_points(point=point+18);

                            break;
                        case 3:
                            int pos3 =sport.getNumber_of_third_positions();
                            sport.setNumber_of_third_positions(pos3+pos3+1);
                            sport.setNumber_of_points(point=point+15);

                            break;
                        case 4:
                            sport.setNumber_of_points(point=point+12);
                            break;
                        case 5:
                            sport.setNumber_of_points(point=point+10);
                            break;
                        case 6:
                            sport.setNumber_of_points(point=point+8);
                            break;
                        case 7:
                            sport.setNumber_of_points(point=point+6);
                            break;
                        case 8:
                            sport.setNumber_of_points(point=point+4);
                            break;
                        case 9:
                            sport.setNumber_of_points(point=point+2);
                            break;
                        case 10:
                            sport.setNumber_of_points(point=point+1);
                            break;
                        default:
                            break;

                    }
                    int count =sport.getNumber_of_races_participated();
                    sport.setNumber_of_races_participated(count=count+1);
                }

            }
        }

    }


    @Override
    public void save_to_file(ArrayList<Formula1Driver> formula1) throws IOException {
        //https://howtodoinjava.com/java/collections/arraylist/serialize-deserialize-arraylist/
        try
        {
            FileOutputStream fos = new FileOutputStream("formula1Data.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(formula1);
            oos.close();
            fos.close();
            System.out.println("..data saved successfully------");

        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    @Override
    public void load_data() {
        //https://howtodoinjava.com/java/collections/arraylist/serialize-deserialize-arraylist/
        try
        {
            FileInputStream fis = new FileInputStream("formula1Data.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            formula1 = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
            System.out.println("-------Data loaded successfully------");
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }

    }

    @Override
    public void display_statistics(String name) {
        System.out.println("check");
        int check=0;
        for (Formula1Driver cars : formula1) {
            if (cars.getDriver_name().equals(name)) {
                check = 1;
                break;
            }
        }
        if (check!=0){
            for (Formula1Driver car : formula1) {
                if (car.getDriver_name().equals(name)) {

                    int pos1 =car.getNumber_of_first_positions();
                    int pos2 =car.getNumber_of_second_positions();
                    int pos3 =car.getNumber_of_third_positions();
                    int point =car.getNumber_of_points();
                    int race_count =car.getNumber_of_races_participated();
                    String team=car.getDriver_team();

                    System.out.println("Driver name : " + name);
                    System.out.println("Driver team : " + team );
                    System.out.println("number of 1st positions : "+pos1);
                    System.out.println("number of 2nd positions :"+pos2);
                    System.out.println("number of 3rd positions :"+pos3);
                    System.out.println("number of points :"+point);
                    System.out.println("number of races participated : "+race_count);
                    System.out.println("---------------------------------------");
                }

            }
        }
        else if (check ==0){
            System.out.println("---Invalid driver name----");
        }



    }

    @Override
    public void Display_table() {
        System.out.println("-------------------------------------------");
        System.out.println("  D R I V E R  T A B L E  ");
        System.out.println("-------------------------------------------");
        System.out.println("");

        Collections.sort(formula1, Comparator.comparingInt(Formula1Driver::getNumber_of_points).reversed());
        //https://stackoverflow.com/questions/15326248/sort-an-array-of-custom-objects-in-descending-order-on-an-int-property/15326312

        String leftAlignFormat = "| %-18s | %-8s | %-8s| %-8d | %-8d| %-8d | %-8d| %-8d |%n";

        System.out.format("+--------------------+----------+---------+----------+---------+----------+---------+----------+%n");
        System.out.format("| Name               | Team     | Location| Points   | 1st Pos | 2nd Pos  | 3rd Pos | Races    |%n");
        System.out.format("+--------------------+----------+---------+----------+---------+----------+---------+----------+%n");
        for (Formula1Driver drive : formula1) {
            System.out.format(leftAlignFormat, drive.getDriver_name(), drive.getDriver_team(), drive.getDriver_location(),drive.getNumber_of_points(),
                    drive.getNumber_of_first_positions(), drive.getNumber_of_second_positions(), drive.getNumber_of_third_positions(),
                    drive.getNumber_of_races_participated());

        }
        System.out.format("+--------------------+----------+---------+----------+---------+----------+---------+----------+%n");
    }

    @Override
    public void Gui() {
        System.out.println("enter team name: ");
        String n= user_input.next().toLowerCase();
        for (Formula1Driver sport : formula1) {
            if (sport.getDriver_team().equals(n)) {
                System.out.println("1st pos: " + sport.getNumber_of_first_positions());
                System.out.println("2nd pos: "+ sport.getNumber_of_second_positions());
                System.out.println("3rd pos: "+ sport.getNumber_of_third_positions());
                System.out.println("points: "+ sport.getNumber_of_points());
                System.out.println("team: "+ sport.getDriver_team());
            }
        }
    }
}
