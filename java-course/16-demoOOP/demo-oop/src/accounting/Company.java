package accounting;

public class Company {

    private String nif;
    private String name;

    public Company(String nif, String name) {
        this.nif = nif;
        this.name = name;
    }
      
    public String renderHeader() {
        return """
                ==============================================
                %s
                %s
                ----------------------------------------------
                """.formatted(name, nif);
    }

    public String renderClient() {
        return """
                Datos cliente
                Nombre: %s
                Nif: %s
                """.formatted(name, nif);
    }
    
}