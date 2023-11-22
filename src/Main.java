public class Main {
    public static void main(String[] args) {

        Intermedio inter = new Intermedio("master", 2);
        PokemonElectrico poki1 = new PokemonElectrico("kira", 80, inter, 67);
        PokemonElectrico pokiatack = new PokemonElectrico("pips", 89, inter, 90);
        PokemonFuego pokifue = new PokemonFuego("llamasi", 90, inter, 68);

        System.out.println(poki1.ataca(pokiatack));

        System.out.println("Poki se defiende: " + poki1.defiende());

        System.out.println("Poki descansa: " + poki1.descansa());

        System.out.println(poki1.toString());

        System.out.println("\n");
        System.out.println(pokifue.toString());
        System.out.println("\n");

        poki1.evoluciona();
    }
}
