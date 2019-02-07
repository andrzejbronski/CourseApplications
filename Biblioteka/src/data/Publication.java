package data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Publication implements Serializable, Comparable<Publication> {
    private static final long serialVersionUID=7910452641164094454L;//ID serializowanej klasy

    private LocalDate date;
    private String title;
    private String publisher;



    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

  public int getYear(){
        return date.getYear();
  }

    protected Publication(int releaseYear, String title, String publisher) {
        setDate(LocalDate.of(releaseYear,1,1));
        setTitle(title);
        setPublisher(publisher);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publication)) return false;
        Publication that = (Publication) o;
        return Objects.equals(date, that.date) &&
                Objects.equals(title, that.title) &&
                Objects.equals(publisher, that.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, title, publisher);
    }
    @Override
    public int compareTo(Publication o){
        return title.compareTo(o.getTitle());
    }

}
