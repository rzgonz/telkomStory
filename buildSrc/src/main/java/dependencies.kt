object Versions {
    // Build tools and SDK
    const val buildTools = "30.0.2"
    const val compileSdk = 32
    const val gradlePlugin = "4.1.2"
    const val kotlin = "1.4.31"
    const val minSdk = 21
    const val targetSdk = 32
    const val realm = "10.4.0"

    const val googleService = "4.3.10"

    // Android libraries
    const val appcompat = "1.2.0"
    const val arch = "2.1.0"
    const val cardview = "1.0.0"
    const val constraintlayout = "2.0.0"
    const val coordinatorLayout = "1.1.0"
    const val core = "1.3.1"
    const val fragment = "1.2.5"
    const val lifecycle = "2.2.0"
    const val navigation = "2.3.0"
    const val recyclerview = "1.1.0"
    const val material = "1.2.1"
    const val viewPager = "1.0.0"

    // Libraries
    const val autoValue = "1.6.6"
    const val epoxy = "4.0.0"
    const val koin = "3.1.5"
    const val kotlinCoroutines = "1.4.1"
    const val lottie = "3.4.0"
    const val glide = "4.11.0"
    const val eventBus = "3.2.0"
    const val desugar = "1.1.5"

    //    const val moshi = "1.9.2"
    const val gson = "2.8.6"
    const val multidex = "2.0.1"
    const val mavericks = "2.6.0"
    const val retrofit = "2.7.2"
    const val rxAndroid = "2.1.1"
    const val rxJava = "2.2.9"
    const val okHttp3 = "3.12.1"
    const val resizeSSPSDP = "1.0.6"
    const val cameraxVersion = "1.0.0-beta12"

    // Instrumented testing libraries
    const val espresso = "3.2.0"

    // Testing libraries
    const val junit = "4.13"
    const val junitExt = "1.1.1"
    const val mockito = "2.25.1"
    const val mockitoKotlin = "2.2.0"
    const val mockk = "1.9.3"
    const val robolectric = "4.3.1"
    const val testCore = "1.2.0"
    const val shimmer = "0.5.0"

    //compose
    const val compose = "1.0.5"
    const val composeTooling = "1.0.5"
    const val composeFoundation = "1.0.5"
    const val composeMaterialDesign = "1.0.5"
    const val composeMaterialDesignIcon = "1.0.0-beta01"
    const val composeActivity = "1.3.1"
    const val composeViewModel = "1.0.0-alpha02"
    const val composeLiveData = "1.0.0-beta01"
    const val composeRx = "1.0.0-beta01"
    const val composeUnitest = "1.0.0-beta01"
    const val composeConstraintLayout = "1.0.0-alpha03"

    //debugging
    const val flipperVersion = "0.92.0"
}

object AnnotationProcessors {
    const val autoValue = "com.google.auto.value:auto-value:${Versions.autoValue}"
    const val epoxy = "com.airbnb.android:epoxy-processor:${Versions.epoxy}"
    const val lifecycle = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
//    const val moshi = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
}

object Libraries {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val autoValue = "com.google.auto.value:auto-value-annotations:${Versions.autoValue}"
    const val mvrx = "com.airbnb.android:mavericks:${Versions.mavericks}"
    const val cardview = "androidx.cardview:cardview:${Versions.cardview}"
    const val viewPager2 = "androidx.viewpager2:viewpager2:${Versions.viewPager}"
    const val constraintlayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val coordinatorLayout =
        "androidx.coordinatorlayout:coordinatorlayout:${Versions.coordinatorLayout}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.core}"
    const val epoxy = "com.airbnb.android:epoxy:${Versions.epoxy}"
    const val espressoIdlingResource =
        "androidx.test.espresso:espresso-idling-resource:${Versions.espresso}"
    const val fragment = "androidx.fragment:fragment:${Versions.fragment}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val fragmentTesting = "androidx.fragment:fragment-testing:${Versions.fragment}"
    const val junit = "junit:junit:${Versions.junit}"
    const val koin = "io.insert-koin:koin-android:${Versions.koin}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val kotlinCoroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    const val lifecycleCommon = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
    const val lottie = "com.airbnb.android:lottie:${Versions.lottie}"

    //    const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
//    const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val multidex = "androidx.multidex:multidex:${Versions.multidex}"
    const val navigationFragmentKtx =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okHttp3 = "com.squareup.okhttp3:okhttp:${Versions.okHttp3}"
    const val okHttp3Log = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp3}"
    const val retrofitRxJava = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val viewModelSavedState =
        "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycle}"

    const val androidMaterial = "com.google.android.material:material:${Versions.material}"

    const val textSSP = "com.intuit.ssp:ssp-android:${Versions.resizeSSPSDP}"
    const val imageSDP = "com.intuit.sdp:sdp-android:${Versions.resizeSSPSDP}"

    const val shimmer = "com.facebook.shimmer:shimmer:${Versions.shimmer}"
    const val eventBus = "org.greenrobot:eventbus:${Versions.eventBus}"
    const val desugar = "com.android.tools:desugar_jdk_libs:${Versions.desugar}"

    object cameraX {
        const val cameraXcore = "androidx.camera:camera-core:${Versions.cameraxVersion}"
        const val cameraXcamera2 = "androidx.camera:camera-camera2:${Versions.cameraxVersion}"
        const val cameraXlifecycle = "androidx.camera:camera-lifecycle:${Versions.cameraxVersion}"
        const val cameraXview = "androidx.camera:camera-view:1.0.0-alpha18"
    }


    const val compose_ui = "androidx.compose.ui:ui:${Versions.compose}"
    const val compose_tooling = "androidx.compose.ui:ui-tooling:${Versions.composeTooling}"
    const val compose_foundation =
        "androidx.compose.foundation:foundation:${Versions.composeFoundation}"
    const val compose_materialDesign =
        "androidx.compose.material:material:${Versions.composeMaterialDesign}"
    const val compose_icon =
        "androidx.compose.material:material-icons-core:${Versions.composeMaterialDesignIcon}"
    const val compose_iconExtended =
        "androidx.compose.material:material-icons-extended:${Versions.composeMaterialDesignIcon}"
    const val compose_activity = "androidx.activity:activity-compose:${Versions.composeActivity}"
    const val compose_viewModel =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.composeViewModel}"
    const val compose_liveData =
        "androidx.compose.runtime:runtime-livedata:${Versions.composeLiveData}"
    const val compose_rx = "androidx.compose.runtime:runtime-rxjava2:${Versions.composeRx}"
    const val compose_constraint =
        "androidx.constraintlayout:constraintlayout-compose:${Versions.composeConstraintLayout}"
    const val compose_unitTest = "androidx.compose.ui:ui-test-junit4:${Versions.composeUnitest}"


}

object Debugging {
    const val flipperCore = "com.facebook.flipper:flipper:${Versions.flipperVersion}"
    const val flipperNetwork =
        "com.facebook.flipper:flipper-network-plugin:${Versions.flipperVersion}"
}

object InstrumentedTestLibraries {
    const val core = "androidx.test:core:${Versions.testCore}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val junit = "androidx.test.ext:junit:${Versions.junitExt}"
}

object TestLibraries {
    const val junit = "junit:junit:${Versions.junit}"
    const val kotlinCoroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinCoroutines}"
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val roboeletric = "org.robolectric:robolectric:${Versions.robolectric}"
}
