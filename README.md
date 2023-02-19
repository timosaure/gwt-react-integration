# GWT <--> React Integration example

GWT is a technology that even though still widely used in the enterprise space has passed its prime. The community and
ecosystem have fallen behind the modern, widespread Javascript technologies like React, Vue, etc. Still for large
enterprise systems it can pose a significant challenge to migrate away from GWT. Replacing a whole application at once
is an often impossible task and choosing an approach like
the [Strangler Fig pattern](https://learn.microsoft.com/en-us/azure/architecture/patterns/strangler-fig) is better
suited. This example should illustrate how to use a modern web technology like React together with GWT, allowing a
gradual replacement of the application with React code. The key part is the exchange of state between the two
technologies.

React was chosen for this example but any other similar technology like Vue should work the same way.

The example only highlights the integration between the two technologies using JsInterop on GWT side. The build and
packaging
are not configured.

## Usage

**Running the React Dev server**

Navigate to [](react-frontend/src/main/react) and run:

```bash
npm install
npm run serve
```

**Running the GWT Dev server**

Navigate to [](gwt-frontend) and run:

```bash
mvn gwt:devmode
```

## License

[MIT](LICENSE)