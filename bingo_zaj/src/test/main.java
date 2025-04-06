/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author USER
 */
public class main {
    private static int[]komb=new int[]{0,1,1,1};
    
    public static int prebroj(int br, int[] niz) {
        int brojac=0;
        for (int i : niz) {
            if (i == br) {
                brojac++;
            }
        }
        return brojac;
    }
    private static void ukloni(int br, int[] a) {
        for(int i=0;i<4;i++)
        {
            if(a[i]==br)
                a[i]=-1;
        }
    }
    public static int[] vratiStatistiku(int[] pog) {
//        ne menjam originalnu kombinaciju
        int[]a=new int[4],b=new int[4];
        int namestu=0,nije = 0;
        for (int i = 0; i < 4; i++) {
            if (komb[i] == pog[i]) 
                namestu++;
            else 
            {
                a[i]=komb[i];
                b[i]=pog[i];
             }
        }
         for(int i:b)
         {
             if(i!=-1)
             {
             nije+=Math.min(prebroj(i, b), prebroj(i, a));
             ukloni(i,a);
             }
         }
        
        int stat[] = new int[]{namestu, nije};
        return stat;
    }
    public static void main(String[] args) {
     for(int i:vratiStatistiku(new int[]{1,0,0,0})) 
     {
         System.out.println(i);
     }
    }

   
}
