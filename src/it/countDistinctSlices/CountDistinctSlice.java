/*
Caterpillar method - CountDistinctSlice
An integer M and a non-empty array A consisting of N non-negative integers are given. All integers in array A are less than or equal to M.
A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A. The slice consists of the elements A[P], A[P + 1], ..., A[Q]. 
A distinct slice is a slice consisting of only unique numbers. That is, no individual number occurs more than once in the slice.
For example, consider integer M = 6 and array A such that:
    A[0] = 3
    A[1] = 4
    A[2] = 5
    A[3] = 5
    A[4] = 2
There are exactly nine distinct slices: (0, 0), (0, 1), (0, 2), (1, 1), (1, 2), (2, 2), (3, 3), (3, 4), (4, 4).
The goal is to calculate the number of distinct slices.
Write a function:
class Solution { public int solution(int M, int[] A); }
that, given an integer M and a non-empty array A consisting of N integers, returns the number of distinct slices.
If the number of distinct slices is greater than 1,000,000,000, the function should return 1,000,000,000.
For example, given integer M = 6 and array A such that:
    A[0] = 3
    A[1] = 4
    A[2] = 5
    A[3] = 5
    A[4] = 2
the function should return 9, as explained above.
Write an efficient algorithm for the following assumptions:
N is an integer within the range [1..100,000];
M is an integer within the range [0..100,000];
each element of array A is an integer within the range [0..M]. 
 */

package it.countDistinctSlices;

import java.util.Scanner;

public class CountDistinctSlice {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int dim;
		do {
			System.out.println("inserire la dimensione dell'array, (max 100000)");
		        dim = input.nextInt();
		} while (dim <= 0 || dim > 100000);
		
		int [] A = new int[dim];
		int M;
		do {
			System.out.println("Inserire M, (valore massimo per le componenti dell'array), max 100000");	
		        M = input.nextInt();
		   }
		while (M < 0 || M > 100000);
		
		for (int i = 0; i < dim; i++) {
			do {
				System.out.println("Inserire l'i-esimo elemento del vettore, (valori minori o uguali ad " + M + ")");	
				A[i] = input.nextInt();
			   }
			while (A[i] < 0 || A[i] > M);
		  }
		
		int ris = countSlices (A, dim);
		if (ris == 1000000000)
		        System.out.println("ci sono più di 1000000000 distinct slice");
		else 
			System.out.println("il numero di distinct slice è: " + ris);
	  }
	
	    public static int countSlices(int[] A, int dim) {
	    	int count = 0;
	    	boolean t;
		for (int i = 0; i < dim; i++)
			for (int j = i; j < dim; j++) {
				    if (i == j) count++;
				    else { t = false;
					   for (int k = i; k < j; k++) {
					        for (int w = k+1; w <= j; w++) {
					        	if (A[k] == A[w]) {
					        			t = true;
					        			break;
					        	}
					        }
					        if (t == true) break;
					        }
					    if (t == false) count++;  
					  }
			}
		    if (count > 1000000000)
		    	 return 1000000000;
		    else return count;
	    }
	}

