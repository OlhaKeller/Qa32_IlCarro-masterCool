package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    UserHelper userHelper;
    CarHelper car;
    HelperSearch search;;


    public void init(){
        wd=new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://ilcarro.xyz/");
        userHelper = new UserHelper(wd);
        car = new CarHelper(wd);
        search = new HelperSearch(wd);



    }

    public void stop(){
       // wd.quit();
    }

    public UserHelper user() {
        return userHelper;
    }

    public CarHelper car() {
        return car;
    }

    public HelperSearch search() {
        return search;
    }
}
