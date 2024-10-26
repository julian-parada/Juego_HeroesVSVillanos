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
    public abstract void atacar(MiJuego objetivo);
    public abstract void recibirHerida(int herida);

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
// clase Heroe

class opcion extends MiJuego {
    private int nivelBondad;
    public opcion(String nombre, int vida, int poder, int velocidad, int nivelBondad) {
        super(nombre, vida, poder, velocidad);
        this.nivelBondad = nivelBondad; 
    }

    @Override
    public void atacar(MiJuego objetivo) {
        int herida = poder + (nivelBondad/2) + (velocidad/3);
        System.out.println(nombre + " ataca a " + objetivo.getNombre() + " con " + herida + " de herida! " + " con un velocidad de " + velocidad);
        objetivo.recibirHerida(herida);
    }

    @Override
    public void recibirHerida(int herida) {
        vida -= herida;
        if (vida < 0) vida = 0;
        System.out.println(nombre + " recibe " + herida + " de herida. Vida restante: " + vida);
    }

    public void usarPoderEspecial() {
        System.out.println(nombre + " usa su poder especial de heroe!");
        poder *= 1.5;
    }

}

// clase Villano
class opcion2 extends MiJuego {
    private int nivelMaldad;
    public opcion2(String nombre, int vida, int poder, int velocidad, int nivelMaldad) {
        super(nombre, vida, poder, velocidad);
        this.nivelMaldad = nivelMaldad; 
    }
    
    @Override
    public void atacar(MiJuego objetivo) {
        int herida = poder + (nivelMaldad/2) + (velocidad/4);
        System.out.println(nombre + " ataca a " + objetivo.getNombre() + " con " + herida + " de herida! " + "con un velocidad de " + velocidad);
        objetivo.recibirHerida(herida);
    }

    @Override
    public void recibirHerida(int herida) {
        vida -= herida;
        if (vida < 0) vida = 0;
        System.out.println(nombre + " recibe " + herida + " de herida. Vida restante: " + vida);
    }

    public void usarPoderMaligno() {
        System.out.println(nombre + " usa su poder especial de villano!");
        poder *= 2;
    }

}
// Clase principal del Juego
public class Mio {
    public static void main(String[] args) {

        // Crear personajes
        opcion heroe = new opcion("Super Man", 1000, 180, 185, 195);
        opcion2 villano = new opcion2("Hela", 1000, 175, 130, 175);
        opcion heroe2 = new opcion("Mujer Maravilla", 1000, 170, 160, 185);
        opcion2 villano2 = new opcion2("Ego", 1000, 180, 100, 190);

        Scanner scanner = new Scanner(System.in);
        String opcion;
        String opcion2;

        System.out.println("escoge un heroe para la pelea: (ingresa la letra del heroe que deseas) ");

        System.out.println(" a " + heroe.getNombre() + " tiene una vida " + heroe.getVida() + " un poder de " + heroe.getPoder() + " una velocidad de " + heroe.getVelocidad() );

        System.out.println( " b " + heroe2.getNombre() + " tiene una vida " + heroe2.getVida() + " un poder de " + heroe2.getPoder() + " una velocidad de " + heroe2.getVelocidad() );

        opcion = scanner.nextLine();

        System.out.println("escoge un un villano para la pelea: ");

        System.out.println(" a " + villano.getNombre() + " tiene una vida " + villano.getVida() + " un poder de " + villano.getPoder() + " una velocidad de " + villano.getVelocidad() );

        System.out.println(" b " + villano2.getNombre() + " tiene una vida " + villano2.getVida() + " un poder de " + villano2.getPoder() + " una velocidad de " + villano2.getVelocidad() );
        opcion2 = scanner.nextLine();

        if ( opcion.equalsIgnoreCase("A") && opcion2.equalsIgnoreCase("B")){    
            // Ejemplo de interaccion
            System.out.println("Comienza la batalla!");
            heroe.atacar(villano2);
            villano2.usarPoderMaligno();
            villano2.atacar(heroe);
            heroe.usarPoderEspecial();
            heroe.atacar(villano2);
        
            if (heroe.vida <= 0) {
                System.out.println(villano2.nombre + " ha ganado la batalla!");
            } else {
                System.out.println(heroe.nombre + " ha ganado la batalla!");
            }
        }     
        if (opcion.equalsIgnoreCase("B") && opcion2.equalsIgnoreCase("B")){                
            // Ejemplo de interaccion
            System.out.println("Comienza la batalla!");
            heroe2.atacar(villano2);
            villano2.usarPoderMaligno();
            villano2.atacar(heroe2);
            heroe2.usarPoderEspecial();
            heroe2.atacar(villano2);
        
            if (heroe2.vida <= 0) {
                System.out.println(villano2.nombre + " ha ganado la batalla!");
            } else {
                System.out.println(heroe2.nombre + " ha ganado la batalla!");
            }
        }   
        if (opcion.equalsIgnoreCase("A") && opcion2.equalsIgnoreCase("A")){               
                    
            // Ejemplo de interaccion
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
        if( opcion.equalsIgnoreCase("B") && opcion2.equalsIgnoreCase("A")){               
             // Ejemplo de interaccion
            System.out.println("Comienza la batalla!");
            heroe2.atacar(villano);
            villano.usarPoderMaligno();
            villano.atacar(heroe2);
            heroe2.usarPoderEspecial();
            heroe2.atacar(villano);
        
            if (heroe2.vida <= 0) {
                System.out.println(villano.nombre + " ha ganado la batalla!");
            } else {
                System.out.println(heroe2.nombre + " ha ganado la batalla!");
            }
        
        } 
        if (!opcion.equalsIgnoreCase("B") && !opcion2.equalsIgnoreCase("A")){
            System.out.println("las letras que ingresaste son diferentes a (a) y (b)");
        }
        scanner.close();
        
    }    

}