# Monitoring Cybernetics Website

## Project Structure

This is a static website project for Monitoring Cybernetics, a company providing intelligent observability and monitoring solutions.

### Directory Structure

- `/` - Root directory containing the homepage (index.html)
- `/css/` - Contains stylesheets
- `/js/` - Contains JavaScript files
- `/images/` - Contains image assets
- `/pages/` - Contains additional HTML pages

### Key Files

- `index.html` - Homepage
- `pages/about.html` - About Us page
- `pages/services.html` - Services/Products page
- `pages/contact.html` - Contact page with form
- `css/styles.css` - Main stylesheet
- `js/main.js` - Main JavaScript file

## Website Features

- Responsive design that works on mobile, tablet, and desktop
- Clean, modern aesthetic with a navy/blue color scheme
- Navigation menu with mobile-friendly toggle
- Contact form that simulates sending email to monitoringcybernetics@gmail.com
- SVG icons for visual elements

## Development Notes

### Local Development

To view the website locally:
1. Navigate to the project directory
2. Open `index.html` in your browser

### Adding New Pages

When adding new pages:
1. Create HTML files in the `/pages/` directory
2. Update navigation links in all existing pages
3. Follow the existing page structure with proper header and footer

### Image Handling

- Store new images in the `/images/` directory
- Use responsive image techniques as implemented in the current design
- Keep image file sizes optimized for web

### Form Handling

- The contact form is currently set up for frontend demonstration only
- In a production environment, server-side code would be required to send actual emails

## Design Tokens

The website uses a design system with the following key variables:

### Colors
- Primary: #0a192f (Dark navy blue)
- Secondary: #1e88e5 (Bright blue)
- Accent: #64ffda (Teal accent)
- Text: #333333 (Dark gray)
- Background: #ffffff (White)

### Typography
- Primary Font: 'Inter', with system font fallbacks
- Heading Font: 'Inter', with system font fallbacks

### Spacing
- Uses a consistent spacing scale (--space-xs through --space-xxl)

### Responsive Breakpoints
- Mobile: up to 576px
- Tablet: 577px to 768px
- Desktop small: 769px to 992px
- Desktop large: 993px and up