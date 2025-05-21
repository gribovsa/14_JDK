
/*todo
        В рамках выполнения задачи необходимо:
    ● Создать свой Java Maven проект;
    ● Добавьте зависимость commons-math3 https://mvnrepository.com/artifact/org.apache.commons/commons-math3
    (предназначена для решения математических задач) и изучить интерфейс библиотеки
    ● Воспользоваться пакетом org.apache.commons.math3.stat и классом
    DescriptiveStatistics.
    ○ Создать коллекцию из числовых элементов.
    ○ С помощью объекта DescriptiveStatistics вычислить минимальное и
    максимальное значение, сумму и среднее арифметическое.
    ● Воспользоваться пакетом org.apache.commons.math3.util. С помощью класса
    ArithmeticUtils найти :
    ○ факториал числа N.
    ○ Наименьшее общее частное двух чисел
    ○ Наибольший общий делитель двух чисел
    ○ Проверить что число N это степень двойки
    P.S. Репозиторий где качать библиотеки: mvnrepository.com
 */


import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.util.ArithmeticUtils;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        double []array = {1,2,3,4,5,6,7,8,9,10};
        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics(array);
        System.out.println(Arrays.toString(array));
        System.out.println("Минимальное значение: " + descriptiveStatistics.getMin());
        System.out.println("Максимальное значение: " + descriptiveStatistics.getMax());
        System.out.println("Сумма: " + descriptiveStatistics.getSum());
        System.out.println("Среднее арифметическое: " + descriptiveStatistics.getMean());

        System.out.println("Факториал" + ArithmeticUtils.factorial(5));
        System.out.println("Наименьшее общее частное двух чисел: " + ArithmeticUtils.lcm(15,25));
        System.out.println("Наибольший общий делитель двух чисел: " + ArithmeticUtils.gcd(10, 30));
        System.out.println("Проверить что число N это степень двойки: " + ArithmeticUtils.isPowerOfTwo(4));
    }
}

/*
В файле pom.xml добавляем записи <dependencies>

<properties>
        <maven.compiler.source>22</maven.compiler.source>
        <maven.compiler.target>22</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <commons-math3.version>3.6.1</commons-math3.version>
    </properties>


<dependencies>
        <!-- https://mvnrepository.com/artifact/org.apache.commons/commons-math3 -->
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-math3</artifactId>
            <version>${commons-math3.version}</version>
        </dependency>
    </dependencies>
 */
