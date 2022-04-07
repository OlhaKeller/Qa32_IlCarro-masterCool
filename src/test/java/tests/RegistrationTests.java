package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void preCondition() {

        if (app.user().isLogOutPresent()) {
            app.user().logout();
        }
    }

    @Test
    public void registrationSuccess() {
        int index = (int) (System.currentTimeMillis() / 1000) % 36000;

        app.user().openRegistrationForm();
        app.user().fillRegistrationForm("Lia", "Snow", "lia" + index + "@gmail.com", "Llia12345$");
        // app.user().checkPolicy();
        app.user().checkPolicyXY();
        app.user().submit();
        Assert.assertEquals(app.user().checkMessage(), "You are logged in success");

    }

    @Test
    public void registrationSuccessModel() {
        int index = (int) (System.currentTimeMillis() / 1000) % 36000;
        User user = new User()
                .withName("Lia")
                .withLastName("Snow")
                .withEmail("lia" + index + "@gmail.com")
                .withPassword("Llia12345$");


        app.user().openRegistrationForm();
        app.user().fillRegistrationForm(user);
        // app.user().checkPolicy();
        app.user().checkPolicyXY();
        app.user().submit();
        //app.user().pause(1000);
        Assert.assertEquals(app.user().checkMessage(), "You are logged in success");

    }

    @Test
    public void registrationWrongPasswordModel() {

        User user = new User()
                .withName("Lia")
                .withLastName("Snow")
                .withEmail("lalin@gmail.com")
                .withPassword("12345");


        app.user().openRegistrationForm();
        app.user().fillRegistrationForm(user);
        app.user().checkPolicy();
        app.user().submit();
        // error + button not active
        Assert.assertTrue(app.user().isErrorPasswordDisplayedSize());
        Assert.assertTrue(app.user().isErrorPasswordDisplayedFormat());
        Assert.assertFalse(app.user().isYallaButtonNotActive());
        Assert.assertTrue(app.user().isYallaButtonNotClickable());



    }

    @AfterMethod
    public void postCondition() {
        app.user().submitOkButton();
    }
}
