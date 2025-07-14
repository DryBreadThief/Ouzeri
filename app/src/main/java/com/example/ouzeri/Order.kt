package com.example.ouzeri


data class Order(val table: String,val time: String,var dishes: ArrayList<MenuItem>)

object OrderRepository {
    val orders = mutableListOf<Order>()

    fun getAllOrders(): List<Order> = orders
}