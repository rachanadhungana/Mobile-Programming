package com.example.rachanadhungana;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Message_Fragment extends Fragment {

    LinearLayout messageContainer;
    EditText edtMessage;
    ImageButton btnSend;
    ScrollView scrollView;

    public Message_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_message, container, false);

        // Initialize views
        messageContainer = view.findViewById(R.id.messageContainer);
        edtMessage = view.findViewById(R.id.edtMessage);
        btnSend = view.findViewById(R.id.btnSend);
        scrollView = view.findViewById(R.id.scrollMessages);

        // Send Button Click
        btnSend.setOnClickListener(v -> {
            String text = edtMessage.getText().toString().trim();

            if (!text.isEmpty()) {
                addSenderMessage(text);
                edtMessage.setText("");
            }
        });

        return view;
    }

    // Add message bubble on right side (Sender)
    private void addSenderMessage(String text) {
        TextView msg = new TextView(getContext());
        msg.setText(text);
        msg.setTextSize(16);
        msg.setBackgroundResource(R.drawable.sender_bubble);
        msg.setPadding(25, 15, 25, 15);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

        params.gravity = Gravity.END;
        params.setMargins(60, 10, 10, 10);

        msg.setLayoutParams(params);

        messageContainer.addView(msg);

        scrollView.post(() -> scrollView.fullScroll(View.FOCUS_DOWN));
    }
}
