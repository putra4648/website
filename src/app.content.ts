import { t, type Dictionary } from "intlayer";

const appContent = {
  key: "app",
  importMode: "dynamic",
  content: {
    nav: {
      home: t({ en: "Home", id: "Beranda" }),
      project: t({ en: "Project", id: "Proyek" }),
      blog: t({ en: "Blog", id: "Blog" }),
      guestbook: t({ en: "Guestbook", id: "Buku Tamu" }),
      resume: t({ en: "Resume", id: "Resume" }),
    },
    actions: {
      backToBlog: t({ en: "Back to Blog", id: "Kembali ke Blog" }),
      backToProject: t({
        en: "Back to Project",
        id: "Kembali ke Proyek",
      }),
      preview: t({ en: "Preview", id: "Pratinjau" }),
      lastUpdated: t({ en: "Last updated on", id: "Terakhir diperbarui" }),
    },
  },
} satisfies Dictionary;

export default appContent;