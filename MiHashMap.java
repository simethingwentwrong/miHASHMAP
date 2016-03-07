import java.util.Arrays;
/**
 * Write a description of class MiHashMap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MiHashMap
{
    //Creamos una lista en la que se guarde el valor de las claves
    private String [] claves;
    private int [] valores;
    /**
     * Constructor for objects of class MiHashMap
     */
    public MiHashMap()
    {
        claves = new String[0];
        valores  = new int [0];
    }

    /**
     *Asocia el valor especificado con la clave especificada. 
     *Si la clave existía, entonces sobreescribe su valor y devuelve el valor antiguo. 
     *Si no existía devuelve -1.
     */
    public int put(String clave, int valor)
    {
        boolean buscaClave = false;
        int valorAntiguo = -1;
        String[] nuevasClaves    = new String[claves.length + 1];           
        int[]    nuevosValores  = new int[valores.length +1 ];
        for(int i = 0; i < claves.length; i++){
            nuevasClaves[i]   = claves [i];
            nuevosValores[i] = valores[i];
            if(claves[i] == clave && !buscaClave)
            {
                valorAntiguo = valores[i];
                valores[i] = valor; 
                buscaClave   = true;
            }
        }

        if( !buscaClave){
            nuevasClaves[nuevasClaves.length -1]      = clave;
            nuevosValores[nuevosValores.length - 1] = valor;
            claves  = nuevasClaves;
            valores = nuevosValores;
        }

        return valorAntiguo;
    }

    /**
     * Devuelve el valor asociado con la clave especificada o -1 en caso de que la clave no exista.
     */
    public int get(String clave)
    {
        int valor = -1;
        boolean contieneClave = false;
        for(int index = 0; index < claves.length && !contieneClave; index++ )
        {
            if (claves[index] == clave){
                valor = valores[index];
                contieneClave = true;
            }
        }
        return valor;
    }

    /**
     * devuelve true si el mapa no contiene elementos.
     */
    public boolean isEmpty()
    {
        return claves.length == 0;
    }

    /**
     * devuelve el número de elementos del mapa.
     */
    public int size()
    {
        return claves.length;
    }

    /**
     * vacía el mapa.
     */
    public void clear(){
        claves   = new String[0];
        valores = new int[0];
    }

    /**
     * elimina del mapa el elemento con la clave dada y devuelve su valor. 
     * Si no hay esa clave en el mapa devuelve -1.
     */
    private int remove(String clave)
    {
        int eliminado = -1;
        if(claves.length != 0)
        {
            String[] nuevasClaves    = new String[claves.length - 1];
            int[]    nuevosValores  = new int[valores.length - 1];
            boolean es = false;
            for(int index = 0; index < claves.length ; index++ )
            {
                if (claves[index] == clave){
                    eliminado = valores[index];
                    es = true;
                }
                else if(!es){
                    if(index != claves.length - 1 ){
                        nuevasClaves[index]   = claves[index];
                        nuevosValores[index] = valores[index];
                    }
                }
                else{
                    nuevasClaves[index - 1]   = claves[index];
                    nuevosValores[index - 1] = valores[index];
                }
            }
            if(es){ 
                claves   = nuevasClaves;
                valores = nuevosValores;
            }
        }
        return eliminado;
    }
}
