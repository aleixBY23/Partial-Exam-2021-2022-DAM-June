package dam.gtidic.examenfinal2122.usecases.adventure;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import dam.gtidic.examenfinal2122.utils.PreferencesProvider;

public class AdventureViewModel extends ViewModel {

    public MutableLiveData<String> livesLiveData;
    int vides;

    public AdventureViewModel() {
        this.livesLiveData = new MutableLiveData<>(String.valueOf(PreferencesProvider.providePreferences().getInt("lives", 0)));
        this.vides = PreferencesProvider.providePreferences().getInt("lives", 0);
    }

    public void purchaseALive(){
        vides++;
        livesLiveData.setValue(String.valueOf(vides));
        PreferencesProvider.providePreferences().edit().putInt("lives", vides).commit();
    }
    public int getVidesInt(){
        return Integer.valueOf(livesLiveData.getValue());
    }
    public MutableLiveData<String> getLives() {
        return livesLiveData;
    }

    public void setLives(MutableLiveData<String> livesLiveData) {
        this.livesLiveData = livesLiveData;
    }
}
