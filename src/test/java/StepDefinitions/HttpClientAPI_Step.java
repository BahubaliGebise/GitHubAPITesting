package StepDefinitions;

import Core.HttpClientAPI_Implementation;
import Util.TestBaseClass;

import io.cucumber.java.en.*;

import java.io.UnsupportedEncodingException;

public class HttpClientAPI_Step extends TestBaseClass {


    HttpClientAPI_Implementation serviceCall = new HttpClientAPI_Implementation();


    @When("^create a service URL to fetch number of repositories for a provided programming language$")
    public void create_a_service_URL_to_fetch_number_of_repositories_for_a_provided_programming_language() {
        // Fetching Service URL
        serviceCall.Fetching_Numberof_GitRepoByTopicName_URL();
    }


    @When("^create a service URL to fetch number of repositories by provided creation date$")
    public void createAServiceURLToFetchNumberOfRepositoriesByProvidedCreationDate() {
        System.out.println("Repositories search by given creation date from .csv : " + testdata.repoCreatedDate);
        serviceCall.Fetching_NumberOf_GitRepoByCreationdate_URL();
    }


    @When("^create a service URL to fetch number of repo for a provided more than one programming language$")
    public void createAServiceURLToFetchNumberOfRepoForAProvidedMoreThanOneProgrammingLanguage() throws UnsupportedEncodingException {
        System.out.println("Repositories search by given more than one programming languages from .csv file : " + testdata.languageType);
        serviceCall.Fetching_Numberof_GitRepoByMultipleTopic_URL();

    }


    @When("^create a service URL to fetch number of repositories for specific user$")
    public void createAServiceURLToFetchNumberOfRepositoriesForSpecificUser() {

        System.out.println("Repositories search by specific UserName : " + testdata.specificUserName);
        serviceCall.Fetching_Numberof_GitRepoForSpecificUserName_URL();
    }


    @When("^create a service URL to fetch the most starred repositories and order results desc$")
    public void createAServiceURLToFetchTheMostStarredRepositoriesAndOrderResultsDesc() {
        System.out.println("Repositories search by most starred Repo at GitHub: ");
        serviceCall.Fetching_MostStarredGitHub_Repositories_URL();
    }


    @When("^create a service URL to fetch the maximum number of results from github$")
    public void createAServiceURLToFetchTheMaximumNumberOfResultsFromGithub() {
        System.out.println("Repositories search by specific UserName : " + testdata.MaxSearchType);
        serviceCall.Fetching_MaxNumberOfResults_GitHubRepositories_URL();
    }

    @Then("^perform GET method and verify response along with status code is \"([^\"]*)\"$")
    public void perform_GET_method_and_verify_response_along_with_status_code_is(int responsestatusCode) {

        // Get method calling based input parameters
        if (testdata.languageType.length() > 0 && testdata.fetchMultiplTopic.equalsIgnoreCase("FALSE")) {
            System.out.println("programming language value from .csv : " + testdata.languageType);
            serviceCall.Fetching_NumberOf_GitRepoByTopicName(responsestatusCode);
        } else if (testdata.repoCreatedDate.length() > 0 && testdata.fetchMultiplTopic.equalsIgnoreCase("FALSE")) {
            System.out.println("Repositories search by given creation date from .csv : " + testdata.repoCreatedDate);
            serviceCall.Fetching_NumberOf_GitRepoByCreationdate(responsestatusCode);
        } else if (testdata.languageType.length() > 0 && testdata.fetchMultiplTopic.equalsIgnoreCase("TRUE")) {
            System.out.println("Repositories search by given more than one programming languages from .csv : " + testdata.languageType);
            serviceCall.Fetching_NumberOf_GitRepoByMultipleTopic(responsestatusCode);
        } else if (testdata.specificUserName.length() > 0 && testdata.fetchMultiplTopic.equalsIgnoreCase("FALSE")) {
            System.out.println("Repositories search by specific UserName : " + testdata.specificUserName);
            serviceCall.Fetching_NumberOf_GitRepoForSpecificUserName(responsestatusCode);
        } else if (testdata.MostStarredType.length() > 0 && testdata.fetchMultiplTopic.equalsIgnoreCase("FALSE")) {
            System.out.println("Repositories search by MostStarred : " + testdata.MostStarredType);
            serviceCall.Fetching_MostStarredGitHub_Repositories(responsestatusCode);
        } else if (testdata.MaxSearchType.length() > 0 && testdata.fetchMultiplTopic.equalsIgnoreCase("FALSE")) {
            System.out.println("Repositories search by Max numbers Search Type : " + testdata.MaxSearchType);
            serviceCall.Fetching_MaxNumberOfResults_GitHubRepositories(responsestatusCode);
        }

    }


}
