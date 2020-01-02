package action.iterator;

import java.util.Iterator;
import java.util.List;

public class InfoCollegeIterator implements Iterator<Department> {

    private List<Department> departments;
    private int index = -1;

    public InfoCollegeIterator(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        if (index >= departments.size() - 1) {
            return false;
        } else {
            index += 1;
            return true;
        }
    }

    @Override
    public Department next() {
        return departments.get(index);
    }
}
