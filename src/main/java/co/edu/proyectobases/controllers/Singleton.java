package co.edu.proyectobases.controllers;

public class Singleton {
    //VARIABLES
    private static Singleton instaciaSingleton;
    //====================================

    //CONSTRUCTORES

    public Singleton() {
        System.out.println("Funciona :3");
    }


    //====================================

    //GETTERS AND SETTERS

    /**
     * para obtener la insancia del singleton desde otras clases
     * @return
     */
    public static Singleton getInstance(){
        if(!(instaciaSingleton instanceof Singleton)) {
            instaciaSingleton = new Singleton();
        }
        return instaciaSingleton;
    }
    //====================================

    //METODOS

    //====================================

    //METODOS SOBRE ESCRITOS

    //====================================
}
