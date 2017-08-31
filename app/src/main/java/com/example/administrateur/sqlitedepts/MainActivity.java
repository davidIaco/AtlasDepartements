package com.example.administrateur.sqlitedepts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;
import static com.example.administrateur.sqlitedepts.Tools.datToStr;

public class MainActivity extends AppCompatActivity {

    Departements dept;

    private EditText txtNoDept, txtNoRegion, txtNom, txtNomStd, txtSurface, txtDateCreation, txtChefLieu, txtUrlWiki, txtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSearch = (EditText) findViewById(R.id.txtSearch);
        txtNoDept = (EditText) findViewById(R.id.txtNoDept);
        txtNoRegion = (EditText) findViewById(R.id.txtNoRegion);
        txtNom = (EditText) findViewById(R.id.txtNom);
        txtNomStd = (EditText) findViewById(R.id.txtNomStd);
        txtSurface = (EditText) findViewById(R.id.txtSurface);
        txtDateCreation = (EditText) findViewById(R.id.txtDateCreation);
        txtChefLieu = (EditText) findViewById(R.id.txtChefLieu);
        txtUrlWiki = (EditText) findViewById(R.id.txtUrlWiki);
    }

    public void btnSearch(View v) {

        String search = txtSearch.getText().toString();

        try {

            dept = new Departements(this, search);

            txtNoDept.setText(dept.getNoDept());
            txtNoRegion.setText(String.valueOf(dept.getNoRegion()));
            txtNom.setText(dept.getNom());
            txtNomStd.setText(dept.getNomStd());
            txtSurface.setText(String.valueOf(dept.getSurface()));
            txtDateCreation.setText(datToStr(dept.getDateCreation()));
            txtChefLieu.setText(dept.getChefLieu());
            txtUrlWiki.setText(dept.getUrlWiki());

            txtNoDept.setEnabled(false);

        } catch (Exception ex) {

            Toast.makeText(this, ex.getMessage(), LENGTH_LONG).show();
        }
    }

    public void btnSave(View v) throws Exception {

        dept = new Departements(this);

        dept.setNoDept(txtNoDept.getText().toString());
        dept.setNom(txtNom.getText().toString());
        dept.setNomStd(txtNomStd.getText().toString());
        dept.setNoRegion(Integer.parseInt(txtNoRegion.getText().toString()));
        dept.setSurface(Integer.parseInt(txtSurface.getText().toString()));
        dept.setChefLieu(txtChefLieu.getText().toString());
        dept.setDateCreation(txtDateCreation.getText().toString());
        dept.setUrlWiki(txtUrlWiki.getText().toString());

        try {
            Departements d2 = new Departements(this, txtNoDept.getText().toString());

            dept.update();
            Toast.makeText(this, "mis a jour", Toast.LENGTH_LONG).show();

        } catch (Exception ex) {

            try {

                dept.insert();
                Toast.makeText(this, "insertion", Toast.LENGTH_LONG).show();

            } catch (Exception ex2) {

                Toast.makeText(this, "????", LENGTH_LONG).show();
            }
            Toast.makeText(this, "Département ajouté", LENGTH_LONG).show();
        }
    }


    public void btnClear(View v) {

        txtNoDept.setText("");
        txtNoRegion.setText("");
        txtNom.setText("");
        txtNomStd.setText("");
        txtSurface.setText("");
        txtDateCreation.setText("");
        txtChefLieu.setText("");
        txtUrlWiki.setText("");
        txtSearch.setText("");

        txtNoDept.setEnabled(true);

    }

    public void btnDelete(View v) throws Departements.DbException {

        dept = new Departements(this);

        dept.setNoDept(txtNoDept.getText().toString());

        try {

            dept.delete();

        } catch (Exception ex) {

            Toast.makeText(this, ex.getMessage(), LENGTH_LONG).show();
        }

        btnClear(v);
    }
}
