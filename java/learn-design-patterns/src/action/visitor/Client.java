package action.visitor;

public class Client {

    public static void main(String[] args) {
        ObjectStructure os = new ObjectStructure();
        os.attach(new Man());
        os.attach(new Woman());
        Success success = new Success();
        os.display(success);
        System.out.println("-------");
        Fail fail = new Fail();
        os.display(fail);
    }

}
