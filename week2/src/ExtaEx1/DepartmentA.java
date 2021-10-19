package ExtaEx1;

import java.awt.*;
import java.util.ArrayList;

public class DepartmentA extends Department {

    public DepartmentA() {
        super(0, new ArrayList<>(), "NAN");
    }

    public DepartmentA(int workTime, ArrayList<Department> departments, String name) {
       super(workTime, departments, name);
    }
}
