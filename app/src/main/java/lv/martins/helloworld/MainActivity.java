package lv.martins.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList selectedItems = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button goToSecond = (Button) findViewById(R.id.go_to_second);
        goToSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        Button dialog = (Button) findViewById(R.id.dialog);
        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.dialog_title)
                    .setMultiChoiceItems(R.array.students_array,null, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which,
                                            boolean isChecked) {

                            String checked = getResources().getStringArray(R.array.students_array)[which];
;                            if (isChecked) {
                                // If the user checked the item, add it to the selected items
                                selectedItems.add(which);
                                Toast.makeText(MainActivity.this,"student selected "+ checked, Toast.LENGTH_LONG).show();
                            } else if (selectedItems.contains(which)) {
                                // Else, if the item is already in the array, remove it
                                selectedItems.remove(Integer.valueOf(which));
                                Toast.makeText(MainActivity.this,"student unselected " + checked, Toast.LENGTH_LONG).show();
                            }
                        }
                    })
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // FIRE ZE MISSILES!
                        }
                    })
                    .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User cancelled the dialog
                        }
                    });
                // Create the AlertDialog object and return it
                builder.create();
                builder.show();
            }
        });
    }


}


////        ArrayList selectedItems = new ArrayList();  // Where we track the selected items
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        // Set the dialog title
//        builder.setTitle("Users")
//                // Specify the list array, the items to be selected by default (null for none),
//                // and the listener through which to receive callbacks when items are selected
//                .setMultiChoiceItems(, null,
//                        new DialogInterface.OnMultiChoiceClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which,
//                                                boolean isChecked) {
////                                if (isChecked) {
////                                    // If the user checked the item, add it to the selected items
////                                   // selectedItems.add(which);
////                                } else if (selectedItems.contains(which)) {
////                                    // Else, if the item is already in the array, remove it
////                                  //  selectedItems.remove(Integer.valueOf(which));
////                                }
//                            }
//                        })
//                // Set the action buttons
//                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int id) {
//                        // User clicked OK, so save the selectedItems results somewhere
//                        // or return them to the component that opened the dialog
//                    }
//                })
//                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int id) {
//                    }
//                });
//
//        return builder.create();
//    }
//}
