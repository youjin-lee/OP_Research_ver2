package mobile.andorid.yjin.op_research_ver2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import static mobile.andorid.yjin.op_research_ver2.R.id.sign_table;
import static mobile.andorid.yjin.op_research_ver2.R.id.table;

/**
 * Created by You Jin on 2017-05-14.
 */

public class GeneralActivity extends AppCompatActivity {

    final static int DIALOG_LIST_MESSAGE = 1;

    private int selectedID = -1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.general_main);

        RadioGroup rg = (RadioGroup) findViewById(R.id.general_radiogroup);

        Button b = (Button) findViewById(R.id.gmethod);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (selectedID) {
                    case R.id.general_tobinary:
                        break;
                    case R.id.general_tointeger:
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "조건을 선택하시오", Toast.LENGTH_SHORT).show();
                }
                showDialog(DIALOG_LIST_MESSAGE);
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                selectedID = checkedId;
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.spinner_goal);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.goal_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Intent i = getIntent();
        int vars = i.getIntExtra("NUM_OF_VAR", 3);
        int rows = i.getIntExtra("NUM_OF_ROW", 4);
        Toast.makeText(getApplicationContext(), "vars=" + vars + ", rows=" + rows, Toast.LENGTH_SHORT).show();

        TableLayout tl = (TableLayout) findViewById(table);
        TableLayout t2 = (TableLayout) findViewById(sign_table);
        EditText et;

        for (int x = 0; x < rows; x++) {

            TableRow row = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);

            for (int y = 0; y < vars; y++) {
                et = new EditText(this);
                et.setHint("상수");
                row.addView(et);
            }
            tl.addView(row, x);
        }

        for (int z = 0; z < rows; z++) {

            TableRow cons = new TableRow(this);
            TableRow.LayoutParams cp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            cons.setLayoutParams(cp);

            Spinner constraints = (Spinner) findViewById(R.id.constraint_range);
            ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
                    this, R.array.cons_array, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            constraints.setAdapter(adapter2);

            t2.addView(cons, z);
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DIALOG_LIST_MESSAGE:
                final CharSequence[] items = {"Branch and Bound","Cutting Plane","Continuous Heuristic","Tabu Search","Simulated Annealing","Genetic"};

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("풀이 방법을 선택하시오");

                builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {

                        Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();

                        switch (item) {
                            case 0:
                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            default:
                                Toast.makeText(getApplicationContext(), "풀이방법을 선택하시오", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog alert = builder.create();
                return alert;
        }
        return null;
    }
}
