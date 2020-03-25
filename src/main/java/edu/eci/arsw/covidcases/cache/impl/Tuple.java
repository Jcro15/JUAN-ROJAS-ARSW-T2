package edu.eci.arsw.covidcases.cache.impl;

import java.util.Objects;

/**
 * Estructura de datos tupla
 * @param <T1> Objeto en la primera posicion
 * @param <T2> Objeto en la segunda posicion
 */
public class Tuple<T1, T2> {

    T1 o1;
    T2 o2;

    public Tuple(T1 o1, T2 o2) {
        super();
        this.o1 = o1;
        this.o2 = o2;
    }

    /**
     *
     * @return el primer elemento de la tupla
     */
    public T1 getElem1() {
        return o1;
    }

    /**
     *
     * @return el segundo elemento de la tupla
     */
    public T2 getElem2() {
        return o2;
    }

    /**
     *
     * @return el hashcode de la tupla
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.o1);
        hash = 17 * hash + Objects.hashCode(this.o2);
        return hash;
    }

    /**
     * determina si una tupla equivale a otro objeto
     * @param obj el objeto a comparar
     * @return True o False si las tuplas son iguales o no
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tuple<?, ?> other = (Tuple<?, ?>) obj;
        if (!Objects.equals(this.o1, other.o1)) {
            return false;
        }
        if (!Objects.equals(this.o2, other.o2)) {
            return false;
        }
        return true;
    }


}