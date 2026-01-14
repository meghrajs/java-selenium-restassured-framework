![CI](https://github.com/meghrajs/java-selenium-restassured-framework/actions/workflows/ci.yml/badge.svg)

# Java Enterprise Automation Framework (Selenium + REST Assured)

Enterprise-style test automation framework using **Java + Selenium (UI)** and **REST Assured (API)** for **UI + API + E2E** testing with CI-ready execution and reliability patterns.

📌 **SDET Portfolio:** https://github.com/meghrajs/sdet-portfolio

---

## Highlights
- UI + API + E2E tests in one framework (Java)
- TestNG groups: `smoke`, `regression`, `ui`, `api`, `e2e`
- CI-ready via GitHub Actions (smoke on PR/push, regression on schedule)
- Failure artifacts: **screenshots** + **Surefire reports**
- Reliable execution: DriverManager (ThreadLocal), stable waits, clean structure

---

## Tech Stack
- Java 17
- Maven
- Selenium 4
- REST Assured
- TestNG
- WebDriverManager

---

## Project Structure
- `framework/` — core framework code (config, base, utils, pages)
- `tests/ui` — UI tests (Page Objects)
- `tests/api` — API tests (REST Assured)
- `tests/e2e` — end-to-end flows (API seed → UI validate)
- `.github/workflows` — CI pipelines

---

## Setup (Local)

### Prerequisites
- **Java 17+**
- **Maven 3.9+**
- **Google Chrome** installed (or run headless)

Verify:
```bash
java -version
mvn -version
google-chrome --version
```

### Clone + install
```bash
git clone https://github.com/meghrajs/java-selenium-restassured-framework.git
cd java-selenium-restassured-framework
mvn -q -DskipTests package
```

---

## Running Tests (Local)

### Run everything
```bash
mvn test
```

### Run smoke suite
```bash
mvn test -Dgroups=smoke
```

### Run regression suite
```bash
mvn test -Dgroups=regression
```

### Run UI tests only
```bash
mvn test -Dgroups=ui
```

### Run API tests only
```bash
mvn test -Dgroups=api
```

### Run E2E tests only
```bash
mvn test -Dgroups=e2e
```

---

## Headless vs Headed Runs
By default, the framework runs **headless** (CI-friendly).

### Force headless
```bash
mvn test -DHEADLESS=true
```

### Force headed (local debugging)
```bash
mvn test -DHEADLESS=false
```

---

## Environment Overrides
Defaults are loaded from the framework config, but you can override via system properties / CI env vars:

- `BASE_URL` (default: `https://playwright.dev`)
- `API_BASE_URL` (default: `https://reqres.in`)
- `HEADLESS` (default: `true`)

Example:
```bash
mvn test -Dgroups=smoke -DBASE_URL=https://playwright.dev -DHEADLESS=true
```

---

## Live API vs Mimic Mode (CI-friendly)
Public APIs can be flaky due to downtime/rate limits/network issues.

This framework supports a deterministic mode for CI runs:
- Default: **mimic mode** (stable)
- Enable live API calls:
```bash
mvn test -Dgroups=smoke -DUSE_LIVE_API=true
```

---

## Reports & Artifacts

### Surefire reports
After any run:
- `target/surefire-reports/`

### Screenshots (on UI failures)
When UI tests fail, screenshots are stored in:
- `target/screenshots/`

---

## CI (GitHub Actions)
GitHub Actions runs:
- **PR/push:** smoke suite
- **Scheduled:** regression suite

Artifacts uploaded:
- `target/surefire-reports`
- `target/screenshots`
