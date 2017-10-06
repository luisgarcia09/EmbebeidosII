package latitude_pc.app.prueba1.com.prueba1;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

public class ProjectDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);
        try {
            CollapsingToolbarLayout toolbar = (CollapsingToolbarLayout) findViewById(R.id.Collapsable);
            toolbar.setTitle(getIntent().getStringExtra("Title"));
            TextView Date = (TextView) findViewById(R.id.ProjectDate);
            Date.setText("01/10/17");
            TextView Desc = (TextView) findViewById(R.id.Desc);
            Desc.setText("Features:");
        }
        catch (Exception ex)
        {
            Toast.makeText(ProjectDetail.this,ex.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}
