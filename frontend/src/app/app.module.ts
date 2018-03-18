import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpModule,Http } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import { routing }        from './app.routing';
import { HttpServiceService } from './http-service.service';
import { AppComponent } from './app.component';
import { RecipelistComponent } from './recipelist/recipelist.component';
import { AddrecipeComponent } from './addrecipe/addrecipe.component';


@NgModule({
  declarations: [
    AppComponent,
    RecipelistComponent,
    AddrecipeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing,
    HttpClientModule
  ],
  providers: [HttpServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
