package action.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        List<College> colleges = new ArrayList<>();

        ComputerCollege computerCollege = new ComputerCollege();
        InfoCollege infoCollege = new InfoCollege();

        colleges.add(computerCollege);
        colleges.add(infoCollege);

        Iterator<College> iterator = colleges.iterator();
        while (iterator.hasNext()) {
            College college = iterator.next();
            System.out.println("=== " + college.getName() + "=====");
            Iterator collegeIterator = college.createIterator();
            while (collegeIterator.hasNext()) {
                Department d = (Department) collegeIterator.next();
                System.out.println(d.getName());
            }
        }
    }

}
