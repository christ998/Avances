import java.util.Scanner;

public class Main {

    
    public static void main(String[] args) {
      Scanner lr = new Scanner (System.in);
      System.out.println("Bienvenido");
      System.out.println("Para jugar debes crear tus luchadores");
      int cant;
      do {
      System.out.println("Cuantos luchadores quieres crear? (puedes elegir un máximo de 25)");
      cant = lr.nextInt();
      if(cant > 25) {
    	  System.out.println("No puedes elejir más de 25 luchadores");
      }
      if(cant <= 0) {
    		  System.out.println("Debes tener al menos 1 luchador");
      }
      }while(cant > 25 || cant <=0);
    
          InventarioLuchador inv = new InventarioLuchador(cant);
          System.out.println("Tambien puedes elegir una cantidad de armas para agregar a tu inventario");
          do {
          System.out.println("Elija la cantidad de armas que desea tener en el inventario (máximo 25)");
          cant = lr.nextInt();
          }while(cant > 25 || cant < 0 );
          InventarioObjeto iob = new InventarioObjeto(cant);
          int sel;
          do {
          System.out.println("1. Seleccionar luchadores");
          System.out.println("2. Cantidad de luchadores en inventario");
          System.out.println("3. Agregar Luchadores");
          System.out.println("4. Quitar Luchadores");
          System.out.println("5. Agregar armas");
          System.out.println("6. Salir");
          sel = lr.nextInt();
          
          switch(sel) {
          case 1: Batalla bat = new Batalla(); 
                  int sele;
                  do{ System.out.println("\n"+":MENU:");
                	  System.out.println("1. Iniciar batalla"+"\n"+"2.Agregar arma a luchadores"+"\n"+"3.Cantidad de luchadores para la batalla ");
                      sele = lr.nextInt();
                  switch(sele){
                  
                  case 1:System.out.println("Estos serán tus luchadores para la batalla");
                	     bat.mostrarPeleadores(); 
                	     bat.pelea();
                	     break;
                  case 2: bat.mostrarPeleadores();
                          System.out.println("Selecciona Luchador: ");
                          int luc = lr.nextInt();
                          bat.getPeleadores().get(luc-1).equiparArma();
                          continue;
                  case 3: System.out.println("Hay "+bat.getPeleadores().size()+" para la batalla");        
                          continue;
                  }
                  }while(sele != 1);     
                  break;
          case 2: inv.cantidadLuchadores();
                  continue;
          case 3: System.out.println("Cuantos luchadores quiere crear");
                  cant = lr.nextInt();
                  inv.agregarLuchador(cant);
                  continue;
          case 4: System.out.println("Cuantos luchadores quiere quitar?");
                  cant = lr.nextInt();
                  inv.quitarLuchador(cant);
                  continue;
          case 5:System.out.println("Cuantas armas desea agregar?");
          		 cant = lr.nextInt();
        	     iob.agregarObjeto(cant);  
        	     continue;
          case 6: break;     
       }
          }while(sel > 1 && sel < 5);  
      }                     
}

      
      

