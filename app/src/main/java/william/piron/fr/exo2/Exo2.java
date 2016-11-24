package william.piron.fr.exo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Exo2 extends AppCompatActivity {

    SimpleAdapter simpleAdapter;
    List<HashMap<String, Object>> personnes;
    ListView lv;
    int i=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo2);

        personnes = new ArrayList<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("photo", null);
        map.put("nom", "Piron");
        map.put("prenom", "William");
        personnes.add(map);
        String[] from = {"nom", "prenom"};
        int[] to = {R.id.linearlayout_layout_horizontal_vertical_textnom, R.id.linearlayout_layout_horizontal_vertical_textprenom};

        simpleAdapter = new SimpleAdapter(this, personnes,R.layout.listitem, from, to);
        lv = (ListView) findViewById(R.id.linearlayout_vertical_listview);
        lv.setAdapter(simpleAdapter);
        //simpleAdapter.notifyDataSetChanged();

        Button plus = (Button) findViewById(R.id.linearlayout_horizontal_buttonplus);
        Button minus = (Button) findViewById(R.id.linearlayout_horizontal_buttonminus);

        plus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                HashMap<String, Object> map = new HashMap<>();
                i++;
                map.put("photo", null);
                map.put("nom", "Nom : "+i);
                map.put("prenom", "Prénom : "+i);
                personnes.add(map);
                simpleAdapter.notifyDataSetChanged();
            }
        });

        minus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                personnes.clear();
                i=0;
                simpleAdapter.notifyDataSetChanged();
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                personnes.remove(position);
                simpleAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}
