package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class IPokemonTrainerFactoryTest {
	
	IPokemonTrainerFactory pokemonTrainerFactory;
	
	@BeforeEach
	void setup() {
		pokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
	}
	
	@Test
	void createTrainerTest() {
		//test pour vérifier la création correcte d'un pokemon trainer
		IPokedexFactory pokedexFactory = Mockito.mock(IPokedexFactory.class);
	    IPokedex pokedex = Mockito.mock(IPokedex.class);
	    String trainerName = "nomTest";
	    Team trainerTeam = Team.MYSTIC;
	    
	    when(pokemonTrainerFactory.createTrainer(trainerName, trainerTeam, pokedexFactory)).thenReturn(new PokemonTrainer(trainerName, trainerTeam, pokedex));
	    
	    PokemonTrainer pokemonTrainer = pokemonTrainerFactory.createTrainer(trainerName, trainerTeam, pokedexFactory);
	    
	    assertEquals("nomTest", pokemonTrainer.getName());
	    assertEquals(Team.MYSTIC, pokemonTrainer.getTeam());
	    assertEquals(pokedex, pokemonTrainer.getPokedex());
	
	}
	
	@Test
	void createTrainerWithNoTeamTest() {
		//test pour vérifier la non création d'un pokemon trainer en cas de paramètre invalide
		IPokedexFactory pokedexFactory = Mockito.mock(IPokedexFactory.class);
	    String trainerName = "nomTest";
	    
	    when(pokemonTrainerFactory.createTrainer(trainerName, null, pokedexFactory)).thenReturn(null);
	    
	    PokemonTrainer pokemonTrainer = pokemonTrainerFactory.createTrainer(trainerName, null, pokedexFactory);
	    
	    assertEquals(null, pokemonTrainer);
	
	}

}
