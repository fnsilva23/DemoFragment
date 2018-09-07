package com.example.logonrmlocal.demofragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main.activity_back_stack.*

class BackStackActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_back_stack)

        btPrimeiro.setOnClickListener {
            // Passando informações para o fragment através do Bundle
            val primeiroFragment = PrimeiroFragment()
            val bundle = Bundle()
            bundle.putString("mensagem", "Sou o fragmento 1")
            primeiroFragment.arguments = bundle

            trocaFragment(primeiroFragment, "frag1")
        }

        btSegundo.setOnClickListener{
            // Passando informações para o fragment através do Bundle
            val segundoFragment = SegundoFragment()
            val bundle = Bundle()
            bundle.putString("mensagem", "Sou o fragmento 2")
            segundoFragment.arguments = bundle

            trocaFragment(segundoFragment, "frag2")
        }

    }

    //Função que recebe um fragment e troca na tela
    private fun trocaFragment(fragment : Fragment, tag: String){
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.containerFragment, fragment)
        ft.addToBackStack(tag)
        ft.commit()

    }
}
