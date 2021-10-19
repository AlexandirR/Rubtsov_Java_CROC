package ExtaEx1;

import java.util.ArrayList;

public class DepartmentD extends Department {

    public DepartmentD() {
        super(0, new ArrayList<>(), "NAN");
    }

    public DepartmentD(int workTime, ArrayList<Department> departments, DepartmentC parent, String name) {
        super(workTime, departments, name);
        parent.addDepartmentChild(this);
    }
}
