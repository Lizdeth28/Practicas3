/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriela
 */
//La notación común es b (k; n, p).
//donde k es el número de éxitos, n es el número de intentos,
//p es la probabilidad de éxito.
//Sabemos que b (k; n, p) = C (n, k) p k (1 - p) n - k .
/*p= p(A) y q=1-p=p(A’)*/
/* y que la variable toma cada uno de estos valores con probabilidad:
p( X = r ) = (nr) pr (1 – p) n-r
Parámetros de una distribución binomial:
Esperanza:	n · p
Desviación típica	(n · p · q )0.5 ( raíz cuadrada) */
/* Calculamos los valores teóricos de p(X = r),*/
/* multiplicándolos por k para obtener los valores teóricos de cada posible*/ 
/* valor de la variable aleatoria en series de k datos. */


import java.util.*;

import javax.swing.JOptionPane;
public class Binomial
{
	public static double factorial(int n)
	{
		if (n==0)
			return 1;
		else
			return n*factorial(n-1);
	}
	    public static double coeficiente(int n, int k)
	{
		double resp;
		resp=factorial(n)/factorial(k)*factorial(n-k);
		return resp;
	}
	   public static double fmp(int n, double p, int k)
	   {
		   double resp;
		   resp=1;
		   
		   resp=coeficiente(n,k)*Math.pow(1-p, n-k);
		   return resp;
	   }
	      public static double complemento(int n, double p, int x)
	      {
	    	  double resp;
	    	  resp=1-fpa(n,p,x-1);
	    	  return resp;
	      }
	        public static double fpa(int n, double p, int x)
	        {
	        	int i;
	        	double resp;
	        	resp=0;
	        	for (i=0;i<=x;i=i+1)
	        	{
	        		resp=resp+fmp(n,p,i);	
	        	}
	        return resp;
	        }
	        public static void main(String[] args)
	        {
	        	Scanner lee;
	        	lee = new Scanner(System.in);
	        	double p,prob,prob1;
	        	int n,k,m,k1;
	             
	        	System.out.println("Indica los valores para N y P");
	        	n=lee.nextInt();
	        	p=lee.nextDouble();
	        	System.out.println("Ingresa un valor para M para calcular P(X=m)");
	        	m=lee.nextInt();
	        	prob =fmp(n,p,m);

	        	System.out.println(prob);
	        	System.out.println("Ingresa un valor para K para calcular P(X<=k)");
	        	k=lee.nextInt();
	        	prob1=fpa(n,p,k);
	        	System.out.println(prob1);

	        	System.out.println("Ingresa un valor para K para calcular P(X>=k)");
	        	k1=lee.nextInt();
	        	System.out.println(complemento(n,p,k1));


	        	}
	        	

	        }
	        

