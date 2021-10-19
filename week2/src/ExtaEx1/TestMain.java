package ExtaEx1;

import java.util.ArrayList;

public class TestMain {

    public static void main (String[] args) {
        DepartmentA A = new DepartmentA(1, new ArrayList<Department>(), "A");
        DepartmentB B1 = new DepartmentB(3, new ArrayList<Department>(), A,"B1");
        DepartmentB B2 = new DepartmentB(1, new ArrayList<Department>(), A,"B2");
        DepartmentB B3 = new DepartmentB(2, new ArrayList<Department>(), A,"B3");
        DepartmentC C11 = new DepartmentC(1, new ArrayList<Department>(), B1,"C11");
        DepartmentC C12 = new DepartmentC(1, new ArrayList<Department>(), B1,"C12");
        DepartmentC C21 = new DepartmentC(4, new ArrayList<Department>(), B2,"C21");
        DepartmentC C31 = new DepartmentC(1, new ArrayList<Department>(), B3,"C31");
        DepartmentD D311 = new DepartmentD(1, new ArrayList<Department>(), C31,"D311");
        A.printHierarchy(0);
        System.out.println(A.getAllWorkTime());
    }
}
