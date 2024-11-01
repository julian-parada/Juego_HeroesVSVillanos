import java.util.Scanner;
abstract class MiJuego {
    String nombre;
    int vida;
    int poder;
    int velocidad;

    public MiJuego(String nombre, int vida, int poder, int velocidad) {
        this.nombre = nombre;
        this.vida = vida;
        this.poder = poder;
        this.velocidad = velocidad;
      
       
    }
    // Métodos abstractos que las clases hijas deben implementar
    public abstract void atacar(MiJuego objetivo); // Método para realizar ataques
    public abstract void recibirHerida(int herida);  // Método para procesar el daño recibido

    // Getters y Setters para acceder y modificar los atributos
    public String getNombre () {
        return nombre;
    }
    public void setNombre (String nombre) {
        this.nombre = nombre;
    }
    public int getVida () {
        return vida;
    }
    public void setVida (int vida) {
        this.vida = vida;
    }
    public int getPoder () {
        return poder;
    }
    public void setPoder (int poder) {
        this.poder = poder;
    }
    public int getVelocidad () {
        return velocidad;
    }
    public void setVelocidad (int velocidad) {
        this.velocidad = velocidad;
    }

}   

// Clase que representa a los héroes del juego
// Hereda de MiJuego e implementa comportamientos específicos para los héroes

class Heroe extends MiJuego {
    private int nivelBondad;  // Atributo específico de los héroes que afecta su daño

    // nivelBondad que aumenta el daño del héroe
    public Heroe(String nombre, int vida, int poder, int velocidad, int nivelBondad) {
        super(nombre, vida, poder, velocidad);
        this.nivelBondad = nivelBondad; 
    }

    // Implementación del ataque para héroes
    // El daño se calcula usando poder, nivel de bondad y velocidad
    @Override
    public void atacar(MiJuego objetivo) {
        int herida = poder + (nivelBondad/2) + (velocidad/3);
        System.out.println(nombre + " ataca a " + objetivo.getNombre() + " con " + herida + " de herida! " + " con un velocidad de " + velocidad);
        objetivo.recibirHerida(herida);
    }

    // Implementación de recibir daño para héroes
    @Override
    public void recibirHerida(int herida) {
        vida -= herida;
        if (vida < 0) vida = 0;
        System.out.println(nombre + " recibe " + herida + " de herida. Vida restante: " + vida);
    }

    // Poder especial de héroe que aumenta el poder base 
    public void usarPoderEspecial() {
        System.out.println(nombre + " usa su poder especial de heroe!");
        poder *= 1.5;
    }

}

// Clase que representa a los villanos del juego
// Hereda de MiJuego e implementa comportamientos específicos para los villanos
class Villano extends MiJuego {
    private int nivelMaldad;  // Atributo específico de los villanos que afecta su daño

    // nivelMaldad que aumenta el daño del  villano
    public Villano(String nombre, int vida, int poder, int velocidad, int nivelMaldad) {
        super(nombre, vida, poder, velocidad);
        this.nivelMaldad = nivelMaldad; 
    }

    // Implementación del ataque para villanos
    // El daño se calcula usando poder, nivel de maldad y velocidad
    @Override
    public void atacar(MiJuego objetivo) {
        int herida = poder + (nivelMaldad/2) + (velocidad/4);
        System.out.println(nombre + " ataca a " + objetivo.getNombre() + " con " + herida + " de herida! " + "con un velocidad de " + velocidad);
        objetivo.recibirHerida(herida);
    }

    // Implementación de recibir daño para villanos
    @Override
    public void recibirHerida(int herida) {
        vida -= herida;
        if (vida < 0) vida = 0;
        System.out.println(nombre + " recibe " + herida + " de herida. Vida restante: " + vida);
    }
    
