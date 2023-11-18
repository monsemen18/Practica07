/**
* Representación de un entrenador pokemon.
* @author Yessica Janerh PabloMartinez.
* @version 1.0 noviembre 2023
*/
public abstract class Entrenador{
	
	/** Nombre del entrenador. */
	public String nombre;

	/** Pokemones del entrenador. */
	protected Pokemon[] pokemon;

	/** Cantidad de pokemones actuales. */
	private int actual;

	/**
	* Crea un nuevo entrenador.
	* @param nombre el nombre del entrenador.
	* @param cantidad la cantidad de pokemones que tendrá
	* un entrenador.
	*/
	public Entrenador(String nombre, int cantidad){
		this.nombre = nombre;
		pokemon = new Pokemon[cantidad];
		actual = 0;
	}

	/**
	* Agrega un nuevo pokemon al entrenador.
	* @param capturado el pokemon capturado por el entrenador.
	*/
	public void capturaPokemon(Pokemon capturado){
		if(actual == pokemon.length){
			System.out.println("El entrenador "+nombre+" no puede tener más pokemones");
			return;
		}

		pokemon[actual++] = capturado;
	}

	/**
	* Muestra todos los pokemon del entrenador.
	*/
	public void muestraPokemon(){
		for(int i = 0; i < actual ; i++)
			System.out.println(pokemon[i] + "\n");
	}

	/**
	* Ayuda al ataque de un pokemon dependiendo de la experiencia
	* del entrenador.
	* @return un entero dependiendo del tipo de entrenador:
	* 1 si el entrenador es novato.
	* 2 si el entrenador es intermedio.
	* 3 si el entrenador es experto.
	*/
	public abstract int ayudaPokemon();
}