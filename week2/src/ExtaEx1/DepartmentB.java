package ExtaEx1;

import java.util.ArrayList;

public class DepartmentB extends Department {

    public DepartmentB() {
        super(0, new ArrayList<>(), "NAN");
    }

    public DepartmentB(int workTime, ArrayList<Department> departments, DepartmentA parent, String name) {
        super(workTime, departments, name);
        parent.addDepartmentChild(this);
    }
}
