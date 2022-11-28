package com.example.tranvanhuong_kiemtraso3_th;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MayTinhAdapter extends BaseAdapter {
        private Context context;
        private int layout;
        private List<MayTinh> mayTinhlist;

        public MayTinhAdapter(Context context, int layout, List<MayTinh> mayTinhlist) {
            this.context = context;
            this.layout = layout;
            this.mayTinhlist = mayTinhlist;
        }


    @Override
        public int getCount() {
            return mayTinhlist.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }


        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            // ánh xạ
            TextView textTen = (TextView) view.findViewById(R.id.textviewTen);
            TextView textMoTa = (TextView) view.findViewById(R.id.textviewMoTa);
            ImageView imgHinh = (ImageView) view.findViewById(R.id.imageviewHinh);
            // gán giá trị
            MayTinh maytinh = mayTinhlist.get(i);
            textTen.setText(maytinh.getTen());
            textMoTa.setText(maytinh.getMoTa());
            imgHinh.setImageResource(maytinh.getHinh());
            return view;
        }
    }


