import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Formula1ChampionshipManager  implements ChampionshipManager {
    public static ArrayList<Formula1Driver> formula1 = new ArrayList<>();

    public static ArrayList<Race> races = new ArrayList<>();
    Scanner user_input = new Scanner(System.in);

    JButton sortByTotalPoint;
    JButton sortByFirstPositions;
    JButton randomRace;

    JButton raceDates;

    JButton randomRaceWithProb;

    JButton sortByFirstPos;
    JFrame mainFrame;
    JTable formula1DTable;

    JTable raceTable;
    JScrollPane jsMain;

    JScrollPane jsMain2;

    DefaultTableModel driverTable;
    DefaultTableModel positionTable;

    String firstPos;
    String secondPos;
    String thirdPos;

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
    public void delete_driver(int id) {
        boolean team_found = false;

        for (Formula1Driver sport : formula1) {
            if (sport.getTeam_ID()==id) {
                team_found = true;
                formula1.remove(sport);
                System.out.print("**-----team id  "+id+" has successfully deleted from the Formula1 Championship -----**");
                System.out.println("");
                break;
            }
        }
        if (!team_found) {

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

        System.out.print("Team id list-(");
        for (Formula1Driver sport : formula1){
            System.out.print(+sport.getTeam_ID()+"/");
        }
        System.out.print(")" );



        for (int i=1;i<=3;i++){

            System.out.println("\nEnter team id :");
            int team_id= user_input.nextInt();



            for (Formula1Driver sport : formula1){
                if (sport.getTeam_ID()==team_id){
                    System.out.println("Enter position : ");
                    int position=user_input.nextInt();
                    int point =sport.getNumber_of_points();

                    switch (position){
                        case 1:
                            int pos1 =sport.getNumber_of_first_positions();
                            sport.setNumber_of_first_positions(pos1=pos1+1);
                            sport.setNumber_of_points(point=point+25);
                            firstPos=sport.getDriver_name();

                            break;
                        case 2:
                            int pos2 =sport.getNumber_of_second_positions();
                            sport.setNumber_of_second_positions(pos2=pos2+1);
                            sport.setNumber_of_points(point=point+18);
                            secondPos=sport.getDriver_name();

                            break;
                        case 3:
                            int pos3 =sport.getNumber_of_third_positions();
                            sport.setNumber_of_third_positions(pos3=pos3+1);
                            sport.setNumber_of_points(point=point+15);
                            thirdPos=sport.getDriver_name();

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
        Race raceDetails=new Race(race_date,firstPos,secondPos,thirdPos);
        races.add(raceDetails);

    }


    @Override
    public void save_to_file(ArrayList<Formula1Driver> formula1) throws IOException {
        //https://howtodoinjava.com/java/collections/arraylist/serialize-deserialize-arraylist/
        try
        {   //save formula1 object
            FileOutputStream fos = new FileOutputStream("formula1Data.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(formula1);
            oos.close();
            fos.close();

            //save races object
            FileOutputStream fos2 = new FileOutputStream("raceData.txt");
            ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
            oos2.writeObject(races);
            oos2.close();
            fos2.close();

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
        {   // Loading Formula1 data
            FileInputStream fis = new FileInputStream("formula1Data.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            formula1 = (ArrayList) ois.readObject();

            ois.close();
            fis.close();

            //Loading Races data
            FileInputStream fis2 = new FileInputStream("raceData.txt");
            ObjectInputStream ois2 = new ObjectInputStream(fis2);

            races = (ArrayList) ois2.readObject();

            ois2.close();
            fis2.close();

            System.out.println("Data loaded 100%");
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
        System.out.println("----  D R I V E R  T A B L E  ----");
        System.out.println("");

        Collections.sort(formula1, Comparator.comparingInt(Formula1Driver::getNumber_of_points).reversed());
        //https://stackoverflow.com/questions/15326248/sort-an-array-of-custom-objects-in-descending-order-on-an-int-property/15326312

        String leftAlignFormat = "| %-23s | %-22s | %-8d | %-15s| %-8d | %-8s| %-8d | %-8d| %-8d |%n";

        System.out.format("+-------------------------+------------------------+----------+----------------+----------+---------+----------+---------+----------+%n");
        System.out.format("| Name                    | Team                   | id       | Location       | Points   | 1st Pos | 2nd Pos  | 3rd Pos | Races    |%n");
        System.out.format("+-------------------------+------------------------+----------+----------------+----------+---------+----------+---------+----------+%n");
        for (Formula1Driver drive : formula1) {
            System.out.format(leftAlignFormat, drive.getDriver_name(), drive.getDriver_team(), drive.getTeam_ID(), drive.getDriver_location(),drive.getNumber_of_points(),
                    drive.getNumber_of_first_positions(), drive.getNumber_of_second_positions(), drive.getNumber_of_third_positions(),
                    drive.getNumber_of_races_participated());

        }
        System.out.format("+-------------------------+------------------------+----------+----------------+----------+---------+----------+---------+----------+%n");

    }

    @Override
    public void Gui() {

        mainFrame = new JFrame();
        mainFrame.setTitle("FORMULA1 CHAMPIONSHIP MANAGER");
        mainFrame.setSize(1800, 700);
        mainFrame.setLayout(null);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //setting the main logo
        ImageIcon mainLogo = new ImageIcon("formula1_logo.png");
        mainFrame.setIconImage(mainLogo.getImage());

        //Displaying the main table
        Collections.sort(formula1, Comparator.comparingInt(Formula1Driver::getNumber_of_points).reversed());
        JTable table = guiTableDisplayStatistics();
        jsMain = new JScrollPane(table);
        jsMain.setBounds(50,50,1250,200);
        mainFrame.add(jsMain);

        sortByTotalPoint = new JButton("Sort By Points");
        sortByTotalPoint.setBounds(50, 300, 200, 50);
        mainFrame.add(sortByTotalPoint);
        sortByTotalPoint.addActionListener(this::actionPerformedPointSort);

        sortByFirstPositions = new JButton("Sort By 1st Positions");
        sortByFirstPositions.setBounds(300, 300, 200, 50);
        mainFrame.add(sortByFirstPositions);
        sortByFirstPositions.addActionListener(this::actionPerformedFirstSort);

        randomRace = new JButton("Random Race");
        randomRace.setBounds(550, 300, 200, 50);
        mainFrame.add(randomRace);
        randomRace.addActionListener(this::actionPerformedRandomRace);

        randomRaceWithProb = new JButton("Random Race(With prob)");
        randomRaceWithProb.setBounds(800, 300, 200, 50);
        mainFrame.add(randomRaceWithProb);
        randomRaceWithProb.addActionListener(this::actionPerformedRandomRaceWithProb);


        raceDates = new JButton("Race Details");
        raceDates.setBounds(1050, 300, 200, 50);
        mainFrame.add(raceDates);
        raceDates.addActionListener(this::actionPerformedRaceDates);
        mainFrame.setVisible(true);

    }

    @Override
    public int checkRandom() {

        Random rand = new Random();
        int id = rand.nextInt(100);
        int a=0;
        while (a==0){
            int b=0;
            id = rand.nextInt(100);
            for (Formula1Driver sport : formula1) {
                if (id==sport.getTeam_ID()){
                    b=1;
                    break;
                }
            }
            if (b==0){
                a=1;
            }
        }
        return id;
    }

    @Override
    public void generate_randomRace() {

            Random rand = new Random();
            ArrayList<Integer> tempPositions = new ArrayList<>();

            for (Formula1Driver sport : formula1){

                int position=rand.nextInt(formula1.size())+1;

                int temp=0;
                while (temp==0){
                    if (tempPositions.contains(position)){
                        position=rand.nextInt(formula1.size())+1;
                    }
                    else{
                        tempPositions.add(position);
                        temp=1;
                    }
                }

                int point =sport.getNumber_of_points();
                sport.setTemp_position(position=position);

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
                        sport.setNumber_of_third_positions(pos3=pos3+1);
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

    public void generate_randomRaceWithProb() {

        Random rand = new Random();
        ArrayList<Integer> tempPositions = new ArrayList<>();

        int randomProb = rand.nextInt(100)+1;
        int driver_num=0;

        int probPosition;

        if (randomProb<40) {probPosition = 1;}
        else if (randomProb<70) {probPosition = 2;}
        else if (randomProb<80) {probPosition = 3;}
        else if (randomProb<90) {probPosition = 4;}
        else if (randomProb<92) {probPosition = 5;}
        else if (randomProb<94) {probPosition = 6;}
        else if (randomProb<96) {probPosition = 7;}
        else if (randomProb<98) {probPosition = 8;}
        else {probPosition = 9;}

        tempPositions.add(1);

        for (Formula1Driver sport : formula1){

            int point =sport.getNumber_of_points();
            driver_num+=1;

            if (driver_num==probPosition){
                int pos1 =sport.getNumber_of_first_positions();
                sport.setNumber_of_first_positions(pos1=pos1+1);
                sport.setNumber_of_points(point=point+25);
            }

            else{
                int position=rand.nextInt(formula1.size())+1;

                int temp=0;
                while (temp==0){
                    if (tempPositions.contains(position)){
                        position=rand.nextInt(formula1.size())+1;
                    }
                    else{
                        tempPositions.add(position);
                        temp=1;
                    }
                }

                sport.setTemp_position(position=position);

                switch (position){

                    case 2:
                        int pos2 =sport.getNumber_of_second_positions();
                        sport.setNumber_of_second_positions(pos2=pos2+1);
                        sport.setNumber_of_points(point=point+18);

                        break;
                    case 3:
                        int pos3 =sport.getNumber_of_third_positions();
                        sport.setNumber_of_third_positions(pos3=pos3+1);
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
            }


            int count =sport.getNumber_of_races_participated();
            sport.setNumber_of_races_participated(count=count+1);

        }



    }



    public JTable guiTableDisplayStatistics() {
        //Collections.sort(formula1, Comparator.comparingInt(Formula1Driver::getNumber_of_points).reversed());
        String driverTableColumn[] = {"Driver Name", "Location", "Team","Team ID",
                "No Of 1st Places", "No Of 2nd Places", "No Of 3rd Places", "Races","Points"};
        driverTable = new DefaultTableModel(driverTableColumn,0);
        formula1DTable = new JTable(driverTable);
        formula1DTable.setFillsViewportHeight(true);
        for (Formula1Driver formula1Driver : formula1) {
            String dName = formula1Driver.getDriver_name();
            String dLocation = formula1Driver.getDriver_location();
            String team = formula1Driver.getDriver_team();
            String team_id = Integer.toString(formula1Driver.getTeam_ID());
            String numOfFirst = Integer.toString(formula1Driver.getNumber_of_first_positions());
            String numOfSecond = Integer.toString(formula1Driver.getNumber_of_second_positions());
            String numOfThird = Integer.toString(formula1Driver.getNumber_of_third_positions());
            String numOfRace = Integer.toString(formula1Driver.getNumber_of_races_participated());
            String numOfPoints = Integer.toString(formula1Driver.getNumber_of_points());
            Object [] data = {dName, dLocation, team,team_id, numOfFirst, numOfSecond, numOfThird, numOfRace, numOfPoints};
            driverTable.addRow(data);
        }
        driverTable.fireTableDataChanged();
        return formula1DTable;
    }



    public JTable raceTableDisplayStatistics() {
        //Collections.sort(formula1, Comparator.comparingInt(Formula1Driver::getNumber_of_points).reversed());
        String raceTableColumn[] = {"Driver Name", "Team Name","Position"};
        positionTable = new DefaultTableModel(raceTableColumn,0);
        raceTable = new JTable(positionTable);
        raceTable.setFillsViewportHeight(true);
        for (Formula1Driver formula1Driver : formula1) {
            String dName = formula1Driver.getDriver_name();
            String team = formula1Driver.getDriver_team();
            String pos = Integer.toString(formula1Driver.getTemp_position());

            Object [] data = {dName, team,pos};
            positionTable.addRow(data);
        }
        positionTable.fireTableDataChanged();
        return raceTable;
    }

    public JTable dateTableDisplayStatistics() {
        sortingDates();
        String raceTableColumn[] = {"Date","1st Position","2nd Position","3rd Position"};
        positionTable = new DefaultTableModel(raceTableColumn,0);
        raceTable = new JTable(positionTable);
        raceTable.setFillsViewportHeight(true);
        for (Race race_details : races) {
            String date = race_details.getRaceDate();
            String firstPos = race_details.getFirstPosition();
            String secondPos = race_details.getSecondPosition();
            String thirdPos = race_details.getThirdPosition();

            Object [] data = {date, firstPos,secondPos,thirdPos};
            positionTable.addRow(data);
        }
        positionTable.fireTableDataChanged();
        return raceTable;
    }

    public void actionPerformedPointSort(ActionEvent ePointSort){
        if(ePointSort.getSource() == sortByTotalPoint){
            Collections.sort(formula1, Comparator.comparingInt(Formula1Driver::getNumber_of_points));
            //Collections.sort(formula1, Comparator.comparingInt(Formula1Driver::getNumber_of_points).reversed());
            mainFrame.remove(jsMain);
            JTable table = guiTableDisplayStatistics();
            jsMain = new JScrollPane(table);
            jsMain.setBounds(50,50,1250,200);
            mainFrame.add(jsMain);

        }
    }
    public void actionPerformedFirstSort(ActionEvent eFirstPositionsSort){
        if(eFirstPositionsSort.getSource() == sortByFirstPositions){
            Collections.sort(formula1, Comparator.comparingInt(Formula1Driver::getNumber_of_first_positions).reversed());
            mainFrame.remove(jsMain);
            JTable table = guiTableDisplayStatistics();
            jsMain = new JScrollPane(table);
            jsMain.setBounds(50,50,1250,200);
            mainFrame.add(jsMain);

        }
    }

    public void actionPerformedRandomRace(ActionEvent eRandomRace){
        if(eRandomRace.getSource() == randomRace){
            generate_randomRace();
            Collections.sort(formula1, Comparator.comparingInt(Formula1Driver::getNumber_of_points).reversed());
            mainFrame.remove(jsMain);
            JTable table = guiTableDisplayStatistics();
            jsMain = new JScrollPane(table);
            jsMain.setBounds(50,50,1250,200);
            mainFrame.add(jsMain);

            JTable raceTable = raceTableDisplayStatistics();
            jsMain2 = new JScrollPane(raceTable);
            jsMain2.setBounds(40,400,1250,200);
            mainFrame.add(jsMain2);


        }
    }

    public void actionPerformedRandomRaceWithProb(ActionEvent eRandomRaceWithProb){
        if(eRandomRaceWithProb.getSource() == randomRaceWithProb){

            generate_randomRaceWithProb();

            Collections.sort(formula1, Comparator.comparingInt(Formula1Driver::getNumber_of_points).reversed());
            mainFrame.remove(jsMain);
            JTable table = guiTableDisplayStatistics();
            jsMain = new JScrollPane(table);
            jsMain.setBounds(50,50,1250,200);
            mainFrame.add(jsMain);

            JTable raceTable = raceTableDisplayStatistics();
            jsMain2 = new JScrollPane(raceTable);
            jsMain2.setBounds(40,400,1250,200);
            mainFrame.add(jsMain2);

        }
    }

    public void actionPerformedRaceDates(ActionEvent eRaceDates){
        if(eRaceDates.getSource() == raceDates){

            mainFrame.remove(jsMain2);
            JTable raceTable = dateTableDisplayStatistics();
            jsMain2 = new JScrollPane(raceTable);
            jsMain2.setBounds(40,400,1250,200);
            mainFrame.add(jsMain2);



        }
    }

    static class sortItems implements Comparator<Race> {
        public int compare(Race a, Race b)
        {

            // Returning the value after comparing the objects
            // this will sort the data in Ascending order
            return a.getRaceDate().compareTo(b.getRaceDate());
        }
    }

    public void sortingDates(){
        Collections.sort(races, new sortItems());

    }

}