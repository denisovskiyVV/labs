import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.io.*;

// Интерфейс RMI
interface MyRemoteInterface extends Remote {
    void remoteMethod(MySerializableClass obj) throws RemoteException;
}

// Сериализуемый класс
class MySerializableClass implements Serializable {
    private String data;

    public MySerializableClass(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "MySerializableClass{" +
                "data='" + data + '\'' +
                '}';
    }
}

// Реализация сервера RMI
class MyRMIServer implements MyRemoteInterface {s

    protected MyRMIServer() throws RemoteException {}

    @Override
    public void remoteMethod(MySerializableClass obj) throws RemoteException {
        System.out.println("Received object on server: " + obj.toString());
    }

    public static void main(String[] args) {
        try {
            // Создание сервера без наследования UnicastRemoteObject
            MyRMIServer server = new MyRMIServer();

            // Экспортирование (регистрация) удаленного объекта
            MyRemoteInterface stub = (MyRemoteInterface) UnicastRemoteObject.exportObject(server, 0);

            // Создание RMI-реестра на порту 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // Регистрация удаленного объекта под именем "MyRemoteObject"
            registry.rebind("MyRemoteObject", stub);

            System.out.println("Server is ready...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Клиент RMI (без изменений)
class MyRMIClient {

    public static void main(String[] args) {
        try {
            // Подключение к RMI-реестру на сервере
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Получение удаленного объекта
            MyRemoteInterface remoteObject = (MyRemoteInterface) registry.lookup("MyRemoteObject");

            // Создание объекта для передачи
            MySerializableClass myObject = new MySerializableClass("Hello from client!");

            // Вызов удаленного метода и передача объекта
            remoteObject.remoteMethod(myObject);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}