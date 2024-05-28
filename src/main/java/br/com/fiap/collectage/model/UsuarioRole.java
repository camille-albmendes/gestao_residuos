package br.com.fiap.collectage.model;

public enum UsuarioRole {
    ADMIN("ADMIN"),
    USER("USER");

    private final String role;

    UsuarioRole(String role){
        this.role = role;
    }

    public String getRole(){
        return this.role;
    }
}
