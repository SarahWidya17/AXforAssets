package com.example.axforasset;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import org.w3c.dom.Text;

public class DetailItem extends AppCompatActivity {
    private EditText emailEt;
    private Spinner spinner;
    private Button increaseBtn;
    private TextView quantityTv;
    int count = 0;
    private Button decreaseBtn;
    private Button buyBtn;
    private ImageButton backBtn;
    private ImageView imageItem;
    private  ImageView itemPhoto;
    private TextView itemName;
    private TextView descItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);
        Intent intent = getIntent();
        itemName = findViewById(R.id.namaItem);
        itemPhoto = findViewById(R.id.detailImage);
        descItem = findViewById(R.id.deskripsiItem);

        String itemNameIntent = intent.getStringExtra("ITEM_NAME");
        if (itemNameIntent != null) {
            itemName.setText(itemNameIntent);
            itemName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }

        String itemDescIntent = intent.getStringExtra("ITEM_DESC");
        descItem.setText(itemDescIntent);

        int itemPhotoIntent = intent.getIntExtra("ITEM_PHOTO", -1);
        itemPhoto.setImageResource(itemPhotoIntent);


        emailEt = findViewById(R.id.emailEt);
        increaseBtn = findViewById(R.id.increase_quantity);
        quantityTv = (TextView) findViewById(R.id.quantity);
        decreaseBtn = findViewById(R.id.decrease_quantity);
        buyBtn = findViewById(R.id.buy_now);
        spinner = findViewById(R.id.spinner);
        backBtn = findViewById(R.id.backBtnDetail);

        buyBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Ketika tombol disentuh, ubah background dan warna
                        buyBtn.setBackgroundResource(R.drawable.border_drawable);
                        buyBtn.getBackground().setColorFilter(getResources().getColor(R.color.pink), PorterDuff.Mode.SRC_ATOP);
                        break;

                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        // Ketika sentuhan dilepas, kembalikan ke warna awal
                        buyBtn.getBackground().clearColorFilter();
                        buyBtn.setBackgroundResource(R.drawable.border_drawable); // Ganti dengan resource background awal
                        break;
                }
                return false; // Mengembalikan true untuk menangani event ini
            }
        });

        buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity = Integer.parseInt(quantityTv.getText().toString());
                if (emailEt.getText().toString().isEmpty()){
                    new AlertDialog.Builder(DetailItem.this)
                            .setTitle("Error")
                            .setMessage("Email must be filled.")
                            .setPositiveButton("OK", null)
                            .show();
                } else if (quantity == 0) {
                    new AlertDialog.Builder(DetailItem.this)
                            .setTitle("Error")
                            .setMessage("Quantity must be greater than 0.")
                            .setPositiveButton("OK", null)
                            .show();
                } else {
                    AlertDialog dialog = new AlertDialog.Builder(DetailItem.this)
                            .setMessage("A confirmation email has been sent to your email address. Please check your inbox.")
                            .setPositiveButton("OK", null)
                            .show();

                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialogInterface) {
                            Intent intent = new Intent(DetailItem.this, ItemActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailItem.this, HomePage.class);
                startActivity(intent);
                finish();
            }
        });

        //array yg menerima tipe data generic
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                DetailItem.this,
                R.array.payment_array,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    public void increment(View v){
        count++;
        quantityTv.setText("" + count);
    }

    public void decrement(View v){
        if (count <= 0) count = 0;
        else count--;

        quantityTv.setText("" + count);
    }
}
