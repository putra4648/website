import type { App } from 'vue';
import { MotionPlugin } from 'motion-v';

export default (app: App) => {
    app.use(MotionPlugin)
};