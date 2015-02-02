package hu.fatalaa.bingapi;

import hu.fatalaa.bingapi.models.GetTranslationsArrayResponse;
import hu.fatalaa.bingapi.models.GetTranslationsResponse;
import hu.fatalaa.bingapi.models.TranslateArrayResponse;
import retrofit.Callback;
import retrofit.http.*;

import java.util.HashMap;
import java.util.List;

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
    static final String WORDS_PARAM = "texts";

    @GET("/Translate")
    String translate(@Query(WORD_PARAM) String text, @Query(FROM_LANGUAGE_PARAM) String from,
                     @Query(TO_LANGUAGE_PARAM) String to, @Query(CONTENT_TYPE_PARAM) String contentType);

    @GET("/Translate")
    void translateAsync(@Query(WORD_PARAM) String text, @Query(FROM_LANGUAGE_PARAM) String from,
                   @Query(TO_LANGUAGE_PARAM) String to, @Query(CONTENT_TYPE_PARAM) String contentType,
                   Callback<String> callback);

    @POST("/TranslateArray")
    TranslateArrayResponse translateArray(@Query(WORDS_PARAM) List<String> words ,
                                          @Query(FROM_LANGUAGE_PARAM) String from, @Query(TO_LANGUAGE_PARAM) String to,
                                          @QueryMap HashMap<String, String> options);

    @POST("/GetTranslations")
    GetTranslationsResponse getTranslations(@Query(WORD_PARAM) String text, @Query(FROM_LANGUAGE_PARAM) String from,
                             @Query(TO_LANGUAGE_PARAM) String to, @Query(MAX_TRANSLATIONS_PARAM) int maxTranslations,
                             @QueryMap HashMap<String,String> options);

    @FormUrlEncoded
    @POST("/GetTranslationsArray")
    GetTranslationsArrayResponse getTranslationsArray(@Field(WORDS_PARAM) List<String> words,
                                                      @Field(FROM_LANGUAGE_PARAM) String from,
                                                      @Field(TO_LANGUAGE_PARAM) String to,
                                                      @Field(MAX_TRANSLATIONS_PARAM) int maxTranslations,
                                                      @FieldMap HashMap<String,String> options);

}
