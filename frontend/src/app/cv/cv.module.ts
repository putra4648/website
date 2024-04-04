import { NgModule } from "@angular/core";
import { PdfViewerModule } from "ng2-pdf-viewer";
import { CvComponent } from "./cv.component";

@NgModule({
  declarations: [
    CvComponent
  ],
  imports: [
    PdfViewerModule
  ]
})
export default class CVModule { }
