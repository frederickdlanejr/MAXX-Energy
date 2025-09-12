package com.maxxenergy.edap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AboutController {

    @GetMapping("/")
    public String redirectToAbout() {
        return "redirect:/about";
    }


    @GetMapping("/about")
    @ResponseBody
    public String aboutPage() {
        return """
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
                
                /* Data Display Styles */
                .data-section{margin-top:24px}
                .data-card{background:var(--card);border:1px solid var(--line);border-radius:16px;padding:20px}
                .data-grid{display:grid;grid-template-columns:repeat(auto-fit,minmax(250px,1fr));gap:16px;margin-top:16px}
                .stat{text-align:center;padding:16px;background:#0a0e14;border-radius:12px}
                .stat-value{font-size:24px;font-weight:bold;color:var(--accent)}
                .stat-label{color:var(--muted);margin-top:4px;font-size:14px}
                .loading{color:var(--muted);text-align:center;padding:20px}
              </style>
            </head>
            <body>
              <header>
                <div class="wrap nav">
                  <div class="brand">
                   <div style="width:32px;height:32px;background:var(--brand);border-radius:8px;display:flex;align-items:center;justify-content:center;color:white;font-weight:bold;font-size:14px;">ME</div>
                    <span class="chip">MAXX Energy · EDAP</span>
                  </div>
                  <nav class="links" aria-label="Primary">
                    <a href="#mission">Mission</a>
                    <a href="#history">History</a>
                    <a href="#team">Team</a>
                    <a href="#data">Data</a>
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
                    <div style="width:200px;height:120px;background:var(--brand);border-radius:12px;display:flex;align-items:center;justify-content:center;color:white;font-weight:bold;font-size:32px;">MAXX Energy</div>
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

                <section id="data">
                  <div class="panel">
                    <h2>Live Solar Data</h2>
                    <p class="muted">Real-time data from our public solar installations.</p>
                    <div class="data-section">
                      <div id="solarData" class="loading">Loading solar data...</div>
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

              <script>
                // Fetch and display solar data
                async function loadSolarData() {
                  try {
                    const response = await fetch('/api/public/data');
                    const data = await response.json();
                    
                    const container = document.getElementById('solarData');
                    container.innerHTML = `
                      <div class="data-card">
                        <h3>${data.plantName}</h3>
                        <div class="data-grid">
                          <div class="stat">
                            <div class="stat-value">${data.generation.toFixed(2)} MW</div>
                            <div class="stat-label">Generation</div>
                          </div>
                          <div class="stat">
                            <div class="stat-value">$${data.revenue.toLocaleString()}</div>
                            <div class="stat-label">Revenue</div>
                          </div>
                        </div>
                      </div>
                    `;
                  } catch (error) {
                    console.error('Error loading solar data:', error);
                    document.getElementById('solarData').innerHTML = 
                      '<div class="data-card"><p class="muted">Unable to load solar data at this time.</p></div>';
                  }
                }

                // Load data when page loads
                document.addEventListener('DOMContentLoaded', loadSolarData);

                // Smooth scrolling for navigation links
                document.querySelectorAll('a[href^="#"]').forEach(anchor => {
                  anchor.addEventListener('click', function (e) {
                    e.preventDefault();
                    const target = document.querySelector(this.getAttribute('href'));
                    if (target) {
                      target.scrollIntoView({ behavior: 'smooth' });
                    }
                  });
                });
              </script>
            </body>
            </html>
            """;
    }

    @GetMapping("/health")
    @ResponseBody
    public String health() {
        return "OK";
    }
}