package dev.ogabek.java.model;

public class Feed {

    private final int profilePhoto;
    private final int picture;
    private final String time;
    private final String title;
    private final String description;

    public Feed(int profilePhoto, int picture, String time, String title, String description) {
        this.profilePhoto = profilePhoto;
        this.picture = picture;
        this.time = time;
        this.title = title;
        this.description = description;
    }

    public int getProfilePhoto() {
        return profilePhoto;
    }

    public int getPicture() {
        return picture;
    }

    public String getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
