package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;


public class IPokemonTrainerFactoryTest {
	
	IPokemonTrainerFactory pokemonTrainerFactory;
	
	@BeforeEach
	void setup() {
		pokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
	}

}
