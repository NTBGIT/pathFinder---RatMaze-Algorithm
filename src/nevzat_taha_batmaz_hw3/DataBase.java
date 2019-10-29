/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nevzat_taha_batmaz_hw3;

import java.io.*;

import java.util.Scanner;

/**
 *
 * @author Taha
 */
public class DataBase {
     public int dizi[][] = new int [10][10];
    public int dizi1[][] = new int [32][2];

    
    public void ReadMazeFromFile()throws IOException {
       //dosya okuma işlemi bufferreader ile
        String str; 
            System.out.println("Please enter file location: ");
            Scanner ntb = new Scanner(System.in);
            String a = ntb.nextLine();
            FileInputStream fStream = new FileInputStream(a) ;
            DataInputStream dStream = new DataInputStream(fStream);
            BufferedReader bReader = new BufferedReader(new InputStreamReader(dStream));
            String abc [] = new String[8];
            for(int i =0 ; i<8 ; i++ ){
            str = bReader.readLine();
            abc[i]=str;
            }
            
            dStream.close(); 
            
            
            String[] qwe =new String[64];
            String[] deneme = new String[64];
            //Satırlar sırası ile sutuna çeviriliyor.
            int j = 0;
            for(int x=0;x<8;x++){
            deneme = abc[x].split(" ");
            qwe[j]=deneme[0];
            qwe[j+1]=deneme[1];
            qwe[j+2]=deneme[2];
            qwe[j+3]=deneme[3];
            qwe[j+4]=deneme[4];
            qwe[j+5]=deneme[5];
            qwe[j+6]=deneme[6];
            qwe[j+7]=deneme[7];
            j+=8;
            }
        //iki boyutlu arraye atılıyor
         String[][] mydz = new String[8][8];
         int r =0;
         for (int q = 0; q<8 ; q++){
             for(int y = 0; y<8;y++){
                 mydz[q][y] = qwe[r];
                 r=r+1;
             }
         }
         //Arama işi tek fonksiyonda halledilsin diye  arrayın çevresi sıfırla kaplanıyor
         for (int p = 0 ; p<10; p++){
             for(int l = 0 ; l <10 ; l++){
                 if (p==0 || l ==0){
                     dizi[p][l] = 0;
                 }
                 if (p==9 || l==9){
                     dizi[p][l] = 0;
                 }
             }
         }
         for(int x = 0;x < 8; x++){
             for (int y = 0;y<8;y++){
    dizi[x+1][y+1]=Integer.parseInt (mydz[x][y]); 
                        
             }
    }
  }
   
    public int[][] elemanbulmaca (int x, int y, int z){
       // Bütün çevresi araştırılıyor 
      int nev [][] = new int [1][2]; 
      if (dizi[x-1][y]==z){
          nev[0][0] = x-1;
          nev[0][1] = y ;
      }else if(dizi[x+1][y]==z){
          nev[0][0] = x+1;
          nev[0][1] = y ;
      }else if(dizi[x][y-1]==z){
          nev[0][0] = x;
          nev[0][1] = y-1 ;
      }else if(dizi[x][y+1]==z){
          nev[0][0] = x;
          nev[0][1] = y+1 ;
      }else if(dizi[x-1][y-1]==z){
          nev[0][0] = x-1;
          nev[0][1] = y-1 ;
      }else if(dizi[x-1][y+1]==z){
          nev[0][0] = x-1;
          nev[0][1] = y+1 ;
      }else if(dizi[x+1][y-1]==z){
          nev[0][0] = x+1;
          nev[0][1] = y-1 ;
      }else if(dizi[x+1][y+1]==z){
          nev[0][0] = x+1;
          nev[0][1] = y+1 ;
      }else{
         
          dizi[x][y] = 0;
          
          nev[0][0] = 0;
          nev[0][1] = 0 ;
      }
          
      return nev;
    }
    
   
    public void SolveMaze() {
        int i = 0 ;
        int t = 0;
        int j = 0 ;
        int k = 0 ;
        int myar[][] = new int[2][2];
        
        for(j = 1 ; j<9 ;j++){
           for(k= 1; k<9 ;k++){
             if(dizi[j][k]==1){
                myar[i][t] = j;
                myar[i][t+1] = k;
                i = i+1;
               }
            }
            
        }
       // birler bulundu----------------------------------------
      int cnt[][] = new int [32][2];//Çözümün kaydedileceği array
      cnt[0][0]= myar[1][0];
      cnt[0][1]= myar[1][1];
      int u = 0; // çözüm array countu
      
      int n = 2;//sonraki adım aranacak sayı başlangıcı
      //Solving
       for ( int c =0; c<64 ; c++){
        
           for(j=1;j<9;j++){
               for(t=1;t<9;t++){
               
               if(cnt[u][0]==j && cnt[u][1]==t){
            //elemanbulmaca fonksiyonu içinde sonraki değerin adresini bulup , kaydetme
               cnt[u+1][0] = elemanbulmaca(cnt[u][0],cnt[u][1],n)[0][0];
               cnt[u+1][1] = elemanbulmaca(cnt[u][0],cnt[u][1],n)[0][1];
               n=n+1;
               u++;
     //Eğer ara bir değerde tıkanıyorsa önceki aşamaya dönüş
                   if(cnt[u][0] == 0 && cnt[u][1]==0){
                  
                   n=n-2;
                   u=u-2;
    //Eğer başlangıctaki 1 yanlışsa diğer 1'e geçiş
                   if (n==2){
                       cnt[0][0]= myar[0][0];
                       cnt[0][1]= myar[0][1];
                       
                   }
                 }
               }
               if ( n == 33){
                 
                c =64;
               }
            }
         }
      }
       // Fielda yazdırmak için değerler atanıyor
       for (int o=0 ; o<32 ;o++){
           for(int h=0;h<2;h++){
               dizi1[o][h]=cnt[o][h];
           }
       }
           
           
       }
    
    public void PrintSolution() {
        //Yazdırma işlemi
       for(int i=0;i<32;i++){
        System.out.print((dizi1[i][0]-1) + " : " + (dizi1[i][1]-1) + " -> ");
        
        }
        
    
    }
    
}
