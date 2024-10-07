package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;


public class IPokedexFactoryTest {
	
	IPokedexFactory pokedexFactory;
	
	@BeforeEach
	void setup() {
		pokedexFactory = Mockito.mock(IPokedexFactory.class);
	}

}
