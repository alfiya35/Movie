package ru.netology;

import ru.netology.domian.MovieItem;
import ru.netology.manager.MovieManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieServiceTest {
    MovieItem first = new MovieItem(1, "Блашдот", "боевик");
    MovieItem second = new MovieItem(2, "Вперед", "мультфильм");
    MovieItem third = new MovieItem(3, "Отель Белград", "комедия");
    MovieItem fourth = new MovieItem(4, "Джентельмены", "боевик");
    MovieItem fifth = new MovieItem(5, "Человек-невидимка", "ужасы");
    MovieItem sixth = new MovieItem(6, "Тролли.Мировой тур", "мультфильм");
    MovieItem seventh = new MovieItem(7, "Номер один", "комедия");


    @Test
    public void shouldSave() { //тесть на добавление нового фильма
        MovieManager movie = new MovieManager();
        movie.save(first);
        movie.save(second);
        movie.save(third);
        movie.save(fourth);
        movie.save(fifth);
        movie.save(sixth);
        movie.save(seventh);


    }

    @Test
    public void shouldFindAll() { //тест на вывод всех фильмов в порядке добавления
        MovieManager movie = new MovieManager();
        movie.save(first);
        movie.save(second);
        movie.save(third);
        movie.save(fourth);
        movie.save(fifth);
        movie.save(sixth);
        movie.save(seventh);

        MovieItem[]expected = new MovieItem[] {first,second,third,fourth,fifth,sixth,seventh};
        MovieItem[] actual =  movie.findAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    void setFindLastDefault() {
        MovieManager movie = new MovieManager();
        int expected = 10;
        movie.setLimitManager(10);
        assertEquals(expected, movie.getLimitManager());
    }
    @Test
    void setFindLastAmount() {
            MovieManager movie = new MovieManager(5);
        }
    @Test
    void  shouldFindLast(){
        MovieManager movie = new MovieManager(11);
        movie.save(first);
        movie.save(second);
        movie.save(third);
        movie.save(fourth);
        movie.save(fifth);
        movie.save(sixth);
        movie.save(seventh);
        MovieItem[]expected = new MovieItem[] {seventh,sixth,fifth,fourth,third,second,first};
        MovieItem[] actual =  movie.findLast();
        assertArrayEquals(expected, actual);
    }
}


