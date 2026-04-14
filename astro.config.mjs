// @ts-check

import mdx from "@astrojs/mdx";
import sitemap from "@astrojs/sitemap";
import { defineConfig, fontProviders } from "astro/config";

import vercel from "@astrojs/vercel";

import vue from "@astrojs/vue";

import tailwindcss from "@tailwindcss/vite";
import { remarkReadingTime } from "./remark-time.mjs";
import { remarkModifiedTime } from "./remark-modified-time.mjs";

import icon from "astro-icon";

// https://astro.build/config
export default defineConfig({
  site: "https://putracoderz.my.id",
  integrations: [
    mdx({
      remarkPlugins: [remarkReadingTime, remarkModifiedTime],
    }),
    sitemap(),
    vue({
      appEntrypoint: '/src/pages/_app',
    }),
    icon(),
  ],
  adapter: vercel({
    webAnalytics: {
      enabled: true,
    }
  }),
  experimental: {
    fonts: [{
      provider: fontProviders.google(),
      name: "Saira Stencil",
      cssVariable: "--font-saira-stencil",
    }],
  },
  vite: {
    plugins: [
      tailwindcss(),
    ],
  },

});