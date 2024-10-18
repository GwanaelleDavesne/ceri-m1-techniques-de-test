package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class IPokedexFactoryTest {
	
	IPokedexFactory pokedexFactory;
	
	@BeforeEach
	void setup() {
		pokedexFactory = Mockito.mock(IPokedexFactory.class);
	}
	
	@Test
	void createPokedexTest() {
		//test pour vérifier la création correcte d'un pokedex
		IPokemonMetadataProvider pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
		IPokedex pokedex = Mockito.mock(IPokedex.class);
		IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);
		when(pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory)).thenReturn(pokedex);
		
		IPokedex createdPokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
		assertEquals(pokedex, createdPokedex);
	
	}

}
