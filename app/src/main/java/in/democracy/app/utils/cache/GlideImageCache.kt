package `in`.democracy.app.utils.cache

/*
fun preCache(imageURL: String): Target<Drawable> {
    return Glide.with(ApplicationClass.getApp())
        .load(imageURL)
        .apply(
            RequestOptions()
                .useUnlimitedSourceGeneratorsPool(true)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        ).preload(SIZE_ORIGINAL, SIZE_ORIGINAL)
}

fun preCache(imageURLs: List<String>) {
    val handler = CoroutineExceptionHandler { _, exception ->
        Log.e(
            "GlideCache",
            "Glide Cache Job error ${exception.localizedMessage ?: "error message is empty"}"
        )
    }
    GlobalScope.launch(context = handler + IO) {
        supervisorScope {
            imageURLs.forEach {
                launch {
                    preCache(it)
                }
            }
        }
    }
}
*/



