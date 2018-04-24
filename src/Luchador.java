import java.util.Random;
import java.util.Scanner;

public class Luchador{
           
     int atk;
     int def;
     double vida;
     int vel;
     int rango;
     String nombre;
     String nombreArma;
     String faccion;
    
    Luchador(){
     atk();
     defensa();
     vel();
     vida();
     this.rango = estrellas();
     this.atk = getAtk()*this.rango; 
     this.def = getDefensa()*this.rango;
     this.vel = getVel()*this.rango;
     this.vida = getVida()*this.rango;
     this.nombre = elegirNombre(nombres());
     this.faccion = elegirFaccion(faccion());
     this.nombreArma = "No posee armas";
     }
            
    public void mostrarLuchador(){
     String msj ="";
     msj= "\t"+this.nombre;
     msj+="\t\t"+this.faccion;
     msj+="\t\t"+this.rango;  
     msj+="\t\t"+this.vel;     
     System.out.println(msj);
    }
    public String[] nombres(){
     String [] peleadores  = new String[15];
     peleadores[0]="Takle";
     peleadores[1]="Astryd";
     peleadores[2]="Vend";
     peleadores[3]="meshias";
     peleadores[4]="Lucifer";
     peleadores[5]="Scorp";
     peleadores[6]="Jade";
     peleadores[7]="Rain";
     peleadores[8]="Reiko";
     peleadores[10]="Raiden";
     peleadores[11]="SubZero";
     peleadores[12]="Jax";
     peleadores[13]="Yasuo";
     peleadores[14]="Garen";
     return peleadores;
    }
    public String elegirNombre(String []peleadores){
     int i = (int)(Math.random()*15);
     String name = peleadores[i];
     return name;
    }
    public void equiparArma(){
    Scanner leer = new Scanner(System.in);
    int pos = 1;    
    for(int i = 0; i < InventarioObjeto.inventarioObjetos.size();i++){
     System.out.println(""+pos+" Nombre: "+InventarioObjeto.inventarioObjetos.get(i).getNombreArma());
     System.out.println("El objeto mejora: "+InventarioObjeto.inventarioObjetos.get(i).getCarac());
     System.out.println("Tiene una mejora total de: "+InventarioObjeto.inventarioObjetos.get(i).getMejora());
     System.out.println("-------------------------------------------");
     pos++;
    }
    System.out.println("Elija el arma a equipar ");
     int num = leer.nextInt();
     
     if(InventarioObjeto.inventarioObjetos.get(num-1).getCarac().equals("Ataque")){
     this.atk = this.atk + InventarioObjeto.inventarioObjetos.get(num-1).getMejora();
     InventarioObjeto.inventarioObjetos.remove(num-1);
     System.out.println("Ataque mejorado");
     }  
     
     if(InventarioObjeto.inventarioObjetos.get(num-1).getCarac().equals("Defensa")){
     this.def = this.def + InventarioObjeto.inventarioObjetos.get(num-1).getMejora();
     InventarioObjeto.inventarioObjetos.remove(num-1);
     System.out.println("Defensa mejorada");
     }
     
     if(InventarioObjeto.inventarioObjetos.get(num-1).getCarac().equals("Vida")){
     this.vida = this.vida +InventarioObjeto.inventarioObjetos.get(num-1).getMejora();
     InventarioObjeto.inventarioObjetos.remove(num-1);
     System.out.println("Vida mejorada");
     }
     
     if(InventarioObjeto.inventarioObjetos.get(num-1).getCarac().equals("Velocidad")){
     this.vel = this.vel + InventarioObjeto.inventarioObjetos.get(num-1).getMejora();
     InventarioObjeto.inventarioObjetos.remove(num-1);
     System.out.println("Velocidad mejorada");
     }
    }
    
    public String[] faccion(){
     String [] faccion = new String[3];
     faccion[0]="Agua";
     faccion[1]="Fuego";
     faccion[2]="Planta";
     return faccion;
    }
    public String elegirFaccion(String[]faccion){
     int i = (int)(Math.random()*3);
     String tipo = faccion[i];
     return tipo;
    }
        
    public int estrellas(){
     int estrellas = (int)(Math.random()*100);
    
     if(estrellas < 40){
      estrellas = 1;
    }
     if(estrellas >= 40 & estrellas < 70){
      estrellas = 2;   
    }
     if(estrellas >= 70 & estrellas < 85){
      estrellas = 3;
    }
     if(estrellas >= 85 & estrellas < 95){
      estrellas = 4;
    }
     if(estrellas >= 95){
      estrellas = 5;
    }
     return estrellas;
    }
    public void atk(){
     this.atk = (int)(Math.random()*50+20);
    }
    public int getAtk(){
     return this.atk;
    }
    public void vida(){
     this.vida = (int)(Math.random()*300+200);
    }
    public double getVida(){
    return this.vida;
    }
    public void defensa(){
     this.def = (int)(Math.random()*20+5);
    }
    public int getDefensa(){
    return this.def;
    }
    public void vel(){
     this.vel = (int)(Math.random()*90+10);
    }
    public int getVel(){
    return this.vel;
    }
    public String getFaccion(){
    return this.faccion;
    }
    public void disminuirVida(double daño){
    this.vida = this.vida -daño;
    }
    
    
    }
   
    

    

    
    
   

