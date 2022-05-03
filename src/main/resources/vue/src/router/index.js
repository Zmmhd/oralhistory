import {createRouter, createWebHistory} from 'vue-router'
import HomeView from '../views/HomeView.vue'
import MainPage from "@/views/MainPage/MainPage";
import ResourceSort from "@/views/ResourceSort/ResourceSort";
import SortByProvince from "@/views/ResourceSort/SortByProvince";
import SortByTheme from "@/views/ResourceSort/SortByTheme";
import SortByType from "@/views/ResourceSort/SortByType";

const routes = [
  {
    path: '/',
    name: 'homeView',
    component: HomeView,
    // redirect: '/mainPage',
    children: [
      {
        path: '/mainPage',
        name: 'MainPage',
        component: MainPage,
      },
      {
        path: '/resourceSort',
        name: 'ResourceSort',
        component: ResourceSort,
        children: [
          {
            path: '/sortByProvince',
            name: 'SortByProvince',
            component: SortByProvince,
          },
          {
            path: '/sortByTheme',
            name: 'SortByTheme',
            component: SortByTheme,
          },
          {
            path: '/sortByType',
            name: 'SortByType',
            component: SortByType,
          }
        ]
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
