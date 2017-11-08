package bug.the.agenda.cadastroContatos;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import bug.the.agenda.R;

/**
 * Created by Andre on 30/10/2017.
 */

public class ContatosRecyclerAdapter extends RecyclerView.Adapter<ContatosRecyclerAdapter.ContatosViewHolder>  {

    public static class ContatosViewHolder extends RecyclerView.ViewHolder{

        public de.hdodenhof.circleimageview.CircleImageView imagemRecycler;
        public TextView nomeRecycler;
        public TextView emailRecycler;

        public ContatosViewHolder(View itemView){
            super(itemView);
            imagemRecycler = (de.hdodenhof.circleimageview.CircleImageView)itemView.findViewById(R.id.imagemPerfilRecycler);
            nomeRecycler = (TextView)itemView.findViewById(R.id.nomeRecycler);
            emailRecycler = (TextView) itemView.findViewById(R.id.emailRecycler);
        }
    }


    Context context;
    ArrayList<Contato> contatos;
    public static final String CONTATO = "contato";
    public static final String INDEX = "index";


    public ContatosRecyclerAdapter(Context context, ArrayList<Contato> contatos){
        this.context = context;
        this.contatos = contatos;
    }


    @Override
    public ContatosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contato, parent, false);
        ContatosViewHolder contatosViewHolder = new ContatosViewHolder(layout);
        return contatosViewHolder;
    }

    @Override
    public void onBindViewHolder(final ContatosViewHolder holder, int position) {
        holder.imagemRecycler.setImageBitmap(contatos.get(position).getFotoPerfil());
        holder.nomeRecycler.setText(contatos.get(position).getNome());
        holder.emailRecycler.setText(contatos.get(position).getEmail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CadastroContatosActivity.class);
                intent.putExtra(CONTATO, contatos.get(holder.getAdapterPosition()));
                intent.putExtra(INDEX, holder.getAdapterPosition());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contatos.size();
    }
}
