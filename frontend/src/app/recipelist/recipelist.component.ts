import { Component,OnInit} from '@angular/core';
import { HttpServiceService } from '../http-service.service';
import {Router,ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-recipelist',
  templateUrl: './recipelist.component.html',
  styleUrls: ['./recipelist.component.css']
})
export class RecipelistComponent implements OnInit {
selectlist:any;
 private sub: any;     
 private token: string;
  constructor(private router:Router, private apiService: HttpServiceService,private route: ActivatedRoute,) {
    
   }

  ngOnInit() {
     this.sub = this.route.params.subscribe(params => {
        this.token = params['id']; 
       this.apiService.getRecipeListById(this.token).subscribe(data => {
           this.selectlist = data;
    });
      });
  }
}
