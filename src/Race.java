import java.io.Serializable;

public class Race implements Serializable {
    private String raceDate;
    private String firstPosition;
    private String SecondPosition;
    private String thirdPosition;
    public Race (String raceDate,String firstPosition,String SecondPosition,String thirdPosition){
        this.raceDate =raceDate;
        this.firstPosition =firstPosition;
        this.SecondPosition =SecondPosition;
        this.thirdPosition =thirdPosition;
    }

    public String getRaceDate (){
        return raceDate;
    }

    public void setRaceDate(String raceDate){
        this.raceDate =raceDate;
    }



    public String getFirstPosition (){
        return firstPosition;
    }

    public void setFirstPosition(String firstPosition){
        this.firstPosition =firstPosition;
    }



    public String getSecondPosition (){
        return SecondPosition;
    }

    public void setSecondPosition(String SecondPosition){
        this.SecondPosition =SecondPosition;
    }
    public String getThirdPosition (){
        return thirdPosition;
    }

    public void setThirdPosition(String thirdPosition){
        this.thirdPosition =thirdPosition;
    }

}

