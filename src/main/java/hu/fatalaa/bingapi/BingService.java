package hu.fatalaa.bingapi;

import hu.fatalaa.bingapi.models.GetTranslationsResponse;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;
import retrofit.http.QueryMap;

import java.util.HashMap;

/**
 * Created by tmolnar on 9/26/14.
 */
public interface BingService {
    static final String TRANSLATE_API_URL = "http://api.microsofttranslator.com/v2/Http.svc";
    static final String LOGIN_API_URL = "https://datamarket.accesscontrol.windows.net/v2/OAuth2-13";

    static final String FROM_LANGUAGE_PARAM = "from";
    static final String TO_LANGUAGE_PARAM = "to";
    static final String WORD_PARAM = "text";
    static final String CONTENT_TYPE_PARAM = "contentType";
    static final String MAX_TRANSLATIONS_PARAM = "maxTranslations";

    @GET("/Translate")
    String translate(@Query(WORD_PARAM) String text, @Query(FROM_LANGUAGE_PARAM) String from,
                     @Query(TO_LANGUAGE_PARAM) String to, @Query(CONTENT_TYPE_PARAM) String contentType);

    @POST("/GetTranslations")
    GetTranslationsResponse getTranslations(@Query(WORD_PARAM) String text, @Query(FROM_LANGUAGE_PARAM) String from,
                             @Query(TO_LANGUAGE_PARAM) String to, @Query(MAX_TRANSLATIONS_PARAM) int maxTranslations,
                             @QueryMap HashMap<String,String> options);

}
