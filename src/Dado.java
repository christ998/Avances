import java.util.Random;
public class Dado {
    int numero;
    
    public Dado(int caras){
    if(caras == 6){
    setCara1();
    }
    if(caras == 8){
    setCara2();
    }
    }
   
   
 private void setCara1(){
 this.numero = (int)(Math.random()*5+1);
 }   
 public int getCara(){
 return this.numero;
 }
 private void setCara2(){
 numero = (int)(Math.random()*7+1);
 }   

   
}
