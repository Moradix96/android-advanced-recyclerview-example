package ir.samiantec.advancedrecyclerviewexample.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.samiantec.advancedrecyclerviewexample.Model.NumPair;
import ir.samiantec.advancedrecyclerviewexample.Model.Section;
import ir.samiantec.advancedrecyclerviewexample.R;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<Section> sectionList;

    public Adapter(@NonNull List<Section> sectionList) {
        this.sectionList = sectionList;
    }

    @Override
    public int getItemViewType(int position) {
        return isHeader(position) ? 0 : 1; //0:Header 1:Item
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) { //Header
            final View headerView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header, parent, false);
            return new HeaderViewHolder(headerView);
        } else if (viewType == 1) { //Item
            final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            return new ItemViewHolder(itemView);
        } else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final NumPair numPair = findPosition(position);
        final Section section = sectionList.get(numPair.getA());
        if (holder instanceof HeaderViewHolder) {
            final HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            headerViewHolder.tvTitle.setText(section.getTitle());
        } else if (holder instanceof ItemViewHolder) {
            final ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            itemViewHolder.tvText.setText(section.getList().get(numPair.getB()));
        }
        /*holder.itemView.setOnClickListener(v -> {
            if (selectItemListener != null) selectItemListener.onSelect(item);
        });*/
    }

    @Override
    public int getItemCount() {
        int size = 0;
        for (int i = 0; i < sectionList.size(); i++) {
            size += sectionList.get(i).getList().size();
        }
        return size + sectionList.size();
    }

    /**
     * Returns true if adapterPosition points to edge of arrays
     **/
    private boolean isHeader(int adapterPosition) {
        int x = adapterPosition;
        for (int i = 0; i < sectionList.size(); i++) {
            if (x == 0)
                return true;
            else if (x <= sectionList.get(i).getList().size())
                return false;
            x = x - sectionList.get(i).getList().size() - 1;
        }
        return false;
    }

    /**
     * Returns a pair of (sectionIndex, itemIndex)
     **/
    private NumPair findPosition(int adapterPosition) {
        int sectionIndex = 0, itemIndex = adapterPosition;
        for (int i = 0; i < sectionList.size(); i++) {
            itemIndex--;
            if (itemIndex < sectionList.get(i).getList().size()) {
                break;
            }
            sectionIndex++;
            itemIndex -= sectionList.get(i).getList().size();
        }
        return new NumPair(sectionIndex, itemIndex);
    }

    private class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;

        HeaderViewHolder(View view) {
            super(view);
            tvTitle = view.findViewById(R.id.tvTitle);
        }
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvText;

        ItemViewHolder(View view) {
            super(view);
            tvText = view.findViewById(R.id.tvText);
        }
    }

}