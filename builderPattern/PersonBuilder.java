package builderPattern;

public class PersonBuilder {
    private int id;
    private String name;

    public PersonBuilder id(int id){
        this.id = id;
        return this;
    }
    public PersonBuilder name(String name){
        this.name = name;
        return this;
    }
    public Person build(){
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        return person;
    }
}
