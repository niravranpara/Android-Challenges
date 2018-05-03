import java.util.ArrayList;

public class FeedItem
{
    private int id;
    private String byUser;
    private ArrayList<bodyItem> items;

    FeedItem()
    {
        byUser=new String();
        items=new ArrayList<bodyItem>();
    }

    FeedItem(int in_id , String in_byUser)
    {
        id=in_id;
        byUser=in_byUser;
        items=new ArrayList<bodyItem>();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getByUser() {
        return byUser;
    }

    public void setByUser(String byUser) {
        this.byUser = byUser;
    }

    public ArrayList<bodyItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<bodyItem> items) {
        this.items = items;
    }

    public void print()
    {
        System.out.println("ID: "+ String.valueOf(id));
        System.out.println("Username: "+ byUser);
        System.out.println("");
        for (int i=0;i<items.size();i++)
        {
            items.get(i).print();
        }

    }

}
