import Services from './Services.vue';

if (!window.vertxConsoleRoutes) window.vertxConsoleRoutes = [];
window.vertxConsoleRoutes.push({
    path: '/services',
    component: Services
});