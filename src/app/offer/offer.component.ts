import { Component } from '@angular/core';
import { faReact, faAngular, faJava, faHtml5, faCss3, faJs, faGit, faDocker } from '@fortawesome/free-brands-svg-icons'

@Component({
  selector: 'app-offer',
  templateUrl: './offer.component.html',
  styleUrl: './offer.component.scss'
})
export class OfferComponent {
  faReact = faReact
  faAngular = faAngular
  faJava = faJava
  faSpring = "assets/springboot.svg"
  faFastify = "assets/fastify.svg"
  faFlutter = "assets/flutter.svg"
  faNeovim = "assets/neovim.svg"
  faVSCode = "assets/vscode.svg"
  faMongoDB = "assets/mongodb.svg"
  faMySQL = "assets/mysql.svg"
  faTypescript = "assets/typescript.svg"
  faOracle = "assets/oracle.svg"
  faDart = "assets/dart.svg"
  faPostman = "assets/postman.svg"
  faHTML = faHtml5
  faCSS = faCss3
  faJS = faJs
  faGit = faGit
  faDocker = faDocker
}
