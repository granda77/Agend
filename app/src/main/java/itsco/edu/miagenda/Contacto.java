package itsco.edu.miagenda;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by C77 on 05/03/2017.
 */

public class Contacto implements Parcelable{

    String nombre;
    String telefono;
    String correo;

    public Contacto(){

    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(telefono);
        dest.writeString(correo);
    }

    private Contacto(Parcel parcel){
        this.nombre=parcel.readString();
        this.telefono=parcel.readString();
        this.correo=parcel.readString();
    }

    public static final Parcelable.Creator<Contacto> CREATOR
            = new Parcelable.Creator<Contacto>()

    {

        @Override
        public Contacto createFromParcel (Parcel parcel){
        return new Contacto(parcel); }


        @Override
        public Contacto[] newArray (int i){ return new Contacto[i];}

    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() { return this.nombre; }
}
