module imd.principal.sebolunarfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens imd.principal.sebolunarfx to javafx.fxml;
    exports imd.principal.sebolunarfx;
}