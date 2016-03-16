package com.example.gsondemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView tv = (TextView) findViewById(R.id.tv);
		Gson gson = new Gson();
		Cart cart = buildCart();
		StringBuilder sb = new StringBuilder();
		sb.append("Gson.toJson() example: \n");
		sb.append("  Cart Object: ").append(cart).append("\n");
		sb.append("  Cart JSON: ").append(gson.toJson(cart)).append("\n");
		sb.append("\n\nGson.fromJson() example: \n");
		String json = "{buyer:'Happy Camper',creditCard:'4111-1111-1111-1111',"
				+ "lineItems:[{name:'nails',priceInMicros:100000,quantity:100,currencyCode:'USD'}]}";
		sb.append("Cart JSON: ").append(json).append("\n");
		sb.append("Cart Object: ").append(gson.fromJson(json, Cart.class))
				.append("\n");
		tv.setText(sb.toString());
		tv.invalidate();
	}

	private Cart buildCart() {
		List<LineItem> lineItems = new ArrayList<LineItem>();
		lineItems.add(new LineItem("hammer", 1, 12000000, "USD"));
		return new Cart(lineItems, "Happy Buyer", "4111-1111-1111-1111");
	}
}
