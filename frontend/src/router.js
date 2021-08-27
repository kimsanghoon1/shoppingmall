
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManager from "./components/OrderManager"

import ProductManager from "./components/ProductManager"

import InventoryManager from "./components/InventoryManager"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },

            {
                path: '/products',
                name: 'ProductManager',
                component: ProductManager
            },

            {
                path: '/inventories',
                name: 'InventoryManager',
                component: InventoryManager
            },



    ]
})
