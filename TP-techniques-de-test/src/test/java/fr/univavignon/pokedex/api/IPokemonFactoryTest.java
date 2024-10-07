package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;


public class IPokemonFactoryTest {
	
	IPokemonFactory pokemonFactory;
	
	@BeforeEach
	void setup() {
		pokemonFactory = Mockito.mock(IPokemonFactory.class);
	}

}
