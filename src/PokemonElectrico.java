import java.util.Random;

public class PokemonElectrico extends Pokemon{

	 /** atributos PokemonElectrico */
	protected int electricidad;
	protected int rapidez;

	/** Intensidad del ataque especial tipo electrico */
    protected int intensidadElectrico;

    /** Verificador de efecto paralizar a otro pokemon */
    protected boolean paralizar;

    /** Tipo de elemento del pokemon */
    final protected String TIPO = "Electrico";

    /**
     * Crea un nuevo pokemon de tipo electrico.
     * @param nombre el nombre del pokemon.
	 * @param intensidad la intensidad de ataque.
	 * @param entrenador el entrenador del pokemon.
     * @param especialElectrico la intesidad del ataque especial tipo electrico.
     */
    public PokemonElectrico(String nombre, int intensidad, Entrenador entrenador, int especialElectrico) {
        super(nombre, intensidad, entrenador);
        intensidadElectrico = especialElectrico;
        this.paralizar = false;
    }

    /**
     * Metodo auxiliar de tipo getter para la variable final
     * TIPO de nuestro Pokemon
     * @return regresa el elemento que es Electrico
     */
    protected String getTIPO() {
        return TIPO;
    }

	protected int getPC(){
		return pc;
	}

	public int getIntensidadAtaque() {
        return intensidadAtaque;
    }

    /**
	* Ataca a un pokemon, restando la PC la intensidad 
	* del ataque. Cada pokemon ataca dependiendo de su tipo.
	* @param atacado el pokemon a atacar.
	* @return true si el pokemon pudo ser atacado, false en otro caso.
	* Un pokemon no puede ser atacado cuando su PC es negativa o es 0.
	*/
    @Override
	public boolean ataca(Pokemon atacado){
        if(this.pc <= 0 || atacado.pc <= 0){
            System.out.println("no puede ser atacado");
            return false;
        }

        Intermedio intermedio1 = new Intermedio("master", 5);
        
        atacado.pc -= intensidadAtaque * intermedio1.ayudaPokemon();

        System.out.println(this.nombre + " atacó a " + atacado.nombre + " con intensidad " + intensidadAtaque);
        System.out.println("ataque fulgor!!");

        if (atacado.pc <= 0) {
            System.out.println(atacado.nombre + " se debilitó.");
        }

        return true;
    }

	/**
	* Permite al pokemon defenderse.
	* @return true si el pokemon se defiende con exito, false en otro caso.
	*/
    @Override
	public boolean defiende(){
		boolean rn = generaAleatorio();
        if(rn == true){
            System.out.println("Defendido con descarga electrica");
        } else {
			System.out.println("no se puede defender pipipi");
		}

		return rn;
    }

	/**
	* Permite descansar un pokemon. Esto es recuperar su PC.
	* NOTA: La recuperación depende del tipo de pokemon.
	* @return true si el pokemon puede descansar, false en otro caso.
	* Un pokemon no puede aumentar la PC si la PC sobrepasa de 100.
	*/
    @Override
	public boolean descansa(){
		if(pc > 100){
			System.out.println("No puede descansar");
			return false;
		} else {
			pc += 12;
		}
		return true;
    }

	/**
	* Permite evolucionar un pokemon.
	* Un pokemon evoluciona dependiendo de su tipo. Cuando un pokemon
	* evoluciona aumenta la intensidad de su ataque.
	*/
    @Override
	public void evoluciona(){
		double evolucion = intensidadAtaque + (intensidadAtaque * 20 / 100);
		System.out.println("El pokemon evoluciono. \nIntensidad aumento a: " + evolucion);
    }

	/**
	* Genera un valor booleano aleatorio.
	* @return true si el generador aleatorio genera un valor true, false en otro caso.
	*/
	protected boolean generaAleatorio(){
		Random rn = new Random();
		return rn.nextBoolean();
	}

	/**
	* Muestra todas las caracteristicas de un pokemon.
	* Ademas de los atributos definidos en esta clase, cada tipo de pokemon
	* cuenta con diferentes atributos extra.
	* @return la representación de un pokemon.
	*/
    @Override
	public String toString(){
        return "nombre: " + nombre 
        + "\nintensidad: " + intensidadAtaque
        + "\nentrenador: " + entrenador
		+ "\nespecial electrico: " + intensidadElectrico;
    }
}
