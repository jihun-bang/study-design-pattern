package dra.com.mvvmpatternstudy.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import dra.com.mvvmpatternstudy.Model.RobotState.RobotState;
import dra.com.mvvmpatternstudy.Model.RobotState.RobotStateManager;
import dra.com.mvvmpatternstudy.Model.RobotState.RobotStatePlay;
import dra.com.mvvmpatternstudy.Model.RobotState.RobotStateStop;
import dra.com.mvvmpatternstudy.R;
import dra.com.mvvmpatternstudy.ViewModel.MainViewModel;

public class TestActivity extends AppCompatActivity implements Button.OnClickListener {
    public MainViewModel mainViewModel = new MainViewModel();
    public static RobotStateManager robotStateManager = new RobotStateManager(new RobotStateStop());
    public static Button btnTest;
    public static Button btnRobotPlay, btnRobotStop, btnRobotPause;
    public static EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        btnRobotPlay = findViewById(R.id.btn_robotPlay);
        btnRobotPlay.setOnClickListener(this);
        btnRobotStop = findViewById(R.id.btn_robotStop);
        btnRobotStop.setOnClickListener(this);
        btnRobotPause = findViewById(R.id.btn_robotPause);
        btnRobotPause.setOnClickListener(this);
        btnTest = findViewById(R.id.btnTest);
        btnTest.setOnClickListener(this);

        editText = findViewById(R.id.editText);

        robotStateManager = RobotStateManager.getInstance();
        editText.setText(robotStateManager.toString());

    }

    // 1. 버튼 의 클릭 리스너가 이벤트 발생 체크
    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.btn_robotPlay :
                mainViewModel.setRobotState("play");
                break;

            case R.id.btn_robotPause :
                mainViewModel.setRobotState("pause");
                break;

            case R.id.btn_robotStop :
                mainViewModel.setRobotState("stop");
                break;

            case R.id.btnTest :
                // 2. ViewModel 에게 noti
                mainViewModel.setServerState();
                break;
        }
    }
}
