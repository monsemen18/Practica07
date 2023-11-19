public class MaestroPokemon extends Entrenador{
    public MaestroPokemon(String nombre, int cantidad){
        super(nombre, cantidad);
    }

    /**
	* Ayuda al ataque de un pokemon dependiendo de la experiencia
	* del entrenador.
	* @return un entero dependiendo del tipo de entrenador:
	* 1 si el entrenador es novato.
	* 2 si el entrenador es intermedio.
	* 3 si el entrenador es experto.
	*/
	public int ayudaPokemon(){
        return 3;
    }
}
