import {createRouter, createWebHistory} from 'vue-router'
import HomeView from '../views/HomeView.vue'
import MainPage from "@/views/MainPage/MainPage";
import ResourceSort from "@/views/ResourceSort/ResourceSort";
import SortByProvince from "@/views/ResourceSort/SortByProvince";
import SortByTheme from "@/views/ResourceSort/SortByTheme";
import SortByType from "@/views/ResourceSort/SortByType";
import Notice from "@/views/Notice/Notice";
import MomentsNotice from "@/views/Notice/MomentsNotice";
import RaiseNotice from "@/views/Notice/RaiseNotice";
import About from "@/views/About";
import Principle from "@/views/Principle";
import KnowledgePicture from "@/views/KnowledgePicture";
import OralMap from "@/views/OralMap";
import OnlineSubmit from "@/views/OnlineSubmit/OnlineSubmit";
import Submit from "@/views/OnlineSubmit/Submit";
import Review from "@/views/OnlineSubmit/Review";

const routes = [
  {
    path: '/',
    name: 'homeView',
    component: HomeView,
    redirect: '/mainPage',
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
      },
      {
        path: '/notice',
        name: 'Notice',
        component: Notice,
        children: [
          {
            path: '/momentsNotice',
            name: 'MomentsNotice',
            component: MomentsNotice,
          },
          {
            path: '/raiseNotice',
            name: 'RaiseNotice',
            component: RaiseNotice,
          }
        ]
      },
      {
        path: '/principle',
        name: 'Principle',
        component: Principle,
      },
      {
        path: '/knowledgePicture',
        name: 'KnowledgePicture',
        component: KnowledgePicture,
      },
      {
        path: '/oralMap',
        name: 'OralMap',
        component: OralMap,
      },
      {
        path: '/onlineSubmit',
        name: 'OnlineSubmit',
        component: OnlineSubmit,
        children: [
          {
            path: '/submit',
            name: 'Submit',
            component: Submit,
          },
          {
            path: '/review',
            name: 'Review',
            component: Review,
          }
        ]
      },
      {
        path: '/about',
        name: 'About',
        component: About,
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
