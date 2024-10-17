package dev.dao;

import dev.entite.Plat;

import java.util.ArrayList;
import java.util.List;

public class PlatDaoMemoire implements IPlatDao {

    private List<Plat> listePlats = new ArrayList<>();

    @Override
    public List<Plat> listerPlats() {
        return listePlats;
    }

    @Override
    public void ajouterPlat(String nomPlat, Integer prixPlat) {
        String nomPlatEnMajuscules = nomPlat.toUpperCase();

        Plat nouveauPlat = new Plat(nomPlatEnMajuscules, prixPlat);
        listePlats.add(nouveauPlat);
    }
}
