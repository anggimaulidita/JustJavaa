package com.example.justjavaa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
int quantity = 0;
EditText namaEditText;
String nama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view){
            if (quantity > 0) {
                quantity = quantity - 1;
                display(quantity);
            }
    }

    public void submitOrder(View view) {
            CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
            CheckBox chocolateCheckbox = (CheckBox) findViewById(R.id.chococlate_checkbox);

            namaEditText = (EditText) findViewById(R.id.name_fild);

            boolean hasWhippedCream = whippedCreamCheckbox.isChecked();
            boolean hashChocolat = chocolateCheckbox.isChecked();
            nama = namaEditText.getText().toString();
        }
            int price = calculatePrice (hasWhippedCream, hasChocolate);

            String priceMessage = "Total pembelian " + quantity + "cangkir" +
                    "\nWhipped Cream: " + hasWippedCream +
                    "\nChocolate: " + hasChocolate +
                    "\Total pembelian Rp " + price +
                    "\nTerimakasih Kakak" + nama;
            displayMassage(priceMessage);
    }
        private int calculatePrice(boolean addWhippedCream, boolean addChocolate)
        {
            int basePrice = 5000;
            int price = 0;

            if(addWhippedCream){
                basePrice = basePrice + 1000;
            }
            if(addChocolate){
                basePrice = basePrice + 2000;
            }
            return price = quantity * basePrice;
        }

        private void displayMassage(String message) {
            TextView priceTextView = findViewById(R.id.price_text_view);
            priceTextView.setText(message);
        }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view)
        quantityTextView.setText("" + number);
    }

    private void displayPrice (int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));

    }
}

