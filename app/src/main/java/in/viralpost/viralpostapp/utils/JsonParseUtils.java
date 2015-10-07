package in.viralpost.viralpostapp.utils;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import in.viralpost.viralpostapp.models.MBlog;
import in.viralpost.viralpostapp.models.MBlogBuilder;
import in.viralpost.viralpostapp.models.MBlogSpan;

/**
 * Created by pbengani on 9/29/2015.
 */
public class JsonParseUtils {

    private static final String TAG = "JsonParseUtils";

    public static MBlog getMblog(JSONObject mblogJsonObject) {

        try {
            long id = mblogJsonObject.getLong("id");
            String username = mblogJsonObject.getString("username");

            String contents = mblogJsonObject.getString("contents");
            ArrayList<MBlogSpan> spans = getMBlogSpanList(mblogJsonObject);

            String picurl = (mblogJsonObject.isNull("picurl")) ? null : mblogJsonObject.getString("picurl");

            String time_elapsed = mblogJsonObject.getString("time_elapsed");

            int num_persons_starmarked_cached = mblogJsonObject.getInt("num_persons_starmarked_cached");
            int num_persons_replied_cached = mblogJsonObject.getInt("num_persons_replied_cached");
            int num_persons_plusoned_cached = mblogJsonObject.getInt("num_persons_plusoned_cached");

            boolean logged_in_user_starmarked = mblogJsonObject.getBoolean("logged_in_user_starmarked");
            boolean logged_in_user_plusoned = mblogJsonObject.getBoolean("logged_in_user_plusoned");

            String lastactivity_hint = mblogJsonObject.getString("lastactivity_hint");
            String lastactivity_action_text = mblogJsonObject.getString("lastactivity_action_text");
            String lastactivity_person = mblogJsonObject.getString("lastactivity_person");

            // TODO hashtags and persontags
            ArrayList<String> hashtags = new ArrayList<>();
            ArrayList<String> persontags = new ArrayList<>();

            ArrayList<String> institutions = new ArrayList<>();
            // "institutions": [{"display_name": "bits-p"}, {"display_name": "oracle"}, {"display_name": "a.com"}]}]

            JSONArray institutionsJsonArray = mblogJsonObject.getJSONArray("institutions");
            for (int i = 0; i < institutionsJsonArray.length(); i++) {
                JSONObject institutionJsonObject = (JSONObject) institutionsJsonArray.get(i);
                String display_name = institutionJsonObject.getString("display_name");
                institutions.add(display_name);
            }

            return new MBlogBuilder()
                    .builder1(id, username, contents, spans, picurl, time_elapsed)
                    .builder2(num_persons_starmarked_cached, num_persons_replied_cached, num_persons_plusoned_cached)
                    .builder3(logged_in_user_starmarked, logged_in_user_plusoned)
                    .builder4(lastactivity_hint, lastactivity_action_text, lastactivity_person)
                    .builder5(hashtags, persontags, institutions)
                    .build();

        } catch (JSONException e) {
            e.printStackTrace();
            Log.e(TAG, "JSONException caught: " + e.toString());
            return null;
        }

    }

    public static ArrayList<MBlogSpan> getMBlogSpanList(JSONObject mblogJsonObject) {

        ArrayList<MBlogSpan> spans = new ArrayList<>();
        JSONArray links_data = null;
        try {
            links_data = mblogJsonObject.getJSONArray("links_data");
            for (int i = 0; i < links_data.length(); i++) {
                JSONObject link_data = links_data.getJSONObject(i);
                String type = link_data.getString("type");
                MBlogSpan.TYPE type1;
                if (type.equalsIgnoreCase("URL")) {
                    type1 = MBlogSpan.TYPE.URL;
                } else if (type.equalsIgnoreCase("USER")) {
                    type1 = MBlogSpan.TYPE.USER;
                } else if (type.equalsIgnoreCase("INSTI")) {
                    type1 = MBlogSpan.TYPE.INSTI;
                } else if (type.equalsIgnoreCase("HASHTAG")) {
                    type1 = MBlogSpan.TYPE.HASHTAG;
                } else {
                    Log.d(TAG, "Wrong type received: " + type);
                    continue;
                }

                spans.add(new MBlogSpan(link_data.getInt("start"), link_data.getInt("end"), type1, link_data.getString("data")));

            }

        } catch (JSONException e) {
            e.printStackTrace();
            Log.e(TAG, "JSONException caught: " + e.toString());
        }

        return spans;
    }


}
