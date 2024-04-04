import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ProjectComponent } from './project/project.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { OfferComponent } from './offer/offer.component';
import { CvComponent } from './cv/cv.component';

const routes: Routes = [
  {
    path: "",
    pathMatch: 'full',
    redirectTo: "home",
  },
  {
    path: 'home',
    component: HomeComponent,
  },
  {
    path: 'offer',
    component: OfferComponent,
  },
  {
    path: 'project',
    component: ProjectComponent,
  },
  {
    path: 'cv',
    component: CvComponent
  },
  {
    path: '**',
    component: NotFoundComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export default class AppRoutingModule { }
