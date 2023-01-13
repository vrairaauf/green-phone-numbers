package org.raaufcodeforandroid.greennumbertunisia.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.raaufcodeforandroid.greennumbertunisia.R;
import org.raaufcodeforandroid.greennumbertunisia.adapter.GreenPhoneAdapter;
import org.raaufcodeforandroid.greennumbertunisia.controller.AreaController;
import org.raaufcodeforandroid.greennumbertunisia.controller.SharedPrefController;
import org.raaufcodeforandroid.greennumbertunisia.databinding.FragmentHomeBinding;
import org.raaufcodeforandroid.greennumbertunisia.model.GreenPhone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView recyclerView;
    private List<GreenPhone> phones;
    private RecyclerView.Adapter adapter;
    HashMap<String, String> ministary_phones= new HashMap<>();
    HashMap<String, String> hospital_phones= new HashMap<>();
    HashMap<String, String> protection_phones= new HashMap<>();
    HashMap<String, String> controlls_phones= new HashMap<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        protection_phones.put(getResources().getString(R.string.police_phone_title), "197");
        protection_phones.put(getResources().getString(R.string.garde_nitionale_phone_title), "77 01 76 71 ");
        protection_phones.put(getResources().getString(R.string.protection_civile_phone_title), "198");

        hospital_phones.put(getResources().getString(R.string.enaach_phone_title), "07 18 34 71 ");
        protection_phones.put(getResources().getString(R.string.ambulance_phone_title), "190");
        protection_phones.put(getResources().getString(R.string.prices_control_phone_title), "00 00 89 71");
        controlls_phones.put(getResources().getString(R.string.vocal_hour_phone_title), "1291");
        controlls_phones.put(getResources().getString(R.string.details_phone_title), "1200");
        controlls_phones.put(getResources().getString(R.string.meteo_phone_title), "00 34 77 71");
        controlls_phones.put(getResources().getString(R.string.steg_phone_title), " 00 25 79 71");
        controlls_phones.put(getResources().getString(R.string.sonede_phone_title), "00 20 51 71");
        controlls_phones.put(getResources().getString(R.string.onas_phone_title), "00 00 35 71 ");
        controlls_phones.put(getResources().getString(R.string.tunisie_telecom_phone_title), " 17 17 80 71");
        controlls_phones.put(getResources().getString(R.string.poste_phone_title), "33 90 83 71 ");
        controlls_phones.put(getResources().getString(R.string.allo_taxi_rapide_phone_title), "70 83 70 83");
        controlls_phones.put(getResources().getString(R.string.allo_taxi_phone_title), " 40 08 84 71");

        hospital_phones.put(getResources().getString(R.string.hopital_habib_thamer_phone_title), "00 70 39 71");
        hospital_phones.put(getResources().getString(R.string.hopital_aziza_othmana_phone_title), "77 07 57 71");
        hospital_phones.put(getResources().getString(R.string.hopital_charl_nicole_phone_title), "00 80 57 71 ");
        hospital_phones.put(getResources().getString(R.string.hopital_rabta_phone_title), "05 85 57 71");
        hospital_phones.put(getResources().getString(R.string.hopital_enfant_phone_title), "00 77 57 71");
        hospital_phones.put(getResources().getString(R.string.hopital_militaire_phone_title), "33 11 39 71");

        ministary_phones.put(getResources().getString(R.string.ministere_first_phone_title), "1860");
        ministary_phones.put(getResources().getString(R.string.ministere_hokouma_phone_title), "1877");
        ministary_phones.put(getResources().getString(R.string.ministere_sport_phone_title), "1868 ");
        ministary_phones.put(getResources().getString(R.string.ministere_ijtimeia_phone_title), "1870");
        ministary_phones.put(getResources().getString(R.string.ministere_external_phone_title), "1862");
        ministary_phones.put(getResources().getString(R.string.ministere_interieur_phone_title), "1880");
        ministary_phones.put(getResources().getString(R.string.ministere_defense_phone_title), "1850");
        ministary_phones.put(getResources().getString(R.string.ministere_femme_phone_title), "1875");
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);


        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AreaController areaController = AreaController.get_instance(getContext(), getActivity());
        SharedPrefController sharedPrefController = SharedPrefController.get_instance(getContext());
        areaController.setLocal(sharedPrefController.get_language());

        recyclerView=binding.recyclerViewForGreenPhones;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        phones=new ArrayList<>();


        binding.spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                if (position == 2) {
                    phones.clear();
                    Set<String> protection_phone_names = protection_phones.keySet();

                    for (String key : protection_phone_names) {
                        GreenPhone greenPhone = new GreenPhone(key, protection_phones.get(key));
                        phones.add(greenPhone);
                    }
                    adapter=new GreenPhoneAdapter(getContext(), phones);
                    recyclerView.setAdapter(adapter);
                } else if (position == 1) {
                    phones.clear();
                    Set<String> hospital_phone_names = hospital_phones.keySet();

                    for (String key : hospital_phone_names) {
                        GreenPhone greenPhone = new GreenPhone(key, hospital_phones.get(key));
                        phones.add(greenPhone);
                    }
                    adapter=new GreenPhoneAdapter(getContext(), phones);
                    recyclerView.setAdapter(adapter);
                } else if (position == 3) {
                    phones.clear();
                    Set<String> ministary_phone_names = ministary_phones.keySet();

                    for (String key : ministary_phone_names) {
                        GreenPhone greenPhone = new GreenPhone(key, ministary_phones.get(key));
                        phones.add(greenPhone);
                    }
                    adapter=new GreenPhoneAdapter(getContext(), phones);
                    recyclerView.setAdapter(adapter);
                } else if (position == 4) {
                    phones.clear();
                    Set<String> controlls_phone_names = controlls_phones.keySet();
                    for (String key : controlls_phone_names) {
                        GreenPhone greenPhone = new GreenPhone(key, controlls_phones.get(key));
                        phones.add(greenPhone);
                    }
                    adapter=new GreenPhoneAdapter(getContext(), phones);
                    recyclerView.setAdapter(adapter);
                } else {
                    phones.clear();
                    Set<String> protection_phone_names = protection_phones.keySet();

                    for (String key : protection_phone_names) {
                        GreenPhone greenPhone = new GreenPhone(key, protection_phones.get(key));
                        phones.add(greenPhone);
                    }
                    Set<String> hospital_phone_names = hospital_phones.keySet();

                    for (String key : hospital_phone_names) {
                        GreenPhone greenPhone = new GreenPhone(key, hospital_phones.get(key));
                        phones.add(greenPhone);
                    }
                    Set<String> ministary_phone_names = ministary_phones.keySet();

                    for (String key : ministary_phone_names) {
                        GreenPhone greenPhone = new GreenPhone(key, ministary_phones.get(key));
                        phones.add(greenPhone);
                    }
                    Set<String> controlls_phone_names = controlls_phones.keySet();

                    for (String key : controlls_phone_names) {
                        GreenPhone greenPhone = new GreenPhone(key, controlls_phones.get(key));
                        phones.add(greenPhone);
                    }

                    adapter = new GreenPhoneAdapter(getContext(), phones);
                    recyclerView.setAdapter(adapter);
                }


    }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

    });
    }


}