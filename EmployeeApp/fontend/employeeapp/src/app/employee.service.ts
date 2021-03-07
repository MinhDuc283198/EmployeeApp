import { Injectable } from '@angular/core';
import{HttpClient} from "@angular/common/http"
import { Observable } from 'rxjs';

import { environment } from 'src/environments/environment';
import { Employee } from './employee';
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private apiServerUrl=environment.apiBaseUrl;
  constructor(private http:HttpClient) { }
  public getEmployees():Observable<Employee[]>{
     return this.http.get<Employee[]>(`${this.apiServerUrl}/`);
  }
  public addEmployees(employee:Employee):Observable<Employee>{
    return this.http.post<Employee>(`${this.apiServerUrl}/save`,employee);
 }
 public updateEmployees(employee:Employee):Observable<Employee>{
  return this.http.put<Employee>(`${this.apiServerUrl}/update`,employee);
 }
//  public deleteEmployees(employeeId:number):Observable<void>{
//    return this.http.delete<void>(`${this.apiServerUrl}/delete/${employeeId}`);
//  }
 public deleteEmployees(employeeId: number): Observable<void> {
  return this.http.delete<void>(`${this.apiServerUrl}/delete/${employeeId}`);
}
}
