package de.sdp.appcenterdemo

class BusinessLogic {
    var ok = true

    fun complicatedFunction() : Int {
        ok = !ok
        return if(ok) 42 else -1
    }
}