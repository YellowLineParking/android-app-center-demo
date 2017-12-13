package de.sdp.appcenterdemo

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class BusinessLogicTest {
    lateinit var logic : BusinessLogic

    @Before
    fun init() { logic = BusinessLogic() }

    @Test
    fun complicatedFunctionTest() {
        assertEquals(-1, logic.complicatedFunction())
        assertEquals(42, logic.complicatedFunction())
        assertEquals(-1, logic.complicatedFunction())
        assertEquals(42, logic.complicatedFunction())
    }
}
