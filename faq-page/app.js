// Accordion behavior
document.querySelectorAll('.faq-q').forEach(btn => {
  btn.addEventListener('click', () => btn.parentElement.classList.toggle('open'));
});

// Simple search filter
const search = document.getElementById('faq-search');
const items = [...document.querySelectorAll('.faq')];

search.addEventListener('input', (e) => {
  const q = e.target.value.toLowerCase();
  items.forEach(it => {
    const text = it.textContent.toLowerCase();
    it.style.display = text.includes(q) ? '' : 'none';
  });
});
