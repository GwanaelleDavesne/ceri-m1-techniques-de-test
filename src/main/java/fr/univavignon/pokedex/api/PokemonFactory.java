package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory{
	
	IPokemonMetadataProvider metadataProvider;
	
	public PokemonFactory(IPokemonMetadataProvider metadataProvider) {
		//Constructeur
        this.metadataProvider = metadataProvider;
    }

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		try {
			PokemonMetadata metadata = metadataProvider.getPokemonMetadata(index);
			int iv = (int) ((metadata.getAttack() + metadata.getDefense() + metadata.getStamina()) / 45.0 * 100);
	        return new Pokemon(index, metadata.getName(), metadata.getAttack(), metadata.getDefense(), metadata.getStamina(), cp, hp, dust, candy, iv);
		} catch (PokedexException e) {
			throw new IllegalArgumentException("Failed to create Pokemon");
		}  
	}
}
