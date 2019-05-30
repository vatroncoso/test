package com.example.myapplication12;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;e
import java.util.Random;
import java.lang.Math;

//clase gameactivity
//implementacion de la interfaz View.OnClickListener en la activity

public class GameActivity extends Activity implements View.OnClickListener {
	Random aleatorio = new Random(System.currentTimeMillis());
	Random aleatorio2 = new Random(System.currentTimeMillis());
	Random aleatorio3 = new Random(System.currentTimeMillis());
	int correctAnswer;
	Button buttonObjectChoice1;
	Button buttonObjectChoice2;
	Button buttonObjectChoice3;
	//VARIABLES GLOBALES
	int x;
	int variable1,variable2;
	int level = 1;
	int score = 0;
	int counterCorrectAnswer = 0;
	int counterBadAnswer = 0;
	int partA,partB,wrongAnswer1,wrongAnswer2,badAnswer,goodAnswer;
	TextView textObjectPartA,textObjectPartB,textObjectScore,textObjectLevel,textObjectValuex,textObjectGood,textObjectBad;

	 


	@Override //cuando se crea la actividad
	protected void onCreate(Bundle savedInstanceState) {
		//se llama al metodo onCreate de la actividada padre.

		super.onCreate(savedInstanceState);

		// establece el layout que se usara en la actividad, o sea carga el diseño de interfaz de usuario en la pantalla.
		setContentView(R.layout.activity_game);


		// variables de inicializacion
		// PARA QUE PUEDAN UTILIZAR LAS VARIABLES EN TODOS LOS METODOS, ES MEJOR DECLARARLAS COMO GLOBALES,
		// POR ESO LAS DEJARE COMENTADAS ACÁ Y LAS DECLARARE COMO GLOBALES ARRIBA

		// ADEMAS USARE UN METODO LLAMADO NUMERITOS_BOTONES, PARA UTILIZARLO EN EL METODO ONCLICK ASI QUE LO COMENTARE
		numeritos_botones();
	
		x = (int) (Math.random() * 2);


        /*Aquí obtenemos un objeto de trabajo basado en cualquiera de los dos botones.
          o TextView clase y base, así como vincular nuestros nuevos objetos
          directamente a los elementos de la interfaz de usuario apropiados que creamos anteriormente */

		textObjectPartA = (TextView) findViewById(R.id.textPartA);
		textObjectPartB = (TextView) findViewById(R.id.textPartB);
		textObjectScore = (TextView) findViewById(R.id.currentScore);
		textObjectLevel = (TextView) findViewById(R.id.currentLevel);
		textObjectValuex = (TextView) findViewById(R.id.valuex);
		textObjectGood = (TextView) findViewById(R.id.good);
		textObjectBad = (TextView) findViewById(R.id.bad);

		buttonObjectChoice1 = (Button) findViewById(R.id.buttonChoice1);
		buttonObjectChoice2 = (Button) findViewById(R.id.buttonChoice2);
		buttonObjectChoice3 = (Button) findViewById(R.id.buttonChoice3);
		
		initialize();
		// Establecer click oyentes para cada botón
		//el this se ocupa por que ya esta la implementacion de la interfaz que esta por fuera en el public class...
		buttonObjectChoice1.setOnClickListener(this); //calling onClick() method
		buttonObjectChoice2.setOnClickListener(this);
		buttonObjectChoice3.setOnClickListener(this);
	}

