package hu.fatalaa.bingapi;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import retrofit.RestAdapter;
import retrofit.client.Response;
import retrofit.converter.SimpleXMLConverter;

/**
 * Created by tmolnar on 9/27/14.
 */
public class SecuredRestBuilderTest {
    private BingService bingService;
    private final String clientId = "CLIENT-ID-HERE";
    private final String clientSecret = "CLIENT-SECRET HERE";

    @Before
    public void setUp() {
        bingService = new SecuredRestBuilder().setLoginEndpoint(BingService.LOGIN_API_URL)
                                              .setClientId(clientId)
                                              .setClientSecret(clientSecret)
                                              .setEndpoint(BingService.TRANSLATE_API_URL)
                                              .setLogLevel(RestAdapter.LogLevel.FULL)
                                              .setConverter(new SimpleXMLConverter())
                                              .build()
                                              .create(BingService.class);
    }

    @Test
    public void testSomething() {
        Response response = bingService.translate("cica", "hu", "en");
        Assert.assertNotNull(response);
    }
}
