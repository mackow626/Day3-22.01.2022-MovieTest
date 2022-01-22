import company.Actor;
import company.Director;
import company.Movie;
import company.MovieTypeEnum;
import company.SexEnum;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static company.App.getAllMoviesForActor;
import static company.App.searchMovieByTitle;

public class MovieDBTest {
    List<Movie> movieList = new ArrayList<>();
    List<Director> directorList = new ArrayList<>();
    List<Actor> actorList = new ArrayList<>();

    @BeforeClass
    public void dataSetup() {
        dataPreparation();
    }

    @Test
    public void shouldFindMovieByTitle() {
        Movie movie = searchMovieByTitle(movieList, movieList.stream().findAny().orElseThrow().getTitle());
        Assert.assertNotNull(movie);
    }

    @Test
    public void shouldNotFindMovieByTitle() {
        Movie movie = searchMovieByTitle(movieList, "Titanic1");
        Assert.assertNull(movie);
    }

    @Test
    public void shouldFindAllMoviesForActor() {
        List<Movie> allMoviesForActor = getAllMoviesForActor(movieList, actorList, "Winslet");
        Assert.assertEquals(allMoviesForActor.size(), movieList.size());
    }

    @Test
    public void shouldNotFindAllMoviesForActor() {
        List<Movie> allMoviesForActor = getAllMoviesForActor(movieList, actorList, "Winslet1");
        Assert.assertTrue(allMoviesForActor.size() == 0);
    }


    private void dataPreparation() {
        Director jamesCameron = new Director("James", "Cameron", 1000, true);
        directorList.add(jamesCameron);

        Director stevenSpielberg = new Director("Steven", "Spielberg ", 300, false);
        directorList.add(stevenSpielberg);

        Actor leonardoDiCaprio = new Actor("Leonardo", "DiCaprio", 500, SexEnum.male);
        actorList.add(leonardoDiCaprio);

        Actor kateWinslet = new Actor("Kate", "Winslet", 600, SexEnum.female);
        actorList.add(kateWinslet);

        Actor sylwesterStalone = new Actor("Sylwester", "Stalone", 900, SexEnum.male);
        actorList.add(sylwesterStalone);

        Movie titanic =
            new Movie("Titanic", jamesCameron, List.of(leonardoDiCaprio, kateWinslet), LocalDate.of(1999, 10, 21), MovieTypeEnum.romantic);
        movieList.add(titanic);

        Movie rambo =
            new Movie("Rambo", stevenSpielberg, List.of(sylwesterStalone, kateWinslet), LocalDate.of(2010, 10, 21), MovieTypeEnum.action);
        movieList.add(rambo);
    }
}
