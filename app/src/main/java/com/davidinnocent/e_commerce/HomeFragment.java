package com.davidinnocent.e_commerce;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.labo.kaji.fragmentanimations.MoveAnimation;

import de.hdodenhof.circleimageview.CircleImageView;


public class HomeFragment extends Fragment {

    private NavController navController;
    private NavController navController_inner;


    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        Window window=getActivity().getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(getActivity(),R.color.colorPrimaryDarkDark));
        }
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        navController= Navigation.findNavController(container);
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CircleImageView circleImageView=view.findViewById(R.id.profile_image);
        ImageView profile_image=view.findViewById(R.id.cie);
        TextView my_recycler_view=view.findViewById(R.id.textView5);




        ViewCompat.animate(circleImageView)
                .translationY(-50)
                .setStartDelay(500)
                .setDuration(900).setInterpolator(
                new DecelerateInterpolator()).start();



        ViewCompat.animate(profile_image)
                .translationY(-180)
                .setStartDelay(600)
                .setDuration(700).setInterpolator(
                new DecelerateInterpolator()).start();

        ViewCompat.animate(my_recycler_view)
                .scaleY(1).scaleX(1)
                .setStartDelay(700)
                .setDuration(1400).setInterpolator(
                new DecelerateInterpolator()).start();

    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (enter) {
            return MoveAnimation.create(MoveAnimation.LEFT, enter, 700);
        } else {
//            return CubeAnimation.create(CubeAnimation.UP, enter, 500);
            return MoveAnimation.create(MoveAnimation.DOWN, enter, 700);
        }
    }
}