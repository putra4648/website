// src/pages/open-graph/[...route].ts

import { OGImageRoute } from 'astro-og-canvas';

import { getCollection } from 'astro:content';

const collectionEntries = await getCollection('blog');

// Map the array of content collection entries to create an object.
// Converts [{ id: 'post.md', data: { title: 'Example', description: '' } }]
// to { 'post.md': { title: 'Example', description: '' } }
const pages = Object.fromEntries(collectionEntries.map(({ id, data }) => [id, data]));

export const { getStaticPaths, GET } = await OGImageRoute({
    pages: pages,
    getImageOptions: (path, page) => ({
        title: page.title,
        description: page.description,
    }),
});