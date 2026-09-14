import { t, type Dictionary } from "intlayer";

const blogContent = {
  key: "blog",
  importMode: "dynamic",
  content: {
    title: t({ en: "Blog", id: "Blog" }),
    description: t({
      en: "Notes, lessons, and stories from my journey as a developer.",
      id: "Catatan, pembelajaran, dan cerita dari perjalanan saya sebagai pengembang.",
    }),
    actions: {
      back: t({ en: "Back to Blog", id: "Kembali ke Blog" }),
      readMore: t({ en: "Read article", id: "Baca artikel" }),
      seeAll: t({ en: "See all blogs", id: "Lihat semua blog" }),
    },
    metadata: {
      published: t({ en: "Published", id: "Diterbitkan" }),
      updated: t({ en: "Last updated", id: "Terakhir diperbarui" }),
      readingTime: t({ en: "min read", id: "menit baca" }),
    },
    articles: {
      "kehidupan-1": {
        title: t({ en: "Kehidupan - Part 1", id: "Kehidupan - Part 1" }),
        description: t({
          en: "Perjalanan hidup seorang agar tidak setress, dengan berbagai pengalaman dan pembelajaran yang membentuknya menjadi pribadi yang lebih baik.",
          id: "Perjalanan hidup seorang agar tidak setress, dengan berbagai pengalaman dan pembelajaran yang membentuknya menjadi pribadi yang lebih baik.",
        }),
        tags: ["life", "journey", "tech"],
      },
      "kenapa-cusrom": {
        title: t({
          en: "Mengapa custom ROM tidak selalu menjadi pilihan terbaik untuk perangkat Android Anda",
          id: "Mengapa custom ROM tidak selalu menjadi pilihan terbaik untuk perangkat Android Anda",
        }),
        description: t({
          en: "Sebuah alasan untuk tetap stay dengan ROM resmi daripada mencoba custom ROM yang mungkin memiliki risiko keamanan dan stabilitas.",
          id: "Sebuah alasan untuk tetap stay dengan ROM resmi daripada mencoba custom ROM yang mungkin memiliki risiko keamanan dan stabilitas.",
        }),
        tags: ["tech", "android", "custom-rom", "security"],
      },
      "my-kisah": {
        title: t({ en: "My Kisah - Part 1", id: "My Kisah - Part 1" }),
        description: t({
          en: "Menelusuri jejak \"My Kisah\" sebagai Fullstack Engineer",
          id: "Menelusuri jejak \"My Kisah\" sebagai Fullstack Engineer",
        }),
        tags: ["life", "journey", "tech"],
      },
      "my-kisah-2": {
        title: t({ en: "My Kisah - Part 2", id: "My Kisah - Part 2" }),
        description: t({
          en: "Terjebak di labirin Spring Boot, perang lawan ego overengineering, sampai 'perselingkuhan' sesaat dengan React. Sebuah perjalanan mencari efisiensi di tengah kabut kode.",
          id: "Terjebak di labirin Spring Boot, perang lawan ego overengineering, sampai 'perselingkuhan' sesaat dengan React. Sebuah perjalanan mencari efisiensi di tengah kabut kode.",
        }),
        tags: ["life", "journey", "tech"],
      },
      "my-kisah-3": {
        title: t({ en: "My Kisah - Part 3", id: "My Kisah - Part 3" }),
        description: t({
          en: "Meninggalkan zona nyaman Spring Boot untuk mendalami ekosistem React.",
          id: "Meninggalkan zona nyaman Spring Boot untuk mendalami ekosistem React.",
        }),
        tags: ["life", "journey", "tech"],
      },
      "the-struggle-with-flutter": {
        title: t({ en: "The Struggle with Flutter", id: "The Struggle with Flutter" }),
        description: t({
          en: "Things I wish I knew before starting Flutter",
          id: "Things I wish I knew before starting Flutter",
        }),
        tags: ["Flutter", "Firebase", "App Development", "Android", "Dart"],
      },
      "why-flutter": {
        title: t({
          en: "Why I Chose Flutter as an Android Developer",
          id: "Why I Chose Flutter as an Android Developer",
        }),
        description: t({
          en: "From a loud laptop fan to building seamless cross-platform apps.",
          id: "From a loud laptop fan to building seamless cross-platform apps.",
        }),
        tags: ["Flutter", "Android", "Developer Journey", "Dart", "Storytelling"],
      },
    },
  },
} satisfies Dictionary;

export default blogContent;