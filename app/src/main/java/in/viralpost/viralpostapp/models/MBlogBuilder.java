package in.viralpost.viralpostapp.models;

import java.util.ArrayList;

/**
 * Created by pbengani on 9/29/2015.
 */
public class MBlogBuilder {
    private long id;
    private String username;

    private String contents;
    private ArrayList<MBlogSpan> spans = new ArrayList<>();

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

    private ArrayList<String> hashtags = new ArrayList<>();
    private ArrayList<String> persontags = new ArrayList<>();
    private ArrayList<String> institutions = new ArrayList<>();

    public MBlog build() {
        return new MBlog(this);
    }

    public MBlogBuilder() {};

    public MBlogBuilder builder1(long id, String username, String contents, ArrayList<MBlogSpan> spans, String picurl, String time_elapsed) {
        this.id = id;
        this.username = username;
        this.contents = (contents.trim().equals("")) ? null:contents;
        this.picurl = picurl;
        this.time_elapsed = time_elapsed;
        this.spans = spans;
        return this;
    }

    public MBlogBuilder builder2(int num_persons_starmarked_cached, int num_persons_replied_cached, int num_persons_plusoned_cached) {
        this.num_persons_starmarked_cached = num_persons_starmarked_cached;
        this.num_persons_replied_cached = num_persons_replied_cached;
        this.num_persons_plusoned_cached = num_persons_plusoned_cached;
        return this;
    }

    public MBlogBuilder builder3(boolean logged_in_user_starmarked, boolean logged_in_user_plusoned) {
        this.logged_in_user_starmarked = logged_in_user_starmarked;
        this.logged_in_user_plusoned = logged_in_user_plusoned;
        return this;
    }

    public MBlogBuilder builder4(String lastactivity_hint, String lastactivity_action_text, String lastactivity_person) {
        this.lastactivity_hint = lastactivity_hint;
        this.lastactivity_action_text = lastactivity_action_text;
        this.lastactivity_person = lastactivity_person;
        return this;
    }

    public MBlogBuilder builder5(ArrayList<String> hashtags, ArrayList<String> persontags, ArrayList<String> institutions) {
        this.hashtags = hashtags;
        this.persontags = persontags;
        this.institutions = institutions;
        return this;
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
}
