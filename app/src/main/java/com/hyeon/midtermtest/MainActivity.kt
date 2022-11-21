package com.hyeon.midtermtest

import android.app.Activity
import android.app.Dialog
import android.app.ProgressDialog.show
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hyeon.midtermtest.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.w3c.dom.Text


class MainActivity : AppCompatActivity(){
    //지금 공부할 내용 : ViewModel
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            val intent = Intent(this@MainActivity,SubActivity::class.java)
            // text 는 safeNull 처리 필요 X
            var str = binding.editText.text.toString()
            // intent 에게 ( key, Data )를 넘김
            intent.putExtra(EXTRA_MESSAGE,str)
            // 결과를 받기 위해 새로운 Intent 를 실행
            startForResult.launch(intent)

        }

    }
    private val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        // 받아온 결과 값 코드 -> Result_OK
        if (it.resultCode ==  Activity.RESULT_OK){
            //
            if (it.data != null) {
                // safeNull 처리
                val extras: Bundle? = it.data?.extras
                // RETURN_MESSAGE :  SubActivity 파일에 있는데 사용 가능..
                val returnString = extras?.getString(RETURN_MESSAGE) ?: ""
                binding.editText.setText(returnString)
            }
        }
    }

}