package vn.edu.khtn.googlemapsforseminar02;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class GGMapDirectionAPI extends AppCompatActivity {

    private ArrayList<LatLng> listStep;
    private PolylineOptions polyline;
    private GoogleMap map;
    private Button btnHCMUStoNguyenHue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ggmap_direction_api);
        map = ((MapFragment)getFragmentManager().findFragmentById(R.id.mapDirection)).getMap();
        map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        map.getUiSettings().setZoomControlsEnabled(true);
        map.setMyLocationEnabled(true);
        btnHCMUStoNguyenHue = (Button) findViewById(R.id.btnHCMUStoNguyenHue);


        listStep = new ArrayList<LatLng>();
        polyline = new PolylineOptions();


        LatLng KHTN = new LatLng(10.762643, 106.682079);
        LatLng PhoDiBoNguyenHue = new LatLng(10.774467, 106.703274);


        MarkerOptions option = new MarkerOptions();
        option.position(KHTN);
        option.title("Đại Học Khoa Học Tự Nhiên TP.HCM").snippet("Số 227 Nguyễn Văn Cừ, Quận 5");
        option.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        option.alpha(0.8f);
        option.rotation(0);
        Marker maker = map.addMarker(option);
        maker.showInfoWindow();
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(KHTN,17));

        MarkerOptions option2 = new MarkerOptions();
        option2.position(PhoDiBoNguyenHue);
        option2.title("Phố Đi Bộ Nguyễn Huệ").snippet("Quận 1 , TP.HCM");
        option2.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        option2.alpha(0.8f);
        option2.rotation(0);
        Marker maker2 = map.addMarker(option2);


        final AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {

                // 227 Nguyễn Văn Cừ : 10.762643, 106.682079
                // Phố đi bộ Nguyễn Huệ : 10.774467, 106.703274

                String request = makeURL("10.762643","106.682079","10.774467","106.703274");
                GetDirectionsTask task = new GetDirectionsTask(request);
                ArrayList<LatLng> list = task.testDirection();
                for (LatLng latLng : list) {
                    listStep.add(latLng);
                }
                return null;
            }
            @Override
            protected void onPostExecute(Void result) {
                // TODO Auto-generated method stub
                super.onPostExecute(result);
                polyline.addAll(listStep);
                Polyline line = map.addPolyline(polyline);
                line.setColor(Color.BLUE);
                line.setWidth(5);
            }
        };


        btnHCMUStoNguyenHue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task.execute();
            }
        });
    }

    public String makeURL (String sourcelat, String sourcelng, String destlat, String destlng ){
        StringBuilder urlString = new StringBuilder();
        urlString.append("https://maps.googleapis.com/maps/api/directions/json");
        urlString.append("?origin=");// from
        urlString.append(sourcelat);
        urlString.append(",");
        urlString.append(sourcelng);
        urlString.append("&destination=");// to
        urlString.append(destlat);
        urlString.append(",");
        urlString.append(destlng);
        urlString.append("&key="+getResources().getString(R.string.google_api_key));
        return urlString.toString();
    }
}
