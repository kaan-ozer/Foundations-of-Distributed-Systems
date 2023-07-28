import Vue from 'vue'
import {store} from "@/store/store";
import '@fortawesome/fontawesome-free/css/all.css'
import '@fortawesome/fontawesome-free/js/all.js'
import 'bootstrap/dist/css/bootstrap.min.css';


import 'bootstrap/dist/js/bootstrap.bundle.min.js';

import App from "@/App";


Vue.config.productionTip = false

new Vue({
    store,
    render: h => h(App),
}).$mount('#app')
