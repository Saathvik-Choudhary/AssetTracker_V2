package com.example.AssetTracker_V2.core;

public enum InputCurrency {
        USD("United States Dollar", 1.0),
        EUR("Euro", 0.9381801045),
        GBP("British Pound Sterling", 0.8080700929),
        AUD("Australian Dollar", 1.556340158),
        CAD("Canadian Dollar", 1.3740801402),
        CHF("Swiss Franc", 0.9109401158),
        CNY("Chinese Yuan", 7.2387407579),
        JPY("Japanese Yen", 154.646853849),
        NZD("New Zealand Dollar", 1.6949302681),
        MXN("Mexican Peso", 17.0995022105),
        INR("Indian Rupee", 83.3108514846),
        BRL("Brazilian Real", 5.1924908055),
        RUB("Russian Ruble", 93.2105757513),
        ZAR("South African Rand", 19.1175035807),
        KRW("South Korean Won", 1372.716400977),
        SEK("Swedish Krona", 10.9216112693),
        SGD("Singapore Dollar", 1.3612301623),
        HKD("Hong Kong Dollar", 7.8312614928),
        NOK("Norwegian Krone", 11.009121153),
        TRY("Turkish Lira", 32.5982058292),
        AED("United Arab Emirates Dirham", 3.6725), // AED not provided, using approximate value
        SAR("Saudi Riyal", 3.75), // SAR not provided, using approximate value
        IDR("Indonesian Rupiah", 16232.679973354),
        THB("Thai Baht", 36.8737256523),
        MYR("Malaysian Ringgit", 4.7823206076),
        PHP("Philippine Peso", 57.5443475844),
        PLN("Polish Zloty", 4.0388305094),
        DKK("Danish Krone", 6.9992207996),
        HUF("Hungarian Forint", 369.4540417799),
        CZK("Czech Koruna", 23.6688240727);

        private final String currencyName;
        private final double conversionToUSD;

        InputCurrency(String currencyName, double conversionToUSD) {
            this.currencyName = currencyName;
            this.conversionToUSD = conversionToUSD;
        }

        public String getCurrencyName() {
            return currencyName;
        }

        public double getConversionToUSD() {
            return conversionToUSD;
        }

}
