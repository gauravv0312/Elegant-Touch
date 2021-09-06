package com.example.elegant_touch.Dashboard;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.elegant_touch.R;
import com.example.elegant_touch.databinding.FragmentAllCategoriesBinding;

public class AllCategoriesFragment extends Fragment {
    FragmentAllCategoriesBinding binding;
    Animation right_anim,left_anim;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentAllCategoriesBinding.inflate(inflater,container,false);
       binding.backbutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              startActivity(new Intent(getContext(),DashboardActivity.class));
              getActivity().finish();
           }
       });
       right_anim = AnimationUtils.loadAnimation(getContext(),R.anim.right);
       left_anim =AnimationUtils.loadAnimation(getContext(),R.anim.left);
       binding.cardParlour.setAnimation(right_anim);
       binding.cardSaloon.setAnimation(left_anim);
       binding.cardMen.setAnimation(right_anim);
       binding.cardWomen.setAnimation(left_anim);
       binding.cardBoy.setAnimation(right_anim);
       binding.cardGirl.setAnimation(left_anim);
       binding.cardPerfume.setAnimation(right_anim);
       binding.cardHair.setAnimation(left_anim);
       binding.cardSoap.setAnimation(right_anim);
       binding.cardShampoo.setAnimation(left_anim);
       binding.cardMakeup.setAnimation(right_anim);
       return binding.getRoot();
    }
}