package ExtaEx1;

import java.util.ArrayList;
import java.util.List;

public class Department {
    protected Department parent;
    protected String name;
    protected int workTime;
    protected List<Department> departments;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    public int getWorkTime() {
        return workTime;
    }

    public Department getParent() { return parent; }

    public void setParent(Department parent) { this.parent = parent; }

    public Department() {
        this.name = "NAN";
        this.workTime = 0;
        this.departments = new ArrayList<Department>();
        this.parent = null;
    }

    public Department(int workTime, ArrayList<Department> departments, Department parent, String name) {
        this.name = name;
        this.workTime = workTime;
        this.departments = departments;
        this.parent = parent;
        if(parent != null) {
            parent.addDepartmentChild(this);
        }
    }

    public void addDepartmentChild(Department department) {
        this.departments.add(department);
    }

    //Рекурсивно вызываем метод поиска общего времени работы от всех детей в дереве иерархии
    public int getAllWorkTime() {
        int workTimeChildren = 0;
        for (Department department: departments) {
            workTimeChildren = Math.max(workTimeChildren, department.getAllWorkTime());
        }
        return this.workTime + workTimeChildren;
    }


    //Рекурсивно выводим дерево иерархии по DFS
    public void printHierarchy(int indentLevel) {
        String indent = "    ";
        for(int i = 0; i< indentLevel; ++i) {
            System.out.print(indent);
        }
        System.out.println(this.name);
        for(Department department: departments) {
            department.printHierarchy(indentLevel + 1);
        }
    }
}
