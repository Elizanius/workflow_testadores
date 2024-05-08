package org.antonio.Model;

import org.antonio.Exception.HeroeNoEncontradoException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GestorHeroes {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private List<Heroe> heroes;

    public GestorHeroes() {
        this.heroes = new ArrayList<>();
    }

    public void agregarHeroe(Heroe heroe) {
        this.heroes.add(heroe);
    }

    public void agregarHeroes(int nheroes) {

        for (int i = 0; i < nheroes; i++) {
            try {
                System.out.println("Indicame el nombre del heroe");
                String nom = br.readLine();
                System.out.println("Indicame los poderes del heroe");
                String superp;
                superp = br.readLine();
                System.out.println("Indicame la historia del heroe");
                String hist = br.readLine();
                Heroe heroe = new Heroe(nom, superp, hist);
                this.heroes.add(heroe);

            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
        
    }

    public void actualizarHeroe(Heroe heroeactualizado){
        for (Heroe heroe : heroes) {
            if (heroe.getNombre().equals(heroeactualizado.getNombre())) {
                heroe.setBiografia(heroeactualizado.getBiografia());
                heroe.setSuperpoderes(heroeactualizado.getSuperpoderes());
            }else{
                agregarHeroe(heroeactualizado);
            }
        }
    }

    public void eliminarHeroe(String nombre) {
        for (int i = 0; i < this.heroes.size(); i++) {
            Heroe x = new Heroe();
            x.setNombre(nombre);
            try {
                if (this.buscarHeroe(x.getNombre()) != null) {
                    this.heroes.remove(i);
                }else{
                    System.out.println("Este heroe no existe en la lista");
                }

            } catch (HeroeNoEncontradoException e) {            
                e.printStackTrace();
            }
        }    
    }

    public Heroe buscarHeroePorSuperpoder(String superpoder) throws HeroeNoEncontradoException {
        for (Heroe heroe : this.heroes) {
            if (heroe.getSuperpoderes().contains(superpoder)) {
                return heroe;
            }
        }
        throw new HeroeNoEncontradoException(superpoder);
    }

    public Heroe buscarHeroe(String nombre) throws HeroeNoEncontradoException {
        for (Heroe heroe : this.heroes) {
            if (heroe.getNombre().equals(nombre)) {
                return heroe;
            }
        }
        throw new HeroeNoEncontradoException(nombre);
    }

    public List<Heroe> getHeroes(){
        return heroes;
    }

    public List<String> listarheroes(){

        List<String> definitiva = new ArrayList<>();
        
        for (int i = 0; i < getHeroes().size(); i++) {
            definitiva.add(getHeroes().get(i).getNombre());
        }
        return  definitiva;
    }

    public List<Heroe> buscarHeroesPorSuperpoder(String superpoder){
        
        List<Heroe> heroes = new ArrayList<>();
        for (Heroe heroe : this.getHeroes()) {
            if (heroe.getSuperpoderes().contains(superpoder)) {
                heroes.add(heroe);
            }
        }
        return heroes;
    }

}
