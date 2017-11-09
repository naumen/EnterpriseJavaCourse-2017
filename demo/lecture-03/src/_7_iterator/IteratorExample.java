package _7_iterator;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

public class IteratorExample {

    class MyTree<E>{}
    class MyList<E>{}

    void printAllElements(MyTree<String> tree) {
        // алгоритм обход дерева и на каждом элементе вызываем 1 раз нужный нам функционал
        System.out.println(element);
    }

    void printAllElements(MyTree<String> tree) {
        // проходим по списку и вызываем на нем нужный функционал
        System.out.println(element);
    }

    void printAllElements(List<String> tree) {

    }

    void printAllElements(Collection<String> coll) {
        for (String s : coll) {
            System.out.println(s);
        }
    }

}
