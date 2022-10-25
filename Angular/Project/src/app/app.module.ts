import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule ,ReactiveFormsModule} from '@angular/forms';

import { UserComponent } from './user/user.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { CreateBookComponent } from './create-book/create-book.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { GetBooksComponent } from './get-books/get-books.component';
import { AuthenticateComponent } from './authenticate/authenticate.component';
import { BuybookComponent } from './buybook/buybook.component';
import { RefundComponent } from './refund/refund.component';
import { SearchbooksComponent } from './searchbooks/searchbooks.component';
import { SearchbooksresComponent } from './searchbooksres/searchbooksres.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';


@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    WelcomeComponent,
    CreateBookComponent,
    LoginComponent,
    RegisterComponent,
    GetBooksComponent,
    AuthenticateComponent,
    BuybookComponent,
    RefundComponent,
    SearchbooksComponent,
    SearchbooksresComponent,
    HeaderComponent,
    HomeComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
