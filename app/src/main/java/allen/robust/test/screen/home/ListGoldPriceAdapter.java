package allen.robust.test.screen.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import allen.robust.test.R;
import allen.robust.test.object.GoldPrice;

/**
 * Created by sonnh on 6/12/17.
 */

public class ListGoldPriceAdapter extends RecyclerView.Adapter<ListGoldPriceAdapter.GoldPriceItem> {

    private List<GoldPrice> listGoldInfo;

    public ListGoldPriceAdapter(List<GoldPrice> listGoldInfo) {
        this.listGoldInfo = listGoldInfo;
    }

    @Override
    public GoldPriceItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_goldinfo,parent,false);
        return new GoldPriceItem(v);
    }

    @Override
    public void onBindViewHolder(GoldPriceItem holder, int position) {
        holder.display(listGoldInfo.get(position));
    }

    @Override
    public int getItemCount() {
        return listGoldInfo.size();
    }

    public static class GoldPriceItem extends RecyclerView.ViewHolder {
        TextView date, price;

        public GoldPriceItem(View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.date);
            price = (TextView) itemView.findViewById(R.id.price);
        }

        public void display(GoldPrice goldInfo) {
            if (goldInfo == null) return;
            date.setText(goldInfo.getDate());
            price.setText(goldInfo.getAmount());
        }
    }
}
