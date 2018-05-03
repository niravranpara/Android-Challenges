public abstract class bodyItem
{
    private int id;
    private String bodyType;

    bodyItem() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public void print()
    {
        System.out.println("ID: "+ String.valueOf(id));
        System.out.println("Body Type: "+ bodyType);
    }
}
