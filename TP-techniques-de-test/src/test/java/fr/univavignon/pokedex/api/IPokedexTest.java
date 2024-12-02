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
		IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        IPokemonFactory pokemonFactory = new PokemonFactory(metadataProvider);
        pokedex = new Pokedex(metadataProvider, pokemonFactory);
	}
	
	
	@Test
	void sizeTest() {
		//test pour vérifier que cela retourne la taille correcte
		assertEquals(0, pokedex.size());
        pokedex.addPokemon(new Pokemon(133, "Aquali", 15, 15, 15, 2729, 202, 5000, 4, 100));
        assertEquals(1, pokedex.size());
	
	}
	
	
	@Test
	void addPokemonTest() {
		//test pour vérifier l'ajout correcte d'un pokemon
		Pokemon aquali = new Pokemon(133, "Aquali", 15, 15, 15, 2729, 202, 5000, 4, 100);

		assertEquals(133,pokedex.addPokemon(aquali));
	}
	
	
	@Test
	void getPokemonInvalidIndexTest() throws PokedexException{
		//test pour vérifier qu'un numéro d'index invalide lance une exception		
		assertThrows(PokedexException.class, () -> {
			pokedex.getPokemon(151);
		});
	}
	
	@Test
	void getPokemonTest() throws PokedexException{
		//test pour vérifier la recuperation correcte d'un pokemon
		pokedex.addPokemon(new Pokemon(133, "Aquali", 15, 15, 15, 2729, 202, 5000, 4, 100));
		assertEquals("Aquali", pokedex.getPokemon(133).getName());
		assertEquals(4, pokedex.getPokemon(133).getCandy());
	}
	
	@Test
	void getPokemonsTest(){
		//test pour vérifier la recuperation correcte de la liste des pokemons de la pokedex
		List<Pokemon> pokemons = new ArrayList<>();
		Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 8, 8, 9, 613, 64, 4000, 4, 56);
	    Pokemon aquali = new Pokemon(133, "Aquali", 15, 15, 15, 2729, 202, 5000, 4, 100);
	    
	    pokemons.add(bulbizarre);
	    pokemons.add(aquali);
	    
	    pokedex.addPokemon(bulbizarre);
	    pokedex.addPokemon(aquali);
		
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

		pokedex.addPokemon(new Pokemon(133, "Aquali", 15, 15, 15, 2729, 202, 5000, 4, 100));
		pokedex.addPokemon(new Pokemon(0, "Bulbizarre", 8, 8, 9, 613, 64, 4000, 4, 56));

	    List<Pokemon> listPokemons = pokedex.getPokemons(PokemonComparators.CP);
	    assertEquals("Bulbizarre", listPokemons.get(0).getName());
	    assertEquals("Aquali", listPokemons.get(1).getName());
	}

}
