package me.shafran.resourcessample;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button animationViaAnimatorButton;
    private Button animationViaAnimButton;
    private TextView pluralsOneTextView;
    private TextView pluralsOtherTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animationViaAnimatorButton = findViewById(R.id.animationViaAnimatorButton);
        animationViaAnimatorButton.setOnClickListener(this);

        animationViaAnimButton = findViewById(R.id.animationViaAnimButton);
        animationViaAnimButton.setOnClickListener(this);

        pluralsOneTextView = findViewById(R.id.pluralsOneTextView);
        pluralsOneTextView.setText(getResources().getQuantityString(R.plurals.plurals_sample, 1));

        pluralsOtherTextView = findViewById(R.id.pluralsOtherTextView);
        pluralsOtherTextView.setText(getResources().getQuantityString(R.plurals.plurals_sample, 2));
    }

    @Override
    public void onClick(final View v) {
        switch (v.getId()) {
            case R.id.animationViaAnimatorButton:
                startAnimationViaAnimator();
                break;
            case R.id.animationViaAnimButton:
                startAnimationViaAnim();
                break;
            default:
                // Ничего не делать
        }
    }

    private void startAnimationViaAnimator() {
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.animation_sample);
        set.setTarget(animationViaAnimatorButton);
        set.start();
    }

    private void startAnimationViaAnim() {
        animationViaAnimButton.startAnimation(
                AnimationUtils.loadAnimation(this, R.anim.anim_sample)
        );
    }
}
