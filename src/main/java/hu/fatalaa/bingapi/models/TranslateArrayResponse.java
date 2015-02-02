package hu.fatalaa.bingapi.models;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * Created by tmolnar on 9/27/14.
 */
@Root(name = "ArrayOfTranslateArrayResponse")
@NamespaceList({
        @Namespace(reference = "http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2"),
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "i")
}
)
@ElementList(type = hu.fatalaa.bingapi.models.submodels.TranslateArrayResponse.class,
             name = "ArrayOfTranslateArrayResponse",
             entry = "TranslateArrayResponse")
public class TranslateArrayResponse {
}
