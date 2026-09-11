import { OGImageRoute } from 'astro-og-canvas';
import { getCollection } from 'astro:content';

const blogs = await getCollection('blog');
const pages = Object.fromEntries(
    blogs.map((post) => [
        post.id, // Sesuaikan dengan key yang dipanggil di tag <img> (post.id)
        {
            title: post.data.title,
            description: post.data.description || '',
        },
    ])
);

export const { getStaticPaths, GET } = await OGImageRoute({
    pages,
    getImageOptions: (path, page) => ({
        title: page.title,
        description: page.description,
        bgImage: {
            path: './src/assets/bg-blog.jpg',
            fit: "fill"
        },
    }),
});