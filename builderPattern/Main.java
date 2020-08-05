package builderPattern;

public class Main {
    public static void main(String[] args) {
        Person person = Person.builder()
                .id(1)
                .name("Devesh")
                .build();
        System.out.println(person);
    }
}
