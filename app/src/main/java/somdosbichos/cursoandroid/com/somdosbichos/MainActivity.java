package somdosbichos.cursoandroid.com.somdosbichos;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

//vamos implementar a interface OnClickListener. atencao, tem que implementar o metodo onClick
public class MainActivity extends Activity implements View.OnClickListener {

    private ImageView cao;
    private ImageView gato;
    private ImageView leao;
    private ImageView macaco;
    private ImageView ovelha;
    private ImageView vaca;
    private MediaPlayer mediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cao = (ImageView) findViewById(R.id.caoId);
        gato = (ImageView) findViewById(R.id.gatoId);
        leao = (ImageView) findViewById(R.id.leaoId);
        macaco = (ImageView) findViewById(R.id.macacoId);
        ovelha = (ImageView) findViewById(R.id.ovelhaId);
        vaca = (ImageView) findViewById(R.id.vacaId);

        cao.setOnClickListener(this);
        gato.setOnClickListener(this);
        leao.setOnClickListener(this);
        macaco.setOnClickListener(this);
        ovelha.setOnClickListener(this);
        vaca.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(mediaPlayer!=null){
            PararTudo();
        }
        //a gente pode recuperar informacoes sobre o que foi clicado
       // v.getId(); pega o id do que foi clicado
            //pode fazer as comparacos/verificacoes com o if(){ }else if{} .........  OU usar o switch(){}
            switch (v.getId()){
                case R.id.caoId:
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cao);
                    tocarSom();
                    break;
                case R.id.gatoId:
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gato);
                    tocarSom();
                    break;
                case R.id.leaoId:
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.leao);
                    tocarSom();
                    break;
                case R.id.macacoId:
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.macaco);
                    tocarSom();
                    break;
                case R.id.ovelhaId:
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.ovelha);
                    tocarSom();
                    break;
                case R.id.vacaId:
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.vaca);
                    tocarSom();
                    break;
            }
    }
    public void tocarSom(){
        if (mediaPlayer!=null)
        {
            mediaPlayer.start();

        }
    }
    private void PararTudo(){
        if(mediaPlayer!=null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer !=null){
            mediaPlayer.release(); //liberar os recursos usados pelo media player
            mediaPlayer = null; //limpando o objeto da memoria removendo os recursos utilizados pelo media player
        }
        super.onDestroy();
    }
}
