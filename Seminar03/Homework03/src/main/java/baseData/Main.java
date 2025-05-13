package baseData;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        model.saveData(100, "Секретная информация");
        model.saveData(101, "Секретная информация");
        model.saveData(102, "Секретная информация");
        model.saveData(103, "Секретная информация");

        model.loadData();
    }
}
