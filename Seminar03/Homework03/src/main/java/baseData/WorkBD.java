package baseData;

public interface WorkBD {
    boolean saveData(int id, String text);
    String getAllData();
    boolean deleteData();
}
