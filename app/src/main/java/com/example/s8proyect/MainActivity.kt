package com.example.s8proyect

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var btnPopup: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.topAppBar)
        setSupportActionBar(toolbar)

        webView = findViewById(R.id.webView)
        btnPopup = findViewById(R.id.btnPopup)

        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.nba.com/lakers")

        // Registrar menú contextual
        registerForContextMenu(webView)

        // Popup Menu
        btnPopup.setOnClickListener { view ->
            val popup = PopupMenu(this, view)
            popup.menuInflater.inflate(R.menu.popup_menu, popup.menu)
            popup.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.popup_share -> {
                        val shareIntent = Intent(Intent.ACTION_SEND)
                        shareIntent.type = "text/plain"
                        shareIntent.putExtra(Intent.EXTRA_TEXT, webView.url)
                        startActivity(Intent.createChooser(shareIntent, "Compartir URL"))
                        true
                    }
                    R.id.popup_open_browser -> {
                        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(webView.url))
                        startActivity(browserIntent)
                        true
                    }
                    else -> false
                }
            }
            popup.show()
        }
    }

    // Options Menu (arriba)
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val url = when (item.itemId) {
            R.id.menu_lakers -> "https://www.nba.com/lakers"
            R.id.menu_warriors -> "https://www.nba.com/warriors"
            R.id.menu_celtics -> "https://www.nba.com/celtics"
            else -> return super.onOptionsItemSelected(item)
        }
        webView.loadUrl(url)
        return true
    }

    // Context Menu (long click)
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.setHeaderTitle("Opciones WebView")
        menu?.add(0, v?.id ?: 0, 0, "Recargar")
        menu?.add(0, v?.id ?: 0, 1, "Abrir en navegador")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.title) {
            "Recargar" -> webView.reload()
            "Abrir en navegador" -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(webView.url))
                startActivity(intent)
            }
        }
        return true
    }
}
