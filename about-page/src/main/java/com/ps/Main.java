package com.ps;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        // Redirect "/" -> /about
        server.createContext("/", exchange -> {
            exchange.getResponseHeaders().add("Location", "/about");
            exchange.sendResponseHeaders(302, -1);
            exchange.close();
        });

        // Pretty About page
        server.createContext("/about", new AboutHandler());

        // Serve everything under /assets/* from src/main/resources/static/*
        server.createContext("/assets", new StaticFileHandler("/static"));

        // Optional health check
        server.createContext("/health", ex -> {
            byte[] ok = "OK".getBytes(StandardCharsets.UTF_8);
            ex.sendResponseHeaders(200, ok.length);
            try (OutputStream os = ex.getResponseBody()) { os.write(ok); }
        });

        System.out.println("Server running at http://localhost:" + port + "/about");
        server.start();
    }

    /** Renders the About page (logo image instead of video, modern UI) */
    static class AboutHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String html = """
                <!doctype html>
                <html lang="en">
                <head>
                  <meta charset="utf-8" />
                  <meta name="viewport" content="width=device-width, initial-scale=1" />
                  <title>About · MAXX Energy EDAP</title>
                  <style>
                    :root{
                      --bg:#0b0c10; --card:#111217; --ink:#e8eaf0; --muted:#99a1b3; --line:#1f2330;
                      --brand:#e22323; --brand2:#8b1111; --accent:#2dd4bf;
                    }
                    *{box-sizing:border-box}
                    body{margin:0;background:linear-gradient(180deg,#0b0c10 0%, #0e1117 100%);color:var(--ink);
                         font: 15px/1.55 system-ui,-apple-system,Segoe UI,Roboto,Helvetica,Arial,sans-serif}
                    a{color:inherit}
                    .wrap{max-width:1100px;margin:0 auto;padding:0 20px}
                    header{position:sticky;top:0;z-index:40;background:#0c0f15cc;
                           backdrop-filter:saturate(160%) blur(8px);border-bottom:1px solid var(--line)}
                    .nav{display:flex;align-items:center;justify-content:space-between;padding:14px 0}
                    .brand{display:flex;align-items:center;gap:12px}
                    .brand img{width:32px;height:32px;border-radius:8px;box-shadow:0 0 0 3px #00000055}
                    .chip{font-weight:700;letter-spacing:.2px}
                    .links a{padding:6px 10px;border-radius:10px;text-decoration:none;color:var(--muted)}
                    .links a:hover{background:#1a1f2b;color:var(--ink)}
                    .hero{border-bottom:1px solid var(--line);padding:56px 0}
                    .hero-grid{display:grid;grid-template-columns:1.2fr .8fr;gap:28px;align-items:center}
                    @media (max-width:920px){.hero-grid{grid-template-columns:1fr}}
                    h1{font-size:44px;line-height:1.1;margin:0}
                    .lead{margin-top:12px;color:var(--muted);font-size:18px}
                    .cta{margin-top:18px;display:flex;gap:12px;flex-wrap:wrap}
                    .btn{padding:12px 16px;border-radius:14px;border:1px solid var(--line);text-decoration:none}
                    .btn.primary{background:linear-gradient(180deg,var(--brand),var(--brand2));border:0;color:white}
                    .panel{background:var(--card);border:1px solid var(--line);border-radius:18px;padding:18px}
                    section{padding:42px 0}
                    h2{font-size:26px;margin:0 0 10px}
                    .grid2{display:grid;grid-template-columns:1fr 1fr;gap:24px}
                    @media (max-width:920px){.grid2{grid-template-columns:1fr}}
                    .timeline{border-left:2px solid var(--line);padding-left:16px;margin-top:8px}
                    .tl{position:relative;margin:14px 0}
                    .tl::before{content:"";position:absolute;left:-11px;top:6px;width:10px;height:10px;background:var(--accent);border-radius:50%}
                    .cards{display:grid;grid-template-columns:repeat(3,1fr);gap:16px}
                    @media (max-width:920px){.cards{grid-template-columns:1fr}}
                    .card{background:var(--card);border:1px solid var(--line);border-radius:16px;padding:16px}
                    .muted{color:var(--muted)}
                    dl{display:grid;grid-template-columns:140px 1fr;gap:6px 18px}
                    footer{border-top:1px solid var(--line);color:var(--muted);text-align:center;padding:26px 0}
                    .logo-hero{background:#050507;border:1px solid var(--line);border-radius:16px;padding:22px;
                               display:flex;align-items:center;justify-content:center}
                    .logo-hero img{max-width:360px;width:100%;height:auto;filter:drop-shadow(0 8px 24px #00000080)}
                    ul{margin:8px 0 0 20px}
                  </style>
                </head>
                <body>
                  <header>
                    <div class="wrap nav">
                      <div class="brand">
                       <img src="/assets/maxx-energy-logo.png" alt="MAXX Energy logo">
                        <span class="chip">MAXX Energy · EDAP</span>
                      </div>
                      <nav class="links" aria-label="Primary">
                        <a href="#mission">Mission</a>
                        <a href="#history">History</a>
                        <a href="#team">Team</a>
                        <a href="#contact">Contact</a>
                      </nav>
                    </div>
                  </header>

                  <section class="hero">
                    <div class="wrap hero-grid">
                      <div>
                        <h1>About the Enterprise Data Access Portal</h1>
                        <p class="lead">
                          EDAP gives MAXX Energy stakeholders on-demand, trustworthy access to solar plant
                          generation and revenue data. Public insights for everyone, secure detail for authorized roles.
                        </p>
                        <div class="cta">
                          <a class="btn primary" href="#contact">Get in touch</a>
                          <a class="btn" href="#mission">Our mission</a>
                        </div>
                      </div>
                      <div class="logo-hero panel">
                        <img src="/assets/maxx-energy-logo.png" alt="MAXX Energy logo large">
                      </div>
                    </div>
                  </section>

                  <main class="wrap">
                    <section id="mission">
                      <div class="panel">
                        <h2>Our Mission</h2>
                        <p class="muted">Deliver a secure, human-friendly portal that exposes the right energy data to the right users at the right time.</p>
                        <div class="grid2" style="margin-top:14px">
                          <div>
                            <ul>
                              <li>Public data viewable without login</li>
                              <li>Private data secured with authentication & role-based authorization (executive, director, manager, staff)</li>
                              <li>Clear visualizations with filters and drilldowns</li>
                              <li>Well-defined APIs between Application, Data, and Security</li>
                            </ul>
                          </div>
                          <div class="card">
                            <strong>Definition of Done (sample)</strong>
                            <ul>
                              <li>Accessible page, responsive on mobile/desktop</li>
                              <li>Contact info visible</li>
                              <li>Team + history present</li>
                            </ul>
                          </div>
                        </div>
                      </div>
                    </section>

                    <section id="history">
                      <div class="panel">
                        <h2>Our History</h2>
                        <div class="timeline">
                          <div class="tl"><strong>2019</strong> — Concept for a unified energy data portal.</div>
                          <div class="tl"><strong>2022</strong> — Pilot with internal stakeholders.</div>
                          <div class="tl"><strong>2024</strong> — Role-based access model refined.</div>
                          <div class="tl"><strong>2025</strong> — Cohort-led build: public + private views with 8–10 visualizations.</div>
                        </div>
                      </div>
                    </section>

                    <section id="team">
                      <div class="cards">
                        <div class="card">
                          <h3>Agile Coach / Scrum Master</h3>
                          <p class="muted">Leads planning, standups, and manages dependencies across DevOps, Data, Security.</p>
                        </div>
                        <div class="card">
                          <h3>DevOps</h3>
                          <p class="muted">Builds the web app, APIs, and UI—ensuring smooth, responsive access to data.</p>
                        </div>
                        <div class="card">
                          <h3>Data & Security</h3>
                          <p class="muted">Embeds visualizations with filters/drilldowns and protects private data via authz/authn.</p>
                        </div>
                      </div>
                    </section>

                    <section id="contact">
                      <div class="panel">
                        <h2>Contact Us</h2>
                        <p class="muted">We usually respond within one business day.</p>
                        <dl style="margin-top:10px">
                          <dt>Email</dt><dd><a href="mailto:edap@maxxenergy.com">edap@maxxenergy.com</a></dd>
                          <dt>Phone</dt><dd><a href="tel:+11234567890">+1 (123) 456-7890</a></dd>
                          <dt>Address</dt><dd>123 Solar Way, New York, NY 10001</dd>
                          <dt>Social</dt><dd><a href="#">LinkedIn</a> · <a href="#">YouTube</a></dd>
                        </dl>
                      </div>
                    </section>
                  </main>

                  <footer>© 2025 MAXX Energy · Enterprise Data Access Portal</footer>
                </body>
                </html>
                """;

            byte[] bytes = html.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().add("Content-Type", "text/html; charset=utf-8");
            exchange.sendResponseHeaders(200, bytes.length);
            try (OutputStream os = exchange.getResponseBody()) { os.write(bytes); }
        }
    }

    /** Static file handler for /assets/*  → loads from /static in classpath resources */
    static class StaticFileHandler implements HttpHandler {
        private final String resourceRoot; // e.g., "/static"
        StaticFileHandler(String resourceRoot) { this.resourceRoot = resourceRoot; }

        @Override public void handle(HttpExchange ex) throws IOException {
            String path = ex.getRequestURI().getPath().replaceFirst("^/assets", "");
            if (path.isEmpty() || "/".equals(path)) path = "/index.html"; // not used, but safe default
            String resourcePath = resourceRoot + path;

            try (InputStream is = Main.class.getResourceAsStream(resourcePath)) {
                if (is == null) {
                    ex.sendResponseHeaders(404, -1);
                    return;
                }
                String ct = contentType(resourcePath);
                ex.getResponseHeaders().add("Content-Type", ct);
                byte[] data = is.readAllBytes();
                ex.sendResponseHeaders(200, data.length);
                try (OutputStream os = ex.getResponseBody()) { os.write(data); }
            }
        }

        private static String contentType(String path) {
            String p = Objects.requireNonNull(path).toLowerCase();
            if (p.endsWith(".jpg") || p.endsWith(".jpeg")) return "image/jpeg";
            if (p.endsWith(".png")) return "image/png";
            if (p.endsWith(".webp")) return "image/webp";
            if (p.endsWith(".svg")) return "image/svg+xml";
            if (p.endsWith(".css")) return "text/css; charset=utf-8";
            if (p.endsWith(".js"))  return "application/javascript; charset=utf-8";
            if (p.endsWith(".html"))return "text/html; charset=utf-8";
            return "application/octet-stream";
        }
    }
}
