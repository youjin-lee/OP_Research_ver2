package mobile.andorid.yjin.op_research_ver2;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    MainDialog1 gDialog;
    MainDialog2 tDialog;
 //   GeneralDialog gDialog;

    private static final int DIALOG_GENERAL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = (Button) findViewById(R.id.general_layout);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View target) {

                gDialog = new MainDialog1();
                gDialog.show(getFragmentManager(),"General");

            }
        });

        Button end = (Button) findViewById(R.id.tsp_layout);
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View target) {
                tDialog = new MainDialog2();
                tDialog.show(getFragmentManager(), "TSP");

            }
        });}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public static class MainDialog1 extends DialogFragment {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
            LayoutInflater mLayoutInflater = getActivity().getLayoutInflater();
            mBuilder.setView(mLayoutInflater.inflate(R.layout.gdialog_main, null));
            mBuilder.setTitle("General Problem");
            mBuilder.setMessage("변수의 값을 입력하시오");
            return mBuilder.create();
        }
        @Override
        public void onStop() {
            super.onStop();
        }

    }

    public void ONCLICK_DIALOG1(View v) {
        switch (v.getId()) {
            case R.id.g_confirm:
                Intent g_intent = new Intent(getApplicationContext(), GeneralActivity.class);
                startActivity(g_intent);
                break;
            case R.id.g_cancel:
                gDialog.dismiss();
                break;
        }
    }

    public static class MainDialog2 extends DialogFragment {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
            LayoutInflater mLayoutInflater = getActivity().getLayoutInflater();
            mBuilder.setView(mLayoutInflater.inflate(R.layout.tdialog_main, null));
            mBuilder.setTitle("TSP Problem");
            mBuilder.setMessage("X x Y 의 값을 입력하시오");
            return mBuilder.create();
        }
        @Override
        public void onStop() {
            super.onStop();
        }
    }

    public void ONCLICK_DIALOG2(View v) {
        switch (v.getId()) {
            case R.id.t_confirm:
                Intent t_intent = new Intent(getApplicationContext(), TSPActivity.class);
                startActivity(t_intent);
                break;
            case R.id.t_cancel:
                tDialog.dismiss();
                break;
        }

    }
}
