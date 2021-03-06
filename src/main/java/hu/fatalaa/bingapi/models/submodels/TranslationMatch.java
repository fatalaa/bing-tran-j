package hu.fatalaa.bingapi.models.submodels;

import org.simpleframework.xml.Element;

/**
 * Created by tmolnar on 9/27/14.
 */
@Element
public class TranslationMatch {

    @Element(name = "Error", required = false)
    private String error;

    @Element(name = "Count")
    private int count;

    @Element(name = "MatchDegree")
    private int matchDegree;

    @Element(name = "MatchedOriginalText", required = false)
    private String matchedOriginalText;

    @Element(name = "Rating")
    private int rating;

    @Element(name = "TranslatedText")
    private String translatedText;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMatchDegree() {
        return matchDegree;
    }

    public void setMatchDegree(int matchDegree) {
        this.matchDegree = matchDegree;
    }

    public String getMatchedOriginalText() {
        return matchedOriginalText;
    }

    public void setMatchedOriginalText(String matchedOriginalText) {
        this.matchedOriginalText = matchedOriginalText;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }
}
