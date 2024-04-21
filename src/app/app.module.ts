import { NgModule } from "@angular/core";
import { AppComponent } from "./app.component";
import { BrowserModule } from "@angular/platform-browser";
import AppRoutingModule from "./app-routing.module";
import { NavbarModule } from "./navbar/navbar.module";
import HomeModule from "./home/home.module";
import CVModule from "./cv/cv.module";
import OfferModule from "./offer/offer.module";

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NavbarModule,
    HomeModule,
    CVModule,
    OfferModule,
  ],
  bootstrap: [AppComponent]
})
export default class AppModule {

}
