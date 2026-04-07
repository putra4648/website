import type { App } from 'vue';
import Particles from "@tsparticles/vue3"; import { loadFull } from "tsparticles"
import { MotionPlugin } from 'motion-v';

export default (app: App) => {
    if (typeof window !== 'undefined') {
        app.use(Particles, {
            init: async (engine) => {
                await loadFull(engine);
            },
        });
    }
    app.use(MotionPlugin)
};