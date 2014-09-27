package hu.fatalaa.bingapi;

import hu.fatalaa.bingapi.models.GetTranslationsResponse;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import retrofit.RestAdapter;
import retrofit.converter.SimpleXMLConverter;

/**
 * Created by tmolnar on 9/27/14.
 */
public class SecuredRestBuilderTest {
    private BingService bingService;
    private final String clientId = "";
    private final String clientSecret = "";

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

    @Test public void testTranslate() throws Exception {
        String response = bingService.translate("cica", "hu", "en", "text/plain");
        Assert.assertEquals("kitten", response);
    }

    @Test public void testGetTranslations() throws Exception {
        GetTranslationsResponse response = bingService.getTranslations("cica", "hu", "en", 50, null);
        Assert.assertNotNull(response);
    }
}
