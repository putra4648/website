import { t, type Dictionary } from "intlayer";

const introContent = {
  key: "intro",
  importMode: "dynamic",
  content: {
    title: t({
      en: "Hi, I'm Putra 👋",
      id: "Hi, I'm Putra 👋",
    }),
    subtitle: t({
      en: "A Technical System Analyst building scalable enterprise solutions",
      id: "Seorang Software Engineer yang membangun solusi enterprise berskala besar",
    }),
    intro1: t({
      en: `I am a results-driven Fullstack Software Engineer with over 3 years
            of professional experience specializing in enterprise solutions,
            robust backend architecture, and workflow digitalization. Throughout
            my career, I have focused on bridging the gap between complex
            business requirements and high-performance technical execution,
            successfully modernizing legacy infrastructure and streamlining
            critical operational processes`,
      id: "Saya adalah seorang Fullstack Software Engineer yang berorientasi pada hasil dengan pengalaman profesional lebih dari 3 tahun, terspesialisasi dalam solusi tingkat perusahaan (enterprise solutions), arsitektur backend yang tangguh, dan digitalisasi alur kerja. Sepanjang karier saya, saya berfokus untuk menjembatani kesenjangan antara kebutuhan bisnis yang kompleks dan eksekusi teknis berkinerja tinggi, serta berhasil memodernisasi infrastruktur legacy dan menyederhanakan proses operasional yang krusial",
    }),
    intro2: t({
      en: `My technical expertise spans modern backend and frontend
            development, utilizing core languages and frameworks such as Golang,
            Java (Spring Boot, Vaadin), and JavaScript/TypeScript (React.js,
            Vue.js). In addition to application development, I have a strong
            foundation in database architecture and optimization across
            PostgreSQL, IBM DB2, and Oracle SQL, ensuring secure, fast, and
            scalable data handling.`,
      id: "Keahlian teknis saya mencakup pengembangan backend dan frontend modern, menggunakan bahasa dan kerangka kerja inti seperti Golang, Java (Spring Boot, Vaadin), serta JavaScript/TypeScript (React.js, Vue.js). Selain pengembangan aplikasi, saya memiliki fondasi yang kuat dalam arsitektur basis data dan optimasi lintas PostgreSQL, IBM DB2, dan Oracle SQL, guna memastikan pengelolaan data yang aman, cepat, dan berskala besar.",
    }),
    intro3: t({
      en: `Whether it is building automated approval workflows, optimizing
            query performances, or scaling enterprise modules that increase
            operational efficiency, I am deeply passionate about clean code
            principles, agile methodologies, and continuous learning. I thrive
            in dynamic environments where I can solve complex engineering
            challenges and deliver reliable, user-centric software solutions.`,
      id: "Baik itu membangun alur kerja persetujuan otomatis, mengoptimalkan performa query, maupun menskalakan modul perusahaan yang meningkatkan efisiensi operasional, saya memiliki dedikasi tinggi terhadap prinsip clean code, metodologi agile, dan pembelajaran berkelanjutan. Saya dapat berkembang dengan baik di lingkungan dinamis di mana saya dapat memecahkan tantangan teknik yang kompleks dan menghadirkan solusi perangkat lunak yang andal serta berpusat pada pengguna (user-centric).",
    }),
  },
} satisfies Dictionary;

export default introContent;