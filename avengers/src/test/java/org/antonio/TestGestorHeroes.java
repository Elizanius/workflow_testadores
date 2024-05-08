package org.antonio;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.antonio.Exception.HeroeNoEncontradoException;
import org.antonio.Model.GestorHeroes;
import org.antonio.Model.Heroe;

public class TestGestorHeroes {

    Heroe ironMan = null;
    Heroe Spider_Man = null;
    Heroe Capitan = null;
    GestorHeroes gestorHeroes = null;

    @Before
    public void setUp(){

        gestorHeroes = new GestorHeroes();

        // Agregamos algunos héroes
        ironMan = new Heroe("Iron Man", "Traje de alta tecnología", "Millonario y filántropo");
        Spider_Man = new Heroe("Spider-Man", "Sentido arácnido, trepador", "Tímido estudiante de secundaria");
        Capitan = new Heroe("Capitán América", "Superfuerza, agilidad, resistencia", "Soldado de la Segunda Guerra Mundial");


    }

    @Test
        public void testGestorHeroes() throws HeroeNoEncontradoException{
            
            gestorHeroes.agregarHeroe(Spider_Man);
            
            assertSame(Spider_Man, gestorHeroes.buscarHeroe("Spider-Man"));
            assertNotSame(Spider_Man, "SpiderMan");
            
        }

    
    @Test
    public void testActualizaciónHeroe(){
        
        gestorHeroes.agregarHeroe(new Heroe("Capitán América", "Superfuerza, agilidad, resistencia", "Soldado de la Segunda Guerra Mundial"));
        
        try {
            
            assertEquals(Capitan.getBiografia(), gestorHeroes.buscarHeroe("Capitán América").getBiografia());
            assertEquals(Capitan.getNombre(), gestorHeroes.buscarHeroe("Capitán América").getNombre());
            assertEquals(Capitan.getSuperpoderes(), gestorHeroes.buscarHeroe("Capitán América").getSuperpoderes());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testEliminarHeroe(){

        gestorHeroes.agregarHeroe(Capitan);
        gestorHeroes.eliminarHeroe("Capitán América");
        assertEquals(0, gestorHeroes.getHeroes().size());
        assertNotEquals(1, gestorHeroes.getHeroes().size());
    }

    @Test(expected = HeroeNoEncontradoException.class)
    public void testEliminarHeroeWithException() throws HeroeNoEncontradoException {
        gestorHeroes.agregarHeroe(Capitan);
        gestorHeroes.eliminarHeroe("Capitán América");
        gestorHeroes.buscarHeroe("Capitán America");
    }

    @Test
    public void testAgregarVariosHeroes() throws HeroeNoEncontradoException{

        gestorHeroes.agregarHeroe(ironMan);
        gestorHeroes.agregarHeroe(Capitan);
        gestorHeroes.agregarHeroe(Spider_Man);
        GestorHeroes gr = new GestorHeroes();

        assertNotEquals(gestorHeroes.getHeroes().size(), gr.getHeroes().size());
        assertEquals(3,gestorHeroes.getHeroes().size());
        assertEquals(Capitan ,gestorHeroes.buscarHeroe("Capitán América"));

    }

    @Test
    public void testBuscarHeroePorSuperpoder() throws HeroeNoEncontradoException{

        gestorHeroes.agregarHeroe(ironMan);
        gestorHeroes.agregarHeroe(Capitan);
        gestorHeroes.agregarHeroe(Spider_Man);
        GestorHeroes gr = new GestorHeroes();
        gr.agregarHeroe(Capitan);

        assertEquals(gestorHeroes.buscarHeroePorSuperpoder("Superfuerza"), gr.buscarHeroe("Capitán América"));
        assertEquals(Capitan, gestorHeroes.buscarHeroePorSuperpoder("Superfuerza"));
        assertNotEquals(Spider_Man, gestorHeroes.buscarHeroePorSuperpoder("Superfuerza"));

    }

    @Test
    public void testActualizarHeroe() throws HeroeNoEncontradoException{

        gestorHeroes.agregarHeroe(Capitan);
        Capitan.setSuperpoderes("Vuela");
        gestorHeroes.actualizarHeroe(Capitan);

        gestorHeroes.agregarHeroe(Spider_Man);
        Spider_Man.setBiografia("Son 4, uno és animado");
        gestorHeroes.agregarHeroe(ironMan);

        assertNotSame(Spider_Man.getBiografia(), gestorHeroes.buscarHeroe(Spider_Man.getNombre()));
        assertSame(Capitan,gestorHeroes.buscarHeroe("Capitán América"));

    }

    @Test
    public void testListarHeroe(){
            gestorHeroes.agregarHeroe(Capitan);
            gestorHeroes.agregarHeroe(Spider_Man);
            gestorHeroes.agregarHeroe(ironMan);

            GestorHeroes gr = new GestorHeroes();
            gr.agregarHeroe(Capitan);
            gr.agregarHeroe(Capitan);
            gr.agregarHeroe(Capitan);
            
        assertNotSame("[Capitán América, Spider-Man, Iron Man]",gestorHeroes.listarheroes());
        assertNotEquals(gr, gestorHeroes);
        assertEquals(gr.getHeroes().size(), gestorHeroes.getHeroes().size());
    }

    @Test
    public void testBuscarHeroesPorSuperpoder(){

        Capitan.setSuperpoderes("Super Fuerza");
        Spider_Man.setSuperpoderes("Super Fuerza");
        gestorHeroes.agregarHeroe(Capitan);
        gestorHeroes.agregarHeroe(Spider_Man);
        gestorHeroes.agregarHeroe(ironMan);

        List<Heroe> listatest = new ArrayList<>();
        listatest.add(Capitan);
        listatest.add(Spider_Man);

        GestorHeroes gr = new GestorHeroes();
        gr.agregarHeroe(Capitan);
        gr.agregarHeroe(Spider_Man);

        GestorHeroes gr1 = new GestorHeroes();
        gr1.agregarHeroe(Spider_Man);
        gr1.agregarHeroe(Capitan);

        assertEquals(listatest, gestorHeroes.buscarHeroesPorSuperpoder("Super Fuerza"));
        assertEquals(gr.buscarHeroesPorSuperpoder("Super Fuerza"), gestorHeroes.buscarHeroesPorSuperpoder("Super Fuerza"));
        assertNotEquals(gr1.buscarHeroesPorSuperpoder("Super Fuerza"), gestorHeroes.buscarHeroesPorSuperpoder("Super Fuerza"));

    }
}  