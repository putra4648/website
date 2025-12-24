import type { CollectionEntry } from "astro:content";

export function getAllTags(posts: CollectionEntry<"blog">[]) {
  return posts
    .flatMap((post) => post.data.tags)
    .reduce<Record<string, number>>((acc, tag) => {
      acc[tag] = (acc[tag] || 0) + 1;
      return acc;
    }, {});
}

export function randomizeTagColors(tag: string) {
  switch (tag) {
    case 'tech':
      return 'badge-primary'
    case 'life':
      return 'badge-success'
    default:
      return 'badge-accent'
  }
}
