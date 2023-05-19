package com.example.test_fragmentbundle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Fragment1 extends Fragment {
    View view;
    TextView tvFragment1;
    Button btnFragment2Move;
    String result;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment1, container, false);

        tvFragment1 = view.findViewById(R.id.tvFragment2);
        btnFragment2Move = view.findViewById(R.id.btnFragment1Move);

        if (getArguments() != null) {
            result = getArguments().getString("fromFragment2"); //데이터 받아서 온다.
            tvFragment1.setText(result);
        }
        btnFragment2Move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("fromFragment1", "대빵1");
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Fragment2 fragment2 = new Fragment2();
                fragment2.setArguments(bundle);
                transaction.replace(R.id.fragmentLayout, fragment2);    //교체화면을 바꾼다
                transaction.commit();   //저장

            }
        });

        return view;
    }
}
