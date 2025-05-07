package chat.logger;

import java.io.FileReader;
import java.io.FileWriter;

/*todo
    Логгер
 */

public class Logger implements Logging {
    public static final String LOG_PATH = "src/main/java/chat/logger/log.txt";

    public Logger() {

    }

    @Override
    public String readLog() {
        //подключаемся к файлу, читаем его, возвращаем строку
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH)) {
            int c;
            while ((c = reader.read()) != 1) {
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
            return stringBuilder.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public String getLog() {
        //метод запрашивает историю переписки
        return readLog();
    }


    @Override
    public void saveInLog(String text) {
        try(FileWriter writer = new FileWriter(LOG_PATH,true)) {
            writer.write(text);
            writer.write("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
