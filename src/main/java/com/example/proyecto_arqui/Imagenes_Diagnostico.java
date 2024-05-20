package com.example.proyecto_arqui;

public class Imagenes_Diagnostico 
{
    private static Imagenes_Diagnostico instance;
    private Imagenes_Diagnostico(){};
    //private String URL_image;
    private String enfermedad;

    public static Imagenes_Diagnostico getInstance(){
        if(instance==null)
        {
            instance=new Imagenes_Diagnostico();
        }
        return instance;
    }

    public void set_enfermedad(String enfermedad)
    {
      this.enfermedad=enfermedad;
    }

    // public void setURL_image(String uRL_image) {
    //     URL_image = uRL_image;
    // }
    //public void setURL_image() {
        //     aca muestra la imagen sacandola con el url image
        // }
    // public void set_enfermedad()
    // {
    //  String enfermedad;
    //  Compara imagenes y si encuentra coincidencia lo guarda en enfermedad
    //  this.enfermedad=enfermedad;
    //    
    // }

    public void Mostrar_enfermedad()
    {
        System.out.println("tiene "+ this.enfermedad);
    }

    public String getEnfermedad() {
        return enfermedad;
    }
    
}
