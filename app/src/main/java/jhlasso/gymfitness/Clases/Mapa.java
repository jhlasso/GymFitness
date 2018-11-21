package jhlasso.gymfitness.Clases;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.MinimapOverlay;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.ArrayList;

import jhlasso.gymfitness.R;

public class Mapa extends AppCompatActivity {

    private MapView myOpenMapView;
    private MapController myMapController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        GeoPoint musclemania = new GeoPoint(1.217771,-77.281098);
        GeoPoint sport = new GeoPoint(1.222146,-77.280739);
        GeoPoint silver = new GeoPoint(1.217729,-77.278179);
        GeoPoint atlas = new GeoPoint(1.212269,-77.282835);

        GeoPoint body = new GeoPoint(4.692825,-74.033254);
        GeoPoint smart = new GeoPoint(4.617286,-74.087136);
        GeoPoint hard = new GeoPoint(4.664718,-74.118744);
        GeoPoint stark = new GeoPoint(4.703583,-74.029105);

        GeoPoint bodyM = new GeoPoint(6.249976,-75.564438);
        GeoPoint smartM = new GeoPoint(6.240303,-75.586580);
        GeoPoint action = new GeoPoint(6.256514,-75.583094);
        GeoPoint santillana = new GeoPoint(6.202629,-75.574314);

        myOpenMapView = (MapView) findViewById(R.id.openmapview);
        myOpenMapView.setBuiltInZoomControls(true);
        myMapController = (MapController) myOpenMapView.getController();
        myMapController.setCenter(musclemania);
        myMapController.setZoom(6);

        //Puntos

        ArrayList<OverlayItem> puntos = new ArrayList<OverlayItem>();
        puntos.add(new OverlayItem("Bogota", "Gimnasio Bodytech", body));
        puntos.add(new OverlayItem("Bogota", "Gimnasio SmartFit", smart));
        puntos.add(new OverlayItem("Bogota", "Gimnasio Hard Body", hard));
        puntos.add(new OverlayItem("Bogota", "Gimnasio Stark", stark));

        puntos.add(new OverlayItem("Pasto", "Gimnasio Musclemania", musclemania));
        puntos.add(new OverlayItem("Pasto", "Gimnasio Sport Body", sport));
        puntos.add(new OverlayItem("Pasto", "Gimnasio Silver", silver));
        puntos.add(new OverlayItem("Pasto", "Gimnasio Atlas", atlas));

        puntos.add(new OverlayItem("Pasto", "Gimnasio Bodytech", bodyM));
        puntos.add(new OverlayItem("Pasto", "Gimnasio SmartFit", smartM));
        puntos.add(new OverlayItem("Pasto", "Gimnasio Action", action));
        puntos.add(new OverlayItem("Pasto", "Gimnasio Santillana", santillana));


        ItemizedIconOverlay.OnItemGestureListener<OverlayItem> tap = new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemLongPress(int arg0, OverlayItem arg1) {
                return false;
            }
            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                return true;
            }
        };

        ItemizedOverlayWithFocus<OverlayItem> capa = new ItemizedOverlayWithFocus<OverlayItem>(this, puntos, tap);
        capa.setFocusItemsOnTap(true);
        myOpenMapView.getOverlays().add(capa);

        MinimapOverlay miniMapOverlay = new MinimapOverlay(this, myOpenMapView.getTileRequestCompleteHandler());
        miniMapOverlay.setZoomDifference(5);
        miniMapOverlay.setHeight(200);
        miniMapOverlay.setWidth(200);
        myOpenMapView.getOverlays().add(miniMapOverlay);
    }
}
