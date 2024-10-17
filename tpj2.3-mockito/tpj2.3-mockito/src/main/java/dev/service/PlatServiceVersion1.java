package dev.service;

import dev.dao.IPlatDao;
import dev.entite.Plat;
import dev.exception.PlatException;

import java.util.List;
import java.util.stream.Collectors;

public class PlatServiceVersion1 implements IPlatService {

    private IPlatDao dao;

    public PlatServiceVersion1(IPlatDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Plat> listerPlats() {
        try {
            return dao.listerPlats().stream()
                    .map(plat -> new Plat(plat.getNom().toUpperCase(), plat.getPrixEnCentimesEuros()))
                    .collect(Collectors.toList());
        } catch (NullPointerException e) {
            throw new PlatException("Erreur lors de la récupération des plats", e);
        }
    }

    @Override
    public void ajouterPlat(String nomPlat, Integer prixPlat) {

        // Vérification des paramètres nuls
        if (nomPlat == null || prixPlat == null) {
            throw new PlatException("Le nom du plat et le prix ne doivent pas être nuls");
        }

        // règle métier
        if (nomPlat.length() <= 3) {
            throw new PlatException("Un plat doit avoir un nom de plus de 3 caractères");
        }

        if (prixPlat <= 500) {
            throw new PlatException("Le prix d'un plat doit être supérieur à 5 €");
        }

        String nomPlatEnMajuscules = nomPlat.toUpperCase();
        // persistance uniquement si les règles métiers sont respectées
        dao.ajouterPlat(nomPlatEnMajuscules, prixPlat);
    }
}
