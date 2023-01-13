package org.raaufcodeforandroid.greennumbertunisia.adapter;



import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.raaufcodeforandroid.greennumbertunisia.AllGreenPhoneActivity;
import org.raaufcodeforandroid.greennumbertunisia.R;
import org.raaufcodeforandroid.greennumbertunisia.model.GreenPhone;


import java.util.List;

public class GreenPhoneAdapter extends RecyclerView.Adapter<GreenPhoneAdapter.ViewHolder> {
    private final Context context;
    private final List<GreenPhone> phones;

    public GreenPhoneAdapter(Context context, List listItems) {
        this.context=context;
        this.phones=listItems;
    }

    @NonNull
    @Override
    public GreenPhoneAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View views = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.one_green_phone, viewGroup, false);
        return new ViewHolder(views);
    }



    @Override
    public void onBindViewHolder(@NonNull GreenPhoneAdapter.ViewHolder viewHold, int i) {
        GreenPhone phone = phones.get(i);
        viewHold.name.setText(phone.getName());
        viewHold.number.setText(phone.getPhoneNumber());

    }

    @Override
    public int getItemCount() {
        return phones.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder implements  View.OnClickListener {
        private final TextView name;
        private final TextView number;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ImageButton appelGreenPhone = itemView.findViewById(R.id.call_green_phone);
            appelGreenPhone.setOnClickListener(this);
            name = itemView.findViewById(R.id.green_phone_name);
            number = itemView.findViewById(R.id.green_phone_number);
        }


        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            GreenPhone phone = phones.get(position);

            Intent intent = new Intent(v.getContext(), AllGreenPhoneActivity.class);
            intent.putExtra("phone_number", phone.getPhoneNumber());
            intent.putExtra("phone_name", phone.getName());
            context.startActivity(intent);

        }



    }
}