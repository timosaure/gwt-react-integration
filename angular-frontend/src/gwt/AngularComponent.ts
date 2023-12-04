import {bootstrapApplication} from '@angular/platform-browser';
import {AppComponent} from '../app/app.component';
import {ApplicationRef} from "@angular/core";
import {AngularInterface} from "./AngularInterface";


export class AngularComponent {

  private app: ApplicationRef;
  private root: HTMLElement;

  private constructor(app: ApplicationRef, root: HTMLElement) {
    this.root = root
    this.app = app
  }

  static create(element: HTMLElement, api: AngularInterface): Promise<AngularComponent> {
    const root = element.appendChild(document.createElement("app-root"))
    const app = bootstrapApplication(AppComponent, {
      providers: [
        {provide: "test", useValue: api}
      ]
    })

    return app.then(a => new AngularComponent(a, root))
  }

  destroy() {
    this.app.destroy()
    this.root.remove()
  }
}
