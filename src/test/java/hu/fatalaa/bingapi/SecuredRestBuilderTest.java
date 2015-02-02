package hu.fatalaa.bingapi;

import hu.fatalaa.bingapi.models.GetTranslationsArrayResponse;
import hu.fatalaa.bingapi.models.GetTranslationsResponse;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.SimpleXMLConverter;

import java.util.Arrays;

/**
 * Created by tmolnar on 9/27/14.
 */
public class SecuredRestBuilderTest {
    private BingService bingService;
    private final String clientId = "f4t4l44-m1cr0bl0g";
    private final String clientSecret = "RuhWV/MbQu7+pg7eu4vf/Fr9xxDo5bVx7ZTl9ZOCmsE=";

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

    @Test public void  testGetTranslationsArrayResponse() {
        GetTranslationsArrayResponse response = bingService.getTranslationsArray(Arrays.asList("kutya", "cica"),
                        "hu", "en", 10, null
        );
        Assert.assertNotNull(response);
    }

    @Test public void testTranslateAsync() throws InterruptedException {
        String translation = null;
        bingService.translateAsync("cica", "hu", "en", "text/plain", new Callback<String>() {
            @Override
            public void success(String s, Response response) {
                System.out.println(s);
            }

            @Override
            public void failure(RetrofitError error) {
                System.out.println(error);
            }
        });
        Thread.sleep(1500);
    }
}
