package model;

import java.util.Date;

public class PersonImpl implements Person {
    
    @Override
	public String toString() {
		return "PersonImpl [name=" + name + ", surname=" + surname + "]";
	}

	/**
     * 
     */
    private static final long serialVersionUID = 3970309943492437923L;
    private final String name;
    private final String surname;
    private final Date birth;
    private final String cf;

    public PersonImpl(String name, String surname, Date birth, String cf){
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
    public Date getBirth() {
        return this.birth;
    }

    @Override
    public String getCF() {
        return this.cf;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cf == null) ? 0 : cf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonImpl other = (PersonImpl) obj;
		if (cf == null) {
			if (other.cf != null)
				return false;
		} else if (!cf.equals(other.cf))
			return false;
		return true;
	}

}
