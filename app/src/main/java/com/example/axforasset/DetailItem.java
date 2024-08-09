package com.example.axforasset;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);
        emailEt = findViewById(R.id.emailEt);
        increaseBtn = findViewById(R.id.increase_quantity);
        quantityTv = (TextView) findViewById(R.id.quantity);
        decreaseBtn = findViewById(R.id.decrease_quantity);
        buyBtn = findViewById(R.id.buy_now);
        spinner = findViewById(R.id.spinner);


        buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buyBtn.setBackgroundColor(getResources().getColor(R.color.pink));
                if (emailEt.getText().toString().isEmpty()){
                    new MaterialAlertDialogBuilder(DetailItem.this)
                            .setTitle("Error")
                            .setMessage("Email must be filled.")
                            .setPositiveButton("Ok", null)
                            .show();
                }
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