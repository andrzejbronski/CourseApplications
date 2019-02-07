package data;

import java.time.LocalDate;
import java.util.Objects;

public class Magazine extends Publication {

    private static final long serialVersionUID = 2061400934707882805L;//ID serializowanej klasy

    private int month;
    private int day;
    private String language;

    public int getMonth() {
        return getDate().getMonthValue();
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return getDate().getDayOfMonth();
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Magazine(String title, String publisher, int year, int month, int day, String language) {

        super(year, title, publisher); //wywołanie konstruktora z Publication.class
        this.setLanguage(language);
        setDate(LocalDate.of(year,month,day));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Magazine)) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return month == magazine.month &&
                day == magazine.day &&
                Objects.equals(language, magazine.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), month, day, language);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(getTitle());
        sb.append("; ");
        sb.append(getPublisher());
        sb.append("; ");
        sb.append(getYear());
        sb.append("; ");
        sb.append(getMonth());
        sb.append("; ");
        sb.append(getDay());
        sb.append("; ");
        sb.append(getLanguage());
        return sb.toString();

    }

}
