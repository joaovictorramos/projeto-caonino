package com.mycompany.caonino2;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Adocao {
    private Cachorro dog;
    private Pessoa pes;
    private String dataAdocao;

    private static long maior = 0;
    private static long calcMaisTempo;
    private static String nomeMaisTempo = "";

    private boolean chave = true;
    private LocalDate dataEnt;
    private LocalDate dataAdo;
    
    public String statusAdocao(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        String dataAdoFormat = dataAdo.format(formato);
        
        return "==== LISTA DE ADOÇÕES ====" +
               "\nCachorro: " + getDog().getNomeCachorro() +
               "\nPessoa: " + getPes().getNomePessoa() +
               "\nData de adoção: " + dataAdoFormat + 
               "\nNutrição do(a) " + getDog().getNomeCachorro() + ": " + nutricao() +
               "\n\n==== Tempo do(a) " + getDog().getNomeCachorro() + " na ONG ====" + tempoOng() +
               "\n==== Tempo desde a Adoção ====" + tempoAdotado() +
               "\n\n";
    }
    
    public void vamosAdotar(Cachorro dog, Pessoa pes, String dataAdocao){
        setDog(dog);
        setPes(pes);
        setDataAdocao(dataAdocao);
        
        formatarData();
    }
    
    public String nutricao(){
        String condicao = "";
        
        if(getDog().getPeso() >= 0 && getDog().getPeso() <= 20){
            condicao = "Desnutrido";
            
        }else if(getDog().getPeso() >= 21 && getDog().getPeso() <= 30){
            condicao = "Normal";
            
        }else if(getDog().getPeso() > 30){
            condicao = "Obeso";
            
        }else{
            condicao = "ERRO";
        }
        
        return condicao;
    }
    
    public String maisTempo(){
        LocalDate hoje = LocalDate.now();
        calcMaisTempo = ChronoUnit.DAYS.between(dataAdo, hoje);
        
        if(maior < calcMaisTempo){
            maior = calcMaisTempo;
            nomeMaisTempo = getDog().getNomeCachorro();
        }
        
        return nomeMaisTempo;
    }
    
    public String tempoAdotado(){
        LocalDate hoje = LocalDate.now();
        Period periodo = Period.between(dataAdo,hoje);
        
        return "\nDias: " + periodo.getDays() +
               "\nMeses: " + periodo.getMonths() +
               "\nAnos: " + periodo.getYears() +
               "\n";
    }
    
    public String tempoOng(){
        Period periodo = Period.between(dataEnt, dataAdo);
        
        return "\nDias: " + periodo.getDays() +
               "\nMeses: " + periodo.getMonths() +
               "\nAnos: " + periodo.getYears() +
               "\n";
    }
    
     public boolean erroTempo(){
        Period periodo = Period.between(dataEnt, dataAdo);
        
        if(periodo.getYears() < 0 || periodo.getMonths() < 0 || periodo.getDays() < 0){
           chave = false; 
        }
        return chave;
    }
    
    private void formatarData(){
        String dataEntrada = getDog().getDataCachorro();
        String dataAdocao = getDataAdocao();
        
        String aujEntrada = "";
        String aujAdocao = "";
        
        for(int i = 0; i < dataEntrada.length(); i++){
            if(dataEntrada.charAt(i) != '/'){
                aujEntrada += dataEntrada.charAt(i);
            }
            if(dataAdocao.charAt(i) != '/'){
                aujAdocao += dataAdocao.charAt(i);
            }
        }
        
        int i = 0;
        String diaS = "";
        String mesS = "";
        String anoS = "";
        
        String diaA = "";
        String mesA = "";
        String anoA = "";
        
        while(i < 2){
            diaS += aujEntrada.charAt(i);
            diaA += aujAdocao.charAt(i);
            i++;
        }
        while(i < 4){
            mesS += aujEntrada.charAt(i);
            mesA += aujAdocao.charAt(i);
            i++;
        }
        while(i < 8){
            anoS += aujEntrada.charAt(i);
            anoA += aujAdocao.charAt(i);
            i++;
        }
        
        int diaEntrada = Integer.parseInt(diaS);
        int mesEntrada = Integer.parseInt(mesS);
        int anoEntrada = Integer.parseInt(anoS);
        
        int diaAdocao = Integer.parseInt(diaA);
        int mesAdocao = Integer.parseInt(mesA);
        int anoAdocao = Integer.parseInt(anoA);
        
        dataEnt = LocalDate.of(anoEntrada, mesEntrada, diaEntrada);
        dataAdo = LocalDate.of(anoAdocao, mesAdocao, diaAdocao);
    }
    
    public String statusCachorro(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        String dataEntFormat = dataEnt.format(formato);
        
        return "\n==== STATUS DO CACHORRO ====" +
               "\nNome do cachorro: " + getDog().getNomeCachorro() +
               "\nEntrada: " + dataEntFormat +
               "\nRaça: " + getDog().getRaca() +
               "\nCor: " + getDog().getCor() +
               "\nPeso: " + getDog().getPeso() + " Kg\n\n";
    }
    
    public String statusPessoa(){
        return "\n==== STATUS DA PESSOA ====" + 
               "\nNome da pessoa: " + getPes().getNomePessoa() +
               "\nEndereço: " + getPes().getEndereco() +
               "\nTelefone: " + getPes().getTelefone() +
               "\nEmail: " + getPes().getEmail() +
               "\nSexo: " + getPes().getSexo() + 
               "\n\n";
    }
    
    public Cachorro getDog() {
        return dog;
    }

    public void setDog(Cachorro dog) {
        this.dog = dog;
    }

    public Pessoa getPes() {
        return pes;
    }

    public void setPes(Pessoa pes) {
        this.pes = pes;
    }
    
    public String getDataAdocao() {
        return dataAdocao;
    }

    public void setDataAdocao(String dataAdocao) {
        this.dataAdocao = dataAdocao;
    }
}
