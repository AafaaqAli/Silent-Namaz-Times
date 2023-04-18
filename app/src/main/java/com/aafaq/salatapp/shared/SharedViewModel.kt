package com.aafaq.salatapp.shared

import androidx.lifecycle.ViewModel
import com.aafaq.salatapp.utils.deligations.location.ILocationHelper
import com.aafaq.salatapp.utils.deligations.location.LocationHelperImp

class SharedViewModel: ViewModel(), ILocationHelper by LocationHelperImp() {

}