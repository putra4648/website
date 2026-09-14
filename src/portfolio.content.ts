import { t, type Dictionary } from "intlayer";

const portfolioContent = {
  key: "portfolio",
  content: {
    title: t({ en: "Portfolio", id: "Portofolio" }),
    description: t({
      en: "Selected projects and systems I have built.",
      id: "Proyek dan sistem pilihan yang telah saya bangun.",
    }),
    actions: {
      preview: t({ en: "Preview", id: "Pratinjau" }),
      back: t({ en: "Back to Portfolio", id: "Kembali ke Portofolio" }),
    },
    sections: {
      preview: t({ en: "Preview", id: "Pratinjau" }),
    },
    articles: {
      "chat-system": {
        title: t({ en: "Simple Real-Time Chat System", id: "Sistem Chat Real-Time Sederhana" }),
        description: t({
          en: "A high-performance chat application built with Golang, PGX, Parsley, GoFiber, and WebSockets. This project serves as a deep dive into modular architecture and Clean Architecture principles.",
          id: "Aplikasi chat berperforma tinggi yang dibangun dengan Golang, PGX, Parsley, GoFiber, dan WebSockets. Proyek ini mendalami arsitektur modular dan prinsip Clean Architecture.",
        }),
      },
      "e-commerce": {
        title: t({ en: "E-Commerce System (WIP)", id: "Sistem E-Commerce (Dalam Pengembangan)" }),
        description: t({
          en: "An e-commerce project focused on streamlining corporate operations through stock, location, and transfer management. This project serves as a deep dive into modular architecture and Clean Architecture principles.",
          id: "Proyek e-commerce yang berfokus pada penyederhanaan operasional perusahaan melalui pengelolaan stok, lokasi, dan transfer. Proyek ini mendalami arsitektur modular dan prinsip Clean Architecture.",
        }),
      },
      "erp-system": {
        title: t({ en: "My ERP", id: "ERP Saya" }),
        description: t({
          en: "A high-performance enterprise resource planning system focused on real-time inventory tracking and master data management.",
          id: "Sistem enterprise resource planning berperforma tinggi yang berfokus pada pelacakan inventaris real-time dan pengelolaan master data.",
        }),
      },
      "my-anime-list-app": {
        title: t({ en: "My Anime List App", id: "Aplikasi My Anime List" }),
        description: t({
          en: "A mobile management application that allows users to track their anime watchlist, including personal ratings and reviews.",
          id: "Aplikasi manajemen seluler yang memungkinkan pengguna melacak daftar tontonan anime, termasuk rating dan ulasan pribadi.",
        }),
      },
      "portal-berita-indonesia": {
        title: t({ en: "Portal Berita Indonesia", id: "Portal Berita Indonesia" }),
        description: t({
          en: "A news portal application delivering the latest news from Indonesian sources with category filtering, search, and detailed news views.",
          id: "Aplikasi portal berita yang menyajikan berita terbaru dari sumber Indonesia dengan filter kategori, pencarian, dan tampilan berita yang detail.",
        }),
      },
      "production-monitoring-system": {
        title: t({ en: "Production Monitoring System (Private)", id: "Sistem Monitoring Produksi (Pribadi)" }),
        description: t({
          en: "An integrated manufacturing management system built to optimize shop floor efficiency through production planning, machine capacity, and labor availability.",
          id: "Sistem manajemen manufaktur terintegrasi untuk mengoptimalkan efisiensi lantai produksi melalui perencanaan produksi, kapasitas mesin, dan ketersediaan tenaga kerja.",
        }),
      },
      "purchase-requisition": {
        title: t({ en: "Purchase Requisition (Private)", id: "Purchase Requisition (Pribadi)" }),
        description: t({
          en: "A module-based e-Procurement system designed to automate the corporate purchasing cycle and keep procurement aligned with company budgets.",
          id: "Sistem e-Procurement berbasis modul untuk mengotomatisasi siklus pembelian perusahaan dan menjaga pengadaan tetap sesuai anggaran.",
        }),
      },
      "transfer-request": {
        title: t({ en: "Transfer Request", id: "Permintaan Transfer" }),
        description: t({
          en: "An internal ERP system focused on item transfer management and production process control with barcode validation.",
          id: "Sistem ERP internal yang berfokus pada pengelolaan transfer barang dan pengendalian proses produksi dengan validasi barcode.",
        }),
      },
      "warehouse-system": {
        title: t({ en: "Warehouse System", id: "Sistem Gudang" }),
        description: t({
          en: "A warehouse management system designed to optimize operations through stock management, location tracking, transfer management, and reporting.",
          id: "Sistem manajemen gudang untuk mengoptimalkan operasional melalui pengelolaan stok, pelacakan lokasi, manajemen transfer, dan pelaporan.",
        }),
      },
      "xpense-tracker-ui": {
        title: t({ en: "Xpense Tracker UI", id: "UI Xpense Tracker" }),
        description: t({
          en: "A UI slicing project based on a Dribbble design for a mobile expense tracker application, focused on high-fidelity visual implementation.",
          id: "Proyek slicing UI berdasarkan desain Dribbble untuk aplikasi pelacak pengeluaran seluler dengan fokus pada implementasi visual berfidelitas tinggi.",
        }),
      },
    },
  },
} satisfies Dictionary;

export default portfolioContent;