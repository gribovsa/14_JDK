package baseData;

public interface WorkBD {
    boolean saveData(int id, String text);
    void loadData();
    boolean deleteData();
}
