// Mobile menu toggle functionality
document.addEventListener('DOMContentLoaded', function() {
  const mobileMenuToggle = document.querySelector('.mobile-menu-toggle');
  const navList = document.querySelector('.nav-list');
  
  if (mobileMenuToggle && navList) {
    mobileMenuToggle.addEventListener('click', function() {
      navList.classList.toggle('active');
      mobileMenuToggle.classList.toggle('active');
      document.body.classList.toggle('menu-open');
    });
  }
  
  // Add scroll event listener for header
  const header = document.getElementById('header');
  if (header) {
    window.addEventListener('scroll', function() {
      if (window.scrollY > 50) {
        header.classList.add('scrolled');
      } else {
        header.classList.remove('scrolled');
      }
    });
  }
  
});

// Function to open email client with pre-populated form data
function openEmailClient() {
  // Get form data
  const name = document.getElementById('name').value || '';
  const company = document.getElementById('company').value || '';
  const email = document.getElementById('email').value || '';
  const phone = document.getElementById('phone').value || '';
  const subject = document.getElementById('subject').value || '';
  
  // Basic form validation
  if (!name || !email || !subject) {
    alert('Please fill in the Name, Email, and Subject fields.');
    return false;
  }
  
  if (!isValidEmail(email)) {
    alert('Please enter a valid email address.');
    return false;
  }
  
  // Create email body with form data
  const emailBody = encodeURIComponent(
    `Name: ${name}\n` +
    `Company: ${company}\n` +
    `Email: ${email}\n` +
    `Phone: ${phone}\n\n` +
    `[Please add your message here]`
  );
  
  // Create mailto link
  const mailtoLink = `mailto:monitoringcybernetics@gmail.com?subject=${encodeURIComponent(subject)}&body=${emailBody}`;
  
  // Open email client
  window.location.href = mailtoLink;
  
  return false;
}

// Email validation helper
function isValidEmail(email) {
  const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return regex.test(email);
}

// Initialize any interactive elements
document.addEventListener('DOMContentLoaded', function() {
  // Any additional initialization can go here
  
  // Add smooth scrolling for anchor links
  document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function(e) {
      e.preventDefault();
      
      const targetId = this.getAttribute('href').substring(1);
      if (!targetId) return;
      
      const targetElement = document.getElementById(targetId);
      if (targetElement) {
        window.scrollTo({
          top: targetElement.offsetTop - 100,
          behavior: 'smooth'
        });
      }
    });
  });
});