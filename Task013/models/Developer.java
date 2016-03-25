package Task013.models;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class Developer {
    private String name;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Developer(String name) {
        this.name = name;
    }

    public void work(){
        System.out.println("Im working");
    }

    public void learnLang(String lang){
        System.out.println("Im learning language " + lang);
    }



}
