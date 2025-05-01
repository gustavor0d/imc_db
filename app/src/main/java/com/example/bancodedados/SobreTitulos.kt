package com.example.bancodedados

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button
import android.widget.TextView

class SobreTitulos : AppCompatActivity() {

    private lateinit var btnVoltar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sobre_titulos)

        btnVoltar = findViewById(R.id.btnVoltar2)
        btnVoltar.setOnClickListener {val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val texto = findViewById<TextView>(R.id.texto)
        texto.text = """
TÍTULOS DO MAIOR TIME DO MUNDO:

1913 – Campeão Santista (1º) 

1915 – Bicampeão Santista (2º) 

1926 – Campeão do Torneio Início Extra  

1927 – Campeão da Técnica e da Disciplina 

1928 – Campeão Torneio Início (APEA) (1º) 

1929 – Campeão Santista (3º) 

1930 – Campeão do Torneio Início Santista  

1935 – Campeão Paulista – (1º) 

1937 – Campeão Torneio Início – LPF (2º) 

1948 – Taça Cidade de Santos  

1948 – Taça das Taças  

1949 – Taça Cidade de São Paulo 

1951 – Torneio Quadrangular de Belo Horizonte  

1952 – Taça Santos FC  

1952 – Campeão do Torneio Inicio – FPF)  (3º) 

1953 – Taça Cidade de Santos

1953 – Triangular de Vitória-ES  

1955 – Campeão Paulista (2º) 

1956 – Bicampeão Paulista (3º)  

1956 – Campeão do Torneio de Classificação da FPF  

1956 – Taça dos Invictos – (24 jogos) (1º) 

1956 – Campeão do Torneio Internacional da FPF  

1958 – Campeão Paulista (4º) 

1959 – Campeão do Torneio Pentagonal do México  

1959 – Vencedor da Taça Dr. Mário Echandi (Costa Rica)  

1959 – Campeão do Torneio Rio-São Paulo (1º) 

1959 – Troféu Tereza Herrera/Espanha  

1959 – Troféu Triangular de Valência/Espanha  

1960 – Taça Cidade de Paris (IV Torneio) 

1960 – Troféu Giallorosso (Itália) 

1960 – Campeão Paulista (5º)  

1961 – Torneio da Costa Rica 

1961 – Torneio Pentagonal de Guadalajara  

1961 – Torneio da Itália  

1961 – Bicampeão do Torneio de Paris  

1961 – Bicampeão Paulista (6º)  

1961 – Campeão Brasileiro (Taça Brasil) (1º) 

1962 – Bicampeão Brasileiro (Taça Brasil) (2º) 

1962 – Campeão da Taça Libertadores da América (1º) 

1962 – Tricampeão Paulista (7º)  

1962 – Campeão Mundial Interclubes (1º) 

1963 – Tricampeão Brasileiro (Taça Brasil) (3º) 

1963 – Campeão do Torneio Rio-São Paulo (2º) 

1963 – Bicampeão da Taça Libertadores da América (2º) 

1963 – Bicampeão Mundial Interclubes (2º) 

1964 – Bicampeão do Torneio Rio-São Paulo (3º) 

1964 – Campeão Paulista ( 8º)  

1964 – Tetracampeão Brasileiro (Taça Brasil) (4º) 

1965 – Torneio Hexagonal do Chile (1º) 

1965 – Torneio de Caracas – Venezuela  

1965 – Torneio Quadrangular de Buenos Aires (Argentina)  

1965 – Bicampeão Paulista (9º)

1965 – Pentacampeão Brasileiro (Taça Brasil) (5º) 

1966 – Campeão do Torneio Rio-São Paulo (4º) 

1966 – Torneio de Nova York  

1967 – Campeão Paulista (10º) 

1967 – Torneio Rubens Ulhôa Cintra (Cidade de Santos) 

1967 – Triangular Roma / Florença  

1967 – Fita Azul do Futebol Brasileiro – (11 jogos invictos) (1º) 

1968 – Bicampeão Paulista (11º) 

1968 – Campeão Brasileiro – Torneio Roberto Gomes Pedrosa (1ª Taça de Prata) (6º) 

1968 – Torneio da Amazônia  

1968 – Torneio Octogonal do Chile (Nicolau Moran)  

1968 – Torneio Pentagonal de Buenos Aires (Argentina)  

1968 – Campeão da Recopa Sul-Americana Interclubes (1º) 

1968 – Campeão da Recopa Mundial Interclubes (1º) 

1969 – Tricampeão Paulista (12º) 

1969 – Campeão do Torneio de Cuiabá  

1970 – Campeão do Torneio Hexagonal do Chile (2º) 

1970 – Campeão do Triangular da Guatemala  

1970 – Campeão da Taça Cidade de São Paulo  

1971 – Torneio de Kingston / Jamaica  

1972 – Fita Azul do Futebol Brasileiro (17 jogos invictos) (2º) 

1973 – Fita Azul do Brasileiro (10 jogos invictos) (3º) 

1970 – Campeão Paulista (13º) 

1975 – Torneio Governador do Estado SP (Laudo Natel)  

1975 – Torneio Governador da Bahia (Roberto Santos) 

1977 – Torneio Hexagonal do Chile (3º) 

1977 – Torneio Triangular León/México  

1978 – Campeão Paulista (14º) 

1983 – Torneio Vencedores da América / Uruguai  

1983 – Torneio Cidade de Pamplona / Espanha  

1984 – Torneio Início da FPF (4º) 

1984 – Taça dos Invictos (Gazeta Esportiva) (2º) 

1984 – Campeão Paulista (15º) 

1985 – Copa Kirin – Japão  

1987 – Torneio Cidade de Marseille / França  

1990 – Super Copa Sul-Americana – Tai Pei (Taywan)  

1994 – Copa Denner  

1995 – Taça Cidade de Santos  

1996 – Torneio de Verão Santos  

1997 – Torneio Rio-São Paulo (5º) 

1998 – Copa Conmembol

2000 – Melhor do Século nas Américas  

2002 – Campeão Brasileiro (7º) 

2004 – Copa Federação Paulista de Futebol  

2004 – Campeão Brasileiro (8º) 

2006 – Campeão Paulista (16º) 

2007 – Bicampeão Paulista (17º)  

2010 – Campeão Paulista (18º)  

2010 – Campeão da Copa do Brasil  

2011 – Campeão Paulista (19º)  

2011 – Campeão da Taça Libertadores da América (3º)  

2012 – Tricampeão Paulista (20º) 

2012 – Campeão da Recopa Sul-Americana (2º) 

2015 – Campeão Paulista (21º)  

2016 – Bicampeão Paulista (22º)
        """.trimIndent()
        texto.movementMethod = android.text.method.ScrollingMovementMethod()
    }
}