package Task9;

/*todo
        Exchanger — точка синхронизации, позволяющая двум потокам обмениваться
    значениями. Представьте, что вы реализуете логистическое приложение — в рамках
    него двум автомобилям нужно пересечься в одной точке для обмена грузами —
    пока обмен не будет произведен, транспорт не может двинуться дальше по
    маршруту.
        Когда поток вызывает метод exchange(), а другой поток не
    готов к обмену значениями, текущий поток переходит в состояние WAITING.
    Отметим, что этот класс стоит использовать для обмена значениями между двумя
    потоками.
        Также у класса есть
    перегруженный метод exchange, который принимает время, которое поток будет
    находится в состоянии WAITING — в этом случае если процесс обмена не
    завершился, то генерируется проверяемое исключение TimeOutException.
 */

import java.util.concurrent.Exchanger;

public class Main {

    public static void main(String[] args) {
        Exchanger<String> ex = new Exchanger<>();
        new Thread(new NewThread(ex, "First message", "First Thread")).start();
        new Thread(new NewThread(ex, "Second message", "Second Thread")).start();
    }

}
