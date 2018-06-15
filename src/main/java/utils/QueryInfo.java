package utils;

public enum QueryInfo
{
    BASE("cloud.skytap.com"),
    CREDENTIALS("credentials"),
    CONFIGURATIONS("configurations"),
    DESKTOP("desktop"),
    DESKTOPS("desktops"),
    TOKEN("_cloud_session=eyJzZXNzaW9uX2lkIjoiMTFjOGY1ZGUyYTY4OTdmYjBkMjk3ZWUwZmE5ODhiMzUiLCJfY3NyZl90b2tlbiI6InpVd2oyMENoUDJLT2gxU2xnMTI0UHFDcmsvZTM0MTJHOXJrNkpBRmlHaWM9IiwicmVicmFuZF9jdXN0b21lciI6MywidXNlciI6MTE1NTQ4LCJ0aW1lIjoxNTAyNDAyMjUxfQ%3D%3D--0e78b2b023b31239f4ff1395928272d0fb4faac4"),
    USER("user"),
    USERS("users"),
    USERNAME("SDET_candidate_c"),
    PASSWORD("ThorSky1!"),
    TEMPLATE("templates"),
    TEMPLATEID("1109637"),
    VMS("vms");

    private  String text;

    /**
     * @param text
     */
    private QueryInfo( String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
