# PacDesarrolloAppRol
Proyecto de un juego de Rol

2.2 Descripción
Consistirá en la programación de las siguientes clases e interfaces en Java:
a.
Una superclase Personaje que consistirá en:
o
Atributos privados:
1.
nombre (String). Nombre del objeto instanciado.
2.
salud (int). Salud actual del objeto instanciado..
3.
nivel (int). Nivel de experiencia del objeto instanciado.
o
Métodos:
1.
Constructor público para inicializar todos los atributos (edad es opcional, tendrás que usar la sobrecarga de métodos)
2.
Getters y Setters públicos de todos los atributos
b.
Una interfaz Guerrero que obligue a la implementación de los métodos:
o
atacar(Personaje). Para atacar a un objeto de la clase Personaje.
o
defender(Personaje). Para defenderse del ataque de un Personaje.
c.
Una subclase PJugador que herede de Personaje e implemente Guerrero, y que consistirá en:
o
Atributos privados adicionales:
1.
edad (int). Edad del objeto instanciado (del PJugador)
2.
ataque (int). Cuantía de daño que provoca el ataque.
3.
defensa (int). Nivel de daño que absorbe la armadura ante un ataque.
o
Métodos:
1.
Constructor público para inicializar todos los atributos. Usa la sobrecarga de métodos para que edad sea opcional. No olvides la llamada al superconstructor.
2.
Getters y Setters públicos para los atributos que no lo tengan heredado.
3.
atacar(Personaje): Envía un ataque a un Personaje equivalente a multiplicar el nivel del PJugador que ataca por su atributo ataque. Si esta cantidad es superior a la salud del Personaje atacado, morirá (su salud será 0). Si no, a la salud de este Personaje se le restarán los puntos del ataque = atributo ataque del PJugador que ataca multiplicado por su nivel.
4.
defender(Personaje): Resta el daño de un ataque de un Personaje (que equivale a su nivel) menos el atributo defensa. Cuando un Personaje lance un ataque a un PJugador, lo hará con una cantidad de daño igual a su nivel. Esa cantidad se verá contrarrestada por el atributo de defensa del PJugador que se defiende del ataque. Si el daño no es superior a la defensa, el PJugador no recibirá daño. Si el daño es superior, recibirá un daño igual a la resta del parámetro enviado menos el atributo de defensa. Si el daño resultante es superior a la salud del PJugador, este muere.

2.3 Tecnologías
Java para el desarrollo, sin ningún otro framework o plugin, elegir el IDE que mejor te parezca.

2.4 Estructura de ficheros
Para la realización se entrega la clase Rol.java, donde se incluye la función main. Solo hay que desarrollar, por tanto, la superclase Personaje, la interfaz Guerrero y la
subclase PJugador, de forma que se obtenga el resultado esperado y descrito en puntos anteriores.
El proyecto debe estar ubicado dentro de un paquete llamado codigo para su correcto funcionamiento.

2.5
Se proporciona una clase Rol con el método main a ejecutar para que puedas probar tu proyecto. También tiene la implementación de otros métodos, como dado, pjAtaca y pnjAtaca que sería interesante que estudies y comprendas lo que hacen.
Aunque se adjunta el fichero, también se va a pegar aquí el contenido de Rol.java:

import java.util.Random;
public class Rol {
private static int dado(int d, int c) {
Random r = new Random();
int res = 0;
for (int i=0; i < d; i++)
res += r.nextInt(c)+1;
return res;
}
private static void pjAtaca(PJugador pj, Personaje pnj) {
if(pj.getSalud()>0 && pnj.getSalud()>0) {
System.out.println(pj.getNombre() + " ataca a "+pnj.getNombre());
//Se llama al método atacar de la clase PJugador
pj.atacar(pnj);
if (pnj.getSalud()>0) {
System.out.println(pnj.getNombre() + " recibe "+(pj.getAtaque()*pj.getNivel())+" puntos de daño "+ "y tiene "+(pnj.getSalud())+" puntos de vida");
} else {
System.out.println(pnj.getNombre() + " ha muerto");
}
}
}
private static void pnjAtaca(Personaje pnj, PJugador pj) {
if(pnj.getSalud()>0 && pj.getSalud()>0) {
System.out.println(pnj.getNombre() + " ataca a "+pj.getNombre());
//Se llama al método defender de la clase PJugador
pj.defender(pnj);
if (pj.getSalud()>0) {
System.out.println(pj.getNombre() + " recibe un ataque de "+pnj.getNombre()+
"y tiene "+(pj.getSalud())+" puntos de vida");
} else {
System.out.println(pj.getNombre() + " ha muerto");
}
}
}
public static void main(String[] args) {
PJugador aragorn = new PJugador("Aragorn", dado(3,100), dado(2,12), dado(1,6), dado(1,4));
PJugador legolas = new PJugador("Legolas", dado(3,100), dado(2,12), dado(1,6), dado(1,4));
PJugador gimli = new PJugador("Gimli", dado(3,100), dado(2,12), dado(1,6), dado(1,4));
Personaje orco = new Personaje("Orco", dado(2,100), dado(1,12));
Personaje urukhai = new Personaje("Urukhai", dado(2,100), dado(1,12));
Personaje troll = new Personaje("Troll", dado(2,100), dado(1,12));
pjAtaca(aragorn,troll);
pjAtaca(legolas,urukhai);
pjAtaca(gimli,orco);
pnjAtaca(troll,aragorn);
pnjAtaca(urukhai,legolas);
pnjAtaca(orco,gimli);
pjAtaca(legolas,troll);
pjAtaca(gimli,urukhai);
pjAtaca(aragorn,orco);
pnjAtaca(troll,legolas);
pnjAtaca(urukhai,gimli);
pnjAtaca(orco,aragorn);
}
}
