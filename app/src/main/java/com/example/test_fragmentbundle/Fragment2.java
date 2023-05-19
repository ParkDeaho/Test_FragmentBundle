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

public class Fragment2 extends Fragment {
    View view;
    TextView tvFragment2;
    Button btnMove;
    String result;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment2, container, false);

        tvFragment2 = view.findViewById(R.id.tvFragment2);
        btnMove = view.findViewById(R.id.btnFragment1Move);

        // 받을 준비를 한다.
        if (getArguments() != null) {
            result = getArguments().getString("fromFragment1"); //데이터 받아서 온다.
            tvFragment2.setText(result);
        }
        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("fromFragment2", "대빵2");
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Fragment1 fragment1 = new Fragment1();
                fragment1.setArguments(bundle);
                transaction.replace(R.id.fragmentLayout, fragment1);    //교체화면을 바꾼다
                transaction.commit();   //저장

            }
        });

        return view;
    }
}
