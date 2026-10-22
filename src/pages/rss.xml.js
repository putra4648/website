import { getCollection } from "astro:content";
import rss from "@astrojs/rss";
import { SITE_DESCRIPTION, SITE_TITLE } from "../consts";
import { getIntlayer } from "intlayer";

export async function GET(context) {
  const posts = (await getCollection("article"))
    .filter((post) => !post.data.isDraft)
    .sort((a, b) => b.data.pubDate.valueOf() - a.data.pubDate.valueOf());

  return rss({
    title: SITE_TITLE,
    description: SITE_DESCRIPTION,
    site: context.site,
    items: posts
      .map((post) => {
        const slug = post.id.split("/").pop().replace(/\.mdx?$/, "");
        const article = getIntlayer("article", post.data.lang)?.articles?.[slug];
        if (!article) return null;

        return {
          ...post.data,
          title: article.title,
          description: article.description,
          link: `/${post.data.lang}/article/${slug}/`,
        };
      })
      .filter(Boolean),
  });
}
