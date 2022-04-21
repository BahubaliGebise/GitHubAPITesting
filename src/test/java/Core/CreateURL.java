package Core;

//import com.sun.deploy.net.URLEncoder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

import static Util.TestBaseClass.testdata;

public class CreateURL {
    String env = testdata.env;
    String partial_URL = null;
    String serviceUrl = null;
    String multipleTopics = null;

    public String fetch_RepoByGivenTopic_URL() {

        partial_URL = "/repositories?q=language:" + testdata.languageType + "&sort=created&order=desc";
        serviceUrl = env + partial_URL;

        return serviceUrl;
    }


    public String fetch_RepoByCreationDate_URL() {

        partial_URL = "/repositories?q=created:" + testdata.repoCreatedDate;
        serviceUrl = env + partial_URL;


        return serviceUrl;
    }


    public String fetch_RepoByMultipleTopic_URL(String NumberOfTopics) throws UnsupportedEncodingException {


        List<String> expectedTopics = Arrays.asList(NumberOfTopics.split("#"));

        for (int i = 0; i < expectedTopics.size(); i++) {

            System.out.println("number of languages from .csv = " + expectedTopics.get(i));

            if (i == 0) {
                multipleTopics = "/repositories?q=language:" + expectedTopics.get(i);
                continue;

            }

            multipleTopics += URLEncoder.encode(" ", "UTF-8") + "or" + URLEncoder.encode(" ", "UTF-8") + "language:" + expectedTopics.get(i);
        }

        serviceUrl = env + multipleTopics;


        return serviceUrl;
    }

    public String fetch_RepoForSpecificUserName_URL(String SearchForSpecificUserName) {

        partial_URL = "/repositories?q=user:" + SearchForSpecificUserName;
        serviceUrl = env + partial_URL;


        return serviceUrl;
    }


    public String Fetching_MostStarredGitHub_Repo_URL() {

        partial_URL = "/repositories?q=repositories&sort=" + testdata.MostStarredType + "&order=" + testdata.OrderType;
        serviceUrl = env + partial_URL;


        return serviceUrl;
    }


    public String Fetching_MaxNumberOfResultsGitHub_Repo_URL() {

        partial_URL = "/repositories?q=" + testdata.MaxSearchType;
        serviceUrl = env + partial_URL;

        return serviceUrl;
    }


}
