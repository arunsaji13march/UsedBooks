import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ProductComponent } from './product/product.component';
import { AddBookComponent } from './add-book/add-book.component';
import { SearchViewComponent } from './search-view/search-view.component';
import { EditBookComponent } from './edit-book/edit-book.component';
import { CategoryListComponent } from './category-list/category-list.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { UserdashboardComponent } from './userdashboard/userdashboard.component';
import { OrderdeliveryComponent } from './orderdelivery/orderdelivery.component';
import { BookhistoryComponent } from './bookhistory/bookhistory.component';
import { CartComponent } from './cart/cart.component';
import { UpdatedetailsComponent } from './updatedetails/updatedetails.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { OrderhistoryComponent } from './orderhistory/orderhistory.component';
import { canactivateGuard } from './guard/canactivate.guard';
import { AboutUsComponent } from './about-us/about-us.component';
import { PaymentsuccessComponent } from './paymentsuccess/paymentsuccess.component';
import { FooterComponent } from './footer/footer.component';
import { AdminComponent } from './admin/admin.component';
import { AllordersComponent } from './allorders/allorders.component';
import { TotalbooksComponent } from './totalbooks/totalbooks.component';
import { TotalusersComponent } from './totalusers/totalusers.component';


const routes: Routes = [
  
  {path:'',redirectTo:"home",pathMatch:"full"},
  {path:'home',component:HomeComponent},
  {path:'product/:bookId',component: ProductComponent},
  {path:'addbook',component: AddBookComponent ,canActivate:[canactivateGuard]},
  {path:'search/:pattern',component: SearchViewComponent},
  {path:'sell',component: AddBookComponent ,canActivate:[canactivateGuard]},
  {path:'category/:category',component: CategoryListComponent },
  {path:'register',component:RegisterComponent},
  {path:'login',component:LoginComponent},
  {path:'userdashboard',component:UserdashboardComponent ,canActivate:[canactivateGuard]},
  {path:'orderdelivery',component:OrderdeliveryComponent ,canActivate:[canactivateGuard]},
  {path:'cart',component:CartComponent ,canActivate:[canactivateGuard]},
  {path:'update',component:UpdatedetailsComponent ,canActivate:[canactivateGuard]},
  {path:'sellhistory',component:BookhistoryComponent ,canActivate:[canactivateGuard]},
  {path:'contactUs',component:ContactUsComponent },
  {path:'aboutUs',component:AboutUsComponent},
  {path:'orderHistory',component:OrderhistoryComponent,canActivate:[canactivateGuard]},
  {path:'paymentSuccess',component:PaymentsuccessComponent,canActivate:[canactivateGuard]},
  {path:'footer',component:FooterComponent},
  {path:'editBook/:bookId',component:EditBookComponent},
  {path:'admin',component:AdminComponent,canActivate:[canactivateGuard]},
  {path:'totalusers',component:TotalusersComponent,canActivate:[canactivateGuard]},
  {path:'allorders',component:AllordersComponent,canActivate:[canactivateGuard]},
  {path:'totalbooks',component:TotalbooksComponent,canActivate:[canactivateGuard]}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
