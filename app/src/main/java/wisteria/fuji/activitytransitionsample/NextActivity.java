package wisteria.fuji.activitytransitionsample;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.AnimatorRes;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class NextActivity extends Activity {
    private static final String BUNDLE_CLOSE_ENTER_ANIM_RES_ID = "close_enter_animation_res_id";
    private static final String BUNDLE_CLOSE_EXIT_ANIM_RES_ID = "close_exit_animation_res_id";

    @InjectView(R.id.button_prev)
    Button prevButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.button_prev)
    public void onClick(View v) {
        Intent intent = getIntent();

        finish();
        overridePendingTransition(
                intent.getIntExtra(BUNDLE_CLOSE_ENTER_ANIM_RES_ID, R.animator.none_animation),
                intent.getIntExtra(BUNDLE_CLOSE_EXIT_ANIM_RES_ID, R.animator.none_animation)
        );
    }

    public static Bundle createBundleData(@AnimatorRes int closeEnterAnimResId, @AnimatorRes int closeExitAnimResId) {
        Bundle bundle = new Bundle();
        bundle.putInt(BUNDLE_CLOSE_ENTER_ANIM_RES_ID, closeEnterAnimResId);
        bundle.putInt(BUNDLE_CLOSE_EXIT_ANIM_RES_ID, closeExitAnimResId);

        return bundle;

    }

}
