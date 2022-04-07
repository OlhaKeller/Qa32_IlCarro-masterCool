package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends TestBase{

    @Test
    public void searchCurrentMonth(){
        app.search().searchCurrentMonth("Tel Aviv","4/10/2022","4/20/2022");
        app.search().submit();
       // Assert.assertTrue(app.search().isListOfCarsAppeared());
    }



    @Test
    public void searchPeriodInPast(){
        app.search().searchPeriodInPast("Tel Aviv","2/01/2022","04/20/2022");
        app.search().submitWithoutWait();

        Assert.assertFalse(app.user().isYallaButtonNotActive());
        Assert.assertTrue(app.search().isPeriodInPast());
    }

    @Test
    public void searchAnyPeriod(){
        app.search().searchAnyPeriod("Tel Aviv","01/05/2023","03/15/2023");
        app.search().submit();
    }
}
