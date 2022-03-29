package com.androiddasar.anjar

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {

    lateinit var computerImageView: ImageView
    lateinit var batuImageButton: ImageButton
    lateinit var guntingImageButton: ImageButton
    lateinit var kertasImageButton: ImageButton
    lateinit var hasilImageView: ImageView

    private fun initComponents() {
        computerImageView = findViewById(R.id.computerImageView)
        batuImageButton = findViewById(R.id.batuImageButton)
        guntingImageButton = findViewById(R.id.guntingImageButton)
        kertasImageButton = findViewById(R.id.kertasImageButton)
        hasilImageView = findViewById(R.id.hasilImageView)
    }

    private fun initListeners() {
        batuImageButton.setOnClickListener { startGame("BATU") }
        guntingImageButton.setOnClickListener { startGame("GUNTING") }
        kertasImageButton.setOnClickListener { startGame("KERTAS") }
    }

    private fun startGame(option: String) {
        val computerOption = Game.pickRandomOption()
        computerImageView.setImageResource(Game.pickDrawable(computerOption))

        when {
            Game.isDraw(option, computerOption) -> hasilImageView.setImageResource(R.drawable.draw)
            Game.isWin(option, computerOption) -> hasilImageView.setImageResource(R.drawable.winner)
            else -> hasilImageView.setImageResource(R.drawable.lose)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game)

        initComponents()
        initListeners()

    }
}