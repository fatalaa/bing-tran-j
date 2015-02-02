package hu.fatalaa.bingapi.models.submodels;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by tmolnar on 9/27/14.
 */
@Root
public class TranslateArrayResponse {

    @Element(name = "Error", required = false)
    private String error;

    @Namespace(reference = "http://schemas.microsoft.com/2003/10/Serialization/Arrays", prefix = "a")
    @ElementList(name = "OriginalSentenceLengths", type = Integer.class, entry = "int")
    private List<Integer> originalSentenceLengths;

    @Element(name = "State", required = false)
    private String state;

    @Element(name = "TranslatedText")
    private String translatedText;

    @Namespace(reference = "http://schemas.microsoft.com/2003/10/Serialization/Arrays", prefix = "a")
    @ElementList(name = "TranslatedTextSentenceLengths", type = Integer.class, entry = "int")
    private List<Integer> translatedTextSentenceLengths;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Integer> getOriginalSentenceLengths() {
        return originalSentenceLengths;
    }

    public void setOriginalSentenceLengths(List<Integer> originalSentenceLengths) {
        this.originalSentenceLengths = originalSentenceLengths;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }

    public List<Integer> getTranslatedTextSentenceLengths() {
        return translatedTextSentenceLengths;
    }

    public void setTranslatedTextSentenceLengths(List<Integer> translatedTextSentenceLengths) {
        this.translatedTextSentenceLengths = translatedTextSentenceLengths;
    }
}
