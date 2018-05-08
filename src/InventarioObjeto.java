import java.util.ArrayList;
import java.util.Scanner;


public class InventarioObjeto {
static ArrayList <ObjetoEquipable> inventarioObjetos = new ArrayList <>();

 public InventarioObjeto(int cant){
 agregarObjeto(cant);
 }

public void agregarObjeto(int cant){
	for(int i=0; i < cant;i++) {
    if(inventarioObjetos.size() == 25){ 
    System.out.println("Ha alcanzado el máximo de objetos equipables");
    }else{
    inventarioObjetos.add(new ObjetoEquipable());
    
    }
   }
	System.out.println("Objetos creados");
}
        
public void quitarObjeto(){
    int c = 1;
    for(int i = 0; i < inventarioObjetos.size();i++){
    System.out.println(""+c+"\t"+"Nombre: "+inventarioObjetos.get(i).getNombreArma());
    c++;
    }
    Scanner sc = new Scanner(System.in);
    System.out.println("Eliga el objeto a quitar" + "1- "+inventarioObjetos.size());
    int pos = sc.nextInt();
    inventarioObjetos.remove(pos-1);
    System.out.println("Objeto eliminado");
    }

 public void filtroRango(int rango){ 
    System.out.println("Rango: "+rango);
    System.out.println("---------------------------");
    int cont = 1;
        
    for(int i = 0; i < inventarioObjetos.size(); i++){
     if(inventarioObjetos.get(i).getRango() == rango){
      System.out.print(cont);
      inventarioObjetos.get(i).mostrarObjeto();
      cont++;
      }
     }
    }
 public void mostrarTodo(){
 for(int i = 0; i < inventarioObjetos.size();i++){
     System.out.println("Nombre: "+inventarioObjetos.get(i).getNombreArma());
     System.out.println("El objeto mejora: "+inventarioObjetos.get(i).getCarac());
     System.out.println("Tiene un rango de: "+inventarioObjetos.get(i).getRango());
     System.out.println("Tiene base: "+inventarioObjetos.get(i).getMejoraBase());
     System.out.println("Tiene una mejora total de: "+inventarioObjetos.get(i).getMejora());
     System.out.println("-------------------------------------------");
 }
 }
 
 
}
