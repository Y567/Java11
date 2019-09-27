package test_9_10;

public class Aircle {
    String title;
    String author;
    String content;
    String publishedAt;

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(!(obj instanceof Aircle)){
            return false;
        }
        Aircle o = (Aircle)obj;
        if(o.title.equals(this.title) && o.author.equals(this.author) && this.content.equals(this.content) && o.publishedAt.equals(this.content)){
            return true;
        }
        return false;
    }
}
