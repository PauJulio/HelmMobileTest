package example.pau.rickmorty;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {

    private Context chContext;
    private ArrayList<Character> characters;
    private ArrayList<Boolean> likes;
    private ClickListener clickListener;

    public CharacterAdapter(Context chContext, ArrayList<Character> characters, ArrayList<Boolean> likes, ClickListener clickListener) {
        this.chContext = chContext;
        this.characters = characters;
        this.likes = new ArrayList<>(likes);
        this.clickListener = clickListener;
    }

    @Override
    public CharacterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.character, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view, clickListener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterAdapter.ViewHolder viewHolder, final int position) {
        Glide.with(chContext).asBitmap().load(characters.get(position).getChImage()).into(viewHolder.chImage);
        viewHolder.chName.setText(characters.get(position).getChName());
        if (likes.get(position)){
            viewHolder.like.setImageResource(R.drawable.ic_action_unlike);
        } else {
            viewHolder.like.setImageResource(R.drawable.ic_action_like);
        }

    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView chImage;
        TextView chName;
        ImageView like;
        RelativeLayout parentLayout;
        ClickListener clickListener;

        public ViewHolder(@NonNull View itemView, ClickListener clickListener) {
            super(itemView);
            chImage = itemView.findViewById(R.id.chImage);
            chName = itemView.findViewById(R.id.chName);
            like = itemView.findViewById(R.id.generalLike);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            this.clickListener = clickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(getAdapterPosition());
        }
    }

    public interface ClickListener{
        void onClick (int position);
    }

    public void checkLike(int position, boolean value){
        likes.set(position, value);
        notifyItemChanged(position);
    }



}
