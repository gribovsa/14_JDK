public class Wildcard<T> {
    private T first;
    private T second;

    /*todo
                    Подстановочный символ (wildcard)
            В обобщённом коде знак вопроса, называемый подстановочным символом,
        означает неизвестный тип. Подстановочный символ может использоваться в
        разных ситуациях: как параметр типа, поля, локальной переменной, иногда в
        качестве возвращаемого типа.
        Но! Подстановочный символ никогда не используется
        в качестве аргумента типа для вызова обобщённого метода, создания
        экземпляра обобщённого класса или супертипа.
     */

    public Wildcard(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    //Примеры использования
    public static void printInfo(Wildcard<?> wildcard) {
        System.out.printf("Информация: аргумент first:%s, аргумент second:%s\n",
                wildcard.getFirst(), wildcard.getSecond());
    }

    public static void main(String[] args) {
        //экземпляр класса, ограниченный сверху, который работает с Number
        //и с его наследниками, т.е Integer, Double, Float
        Wildcard<? extends Number> wildcard0 = new Wildcard<>(1, 2.2f);

        //экземпляр класса, ограниченный снизу, который работает с Float
        //и с его родителем, т.е с Number
        Wildcard<? super Float> wildcard1 = new Wildcard<>(1.3f, 1);


        printInfo(wildcard0);
        printInfo(wildcard1);

    }
}
