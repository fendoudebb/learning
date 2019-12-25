package structure.composite;

public class Client {

    public static void main(String[] args) {
        University university = new University("加州大学洛杉矶分校", "UCLA");

        College softwareCollege = new College("软件学院", "Software College");
        College informationCollege = new College("信息学院", "Information College");

        university.add(softwareCollege);
        university.add(informationCollege);

        softwareCollege.add(new Department("软件工程","Software Engineering"));
        softwareCollege.add(new Department("网络工程","Network Engineering"));
        softwareCollege.add(new Department("计算机科学与技术","Computer Science and Technology"));

        informationCollege.add(new Department("通信工程", "Communications Engineering"));
        informationCollege.add(new Department("信息工程", "Information Engineering"));

        university.print();
    }

}
