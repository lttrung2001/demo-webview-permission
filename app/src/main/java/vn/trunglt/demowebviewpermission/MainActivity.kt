package vn.trunglt.demowebviewpermission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.PermissionRequest
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import vn.trunglt.demowebviewpermission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.root.apply {
            settings.apply {
                layoutAlgorithm = WebSettings.LayoutAlgorithm.SINGLE_COLUMN
                loadWithOverviewMode = true
                useWideViewPort = true
                setSupportZoom(true)
                builtInZoomControls = true
                allowFileAccess = true
                allowFileAccessFromFileURLs = true
                javaScriptEnabled = true
                domStorageEnabled = true
                cacheMode= WebSettings.LOAD_NO_CACHE
                displayZoomControls = false
                mediaPlaybackRequiresUserGesture = false
                allowUniversalAccessFromFileURLs = true
                javaScriptCanOpenWindowsAutomatically = true
            }
            webChromeClient = object: WebChromeClient() {
                override fun onPermissionRequest(request: PermissionRequest?) {
                    println(request?.resources)
                    request?.grant(request.resources)
                }
            }
            loadUrl("https://webcamtests.com/mirror")
        }
    }
}