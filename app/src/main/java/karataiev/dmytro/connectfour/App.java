/*
 * MIT License
 *
 * Copyright (c) 2016. Dmytro Karataiev
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package karataiev.dmytro.connectfour;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import karataiev.dmytro.connectfour.interfaces.OnGoogleApiChange;
import karataiev.dmytro.connectfour.managers.MultiplayerManager;
import karataiev.dmytro.connectfour.managers.RoomManager;

/**
 * Created by karataev on 4/27/16.
 */
public class App extends Application {

    private static MultiplayerManager sMultiplayerManager;
    private static RoomManager sRoomManager;

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        App.sContext = getApplicationContext();
    }

    public static MultiplayerManager getGoogleApiManager(Activity activity, OnGoogleApiChange listener) {
        if (sMultiplayerManager == null) {
            sMultiplayerManager = new MultiplayerManager();
            sMultiplayerManager.init(activity, listener);
        }
        return sMultiplayerManager;
    }

    public static RoomManager getRoomManager(Activity activity) {
        if (sRoomManager == null) {
            sRoomManager = new RoomManager();
            sRoomManager.init(activity);
        }
        return sRoomManager;
    }

}
