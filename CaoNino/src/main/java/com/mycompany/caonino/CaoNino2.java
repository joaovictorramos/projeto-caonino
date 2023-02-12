package com.mycompany.caonino2;

import java.util.ArrayList;
import java.util.Scanner;

public class CaoNino2 {

    public static void main(String[] args) {
        ArrayList<Cachorro> cachorro = new ArrayList<>();
        ArrayList<Adocao> ficha = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        
        Adocao ad1 = new Adocao();
        Adocao ad2 = new Adocao();
        Adocao ad3 = new Adocao();
        Adocao ad4 = new Adocao();
        
        Cachorro c1 = new Cachorro("Kate", "12/06/2009", "Vira Lata", "Preto", 35);
        Cachorro c2 = new Cachorro("Bob", "09/10/2010", "Bulldog", "Preto", 22);
        Cachorro c3 = new Cachorro("Pitty", "02/03/2007", "Pitbul", "Branco", 38);
        Cachorro c4 = new Cachorro("Kelly", "08/05/2001", "Labrador", "Amarelo", 36);
        Cachorro c5 = new Cachorro("Peixe", "09/11/2008", "Vira Lata", "Amarelo", 20);
        Cachorro c6 = new Cachorro("Grazi", "12/12/2012", "Pastor", "Amarelo", 18);
        
        Pessoa p1 = new Pessoa("Diana", "Rua da Diana", 911111111, "diana01@gmail.com", "Feminino");
        Pessoa p2 = new Pessoa("Louis", "Rua da Louis", 922222222, "louis02@gmail.com", "Feminino");
        Pessoa p3 = new Pessoa("Bruce", "Rua do Bruce", 933333333, "bruce03@gmail.com", "Masculino");
        Pessoa p4 = new Pessoa("Clark", "Rua do Clark", 944444444, "clark04@gmail.com", "Masculino");
        
        String dataAdocao1 = "24/12/2010";
        String dataAdocao2 = "20/03/2011";
        String dataAdocao3 = "18/06/2007";
        String dataAdocao4 = "01/09/2002";
        
        ad1.vamosAdotar(c1, p1, dataAdocao1);
        ad2.vamosAdotar(c2, p2, dataAdocao2);
        ad3.vamosAdotar(c3, p3, dataAdocao3);
        ad4.vamosAdotar(c4, p4, dataAdocao4);
        
        ficha.add(ad1);
        ficha.add(ad2);
        ficha.add(ad3);
        ficha.add(ad4);
        
        cachorro.add(c1);
        cachorro.add(c2);
        cachorro.add(c3);
        cachorro.add(c4);
        cachorro.add(c5);
        cachorro.add(c6);
        
        System.out.println("Deseja procurar algum cachorro?[true/false]: ");
        boolean resp = scan.nextBoolean();
        procuraDog(ficha, resp);
        
        //System.out.println(ad1.statusCachorro());
        //System.out.println(ad1.statusPessoa());
        
        delete(ficha);
        maisTempoAdotado(ficha);
        contViraLata(ficha);
        
        arrayCachorro(cachorro);
    }
    
    public static void procuraDog(ArrayList<Adocao> ficha, boolean resp){
        Scanner scan = new Scanner(System.in);
        
        if(resp){
            System.out.print("Informe o nome do cachorro: ");
            String nameDog = scan.nextLine();
            
            boolean result = false;
            for(Adocao adocao : ficha){
                String comparar = adocao.getDog().getNomeCachorro();
            
                if(nameDog.equals(comparar)){
                    result = true;
                    System.out.println("\nCachorro Encontrado!!!");
                    System.out.println(adocao.statusCachorro());
                    System.out.println(adocao.statusAdocao());
                
                }
            }
        
            if(!result){
                System.out.println("\nCachorro NÃO Encontrado!!!\n\n");
            }
        }
    }
    
    public static void delete(ArrayList<Adocao> ficha){
        boolean[] posicao = new boolean[ficha.size()];
        for(int i = 0; i < ficha.size(); i++){
            if(!ficha.isEmpty()){
                posicao[i] = ficha.get(i).erroTempo();
            }
        }
        
        for(int i = 0; i < posicao.length; i++){
            if(!posicao[i]){
                ficha.remove(ficha.get(i));
            }
        }
        
        for(Adocao adocao : ficha){
            if(!ficha.isEmpty()){
                System.out.println(adocao.statusAdocao());
            }
        };
    }
    
    public static void maisTempoAdotado(ArrayList<Adocao> ficha){
        String nomeMaisTempo = "";
        for(Adocao adocao : ficha){
            nomeMaisTempo = adocao.maisTempo();
        }
        System.out.println("Cachorro com o mais tempo de adotado: " + nomeMaisTempo);
    }
    
    public static void contViraLata(ArrayList<Adocao> ficha){
        int contVL = 0;
        for(Adocao adocao : ficha){
            if(!ficha.isEmpty()){
                if("Vira Lata".equalsIgnoreCase(adocao.getDog().getRaca())){
                    contVL++;
                }
            }
        }
        System.out.println("Vira latas adotados: " + contVL);
    }
    
    public static void arrayCachorro(ArrayList<Cachorro> cachorro){
        for(Cachorro dog : cachorro){
            if(!cachorro.isEmpty()){
                if(dog.getPeso() < 20){
                    System.out.println("\n" + dog.getNomeCachorro() + " se encontra DESNUTRIDO(A)!");
                }
            }
        }
        
        int contVR = 0;
        for(Cachorro dog : cachorro){
            if(!cachorro.isEmpty()){
                if("Vira Lata".equalsIgnoreCase(dog.getRaca())){
                    contVR++;
                }
            }
        }
        System.out.println("Quant. de Vira latas: " + contVR);
        
        int contCor = 0;
        for(Cachorro dog : cachorro){
            if(!cachorro.isEmpty()){
                if("Amarelo".equalsIgnoreCase(dog.getCor())){
                    contCor++;
                }
            }
        }
        System.out.println("Quant. de cachorros amarelos: " + contCor);
    }
}
