package dam.gtidic.examenfinal2122.usecases.adventure;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import dam.gtidic.examenfinal2122.R;
import dam.gtidic.examenfinal2122.databinding.ActivityAdventureBinding;
import dam.gtidic.examenfinal2122.usecases.game.math.GameActivityMath;

public class AdventureActivity extends AppCompatActivity {

    private AdventureViewModel viewModel;
    private ActivityAdventureBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventure);
        setup();
        data();
    }

    // Private methods
    private void setup(){
        binding = ActivityAdventureBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(AdventureViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);


        this.getOnBackPressedDispatcher()
                .addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                close();
            }
        });
    }

    private void data(){
        Log.d(this.getClass().getSimpleName(),"...data() ");
    }

    public void showMathAdventure(View view){
            startActivity( new Intent(this, GameActivityMath.class));
    }


    private void close(){
        Log.d(this.getClass().getSimpleName(), "...closing()");
        finishAffinity();
    }

}