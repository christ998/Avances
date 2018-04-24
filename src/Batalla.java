import java.util.ArrayList;
import java.util.Scanner;
public class Batalla {
    private ArrayList<Luchador> peleadores = new ArrayList<>();
    private ArrayList<Monstruo> monstruos = new ArrayList<>();
    int dif;
    
        
    public Batalla(){
     asignarMonstruo();
     asignarPeleadores();
     ordenVelocidad();  
     mostrarPeleadores();
     pelea();
     
     
    }
   
    public void asignarPeleadores(){
     Scanner leer = new Scanner(System.in); 
     System.out.println("Eliga la cantidad de luchadores que van a la batalla "); 
     int cant = leer.nextInt();
       
     System.out.println("Nombre"+"\t\t"+"Facci�n"+"\t\t"+"Rango");
     System.out.println("---------------------------------------------");
       for(int i=0; i < InventarioLuchador.inventario.size(); i++){
        System.out.print(i+1);
        InventarioLuchador.inventario.get(i).mostrarLuchador();
       }
     System.out.println("Elija los "+cant+" luchadores (debe ingresar la posici�n)");
         
     for(int i=0; i < cant; i++){
     int pos = leer.nextInt();
     peleadores.add(InventarioLuchador.inventario.get(pos-1));
     System.out.println("Luchador listo para la batalla");
     }
     System.out.println("Luchadores listos");
    }
    public void asignarMonstruo(){
     monstruos.add(new Monstruo());
    }
    
    public void lanzarDado(){
    Dado dado1 = new Dado(8);
    Dado dado2 = new Dado(6);
    this.dif = dado1.getCara()-dado2.getCara();
    System.out.println("La diferencia en el lanzamiento de dados es: "+this.dif);
    }
    
    public int getDado(){
    return Math.abs(this.dif);
    }
    
    public void ordenVelocidad(){
      ArrayList <Luchador> aux = new ArrayList<>(1);  
     for(int i=0; i < (peleadores.size()-1);i++){
       for(int j=i+1; j < peleadores.size();j++){
        if(peleadores.get(i).getVel() < peleadores.get(j).getVel()){
         aux.add(0,peleadores.get(i));
         peleadores.add(i,peleadores.get(j));
         peleadores.remove(i+1);
         peleadores.add(j,aux.get(0));
         peleadores.remove(j+1);
         }
      }  
     }
    } //Este m�todo ordena el Array de peleadores que van a pelear segun sus velocidades, de mayor a menor
    
    public void mostrarPeleadores(){
    System.out.println("Nombre"+"\t\t"+"Facci�n"+"\t\t"+"Rango"+"\t\t"+"Velocidad");
    System.out.println("--------------------------------------------------");
      for(int i=0; i < peleadores.size(); i++){
       System.out.print(i+1);
       peleadores.get(i).mostrarLuchador();
      }
    }
       
    public void ataqueJugador(int i){
    double ataq = peleadores.get(i).getAtk();
    double da�o;
     if((peleadores.get(i).getFaccion().equals("Agua")&& monstruos.get(0).getFaccion().equals("Fuego"))|| (peleadores.get(i).getFaccion().equals("Fuego")) && monstruos.get(0).getFaccion().equals("Planta")){
      da�o = ataq*1.5;   
     }else{
     if(peleadores.get(i).getFaccion().equals("Planta")&& monstruos.get(0).getFaccion().equals("Agua")){
     da�o = ataq*1.5;
     }else{
      da�o=ataq*0.75;
      }
     }
                            
     if(this.dif > 0){
     da�o = (ataq-monstruos.get(0).getDef())*getDado();
      if(da�o < 0){
       da�o = 0;
      }
     }else{
      da�o = da�o-monstruos.get(0).getDef();
        if(da�o < 0){
        da�o = 0;
        }
     }
     monstruos.get(0).disminuirVida(da�o);//El metodo disminuir vida esta en la clase Monstruo
    }
     
    
    public void ataqueMonstruo(int i){
    double ataq = monstruos.get(0).getAtk();
    double da�o;
    if((monstruos.get(0).getFaccion().equals("Agua")&& peleadores.get(i).getFaccion().equals("Fuego"))|| (monstruos.get(0).getFaccion().equals("Fuego")) && peleadores.get(i).getFaccion().equals("Planta")){
      ataq = ataq*1.5;   
     }else{
     if(monstruos.get(0).getFaccion().equals("Planta")&& peleadores.get(i).getFaccion().equals("Agua")){
     ataq = ataq*1.5;
     }else{
       ataq = ataq*0.75;  
      }
     }
     
     if(this.dif < 0){
     da�o = (ataq-peleadores.get(i).getDefensa())*getDado();
        if(da�o < 0){
        da�o = 0;
        }
     }else{
     da�o = ataq-peleadores.get(i).getDefensa();
      if(da�o < 0){
       da�o = 0;
      }
    }
     peleadores.get(i).disminuirVida(da�o);//El metodo disminuir vida esta en la clase Luchador
    }
    
    public void pelea(){
      for(int i=0; i < peleadores.size(); i++){ //Este for sirve para que vayan peleando "en fila" los luchadores, si muere uno, sigue el siguiente del Array   
       do{
        ataqueJugador(i);
        ataqueMonstruo(i);
      }while(peleadores.get(i).getVida()>0 && monstruos.get(0).getHp()>0);
      if(monstruos.get(0).getHp()<=0){
        System.out.println("Murio el Monstruo");  
        System.out.println("HAS GANADO");
        break;
                     
      }else{
        System.out.println("Murio tu luchador"); 
       }
      
      }
     if(peleadores.get(peleadores.size()-1).getVida() <= 0){
         System.out.println("HAS PERDIDO LA BATALLA :/");
     }
    } 
}
    

     
    
    

    
    
    
    

