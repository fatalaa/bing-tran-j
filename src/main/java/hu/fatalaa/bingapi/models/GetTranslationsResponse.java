package hu.fatalaa.bingapi.models;

import hu.fatalaa.bingapi.models.submodels.Translations;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * Created by tmolnar on 9/27/14.
 */
@Root
@NamespaceList({
        @Namespace(reference = "http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2"),
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "i")
})
public class GetTranslationsResponse {
    @Element(name = "From")
    private String from;

    @Element(name = "State", required = false)
    private String state;

    @Element(name = "Translations")
    private Translations translations;
}
