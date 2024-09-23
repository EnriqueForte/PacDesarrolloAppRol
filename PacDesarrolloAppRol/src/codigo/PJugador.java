package codigo;

public class PJugador extends Personaje implements Guerrero {
    // Atributos privados adicionales
    private int edad;
    private int ataque;
    private int defensa;

    // Constructor público para inicializar todos los atributos
    public PJugador(String nombre, int salud, int nivel, int ataque, int defensa) {
        super(nombre, salud, nivel); // Llamada al constructor de la superclase
        this.setAtaque(ataque);
        this.setDefensa(defensa);
    }
    
    // Constructor sobrecargado (con edad)
    public PJugador(String nombre, int salud, int nivel, int edad, int ataque, int defensa) {
        this(nombre, salud, nivel, ataque, defensa);
        this.edad = edad;
    }  
    
 // Getters y Setters públicos para los atributos que no lo tengan heredado
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	// Implementacion del método atacar de la interfaz Guerrero
	@Override
	public void atacar(Personaje objetivo) {
		int daño = this.ataque * this.getNivel();
		if(daño >= objetivo.getSalud()) {
			objetivo.setSalud(0);			
		}else
			objetivo.setSalud(objetivo.getSalud() - daño);				
	}

	// Implementacion del método defender de la interfaz Guerrero	
	@Override
	public void defender(Personaje atacante) {
		int daño = atacante.getNivel() - this.defensa;
		if(daño <= 0) { 			
		}else {
            this.setSalud(this.getSalud() - daño);
        }		
		
	}
	
}
