import { defineCollection } from "astro:content";
import { z } from 'astro/zod'
import { glob } from "astro/loaders";

const article = defineCollection({
  loader: glob({ base: "./src/content/article", pattern: "**/*.{md,mdx}" }),
  schema: ({ image }) =>
    z.object({
      pubDate: z.coerce.date(),
      updatedDate: z.coerce.date().optional(),
      isDraft: z.coerce.boolean().default(false),
      lang: z.enum(["id", "en"]).default("id"),
    }),
});

const portfolio = defineCollection({
  loader: glob({ base: "./src/content/portfolio", pattern: "**/*.{md,mdx}" }),
  schema: ({ image }) =>
    z.object({
      year: z.number(),
      stack: z.array(z.string()).default([]),
      source: z.string().optional(),
      hidden: z.boolean().default(false),
    }),
});

export const collections = { article, portfolio };
