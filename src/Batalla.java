import java.util.ArrayList;
import java.util.Scanner;
public class Batalla {
    private ArrayList<Luchador> peleadores = new ArrayList<>();
    private ArrayList<Monstruo> monstruos = new ArrayList<>();
    int dif;
    
        
    public Batalla(){
       
     asignarMonstruo();
         
     asignarPeleadores();
     lanzarDado();
     
     pelea();
     
    }
   
    public void asignarPeleadores(){
     Scanner leer = new Scanner(System.in); 
     System.out.println("Eliga la cantidad de luchadores que van a la batalla "); 
     int cant = leer.nextInt();
       
     InventarioLuchador.mostrarInventario();
     System.out.println("Elija los "+cant+" luchadores (debe ingresar la posición)");
     
     for(int i=0; i < cant; i++){
     int pos = leer.nextInt();    
     peleadores.add(InventarioLuchador.inventario.get(pos-1));
     
     System.out.println("Luchador listo para la batalla");
     }
     System.out.println("Luchadores listos");
    }
    
    public void asignarMonstruo(){
    Monstruo rival = new Monstruo();
    monstruos.add(rival);
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
     for(int i=0; i < peleadores.size();i++){
       for(int j=i+1; j < peleadores.size();j++){
        if(peleadores.get(i).getVel() < peleadores.get(j).getVel()){
         aux.add(0,peleadores.get(i));
         peleadores.add(i,peleadores.get(j));
         peleadores.add(j,aux.get(0));
         }
      }  
     }
    } //Este método ordena el Array de peleadores que van a pelear segun sus velocidades, de mayor a menor
    public int casoDado(int daño){
     if(this.dif > 0){
     daño = daño*this.dif;
     }
     if(this.dif < 0){
     daño = daño*getDado();
     }
     return daño;     
    }
    
    public void ataqueJugador(int i){
    double ataq = peleadores.get(i).getAtk();
    /* if((peleadores.get(i).getFaccion().equals("Agua")&& monstruos.get(0).getFaccion().equals("Fuego"))|| (peleadores.get(i).getFaccion().equals("Fuego")) && monstruos.get(0).getFaccion().equals("Planta")){
      ataq = ataq*1.5;   
     }
     if(peleadores.get(i).getFaccion().equals("Planta")&& monstruos.get(0).getFaccion().equals("Agua")){
     ataq = ataq*1.5;
     }*/
     if(this.dif > 0){
     double daño = (ataq-monstruos.get(0).getDef())*getDado();
     monstruos.get(0).disminuirVida(daño);
     }
     if(this.dif == 0 || this.dif < 0){
     double daño = ataq-monstruos.get(0).getDef();
     monstruos.get(0).disminuirVida(daño); //El metodo disminuir vida esta en la clase Monstruo
     }
     }
    
    public void ataqueMonstruo(int i){
    double ataq = monstruos.get(0).getAtk();
     /*if((monstruos.get(0).getFaccion().equals("Agua")&& peleadores.get(i).getFaccion().equals("Fuego"))|| (monstruos.get(0).getFaccion().equals("Fuego")) && peleadores.get(i).getFaccion().equals("Planta")){
      ataq = ataq*1.5;   
     }
     if(monstruos.get(0).getFaccion().equals("Planta")&& peleadores.get(i).getFaccion().equals("Agua")){
     ataq = ataq*1.5;
     }*/
     if(this.dif < 0){
     double daño = (ataq-peleadores.get(i).getDefensa())*getDado();
     peleadores.get(i).disminuirVida(daño);
     }
     if(this.dif == 0 || this.dif > 0){
     double daño = ataq-peleadores.get(i).getDefensa();
     peleadores.get(i).disminuirVida(daño); //El metodo disminuir vida esta en la clase Luchador
     }
    }
    public void pelea(){
    
      for(int i=0; i < peleadores.size(); i++){    
       do{
        ataqueJugador(i);
    
        ataqueMonstruo(i);
     
       }while(peleadores.get(i).getVida()<= 0 || monstruos.get(0).getHp()<=0);
      if(monstruos.get(0).getHp()<=0){
        System.out.println("HAS GANADO");
      }else{
        System.out.println("Murio tu luchador"); 
       }
      
    }
    System.out.println("PERDISTE LA BATALLA :/");
    } 
}
    

     
    
    

    
    
    
    

