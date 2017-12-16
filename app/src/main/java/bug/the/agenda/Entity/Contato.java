package bug.the.agenda.Entity;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Andre on 25/10/2017.
 */

public class Contato implements Parcelable {
    private Bitmap fotoPerfil;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;

    public Contato(Bitmap bitmap, String nome, String endereco, String telefone, String email){
        this.fotoPerfil = bitmap;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    private Contato(Parcel from){
        fotoPerfil = from.readParcelable(getClass().getClassLoader());
        nome = from.readString();
        endereco = from.readString();
        telefone = from.readString();
        email = from.readString();
    }

    public void setFotoPerfil(Bitmap bitmap){
        this.fotoPerfil = bitmap;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public Bitmap getFotoPerfil() {
        return fotoPerfil;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail(){
        return email;
    }

    public static final Parcelable.Creator<Contato>
        CREATOR = new Parcelable.Creator<Contato>(){

        public Contato createFromParcel(Parcel in){
            return new Contato(in);
        }

        @Override
        public Contato[] newArray(int i) {
            return new Contato[i];
        }
    };

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeParcelable(fotoPerfil, flags);
        dest.writeString(nome);
        dest.writeString(telefone);
        dest.writeString(email);
        dest.writeString(endereco);
    }
}
