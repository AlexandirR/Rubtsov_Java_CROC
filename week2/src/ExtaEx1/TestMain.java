package ExtaEx1;

import java.util.ArrayList;

public class TestMain {

    public static void main (String[] args) {
        Department A = new Department(1, new ArrayList<Department>(),null, "A");
        Department B1 = new Department(3, new ArrayList<Department>(), A,"B1");
        Department B2 = new Department(1, new ArrayList<Department>(), A,"B2");
        Department B3 = new Department(2, new ArrayList<Department>(), A,"B3");
        Department C11 = new Department(1, new ArrayList<Department>(), B1,"C11");
        Department C12 = new Department(1, new ArrayList<Department>(), B1,"C12");
        Department C21 = new Department(4, new ArrayList<Department>(), B2,"C21");
        Department C31 = new Department(1, new ArrayList<Department>(), B3,"C31");
        Department D311 = new Department(1, new ArrayList<Department>(), C31,"D311");
        A.printHierarchy(0);
        System.out.println(A.getAllWorkTime());
    }
}
