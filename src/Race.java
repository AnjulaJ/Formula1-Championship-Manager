public class Race{
    private String raceDate;
    private int firstPosition;
    private int SecondPosition;
    private int thirdPosition;
    public Race (String raceDate,int firstPosition,int SecondPosition,int thirdPosition){
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



    public int getFirstPosition (){
        return firstPosition;
    }

    public void setFirstPosition(int firstPosition){
        this.firstPosition =firstPosition;
    }



    public int getSecondPosition (){
        return SecondPosition;
    }

    public void setSecondPosition(int SecondPosition){
        this.SecondPosition =SecondPosition;
    }
    public int getThirdPosition (){
        return thirdPosition;
    }

    public void setThirdPosition(int thirdPosition){
        this.thirdPosition =thirdPosition;
    }

}

