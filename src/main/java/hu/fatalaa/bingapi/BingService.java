package hu.fatalaa.bingapi;

import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by tmolnar on 9/26/14.
 */
public interface BingService {
    static final String TRANSLATE_API_URL = "http://api.microsofttranslator.com/v2/Http.svc";
    static final String LOGIN_API_URL = "https://datamarket.accesscontrol.windows.net/v2/OAuth2-13";

    static final String FROM_LANGUAGE_PARAM = "from";
    static final String TO_LANGUAGE_PARAM = "to";
    static final String WORD_PARAM = "text";

    @GET("/Translate")
    Response translate(@Query(WORD_PARAM) String text, @Query(FROM_LANGUAGE_PARAM) String from,
                     @Query(TO_LANGUAGE_PARAM) String to);

}
