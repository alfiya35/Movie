package ru.netology.manager;

public class MovieManager {

    private String[] items = new String[0];

    private int limitLength = 10;

    //Конструкторы
    public MovieManager() {   //Конструктор по умолчанию(10 фильмов)
    }


    public MovieManager(int limitLength) { //Конструктор с параметрами
        this.limitLength = limitLength;
    }

    //Геттеры и сеттеры

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    public int getLimitLength() {
        return limitLength;
    }

    public void setLimitLength(int limitLength) {
        this.limitLength = limitLength;
    }

    public void save(String item) { //метод добавления нового фильма
        //создаем новый массив размером на еденицу больше
        int length = items.length + 1;
        String[] tmp = new String[length];
        //копируем поэлементоно
        System.arraycopy(items, 0, tmp, 0, items.length);
        //кладем последний наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public String[] findAll() {  //вывод всех фильмов в порядке добавления
        return items;
    }


    public String[] findLast() {//Метод получения последних фильмов в обратном порядке
        int resultLength = items.length;
        if (resultLength > limitLength) {
            resultLength = limitLength;
        }

        String[] result = new String[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

}





