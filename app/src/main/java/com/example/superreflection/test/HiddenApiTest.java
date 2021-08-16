package com.example.superreflection.test;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import com.example.superreflection.MainActivity;

import java.lang.reflect.Method;

public class HiddenApiTest {
    private static final String TAG = "HiddenApiTest";
    public static void main(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P
                || (Build.VERSION.SDK_INT == Build.VERSION_CODES.O_MR1 && Build.VERSION.PREVIEW_SDK_INT > 0)) {
            try {
                Class runtimeClass = Class.forName("dalvik.system.VMRuntime");
                Method nativeLoadMethod = runtimeClass.getDeclaredMethod("setTargetSdkVersionNative",
                        new Class[] {int.class});

                Log.d("whulzz", "setTargetSdkVersionNative success!");
                Toast.makeText(context,
                        "HiddenApiTest success",
                        Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        } else {
            Log.d(TAG, "nothing todo");
            Toast.makeText(context,
                    "HiddenApiTest nothing todo",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
