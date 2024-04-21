import { NgModule } from "@angular/core";
import { OfferComponent } from "./offer.component";
import { FontAwesomeModule } from "@fortawesome/angular-fontawesome";
import { SvgIconComponent, provideAngularSvgIcon } from "angular-svg-icon";
import { HttpClientModule } from "@angular/common/http";

@NgModule({
  declarations: [OfferComponent],
  providers: [provideAngularSvgIcon()],
  imports: [
    HttpClientModule,
    FontAwesomeModule,
    SvgIconComponent,
  ]
})
export default class OfferModule { }
