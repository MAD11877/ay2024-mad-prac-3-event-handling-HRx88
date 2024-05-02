package sg.edu.np.mad.madpractical3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        User user = new User("John Doe","MAD Developer",1,false);

        TextView tvName = findViewById(R.id.tvName);
        TextView tvDescription=findViewById(R.id.tvDescription);
        Button btnFollow=findViewById(R.id.btnFollow);
        ImageView imageView = findViewById(R.id.imageView3);

        tvName.setText(user.name);
        tvDescription.setText(user.description);
        btnFollow.setText("Follow");


        btnFollow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (user.followed==false){
                    btnFollow.setText("Unfollow");
                    user.followed=true;
                    Toast.makeText(MainActivity.this,"Unfollowed",Toast.LENGTH_SHORT).show();
                }
                else if (user.followed==true){
                    btnFollow.setText("Follow");
                    user.followed=false;
                    Toast.makeText(MainActivity.this,"Followed",Toast.LENGTH_SHORT).show();
                }


            }
        });

        Intent main = getIntent();
        int num = main.getIntExtra("num",0);

        tvName.setText("MAD "+num);
    }
}