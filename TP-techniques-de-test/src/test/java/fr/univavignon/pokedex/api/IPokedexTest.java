package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class IPokedexTest {
	
	IPokedex pokedex;
	
	@BeforeEach
	void setup() {
		pokedex = Mockito.mock(IPokedex.class);
	}
	
	
	@Test
	void sizeTest() {
		//test pour vérifier que cela retourne la taille correcte
		when(pokedex.size()).thenReturn(2);
		
		assertEquals(2,pokedex.size());
	
	}
	
	
	@Test
	void addPokemonTest() {
		//test pour vérifier l'ajout correcte d'un pokemon
		Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
		when(pokedex.addPokemon(aquali)).thenReturn(133);
		
		assertEquals(133,pokedex.addPokemon(aquali));
	}
	
	
	@Test
	void getPokemonInvalidIndexTest() throws PokedexException{
		//test pour vérifier qu'un numéro d'index invalide lance une exception		
		when(pokedex.getPokemon(151)).thenThrow(new PokedexException("Invalid Index"));
		
		assertThrows(PokedexException.class, () -> {
			pokedex.getPokemon(151);
		});
	}
	
	@Test
	void getPokemonTest() throws PokedexException{
		//test pour vérifier la recuperation correcte d'un pokemon
		when(pokedex.getPokemon(133)).thenReturn(new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100));
		
		assertEquals("Aquali", pokedex.getPokemon(133).getName());
		assertEquals(4, pokedex.getPokemon(133).getCandy());
	}
	
	@Test
	void getPokemonsTest(){
		//test pour vérifier la recuperation correcte de la liste des pokemons de la pokedex
		List<Pokemon> pokemons = new ArrayList<>();
		pokemons.add(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56));
		pokemons.add(new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100));
		when(pokedex.getPokemons()).thenReturn(pokemons);
		
		assertEquals(pokemons, pokedex.getPokemons());
		assertEquals("Bulbizarre", pokedex.getPokemons().get(0).getName());
		assertEquals("Aquali", pokedex.getPokemons().get(1).getName());
	}
	
	@Test
	void getPokemonsSortedByCPTest() {
		//test pour vérifier la recuperation correcte de la liste ordonnée des pokemons de la pokedex
	    List<Pokemon> pokemons = new ArrayList<>();
	    pokemons.add(new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100));
	    pokemons.add(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56));
	    List<Pokemon> pokemonsByCP = new ArrayList<>(pokemons);
	    pokemonsByCP.sort(PokemonComparators.CP);

	    when(pokedex.getPokemons(PokemonComparators.CP)).thenReturn(pokemonsByCP);

	    List<Pokemon> listPokemons = pokedex.getPokemons(PokemonComparators.CP);
	    assertEquals("Bulbizarre", listPokemons.get(0).getName());
	    assertEquals("Aquali", listPokemons.get(1).getName());
	}

}
