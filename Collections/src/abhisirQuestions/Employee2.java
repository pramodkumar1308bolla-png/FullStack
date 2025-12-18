package abhisirQuestions;

class Employe {
    int id;
    String name;
    String company;
    double salary;

    Employe(int id, String name, String company, double salary) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + company + " " + salary;
    }
}
