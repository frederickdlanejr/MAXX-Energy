# 🌞 MAXX Energy Website! 💡

**MAXX-Energy** is a collaborative monorepo housing both the company’s public-facing **About Page** 🌐 and the backend **SolarData** ☀️ Java service. This setup makes teamwork smooth, keeps everything in one happy home for us 🏡, and ensures updates across the whole platform stay in sync and readily avaliable ✨.

📂 **about-page/** – Static site files for the company “About” content
📂 **solardata/** – Java-based application for data handling and integrations

---

## 🚀 Getting Started

```bash
git clone https://github.com/frederickdlanejr/MAXX-Energy.git
cd MAXX-Energy
```

**about-page:** Open `index.html` in a browser or run:

```bash
cd about-page && python -m http.server 8080
```

**solardata:**
☕ Maven:

```bash
cd solardata && mvn spring-boot:run
```

## 🔄 Updating Subtrees

**About Page:**

```bash
git fetch about && git subtree pull --prefix=about-page about main
```

**SolarData:**

```bash
git fetch solardata && git subtree pull --prefix=solardata solardata main
```

---

## 🤝 Contributing

1. 🌱 Create a branch: `git checkout -b feature-name`
2. ✏️ Make changes, commit, push
3. 📬 Open a PR for review

---

## 📜 License

MIT License – see LICENSE file 📄

---


