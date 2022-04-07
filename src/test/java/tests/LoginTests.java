package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void preCondition(){

        if(app.user().isLogOutPresent()){
            app.user().logout();
        }
    }

    @Test
    public void loginSuccess(){

        app.user().openLoginForm();
        app.user().fillLoginForm("noa@gmail.com","Nnoa12345$");
        app.user().submit();
        app.user().pause(1000);
        Assert.assertEquals(app.user().checkMessage(),"Logged in success");

    }

    @Test
    public void loginSuccessModel(){
        User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");

        app.user().openLoginForm();
        app.user().fillLoginForm(user);
        app.user().submit();
        app.user().pause(1000);
        Assert.assertEquals(app.user().checkMessage(),"Logged in success");

    }

    @Test
    public void loginSuccessNew(){

        app.user().openLoginForm();
        app.user().fillLoginForm("noa@gmail.com","Nnoa12345$");
        app.user().submit();
        app.user().pause(1000);
        Assert.assertEquals(app.user().checkMessage(),"Logged in success");



    }

    @AfterMethod
    public void postCondition(){
        app.user().submitOkButton();
    }
}
