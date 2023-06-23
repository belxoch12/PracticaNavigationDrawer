package com.example.practica_navigationdrawer;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.practica_navigationdrawer.ui.configuraciones.Configuraciones;
import com.example.practica_navigationdrawer.ui.gallery.GalleryFragment;
import com.example.practica_navigationdrawer.ui.home.HomeFragment;
import com.example.practica_navigationdrawer.ui.home.HomeViewModel;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.practica_navigationdrawer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    private int selectedTab=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtener referencias de los LinearLayout
        final LinearLayout PrincipalLayout = findViewById(R.id.homeLayout);
        final LinearLayout toolsLayout = findViewById(R.id.HerramientasLayout);
        final LinearLayout profileLayout = findViewById(R.id.PerfilLayout);

        //Enlace de cada uno de las vistas de Lottie
        final LottieAnimationView toolsView=findViewById(R.id.HerramientasView);
        final LottieAnimationView profileView=findViewById(R.id.PerfilView);
        final LottieAnimationView homeanimationView=findViewById(R.id.homeanimationView);

        //Enlace de cada uno de los campos de texto del menú
        final TextView toolsTxt=findViewById(R.id.HerramientasTxt);
        final TextView profileTxt=findViewById(R.id.PerfilTxt);
        final TextView homeTxt=findViewById(R.id.homeTxt);

        PrincipalLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                HomeFragment homeFragment = new HomeFragment();

                getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.nav_host_fragment_content_main, homeFragment) // Reemplazar el fragmento actual con la instancia de HomeFragment
                        .addToBackStack(null) // Agregar la transacción a la pila de retroceso
                        .commit();

                if(selectedTab!=1){

                    //Se colocan invisibles los textos
                    toolsTxt.setVisibility(View.GONE);
                    profileTxt.setVisibility(View.GONE);

                    //Se cancelan las animaciones
                    toolsView.cancelAnimation();
                    profileView.cancelAnimation();

                    //Se quitan los fondos de cada uno de los linear layout
                    toolsLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    profileLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));


                    //Se destaca el elemento seleccionado
                    PrincipalLayout.setBackgroundResource(R.drawable.background_item_menu);
                    homeTxt.setVisibility(View.VISIBLE);
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1.f,1f, Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    PrincipalLayout.startAnimation(scaleAnimation);
                    homeanimationView.playAnimation();

                    selectedTab=1;

                }
            }
        });

        toolsLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GalleryFragment galleryFragment = new GalleryFragment();

                getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.nav_host_fragment_content_main, galleryFragment) // Reemplazar el fragmento actual con la instancia de HomeFragment
                        .addToBackStack(null) // Agregar la transacción a la pila de retroceso
                        .commit();

                if(selectedTab!=2){

                    //Se colocan invisibles los textos
                    toolsTxt.setVisibility(View.GONE);
                    profileTxt.setVisibility(View.GONE);

                    //Se cancelan las animaciones
                    homeanimationView.cancelAnimation();
                    profileView.cancelAnimation();

                    //Se quitan los fondos de cada uno de los linear layout
                    PrincipalLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    profileLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));


                    //Se destaca el elemento seleccionado
                    toolsLayout.setBackgroundResource(R.drawable.background_item_menu);
                    toolsTxt.setVisibility(View.VISIBLE);
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1.f,1f, Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    toolsLayout.startAnimation(scaleAnimation);
                    toolsView.playAnimation();

                    selectedTab=2;

                }
            }
        });

        profileLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Configuraciones configuraciones = new Configuraciones();

                getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.nav_host_fragment_content_main, configuraciones) // Reemplazar el fragmento actual con la instancia de HomeFragment
                        .addToBackStack(null) // Agregar la transacción a la pila de retroceso
                        .commit();

                if(selectedTab!=3){

                    //Se colocan invisibles los textos
                    toolsTxt.setVisibility(View.GONE);
                    homeTxt.setVisibility(View.GONE);

                    //Se cancelan las animaciones
                    toolsView.cancelAnimation();
                    homeanimationView.cancelAnimation();

                    //Se quitan los fondos de cada uno de los linear layout
                    PrincipalLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    toolsLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));


                    //Se destaca el elemento seleccionado
                    profileLayout.setBackgroundResource(R.drawable.background_item_menu);
                    profileTxt.setVisibility(View.VISIBLE);
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1.f,1f, Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    profileLayout.startAnimation(scaleAnimation);
                    profileView.playAnimation();

                    selectedTab=3;

                }
            }
        });


        setSupportActionBar(binding.appBarMain.toolbar);




        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,R.id.nav_configuraciones)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}