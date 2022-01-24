import java.util.Scanner;

public class principal {

    public static int GCD(int a, int b){

        int dividendo = Math.max(a, b);
        int divisor = Math.min(a,b);
        int residuo = dividendo%divisor;


        while(residuo != 0){

            dividendo = divisor;
            divisor = residuo;
            residuo = dividendo%divisor;

        }
        return divisor;
    }


    static Scanner lector = new Scanner(System.in);

    public static void main(String[] args){

        System.out.println("Ingrese el primer numero:");
        int a = lector.nextInt();

        System.out.println("Ingrese el segundo numero: ");
        int b = lector.nextInt();

        int maximoComunDivisor = GCD(a,b);

        System.out.println("El GCD entre "+a+" y "+b+" es: "+maximoComunDivisor);

        int yo=0;
        int xo = (maximoComunDivisor)/a;
        while((a*xo+b*yo)!=maximoComunDivisor){
            yo++;
            xo = (maximoComunDivisor-b*yo)/a;
        }
        System.out.println("Vamos a expresar el GCD como combinacion lineal de a y b, de la siguiente forma: ax+by=GCD(a,b)");
        System.out.println("Lo cual nos daría la siguiente ecuación: "+a+"x + "+b+"y = "+maximoComunDivisor);
        System.out.println("Una solución particular de este sistema es x = "+xo+", y = "+yo);

        System.out.println("Desea otra solución?(si,no): ");
        String respuesta = lector.next();

        int x;
        int y;
        int t = 0;
        if(respuesta.equalsIgnoreCase("si")||respuesta.equalsIgnoreCase("sí")){
            System.out.println("Cuantas soluciones necesita: ");
            t = lector.nextInt();
        }else{
            System.exit(0);
        }
        for(int i=1; i<=t; i++){
            x = xo + (b/maximoComunDivisor)*i;
            y = yo - (a/maximoComunDivisor)*i;
            System.out.println("Solución "+i+": x = "+x+" y = "+y);
        }
    }
}
