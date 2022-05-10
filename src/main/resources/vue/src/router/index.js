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
import OralMap from "@/views/OralMap";
import OnlineSubmit from "@/views/OnlineSubmit/OnlineSubmit";
import Submit from "@/views/OnlineSubmit/Submit";
import Review from "@/views/OnlineSubmit/Review";
import AdminHomeView from "@/views/Administrator/AdminHomeView";
import ManageNotice from "@/views/Administrator/ManageNotice";
import ManageResource from "@/views/Administrator/ManageResource";
import ManageRaiseNotice from "@/views/Administrator/ManageRaiseNotice";
import ManageMomentsNotice from "@/views/Administrator/ManageMomentsNotice";
import KnowledgePicture from "@/views/KnowledgePicture/KnowledgePicture";
import ThemeRelative from "@/views/KnowledgePicture/ThemeRelative";
import WechatTypeRelative from "@/views/KnowledgePicture/WechatTypeRelative";
import WebsiteTypeRelative from "@/views/KnowledgePicture/WebsiteTypeRelative";

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
        children: [
          {
            path: '/themeRelative',
            name: 'ThemeRelative',
            component: ThemeRelative,
          },
          {
            path: '/wechatTypeRelative',
            name: 'WechatTypeRelative',
            component: WechatTypeRelative,
          },
          {
            path: '/websiteTypeRelative',
            name: 'WebsiteTypeRelative',
            component: WebsiteTypeRelative,
          }
        ]
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
  },
  {
    path: '/admin',
    name: 'AdminHomeView',
    component: AdminHomeView,
    redirect: '/manageResource',
    children: [
      {
        path: '/manageResource',
        name: 'ManageResource',
        component: ManageResource,
      },
      {
        path: '/manageNotice',
        name: 'ManageNotice',
        component: ManageNotice,
        children: [
          {
            path: '/manageRaiseNotice',
            name: 'ManageRaiseNotice',
            component: ManageRaiseNotice,
          },
          {
            path: '/manageMomentsNotice',
            name: 'ManageMomentsNotice',
            component: ManageMomentsNotice,
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
