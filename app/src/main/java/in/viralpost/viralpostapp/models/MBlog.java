package in.viralpost.viralpostapp.models;

import java.util.ArrayList;

/**
 * Created by pbengani on 9/29/2015.
 */
public class MBlog {

    private long id;
    private String username;

    private String contents;
    private ArrayList<MBlogSpan> spans;

    private String picurl;

    private String time_elapsed;

    private int num_persons_starmarked_cached;
    private int num_persons_replied_cached;
    private int num_persons_plusoned_cached;

    private boolean logged_in_user_starmarked;
    private boolean logged_in_user_plusoned;

    private String lastactivity_hint;
    private String lastactivity_action_text;
    private String lastactivity_person;

    private ArrayList<String> hashtags;
    private ArrayList<String> persontags;
    private ArrayList<String> institutions;

    public MBlog(MBlogBuilder builder) {
        this.id = builder.getId();
        this.username = builder.getUsername();

        this.contents = builder.getContents();
        this.spans = builder.getSpans();

        this.picurl = builder.getPicurl();

        this.time_elapsed = builder.getTime_elapsed();

        this.num_persons_starmarked_cached = builder.getNum_persons_starmarked_cached();
        this.num_persons_replied_cached = builder.getNum_persons_replied_cached();
        this.num_persons_plusoned_cached = builder.getNum_persons_plusoned_cached();

        this.logged_in_user_starmarked = builder.isLogged_in_user_starmarked();
        this.logged_in_user_plusoned = builder.isLogged_in_user_plusoned();

        this.lastactivity_hint = builder.getLastactivity_hint();
        this.lastactivity_action_text = builder.getLastactivity_action_text();
        this.lastactivity_person = builder.getLastactivity_person();

        this.hashtags = builder.getHashtags();
        this.persontags = builder.getPersontags();
        this.institutions = builder.getInstitutions();

    }

    public ArrayList<String> getInstitutions() {
        return institutions;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getContents() {
        return contents;
    }

    public ArrayList<MBlogSpan> getSpans() {
        return spans;
    }

    public String getPicurl() {
        return picurl;
    }

    public String getTime_elapsed() {
        return time_elapsed;
    }

    public int getNum_persons_starmarked_cached() {
        return num_persons_starmarked_cached;
    }

    public int getNum_persons_replied_cached() {
        return num_persons_replied_cached;
    }

    public int getNum_persons_plusoned_cached() {
        return num_persons_plusoned_cached;
    }

    public boolean isLogged_in_user_starmarked() {
        return logged_in_user_starmarked;
    }

    public boolean isLogged_in_user_plusoned() {
        return logged_in_user_plusoned;
    }

    public String getLastactivity_hint() {
        return lastactivity_hint;
    }

    public String getLastactivity_action_text() {
        return lastactivity_action_text;
    }

    public String getLastactivity_person() {
        return lastactivity_person;
    }

    public ArrayList<String> getHashtags() {
        return hashtags;
    }

    public ArrayList<String> getPersontags() {
        return persontags;
    }

    @Override
    public String toString() {
        String cons = (getContents() == null) ? "": getContents();
        String pic = (getPicurl() == null) ? "":getPicurl();

        return getId() + " - " + getUsername() + " - " + cons + " - " + pic + " - " + getTime_elapsed();
    }

}
