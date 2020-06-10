import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddTheaterComponent } from './add-theater/add-theater.component';
import { HeaderComponent } from './header/header.component';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { AddMovieComponent } from './add-movie/add-movie.component';
import { AddScreenComponent } from './add-screen/add-screen.component';
import { AddShowComponent } from './add-show/add-show.component';
import { GetAllTheatersComponent } from './get-all-theaters/get-all-theaters.component';
import { GetAllMoviesComponent } from './get-all-movies/get-all-movies.component';
import { GetAllScreensComponent } from './get-all-screens/get-all-screens.component';
import { GetAllShowsComponent } from './get-all-shows/get-all-shows.component';
import { UpdateTheaterComponent } from './update-theater/update-theater.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { SearchTheaterComponent } from './search-theater/search-theater.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { AuthGuard } from './auth.guard';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    AddTheaterComponent,
    HeaderComponent,
    AddMovieComponent,
    AddScreenComponent,
    AddShowComponent,
    GetAllTheatersComponent,
    GetAllMoviesComponent,
    GetAllScreensComponent,
    GetAllShowsComponent,
    UpdateTheaterComponent,
    SignInComponent,
    SearchTheaterComponent,
    PagenotfoundComponent,
    FooterComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      {path:'addTheater', component:AddTheaterComponent,
      canActivate: [AuthGuard], data: {
        expectedRoles: ['Dilip']
      }},
      {path:'addMovie', component:AddMovieComponent,
      canActivate: [AuthGuard], data: {
        expectedRoles: ['Dilip']}},
      {path:'addScreen', component:AddScreenComponent,
      canActivate: [AuthGuard], data: {
        expectedRoles: ['Dilip']}},
      {path:'addShow', component:AddShowComponent,
      canActivate: [AuthGuard], data: {
        expectedRoles: ['Dilip']}},
      {path:'getAllTheaters', component:GetAllTheatersComponent,
      canActivate: [AuthGuard], data: {
        expectedRoles: ['Dilip']}},
      {path:'getAllMovies', component:GetAllMoviesComponent,
      canActivate: [AuthGuard], data: {
        expectedRoles: ['Dilip']}},
      {path:'getAllScreens', component:GetAllScreensComponent,
      canActivate: [AuthGuard], data: {
        expectedRoles: ['Dilip']}},
      {path:'getAllShows', component:GetAllShowsComponent,
      canActivate: [AuthGuard], data: {
        expectedRoles: ['Dilip']}},
      {path:'update-theater/:id', component:UpdateTheaterComponent,
      canActivate: [AuthGuard], data: {
        expectedRoles: ['Dilip']}},
      {path:'signIn', component:SignInComponent},
      {path:'searchTheater',component:SearchTheaterComponent,
      canActivate: [AuthGuard], data: {
        expectedRoles: ['Dilip']}},
        {path:'',component:HomeComponent},
      { path: '**', component: PagenotfoundComponent }
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
