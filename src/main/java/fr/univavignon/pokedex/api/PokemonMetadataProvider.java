package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {
	
	List<PokemonMetadata> pokemonMetadata;
	
	public PokemonMetadataProvider() {
		//Constructeur
		pokemonMetadata = new ArrayList<>();
		pokemonMetadata.add(new PokemonMetadata(0, "Bulbizarre", 8, 8, 9));
		pokemonMetadata.add( new PokemonMetadata(133, "Aquali", 15, 15, 15));
    }

	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		//vérification de la validite de l'index
        if (index < 0 || index > 150) {
            throw new PokedexException("Invalid Index");
        }
        return pokemonMetadata.get(index);
	}
	

}
