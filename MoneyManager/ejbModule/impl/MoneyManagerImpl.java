package impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import remote.MoneyManagerRemote;

@Stateless
@LocalBean
public class MoneyManagerImpl implements MoneyManagerRemote {

    private static final double USD_TO_EUR = 0.944;
    private static final double USD_TO_GBP = 0.801;
    private static final double USD_TO_INR = 68.489;
    private static final double USD_TO_AUD = 1.343;
    private static final double USD_TO_CAD = 1.352;

    private static final double EUR_TO_USD = 1.059;
    private static final double EUR_TO_GBP = 0.848;
    private static final double EUR_TO_INR = 72.552;
    private static final double EUR_TO_AUD = 1.422;
    private static final double EUR_TO_CAD = 1.432;

    private static final double GBP_TO_USD = 1.247;
    private static final double GBP_TO_EUR = 1.177;
    private static final double GBP_TO_INR = 84.461;
    private static final double GBP_TO_AUD = 1.676;
    private static final double GBP_TO_CAD = 1.687;

    public MoneyManagerImpl() {
        super();
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * 
     * @see impl.MoneyManagerRemote#calculTTCFrance(java.lang.Double,
     * java.lang.String)
     */
    @Override
    public double calculTTCFrance( Double prixHT, String categorie ) {
        switch ( categorie ) {
        case "agricole":
            return prixHT * 1.1;
        case "culturel":
            return prixHT * 1.055;
        case "alimentaire":
            return prixHT * 1.055;
        default:
            return prixHT * 1.2;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see impl.MoneyManagerRemote#convertTo(double, java.lang.String)
     */
    @Override
    public double convertTo( double value, String type ) {

        return 0;
    }

}
