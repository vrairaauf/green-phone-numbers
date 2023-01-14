package org.raaufcodeforandroid.greennumbertunisia.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import org.raaufcodeforandroid.greennumbertunisia.R;
import org.raaufcodeforandroid.greennumbertunisia.controller.AreaController;
import org.raaufcodeforandroid.greennumbertunisia.controller.SharedPrefController;
import org.raaufcodeforandroid.greennumbertunisia.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private SharedPrefController sharedPrefController;
    private AreaController areaController;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        return binding.getRoot();



    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPrefController=SharedPrefController.get_instance(getContext());
        areaController=AreaController.get_instance(getContext(), getActivity());
        areaController.setLocal(sharedPrefController.get_language());

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.imageButtonAddMyBusiness.setOnClickListener(v -> NavHostFragment.findNavController(DashboardFragment.this)
                .navigate(R.id.action_navigation_dashboard_to_addMyBusinessFragment));
        int selectedLang;
        String currentlanguage=sharedPrefController.get_language();
        if(currentlanguage.equals("en"))
            selectedLang=0;
        else if(currentlanguage.equals("fr"))
            selectedLang=1;
        else
            selectedLang=2;
        binding.languageSpinner.setSelection(selectedLang);
        binding.languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                String lang;
                if(position==0){
                    lang="en";
                }else if(position==1){
                    lang="fr";
                }else{
                    lang="ar";
                }
                sharedPrefController.set_language(lang);
                areaController.setLocal(sharedPrefController.get_language());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}