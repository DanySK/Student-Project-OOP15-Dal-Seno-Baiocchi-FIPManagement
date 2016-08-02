package model;

public class CompanyImpl implements Company {

    /**
     * 
     */
    private static final long serialVersionUID = 6225643899682723273L;
    private final String name;
    private final String VAT;
    
    public CompanyImpl(String name,String vat){
       this.name = name;
       this.VAT = vat;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getVATNumber() {
        return this.VAT;
    }

}
