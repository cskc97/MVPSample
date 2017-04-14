package apps.everythingforward.com.mvpsamplereal.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import apps.everythingforward.com.mvpsamplereal.R;
import apps.everythingforward.com.mvpsamplereal.model.PostsModel;

/**
 * Created by santh on 4/14/2017.
 */

public class PostsRecyclerViewAdapter extends RecyclerView.Adapter<PostsRecyclerViewAdapter.ViewHolder> {

    ArrayList<PostsModel> data;

    public PostsRecyclerViewAdapter()
    {
        data = new ArrayList<>();

    }

    public PostsRecyclerViewAdapter(ArrayList<PostsModel> postsList)
    {
        data = postsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String userID,ID,title,body;
        userID = data.get(position).getUserId();
        ID=data.get(position).getId();
        title=data.get(position).getTitle();
        body=data.get(position).getBody();

        holder.userID.setText(userID);
        holder.ID.setText(ID);
        holder.title.setText(title);
        holder.title.setText(body);





    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView userID,ID,title,body;
        public ViewHolder(View itemView) {
            super(itemView);

            userID = (TextView)itemView.findViewById(R.id.userID);
            ID = (TextView)itemView.findViewById(R.id.Id);
            title=(TextView)itemView.findViewById(R.id.titleString);
            body=(TextView)itemView.findViewById(R.id.bodyString);

        }
    }

    public void addPosts(ArrayList<PostsModel> posts)
    {

        data.addAll(posts);
        this.notifyDataSetChanged();


    }


}
