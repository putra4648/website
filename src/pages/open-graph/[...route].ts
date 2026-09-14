import { OGImageRoute } from 'astro-og-canvas';
import { getCollection } from 'astro:content';
import { getIntlayer } from 'intlayer';

const blogs = await getCollection('blog');
const getArticle = (post) => {
    const slug = post.id.split('/').pop().replace(/\.mdx?$/, '');
    return (getIntlayer('blog', post.data.lang).articles as Record<string, { title: string; description: string }>)[slug];
};
const pages = Object.fromEntries(
    blogs.map((post) => [
        post.id, // Sesuaikan dengan key yang dipanggil di tag <img> (post.id)
        {
            title: getArticle(post).title,
            description: getArticle(post).description,
        },
    ])
);

export const { getStaticPaths, GET } = await OGImageRoute({
    pages,
    getImageOptions: (path, page) => ({
        title: page.title,
        description: page.description,
        // bgImage: {
        //     path: './src/assets/bg-blog.jpg',
        //     fit: "fill"
        // },
    }),
});