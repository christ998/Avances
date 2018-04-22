import java.util.Random;
import java.util.ArrayList;
public class ObjetoEquipable {
  
  private int rango;  
  private int base;
  private int mejora;
  private String carac;
  private String nombre;
 
  ObjetoEquipable(){
  probabilidad();
  setMejoraBase();
  getMejoraBase();
  caracteristica();
  getCarac();
  setMejora();
  getMejora();
  setNombreArma();
  getNombreArma();
  }
  /*public static void main(String [] args){
  ArrayList <ObjetoEquipable> inventario = new ArrayList<>(15);    
  crearObjetoEquipable(inventario);
  crearObjetoEquipable(inventario);
  mostrarCaracteristicas(inventario);
  }*/
  
  public static ArrayList<ObjetoEquipable> crearObjetoEquipable (ArrayList <ObjetoEquipable> inventario){
   inventario.add(new ObjetoEquipable());
   return inventario;
  }
  
  public void caracteristica(){
   String [] matriz = new String[4];
   matriz[0] = "Ataque";
   matriz[1] = "Defensa";
   matriz[2] = "Velocidad";
   matriz[3] = "Vida";
   int i = (int)(Math.random()*3);
   this.carac = matriz[i];
  }
  public String getCarac(){
  return this.carac;
  }
  public void setNombreArma(){
  String [] nombre = new String [5];
  nombre[0] = "Coraza de espinas";
  nombre[1] = "Botas";
  nombre[2] = "Casco";
  nombre[3] = "Espada gladius";
  nombre[4] = "Poción ancestral";
  int i = (int)(Math.random()*4);
  this.nombre = nombre[i];
  }
  public String getNombreArma(){
  return this.nombre;
  }
  public void probabilidad(){
  int i = (int)(Math.random()*100);
  
  if(i <= 20){
   this.rango = 1;
  }
  if(i > 20 && i<=40){
   this.rango=2;
  }
  if(i > 40 && i <=60){
   this.rango = 3;
  }
  if(i > 60 && i <=75){
   this.rango = 4;
  }
  if(i > 75 && i <=85){
   this.rango = 5;
  }
  if(i > 85 && i <= 90){
   this.rango = 6;
  }
  if(i > 90 && i <=94){
   this.rango = 7;
  }
  if(i > 94 && i <=97){
   this.rango = 8;
  }
  if(i > 97 && i <= 99){
   this.rango = 9;
  }
  if(i == 100){
  this.rango = 10;
  }
  }
  
 public int getRango(){
  return this.rango;  
 } 
   
 public void setMejoraBase(){
  this.base = (int)(Math.random()*8+1);
 }
 
 public int getMejoraBase(){
  return this.base;
 }
 
 public void setMejora(){
  this.mejora = this.base*this.rango;
 }
 
 public int getMejora(){
 return this.mejora;
 }
 public void mostrarObjeto(){
 String msj = "Base: "+this.base+"\t" +"Rango: "+ this.rango +"\t"+ "Mejora total: "+this.mejora;
 System.out.println(msj);
 
 }
 public static void mostrarCaracteristicas(ArrayList <ObjetoEquipable> inventario){
     for(int i = 0; i < inventario.size();i++){
     System.out.println("Nombre: "+inventario.get(i).nombre);    
     System.out.println("El objeto mejora: "+inventario.get(i).carac);
     System.out.println("Tiene un rango de: "+inventario.get(i).rango);
     System.out.println("Tiene base: "+inventario.get(i).base);
     System.out.println("Tiene una mejora total de: "+inventario.get(i).mejora);
     System.out.println("-------------------------------------------");
     }
 }
}


