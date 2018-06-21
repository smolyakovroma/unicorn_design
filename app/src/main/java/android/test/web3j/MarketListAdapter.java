package android.test.web3j;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class MarketListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Unicorn> list = new ArrayList<>();
    private final MarketListAdapter.OnItemClick mOnItemClick;
    private FragmentActivity context;

    private boolean allItemsLoaded;

    public void addNewItems(List<Unicorn> items) {
        if (items.size() == 0) {
            allItemsLoaded = true;
            return;
        }
//        if(items.size()+ list.size())
        list.addAll(items);
    }


    public boolean isAllItemsLoaded() {
        return allItemsLoaded;
    }


    public interface OnItemClick {
        void onItemClick(@NonNull Unicorn unicorn);

        void update();
    }

    public MarketListAdapter(ArrayList<Unicorn> list, MarketListAdapter.OnItemClick mOnItemClick, FragmentActivity myContext, RecyclerView recyclerView) {
        this.list = list;
        this.mOnItemClick = mOnItemClick;
        this.context = myContext;
    }

//    @Override
//    public int getItemViewType(int position) {
//        return list.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
//    }

    private final View.OnClickListener mInternalListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Unicorn unicorn = (Unicorn) view.getTag();
            mOnItemClick.onItemClick(unicorn);
            mOnItemClick.update();
        }

    };


    public void changeDataSet(@NonNull List<Unicorn> unicorns) {
        list.clear();
        list.addAll(unicorns);
        notifyDataSetChanged();
        notifyItemChanged(1);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        if (viewType == VIEW_TYPE_ITEM) {
        View view = inflater.inflate(R.layout.market_item, parent, false);
        return new MarketListAdapter.MarketViewHolder(view);
//        } else if (viewType == VIEW_TYPE_LOADING) {
//            View view = inflater.inflate(R.layout.loading_item, parent, false);
//            return new MarketListAdapter.LoadingViewHolder(view);
//        }
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.advert_item, parent, false);


    }


    public static final int SWITCH_FROM_MAIN = 300;

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        if (viewHolder instanceof MarketViewHolder) {
            MarketViewHolder holder = (MarketViewHolder) viewHolder;
            Unicorn unicorn = list.get(position);
            if (unicorn.getName() == null || unicorn.getName().isEmpty()) {
                holder.tvTitle.setText("Unicorn #" + unicorn.getUnicorn_blockchain_id() + " Gen" + unicorn.getGeneration());
            } else {
                holder.tvTitle.setText(unicorn.getName() + " Gen" + unicorn.getGeneration());
            }
//        holder.tvCreated.setText(unicorn.getCreated_at());
            holder.tvStr.setText("str " + unicorn.getStrength());
            holder.tvAgi.setText("agi " + unicorn.getAgility());
            holder.tvSpe.setText("spe " + unicorn.getSpeed());
            holder.tvInt.setText("int " + unicorn.getIntelligence());
            holder.tvCha.setText("cha " + unicorn.getCharisma());

            holder.tvEnergy.setText(Constants.propertyMap.get(unicorn.getEnergy()));
            holder.tvReproduction.setText(Constants.propertyMap.get(unicorn.getReproduction()));

            holder.tvLiked.setText(String.valueOf(unicorn.getLikes()));
            if (unicorn.isLiked_by_current_user()) {
                holder.tvLiked.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_heart_black_18dp, 0);
            } else {
                holder.tvLiked.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_heart_outline_black_18dp, 0);
            }

            //выставляем видимость если продаем и не спариваем
