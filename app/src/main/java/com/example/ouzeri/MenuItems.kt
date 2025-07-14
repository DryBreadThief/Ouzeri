package com.example.ouzeri

data class MenuItem(val name: String,val type: String, var quantity: Int = 0)

object MenuRepository {
    val menuItems = mutableListOf(
        MenuItem("ΚΑΛΑΜΑΡΑΚΙΑ","Tiganita"),
        MenuItem("ΓΑΥΡΟΣ","Tiganita"),
        MenuItem("ΣΑΡΔΕΛΑ","Piata"),
        MenuItem("ΠΡΟΣΦΥΓΑΚΙΑ","Tiganita"),
        MenuItem("ΦΑΓΓΡΙ","Psita"),
        MenuItem("ΛΑΥΡΑΚΙ","Psita"),
        MenuItem("ΜΥΛΟΚΟΠΙ","Psita"),
        MenuItem("ΣΟΛΟΜΟΣ","Piata"),
        MenuItem("ΧΤΑΠΟΔΙ","Psita"),
        MenuItem("ΓΑΡΙΔΟΜΑΚΑΡΟΝΑΔΑ","Piata"),
        MenuItem("ΓΑΡΙΔΕΣ ΨΗΤΕΣ","Psita"),
        MenuItem("ΓΑΡΙΔΕΣ ΣΑΓΑΝΑΚΙ","Piata"),
        MenuItem("ΣΥΜΙΑΚΟ","Tiganita"),
        MenuItem("ΜΥΔΙΑ","Piata"),
        MenuItem("ΤΣΙΠΟΥΡΑ","Sxara"),
    )
}