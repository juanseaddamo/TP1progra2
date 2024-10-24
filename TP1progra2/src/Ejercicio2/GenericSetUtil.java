package Ejercicio2;

public class GenericSetUtil {

    public static <T> GenericSet<T> copy(GenericSet<T> set) {
        GenericSet<T> aux = new StaticGenericSet<>();
        GenericSet<T> aux2 = new StaticGenericSet<>();
        while (!set.isEmpty()) {
            T element = set.choose();
            aux.add(element);
            aux2.add(element);
            set.remove(element);
        }
        while (!aux2.isEmpty()) {
            T element = aux2.choose();
            set.add(element);
            aux2.remove(element);
        }
        return aux;
    }

    public static <T> void print(GenericSet<T> set) {
        GenericSet<T> copy = copy(set);
        //siempre que use el choose, y luego lo necesite usar lo guardo en una variable
        while (!copy.isEmpty()) {
            T element = copy.choose();
            System.out.println(element);
            copy.remove(element);
        }
    }

}
