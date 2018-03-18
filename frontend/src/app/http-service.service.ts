import { Injectable } from '@angular/core';
import { HttpClient,HttpErrorResponse,HttpHeaders,HttpResponse,HttpParams} from '@angular/common/http';
import 'rxjs/add/operator/map'
@Injectable()
export class HttpServiceService {
  baseUrl='/rcp/mgnt/v0/';
  constructor(private http: HttpClient) { }
  status;
  setStatus(status){
  	this.status=status;
  }

  getStatus(){
  	return this.status;
  }
  getRecipeList(){
   let headers = new HttpHeaders();
   headers.append('Content-Type', 'application/JSON');
   return this.http.get(this.baseUrl+'get',{headers:headers}).map((res: HttpResponse<any>) =>{
       if(res.status === 200){
                    return res;
                }else{
                    return res;
         }
       },
      (err: HttpErrorResponse) => {
        if (err.error instanceof Error) {
          console.log("Client-side error occured.");
        } else {
          console.log("Server-side error occured.");
        }
      }
    );
 }
getRecipeListById(id){
   let headers = new HttpHeaders();
   headers.append('Content-Type', 'application/JSON');
   return this.http.get(this.baseUrl+'get/'+id,{headers:headers}).map((res: HttpResponse<any>) =>{
       if(res.status === 200){
                    return res;
                }else{
                    return res;
         }
       },
      (err: HttpErrorResponse) => {
        if (err.error instanceof Error) {
          console.log("Client-side error occured.");
        } else {
          console.log("Server-side error occured.");
        }
      }
    );
 }
 addRecipe(recipe){
   let headers = new HttpHeaders();
   headers.append('Content-Type', 'application/JSON');
   return this.http.post(this.baseUrl+'save',recipe,{headers:headers}).map((res: HttpResponse<any>) =>{
       if(res.status === 200){
                    return res;
                }else{
                    return res;
         }
       },
      (err: HttpErrorResponse) => {
        if (err.error instanceof Error) {
          console.log("Client-side error occured.");
        } else {
          console.log("Server-side error occured.");
        }
      }
    );
 }
}
