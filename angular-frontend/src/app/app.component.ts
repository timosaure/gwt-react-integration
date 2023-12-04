import {Component, Injector} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AngularInterface} from "../gwt/AngularInterface";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title: string;
  api: AngularInterface;

  constructor(injector: Injector) {
    this.api = injector.get("test") as AngularInterface
    this.title = this.api.title()
  }

  clicked() {
    console.log("clicked!")
    this.api.alertGwt("Sent from Angular!")
  }
}
