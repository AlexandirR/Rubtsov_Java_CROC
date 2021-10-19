package ExtaEx1;

import java.util.ArrayList;

public class DepartmentC extends Department {

    public DepartmentC() {
        super(0, new ArrayList<>(), "NAN");
    }

    public DepartmentC(int workTime, ArrayList<Department> departments, DepartmentB parent, String name) {
        super(workTime, departments, name);
        parent.addDepartmentChild(this);
    }
}
