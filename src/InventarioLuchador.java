import java.util.ArrayList;
import java.util.Scanner;

   public class InventarioLuchador {
  static ArrayList <Luchador> inventario = new ArrayList <>();


   InventarioLuchador(){
   }
    
   /*public static void main(String [] args){
   agregarLuchador();
   agregarLuchador();
   }*/

    public void agregarLuchador(){
    if(inventario.size() == 25){
    System.out.println("Ha alcanzado el máximo de luchadores");
    }else{
    inventario.add(new Luchador());
    System.out.println("Luchador creado");
    }
    
    }
        
    public void quitarLuchador(){
    Scanner sc = new Scanner (System.in);
    System.out.println("Eliga el luchador a quitar");
    int pos = sc.nextInt();
    inventario.remove(pos);
    System.out.println("Luchador eliminado");
    }
    
    public void filtroFaccion(String faccion){ 
    
    System.out.println("Facción: "+faccion);
    System.out.println("---------------------------");
    int cont = 1;
        
      for(int i = 0; i < inventario.size(); i++){
      if(inventario.get(i).faccion.equals(faccion)){
       System.out.print(cont);
       inventario.get(i).mostrarLuchador();
       cont++;
      }
     }
  
    }
    public void filtroRango(int rango){ 
    System.out.println("Rango: "+rango);
    System.out.println("---------------------------");
    int cont = 1;
        
      for(int i = 0; i < inventario.size(); i++){
      if(inventario.get(i).rango == rango){
       System.out.print(cont);
       inventario.get(i).mostrarLuchador();
       cont++;
      }
     }
    }

    public static void mostrarInventario(){
    System.out.println("Nombre"+"\t\t"+"Facción"+"\t\t"+"Rango");
    System.out.println("---------------------------------------------");
    for(int i=0; i < inventario.size(); i++){
     System.out.print(i+1);
     inventario.get(i).mostrarLuchador();
    }
    }
    public void mostrarTodoUnLuchador(int i){
        System.out.println("Nombre"+"\t\t"+"Facción"+"\t\t"+"Rango"+"\t\t"+"Ataque"+"\t\t"+"Defensa"+"\t\t"+"Vida"+"\t\t"+"Velocidad");
        System.out.println("--------------------------------------------------------------------------------------");
        String msj="";
        msj= inventario.get(i).nombre;
        msj+="\t\t"+inventario.get(i).faccion;
        msj+="\t\t"+inventario.get(i).rango;
        msj+="\t\t"+inventario.get(i).atk;
        msj+="\t\t"+inventario.get(i).def;
        msj+="\t\t"+inventario.get(i).vida;
        msj+="\t\t"+inventario.get(i).vel;
        System.out.println(msj);        
        
    }
    
    public void cantidadLuchadores(ArrayList<Luchador> inventario){
      System.out.println("Hay "+this.inventario.size()+" luchadores");
    }
    public ArrayList getArray(){
     return inventario;
    }
 
     
    }
