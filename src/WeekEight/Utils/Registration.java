package WeekEight.Utils;
import WeekEight.Constants;
import WeekEight.FileHandler;

public class Registration {

    public String registerUser(String[] userDetail) {
        FileHandler fh = new FileHandler();
        return fh.CreateOrAdd(Constants.userDetailFileName, userDetail);
    }
}
    