    // Poder especial del villano que aumenta el poder base
    public void usarPoderMaligno() {
        System.out.println(nombre + " usa su poder especial de villano!");
        poder *= 2;
    }

}
// Clase principal del Juego
public class JuegoHeroeVillano {
    public static void main(String[] args) {

        // Creación de los personajes con sus estadísticas iniciales
        Heroe heroe = new Heroe("Super Man", 1000, 180, 185, 195);
        Heroe heroe2 = new Heroe("Mujer Maravilla", 1000, 170, 160, 185);
        Villano villano = new Villano("Hela", 1000, 175, 130, 175);
        Villano villano2 = new Villano("Ego", 1000, 180, 100, 190);

        Scanner scanner = new Scanner(System.in);
        String Heroe;  // Almacena la elección del héroe
        String Villano;  // Almacena la elección del villano

        // Mostrar opciones de héroes y obtener selección del usuario
        System.out.println("escoge un heroe para la pelea: (ingresa la letra del heroe que deseas) ");

        System.out.println(" a " + heroe.getNombre() + " tiene una vida " + heroe.getVida() + " un poder de " + heroe.getPoder() + " una velocidad de " + heroe.getVelocidad() );

        System.out.println( " b " + heroe2.getNombre() + " tiene una vida " + heroe2.getVida() + " un poder de " + heroe2.getPoder() + " una velocidad de " + heroe2.getVelocidad() );

        Heroe = scanner.nextLine();

        // Mostrar opciones de villanos y obtener selección del usuario
        System.out.println("escoge un un villano para la pelea: ");

        System.out.println(" a " + villano.getNombre() + " tiene una vida " + villano.getVida() + " un poder de " + villano.getPoder() + " una velocidad de " + villano.getVelocidad() );

        System.out.println(" b " + villano2.getNombre() + " tiene una vida " + villano2.getVida() + " un poder de " + villano2.getPoder() + " una velocidad de " + villano2.getVelocidad() );
        Villano = scanner.nextLine();

        // Lógica de combate basada en las selecciones del usuario
        if ( Heroe.equalsIgnoreCase("A") && Villano.equalsIgnoreCase("B")){    
            // Combate entre Superman y Ego
            System.out.println("Comienza la batalla!");
            heroe.atacar(villano2);
            villano2.usarPoderMaligno();
            villano2.atacar(heroe);
            heroe.usarPoderEspecial();
            heroe.atacar(villano2);

            // Determinar el ganador
            if (heroe.vida <= 0) {
                System.out.println(villano2.nombre + " ha ganado la batalla!");
            } else {
                System.out.println(heroe.nombre + " ha ganado la batalla!");
            }
        }     
        if (Heroe.equalsIgnoreCase("B") && Villano.equalsIgnoreCase("B")){                
            // Combate entre Mujer Maravilla y Ego
            System.out.println("Comienza la batalla!");
            heroe2.atacar(villano2);
            villano2.usarPoderMaligno();
            villano2.atacar(heroe2);
            heroe2.usarPoderEspecial();
            heroe2.atacar(villano2);

            // Determinar el ganador  
            if (heroe2.vida <= 0) {
                System.out.println(villano2.nombre + " ha ganado la batalla!");
            } else {
                System.out.println(heroe2.nombre + " ha ganado la batalla!");
            }
        }   
        if (Heroe.equalsIgnoreCase("A") && Villano.equalsIgnoreCase("A")){               
                    
            // combate entre Super Man y Hela
            System.out.println("Comienza la batalla!");
            heroe.atacar(villano);
            villano.usarPoderMaligno();
            villano.atacar(heroe);
            heroe.usarPoderEspecial();
            heroe.atacar(villano);
        
            if (heroe.vida <= 0) {
                System.out.println(villano.nombre + " ha ganado la batalla!");
            } else {
                System.out.println(heroe.nombre + " ha ganado la batalla!");
            }
        } 
        if( Heroe.equalsIgnoreCase("B") && Villano.equalsIgnoreCase("A")){               
            // combate entre Mujer maravilla y Hela
            System.out.println("Comienza la batalla!");
            heroe2.atacar(villano);
            villano.usarPoderMaligno();
            villano.atacar(heroe2);
            heroe2.usarPoderEspecial();
            heroe2.atacar(villano);

            // Determinar el ganador 
            if (heroe2.vida <= 0) {
                System.out.println(villano.nombre + " ha ganado la batalla!");
            } else {
                System.out.println(heroe2.nombre + " ha ganado la batalla!");
            }
        
        } 
        if (!Heroe.equalsIgnoreCase("B") && !Villano.equalsIgnoreCase("A")){
            System.out.println("las letras que ingresaste son diferentes (a) y (b)");
        }
        scanner.close();
        
    }    

}
