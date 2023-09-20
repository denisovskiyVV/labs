import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Базовый класс для тарифов
class Tariff implements Serializable {
    private String name;
    private double price;

    public Tariff(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tariff{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

// Класс Мобильная компания
class MobileCompany implements Serializable {
    private List<Tariff> tariffs;

    public MobileCompany() {
        tariffs = new ArrayList<>();
    }

    public void addTariff(Tariff tariff) {
        tariffs.add(tariff);
    }

    public int getTotalClients() {
        // Здесь вы можете реализовать логику подсчета общего числа клиентов на основе тарифов
        return tariffs.size() * 100; // Простой пример, где каждый тариф имеет 100 клиентов
    }

    @Override
    public String toString() {
        return "MobileCompany{" +
                "tariffs=" + tariffs +
                '}';
    }

    // Сериализация компании в файл
    public void serialize(String fileName) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(this);
        }
    }

    // Десериализация компании из файла
    public static MobileCompany deserialize(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (MobileCompany) inputStream.readObject();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Создание тарифов
        Tariff tariff1 = new Tariff("Тариф 1", 10.0);
        Tariff tariff2 = new Tariff("Тариф 2", 15.0);

        // Создание мобильной компании и добавление тарифов
        MobileCompany mobileCompany = new MobileCompany();
        mobileCompany.addTariff(tariff1);
        mobileCompany.addTariff(tariff2);

        // Сериализация компании в файл
        try {
            mobileCompany.serialize("mobile_company.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Десериализация компании из файла
        try {
            MobileCompany loadedCompany = MobileCompany.deserialize("mobile_company.ser");
            System.out.println("Loaded Company: " + loadedCompany);
            System.out.println("Total Clients: " + loadedCompany.getTotalClients());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}