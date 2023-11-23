package com.example.appderestaurante;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appderestaurante.adapter.FoodAdapter;
import com.example.appderestaurante.databinding.ActivityListaBinding;
import com.example.appderestaurante.model.Food;

import java.util.ArrayList;

public class Lista extends AppCompatActivity {
    private final ArrayList<Food> foodList = new ArrayList<>();
    private AppCompatButton btEntar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Usando View Binding
        ActivityListaBinding binding = ActivityListaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Inicializar os componentes
        IniciarComponentesLis();

        // Configurar o RecyclerView
        RecyclerView recyclerViewFood = binding.RecyclerViewFood;
        recyclerViewFood.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewFood.setHasFixedSize(true);

        // Configurar o FoodAdapter
        FoodAdapter foodAdapter = new FoodAdapter(foodList, this);
        recyclerViewFood.setAdapter(foodAdapter);

        // Preencher a lista de alimentos
        getFood();

        // Adicionar OnClickListener ao botão
        btEntar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Lista.this, inicio.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void getFood(){
        Food food1 = new Food(
                R.drawable.ebook1,
                "Rumo à Liberdade Financeira",
                "Este e-book abrange estratégias práticas para criar um plano financeiro sólido, desde a gestão do orçamento até a construção de um fundo de emergência. Descubra como alcançar a liberdade financeira e tomar o controle de suas finanças.",
                "$ 120.00"
        );
        foodList.add(food1);


        Food food2 = new Food(
                R.drawable.ebook2,
                "Investindo com Inteligência",
                "Para aqueles que desejam iniciar no mundo dos investimentos, este e-book oferece conselhos claros e práticos. Aprenda sobre diferentes opções de investimento, como ações, títulos e fundos mútuos, e desenvolva uma abordagem inteligente para fazer seu dinheiro trabalhar por você.",
                "$ 80.00"
        );
        foodList.add(food2);

        Food food3 = new Food(
                R.drawable.ebook3,
                "Economize, Invista, Conquiste",
                "Descubra como equilibrar o presente e o futuro, aprendendo a economizar de forma eficiente, investir de maneira estratégica e conquistar seus objetivos financeiros a longo prazo. Este guia completo irá capacitá-lo a tomar decisões financeiras informadas.",
                "$ 20.00"
        );
        foodList.add(food3);

        Food food4 = new Food(
                R.drawable.ebook4,
                "Orçamento Descomplicado",
                "Este e-book desmistifica o processo de elaboração de orçamentos, tornando-o acessível a todos. Aprenda a criar e manter um orçamento eficaz, identificando áreas para economizar e priorizando gastos para alcançar seus objetivos financeiros de maneira realista e sustentável.",
                "$ 60.00"
        );
        foodList.add(food4);

        Food food5 = new Food(
                R.drawable.ebook5,
                "O Caminho da Riqueza",
                "Este e-book avançado explora estratégias de investimento mais complexas, desde a diversificação da carteira até a compreensão das tendências do mercado. Desenvolva habilidades avançadas para maximizar seus ganhos e construir riqueza ao longo do tempo.",
                "$ 50.00"
        );
        foodList.add(food5);

    }
    private void IniciarComponentesLis() {
        // Inicializar os componentes, como você fez antes
        btEntar = findViewById(R.id.btEntar);
    }

}