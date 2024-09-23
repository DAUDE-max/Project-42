package diagnosen;

public abstract class Diagnose {

    public String name;
    public String klasse;
    
    public int atemfrequenz;
    public int oxygenlevel;
    public int pulse;
    public int bloodpressure_t;
    public int bloodpressure_b;
    public int recaptime; 
    public int gcs;   
    public int bloodsugar;
    public int temperatur;

    //c
    public String blutung;
    public String sturz;
    
    //A
    public String mundraum;
    public String schleimhäute;

    //B
    public String azv;
    public String zyanose;
    public String atemgeräusch;

    //C
    public String pulsqualität;
    public String pulsrhytmus;
    public String lagerung;

    //STU
    public String stu_kopf;
    public String stu_hws;
    public String stu_brust;
    public String stu_bauch;
    public String stu_bauch_q1;
    public String stu_bauch_q2;
    public String stu_bauch_q3;
    public String stu_bauch_q4;
    public String stu_becken;
    public String stu_oberschenkel;
    public String stu_unterschänkel;
    public String stu_arme;
    public String stu_wirbelsäule;

    //D
    public String vierfach_wer;
    public String vierfach_wo;
    public String vierfach_wann;
    public String vierfach_was;
    public String isokor;
    public String lichtreagibel;
    public String decke;
    public String fast;

    //DMS
    public String dms_d_arm_l;
    public String dms_d_arm_r;
    public String dms_d_bein_l;
    public String dms_d_bein_r;
    public String dms_m_arm_l;
    public String dms_m_arm_r;
    public String dms_m_bein_l;
    public String dms_m_bein_r;
    public String dms_s_arm_l;
    public String dms_s_arm_r;
    public String dms_s_bein_l;
    public String dms_s_bein_r;

    //SAMPLER
    public String symptome;
    public String allergien;
    public String medikamente;
    public String patientengeschichte;
    public String letzte_mahlzeit;
    public String ereigniss;
    public String risikofaktoren;

    //OPQRST
    public String onset;
    public String provocation;
    public String quality;
    public String radiation;
    public String strength;
    public String time;          

    //Orga
    public String alarm;
    public String sichtung;

    //Maßnahmen
    public void mundraum_reumen(){};
    public void blutung_stillen(){};
    public void sauerstoff_geben(int liter){};
    public void lippenbremse(){};
    public void assistiert_beatmen(){};
    public void hochlagern(){};
    public void flachlagern(){};
    public void schocklage(){};
    public void absaugbereitschft(){};
    public void stabile_seitenlage(){};
    public void hws_immobilisieren(){};
    public void lokal_immobilisieren(){};
    public void notarzt_nachfordern(){};
    public void entkleiden(){};
    public void zudecken(){};
    public void asservieren(){};
    public void load_and_go(){};
    public void intubation_vorbereiten(){};
    public void infusion_vorbereiten(String station){};

    

























}
