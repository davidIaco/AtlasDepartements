package com.example.administrateur.sqlitedepts;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.example.administrateur.sqlitedepts.Tools.datToSql;
import static com.example.administrateur.sqlitedepts.Tools.sqlToDat;

public class Departements {

    private int noRegion, surface;
    private String noDept, nom, nomStd, chefLieu, urlWiki;
    private Date dateCreation;


    private final String TAB_NAME = "departements";

    private Context ctxt;
    private SQLiteDatabase db;

    public Departements (Context ctxt) {

        this.ctxt = ctxt;

        DbInit initDb = DbInit.getInstance( ctxt);
        db = initDb.getWritableDatabase();

    }

    public Departements (Context ctxt, String noDept) throws Exception {

        this (ctxt);  // Appel du premier constructeur

        select(noDept);
    }

    public void select ( String name) throws Exception {

        String[] colonnes = {"no_dept", "no_region", "nom", "nom_std", "surface", "date_creation", "chef_lieu", "url_wiki"};
        Cursor curs = db.query(false, TAB_NAME, colonnes, "no_dept ='" + name + "'", null, null, null, null, null);

        if (curs.moveToFirst()) {

            this.noDept = curs.getString(0);
            this.noRegion = curs.getInt(1);
            this.nom = curs.getString(2);
            this.nomStd = curs.getString(3);
            this.surface = curs.getInt(4);

            try {
                this.dateCreation = sqlToDat(curs.getString(5));
            } catch (Exception ex) {}
            this.chefLieu = curs.getString(6);
            this.urlWiki = curs.getString(7);

        } else {

            throw new DbDeptNotFoundException();

        }
    }

    public void delete () throws  Exception {

        if (this.noDept.equals("")) {

            throw new DbException("Département non initialisé");
        }
        String where = "no_dept= '" + noDept + "'";

        db.delete( TAB_NAME, where, null);

    }

    public void update () throws Exception {

        String where = "no_dept = " + getNoDept();

        ContentValues values = new ContentValues();

        values.put("no_dept", noDept);
        values.put("no_region", noRegion);
        values.put("nom", nom);
        values.put("nom_std", nomStd);
        values.put("no_region", noRegion);
        values.put("surface", surface);
        values.put("date_creation", datToSql(dateCreation));
        values.put("chef_lieu", chefLieu);
        values.put("url_wiki", urlWiki);

        db.update(TAB_NAME, values, where, null);

    }

    public void insert () throws Exception {

        ContentValues values = new ContentValues();

        values.put("no_dept", noDept);
        values.put("no_region", noRegion);
        values.put("nom", nom);
        values.put("nom_std", nomStd);
        values.put("no_region", noRegion);
        values.put("surface", surface);
        values.put("date_creation", datToSql(dateCreation));
        values.put("chef_lieu", chefLieu);
        values.put("url_wiki", urlWiki);

        db.insert(TAB_NAME, null, values);

    }

    public int getNoRegion() {
        return noRegion;
    }

    public void setNoRegion(int noRegion) {
        this.noRegion = noRegion;
    }

    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public String getNoDept() {
        return noDept;
    }

    public void setNoDept(String noDept) throws DbException {

        if (noDept.equals("")) {

            throw new DbException ("Numero Département invalide");
        }

        Pattern pattern = Pattern.compile("[0-9] [0-9AB] [0-9]?");
        Matcher matcher = pattern.matcher(noDept);

        if (matcher.find()) {
            throw new DbException("Numero Département invalide");
        }
        this.noDept = noDept;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomStd() {
        return nomStd;
    }

    public void setNomStd(String nomStd) {
        this.nomStd = nomStd;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String value) throws Exception {
        dateCreation = Tools.strToDat(value);
    }

    public String getChefLieu() {
        return chefLieu;
    }

    public void setChefLieu(String chefLieu) {
        this.chefLieu = chefLieu;
    }

    public String getUrlWiki() {
        return urlWiki;
    }

    public void setUrlWiki(String urlWiki) {
        this.urlWiki = urlWiki;
    }


    public class DbException extends Exception {

        public DbException (String msg) {

            super(msg);
        }

        public  DbException ( Context ctxt, int stringId) {

            super (ctxt.getString(stringId));
        }
    }

    public class DbDeptNotFoundException extends Exception {

        public DbDeptNotFoundException() {

            super("Département non trouvé");
        }
    }


}
