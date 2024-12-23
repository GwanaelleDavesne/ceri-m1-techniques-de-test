package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class IPokemonFactoryTest {
	
	IPokemonFactory pokemonFactory;
	IPokemonMetadataProvider pokemonMetadataProvider;
	
	@BeforeEach
	void setup() {
		pokemonMetadataProvider = new PokemonMetadataProvider();
		pokemonFactory = new RocketPokemonFactory();
	}
	
	@Test
	void createPokemonTest(){
		//test pour vérifier la création correcte d'un Pokemon
		Pokemon bulbizarre = pokemonFactory.createPokemon(0,613,64,4000,4);
		
		assertEquals(0,bulbizarre.getIndex());
		assertEquals("Bulbizarre",bulbizarre.getName());
		assertEquals(613,bulbizarre.getCp());
		assertEquals(64,bulbizarre.getHp());
		assertEquals(4000,bulbizarre.getDust());
		assertEquals(4,bulbizarre.getCandy());
		assertEquals(1,bulbizarre.getIv());
	}
	
	@Test
	void createPokemonInvalidParameterTest(){
		//test pour vérifier la création d'un Pokemon  en cas de paramètres invalides
		Pokemon pokemon = pokemonFactory.createPokemon(-1,613,64,4000,4);
		
		assertEquals(-1,pokemon.getIndex());
		assertEquals("Ash's Pikachu",pokemon.getName());
		assertEquals(1000,pokemon.getAttack());
		assertEquals(1000,pokemon.getDefense());
		assertEquals(1000,pokemon.getStamina());
		assertEquals(613,pokemon.getCp());
		assertEquals(64,pokemon.getHp());
		assertEquals(4000,pokemon.getDust());
		assertEquals(4,pokemon.getCandy());
		assertEquals(0,pokemon.getIv());
	}
	
	@Test
	void generateRandomStatTest() {
	    //test pour vérifier que les statistiques générées sont dans une bonne intervalle
	    Pokemon pokemon = pokemonFactory.createPokemon(1, 613, 64, 4000, 4);

	    assertTrue(pokemon.getAttack() >= 0 && pokemon.getAttack() <= 100);
	    assertTrue(pokemon.getDefense() >= 0 && pokemon.getDefense() <= 100);
	    assertTrue(pokemon.getStamina() >= 0 && pokemon.getStamina() <= 100);
	}
	
	@Test
	void createPokemonInvalidIndexTest(){
		//test pour vérifier la création d'un Pokemon avec un Index qui n'est pas dans aMap
		Pokemon pokemon = pokemonFactory.createPokemon(3,613,64,4000,4);
		
		assertEquals(3,pokemon.getIndex());
		assertEquals("Bulbizarre",pokemon.getName());
		assertEquals(613,pokemon.getCp());
		assertEquals(64,pokemon.getHp());
		assertEquals(4000,pokemon.getDust());
		assertEquals(4,pokemon.getCandy());
		assertEquals(1,pokemon.getIv());
	}

}
