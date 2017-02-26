package eu.long1.spacetablayoutdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import eu.long1.spacetablayoutdemo.Login;
import eu.long1.spacetablayoutdemo.MainActivity;
import eu.long1.spacetablayoutdemo.R;
import eu.long1.spacetablayoutdemo.bean.Berita;
import eu.long1.spacetablayoutdemo.config;
import eu.long1.spacetablayoutdemo.isi_berita;

import static eu.long1.spacetablayoutdemo.R.id.imageView;

/**
 * Created by putra on 2/25/17.
 */

public class AdapterBerita extends BaseAdapter {

    private Context context;
    private ArrayList<Berita> list;

    private TextView tanggal;
    private TextView judul;
    private TextView isi;
    private ImageView image;
    String foto = "";
    private LinearLayout llytLayout;
    public AdapterBerita(Context context, ArrayList<Berita> list){
        this.context = context;
        this.list = list;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.filter, parent, false);

        tanggal = (TextView) convertView.findViewById(R.id.tanggal);
        judul = (TextView) convertView.findViewById(R.id.judul);
        isi = (TextView) convertView.findViewById(R.id.isi);
        image = (ImageView) convertView.findViewById(R.id.imageView6);
        llytLayout = (LinearLayout) convertView.findViewById(R.id.llyt_layout);

        tanggal.setText(list.get(position).getTanggal());
        judul.setText(list.get(position).getJudul());
        isi.setText(list.get(position).getIsi());
        foto = list.get(position).getFoto();

        Picasso.with(context)
                .load(foto)
                .resize(50, 50)
                .into(image);


        llytLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   Toast.makeText(context, "asdf", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(context,isi_berita.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(config.TAG_JUDUL_BERITA,list.get(position).getJudul());
                intent.putExtra(config.TAG_TANGGAL_BERITA, list.get(position).getTanggal());
                intent.putExtra(config.TAG_ISI_BERITA, list.get(position).getIsi());
                intent.putExtra(config.TAG_FOTO_BERITA, list.get(position).getFoto());
                context.startActivity(intent);
            }
        });



        return convertView;

    }

}
