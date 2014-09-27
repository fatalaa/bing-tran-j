package hu.fatalaa.bingapi.models.submodels;

import org.simpleframework.xml.Element;

/**
 * Created by tmolnar on 9/27/14.
 */
@Element
public class Translations {
    @Element(name = "TranslationMatch")
    private TranslationMatch translationMatch;
}
