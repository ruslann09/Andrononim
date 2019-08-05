package com.android.anonim.andrononim;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.VpnService;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.anonim.andrononim.activities.ToyVpnClient;
import com.android.anonim.andrononim.services.ToyVpnService;
import com.android.anonim.andrononim.utils.ToyVpnConnection;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_PERMISSION_BIND_VPN_SERVICE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.BIND_VPN_SERVICE) != PackageManager.PERMISSION_GRANTED) {
            // показываем Activity для запроса прав у пользователя
            Intent intent = VpnService.prepare(MainActivity.this);
            startActivityForResult(intent, REQUEST_CODE_PERMISSION_BIND_VPN_SERVICE); // запрос прав
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_PERMISSION_BIND_VPN_SERVICE && resultCode == RESULT_OK) {
//            VpnService.Builder vpnBuilder = new VpnService.Builder();
//            vpnBuilder.addAddress("91.189.181.22", 0);
//            vpnBuilder.addRoute("0.0.0.0", 0);
//            ParcelFileDescriptor parcelFileDescriptor = vpnBuilder.establish();
//            FileInputStream in = new FileInputStream(parcelFileDescriptor.getFileDescriptor());
//            FileOutputStream out = new FileOutputStream(parcelFileDescriptor.getFileDescriptor());

//            startService(new Intent(getApplicationContext(), ToyVpnService.class));

            startActivity(new Intent(getApplicationContext(), ToyVpnClient.class));
        }
    }
}
