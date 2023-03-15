# SilentSalah

![](app/Images/SalahAppMockup.png)

# Working
An application which turns the Phone state to Silent when Salah time reaches and turn the phone state back to normal when Salah time ends.

# Important NOTE:
1) After Installing the App please Allow the Permissions.

    a)- REQUEST_IGNORE_BATTERY_OPTIMIZATIONS: [Documentation](https://developer.android.com/training/monitoring-device-state/doze-standby "More About Battery Optimization Request").
    
    b)- DnD (Do not Disturb access Permission): [Reference](https://developer.android.com/reference/android/Manifest.permission#ACCESS_NOTIFICATION_POLICY).
  
2) Due to the API 24 Restrictions, the app needs to be locked to avoid the optimization(Force close by System).


# Libraries Used
a) Toggle Buttons: [Link to Library](https://github.com/RiccardoMoro/RMSwitch "Link to the Github page")


# Download Link
[Apk Source File](https://www.dropbox.com/s/m121im40oecshn7/SilentSalah.apk?dl=0)


#Road map
1) Migrate to Kotlin
2) Fix issues 
   a) Does not show notification
   b) Does not change Ringer status
   c) Update date picker and business logic {Working but not good}
3) Update UI
4) Add Salah time automation based on location & date/time
5) Notification Management,
6) Remove Service in favour of WorkManager
7) Separation of concerns



This Application is merely Developed with the intention of Sadqa-e-Jaariyah, So please feel free to contribute and report bugs :)


# LICENSE
This code is licensed under The **GPL-3.0**.

