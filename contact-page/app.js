const form = document.getElementById('contact-form');
const statusEl = document.getElementById('status');

form.addEventListener('submit', async (e) => {
  e.preventDefault();
  statusEl.hidden = true;

  const name = document.getElementById('name').value.trim();
  const email = document.getElementById('email').value.trim();
  const message = document.getElementById('message').value.trim();

  if (!name || !email || !message) {
    show('Please fill out all fields.', false);
    return;
  }
  if (!/^[^@\s]+@[^@\s]+\.[^@\s]+$/.test(email)) {
    show('Please enter a valid email address.', false);
    return;
  }

  // TODO: Hook up to your backend. For now, simulate success.
  // Example Spring Boot endpoint (optional): POST /api/contact {name,email,message}
  await new Promise(r => setTimeout(r, 600));
  form.reset();
  show('Thanks! Your message has been sent.', true);
});

function show(msg, ok) {
  statusEl.textContent = msg;
  statusEl.className = 'status ' + (ok ? 'ok' : 'err');
  statusEl.hidden = false;
}
