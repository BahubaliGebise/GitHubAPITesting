package Core;


import org.json.JSONArray;
import org.json.JSONObject;
import java.io.UnsupportedEncodingException;
import static Util.TestBaseClass.testdata;
import static org.junit.Assert.assertEquals;


public class HttpClientAPI_Implementation {

    CreateURL updateServiceURL = new CreateURL();
    Get_HttpClient get_Service = new Get_HttpClient();

    public int totalCountResult;
    public int totalArrBlocks;

    public void Fetching_Numberof_GitRepoByTopicName_URL() {

        // Fetching updated URL's according to input parameters
        testdata.createdServiceAPI_URL = updateServiceURL.fetch_RepoByGivenTopic_URL();
        System.out.println("Final URL Created for fetching topic details from Repo : " + testdata.createdServiceAPI_URL);


    }


    public void Fetching_NumberOf_GitRepoByTopicName(int responseStatusCode) {

        // Calling Get Method and creating JsonObject
        try {
            JSONObject objResult = new JSONObject(get_Service.get_HttpClientMethod(responseStatusCode));

            totalCountResult = (int) objResult.get("total_count");
            System.out.println("Total count fetched from API : " + totalCountResult);

            Boolean incompleteResult = (Boolean) objResult.get("incomplete_results");
            System.out.println("incomplete_result : status fetched from API : " + incompleteResult);


            JSONArray arrJson = (JSONArray) objResult.get("items");
            int totalLanguages = arrJson.length();


            System.out.println("Total count to display on console  : " + totalLanguages);
            System.out.println("Given topic :" + testdata.languageType + " and count fetched from API : " + totalCountResult);


            System.out.println("==============Verify Given languages=========================");

                for (int i = 0; i < totalLanguages; i++) {

                    JSONObject jsonblocks = (JSONObject) arrJson.get(i);
                    String languageValue = jsonblocks.getString("language");
                    System.out.println("Actual Language Name from API : " + languageValue + " : Expected Given Language Name : " + testdata.languageType);

                    assertEquals(languageValue, testdata.languageType);

                }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void Fetching_NumberOf_GitRepoByCreationdate_URL() {

        // Fetching updated URL's according to input parameters
        testdata.createdServiceAPI_URL = updateServiceURL.fetch_RepoByCreationDate_URL();
        System.out.println("Final URL created for fetching Repo by creation date : " + testdata.createdServiceAPI_URL);

    }

    public void Fetching_NumberOf_GitRepoByCreationdate(int responseStatusCode) {


        // Calling Get Method and creating JsonObject
        try {
            JSONObject objResult = new JSONObject(get_Service.get_HttpClientMethod(responseStatusCode));

            totalCountResult = (int) objResult.get("total_count");

            Boolean incompleteResult = (Boolean) objResult.get("incomplete_results");
            System.out.println("incomplete_result : status fetched from API : " + incompleteResult);
            //assertFalse("incompleteResult status received response from API ", incompleteResult);


            JSONArray arrJson = (JSONArray) objResult.get("items");
            totalArrBlocks = arrJson.length();
            System.out.println("Total count to display on console  : " + totalArrBlocks);
            System.out.println("For a Given Creation Date : " + testdata.repoCreatedDate + " and count fetched from API : " + totalCountResult);


            System.out.println("\n==================Verify Given CreationDate from Response=========================\n");


            for (int i = 0; i < totalArrBlocks; i++) {

                JSONObject jsonblocks = (JSONObject) arrJson.get(i);
                String createdDesc = jsonblocks.getString("created_at");

                System.out.println("Actual Creation Date from API : " + createdDesc + " :  Expected CreationDate : " + testdata.repoCreatedDate);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void Fetching_Numberof_GitRepoByMultipleTopic_URL() throws UnsupportedEncodingException {

        // Fetching updated URL's according to input parameters
        testdata.createdServiceAPI_URL = updateServiceURL.fetch_RepoByMultipleTopic_URL(testdata.languageType);
        System.out.println("Final URL created for fetching Repo by multiple topic : " + testdata.createdServiceAPI_URL);

    }


    public void Fetching_NumberOf_GitRepoByMultipleTopic(int responseStatusCode) {

        try {
            JSONObject objResult = new JSONObject(get_Service.get_HttpClientMethod(responseStatusCode));

            totalCountResult = (int) objResult.get("total_count");

            Boolean incompleteResult = (Boolean) objResult.get("incomplete_results");
            System.out.println("incomplete_result : status fetched from API : " + incompleteResult);

            //assertFalse("incompleteResult status received response from API ", incompleteResult);


            JSONArray arrJson = (JSONArray) objResult.get("items");
            totalArrBlocks = arrJson.length();
            System.out.println("Total count to display on console  : " + totalArrBlocks);
            System.out.println("For a more than one programming languages : " + testdata.languageType + " and count fetched from API : " + totalCountResult);


            System.out.println("\n==================Verify Given more than one Programing language from Response=========================\n");


            for (int i = 0; i < totalArrBlocks; i++) {

                JSONObject jsonblocks = (JSONObject) arrJson.get(i);
                String moreLanguages = jsonblocks.getString("language");

                System.out.println("Actual ProgramLanguages from API : " + moreLanguages + " :  Expected languages from this list : " + testdata.languageType);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void Fetching_Numberof_GitRepoForSpecificUserName_URL() {

        testdata.createdServiceAPI_URL = updateServiceURL.fetch_RepoForSpecificUserName_URL(testdata.specificUserName);
        System.out.println("Final URL created for fetching Repo for specific Username : " + testdata.createdServiceAPI_URL);

    }

    public void Fetching_NumberOf_GitRepoForSpecificUserName(int responseStatusCode) {

        // Calling Get Method and creating JsonObject
        try {
            JSONObject objResult = new JSONObject(get_Service.get_HttpClientMethod(responseStatusCode));

            totalCountResult = (int) objResult.get("total_count");


            Boolean incompleteResult = (Boolean) objResult.get("incomplete_results");
            System.out.println("incomplete_result : status fetched from API : " + incompleteResult);

            //assertFalse("incompleteResult status received response from API ", incompleteResult);


            JSONArray arrJson = (JSONArray) objResult.get("items");
            totalArrBlocks = arrJson.length();
            System.out.println("Total count to display on console  : " + totalArrBlocks);
            System.out.println("Fetching repositories for a specific user : " + testdata.specificUserName + " and count fetched from API : " + totalCountResult);


            System.out.println("\n==================Verify Fetch repositories for a specific user from Response=========================\n");


            for (int i = 0; i < totalArrBlocks; i++) {

                JSONObject jsonblocks = (JSONObject) arrJson.get(i);
                String specificUser = jsonblocks.getString("full_name");

                System.out.println("Actual UserName from API : " + specificUser + " :  Expected User name : " + testdata.specificUserName);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void Fetching_MostStarredGitHub_Repositories_URL() {

        testdata.createdServiceAPI_URL = updateServiceURL.Fetching_MostStarredGitHub_Repo_URL();
        System.out.println("Final URL created for fetching Repo by most starred : " + testdata.createdServiceAPI_URL);

    }

    public void Fetching_MostStarredGitHub_Repositories(int responseStatusCode) {


        // Calling Get Method and creating JsonObject
        try {
            JSONObject objResult = new JSONObject(get_Service.get_HttpClientMethod(responseStatusCode));

            totalCountResult = (int) objResult.get("total_count");


            Boolean incompleteResult = (Boolean) objResult.get("incomplete_results");
            System.out.println("incomplete_result : status fetched from API : " + incompleteResult);
            //assertFalse("incompleteResult status received response from API ", incompleteResult);


            JSONArray arrJson = (JSONArray) objResult.get("items");
            totalArrBlocks = arrJson.length();
            System.out.println("Total count to display on console  : " + totalArrBlocks);
            System.out.println("Given most starred Type :" + testdata.MostStarredType + " and count fetched from API : " + totalCountResult);


            System.out.println("\n ============== Verify most starred Github repositories and order the results decreasingly =========================\n");


            for (int i = 0; i < totalArrBlocks; i++) {

                JSONObject jsonblocks = (JSONObject) arrJson.get(i);

                System.out.println("Get the MostStarred GitHubRepo and ordered results in decreasingly from API response : " + jsonblocks);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void Fetching_MaxNumberOfResults_GitHubRepositories_URL() {

        testdata.createdServiceAPI_URL = updateServiceURL.Fetching_MaxNumberOfResultsGitHub_Repo_URL();
        System.out.println("Final URL created for fetching Repo by Max Number of results : " + testdata.createdServiceAPI_URL);

    }

    public void Fetching_MaxNumberOfResults_GitHubRepositories(int responseStatusCode) {

        // Calling Get Method and creating JsonObject
        try {
            JSONObject objResult = new JSONObject(get_Service.get_HttpClientMethod(responseStatusCode));

            totalCountResult = (int) objResult.get("total_count");


            Boolean incompleteResult = (Boolean) objResult.get("incomplete_results");
            System.out.println("incomplete_result : status fetched from API : " + incompleteResult);
            //assertFalse("incompleteResult status received response from API ", incompleteResult);


            JSONArray arrJson = (JSONArray) objResult.get("items");
            totalArrBlocks = arrJson.length();
            System.out.println("Total count to display on console  : " + totalArrBlocks);
            System.out.println(" Specify a maximum number of results :" + testdata.MaxSearchType + " and count fetched from API : " + totalCountResult);


            System.out.println("\n ============== Fetch maximum number of results from GitHub=========================\n");


            for (int i = 0; i < totalArrBlocks; i++) {

                JSONObject jsonblocks = (JSONObject) arrJson.get(i);
                String MaxRepoCount = jsonblocks.getString("name");
                System.out.println("repositories maximum number of results from GitHub : " + MaxRepoCount);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}