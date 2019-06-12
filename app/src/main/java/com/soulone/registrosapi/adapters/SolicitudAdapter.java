package com.soulone.registrosapi.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.soulone.registrosapi.R;
import com.soulone.registrosapi.models.Solicitud;

import java.util.ArrayList;
import java.util.List;

public class SolicitudAdapter extends RecyclerView.Adapter<SolicitudAdapter.ViewHolder> {
    @NonNull


    private List<Solicitud> solicitudList;
    private Activity activity;

    public SolicitudAdapter() {
        this.solicitudList = new ArrayList<>();
    }

    public void setPostsList(List<Solicitud> solicitudList) {
        this.solicitudList = solicitudList;
    }

    @Override
    public SolicitudAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_solicitud, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SolicitudAdapter.ViewHolder viewHolder, int i) {
        Solicitud solicitud=this.solicitudList.get(i);
        viewHolder.soli.setText(solicitud.getTipo());
        viewHolder.correo.setText(solicitud.getEmail());
        viewHolder.des.setText(solicitud.getMotico());
    }

    @Override
    public int getItemCount() {
        return solicitudList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView soli;
        private TextView correo;
        private TextView des;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            soli=itemView.findViewById(R.id.tvMatricula);
            correo=itemView.findViewById(R.id.tvCorreo);
            des=itemView.findViewById(R.id.tvDescipcion);
        }
    }
}