//            if ((unicorn.getCost() != null || unicorn.getCandy_cost() != null) && unicorn.getCandy_breed_cost() == null) {
//                if (unicorn.getCost() != null) holder.tvCost.setText(unicorn.getCost() + " eth");
//                if (unicorn.getCandy_cost() != null)
//                    holder.tvCandyCost.setText(unicorn.getCandy_cost() + " candy");
//                holder.llSell1.setVisibility(View.VISIBLE);
//                holder.llSell2.setVisibility(View.GONE);
//                holder.llSire1.setVisibility(View.GONE);
//                holder.llSire2.setVisibility(View.VISIBLE);
//                holder.llSell4.setVisibility(View.GONE);
//                holder.llSire3.setVisibility(View.GONE);
//                holder.llSire4.setVisibility(View.GONE);
//                holder.btnSell.setText(Constants.CONTEXT.getResources().getString(R.string.title_buy));
//
//            }
//            //выставляем видимость если не продаем и спариваем
//            if (unicorn.getCandy_breed_cost() != null && (unicorn.getCost() == null && unicorn.getCandy_cost() == null)) {
//                holder.tvBreedingCost.setText(unicorn.getCandy_breed_cost() + " candy");
//                holder.llSire1.setVisibility(View.VISIBLE);
//                holder.llSire2.setVisibility(View.GONE);
//                holder.llSell1.setVisibility(View.GONE);
//                holder.llSell2.setVisibility(View.VISIBLE);
//                holder.llSell4.setVisibility(View.GONE);
//                holder.llSire4.setVisibility(View.GONE);
//                holder.llSire3.setVisibility(View.GONE);
//                holder.btnSire.setText(Constants.CONTEXT.getResources().getString(R.string.title_sire));
//                holder.llSire1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
////                            confirmSire(unicorn);
//                    }
//                });
//                holder.btnSire.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
////                            confirmSire(unicorn);
//                    }
//                });
//            }
//
//            //выставляем видимость если не продаем и не спариваем
//            if (unicorn.getCost() == null && unicorn.getCandy_cost() == null && unicorn.getCandy_breed_cost() == null) {
//                holder.llSire1.setVisibility(View.GONE);
//                holder.llSire2.setVisibility(View.VISIBLE);
//                holder.llSell1.setVisibility(View.GONE);
//                holder.llSell2.setVisibility(View.VISIBLE);
//                holder.btnSire.setText(Constants.CONTEXT.getResources().getString(R.string.title_not_sell));
//                holder.btnSell.setText(Constants.CONTEXT.getResources().getString(R.string.title_not_sire));
//                holder.llSell4.setVisibility(View.GONE);
//                holder.llSire4.setVisibility(View.GONE);
//                holder.llSire3.setVisibility(View.GONE);
//            }

            if (unicorn.getImage() != null) {

//            try {
//                InputStream in = new java.net.URL(unicorn.getImage()).openStream();
//                holder.ivItem.setImageBitmap(BitmapFactory.decodeStream(in));
//
//            } catch (Exception e) {
//                new MainActivity.RenderPic().execute(new BigInteger(unicorn.getUnicorn_blockchain_id()));
//                e.printStackTrace();
//            }
                //TODO нужны заглушки?
                Picasso.get().load(unicorn.getImage())
//                        .placeholder(R.drawable.logo_small)
                        .error(R.drawable.logo_small)
                        .into(holder.ivItem, new Callback() {
                            @Override
                            public void onSuccess() {

                            }

                            @Override
                            public void onError(Exception e) {
//                            new MainActivity.RenderPic().execute(new BigInteger(unicorn.getUnicorn_blockchain_id()));
                            }
                        });
            }

//            holder.ivItem.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    Intent intent = new Intent(context, UnicornActivity.class);
//                    intent.putExtra("market", true);
//                    intent.putExtra("unicorn", unicorn);
//
//                    context.startActivityForResult(intent, SWITCH_FROM_MAIN);
//                }
//            });

