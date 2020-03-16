package beans;

public class HelloWorld {

    private String name;

    public void hello() {
        System.out.println("hello:"+name);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
