import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main {

    // Main(){}

    public static String loadJSONFromAsset(String filename) {

        String json = null;
        try {
            InputStream is = new FileInputStream(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public static ArrayList<FeedItem> getFeedItems(JSONArray jsonarray) {
        ArrayList<FeedItem> items = new ArrayList<FeedItem>();

        try {

            for (int i = 0; i < jsonarray.length(); i++) {
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                FeedItem tempFeedItem = new FeedItem(jsonobject.getInt("Id"), jsonobject.getString("username"));

                JSONArray itemlist = (JSONArray) jsonobject.get("body");

                for (int j = 0; j < itemlist.length(); j++) {
                    JSONObject jsonBodyItem = itemlist.getJSONObject(j);
                    String bodyType = jsonBodyItem.getString("bodyType");


                    if (bodyType.equals("text")) {
                        text tempBodyItem = new text();
                        tempBodyItem.setId(jsonBodyItem.getInt("Id"));
                        tempBodyItem.setBodyType(bodyType);
                        tempBodyItem.setText(jsonBodyItem.getString("text"));
                        tempFeedItem.getItems().add(tempBodyItem);
                    } else if (bodyType.equals("image")) {
                        image tempBodyItem = new image();
                        tempBodyItem.setId(jsonBodyItem.getInt("Id"));
                        tempBodyItem.setBodyType(bodyType);
                        tempBodyItem.setMediaLocation(jsonBodyItem.getString("mediaLocation"));
                        tempFeedItem.getItems().add(tempBodyItem);
                    } else {
                        video tempBodyItem = new video();
                        tempBodyItem.setId(jsonBodyItem.getInt("Id"));
                        tempBodyItem.setBodyType(bodyType);
                        tempBodyItem.setMediaLocation(jsonBodyItem.getString("mediaLocation"));
                        tempFeedItem.getItems().add(tempBodyItem);
                    }
                }

                items.add(tempFeedItem);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return items;

    }



    public static void main(String[] args) {

        String string = loadJSONFromAsset("response.json");   // here i am reading from json file but if you have a function then skip the file part


        try
        {
            JSONArray jsonarray = new JSONArray(string);
            ArrayList<FeedItem> items=getFeedItems(jsonarray);  //if you have a function that gives jsonarray then  give that array as parameter here

            for (int i=0;i<items.size();i++)    //for verification that ArrayList have all the feed items I printed the data
            {
                items.get(i).print();
                System.out.println("----------------------");
            }

        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }




    }
}