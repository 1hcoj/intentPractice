package com.hyeon.midtermtest

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.hyeon.midtermtest.databinding.ActivitySubBinding

const val EXTRA_MESSAGE = "com.hyeon.midtermtest.EXTRA_MESSAGE"
const val RETURN_MESSAGE = "com.hyeon.midtermtest.RETURN_MESSAGE"
class SubActivity : AppCompatActivity() {
    lateinit var binding : ActivitySubBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val str = binding.editText.text.toString()
            val data = Intent()
            // intent 객체에 data 추가
            data.putExtra(RETURN_MESSAGE, str)
            // 호출 Activity 에 보낼 결과 코드와 Intent () 결과 전송
            // Intent 는 Messaging system 이다 ( 정보를 가지고 있음 )
            // setResult -> intent 를 전송하지 않고 resultCode 만 전송할 수도 있음..
            setResult(Activity.RESULT_OK,data)
            // 뒤로 가기
            onBackPressed()
        }
    }


}