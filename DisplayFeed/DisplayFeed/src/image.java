public class image extends bodyItem
{
    private String mediaLocation;

    image(){}

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
