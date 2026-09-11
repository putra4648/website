import { defineCollection } from "astro:content";
import { z } from 'astro/zod'
import { glob } from "astro/loaders";

const blog = defineCollection({
  // Load Markdown and MDX files in the `src/content/blog/` directory.
  loader: glob({ base: "./src/content/blog", pattern: "**/*.{md,mdx}" }),
  // Type-check frontmatter using a schema
  schema: ({ image }) =>
    z.object({
      title: z.string(),
      description: z.string(),
      pubDate: z.coerce.date(),
      updatedDate: z.coerce.date().optional(),
      heroImage: image().optional(),
      tags: z.array(z.string()).default([]),
      lang: z.enum(["id", "en"]).default("id"),
    }),
});

const portfolio = defineCollection({
  // Load Markdown and MDX files in the `src/content/portfolio/` directory.
  loader: glob({ base: "./src/content/portfolio", pattern: "**/*.{md,mdx}" }),
  // Type-check frontmatter using a schema
  schema: ({ image }) =>
    z.object({
      title: z.string(),
      description: z.array(z.string()),
      year: z.number(),
      stack: z.array(z.string()).default([]),
      source: z.string().optional(),
      image: image().optional(),
      hidden: z.boolean().default(false),
    }),
});

export const collections = { blog, portfolio };
