import { Routes, RouterModule } from '@angular/router';
import { ModuleWithProviders} from '@angular/core';
import { RecipelistComponent } from './recipelist/recipelist.component';
import { AddrecipeComponent } from './addrecipe/addrecipe.component';
import { AppComponent } from './app.component';
const appRoutes: Routes = [
    { path: 'home', component: RecipelistComponent ,
     children: [
        
     ]
    
   },
    { path:'addrecipe',component: AddrecipeComponent},
    { path:'recipelist/:id',component: RecipelistComponent},
    { path: '**', redirectTo: 'home' }
];

export const routing = RouterModule.forRoot(appRoutes,{useHash: true});