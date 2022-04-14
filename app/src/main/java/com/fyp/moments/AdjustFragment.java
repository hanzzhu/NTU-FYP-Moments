package com.fyp.moments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class AdjustFragment extends BottomSheetDialogFragment implements SeekBar.OnSeekBarChangeListener {

    public AdjustFragment() {
        // Required empty public constructor
    }

    private AjustmentListener mAjustments;

    public interface AjustmentListener {
        void onBrightnessChanged (int brightness);

        void onContrastChanged (int contrast);

        void onSaturationChanged (int saturation);

        void onAutoFixChanged (int autofix);

        void onTemperatureChanged (int temperature);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_bottom_adjust_dialog, container, false);
        return contentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SeekBar adjustBrightness = view.findViewById(R.id.adjust_brightness);
        SeekBar adjustContrast = view.findViewById(R.id.adjust_contrast);
        SeekBar adjustSaturation = view.findViewById(R.id.adjust_saturation);
        SeekBar adjustAutoFix = view.findViewById(R.id.adjust_autofix);
        SeekBar adjustTemperature = view.findViewById(R.id.adjust_temperature);

        adjustBrightness.setOnSeekBarChangeListener(this);
        adjustContrast.setOnSeekBarChangeListener(this);
        adjustSaturation.setOnSeekBarChangeListener(this);
        adjustAutoFix.setOnSeekBarChangeListener(this);
        adjustTemperature.setOnSeekBarChangeListener(this);


    }

    public void setAdjustmentsChangeListener(AjustmentListener ajustments) {
        mAjustments = ajustments;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        switch (seekBar.getId()) {
            case R.id.adjust_brightness:
                if (mAjustments != null) {
                    mAjustments.onBrightnessChanged(i);
                }
                break;
            case R.id.adjust_contrast:
                if (mAjustments != null) {
                    mAjustments.onContrastChanged(i);
                }
                break;
            case R.id.adjust_saturation:
                if (mAjustments != null) {
                    mAjustments.onSaturationChanged(i);
                }
                break;
            case R.id.adjust_autofix:
                if (mAjustments != null) {
                    mAjustments.onAutoFixChanged(i);
                }
                break;
            case R.id.adjust_temperature:
                if (mAjustments != null) {
                    mAjustments.onTemperatureChanged(i);
                }
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
