import java.util.Arrays;
import java.util.Random;

class Alumno{
	private String nombre;
	private String carrera;
	private int promedio;
	
	public Alumno(String nombre, String carrera, int promedio) {
		super();
		this.nombre = nombre;
		this.carrera = carrera;
		this.promedio = promedio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public int getPromedio() {
		return promedio;
	}
	public void setPromedio(int promedio) {
		this.promedio = promedio;
	}
	@Override
	public String toString() {
		return "Alumno [nombre= " + nombre + ", carrera= "+ carrera + ", promedio= "+ promedio + "]";
	}
	
}
class OrdenamientoQuicksort{
	private static void quicksort(int []a, int primero, int ultimo) {
		int i,j, central;
		int pivote;
		central = (primero + ultimo)/2;
		pivote = a[central];
		i = primero;
		j= ultimo;
		
		do {
			while(a[i] < pivote)i++;
			while(a[j]> pivote)j--;
			if(i<= j) {
				int aux = a[i];
				a[i] = a[j];
				a[j]= aux;
				i++;
				j--;
			}
			
		}while(i <= j);
		
		if(primero < j) {
			quicksort(a,primero, j);
		}
		if(i<ultimo) {
			quicksort(a, i, ultimo);
		}
	}
	
	public static void quicksort(int a[]) {
		quicksort(a, 0, a.length-1);
	}
	
	private static void quicksort(Alumno []a, int primero, int ultimo) {
		int i,j, central;
		Alumno pivote;
		central = (primero + ultimo)/2;
		pivote = a[central];
		i = primero;
		j= ultimo;
		
		do {
			while(a[i].getPromedio() < pivote.getPromedio())i++;
			while(a[j].getPromedio()> pivote.getPromedio())j--;
			if(i<= j) {
				Alumno aux = a[i];
				a[i] = a[j];
				a[j]= aux;
				i++;
				j--;
			}
			
		}while(i <= j);
		
		if(primero < j) {
			quicksort(a,primero, j);
		}
		if(i<ultimo) {
			quicksort(a, i, ultimo);
		}
	}
	
	public static void quicksort(Alumno a[]) {
		quicksort(a, 0, a.length-1);
	}
}

class Shellsort{
	public static void shellsort(int[] A) {
		 int salto, aux, i;
	        boolean cambios;
	  
	        for (salto = A.length / 2; salto != 0; salto /= 2) {
	            cambios = true;
	            while (cambios) {                                        
	                cambios = false;
	                for (i = salto; i < A.length; i++)   
	                {
	                    if (A[i - salto] > A[i]) {     
	                        aux = A[i];                
	                        A[i] = A[i - salto];
	                        A[i - salto] = aux;
	                        cambios = true;                                          
	                    }
	                }
	            }
	        }
		
	}
	
	
}

class Radix{
	
	public static void radix(int[]nums) {
		int [][] bucket = new  int[10][nums.length];
		int [] bucketOfElement = new int [10];
		int max=0;
		
		for(int i =0 ; i< nums.length; i++) {
			if(nums[i]>max) {
				max= nums[i];
			}
			
		}
		
		int maxLength = (max+"").length();
		for(int m =0, n=1; m<maxLength; m++, n*=10) {
			
			for(int i=0; i< nums.length; i++) {
				int digit = nums[i]/n%10;
				
				bucket[digit][bucketOfElement[digit]]= nums[i];
				bucketOfElement[digit]++;
			}
		int index = 0;
		
		for(int j =0; j<10; j++ ) {
			for(int k= 0; k<bucketOfElement[j]; k++) {
				nums[index]= bucket[j][k];
				index++;
			}
			bucketOfElement[j]=0;
			
		}
		
		
		
		}
	
		
		
		
	}
	
	
}


public class PruebaOrdenamiento {

	public static void main(String[] args) {
		 Random random = new Random();
		 int []a = new int[10];
		 for (int i=0; i<a.length; i++) {
			 a[i] = random.nextInt(100)+1;
		 }
		 
		 System.out.println("Algoritmo QUICKSORT");
		 System.out.println("\nVector sin ordenar");
		 System.out.println(Arrays.toString(a));
		 
		 OrdenamientoQuicksort.quicksort(a);
		 
		 System.out.println("\nVector ordenado");
		 System.out.println(Arrays.toString(a));
		 
		 Alumno []alumnos = {new Alumno("paco", "ISC", 100),new Alumno("juan", "ISC", 80),new Alumno("maria", "ISC", 90)};
		 
		 System.out.println("\nVector sin ordenar");
		 System.out.println(Arrays.toString(alumnos));
		 
		 OrdenamientoQuicksort.quicksort(alumnos);
		 
		 System.out.println("\nVector ordenado");
		 System.out.println(Arrays.toString(alumnos));
		 
		 int[] A = new int[15];
			
			for(int i=0; i<A.length; i++) {
				A[i]= (int)(Math.random()*100);
			}
			
			System.out.println("\nalgoritmo Shellsort");
			System.out.println("\nSin ordenar");
			System.out.println(Arrays.toString(A));
			
			Shellsort ss = new Shellsort();
			
			ss.shellsort(A);
			
			System.out.println("\nordenado");
			System.out.println(Arrays.toString(A));
			
			System.out.println("\nAlgoritmo RADIX");
			
			int[] nums = new int[15];
			
			for(int i=0; i<nums.length; i++) {
				nums[i]= (int)(Math.random()*100);
			}
			
			System.out.println("\nSin ordenar");
			System.out.println(Arrays.toString(nums));
			
			Radix ra = new Radix();
			
			ra.radix(nums);
			
			System.out.println("\nordenado");
			System.out.println(Arrays.toString(nums));


	}

}
