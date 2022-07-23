import java.io.Serializable;

public abstract class Driver implements Serializable {
    private String driver_name;
    private String driver_location;
    private String driver_team;
    private int team_ID;

    private int temp_position;

    public Driver (String driver_name,String driver_location,String driver_team,Integer team_ID,Integer temp_position){
        this.driver_name =driver_name;
        this.driver_location =driver_location;
        this.driver_team=driver_team;
        this.team_ID=team_ID;
        this.temp_position=temp_position;
    }

    public String getDriver_name (){
        return driver_name;
    }

    public void setDriver_name(String driver_name){ this.driver_name =driver_name;}

    public String getDriver_location (){
        return driver_location;
    }

    public void setDriver_location(String driver_location){
        this.driver_location =driver_location;
    }

    public String getDriver_team (){
        return driver_team;
    }

    public void setDriver_team(String driver_team){
        this.driver_team =driver_team;
    }

    public int getTeam_ID(){
        return team_ID;
    }

    public void setTeam_ID(int team_ID){
        this.team_ID =team_ID;
    }

    public int getTemp_position(){
        return temp_position;
    }

    public void setTemp_position(int temp_position){
        this.temp_position =temp_position;
    }
}