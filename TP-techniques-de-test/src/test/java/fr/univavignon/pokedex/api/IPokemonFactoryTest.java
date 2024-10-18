package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class IPokemonFactoryTest {
	
	IPokemonFactory pokemonFactory;
	
	@BeforeEach
	void setup() {
		pokemonFactory = Mockito.mock(IPokemonFactory.class);
	}
	
	@Test
	void createPokemonTest(){
		//test pour vérifier la création correcte d'un Pokemon
		when(pokemonFactory.createPokemon(0,613,64,4000,4)).thenReturn(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56));
		
		Pokemon bulbizarre = pokemonFactory.createPokemon(0,613,64,4000,4);
		
		assertEquals(0,bulbizarre.getIndex());
		assertEquals("Bulbizarre",bulbizarre.getName());
		assertEquals(126,bulbizarre.getAttack());
		assertEquals(126,bulbizarre.getDefense());
		assertEquals(90,bulbizarre.getStamina());
		assertEquals(613,bulbizarre.getCp());
		assertEquals(64,bulbizarre.getHp());
		assertEquals(4000,bulbizarre.getDust());
		assertEquals(4,bulbizarre.getCandy());
		assertEquals(56,bulbizarre.getIv());
	}
	
	@Test
	void createPokemonInvalidParameterTest(){
		//test pour vérifier la création d'un Pokemon  en cas de paramètres invalides
		when(pokemonFactory.createPokemon(-1, -613, -64, -4000, -4)).thenReturn(new Pokemon(-1, "Unknown", 0, 0, 0, 0, 0, 0, 0, 0));
	
		Pokemon invalidPokemon = pokemonFactory.createPokemon(-1, -613, -64, -4000, -4);
	
		assertEquals(-1, invalidPokemon.getIndex());
		assertEquals("Unknown", invalidPokemon.getName());
		assertEquals(0, invalidPokemon.getAttack());
		assertEquals(0, invalidPokemon.getDefense());
		assertEquals(0, invalidPokemon.getStamina());
		assertEquals(0, invalidPokemon.getCp());
		assertEquals(0, invalidPokemon.getHp());
		assertEquals(0, invalidPokemon.getDust());
		assertEquals(0, invalidPokemon.getCandy());
		assertEquals(0, invalidPokemon.getIv());
	}

}
