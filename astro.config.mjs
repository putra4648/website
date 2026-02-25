// @ts-check

import mdx from "@astrojs/mdx";
import sitemap from "@astrojs/sitemap";
import { defineConfig } from "astro/config";

import vercel from "@astrojs/vercel";

import vue from "@astrojs/vue";

import tailwindcss from "@tailwindcss/vite";
import { remarkReadingTime } from "./remark-time.mjs";
import { remarkModifiedTime } from "./remark-modified-time.mjs";

// https://astro.build/config
export default defineConfig({
  site: "https://putracoderz.my.id",
  integrations: [
    mdx({
      remarkPlugins: [remarkReadingTime, remarkModifiedTime],
    }),
    sitemap(),
    vue(),
  ],
  adapter: vercel(),

  vite: {
    plugins: [tailwindcss()],
  },
});
