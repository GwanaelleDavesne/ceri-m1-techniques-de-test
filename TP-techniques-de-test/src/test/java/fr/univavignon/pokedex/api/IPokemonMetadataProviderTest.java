package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class IPokemonMetadataProviderTest {
	
	IPokemonMetadataProvider pokemonMetadataProvider;
	
	@BeforeEach
	void setup() {
		pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
	}
	
	
	@Test
	void getPokemonMetadaInvalidIndexTest() throws PokedexException{
		//test pour vérifier qu'un numéro d'index invalide lance une exception
		when(pokemonMetadataProvider.getPokemonMetadata(151)).thenThrow(new PokedexException("Invalid Index"));
		
		assertThrows(PokedexException.class, () -> {
			pokemonMetadataProvider.getPokemonMetadata(151);
		});
	}
	
	@Test
	void getPokemonMetadaTest() throws PokedexException{
		//test pour vérifier que cela retourne les métadonnées correctes
		when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
		
		PokemonMetadata bulbizarre = pokemonMetadataProvider.getPokemonMetadata(0);
		
		assertEquals(0,bulbizarre.getIndex());
		assertEquals("Bulbizarre",bulbizarre.getName());
		assertEquals(126,bulbizarre.getAttack());
		assertEquals(126,bulbizarre.getDefense());
		assertEquals(90,bulbizarre.getStamina());
	}

}
