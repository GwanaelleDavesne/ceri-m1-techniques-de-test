package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;


public class IPokedexTest {
	
	IPokedex pokedex;
	
	@BeforeEach
	void setup() {
		pokedex = Mockito.mock(IPokedex.class);
	}

}
