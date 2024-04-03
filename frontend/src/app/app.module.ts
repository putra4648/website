import { NgModule } from "@angular/core";
import { AppComponent } from "./app.component";
import { BrowserModule } from "@angular/platform-browser";
import AppRoutingModule from "./app-routing.module";
import { NavbarModule } from "./navbar/navbar.module";

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NavbarModule
  ],
  bootstrap: [AppComponent]
})
export default class AppModule {

}
