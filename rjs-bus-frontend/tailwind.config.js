
/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{js,jsx,ts,tsx}", "./node_modules/react-tailwindcss-datepicker/dist/index.esm.js"
  ],
  theme: {
    extend: {
      colors:{
        "black-rgba":'rgba(0,0,0,100)',
        "transparent-rgba":'rgba(0,0,0,0)',
        "geryish":"rgb(236, 237, 234)",
        "nav-black" : "rgb(35, 31, 32)",
        "search-left" : "rgb(83, 178, 254)",
        "search-right":"rgb(6, 91, 243)",
        "search-headding":"rgb(47, 137, 249)"
      },
      backgroundImage:{
        'hero': "url('./Assets/Landing_page_background.jpg')",
      }
    },
  },
  variant : {
    extend : {
      display : ['group-focus']
    }
  },
  plugins: [],
}