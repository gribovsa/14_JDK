package baseData;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Model implements WorkBD {

    public static final String BD_PATH = "src/main/java/baseData/bd.txt";
    private int id;
    private String text;

    public Model() {
    }

    @Override
    public boolean saveData(int id, String text) {
        Charset code = StandardCharsets.UTF_8;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BD_PATH, code, true))) {
            writer.write((Integer.toString(id) + "," + text));
            writer.write("\n");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public void loadData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(BD_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) { //если строка не пустая
                String[] arr = line.split(",");
                //return String.format("Запись ID: %s, text: %s", arr[0], arr[1]);
                System.out.println(String.format("Запись ID: %s, text: %s", arr[0], arr[1]));
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }

    }

    @Override
    public boolean deleteData() {
        System.out.println("Данные удалены");
        return false;
    }


}

