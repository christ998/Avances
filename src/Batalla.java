import java.util.ArrayList;
import java.util.Scanner;
public class Batalla {
    private ArrayList<Luchador> peleadores = new ArrayList<>();
    private ArrayList<Monstruo> monstruos = new ArrayList<>();
    int dif;
    
        
    public Batalla(){
     asignarMonstruo();
     asignarPeleadores();
       
     mostrarPeleadores();
     pelea();
     
     
    }
   
    public void asignarPeleadores(){
     Scanner leer = new Scanner(System.in); 
     System.out.println("Eliga la cantidad de luchadores que van a la batalla "); 
     int cant = leer.nextInt();
       
     System.out.println("Nombre"+"\t\t"+"Facción"+"\t\t"+"Rango");
     System.out.println("---------------------------------------------");
       for(int i=0; i < InventarioLuchador.inventario.size(); i++){
        System.out.print(i+1);
        InventarioLuchador.inventario.get(i).mostrarLuchador();
       }
     System.out.println("Elija los "+cant+" luchadores (debe ingresar la posición)");
         
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
    
    public void mostrarPeleadores(){
    System.out.println("Nombre"+"\t\t"+"Facción"+"\t\t"+"Rango"+"\t\t"+"Velocidad");
    System.out.println("--------------------------------------------------");
      for(int i=0; i < peleadores.size(); i++){
       System.out.print(i+1);
       peleadores.get(i).mostrarLuchador();
      }
    }
       
    public void ataqueJugador(int i){
    double ataq = peleadores.get(i).getAtk();
    double daño;
     if((peleadores.get(i).getFaccion().equals("Agua")&& monstruos.get(0).getFaccion().equals("Fuego"))|| (peleadores.get(i).getFaccion().equals("Fuego")) && monstruos.get(0).getFaccion().equals("Planta")){
      daño = ataq*1.5;   
     }else{
     if(peleadores.get(i).getFaccion().equals("Planta")&& monstruos.get(0).getFaccion().equals("Agua")){
     daño = ataq*1.5;
     }else{
      daño=ataq*0.75;
      }
     }
                            
     if(this.dif > 0){
     daño = (ataq-monstruos.get(0).getDef())*getDado();
      if(daño < 0){
       daño = 0;
      }
     }else{
      daño = daño-monstruos.get(0).getDef();
        if(daño < 0){
        daño = 0;
        }
     }
     monstruos.get(0).disminuirVida(daño);//El metodo disminuir vida esta en la clase Monstruo
    }
     
    
    public void ataqueMonstruo(int i){
    double ataq = monstruos.get(0).getAtk();
    double daño;
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
     daño = (ataq-peleadores.get(i).getDefensa())*getDado();
        if(daño < 0){
        daño = 0;
        }
     }else{
     daño = ataq-peleadores.get(i).getDefensa();
      if(daño < 0){
       daño = 0;
      }
    }
     peleadores.get(i).disminuirVida(daño);//El metodo disminuir vida esta en la clase Luchador
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
    

     
    
    

    
    
    
    

