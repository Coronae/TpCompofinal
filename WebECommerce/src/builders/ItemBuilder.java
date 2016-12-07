package builders;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.Item;

public class ItemBuilder {

    private static final String CHAMP_DESIGNATION = "designationItem";
    private static final String CHAMP_DESCRIPTION = "descriptionItem";
    private static final String CHAMP_TAGS        = "tagsItem";
    private static final String CHAMP_CATEGORIE   = "categorieItem";
    private static final String CHAMP_IMG         = "imgItem";
    private static final String CHAMP_QUANTITE    = "quantiteItem";
    private static final String CHAMP_PRIXHT      = "prixHTItem";

    private static final String ATT_ERREURS       = "form";

    private Map<String, String> erreurs           = new HashMap<String, String>();

    public ItemBuilder() {
        // TODO Auto-generated constructor stub
    }

    public Item createItem( HttpServletRequest request ) {

        String designation = getValeurChamp( request, CHAMP_DESIGNATION );
        String description = getValeurChamp( request, CHAMP_DESCRIPTION );
        String tags = getValeurChamp( request, CHAMP_TAGS );
        String categorie = getValeurChamp( request, CHAMP_CATEGORIE );
        String img = getValeurChamp( request, CHAMP_IMG );
        String sQuantite = getValeurChamp( request, CHAMP_QUANTITE );
        String sPrixHT = getValeurChamp( request, CHAMP_PRIXHT );

        Item item = new Item();

        try {
            validDesignation( designation );
            item.setDesignation( designation );
        } catch ( Exception e ) {
            setErreur( CHAMP_DESIGNATION, e.getMessage() );
        }

        try {
            validDescription( description );
            item.setDescription( description );
        } catch ( Exception e ) {
            setErreur( CHAMP_DESCRIPTION, e.getMessage() );
        }

        try {
            validTags( tags );
            item.setTags( tags.split( ", " ) );
        } catch ( Exception e ) {
            setErreur( CHAMP_TAGS, e.getMessage() );
        }

        try {
            validCategorie( categorie );
            item.setCategorie( categorie );
        } catch ( Exception e ) {
            setErreur( CHAMP_CATEGORIE, e.getMessage() );
        }

        try {
            validQuantite( sQuantite );
            item.setQuantiteRestante( Integer.parseInt( sQuantite ) );
        } catch ( Exception e ) {
            setErreur( CHAMP_QUANTITE, e.getMessage() );
        }

        try {
            validPrixHT( sPrixHT );
            item.setPrixHT( Double.parseDouble( sPrixHT ) );
        } catch ( Exception e ) {
            setErreur( CHAMP_PRIXHT, e.getMessage() );
        }

        return item;
    }

    private void validDesignation( String designation ) throws Exception {
        if ( designation != null ) {
            if ( designation.length() < 2 ) {
                throw new Exception( " La désignation du produit doit comporter au moins 2 caractères" );
            }
        } else {
            throw new Exception( " Entrez une désignation" );
        }
    }

    private void validDescription( String description ) throws Exception {
        if ( description != null ) {
            if ( description.length() < 10 ) {
                throw new Exception( "La description doit contenir au moins 10 caractères" );
            }
        } else {
            throw new Exception( "Entrez une description" );
        }
    }

    private void validTags( String tags ) throws Exception {
        if ( tags != null ) {
            String[] tabTags = tags.split( ", ", 0 );
            for ( String tag : tabTags ) {
                if ( tag.length() < 2 || tag.length() > 20 ) {

                    if ( !tag.matches( "^[A-Za-z-]{2,20}$" ) ) {
                        throw new Exception( "Le tag ne doit pas contenir de caractères spéciaux" );
                    }
                } else {
                    throw new Exception( "Le tag doit faire entre 2 et 8 caractères " );
                }
            }
        } else {
            throw new Exception( "Saisissez au moins un tag, plusieurs séparé par une virgule " );
        }
    }

    private void validCategorie( String categorie ) throws Exception {
        if ( categorie != null ) {
            if ( categorie.length() < 2 ) {
                throw new Exception( "La catégorie doit au moins faire 2 caractères" );
            }
        } else {
            throw new Exception( "Entrez une categorie" );
        }
    }

    private void validQuantite( String sQuantite ) throws Exception {
        if ( sQuantite != null ) {
            if ( !sQuantite.matches( "\\d+" ) ) {
                throw new Exception( "La quantité ne doit contenir que des entiers positifs" );
            }

        } else {
            throw new Exception( "Entrez une quantité" );
        }
    }

    private void validPrixHT( String sPrixHT ) throws Exception {
        if ( sPrixHT != null ) {
            if ( !sPrixHT.matches( "^(\\d*\\[.]?\\d*)$" ) )

                throw new Exception( "Prix HT incorrect" );
        } else {
            throw new Exception( "Entrez un prix" );
        }
    }

    private String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }

    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

}