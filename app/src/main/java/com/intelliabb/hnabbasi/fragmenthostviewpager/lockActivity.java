package com.intelliabb.hnabbasi.fragmenthostviewpager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.intelliabb.hnabbasi.fragmenthostviewpager.Fragments.MyFragment;

import java.util.Random;

public class lockActivity extends Activity implements View.OnClickListener{
    TextView textview;
    String eng,kor,hard,share1,share2;
    Button button;
    int open;
    SeekBar sb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_lock);
        open=0;
        Random rand = new Random();
        int n = rand.nextInt(20); //랜덤 창조

        SharedPreferences pref = getSharedPreferences("pref", 0);
        hard = pref.getString("share01","empty");
        share1 = pref.getString("share02","empty");

        if (hard =="0"){
            n=n+0;
        }
        else if(hard == "1") {//고등
            n=n+20;
        }
        else if(hard == "2"){//수능
            n=n+40;
        }
        else if(hard == "3"){//토익
            n=n+60;
        }

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        Random r = new Random();
        Random j = new Random();
        int x = r.nextInt(500)+1;
        int y = j.nextInt(800)+50;
        button.setX(x);
        button.setY(y);

        textview = (TextView)findViewById(R.id.textView2);
        //textview2 = (TextView)findViewById(R.id.textView3);
        switch(n) {
            case 0:
                eng="ability";
                kor="능력";
                break;
            case 1:
                eng="amaze";
                kor="놀라게 하다";
            break;
            case 2:
                eng="board";
                kor="판자, 뱃전";
            break;
            case 3:
                eng="cake";
                kor="과자, 케잌";
            break;
            case 4:
                eng="couple";
                kor="한 쌍, 두 개, 부부";
            break;
            case 5:
                eng="dangerous";
                kor="위험한";
            break;
            case 6:
                eng="dictation";
                kor="구술, 받아쓰기";
            break;
            case 7:
                eng="environment";
                kor="환경";
            break;
            case 8:
                eng="greeting";
                kor="인사";
            break;
            case 9:
                eng="gym";
                kor="체육관";
            break;
            case 10:
                eng="identity  ";
                kor="신원";
            break;
            case 11:
                eng="independent";
                kor="독립의, 독자적인";
            break;
            case 12:
                eng="jacket";
                kor="자켓, 짧은 웃옷";
            break;
            case 13:
                eng="laboratory";
                kor="실험실, 실습실";
            break;
            case 14:
                eng="line";
                kor="선, 열, 줄";
            break;
            case 15:
                eng="pear";
                kor="배";
            break;
            case 16:
                eng="painter";
                kor="화가";
            break;
            case 17:
                eng="social";
                kor="사회의, 사회적인";
            break;
            case 18:
                eng="system";
                kor="조직, 체계, 제도, 방식";
            break;
            case 19:
                eng="whisper";
                kor="속삭이다, 속삭임";
            break;
            case 20:
                eng="remind";
                kor="상기시키다";
            break;
            case 21:
                eng="phonemenon";
                kor="현상";
            break;
            case 22:
                eng="tune";
                kor="맞추다";
            break;
            case 23:
                eng="meanwhile";
                kor="그러는동안";
            break;
            case 24:
                eng="decorate";
                kor="꾸미다, 장식하다";
            break;
            case 25:
                eng="import";
                kor="수입하다";
            break;
            case 26:
                eng="costume";
                kor="의상";
            break;
            case 27:
                eng="stream";
                kor="강, 흐름";
            break;
            case 28:
                eng="merge";
                kor="합병";
            break;
            case 29:
                eng="interaction";
                kor="상호작용";
            break;
            case 30:
                eng="anazing";
                kor="놀라운";
            break;
            case 31:
                eng="transtormation";
                kor="변형";
            break;
            case 32:
                eng="blossom";
                kor="꽃";
            break;
            case 33:
                eng="stem";
                kor="줄기";
            break;
            case 34:
                eng="shade";
                kor="색조";
            break;
            case 35:
                eng="official";
                kor="공식적인";
            break;
            case 36:
                eng="mainly";
                kor="주로";
            break;
            case 37:
                eng="conference";
                kor="회의";
            break;
            case 38:
                eng="vehicle";
                kor="탈것";
            break;
            case 39:
                eng="visible";
                kor="명백한";
            break;
            case 40: //수능
                eng="resident";
                kor="주민";
                break;
            case 41:
                eng="remind";
                kor="상기시키다";
                break;
            case 42:
                eng="improve";
                kor="개선되다";
            case 43:
                eng="illegal";
                kor="불법적인";
                break;
            case 44:
                eng="sidewalk";
                kor="인도,보도";
            break;
            case 45:
                eng="available";
                kor="이용가능한";
            break;
            case 46:
                eng="pedestrian";
                kor="보행자";
            break;
            case 47:
                eng="adjacent";
                kor="인접한";
            break;
            case 48:
                eng="motorist";
                kor="운전자";
            break;
            case 49:
                eng="honor";
                kor="지키다,이행하다";
            break;
            case 50:
                eng="fine";
                kor="벌금";
            break;
            case 51:
                eng="priority";
                kor="우선순위";
            break;
            case 52:
                eng="charge";
                kor="청구하다";
                break;
            case 53:
                eng="unique";
                kor="특색있는";
            break;
            case 54:
                eng="passion";
                kor="열정";
            break;
            case 55:
                eng="annual";
                kor="매년의";
            break;
            case 56:
                eng="device";
                kor="기기,장치";
            break;
            case 57:
                eng="sensitive";
                kor="민감한";
            break;
            case 58:
                eng="log";
                kor="기록,일지";
            break;
            case 59:
                eng="wipe";
                kor="지우다,닦다";
            break;
            case 60:  //토익단어
                eng="store";
                kor="저장하다";
            break;
            case 61:
                eng="socialize";
                kor="사회화하다";
            break;
            case 62:
                eng="explanation";
                kor="설명";
            break;
            case 63:
                eng="inheritance";
                kor="유전,유산";
            break;
            case 64:
                eng="reinforce";
                kor="강화시키다";
            break;
            case 65:
                eng="educational";
                kor="교육적인";
            break;
            case 67:
                eng="innately";
                kor="본래,선천적으로";
            break;
            case 68:
                eng="babarian";
                kor="야만인";
            break;
            case 69:
                eng="appointment";
                kor="약속";
            break;
            case 70:
                eng="proper";
                kor="적당한";
            break;
            case 71:
                eng="demonstration";
                kor="표시,지위,전시";
            break;
            case 72:
                eng="conversation";
                kor="대화";
            break;
            case 73:
                eng="honorable";
                kor="존경할만한";
            break;
            case 74:
                eng="originality";
                kor="독창성";
            break;
            case 75:
                eng="customary";
                kor="습관적인,통상적인";
            break;
            case 76:
                eng="prudent";
                kor="신중한,사려깊은";
            break;
            case 77:
                eng="gradually";
                kor="점차로";
            break;
            case 78:
                eng="universl";
                kor="우주의,보편적인";
            break;
            case 79:
                eng="various";
                kor="다양한";
            break;
            case 80:
                eng="babysitting";
                kor="아기 보기";
            break;

            default:
                textview.setText("region");
                button.setText("지역,군단");
                break;
        }

        textview.setText(eng+" ");
        button.setText(kor);
    }

    @Override
    public void onClick(View view) {
        SharedPreferences pref = getSharedPreferences("pref", 0);
        share2 = pref.getString("share03","empty");
        if(share2 != "0"){
            open=2;
        }

        if(open==0){
            Random r = new Random();
            Random j = new Random();
            int x = r.nextInt(500)+1;
            int y = j.nextInt(800)+50;
            button.setX(x);
            button.setY(y);
            open=1;
            button.setText(eng);
        }
        else if(open==1){
            Random r = new Random();
            Random j = new Random();
            int x = r.nextInt(500)+1;
            int y = j.nextInt(800)+50;
            button.setX(x);
            button.setY(y);
            open=2;
            button.setText(kor);
        }
        else if(open ==2) {
            Toast.makeText(lockActivity.this, eng + "는 " + kor + "입니다", Toast.LENGTH_LONG).show();
            open=0;
            this.finish();
/*
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
            mBuilder.setSmallIcon(R.drawable.treeicon);
            mBuilder.setContentTitle(eng);
            mBuilder.setContentText(kor);
*/
            if(share1=="0") {
                scheduleNotification(getNotification(kor), 3000);
            }
/*
            Intent resultIntent = new Intent(this, lockActivity.class);
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
                // Adds the back stack for the Intent (but not the Intent itself)
            stackBuilder.addParentStack(lockActivity.class);
                // Adds the Intent that starts the Activity to the top of the stack
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
            mBuilder.setContentIntent(resultPendingIntent);
            NotificationManager mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                // mId allows you to update the notification later on.
            mNotificationManager.notify(1,mBuilder.build());
            */
        }
    }

    private void scheduleNotification(Notification notification, int delay) {

        Intent notificationIntent = new Intent(this, NotificationPublisher.class);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION_ID, 1);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION, notification);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        long futureInMillis = SystemClock.elapsedRealtime() + delay;
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent);
    }

    private Notification getNotification(String content) {
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle(eng);
        builder.setContentText(content);
        builder.setSmallIcon(R.drawable.treeicon);
        return builder.build();
    }
}
