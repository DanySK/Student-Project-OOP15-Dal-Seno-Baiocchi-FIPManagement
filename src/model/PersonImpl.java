package model;

public class PersonImpl implements Person {
    
    /**
     * 
     */
    private static final long serialVersionUID = 3970309943492437923L;
    private final String name;
    private final String surname;
    private final String birth;
    private final String cf;

    public PersonImpl(String name, String surname, String birth, String cf){
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.cf = cf;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getSurname() {
        return this.surname;
    }

    @Override
    public String getBirth() {
        return this.birth;
    }

    @Override
    public String getCF() {
        return this.cf;
    }

}
