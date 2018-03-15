package ui.loading.android.com.myapplication;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show();

            }
        });

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              show2();
            }
        });
    }

    private void show2() {
        LoadingDialog.Builder builder2=new LoadingDialog.Builder(MainActivity.this)
                .setShowMessage(false)
                .setCancelable(false);
        final LoadingDialog dialog2=builder2.create();
        dialog2.show();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog2.dismiss();
            }
        },2000);
    }

    private void show() {
        LoadingDialog.Builder builder1=new LoadingDialog.Builder(MainActivity.this)
                .setMessage("加载中...")
                .setCancelable(false);
        final LoadingDialog dialog1=builder1.create();
        dialog1.show();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog1.dismiss();
            }
        },2000);
    }
}
