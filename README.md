# My beautiful actor in ClojureScript

This actor does not do anything really useful. But if you also cannot bare
JavaScript torture and require a sane lispy language to write actors in, then
this will get you started using CLojureScript and shadow-cljs.

It does not work without some hard bits - especially there are neither externs for
the apify platforma nor for puppeteer. So you need to write externs by hand.

Also the default docker images do not contain java. So depenting on what you
are trying to do either make new docker images or build localy and then push
the compiled results - to do that with this actor do:

```
npm install
npm run release
apify push
```
