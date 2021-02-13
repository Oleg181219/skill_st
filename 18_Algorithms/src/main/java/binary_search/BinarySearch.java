package binary_search;

import java.util.ArrayList;

public class BinarySearch
{
    private ArrayList<String> list;

    public BinarySearch(ArrayList<String> list)
    {
        this.list = list;
    }

    public int search(String query)
    {
        return search(query, 0, list.size() - 1);
    }

    private int search(String query, int from, int to)
    {
        // берем значение в середине
        int middle = (from + to) / 2;
        // если инд старта больше окончания то массив пустой. возвращаем -1
        if (to < from) {
            return -1;
        }
        // берем значение для сравнения, сравнивая строку поиска и значение в середине выборки

        int compare = query.compareTo(list.get(middle));
        // если compare равен '0' , то объект найден, возвращаем его индекс
        if (compare == 0) {
            return middle;
        }
        // если compare > '0', то рекурсией запрашиваем search но к from = middle + 1
        if (compare > 0) {
            return search(query, middle + 1, to);
        }
        // иначе  compare < '0', то рекурсией запрашиваем search но к to = middle - 1
        return search(query, from, middle - 1);

    }
}
