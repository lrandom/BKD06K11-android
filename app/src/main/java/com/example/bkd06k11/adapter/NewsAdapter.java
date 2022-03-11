package com.example.bkd06k11.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bkd06k11.R;
import com.example.bkd06k11.models.Article;
import com.example.bkd06k11.models.TransactionItem;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsItemHolder> {
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Article> articles = new ArrayList<>();
    OnItemClickListener onItemClickListener;

    public NewsAdapter(Context context, ArrayList<Article> articles) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.articles = articles;
    }

    @NonNull
    @Override
    public NewsItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_new, null);
        return new NewsItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsItemHolder holder, int position) {
        Article article = articles.get(position);
        holder.tvTitle.setText(article.getTitle());
        holder.tvDescription.setText(article.getDescription());
        Glide.with(context).load(article.getUrlToImage()).into(holder.imageView);
        holder.view.setTag(position);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick((Integer) v.getTag());
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    public interface OnItemClickListener {
        public void onItemClick(int position);
    }

    public class NewsItemHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvDescription;
        ImageView imageView;
        View view;


        public NewsItemHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            imageView = itemView.findViewById(R.id.imgThumbnail);
            view = itemView;
        }
    }
}
