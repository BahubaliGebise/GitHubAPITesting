package Core;

import Util.ReadFromCSV;


public class ReadTestCaseData_Implementation {

    public String env;
    public String languageType;
    public String MaxSearchType;
    public String createdServiceAPI_URL;
    public String fetchMultiplTopic;
    public String repoCreatedDate;
    public String specificUserName;
    public String MostStarredType;
    public String OrderType;

    public void initialize_testcases(String testcaseID) {

        // .csv file name and reading rows and columns(key, value pair)

        String csvFileName = "GitHub_TestData.csv";
        System.out.println("Reading data from .csv file name  :" + csvFileName);

        ReadFromCSV csvReader = new ReadFromCSV(csvFileName);

        env = csvReader.readValue("Environment", "Env");

        languageType = csvReader.readValue(testcaseID, "Language");

        MaxSearchType = csvReader.readValue(testcaseID, "MaxTypeSearch");

        fetchMultiplTopic = csvReader.readValue(testcaseID, "SearchByMultipleTopic");

        repoCreatedDate = csvReader.readValue(testcaseID, "CreatedDate");

        specificUserName = csvReader.readValue(testcaseID, "UserName");

        MostStarredType = csvReader.readValue(testcaseID, "MostStarred");

        OrderType = csvReader.readValue(testcaseID, "Order");


    }
}
