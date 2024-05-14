package com.dam.fitmaster;
import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorComida extends RecyclerView.Adapter<AdaptadorComida.MealViewHolder> {
    private final Comida[] comidas;

    public AdaptadorComida(Comida[] comidas) {
        this.comidas = comidas;
    }

    @NonNull
    @Override
    public MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comida, parent, false);
        return new MealViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MealViewHolder holder, int position) {
        Comida comida = comidas[position];
        holder.textDia.setText(comida.getDia());
        holder.textComida.setText("Desayuno: " + comida.getDesayuno() + "\n" +
                "Comida: " + comida.getAlmuerzo() + "\n" +
                "Merienda: " + comida.getMerienda() + "\n" +
                "Cena: " + comida.getCena());
    }

    @Override
    public int getItemCount() {
        return comidas.length;
    }

    public static class MealViewHolder extends RecyclerView.ViewHolder {
        TextView textDia, textComida;

        public MealViewHolder(@NonNull View itemView) {
            super(itemView);
            textDia = itemView.findViewById(R.id.textDia);
            textComida = itemView.findViewById(R.id.textComida);
        }
    }
}