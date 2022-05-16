package com.example.kotlin_jetpack.ui.log

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_jetpack.R
import com.example.kotlin_jetpack.databinding.ActivityLoginBinding
import com.example.kotlin_jetpack.databinding.ActivityPlayMusicBinding
import com.example.kotlin_jetpack.ui.MainActivity_home
import com.example.kotlin_jetpack.ui.PlayMusicActivityModel
import com.example.kotlin_jetpack.ui.Unit.visibleAlphaAnimation



class Login : AppCompatActivity() {
    var phone:Long=0
    private lateinit var _binding: ActivityLoginBinding
    val binding: ActivityLoginBinding
        get() = _binding
    private val viewhodel by lazy {
        ViewModelProvider(this).get(LoginViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getcode()
        yzcode()
    }

    private fun yzcode() {
        binding.apply {
            logBt.setOnClickListener {


                val s1:String=pinEntryEditText.text.toString()
                println(s1.toInt())
                if(s1.isEmpty()){
                    Toast.makeText(this@Login,"请输入验证码",Toast.LENGTH_LONG).show()
                }else{
                    viewhodel.apply {
                        login.observe(this@Login, Observer {
                            if(it.code==200){
                                Log.d("log",it.cookie)
                                val editor=getSharedPreferences("token", Context.MODE_PRIVATE).edit()
                                editor.putString("cookie",it.cookie)
                                editor.apply()

                                val intent=Intent(this@Login,MainActivity_home::class.java)
                                startActivity(intent)
                            }else{
                                Toast.makeText(this@Login,"错误",Toast.LENGTH_LONG).show()
                            }
                        })
                    }.getlog(phone,s1.toInt())
                }

            }
        }
    }

    private fun getcode() {
        if(binding.editTextPhone.text.toString().equals(null)){
            binding.button5.isEnabled=false
            binding.button5.setBackgroundResource(R.drawable.log_bt)


        }else{
            binding.button5.isEnabled=true
            binding.button5.setBackgroundResource(R.drawable.top_button_shap)
            binding.button5.setOnClickListener {

                val s1  = binding.editTextPhone.text.toString()

                val number=s1.toLong()
                print(number)

                viewhodel.apply {
                     getcode.observe(this@Login, Observer {

                         if(it.code==200){
                             Toast.makeText(this@Login,"发送成功~请查看",Toast.LENGTH_LONG).show()
                             phone=number
                             binding.pinEntryEditText.visibleAlphaAnimation()
                             binding.logBt.visibleAlphaAnimation()
                         }else{
                             Toast.makeText(this@Login,"手机号错误~",Toast.LENGTH_LONG).show()
                         }
                     })
                }.code(number)
            }
        }


    }
}