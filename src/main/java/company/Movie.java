package company;

import java.time.LocalDate;
import java.util.List;

public class Movie {
    String title;
    Director director;
    List<Actor> actorList;
    LocalDate premierDate;
    MovieTypeEnum movieTypeEnum;

    @Override
    public String toString() {
        return "Movie{" +
            "title='" + title + '\'' +
            ", director=" + director +
            ", actorList=" + actorList +
            ", premierDate=" + premierDate +
            ", movieTypeEnum=" + movieTypeEnum +
            '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Actor> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
    }

    public LocalDate getPremierDate() {
        return premierDate;
    }

    public void setPremierDate(LocalDate premierDate) {
        this.premierDate = premierDate;
    }

    public MovieTypeEnum getMovieType() {
        return movieTypeEnum;
    }

    public void setMovieType(MovieTypeEnum movieTypeEnum) {
        this.movieTypeEnum = movieTypeEnum;
    }

    public Movie(String title, Director director, List<Actor> actorList, LocalDate premierDate, MovieTypeEnum movieTypeEnum) {
        this.title = title;
        this.director = director;
        this.actorList = actorList;
        this.premierDate = premierDate;
        this.movieTypeEnum = movieTypeEnum;
    }
}
