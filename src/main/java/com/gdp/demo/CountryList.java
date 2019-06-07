package com.gdp.demo;

import com.gdp.demo.model.Country;

import java.util.ArrayList;

public class CountryList {

    public ArrayList<Country> countryList = new ArrayList<Country>();

    public CountryList()
    {
        countryList.add(new Country("United States", 20513000));
        countryList.add(new Country("China", 13457267));
        countryList.add(new Country("Japan", 5070626));
        countryList.add(new Country("Germany", 4029140));
        countryList.add(new Country("United Kingdom", 2808899));
        countryList.add(new Country("France", 2794696));
        countryList.add(new Country("India", 2689992));
        countryList.add(new Country("Italy", 2086911));
        countryList.add(new Country("Brazil", 1909386));
        countryList.add(new Country("Canada", 1733706));
        countryList.add(new Country("South Korea", 1655608));
        countryList.add(new Country("Russia", 1576488));
        countryList.add(new Country("Spain", 1437047));
        countryList.add(new Country("Australia", 1427767));
        countryList.add(new Country("Mexico", 1199264));
        countryList.add(new Country("Indonesia", 1005268));
        countryList.add(new Country("Netherlands", 909887));
        countryList.add(new Country("Saudi Arabia", 769878));
        countryList.add(new Country("Turkey", 713513));
        countryList.add(new Country("Switzerland", 709118));
        countryList.add(new Country("Taiwan", 602678));
        countryList.add(new Country("Sweden", 554659));
        countryList.add(new Country("Poland", 549478));
        countryList.add(new Country("Belgium", 536055));
        countryList.add(new Country("Thailand", 490120));
        countryList.add(new Country("Argentina", 475429));
        countryList.add(new Country("Austria", 459401));
        countryList.add(new Country("Norway", 441439));
        countryList.add(new Country("United Arab Emirates", 432612));
        countryList.add(new Country("Iran", 430082));
        countryList.add(new Country("Nigeria", 397472));
        countryList.add(new Country("South Africa", 376679));
        countryList.add(new Country("Ireland", 366448));
        countryList.add(new Country("Israel", 365599));
        countryList.add(new Country("Hong Kong", 360315));
        countryList.add(new Country("Denmark", 354683));
        countryList.add(new Country("Malaysia", 347290));
        countryList.add(new Country("Singapore", 346621));
        countryList.add(new Country("Colombia", 336940));
        countryList.add(new Country("Philippines", 331678));
        countryList.add(new Country("Pakistan", 306987));
        countryList.add(new Country("Chile", 299887));
        countryList.add(new Country("Bangladesh", 286275));
        countryList.add(new Country("Finland", 276553));
        countryList.add(new Country("Egypt", 249471));
        countryList.add(new Country("Czech Republic", 244540));
        countryList.add(new Country("Vietnam", 241434));
        countryList.add(new Country("Romania", 239440));
        countryList.add(new Country("Portugal", 237962));
        countryList.add(new Country("Iraq", 230911));
        countryList.add(new Country("Peru", 228944));
        countryList.add(new Country("Greece", 218057));
        countryList.add(new Country("New Zealand", 205997));
        countryList.add(new Country("Algeria", 188342));
        countryList.add(new Country("Qatar", 188295));
        countryList.add(new Country("Kazakhstan", 184209));
        countryList.add(new Country("Hungary", 156393));
        countryList.add(new Country("Kuwait", 144523));
        countryList.add(new Country("Ukraine", 126390));
        countryList.add(new Country("Morocco", 118178));
        countryList.add(new Country("Angola", 114504));
        countryList.add(new Country("Ecuador", 107266));
        countryList.add(new Country("Slovakia", 106940));
        countryList.add(new Country("Puerto Rico", 104557));
        countryList.add(new Country("Venezuela", 96328));
        countryList.add(new Country("Sri Lanka", 92504));
        countryList.add(new Country("Kenya", 89591));
        countryList.add(new Country("Ethiopia", 83836));
        countryList.add(new Country("Oman", 81682));
        countryList.add(new Country("Dominican Republic", 81103));
        countryList.add(new Country("Guatemala", 79109));
        countryList.add(new Country("Syria", 77460));
        countryList.add(new Country("Myanmar", 71543));
        countryList.add(new Country("Luxembourg", 68993));
        countryList.add(new Country("Panama", 66031));
        countryList.add(new Country("Bulgaria", 63651));
        countryList.add(new Country("Uruguay", 60933));
        countryList.add(new Country("Costa Rica", 60816));
        countryList.add(new Country("Croatia", 59971));
        countryList.add(new Country("Belarus", 56934));
        countryList.add(new Country("Lebanon", 56709));
        countryList.add(new Country("Tanzania", 55645));
        countryList.add(new Country("Slovenia", 54969));
        countryList.add(new Country("Macau", 53961));
        countryList.add(new Country("Lithuania", 52468));
        countryList.add(new Country("Ghana", 51815));
        countryList.add(new Country("Serbia", 47564));
        countryList.add(new Country("Cote d'Ivoire", 45875));
        countryList.add(new Country("Azerbaijan", 45592));
        countryList.add(new Country("Uzbekistan", 43303));
        countryList.add(new Country("Libya", 43236));
        countryList.add(new Country("Democratic Republic of the Congo", 42692));
        countryList.add(new Country("Turkmenistan", 42764));
        countryList.add(new Country("Jordan", 41869));
        countryList.add(new Country("Paraguay", 41851));
        countryList.add(new Country("Bolivia", 41833));
        countryList.add(new Country("Tunisia", 41662));
        countryList.add(new Country("Bahrain", 39300));
        countryList.add(new Country("Cameroon", 38445));
        countryList.add(new Country("Latvia", 34286));
        countryList.add(new Country("Sudan", 33249));
    }

    public Country findCountry(CheckCountry tester)
    {
        for (Country c : countryList)
        {
            if(tester.test(c))
            {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Country> findCountries(CheckCountry tester)
    {
        ArrayList<Country> tempCountryList = new ArrayList<>();

        for (Country c: countryList)
        {
            if(tester.test(c))
            {
                tempCountryList.add(c);
            }
        }

        return tempCountryList;
    }
}
