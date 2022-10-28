<h1>Cat Images App</h1>
<p>The app showcase images of cats with staggered grid view</p>
<hr>
<h3>Used Technologies</h3>
<ul>
  <li>Kotlin</li>
  <li>Retrofit 2</li>
  <li>Dagger Hilt injection</li>
  <li>Data binding</li>
  <li>Recycler View</li>
</ul>  
<hr>
<h3>Implimentations of Dependencies in project</h3>

    def jetpack_version = "2.1.0"

    //legacy support
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'

    // dagger hilt
    implementation "com.google.dagger:hilt-android:2.41"
    kapt "com.google.dagger:hilt-compiler:2.41"

    // networking
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation 'com.google.code.gson:gson:2.8.9'
    implementation "com.squareup.okhttp3:okhttp:5.0.0-alpha.2"
    implementation "com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2"

    // Image Loading
    implementation "io.coil-kt:coil:1.4.0"

    // Coroutine and Lifecycle
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1'
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.6.1'
    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1'
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:2.5.1"
    implementation "androidx.fragment:fragment-ktx:1.5.2"

    //dimens
    implementation 'com.intuit.sdp:sdp-android:1.0.6'

    //paging
    def paging_version = "3.0.0"
    implementation "androidx.paging:paging-runtime:$paging_version"
