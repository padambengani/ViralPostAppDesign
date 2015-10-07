package in.viralpost.viralpostapp.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import in.viralpost.viralpostapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EntryFragment extends Fragment {

    OnButtonClickListener mCallBack;
    Button loginButton;
    Button signupButton;

    public EntryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_entry, container, false);
        loginButton = (Button) view.findViewById(R.id.button_entry_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallBack.onLoginClicked();
            }
        });

        signupButton = (Button) view.findViewById(R.id.button_entry_signup);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallBack.onSignupClicked();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallBack = (OnButtonClickListener) context;
        } catch(ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnButtonClickListener interface");
        }

    }

    public interface OnButtonClickListener {
        public void onLoginClicked();
        public void onSignupClicked();
    }

}