//        } else if (viewHolder instanceof LoadingViewHolder) {
//            LoadingViewHolder holder = (LoadingViewHolder) viewHolder;
//            holder.pbLoading.setIndeterminate(true);
//        }
        }
    }

    private void confirmSire(Unicorn unicorn) {

//        Intent intent = new Intent(context, ChooserActivity.class);
//        intent.putExtra("unicornTarget", unicorn);
//        context.startActivityForResult(intent, MainActivity.REQUEST_CHOOSER);

    }

    private void confirmBuy(Unicorn unicorn, int position) {
        AlertDialog.Builder ad = new AlertDialog.Builder(context);
        ad.setTitle(Constants.CONTEXT.getResources().getString(R.string.confirm));  // заголовок
        ad.setMessage(Constants.CONTEXT.getResources().getString(R.string.dlg_buy_unicorn));
        if (unicorn.getCost() != null && !unicorn.getCost().isEmpty()) {//TODO добавить в бандл английский
            ad.setPositiveButton(Constants.CONTEXT.getResources().getString(R.string.title_cost) + " " + unicorn.getCost() + " eth", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int arg1) {
//                    ((MainActivity) context).getMarketFragment().buyUnicornWithEth(unicorn, position);
                }
            });
        }
        if (unicorn.getCandy_cost() != null && !unicorn.getCandy_cost().isEmpty()) {
            ad.setNegativeButton(Constants.CONTEXT.getResources().getString(R.string.title_cost) + " " + unicorn.getCandy_cost() + " candy", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int arg1) {
//                    ((MainActivity) context).getMarketFragment().buyUnicornWithCandy(unicorn, position);

                }
            });

        }
        ad.setCancelable(true);
        ad.setNeutralButton(Constants.CONTEXT.getResources().getString(R.string.btn_cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        ad.show();

    }

    public void updatePosition(Unicorn unicorn, int position) {
        if (list.size() < position || list.get(position) == null || list.get(position).getUnicorn_blockchain_id() == null)
            return;
        if (list.get(position).getUnicorn_blockchain_id().equals(unicorn.getUnicorn_blockchain_id())) {
            list.set(position, unicorn);
            notifyItemChanged(position);//TODO - работает, но нужно будет пофиксить в случаи резкого переключения на другой фрагмент (update?)}
        }
    }

    public void updatePositionLite(int position) {
        if (list.size() >= position && list.get(position) != null) {
            notifyItemChanged(position);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(ArrayList<Unicorn> list) {

        this.list = list;
    }

//    public static class LoadingViewHolder extends RecyclerView.ViewHolder {
//
//        public ProgressBar pbLoading;
//
//        public LoadingViewHolder(View itemView) {
//            super(itemView);
//            pbLoading = (ProgressBar) itemView.findViewById(R.id.pbLoading);
//        }
//    }

    public static class MarketViewHolder extends RecyclerView.ViewHolder {

        public CardView cardView;
        public TextView tvTitle, tvFrozenTime, tvStr, tvAgi, tvSpe, tvInt, tvCha, tvCost, tvCandyCost, tvBreedingCost, tvEnergy, tvReproduction, tvLiked;
        public ImageView ivItem;
        public Button btnSell, btnSire;
        public LinearLayout llSell1, llSell2, llSire1, llSire2, llSire3, llSell4, llSire4;

        public MarketViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.info_card_view);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
//            tvCreated = (TextView) itemView.findViewById(R.id.tv_created);
            tvStr = (TextView) itemView.findViewById(R.id.tv_str);
            tvAgi = (TextView) itemView.findViewById(R.id.tv_agi);
            tvSpe = (TextView) itemView.findViewById(R.id.tv_spe);
            tvInt = (TextView) itemView.findViewById(R.id.tv_int);
            tvCha = (TextView) itemView.findViewById(R.id.tv_cha);
            ivItem = (ImageView) itemView.findViewById(R.id.iv_item);
            btnSell = (Button) itemView.findViewById(R.id.btnSell);
            btnSire = (Button) itemView.findViewById(R.id.btnSire);
            llSell1 = (LinearLayout) itemView.findViewById(R.id.llSell1);
            llSell2 = (LinearLayout) itemView.findViewById(R.id.llSell2);
            llSire1 = (LinearLayout) itemView.findViewById(R.id.llSire1);
            llSire2 = (LinearLayout) itemView.findViewById(R.id.llSire2);
            llSire3 = (LinearLayout) itemView.findViewById(R.id.llSire3);
            llSell4 = (LinearLayout) itemView.findViewById(R.id.llSell4);
            llSire4 = (LinearLayout) itemView.findViewById(R.id.llSire4);
            tvCost = (TextView) itemView.findViewById(R.id.tvCost);
            tvFrozenTime = (TextView) itemView.findViewById(R.id.tvFrozenTime);
            tvCandyCost = (TextView) itemView.findViewById(R.id.tvCandyCost);
            tvBreedingCost = (TextView) itemView.findViewById(R.id.tvBreedingCost);
            tvEnergy = (TextView) itemView.findViewById(R.id.tvEnergy);
            tvReproduction = (TextView) itemView.findViewById(R.id.tvReproduction);
            tvLiked = (TextView) itemView.findViewById(R.id.tvLiked);
        }
    }


}
