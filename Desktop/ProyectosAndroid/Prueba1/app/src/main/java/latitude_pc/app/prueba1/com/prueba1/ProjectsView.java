package latitude_pc.app.prueba1.com.prueba1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ProjectsView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects_view);
        try {
            ListView lv = (ListView) findViewById(R.id.Project_List);

            final ArrayList<String> array = new ArrayList<String>();
            array.add("Proyecto Web Recursos Humanos");
            array.add("Proyecto Inventario");
            array.add("Proyecto X");
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, array);

            lv.setAdapter(arrayAdapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                        Intent intent = new Intent(ProjectsView.this, ProjectDetail.class);
                        String title = array.get(position);
                        intent.putExtra("Title", title);
                        ProjectsView.this.startActivity(intent);
                }
            });

        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
