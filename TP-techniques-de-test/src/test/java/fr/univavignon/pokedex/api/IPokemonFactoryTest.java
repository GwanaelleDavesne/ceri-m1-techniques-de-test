package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

}
