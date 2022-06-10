package pl.wsb.students.android.introduction.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pl.wsb.students.android.introduction.R;
import pl.wsb.students.android.introduction.model.Note;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    private final List<Note> data;
    private final LayoutInflater inflater;

    public NotesAdapter(
            Context context,
            List<Note> data
    ) {
        this.inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = this.inflater.inflate(R.layout.item_users_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note item = data.get(position);
        if (item == null) {
            return;
        }   //if
        //   holder.txtUsersListUserName.setText(item.getId());
        holder.txtUsersListUserPhone.setText(item.getTitle());
        //   holder.txtUsersListUserEmail.setText(item.getContent().getContent());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public Note getItem(int position) {
        return data.get(position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtUsersListUserName;
        TextView txtUsersListUserPhone;
        TextView txtUsersListUserEmail;
        TextView txtUsersListUserWebsite;

        ViewHolder(View itemView) {
            super(itemView);
            this.txtUsersListUserName = itemView.findViewById(R.id.txtUsersListUserName);
            this.txtUsersListUserPhone = itemView.findViewById(R.id.txtUsersListUserPhone);
            this.txtUsersListUserEmail = itemView.findViewById(R.id.txtUsersListUserEmail);
            this.txtUsersListUserWebsite = itemView.findViewById(R.id.txtUsersListUserWebsite);
        }

    }
}
