import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './user/user.component';
import { CreateBookComponent } from './create-book/create-book.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { GetBooksComponent } from './get-books/get-books.component';
import { BuybookComponent } from './buybook/buybook.component';
import { RefundComponent } from './refund/refund.component';
import { SearchbooksComponent } from './searchbooks/searchbooks.component';
import { SearchbooksresComponent } from './searchbooksres/searchbooksres.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { AuthenticateComponent } from './authenticate/authenticate.component';
const routes: Routes = [
{ path: '', component:HeaderComponent},
{ path: 'home', component:HomeComponent},
{ path:'authenticate', component: AuthenticateComponent},
{ path: 'User', component:UserComponent},
{ path:'createbook', component: CreateBookComponent},
{ path:'login', component: LoginComponent},
{ path:'register', component: RegisterComponent},
{ path:'welcome', component: WelcomeComponent},
{ path:'getBooks', component: GetBooksComponent},
{ path:'buybooks', component: BuybookComponent},
{ path:'refund', component: RefundComponent},
{ path:'searchbook', component: SearchbooksComponent},
{ path:'searchbookres', component: SearchbooksresComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