	@Override //lo que va a suceder luego de presionar el boton
	public void onClick(View view) {
		//manejo de eventos onClick
	
		updateScore();
	

		/*se crea un switch como instruccion condicional para detectar que boton se esta pulsando
		y con view.getId() se consigue cual es el identificador del boton*/
		if (x == 0) {
			switch (view.getId()) {

				case R.id.buttonChoice1: //caso al presionar el boton 1

					//lo que quiero que se presente cuando se implemente o presione el boton 1
					Toast.makeText(getApplicationContext(), "Es correcto", Toast.LENGTH_SHORT).show();
					numeritos_botones();
					initialize();
					counterCorrectAnswer = counterCorrectAnswer + 1;
					updateScore(); //SE EJECUTA ACÁ TAMBIÉN PARA ASÍ ASEGURAR QUE SE RANDOMIZE CADA VEZ
					break; //detiene éste case, se cierra el switch y pasa al case siguiente

				case R.id.buttonChoice2:
					tonChoice2:
					//caso al presionar el boton 2

					//lo que quiero que se presente cuando se implemente o presione el boton 2
					Toast.makeText(getApplicationContext(), "Es incorrecto", Toast.LENGTH_SHORT).show();
					numeritos_botones();
					initialize(); //SE EJECUTA ACÁ TAMBIÉN PARA ASÍ ASEGURAR QUE SE RANDOMIZE CADA VEZ
					counterBadAnswer = counterBadAnswer + 1;
					updateScore();
					break; //detiene éste case, se cierra el switch y pasa al case siguiente

				case R.id.buttonChoice3: //caso al presionar el boton 3

					//lo que quiero que se presente cuando se implemente o presione el boton 3
					Toast.makeText(getApplicationContext(), "Es incorrecto", Toast.LENGTH_SHORT).show();
					numeritos_botones();
					initialize(); //SE EJECUTA ACÁ TAMBIÉN PARA ASÍ ASEGURAR QUE SE RANDOMIZE CADA VEZ
					counterBadAnswer = counterBadAnswer + 1;
					updateScore();
					break; //detiene éste case y se cierra el switch

				//sin los break, se ejecutaría un case tras otro.
			}
		}


		if (x == 1) {
			switch (view.getId()) {

				case R.id.buttonChoice1: //caso al presionar el boton 1

					//lo que quiero que se presente cuando se implemente o presione el boton 1
					Toast.makeText(getApplicationContext(), "Es incorrecto", Toast.LENGTH_SHORT).show();
					numeritos_botones();
					initialize(); //SE EJECUTA ACÁ TAMBIÉN PARA ASÍ ASEGURAR QUE SE RANDOMIZE CADA VEZ
					counterBadAnswer = counterBadAnswer + 1;
					updateScore();
					break; //detiene éste case, se cierra el switch y pasa al case siguiente

				case R.id.buttonChoice2:
					//caso al presionar el boton 2

					//lo que quiero que se presente cuando se implemente o presione el boton 2
					Toast.makeText(getApplicationContext(), "Es correcto", Toast.LENGTH_SHORT).show();
					numeritos_botones();
					initialize();
					counterCorrectAnswer = counterCorrectAnswer + 1;
					updateScore(); //SE EJECUTA ACÁ TAMBIÉN PARA ASÍ ASEGURAR QUE SE RANDOMIZE CADA VEZ
					break; //detiene éste case, se cierra el switch y pasa al case siguiente

				case R.id.buttonChoice3: //caso al presionar el boton 3

					//lo que quiero que se presente cuando se implemente o presione el boton 3
					Toast.makeText(getApplicationContext(), "Es incorrecto", Toast.LENGTH_SHORT).show();
					numeritos_botones();
					initialize(); //SE EJECUTA ACÁ TAMBIÉN PARA ASÍ ASEGURAR QUE SE RANDOMIZE CADA VEZ
					counterBadAnswer = counterBadAnswer + 1;
					updateScore();
					break; //detiene éste case y se cierra el switch

				//sin los break, se ejecutaría un case tras otro.

			}
		}

		if (x == 2) {
			switch (view.getId()) {

				case R.id.buttonChoice1: //caso al presionar el boton 1

					//lo que quiero que se presente cuando se implemente o presione el boton 1
					Toast.makeText(getApplicationContext(), "Es incorrecto", Toast.LENGTH_SHORT).show();
					numeritos_botones();
					initialize(); //SE EJECUTA ACÁ TAMBIÉN PARA ASÍ ASEGURAR QUE SE RANDOMIZE CADA VEZ
					counterBadAnswer = counterBadAnswer + 1;
					updateScore();
					break; //detiene éste case, se cierra el switch y pasa al case siguiente

				case R.id.buttonChoice2:
					tonChoice2:
					//caso al presionar el boton 2

					//lo que quiero que se presente cuando se implemente o presione el boton 2
					Toast.makeText(getApplicationContext(), "Es incorrecto", Toast.LENGTH_SHORT).show();
					numeritos_botones();
					initialize(); //SE EJECUTA ACÁ TAMBIÉN PARA ASÍ ASEGURAR QUE SE RANDOMIZE CADA VEZ
					counterBadAnswer = counterBadAnswer + 1;
					updateScore();
					break; //detiene éste case, se cierra el switch y pasa al case siguiente

				case R.id.buttonChoice3: //caso al presionar el boton 3

					//lo que quiero que se presente cuando se implemente o presione el boton 3
					Toast.makeText(getApplicationContext(), "Es correcto", Toast.LENGTH_SHORT).show();
					numeritos_botones();
					initialize();
					counterCorrectAnswer = counterCorrectAnswer + 1;
					updateScore(); //SE EJECUTA ACÁ TAMBIÉN PARA ASÍ ASEGURAR QUE SE RANDOMIZE CADA VEZ
					break; //detiene éste case y se cierra el switch

				//sin los break, se ejecutaría un case tras otro.

			}
		}
                 /*finish();
		         startActivity(getIntent());*/
	}
	public void numeritos_botones(){
		
		partA = aleatorio.nextInt(100) + 1;
		partB = (int) (Math.random() * 100) + 1;
		variable1 = (int) (Math.random() * 100) + 1;
		variable2 =  aleatorio2.nextInt(100)+1;
		

		correctAnswer = partA * partB;
		wrongAnswer1 = correctAnswer + variable1;
		wrongAnswer2 = correctAnswer - variable2;
}
	public void initialize(){
		x = aleatorio.nextInt(3);
			textObjectPartA.setText("" + partA);
			textObjectPartB.setText("" + partB);
			textObjectScore.setText("" + score);
			textObjectLevel.setText("" + level);
			textObjectValuex.setText("" + x);
			textObjectGood.setText("" + counterCorrectAnswer);
			textObjectBad.setText("" + counterBadAnswer);

		if (x == 0) {
			

			buttonObjectChoice1.setText("" + correctAnswer);
			buttonObjectChoice2.setText("" + wrongAnswer1);
			buttonObjectChoice3.setText("" + wrongAnswer2);
		}
		if (x == 1) {
			
			buttonObjectChoice1.setText("" + wrongAnswer1);
			buttonObjectChoice2.setText("" + correctAnswer);
			buttonObjectChoice3.setText("" + wrongAnswer2);
		}
		if (x == 2) {
			
			buttonObjectChoice1.setText("" + wrongAnswer1);
			buttonObjectChoice2.setText("" + wrongAnswer2);
			buttonObjectChoice3.setText("" + correctAnswer);
		}
	}
	
		public void updateScore() {
		goodAnswer = counterCorrectAnswer*100;
		badAnswer = counterBadAnswer*50;
		score = goodAnswer - badAnswer;

		for (int i = 10;i <=100; i+=10) {
			if(counterCorrectAnswer==i){
				level = i/10 + 1;
			}
		}	
		}
		}
