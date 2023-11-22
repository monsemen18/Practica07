import java.util.Random;

public class PokemonPsiquico extends Pokemon{

	/** Intensidad del ataque de tipo psiquico */
    protected int intensidadPsiquico;

    /** Indicador de efecto confundir en otro pokemon */
    protected boolean confundir;

    final protected String TIPO = "Psiquico";

    public PokemonPsiquico(String nombre, int intensidad, Entrenador entrenador, int especialPsiquico) {
        super(nombre, intensidad, entrenador);
        this.intensidadPsiquico = especialPsiquico;
        this.confundir = false;
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
            System.out.println("Defendido con jaquecas");
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
        return false;
    }

	/**
	* Permite evolucionar un pokemon.
	* Un pokemon evoluciona dependiendo de su tipo. Cuando un pokemon
	* evoluciona aumenta la intensidad de su ataque.
	*/
    @Override
	public void evoluciona(){
		double evolucion = intensidadAtaque + (intensidadAtaque * 35 / 100);
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
		+ "\nespecial electrico: " + intensidadPsiquico
		+ "\nelemento: " + TIPO;
    }
}
