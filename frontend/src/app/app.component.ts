import { Component,OnInit} from '@angular/core';
import { HttpServiceService } from './http-service.service';
import {Router,ActivatedRoute} from '@angular/router';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit  {
  title = 'app';
   selectlist: any;
   constructor(private router:Router, private apiService: HttpServiceService,private _route: ActivatedRoute) { }
     ngOnInit() {
      
       this.apiService.getRecipeList().subscribe(data => {
           this.selectlist = data;
            console.log( this.selectlist);
        });
     }

     onGroupChange(id){
       this.apiService.setStatus(id);
        this.router.navigate(['recipelist/'+id],{ relativeTo: this. _route });
     }
}
