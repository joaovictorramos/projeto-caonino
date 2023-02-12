package com.mycompany.caonino2;

public class Pessoa {
    private String nomePessoa;
    private String endereco;
    private long telefone;
    private String email;
    private String sexo;
    
    public Pessoa(String nomePessoa, String endereco, long telefone, String email, String sexo){
        setNomePessoa(nomePessoa);
        setEndereco(endereco);
        setTelefone(telefone);
        setEmail(email);
        setSexo(sexo);
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
