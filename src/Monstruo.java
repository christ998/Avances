import java.util.Random;
import java.util.ArrayList;
public class Monstruo {
    
  private double hp;
  private int atk;
  private int def;
  private int spd;
  private String faccion;
  ArrayList <ObjetoEquipable> dropeos = new ArrayList<>();
  
  public Monstruo(){
  crearMonstruo();
  
  } // El constructor se encargará de crear los monstruos (objetos de la clase Monstruo) con sus respectivos atributos
  
 private void setHp(){
 this.hp = (int)(Math.random()*500+3500);
 }
 public double getHp(){
 return this.hp;
 }
 private void setAtk(){
 this.atk = (int)(Math.random()*500+1000);
 }
 public int getAtk(){
 return this.atk;
 }
 private void setDef(){
 this.def = (int)(Math.random()*20+5);
 }
 public int getDef(){
 return this.def;
 }
 private void setSpd(){
 this.spd = (int)(Math.random()*90+10);
 }
 public int getSpd(){
 return this.spd;
 }
 public String[] faccion(){
 String [] faccion = new String[3];
 faccion[0]="Agua";
 faccion[1]="Fuego";
 faccion[2]="Planta";
 return faccion;
 }
public String elegirFaccion(String[]faccion){
    int i = (int)(Math.random()*2);
     String tipo = faccion[i];
     return tipo;
    }
 private void crearMonstruo(){
  setHp();
  setAtk();
  setDef();
  setSpd();
  faccion = elegirFaccion(faccion());
 }
 private ArrayList<ObjetoEquipable> getObjeto(){
  return dropeos;
 }
 public String getFaccion(){
 return this.faccion;
 }
 private void crearObjetoDropeable(ArrayList <ObjetoEquipable> array){
 array.add(new ObjetoEquipable());
 }
 public void mostrarObjetoDropeable(ArrayList <ObjetoEquipable> array){
     System.out.println("Nombre: "+array.get(0).getNombreArma());    
     System.out.println("El objeto mejora: "+array.get(0).getCarac());
     System.out.println("Tiene un rango de: "+array.get(0).getRango());
     System.out.println("Tiene una mejora total de: "+array.get(0).getMejora());
     System.out.println("-------------------------------------------");
 }
 public void disminuirVida(double daño){
 this.hp = this.hp - daño;
 }
}
