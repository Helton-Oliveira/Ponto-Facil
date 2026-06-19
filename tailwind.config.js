/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./webapp/**/*.{html,ts,css}",
    "./webapp/index.html",
  ],
  theme: {
    extend: {
      colors: {
        sidebar: '#000000',
        brand: '#3b82f6', // blue-500
      }
    },
  },
  plugins: [],
}
