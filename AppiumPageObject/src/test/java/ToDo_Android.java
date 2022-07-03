import PageObjects.CreateTaskPage;
import PageObjects.TasksListPage;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.CreateTaskPage;
import pageObject.TaskListPage;
import utils.JsonReader;

import java.io.IOException;
import java.net.MalformedURLException;

public class ToDo_Android extends TestBase {

    CreateTaskPage createTaskPage;
    TaskListPage tasksListPage;

    @DataProvider(name = "tasks data")
    public Object[][] passData() throws IOException, ParseException {
        return JsonReader.getJSONdata
                (System.getProperty("user.dir") + "/data/TasksData.json"
                        , "Tasks Data", 2);
    }

    @Test(dataProvider = "tasks data")
    public void test_add_task() throws MalformedURLException {
        Android_setUp();
        tasksListPage = new TaskListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        tasksListPage.clickAddTaskBtn();
        createTaskPage.enterTaskName("Finish Appium Course");
        createTaskPage.enterTaskDesc("Finishing my course ASAP");
        driver.hideKeyboard();
        createTaskPage.clickSaveBtn();
        tearDown();
    }
}