package org.antonio;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.antonio.Exception.HeroeNoEncontradoException;
import org.antonio.Model.GestorHeroes;
import org.antonio.Model.Heroe;

public class TestHeroes {
    

    Heroe ironMan = null;
    Heroe Spider_Man = null;
    Heroe Capitan = null;
    GestorHeroes gestorHeroes = null;

    @Before
    public void setUp(){

        gestorHeroes = new GestorHeroes();

        ironMan = new Heroe("Iron Man", "Traje de alta tecnología", "Millonario y filántropo");
        Spider_Man = new Heroe("Spider-Man", "Sentido arácnido, trepador", "Tímido estudiante de secundaria");
        Capitan = new Heroe("Capitán América", "Superfuerza, agilidad, resistencia", "Soldado de la Segunda Guerra Mundial");

    }

    @Test
    public void testSetters(){

        ironMan.setSuperpoderes("Si");
        Capitan.setBiografia("No");
        Spider_Man.setNombre("Spidy");

        assertEquals("Si", ironMan.getSuperpoderes());
        assertNotEquals(ironMan.getBiografia(), Capitan.getBiografia());
        assertNotEquals("Spider_Man",Spider_Man.getNombre());
    }

    @Test
    public void testGetters(){

        Capitan.setBiografia("Tímido estudiante de secundaria");
        assertNotEquals(ironMan.getSuperpoderes(), Capitan.getSuperpoderes());
        assertEquals(Spider_Man.getBiografia(), Capitan.getBiografia());
        assertEquals("Tímido estudiante de secundaria", Capitan.getBiografia());
        assertNotEquals("Tímido estudiante de secundaria", ironMan.getNombre());

    }

}
