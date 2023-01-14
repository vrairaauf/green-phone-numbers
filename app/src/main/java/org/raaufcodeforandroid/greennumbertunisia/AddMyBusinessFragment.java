package org.raaufcodeforandroid.greennumbertunisia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.raaufcodeforandroid.greennumbertunisia.databinding.FragmentAddMyBusinessBinding;
import org.raaufcodeforandroid.greennumbertunisia.databinding.FragmentDashboardBinding;


public class AddMyBusinessFragment extends Fragment {
    private FragmentAddMyBusinessBinding binding;


    public AddMyBusinessFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.textviewCategory.setOnClickListener(v -> {
            Toast.makeText(getContext(), getResources().getString(R.string.why_select_categorie_string), Toast.LENGTH_SHORT).show();
        });


        String category=binding.spinnerBusinessCategories.getSelectedItem().toString();
        String name=binding.editTextName.getText().toString();
        String description=binding.editTextBusinessDescribe.getText().toString();
        String phone_number=binding.editTextPhone.getText().toString();

        boolean yes=binding.radioButtonYes.isChecked();

        if(category=="None"){
            binding.spinnerBusinessCategories.setFocusable(true);
            binding.editTextErrorDetails.setText(getResources().getString(R.string.error_select_category));
        }else if(name.isEmpty() || name.length()<8){
            binding.editTextErrorDetails.setText("");
            binding.editTextName.setFocusable(true);
            binding.editTextErrorDetails.setText(getResources().getString(R.string.error_enter_name));
        }else if(description.isEmpty() || description.length()<25){
            binding.editTextErrorDetails.setText("");
            binding.editTextBusinessDescribe.setFocusable(true);
            binding.editTextErrorDetails.setText(getResources().getString(R.string.error_enter_description));
        }else if(phone_number.isEmpty() ){
            binding.editTextErrorDetails.setText("");
            binding.editTextPhone.setFocusable(true);
            binding.editTextErrorDetails.setText(getResources().getString(R.string.error_enter_phone_number));
        }else if(!yes){
            binding.editTextErrorDetails.setText("");
            binding.scrollViewPolicy.setFocusable(true);
            binding.editTextErrorDetails.setText(getResources().getString(R.string.error_select_yes));
        }else{
            binding.editTextErrorDetails.setText("");
            binding.buttonAddBusinessPhoneNumber.setEnabled(true);
        }



    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAddMyBusinessBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}