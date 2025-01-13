module imd.principal.sebolunarfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens imd.principal.sebolunarfx to javafx.fxml;
    exports imd.principal.sebolunarfx;
    exports imd.principal.sebolunarfx.controllers;
    opens imd.principal.sebolunarfx.controllers to javafx.fxml;
}