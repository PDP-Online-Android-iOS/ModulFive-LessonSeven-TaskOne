package dev.ogabek.java.model;

public class Filter {

    private String title = null;
    private boolean isExploreHave = false;
    private final boolean isSelected;

    public Filter(boolean isExploreHave, boolean isSelected) {
        this.isExploreHave = isExploreHave;
        this.isSelected = isSelected;
    }
    public Filter(String title, boolean isSelected) {
        this.title = title;
        this.isSelected = isSelected;
    }

    public String getTitle() {
        return title;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public boolean isExploreHave() {
        return isExploreHave;
    }
}
