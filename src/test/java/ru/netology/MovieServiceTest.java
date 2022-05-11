package ru.netology;

import ru.netology.manager.MovieManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieServiceTest {

    MovieManager movie = new MovieManager();

    @Test
    public void shouldSave() { //тесть на добавление нового фильма
        String[] itemsMore = new String[]{"Бладшот", "Вперед", "Джентельмены", "Человек-невидимка"};
        movie.setItems(itemsMore);
        String saveItem = "Отель Белград";
        movie.save(saveItem);

        String[] expected = new String[]{"Бладшот", "Вперед", "Джентельмены", "Человек-невидимка", "Отель Белград"};
        String[] actual = movie.getItems();
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindAll() { //тест на вывод всех фильмов в порядке добавления
        String[] itemsMore = new String[]{"Бладшот", "Вперед", "Отель Белград", "Джентельмены", "Человек-невидимка"};
        movie.setItems(itemsMore);
        movie.findAll();

        String[] expected = new String[]{"Бладшот", "Вперед", "Отель Белград", "Джентельмены", "Человек-невидимка"};
        String[] actual = movie.getItems();

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindLast() {
        String[] itemsMore = new String[]{"Бладшот", "Вперед", "Отель Белград", "Джентельмены", "Человек-невидимка"};
        movie.setItems(itemsMore);

        String[] expected = new String[]{"Человек-невидимка", "Джентельмены", "Отель Белград", "Вперед", "Бладшот"};
        String[] actual = movie.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastMoreTen() {
        String[] itemsMore = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
        movie.setItems(itemsMore);

        String[] expected = new String[]{"11", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
        String[] actual = movie.findLast();
        assertArrayEquals(expected, actual);
    }
}


