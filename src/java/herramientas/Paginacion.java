package herramientas;

public class Paginacion {

    
    
    
    
 public int NumeroDePaginas(int dividendo,int divisor){
 
     int resultado1 = 0;
     int resultado2 = 0;
     
     
     
     resultado1 = dividendo / divisor;
     resultado2 = dividendo % divisor;
     
     
     if(resultado2!=0){
     resultado1++;
     }
     
     
  return resultado1;    
 }   
    
 
 
 
 public String cantidadDePaginas(int pagina,int numpaginaciones){
 
       int inipag = 0;
       int finpag = 0;
       int iterador = 0;
       
       
       if((pagina-1)%numpaginaciones==0){
       inipag = pagina;
       finpag = inipag+(numpaginaciones-1);
       }else{
       
       int flag = pagina-numpaginaciones; 
       
       
       if(flag < 0){
       flag = flag * -1;
       finpag = pagina + flag;
       inipag = finpag - (numpaginaciones-1);
       }else{
      
       int flag2 = flag;
           
       while(flag2%numpaginaciones!=0){
          
           flag2++;
           iterador++;
       }        
       
       inipag = (flag + iterador)+1;
       finpag = inipag + (numpaginaciones-1);
       
       
       }
       
           
       }
       
       if(pagina%numpaginaciones==0){
       finpag = pagina;
       inipag = finpag-(numpaginaciones-1);
       }

     
 return inipag+"-"+finpag;
 }
    
    
    
    
    
    
    
    
    
}
