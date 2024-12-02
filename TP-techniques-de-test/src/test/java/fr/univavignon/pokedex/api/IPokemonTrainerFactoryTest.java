package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class IPokemonTrainerFactoryTest {
	
	IPokemonTrainerFactory pokemonTrainerFactory;
	
	@BeforeEach
	void setup() {
		pokemonTrainerFactory = new PokemonTrainerFactory();
	}
	
	@Test
	void createTrainerTest() {
		//test pour vérifier la création correcte d'un pokemon trainer
		IPokedexFactory pokedexFactory = new PokedexFactory();
	    String trainerName = "nomTest";
	    Team trainerTeam = Team.MYSTIC;
	    
	    PokemonTrainer pokemonTrainer = pokemonTrainerFactory.createTrainer(trainerName, trainerTeam, pokedexFactory);
	    
	    assertNotNull(pokemonTrainer);
	    assertEquals("nomTest", pokemonTrainer.getName());
	    assertEquals(Team.MYSTIC, pokemonTrainer.getTeam());

	
	}
	
	@Test
	void createTrainerWithNoTeamTest() {
		//test pour vérifier la non création d'un pokemon trainer en cas de paramètre invalide
		IPokedexFactory pokedexFactory = Mockito.mock(IPokedexFactory.class);
	    String trainerName = "nomTest";
	    
	    PokemonTrainer pokemonTrainer = pokemonTrainerFactory.createTrainer(trainerName, null, pokedexFactory);
	    
	    assertNull(pokemonTrainer);
	
	}

}
