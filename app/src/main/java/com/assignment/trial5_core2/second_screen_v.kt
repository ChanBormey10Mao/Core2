package com.assignment.trial5_core2

import android.app.Activity
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView

class second_screen_v: AppCompatActivity() {
    lateinit var Eachmember: member

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen_v)

        Eachmember = intent.getParcelableExtra<member>("v") as member

        val Name = findViewById<TextView>(R.id.Name)
        Name.text = "Name: "+ Eachmember?.name
        val StName = findViewById<TextView>(R.id.StageName)
        StName.text = "Stage Name: " +Eachmember?.stagename
        val nickname = findViewById<TextView>(R.id.Nickname)
        nickname.text = "Nick Name: "+Eachmember?.nickname

        val Age = findViewById<TextView>(R.id.Age)
        Age.text = "Age: "+ Eachmember?.age.toString()

        val Role = findViewById<TextView>(R.id.Role)
        Role.text = "Role: "+Eachmember?.Role

        val KnownFor = findViewById<TextView>(R.id.KnownForView)
        KnownFor.text = "Known as: " +Eachmember?.knownFor

        val Picture = findViewById<ImageView>(R.id.Pic)
        val ImgRes = Picture.context.resources.getIdentifier("${Eachmember.img}", "drawable",Picture.context.packageName)
        Picture.setImageResource(ImgRes)

        var knowHim = findViewById<TextView>(R.id.knowHim)
        if(Eachmember?.KnowHim == true) {
            knowHim.append("        Yes")
        }else{
            knowHim.append("        No")
        }
        val rating = findViewById<RatingBar>(R.id.ratingV)
        rating.setOnRatingBarChangeListener(object: RatingBar.OnRatingBarChangeListener{
            override fun onRatingChanged(p0: RatingBar?, p1: Float, p2: Boolean) {
                Eachmember.rating = p1.toFloat()
            }
        })

        val vSoundButton = findViewById<Button>(R.id.SoundButton)
        var vSound: MediaPlayer? = MediaPlayer.create(this, R.raw.v_im_good_boy)
        vSoundButton?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                vSound?.start()
            }
        })
    }
    override fun onBackPressed() {

        val i = intent.apply {
            putExtra("v", Eachmember)
        }
        setResult(Activity.RESULT_OK, i)
        super.onBackPressed()
    }
}