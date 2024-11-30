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
		pokemonFactory = new PokemonFactory(pokemonMetadataProvider);
	}
	
	@Test
	void createPokemonTest(){
		//test pour vérifier la création correcte d'un Pokemon
		Pokemon bulbizarre = pokemonFactory.createPokemon(0,613,64,4000,4);
		
		assertEquals(0,bulbizarre.getIndex());
		assertEquals("Bulbizarre",bulbizarre.getName());
		assertEquals(8,bulbizarre.getAttack());
		assertEquals(8,bulbizarre.getDefense());
		assertEquals(9,bulbizarre.getStamina());
		assertEquals(613,bulbizarre.getCp());
		assertEquals(64,bulbizarre.getHp());
		assertEquals(4000,bulbizarre.getDust());
		assertEquals(4,bulbizarre.getCandy());
		assertEquals(55,bulbizarre.getIv());
	}
	
	@Test
	void createPokemonInvalidParameterTest(){
		//test pour vérifier la non création d'un Pokemon  en cas de paramètres invalides
		assertThrows(IllegalArgumentException.class, () -> {
			pokemonFactory.createPokemon(-1, -613, -64, -4000, -4);
	    });
	}

}
