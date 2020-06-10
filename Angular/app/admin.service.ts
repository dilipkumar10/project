import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NgForm } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  api = `http://localhost:8080`;
  theater: Theater[];
  screen: Screen[];
  movie: Movie[]; 
  constructor(private http: HttpClient) { }

  addTheater(theater): Observable<any> {
    return this.http.post<any>(`${this.api}/add-theater`, theater);
  }

  addMovie(movie): Observable<any> {
    return this.http.post<any>(`${this.api}/add-movie`, movie);
  }

  addScreen(screen): Observable<any> {
    return this.http.post<any>(`${this.api}/add-screen`, screen);
  }

  addShow(show): Observable<any> {
    console.log('show');
    return this.http.post<any>(`${this.api}/add-show`, show);
  }

  getAllTheaters(): Observable<any> {
    return this.http.get<any>(`${this.api}/get-all-theaters`);
  }

  getAllMovies(): Observable<any> {
    return this.http.get<any>(`${this.api}/get-all-movies`);
  }

  getAllScreens(): Observable<any> {
    return this.http.get<any>(`${this.api}/get-all-screens`);
  }

  getAllShows(): Observable<any> {
    return this.http.get<any>(`${this.api}/get-all-shows`);
  }

  deleteTheater(theater: Theater): Observable<any> {
    return this.http.delete<any>(`${this.api}/delete-theater/${theater.theaterId}`);
  }

  deleteScreen(screen: Screen): Observable<any> {
    return this.http.delete<any>(`${this.api}/delete-screen/${screen.screenId}`);
  }

  deleteMovie(movie: Movie): Observable<any> {
    return this.http.delete<any>(`${this.api}/delete-movie/${movie.movieId}`);
  }

  updateTheater(theater: Theater): Observable<any> {
    return this.http.put<any>(`${this.api}/update-theater`, theater)
  }

  adminUser(credintials): Observable<any> {
    console.log(credintials);
    return this.http.post<any>(`${this.api}/login-user`, credintials);
  }

  searchTheater(theater): Observable<any> {
    return this.http.get<any>(`${this.api}/get-theater/${theater.theaterId}`);
  }
}
