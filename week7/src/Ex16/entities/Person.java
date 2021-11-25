package Ex16.entities;

public class Person implements Comparable{
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.age + ")";
    }

    @Override
    public int hashCode() {
        return this.age.hashCode() + this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.age.equals(((Person) obj).age) && this.name.equals(((Person) obj).name);
    }

    @Override
    public int compareTo(Object o) {
        if(this.age == ((Person) o).age) {
            return this.name.compareTo(((Person) o).name);
        }
        else {
            // revers for age
            return (-1) * this.age.compareTo(((Person) o).age);
        }
    }
}
