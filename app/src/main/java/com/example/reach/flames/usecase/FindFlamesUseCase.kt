package com.example.reach.flames.usecase

interface FindFlamesUseCase {
    fun execute(nameOne: String, nameTwo: String): String
}

class FindFlamesUseCaseImpl : FindFlamesUseCase {
    override fun execute(nameOne: String, nameTwo: String): String {

        /*converting to char array*/
        /*converting to char array*/
        val name1char: CharArray = nameOne.toCharArray()
        val name2char: CharArray = nameTwo.toCharArray()


        /*finding the length*/
        val a: Int = nameOne.length
        val b: Int = nameTwo.length
        var combinedNamesLength = a + b

        /*eliminating the common letters*/


        /*eliminating the common letters*/for (i in 0 until a) {
            for (j in 0 until b) {
                if (name1char[i] == name2char[j]) {
                    name1char[i] = ' '
                    name2char[j] = ' '
                    combinedNamesLength -= 2
                    break
                }
            }
        }


        val flames = "flames"
        var flamesString = StringBuilder(flames)
        var flameResult = 0.toChar()

        while (flamesString.length != 1) {
            val y = combinedNamesLength % flamesString.length
            var temp: String? = if (y != 0) {
                flamesString.substring(y) + flamesString.substring(0, y - 1)
                // taking substring (counting purpose)
            } else {
                flamesString.substring(
                    0,
                    flamesString.length - 1
                ) // taking substring (counting purpose)
            }
            flamesString = StringBuilder(temp)
            flameResult = flamesString[0]
        }
        return flameResult.toString()

    }

}