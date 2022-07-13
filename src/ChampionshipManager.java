import java.io.IOException;
import java.util.ArrayList;

public interface ChampionshipManager  {

    void add_driver(String team_name,Formula1Driver Driver);

    void delete_driver(String name);

    void change_driver(String team_name,String driver_name);

    void updateScore(String race_date);

    void save_to_file(ArrayList<Formula1Driver> formula1) throws IOException;

    void load_data();

    void display_statistics(String name);

    void Display_table();

    void Gui();

}
