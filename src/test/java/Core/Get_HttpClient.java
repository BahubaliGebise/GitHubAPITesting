package Core;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import static Util.TestBaseClass.testdata;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class Get_HttpClient {


    public String get_HttpClientMethod(int responseStatusCode) throws IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(testdata.createdServiceAPI_URL);

        httpGet.addHeader("accept", "application/vnd.github.mercy-preview+json");

        CloseableHttpResponse response = httpclient.execute(httpGet);

        System.out.println("Response status code : " + response.getStatusLine().getStatusCode());
        assertThat(response.getStatusLine().getStatusCode(), equalTo(responseStatusCode));
        HttpEntity httpEntityResponse = response.getEntity();

        return EntityUtils.toString(httpEntityResponse);
    }
}
