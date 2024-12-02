package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class IPokedexFactoryTest {
	
	IPokedexFactory pokedexFactory;
	
	@BeforeEach
	void setup() {
		pokedexFactory = new PokedexFactory();
	}
	
	@Test
	void createPokedexTest() {
		//test pour vérifier la création correcte d'un pokedex
		IPokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();
		IPokemonFactory pokemonFactory = new PokemonFactory(pokemonMetadataProvider);
		
		IPokedex createdPokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
		assertNotNull(createdPokedex);
	
	}

}
