package baseData;

import java.io.FileReader;
import java.io.FileWriter;

public class Model implements WorkBD {

    public static final String BD_PATH = "src/main/java/baseData/bd.txt";
    private int id;
    private String text;

    public Model() {
    }

    @Override
    public boolean saveData(int id, String text) {
        try (FileWriter writer = new FileWriter(BD_PATH, true)) {
            writer.write((Integer.toString(id) + " " + text));
            writer.write("\n");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String getAllData() {
        //подключаемся к файлу, читаем его, возвращаем строку
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(BD_PATH)) {
            int c;
            while ((c = reader.read()) != 1) {
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
            return stringBuilder.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public boolean deleteData() {
        System.out.println("Данные удалены");
        return false;
    }


}

