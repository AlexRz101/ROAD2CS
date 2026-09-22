# Road2CS

A full-stack degree roadmap tool built for CSUN CS students. Generate a personalized semester-by-semester course plan based on your schedule preference, with support for GE swapping, multiple load types, and real-time persistence.

**Live App:** [road2cs.vercel.app](https://road2cs.vercel.app)
> 🎓 Used by real CSUN students — 30+ monthly visitors, indexed on Google and Bing SEO.

---

## Tech Stack

| Layer | Technology |
|---|---|
| Frontend | React, Vite, Tailwind CSS |
| Backend | Java, Spring Boot |
| Deployment | Vercel (frontend), Render (backend) |
| Analytics | Vercel Analytics |

---

## Features

- **Multiple roadmap templates** — Heavy, Medium, Light, Part-Time, Summer, and Winter schedule variants
- **GE course swapping** — swap General Education courses via a backend-powered dropdown API
- **GE randomization** — courses pulled from category-keyed pools for variety
- **localStorage persistence** — your roadmap is saved between sessions
- **Fully responsive** — optimized layouts for mobile, tablet, and desktop 
- **SEO indexed** — listed on Google Search Console and Bing Webmaster Tools; achieved Google AI Overview placement for CSUN CS roadmap queries

---

## Architecture

The backend uses in-memory HashMap templates organized into separate Java helper classes by load type (`HeavySemesters`, `MediumSemesters`, etc.). A `/api/courses` endpoint returns GE options grouped by category, powering the frontend swap dropdowns.

---

## Getting Started

### Prerequisites

- Java 17+
- Node.js 18+

### Backend

```bash
git clone https://github.com/AlexRz101/ROAD2CS.git
cd ROAD2CS/backend
./mvnw spring-boot:run
```

### Frontend

```bash
cd frontend
npm install
npm run dev
```

---

## Contributors

| Name | Role |
|---|---|
| [Alexander Ruiz](https://github.com/AlexRz101) | Full stack lead |
| [Tristan Munoz](https://github.com/tristan-33) | Frontend lead |
| [Anthony Sanchez](https://github.com/Sanch1660) | Backend developer |
| [Liam Saheli](https://github.com/salehiliam) | Frontend developer |
| [Ricardo Tejas](https://github.com/qrw42426) | Frontend developer |




---

## Links

- [LinkedIn — Alexander Ruiz](https://linkedin.com/in/alexander-r-6b620a210)
