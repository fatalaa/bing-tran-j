package hu.fatalaa.bingapi.models;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by tmolnar on 9/27/14.
 */
@Root
@ElementList(type = TranslateArrayResponse.class)
@NamespaceList({
        @Namespace(reference = "http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2"),
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "i")
})
public class GetTranslationsArrayResponse {
    private List<TranslateArrayResponse> translateArrayResponses;

    public List<TranslateArrayResponse> getTranslateArrayResponses() {
        return translateArrayResponses;
    }

    public void setTranslateArrayResponses(List<TranslateArrayResponse> translateArrayResponses) {
        this.translateArrayResponses = translateArrayResponses;
    }
}
