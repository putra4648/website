import type { App } from 'vue';
import Particles from "@tsparticles/vue3";
import { loadSlim } from "@tsparticles/slim"
import { MotionPlugin } from 'motion-v';

export default (app: App) => {
    if (typeof window !== 'undefined') {
        app.use(Particles, {
            init: async (engine) => {
                await loadSlim(engine);
            },
        });
    }
    app.use(MotionPlugin)
};