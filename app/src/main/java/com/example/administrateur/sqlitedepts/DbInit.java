package com.example.administrateur.sqlitedepts;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbInit extends SQLiteOpenHelper {

    private static Context ctxt;

    public DbInit(Context ctxt, String name, int version) {

        super(ctxt, name, null, version);
        this.ctxt = ctxt;
    }

    private static DbInit instance;
    public static DbInit getInstance( Context ctxt) {

        if ( instance == null) {

            instance = new DbInit( ctxt, "geo", 1);
        }
        return instance;
    }


    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "CREATE TABLE regions (" +
                "   no_region INTEGER PRIMARY KEY NOT NULL" +
                ",  nom TEXT NOT NULL" +
                ")";

        db.execSQL(sql);

        sql = "CREATE TABLE departements (" +
                "   no_dept TEXT PRIMARY KEY NOT NULL" +
                ",  no_region INTEGER" +
                ",  nom TEXT NOT NULL" +
                ",  nom_std TEXT NOT NULL" +
                ",  surface INTEGER" +
                ",  date_creation TEXT" +
                ",  chef_lieu TEXT" +
                ",  url_wiki TEXT" +
                ",  FOREIGN KEY(no_region) REFERENCES Regions(no_region)" + ")";
        db.execSQL(sql);

        db.execSQL("INSERT INTO Regions (no_region, nom) VALUES (11,'Île-de-France')");
        db.execSQL("INSERT INTO Regions (no_region, nom) VALUES (21,'Champagne-Ardenne')");
        db.execSQL("INSERT INTO Regions (no_region, nom) VALUES (22,'Picardie')");
        db.execSQL("INSERT INTO Regions (no_region, nom) VALUES (23,'Haute-Normandie')");
        db.execSQL("INSERT INTO Regions (no_region, nom) VALUES (24,'Centre')");
        db.execSQL("INSERT INTO Regions (no_region, nom) VALUES (25,'Basse-Normandie')");
        db.execSQL("INSERT INTO Regions (no_region, nom) VALUES (26,'Bourgogne')");
        db.execSQL("INSERT INTO Regions (no_region, nom) VALUES (31,'Nord-Pas-de-Calais')");
        db.execSQL("INSERT INTO Regions (no_region, nom) VALUES (41,'Lorraine')");
        db.execSQL("INSERT INTO Regions (no_region, nom) VALUES (42,'Alsace')");
        db.execSQL("INSERT INTO Regions (no_region, nom) VALUES (43,'Franche-Comté')");
        db.execSQL("INSERT INTO Regions (no_region, nom) VALUES (52,'Pays de la Loire')");
        db.execSQL("INSERT INTO Regions (no_region, nom) VALUES (53,'Bretagne')");
        db.execSQL("INSERT INTO Regions (no_region, nom) VALUES (54,'Poitou-Charentes')");
        db.execSQL("INSERT INTO Regions (no_region, nom) VALUES (72,'Aquuitaine')");
        db.execSQL("INSERT INTO Regions (no_region, nom) VALUES (73,'Midi-Pyrénées')");
        db.execSQL("INSERT INTO Regions (no_region, nom) VALUES (74,'Limousin')");
        db.execSQL("INSERT INTO Regions (no_region, nom) VALUES (82,'Rhône-Alpes')");
        db.execSQL("INSERT INTO Regions (no_region, nom) VALUES (83,'Auvergne')");
        db.execSQL("INSERT INTO Regions (no_region, nom) VALUES (91,'Languedoc-Roussillon')");
        db.execSQL("INSERT INTO Regions (no_region, nom) VALUES (93,'Provence-Alpes-Côte d''Azur')");
        db.execSQL("INSERT INTO Regions (no_region, nom) VALUES (94,'Corse')");
        db.execSQL("INSERT INTO Regions (no_region, nom) VALUES (97,'DOM')");

        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('01','82','Ain','AIN','5762','1790-03-04T12:00:00','Bourg-en-Bresse','http://fr.wikipedia.org/wiki/Ain_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('02','22','Aisne','AISNE','7369','1790-03-04T12:00:00','Laon','http://fr.wikipedia.org/wiki/Aisne_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('03','83','Allier ','ALLIER','7340','1790-03-04T12:00:00','Moulins','http://fr.wikipedia.org/wiki/Allier_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('04','93','Alpes-de-Haute-Provence','ALPES DE HAUTE PROVENCE','6925','1790-03-04T12:00:00','Digne','http://fr.wikipedia.org/wiki/Alpes-de-Haute-Provence')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('05','93','Alpes (Hautes)','HAUTES ALPES','5549','1790-03-04T12:00:00','Gap','http://fr.wikipedia.org/wiki/Hautes-Alpes')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('06','93','Alpes-Maritimes','ALPES MARITIMES','4299','1860-06-14T12:00:00','Nice','http://fr.wikipedia.org/wiki/Alpes-Maritimes')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('07','82','Ardéche','ARDECHE','5529','1790-03-04T12:00:00','Privas','http://fr.wikipedia.org/wiki/Ard%C3%A8che_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('08','21','Ardennes','ARDENNES','5229','1790-03-04T12:00:00','Charleville-Mézières','http://fr.wikipedia.org/wiki/Ardennes_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('09','73','Ariége','ARIEGE','4890','1790-03-04T12:00:00','Foix','http://fr.wikipedia.org/wiki/Ari%C3%A8ge_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('10','21','Aube','AUBE','6004','1790-03-04T12:00:00','Troyes','http://fr.wikipedia.org/wiki/Aube_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('11','91','Aude','AUDE','6139','1790-03-04T12:00:00','Carcassonne','http://fr.wikipedia.org/wiki/Aude_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('12','73','Aveyron','AVEYRON','8735','1790-03-04T12:00:00','Rodez','http://fr.wikipedia.org/wiki/Aveyron_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('13','93','Bouches-du-Rhône','BOUCHES DU RHONE','5087','1790-03-04T12:00:00','Marseille','http://fr.wikipedia.org/wiki/Bouches-du-Rh%C3%B4ne')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('14','25','Calvados','CALVADOS','5548','1790-03-04T12:00:00','Caen','http://fr.wikipedia.org/wiki/Calvados_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('15','83','Cantal','CANTAL','5726','1790-03-04T12:00:00','Aurillac','http://fr.wikipedia.org/wiki/Cantal_%28d%C3%A9partement%29')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('16','54','Charente','CHARENTE','5956','1790-03-04T12:00:00','Angoulême','http://fr.wikipedia.org/wiki/Charente_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('17','54','Charente-Maritime','CHARENTE MARITIME','6864','1790-03-04T12:00:00','La Rochelle','http://fr.wikipedia.org/wiki/Charente-Maritime')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('18','24','Cher','CHER','7235','1790-03-04T12:00:00','Bourges','http://fr.wikipedia.org/wiki/Cher_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('19','74','Corréze','CORREZE','5857','1790-03-04T12:00:00','Tulle','http://fr.wikipedia.org/wiki/Corr%C3%A8ze_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('21','26','Côte d''or','COTE D''OR','8763','1790-03-04T12:00:00','Dijon','http://fr.wikipedia.org/wiki/C%C3%B4te-d%27Or')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('22','53','Côtes d''armor','COTES D''ARMOR','6878','1790-03-04T12:00:00','St-Brieuc','http://fr.wikipedia.org/wiki/C%C3%B4tes-d%27Armor')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('2A','94','Corse du sud','CORSE DU SUD','4014','1976-01-01T12:00:00','Ajaccio','http://fr.wikipedia.org/wiki/Corse-du-Sud')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('2B','94','Haute corse','HAUTE CORSE','4666','1976-01-01T12:00:00','Bastia','http://fr.wikipedia.org/wiki/Haute-Corse')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('23','74','Creuse','CREUSE','5565','1790-03-04T12:00:00','Guéret','http://fr.wikipedia.org/wiki/Creuse_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('24','72','Dordogne','DORDOGNE','9060','1790-03-04T12:00:00','Périgueux','http://fr.wikipedia.org/wiki/Dordogne_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('25','43','Doubs','DOUBS','5234','1790-03-04T12:00:00','Besançon','http://fr.wikipedia.org/wiki/Doubs_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('26','82','Drôme','DROME','6530','1790-03-04T12:00:00','Valence','http://fr.wikipedia.org/wiki/Dr%C3%B4me_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('27','23','Eure','EURE','6040','1790-03-04T12:00:00','Evreux','http://fr.wikipedia.org/wiki/Eure_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('28','24','Eure et Loir','EURE ET LOIR','5880','1790-03-04T12:00:00','Chartres','http://fr.wikipedia.org/wiki/Eure-et-Loir')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('29','53','Finistére','FINISTERE','6733','1790-03-04T12:00:00','Quimper','http://fr.wikipedia.org/wiki/Finist%C3%A8re')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('30','91','Gard','GARD','5853','1790-03-04T12:00:00','Nîmes','http://fr.wikipedia.org/wiki/Gard')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('31','73','Garonne (Haute)','HAUTE GARONNE','6309','1790-03-04T12:00:00','Toulouse','http://fr.wikipedia.org/wiki/Haute-Garonne')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('32','73','Gers','GERS','6257','1790-03-04T12:00:00','Auch','http://fr.wikipedia.org/wiki/Gers_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('33','72','Gironde','GIRONDE','10725','1790-03-04T12:00:00','Bordeaux','http://fr.wikipedia.org/wiki/Gironde_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('34','91','Hérault','HERAULT','6224','1790-03-04T12:00:00','Montpellier','http://fr.wikipedia.org/wiki/H%C3%A9rault_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('35','53','Ile et Vilaine','ILE ET VILAINE','6775','1790-03-04T12:00:00','Rennes','http://fr.wikipedia.org/wiki/Ille-et-Vilaine')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('36','24','Indre','INDRE','6903','1790-03-04T12:00:00','Châteauroux','http://fr.wikipedia.org/wiki/Indre_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('37','24','Indre et Loire','INDRE ET LOIRE','6127','1790-03-04T12:00:00','Tours','http://fr.wikipedia.org/wiki/Indre-et-Loire')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('38','82','Isére','ISERE','7431','1790-03-04T12:00:00','Grenoble','http://fr.wikipedia.org/wiki/Is%C3%A8re_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('39','43','Jura','JURA','4999','1790-03-04T12:00:00','Lons-le-Saunier','http://fr.wikipedia.org/wiki/Jura_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('40','72','Landes','LANDES','9243','1790-03-04T12:00:00','Mont-de-Marsan','http://fr.wikipedia.org/wiki/Landes_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('41','24','Loir et Cher','LOIR ET CHER','6343','1790-03-04T12:00:00','Blois','http://fr.wikipedia.org/wiki/Loir-et-Cher')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('42','82','Loire','LOIRE','4781','1793-08-12T12:00:00','St-Étienne','http://fr.wikipedia.org/wiki/Loire_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('43','83','Loire (Haute)','HAUTRE LOIRE','4977','1790-03-04T12:00:00','Le Puy','http://fr.wikipedia.org/wiki/Haute-Loire')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('44','52','Loire Atlantique','LOIRE ATLANTIQUE','6815','1790-03-04T12:00:00','Nantes','http://fr.wikipedia.org/wiki/Loire-Atlantique')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('45','24','Loiret','LOIRET','6775','1790-03-04T12:00:00','Orléans','http://fr.wikipedia.org/wiki/Loiret_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('46','73','Lot','LOT','5217','1790-03-04T12:00:00','Cahors','http://fr.wikipedia.org/wiki/Lot_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('47','72','Lot et Garonne','LOT ET GARONNE','5361','1790-03-04T12:00:00','Agen','http://fr.wikipedia.org/wiki/Lot-et-Garonne')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('48','91','Lozére','LOZERE','5167','1790-03-04T12:00:00','Mende','http://fr.wikipedia.org/wiki/Loz%C3%A8re_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('49','52','Maine et Loire','MAINE ET LOIRE','7166','1790-03-04T12:00:00','Angers','http://fr.wikipedia.org/wiki/Maine-et-Loire')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('50','25','Manche','MANCHE','5938','1790-03-04T12:00:00','St-Lô','http://fr.wikipedia.org/wiki/Manche_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('51','21','Marne','MARNE','8162','1790-03-04T12:00:00','Châlons-sur-Marne','http://fr.wikipedia.org/wiki/Marne_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('52','21','Marne (Haute)','HAUTE MARNE','6211','1790-03-04T12:00:00','Chaumont','http://fr.wikipedia.org/wiki/Haute-Marne')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('53','52','Mayenne','MAYENNE','5175','1790-03-04T12:00:00','Laval','http://fr.wikipedia.org/wiki/Mayenne_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('54','41','Meurthe et Moselle','MEURTHE ET MOSELLE','5246','1871-09-07T12:00:00','Nancy','http://fr.wikipedia.org/wiki/Meurthe-et-Moselle')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('55','41','Meuse','MEUSE','6211','1790-03-04T12:00:00','Bar-le-Duc','http://fr.wikipedia.org/wiki/Meuse_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('56','53','Morbihan','MORBIHAN','6823','1790-03-04T12:00:00','Vannes','http://fr.wikipedia.org/wiki/Morbihan')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('57','41','Moselle','MOSELLE','6216','1919-06-28T12:00:00','Metz','http://fr.wikipedia.org/wiki/Moselle_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('58','26','Niévre','NIEVRE','6817','1790-03-04T12:00:00','Nevers','http://fr.wikipedia.org/wiki/Ni%C3%A8vre_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('59','31','Nord','NORD','5743','1790-03-04T12:00:00','Lille','http://fr.wikipedia.org/wiki/Nord_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('60','22','Oise','OISE','5860','1790-03-04T12:00:00','Beauvais','http://fr.wikipedia.org/wiki/Oise_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('61','25','Orne','ORNE','6103','1790-03-04T12:00:00','Alençon','http://fr.wikipedia.org/wiki/Orne_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('62','31','Pas de Calais','PAS DE CALAIS','6671','1790-03-04T12:00:00','Arras','http://fr.wikipedia.org/wiki/Pas-de-Calais')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('63','83','Puy de Dôme','PUY DE DOME','7970','1790-03-04T12:00:00','Clermont-Ferrand','http://fr.wikipedia.org/wiki/Puy-de-D%C3%B4me')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('64','72','Pyrénées Atlantiques','PYRENEES ATLANTIQUES','7645','1790-03-04T12:00:00','Pau','http://fr.wikipedia.org/wiki/Pyr%C3%A9n%C3%A9es-Atlantiques')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('65','73','Pyrénées (Hautes)','HAUTES PYRENEES','4464','1790-03-04T12:00:00','Tarbes','http://fr.wikipedia.org/wiki/Hautes-Pyr%C3%A9n%C3%A9es')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('66','91','Pyrénées Orientales','PYRENEES ORIENTALES','4116','1790-03-04T12:00:00','Perpignan','http://fr.wikipedia.org/wiki/Pyr%C3%A9n%C3%A9es-Orientales')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('67','42','Rhin (Bas)','BAS RHIN','4755','1790-03-04T12:00:00','Strasbourg','http://fr.wikipedia.org/wiki/Bas-Rhin')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('68','42','Rhin (Haut)','HAUT RHIN','3525','1790-03-04T12:00:00','Colmar','http://fr.wikipedia.org/wiki/Haut-Rhin')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('69','82','Rhône','RHONE','3249','1793-08-12T12:00:00','Lyon','http://fr.wikipedia.org/wiki/Rh%C3%B4ne_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('70','43','Saône (Haute)','HAUTE SAONE','5360','1790-03-04T12:00:00','Vesoul','http://fr.wikipedia.org/wiki/Haute-Sa%C3%B4ne')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('71','26','Saône et Loire','SAONE ET LOIRE','8575','1790-03-04T12:00:00','Mâcon','http://fr.wikipedia.org/wiki/Sa%C3%B4ne-et-Loire')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('72','52','Sarthe','SARTHE','6206','1790-03-04T12:00:00','Le Mans','http://fr.wikipedia.org/wiki/Sarthe_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('73','82','Savoie','SAVOIE','6028','1860-06-15T12:00:00','Chambéry','http://fr.wikipedia.org/wiki/Savoie_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('74','82','Savoie (Haute)','HAUTE SAVOIE','4388','1860-06-14T12:00:00','Annecy','http://fr.wikipedia.org/wiki/Haute-Savoie')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('75','11','Paris','PARIS','105',Null,'Paris','http://fr.wikipedia.org/wiki/Paris')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('76','23','Seine Maritime','SEINE MARITIME','6278','1790-03-04T12:00:00','Rouen','http://fr.wikipedia.org/wiki/Seine-Maritime')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('77','11','Seine et Marne','SEINE ET MARNE','5915','1790-03-04T12:00:00','Melun','http://fr.wikipedia.org/wiki/Seine-et-Marne')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('78','11','Yvelines','YVELINES','2284','1968-01-01T12:00:00','Versailles','http://fr.wikipedia.org/wiki/Yvelines')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('79','54','Sèvres (Deux)','DEUX SEVRES','5999','1790-03-04T12:00:00','Niort','http://fr.wikipedia.org/wiki/Deux-S%C3%A8vres')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('80','22','Somme','SOMME','6170','1790-03-04T12:00:00','Amiens','http://fr.wikipedia.org/wiki/Somme_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('81','73','Tarn','TARN','5758','1790-03-04T12:00:00','Albi','http://fr.wikipedia.org/wiki/Tarn_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('82','73','Tarn et Garonne','TARN ET GARONNE','3718','1808-11-21T12:00:00','Montauban','http://fr.wikipedia.org/wiki/Tarn-et-Garonne')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('83','93','Var','VAR','5973','1790-03-04T12:00:00','Toulon','http://fr.wikipedia.org/wiki/Var_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('84','93','Vaucluse','VAUCLUSE','3567','1793-08-12T12:00:00','Avignon','http://fr.wikipedia.org/wiki/Vaucluse_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('85','52','Vendée','VENDEE','6720','1790-03-04T12:00:00','La Roche-sur-Yon','http://fr.wikipedia.org/wiki/Vend%C3%A9e_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('86','54','Vienne','VIENNE','6990','1790-03-04T12:00:00','Poitiers','http://fr.wikipedia.org/wiki/Vienne_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('87','74','Vienne (Haute)','HAUTE VIENNE','5520','1790-03-04T12:00:00','Limoges','http://fr.wikipedia.org/wiki/Haute-Vienne')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('88','41','Vosges','VOSGES','5874','1790-03-04T12:00:00','Épinal','http://fr.wikipedia.org/wiki/Vosges_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('89','26','Yonne','YONNE','7427','1790-03-04T12:00:00','Auxerre','http://fr.wikipedia.org/wiki/Yonne_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('90','43','Belfort (Territoire de)','TERRITOIRE DE BELFORT','609','1922-01-01T12:00:00','Belfort','http://fr.wikipedia.org/wiki/Territoire_de_Belfort')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('91','11','Essonne','ESSONNE','1804','1968-01-01T12:00:00','Evry','http://fr.wikipedia.org/wiki/Essonne_(d%C3%A9partement)')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('92','11','Hauts de Seine','HAUTS DE SEINE','176','1968-01-01T12:00:00','Nanterre','http://fr.wikipedia.org/wiki/Hauts-de-Seine')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('93','11','Seine Saint Denis','SEINE SAINT DENIS','236','1968-01-01T12:00:00','Bobigny','http://fr.wikipedia.org/wiki/Seine-Saint-Denis')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('94','11','Val de Marne','VAL DE MARNE','245','1968-01-01T12:00:00','Créteil','http://fr.wikipedia.org/wiki/Val-de-Marne')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('95','11','Val d''oise','VAL D''OISE','1246','1968-01-01T12:00:00','Pontoise','http://fr.wikipedia.org/wiki/Val-d%27Oise')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('976','97','Mayotte','MAYOTTE','376',Null,'Mamoudzou','http://fr.wikipedia.org/wiki/Mayotte')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('971','97','Guadeloupe','GUADELOUPE','1628',Null,'Basse-Terre','http://fr.wikipedia.org/wiki/Guadeloupe')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('973','97','Guyane','GUYANE','83846',Null,'Cayenne','http://fr.wikipedia.org/wiki/Guyane')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('972','97','Martinique','MARTINIQUE','1128',Null,'Fort-de-France','http://fr.wikipedia.org/wiki/Martinique')");
        db.execSQL("INSERT INTO departements (no_dept,no_region,nom,nom_std,surface,date_creation,chef_lieu,url_wiki) values ('974','97','Réunion','REUNION','2512',Null,'Saint-Denis','http://fr.wikipedia.org/wiki/La_R%C3%A9union')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
