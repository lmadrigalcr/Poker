/*
 /*
 * Instituto Tecnol�gico de Costa Rica
 * Escuela de Ingenier�a en Computaci�n
 * Lenguajes de Programaci�n
 * Casa de Apuestas de Eddy
 */

package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Mano implements Comparable<Mano> {
    
    //Parametro de mano
    private List<Carta> cartas;
    
    //Constructor
    public Mano(List<Carta> cartas)
    {
        this.cartas = cartas;
    }
    
    public List<List<Carta>> printCombination(List<Carta> l, int n, int r)
    { 
        List<Carta> data = new ArrayList<>();
        List<List<Carta>> res = new ArrayList<>();
 
        // Print all combination using temprary array 'data[]'
        combinationUtil(res, l, data, 0, l.size()-1, 0, r);
        return res;
    }

    /* arr[]  ---> Input Array
       data[] ---> Temporary array to store current combination
       start & end ---> Staring and Ending indexes in arr[]
       index  ---> Current index in data[]
       r ---> Size of a combination to be printed */
    private void combinationUtil(List<List<Carta>> res, List<Carta> l, List<Carta> data, int start, int end, int index, int r)
    {
        // Current combination is ready to be printed, print it
        if (index == r)
        {
            res.add(data);
            data = new ArrayList<>();
            return;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data.add(index, l.get(i));
            combinationUtil(res, l, data, i+1, end, index+1, r);
        }
    }
    
    public void ordenarValor()
    {
        Collections.sort(cartas);
    }
    
    public void ordenarPalo()
    {
        Collections.sort(cartas, new Comparator<Carta>()
        {
            @Override
            public int compare(Carta o1, Carta o2)
            {
                return o1.getPalo() - o2.getPalo();
            }
        });
    }
    
    //Metodo para obtener la mano
    public List<Carta> getCartas()
    {
        return cartas;
    }
    
    private boolean esPareja()
    {
        return cantidadDeParejas() == 1;
    }
    
    private boolean esDoblePareja()
    {
        return cantidadDeParejas() == 2;
    }
    
    private boolean esTrio()
    {
        return cantidadDeTrios() == 1;
    }
    
    private boolean esEscalera()
    {
        this.ordenarValor();
        for (int i=0; i<cartas.size()-1; i++)
        {
            if (cartas.get(i).getValor() != cartas.get(i+1).getValor() - 1)
            {
                return false;
            }
        }
        return true;
    }
    
    private boolean esColor()
    {
        return mismoPalo();
    }
    
    private boolean esFullHouse()
    {
        return cantidadDeTrios() == 1 && cantidadDeParejas() == 1;
    }
    
    private boolean esPoker()
    {
        return cantidadDeRepeticiones(4) == 1;
    }
    
    private boolean esEscaleraColor()
    {
        return esEscalera() && mismoPalo();
    }
    
    private boolean esEscaleraReal()
    {
        this.ordenarValor();
        
        // Si la primera carta es un AS y la segunda es un 10.
        if (cartas.get(0).getValor() == 1 && cartas.get(1).getValor() == 10)
        {
            for (int i=1; i<cartas.size()-1; i++)
            {
                if (cartas.get(i).getValor() != cartas.get(i+1).getValor() - 1)
                {
                    return false;
                }
            }
            return mismoPalo();
        }
        else
        {
            return false;
        }
    }
    
    private boolean mismoPalo()
    {
        for (int i=0; i<cartas.size()-1; i++)
        {
            if (cartas.get(i).getPalo() != cartas.get(i+1).getPalo())
            {
                return false;
            }
        }
        return true;
    }
    
    private int cantidadDeParejas()
    {
        return cantidadDeRepeticiones(2);
    }
    
    private int cantidadDeTrios()
    {
        return cantidadDeRepeticiones(3);
    }
    
    private int cantidadDeRepeticiones(int numCartas)
    {
        this.ordenarValor();
        int frecuencia = 0;
        int repeticiones = 0;
        
        while (frecuencia <= cartas.size())
        {
            frecuencia += Collections.frequency(cartas, cartas.get(frecuencia));
            if (frecuencia%numCartas == 0)
            {
                repeticiones += frecuencia/numCartas;
            }
        }
        return repeticiones;
    }
    
    //Metodo para obtener el valor de la mano
    public int obtenerValor()
    {
        if (esEscaleraReal())
        {
            return Constantes.MANO_ESCALERA_REAL;
        }
        else if (esEscaleraColor())
        {
            return Constantes.MANO_ESCALERA_COLOR;
        }
        else if (esPoker())
        {
            return Constantes.MANO_POKER;
        }
        else if (esFullHouse())
        {
            return Constantes.MANO_FULL_HOUSE;
        }
        else if (esColor())
        {
            return Constantes.MANO_COLOR;
        }
        else if (esEscalera())
        {
            return Constantes.MANO_ESCALERA;
        }
        else if (esTrio())
        {
            return Constantes.MANO_TRIO;
        }
        else if (esDoblePareja())
        {
            return Constantes.MANO_DOBLE_PAREJA;
        }
        else if (esPareja())
        {
            return Constantes.MANO_PAREJA;
        }
        else
        {
            return Constantes.MANO_CARTA_ALTA;
        }
    }
   
    //Metodo compareTo de la interfaz Comparable
    @Override
    public int compareTo(Mano mano)
    {
        int compare = this.obtenerValor() - mano.obtenerValor();
        
        if (compare == 0)
        {
            int desempate;
            for (int i=0; i<this.cartas.size(); i++)
            {
                desempate = this.cartas.get(i).compareTo( mano.getCartas().get(i) );
                if (desempate != 0)
                {
                    return desempate;
                }
            }
            return 0;
        }
        else
        {
            return compare;
        }
    }
}
