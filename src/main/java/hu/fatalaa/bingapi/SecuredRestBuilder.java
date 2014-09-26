package hu.fatalaa.bingapi;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import retrofit.*;
import retrofit.client.Client;
import retrofit.client.OkClient;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.converter.Converter;
import retrofit.mime.FormUrlEncodedTypedOutput;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.concurrent.Executor;

/**
 * Created by tmolnar on 9/26/14.
 */
public class SecuredRestBuilder extends RestAdapter.Builder {

    private class OAuthHandler implements RequestInterceptor {

        private Client client;
        private String tokenIssuingEndpoint;
        private String clientId;
        private String clientSecret;
        private String accessToken;
        private Calendar expiration;

        public OAuthHandler(Client client, String tokenIssuingEndpoint, String clientId, String clientSecret) {
            super();
            this.client = client;
            this.tokenIssuingEndpoint = tokenIssuingEndpoint;
            this.clientId = clientId;
            this.clientSecret = clientSecret;
        }

        @Override
        public void intercept(RequestFacade originalRequest) {
            if (expiration == null || expiration.before(Calendar.getInstance())) {
                try {
                    FormUrlEncodedTypedOutput typedOutput = new FormUrlEncodedTypedOutput();
                    typedOutput.addField("grant_type", "client_credentials");
                    typedOutput.addField("client_id", clientId);
                    typedOutput.addField("client_secret", clientSecret);
                    typedOutput.addField("scope", "http://api.microsofttranslator.com");

                    Request authRequest = new Request("POST", tokenIssuingEndpoint, null, typedOutput);
                    Response response = client.execute(authRequest);

                    if (response.getStatus() < 200 || response.getStatus() >= 300 ) {
                        throw new RuntimeException("Login failed");
                    }
                    Gson gson = new Gson();
                    JsonObject responseJson = gson.fromJson(new InputStreamReader(response.getBody().in()),
                                                            JsonObject.class);
                    accessToken = responseJson.get("access_token").getAsString();

                    int expiresIn  = responseJson.get("expires_in").getAsInt();
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.SECOND, expiresIn);
                    expiration = calendar;
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            originalRequest.addHeader("Authorization", "Bearer " + accessToken );
        }
    }

    private String loginUrl;
    private String clientId;
    private String clientSecret = "";
    private Client client;

    public SecuredRestBuilder setLoginEndpoint(String endpoint){
        loginUrl = endpoint;
        return this;
    }

    public SecuredRestBuilder setClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public SecuredRestBuilder setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
        return this;
    }

    @Override
    public SecuredRestBuilder setClient(Client client) {
        this.client = client;
        return (SecuredRestBuilder) super.setClient(client);
    }

    @Override
    public SecuredRestBuilder setClient(Client.Provider clientProvider) {
        client = clientProvider.get();
        return (SecuredRestBuilder) super.setClient(clientProvider);
    }

    @Override
    public SecuredRestBuilder setErrorHandler(ErrorHandler errorHandler) {

        return (SecuredRestBuilder) super.setErrorHandler(errorHandler);
    }

    @Override
    public SecuredRestBuilder setExecutors(Executor httpExecutor,
                                           Executor callbackExecutor) {

        return (SecuredRestBuilder) super.setExecutors(httpExecutor,
                callbackExecutor);
    }

    @Override
    public SecuredRestBuilder setRequestInterceptor(
            RequestInterceptor requestInterceptor) {

        return (SecuredRestBuilder) super
                .setRequestInterceptor(requestInterceptor);
    }

    @Override
    public SecuredRestBuilder setConverter(Converter converter) {

        return (SecuredRestBuilder) super.setConverter(converter);
    }

    @Override
    public SecuredRestBuilder setProfiler(@SuppressWarnings("rawtypes") Profiler profiler) {

        return (SecuredRestBuilder) super.setProfiler(profiler);
    }

    @Override
    public SecuredRestBuilder setLogLevel(RestAdapter.LogLevel logLevel) {

        return (SecuredRestBuilder) super.setLogLevel(logLevel);
    }

    @Override
    public SecuredRestBuilder setEndpoint(String endpoint) {
        return (SecuredRestBuilder) super.setEndpoint(endpoint);
    }

    @Override
    public SecuredRestBuilder setEndpoint(Endpoint endpoint) {
        return (SecuredRestBuilder) super.setEndpoint(endpoint);
    }

    @Override
    public RestAdapter build() {
        if (clientId == null || clientSecret == null) {
            throw new IllegalArgumentException("The client ID and the client secret cannot be null");
        }
        if (client == null) {
            client = new OkClient();
        }
        OAuthHandler oAuthHandler = new OAuthHandler(client, loginUrl, clientId, clientSecret);
        setRequestInterceptor(oAuthHandler);
        return super.build();
    }
}
