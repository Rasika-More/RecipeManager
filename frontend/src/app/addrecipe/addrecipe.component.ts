import { Component,OnInit} from '@angular/core';
import { HttpServiceService } from '../http-service.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-addrecipe',
  templateUrl: './addrecipe.component.html',
  styleUrls: ['./addrecipe.component.css']
})
export class AddrecipeComponent implements OnInit {
 model: any = {};
  selectlist: any;
  message: any;
  constructor(private router:Router, private apiService: HttpServiceService) { }

  ngOnInit() {
  }
  addRecipe(){
     var body= {
                                    'name':this.model.recipename,
                                    'ingredient_1':this.model.ingredient1,
                                    'ingredient_2':this.model.ingredient2,
                                    'ingredient_3':this.model.ingredient3,
                                    'ingredient_4':this.model.ingredient4

                 }; 
      
       this.apiService.addRecipe(body).subscribe(data => {
           this.apiService.getRecipeList().subscribe(data => {
           this.selectlist = data;
           this.message="Successfully added"
        });
        });
  }

}
