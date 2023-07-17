import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ProductComponent } from './product/product.component';
import { AddBookComponent } from './add-book/add-book.component';
import { EditBookComponent } from './edit-book/edit-book.component';
import { SearchViewComponent } from './search-view/search-view.component';
import { DropdownComponent } from './dropdown/dropdown.component';
import {MatSelectModule} from '@angular/material/select';
import {MatFormFieldModule} from '@angular/material/form-field';
import { CategoryListComponent } from './category-list/category-list.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { UserdashboardComponent } from './userdashboard/userdashboard.component';
import { OrderdeliveryComponent } from './orderdelivery/orderdelivery.component';
import { UpdatedetailsComponent } from './updatedetails/updatedetails.component';
import { CartComponent } from './cart/cart.component';
import { BookhistoryComponent } from './bookhistory/bookhistory.component';
import { AfterHeaderComponent } from './after-header/after-header.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { OrderhistoryComponent } from './orderhistory/orderhistory.component';
import { PaymentsuccessComponent } from './paymentsuccess/paymentsuccess.component';
import { FooterComponent } from './footer/footer.component';
import { AdminComponent } from './admin/admin.component';
import { TotalusersComponent } from './totalusers/totalusers.component';
import { TotalbooksComponent } from './totalbooks/totalbooks.component';
import { AllordersComponent } from './allorders/allorders.component';
import { ToastrModule } from 'ngx-toastr';
import { NotificationDialogComponent } from './notification-dialog/notification-dialog.component';
import { MatDialogModule } from '@angular/material/dialog'


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    ProductComponent,
    AddBookComponent,
    EditBookComponent,
    SearchViewComponent,
    DropdownComponent,
    CategoryListComponent,
    RegisterComponent,
    LoginComponent,
    UserdashboardComponent,
    OrderdeliveryComponent,
    UpdatedetailsComponent,
    CartComponent,
    BookhistoryComponent,
    AfterHeaderComponent,
    AboutUsComponent,
    ContactUsComponent,
    OrderhistoryComponent,
    PaymentsuccessComponent,
    FooterComponent,
    AdminComponent,
    TotalusersComponent,
    TotalbooksComponent,
    AllordersComponent,
    NotificationDialogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    CommonModule,
    MatSelectModule,
    MatFormFieldModule,
    MatCheckboxModule,
    ToastrModule.forRoot(),
    MatDialogModule
   
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
