import jtoolbox.*;


public class FRAKTAL extends java.lang.Object 
{

   private Rechteck stamm;
   private Kreis krone;

   public FRAKTAL()
   {

      stamm = new Rechteck(90, 200);
      stamm.setzePosition(105, 200);
      stamm.setzeFarbe("dunkelgrau");

      krone = new Kreis(100);
      krone.setzePosition(50, 50);
      krone.setzeFarbe("gruen");
   }

   public static void main(String[] args)
   {
      new FRAKTAL();
   }
   
}