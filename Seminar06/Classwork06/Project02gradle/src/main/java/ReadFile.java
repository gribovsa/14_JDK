
/*todo
    Из папки ресурсов требуется прочитать файл
 */


import java.io.IOException;
import java.io.InputStream;

public class ReadFile {
    public static void main(String[] args) {
        System.out.println(new ReadFile().readFile());
    }

    public String readFile(){
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("test.txt");
        try (inputStream){
            String textFile = new String(inputStream.readAllBytes());
            return textFile;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
