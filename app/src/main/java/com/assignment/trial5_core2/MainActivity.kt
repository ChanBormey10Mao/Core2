package com.assignment.trial5_core2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

lateinit var memberRM: member
lateinit var memberJin: member
lateinit var memberJK: member
lateinit var memberV: member

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        memberRM = member("Kim Namjoon", "Rap Monster",
                "God of Destruction\nJoonie\nNamu\nMoni\n", 26, "Leader, Main Rapper","148IQ\nDaddy of BTS", 0F, "rm", false)

        memberJin = member("Kim Seokjin", "Jin",
                "World Wide Handsome\nEatjin", 27, "Visual, Vocalist","Mannar idol, Mum of BTS",0F ,"jin",false)

        memberJK = member("Jeon Jungkook", "Jungkook",
                "Bunny\nGolden Maknae\nJK", 23, "Face  of the group\nCentre\nMain Vocalist\nMaknae","Muscle Bunny\nAngelic Voice\nBanana Milk" ,0F,"jk",false)
        memberV = member("Kim Taehyung", "V",
                "Baby Lion\nTae Tae", 24, "Visual, Vocalist","4D Alien\nGood Boi\nGucci Boi",0F ,"v",false)

        val rmImgButton = findViewById<ImageButton>(R.id.RMimageButton)
        val jinImgButton = findViewById<ImageButton>(R.id.jinImageButton)
        val jkImgButton = findViewById<ImageButton>(R.id.JKimageButton)
        val vImgButton = findViewById<ImageButton>(R.id.VImageButton)

        val rmInfoTextView = findViewById<TextView>(R.id.RMTextView)
        val jinInfoTextView = findViewById<TextView>(R.id.JinTextView)
        val jkInfoTextView = findViewById<TextView>(R.id.jkTextView)
        val vInfoTextView = findViewById<TextView>(R.id.VTextView)

        val switchRM = findViewById<Switch>(R.id.switchRM)
        val switchJin = findViewById<Switch>(R.id.switchJin)
        val switchJk = findViewById<Switch>(R.id.switchJK)
        val switchV = findViewById<Switch>(R.id.switchV)

        rmInfoTextView.text = "Name: ${memberRM.name}\nRole: ${memberRM.Role}\n"
        jinInfoTextView.text = "Name: ${memberJin.name}\n" + "Role: ${memberJin.Role}\n"
        vInfoTextView.text = "Name: ${memberV.name}\n" + "Role: ${memberV.Role}\n"
        jkInfoTextView.text = "Name: ${memberJK.name}\n" + "Role: ${memberJK.Role}\n"

        switchRM?.setOnCheckedChangeListener { _, isChecked ->
            memberRM.KnowHim = isChecked
        }
        switchJin?.setOnCheckedChangeListener { _, isChecked ->
            memberJin.KnowHim = isChecked
        }
        switchJk?.setOnCheckedChangeListener { _, isChecked ->
            memberJK.KnowHim = isChecked
        }
        switchV?.setOnCheckedChangeListener { _, isChecked ->
            memberV.KnowHim = isChecked
        }

        rmImgButton.setOnClickListener {
            val i = Intent(this, SecondScreen_R::class.java)
            i.putExtra("RM",memberRM)
            startActivityForResult(i,0)
        }
        jinImgButton.setOnClickListener {
            val i = Intent(this, SecondScreen_Jin::class.java)
            i.putExtra("jin", memberJin)
            startActivityForResult(i,1)
        }
        jkImgButton.setOnClickListener {
            val i = Intent(this, second_screen_jk::class.java)
            i.putExtra("jk", memberJK)
            startActivityForResult(i,2)
        }
        vImgButton.setOnClickListener {
            val i = Intent(this, second_screen_v::class.java)
            i.putExtra("v", memberV)
            startActivityForResult(i,2)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode != Activity.RESULT_OK) return

        when (requestCode) {
            0-> {
                val memberEach = data?.getParcelableExtra<member>("RM")
                val rating = findViewById<TextView>(R.id.ratingRm)
                memberEach?.let {
                    rating.append("${memberEach.rating}/5")
                }
            }
            1->{
                val memberEach = data?.getParcelableExtra<member>("jin")
                val rating = findViewById<TextView>(R.id.ratingJin)
                memberEach?.let {
                    rating.append("${memberEach.rating}/5")
                }
            }
            2->{
                val memberEach = data?.getParcelableExtra<member>("jk")
                val rating = findViewById<TextView>(R.id.ratingJK)
                memberEach?.let {
                    rating.append("${memberEach.rating}/5")
                }
            }
            3-> {
                val memberEach = data?.getParcelableExtra<member>("v")
                val rating = findViewById<TextView>(R.id.ratingV)
                memberEach?.let {
                    rating.append("${memberEach.rating}/5")
                }
            }
        }
    }

}



