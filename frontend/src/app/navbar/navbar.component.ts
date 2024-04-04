import { Component } from '@angular/core';
import { faGithubSquare, faLinkedin } from '@fortawesome/free-brands-svg-icons';
import { faArrowLeftLong, faEnvelope } from '@fortawesome/free-solid-svg-icons'

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
})
export class NavbarComponent {
  faEmail = faEnvelope;
  faLinkedin = faLinkedin
  faGithub = faGithubSquare
  faArrowLeft = faArrowLeftLong
}
