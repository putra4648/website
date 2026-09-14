import { getCollection } from "astro:content";
import rss from "@astrojs/rss";
import { SITE_DESCRIPTION, SITE_TITLE } from "../consts";
import { getIntlayer } from "intlayer";

export async function GET(context) {
  const posts = await getCollection("blog");
  return rss({
    title: SITE_TITLE,
    description: SITE_DESCRIPTION,
    site: context.site,
    items: posts.map((post) => {
      const slug = post.id.split("/").pop().replace(/\.mdx?$/, "");
      const article = getIntlayer("blog", post.data.lang).articles[slug];
      return {
      ...post.data,
      title: article.title,
      description: article.description,
      link: `/blog/${post.id}/`,
      };
    }),
  });
}
