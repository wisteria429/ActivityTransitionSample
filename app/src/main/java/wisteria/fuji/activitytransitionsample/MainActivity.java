package wisteria.fuji.activitytransitionsample;

import android.content.Intent;
import android.support.annotation.AnimatorRes;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends ActionBarActivity {
    @InjectView(R.id.button_top)
    Button topButton;
    @InjectView(R.id.button_bottom)
    Button bottomButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.button_right)
    public void onClickRight(View v) {
        animationIntent(
                R.animator.slide_in_left,
                R.animator.none_animation,
                R.animator.none_animation,
                R.animator.slide_out_right
        );
    }

    @OnClick(R.id.button_left)
    public void onClickLeft(View v) {
        animationIntent(
                R.animator.slide_in_right,
                R.animator.none_animation,
                R.animator.none_animation,
                R.animator.slide_out_left
        );
    }
    @OnClick(R.id.button_top)
    public void onClickTop(View v) {
        animationIntent(
                R.animator.slide_in_top,
                R.animator.none_animation,
                R.animator.none_animation,
                R.animator.slide_out_top
        );
    }
    @OnClick(R.id.button_bottom)
    public void onClickBottom(View v) {
        animationIntent(
                R.animator.slide_in_bottom,
                R.animator.none_animation,
                R.animator.none_animation,
                R.animator.slide_out_bottom
        );
    }
    private void animationIntent(@AnimatorRes int openEnterAnim, @AnimatorRes int openExitAnim, @AnimatorRes int closeEnterAnim, @AnimatorRes int closeExitAnim)  {
        Intent intent = new Intent(this, NextActivity.class);
        intent.putExtras(NextActivity.createBundleData(closeEnterAnim, closeExitAnim));
        startActivity(intent);
        overridePendingTransition(openEnterAnim, openExitAnim);
    }
}
