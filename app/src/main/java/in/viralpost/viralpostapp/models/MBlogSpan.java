package in.viralpost.viralpostapp.models;

/**
 * Created by pbengani on 9/29/2015.
 */
public class MBlogSpan {

    public enum TYPE {URL, USER, INSTI, HASHTAG};

    private int start;
    private int end;
    private TYPE type;
    private String data;

    public MBlogSpan(int start, int end, TYPE type, String data){
        this.start = start;
        this.end = end;
        this.type = type;
        this.data = data;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public TYPE getType() {
        return type;
    }

    public String getData() {
        return data;
    }

}
