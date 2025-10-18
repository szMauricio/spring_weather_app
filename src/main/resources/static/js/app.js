document.addEventListener('DOMContentLoaded', function () {
  const form = document.getElementById('cityForm');
  const btn = document.getElementById('submitBtn');
  const btnText = document.getElementById('btnText');
  const spinner = document.getElementById('btnSpinner');

  if (form && btn) {
    form.addEventListener('submit', function () {
      // Disable the submit button to avoid double submission
      btn.setAttribute('disabled', 'disabled');

      // Change button text and show spinner
      if (btnText) btnText.textContent = 'Loading...';
      if (spinner) spinner.classList.remove('hidden');
    });
  }
});
