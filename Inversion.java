/**
 * Write a description of class Inversion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Inversion
{
    // monto= Monto a invertir
    // duracion_dias= Cantidad de días que dura la inversion
   public int monto, duracion_dias;
   // tasa=tasa de interes
   public double tasa;
   // isr = impuesto
   public double isr=0.15/100;
   
   public Inversion(int monto, int duracion_dias,double tasa){
       this.monto=monto;
       this.duracion_dias=duracion_dias;
       this.tasa=tasa/100;
   }
   
   public Inversion(){
       
   }
   
   public double ganancias(){
       // i_bruto= interés bruto (las ganancias de la inversión antes de impuestos
       double i_bruto=monto*duracion_dias*tasa/360;
       double impuesto=monto*isr*duracion_dias/365;
       // i_neto= interés neto (las ganancias después de impuestos)
       double i_neto=i_bruto-impuesto;
       // ganancias= la suma del monto que se invirtió más el interes neto
       double ganancias=monto+i_neto;
       return ganancias;
   }
   
   public String toString(){
       return "La ganancia es " + ganancias();
   }
}
