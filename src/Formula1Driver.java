import java.io.Serializable;

public class Formula1Driver extends Driver implements Serializable {
    private int number_of_first_positions=0;
    private int number_of_second_positions=0;
    private int number_of_third_positions=0;
    private int number_of_points=0;
    private int number_of_races_participated=0;
    private String date;

    public Formula1Driver(String driver_name, String driver_location, String driver_team,Integer team_ID,Integer temp_position) {

        super(driver_name, driver_location, driver_team, team_ID,temp_position);
    }

    public Formula1Driver(String driver_name, String driver_location, String driver_team,Integer team_ID,Integer temp_position,
                          int number_of_first_positions,int number_of_second_positions,int number_of_third_positions,
                          int number_of_points,int number_of_races_participated,String date){

        super(driver_name,driver_location,driver_team,team_ID,temp_position);
        this.number_of_first_positions = number_of_first_positions;
        this.number_of_second_positions =number_of_second_positions;
        this.number_of_third_positions= number_of_third_positions;
        this.number_of_points= number_of_points;
        this.number_of_races_participated = number_of_races_participated;
        this.date=date;

    }

    public int getNumber_of_first_positions(){
        return number_of_first_positions;
    }
    public void setNumber_of_first_positions(int number_of_first_positions){
        this.number_of_first_positions = number_of_first_positions;
    }

    public int getNumber_of_second_positions(){
        return number_of_second_positions;
    }
    public void setNumber_of_second_positions(int number_of_second_positions){
        this.number_of_second_positions = number_of_second_positions;
    }

    public int getNumber_of_third_positions(){
        return number_of_third_positions;
    }
    public void setNumber_of_third_positions(int number_of_third_positions){
        this.number_of_third_positions = number_of_third_positions;
    }

    public int getNumber_of_points(){
        return number_of_points;
    }
    public void setNumber_of_points(int number_of_points){
        this.number_of_points = number_of_points;
    }

    public int getNumber_of_races_participated(){
        return number_of_races_participated;
    }
    public void setNumber_of_races_participated(int number_of_races_participated){
        this.number_of_races_participated = number_of_races_participated;
    }

    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date = date;
    }
}

