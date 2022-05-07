package ru.netology.manager;

import ru.netology.domian.MovieItem;

public class MovieManager {

    private MovieItem[] items = new MovieItem[0];

    private int LimitManager;
   private int maxLimitManager = 10;


    public int getLimitManager() {
        return LimitManager;
    }

    public void setLimitManager(int limitManager) {
        LimitManager = maxLimitManager;
    }

    public void save(MovieItem item) { //метод добавления нового фильма
        //создаем новый массив размером на еденицу больше
        int length = items.length + 1;
        MovieItem[] tmp = new MovieItem[length];
        //копируем поэлементоно
        System.arraycopy(items, 0, tmp, 0, items.length);
        //кладем последний наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public MovieItem[] findAll() {  //вывод всех фильмов в порядке добавления
        return items;
    }

    public MovieManager() {   //Конструктор по умолчанию(10 фильмов)
    }

    public MovieManager(int sumMovie) { //Конструктор с параметрами
        LimitManager = sumMovie;
    }
    public MovieItem[] findLast() {//Метод получения последних фильмов в обратном порядке
        int resultLength = items.length - maxLimitManager;
        MovieItem[] result = new  MovieItem[items.length - resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

}





