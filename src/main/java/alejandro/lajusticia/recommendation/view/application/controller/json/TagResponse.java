package alejandro.lajusticia.recommendation.view.application.controller.json;

import java.util.List;

public class TagResponse {

    private String tag;
    private List<String> potentialTags;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<String> getPotentialTags() {
        return potentialTags;
    }

    public void setPotentialTags(List<String> potentialTags) {
        this.potentialTags = potentialTags;
    }

}
