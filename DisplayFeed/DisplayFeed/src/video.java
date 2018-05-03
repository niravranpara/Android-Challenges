public class video extends bodyItem
{
    private String mediaLocation;

    video(){}

    public String getMediaLocation() {
        return mediaLocation;
    }

    public void setMediaLocation(String mediaLocation) {
        this.mediaLocation = mediaLocation;
    }

    public void print()
    {
        super.print();
        System.out.println(("Media Location: " + mediaLocation ));
        System.out.println((""));

    }

}
