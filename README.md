# MAXX Energy

**MAXX-Energy** is a collaborative monorepo housing both the company’s public-facing **About Page** and the backend **SolarData** Java service, as well as more later on. This structure enables streamlined development for our website content and supporting API under one unified repository. The `about-page` folder contains the static site files, while `solardata` includes the Java-based application that powers data handling and integrations. By keeping these projects together, we simplify version control, improve team collaboration, and make it easier to maintain consistent updates across the entire MAXX-Energy platform.

---

## Getting Started

```bash
git clone https://github.com/frederickdlanejr/MAXX-Energy.git
cd MAXX-Energy
```

**about-page:** Open `index.html` in a browser or run:

```bash
cd about-page && python -m http.server 8080
```

**solardata:**
Maven:

```bash
cd solardata && mvn spring-boot:run
```

Gradle:

```bash
cd solardata && ./gradlew bootRun
```

---

## Updating Subtrees

**About Page:**

```bash
git fetch about && git subtree pull --prefix=about-page about main
```

**SolarData:**

```bash
git fetch solardata && git subtree pull --prefix=solardata solardata main
```

---

## Contributing

1. Create a branch: `git checkout -b feature-name`
2. Make changes, commit, push
3. Open a PR for review

---

## License

MIT License – see LICENSE file.

---

> Tip: Add a badges row (build status, license, last commit) to make the repo top section more professional on GitHub.
