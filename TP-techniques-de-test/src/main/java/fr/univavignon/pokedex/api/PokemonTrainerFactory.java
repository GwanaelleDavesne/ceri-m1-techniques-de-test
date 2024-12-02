package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory{

	@Override
	public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
		if (name == null || team == null || pokedexFactory == null) {
            return null; //paramètres invalides
        }
		 IPokedex pokedex = pokedexFactory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory(new PokemonMetadataProvider()));
	        return new PokemonTrainer(name, team, pokedex);
	}

}
