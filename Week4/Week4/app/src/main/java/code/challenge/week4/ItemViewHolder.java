package code.challenge.week4;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    private final TextView firstName;
    private final TextView lastName;

    ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        firstName = itemView.findViewById(R.id.tv_first_name);
        lastName = itemView.findViewById(R.id.tv_last_name);
    }

    void bind(@NonNull final Item item) {
        firstName.setText(item.getFirstName());
        lastName.setText(item.getLastName());
    }

    void updateBackground(int position) {
        if (position % 2 == 1) {
            itemView.setBackgroundColor(Color.rgb(240, 240, 240));
        } else {
            itemView.setBackgroundColor(Color.rgb(250, 255, 255));
        }
    }
}