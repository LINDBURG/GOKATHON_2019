package com.example.gokathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import javax.mail.MessagingException;
import javax.mail.SendFailedException;

public class AuthActivity extends AppCompatActivity {

    private TextView textView = null;
    private TextView message = null;
    private Button button = null;
    private Button authButton = null;
    private String code = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .permitDiskReads()
                .permitDiskWrites()
                .permitNetwork().build());


        textView = (TextView) findViewById(R.id.u_mail); //받는 사람의 이메일
        message = (TextView) findViewById(R.id.message); //본문 내용

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    GmailSender gMailSender = new GmailSender("AnamDobby@gmail.com", "gokathon");
                    //GMailSender.sendMail(제목, 본문내용, 받는사람);
                    code = gMailSender.getEmailCode();
                    String mailMessage = "안녕하세요. 안암도비입니다.\n" +
                            "저희 안암도비는 고려대학교 학생들을 대상으로 하는 서비스입니다.\n" +
                            "저희 서비스를 이용하기 위해서는 학교인증을 해야합니다.\n\n" +
                            "코드 : " + code +
                            "\n\n해당 코드를 입력하여 학교인증을 완료해주세요.\n" +
                            "" +
                            "감사합니다.\n" +
                            "-안암도비-";
                    gMailSender.sendMail("안암도비 인증메일 입니다", mailMessage, textView.getText().toString() + "@naver.com");
                    //테스트 편의상 naver메일로 보내는데 추후에 korea.ac.kr메일로 변경 예정
                    Toast.makeText(getApplicationContext(), "이메일을 성공적으로 보냈습니다.", Toast.LENGTH_SHORT).show();
                } catch (SendFailedException e) {
                    Toast.makeText(getApplicationContext(), "이메일 형식이 잘못되었습니다.", Toast.LENGTH_SHORT).show();
                } catch (MessagingException e) {
                    Toast.makeText(getApplicationContext(), "인터넷 연결을 확인해주십시오", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "모두다 확인해주십시오", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

        authButton = (Button) findViewById(R.id.button2);
        authButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(message.getText().toString().equals(code)) {
                    Intent homeIntent = new Intent(AuthActivity.this, HomeActivity.class);
                    startActivity(homeIntent);
                } else {
                    Toast.makeText(getApplicationContext(), "인증코드를 다시 확인해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button skipButton = (Button) findViewById(R.id.button3);
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(AuthActivity.this, HomeActivity.class);
                startActivity(homeIntent);
            }
        });
    }
}