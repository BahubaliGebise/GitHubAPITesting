package StepDefinitions;

import Util.TestBaseClass;
import io.cucumber.java.en.Given;

public class ReadTestCaseData_Step extends TestBaseClass {


    @Given("^the test case id is \"([^\"]*)\"$")
    public void the_test_case_ID_is(String TestID) {

        testdata.initialize_testcases(TestID);
    }

}
