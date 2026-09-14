import { t, type Dictionary } from "intlayer";

const appContent = {
  key: "app",
  content: {
    title: t({
      en: "Hello World",
      id: "Halo Dunia",
    }),
    nav: {
      home: t({ en: "Home", id: "Beranda" }),
      portfolio: t({ en: "Portfolio", id: "Portofolio" }),
      blog: t({ en: "Blog", id: "Blog" }),
      guestbook: t({ en: "Guestbook", id: "Buku Tamu" }),
      resume: t({ en: "Resume", id: "Resume" }),
    },
    actions: {
      backToBlog: t({ en: "Back to Blog", id: "Kembali ke Blog" }),
      backToPortfolio: t({
        en: "Back to Portfolio",
        id: "Kembali ke Portofolio",
      }),
      preview: t({ en: "Preview", id: "Pratinjau" }),
      lastUpdated: t({ en: "Last updated on", id: "Terakhir diperbarui" }),
    },
  },
} satisfies Dictionary;

export default appContent;