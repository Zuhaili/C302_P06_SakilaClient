package sg.edu.rp.c346.id19004781.c302_p06_sakilaclient;

public class Film {
    private String title;
    private Integer year;
    private String rating;

    public Film(String title, Integer year, String rating){
        this.title = title;
        this.year = year;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
