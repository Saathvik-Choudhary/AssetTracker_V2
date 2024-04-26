package com.example.AssetTracker_V2.core;

public enum InputCurrency {


        AED ("United Arab Emirates Dirham", 3.6725),
        AUD ("Australian Dollar", 1.556340158),
        BRL ("Brazilian Real", 5.1924908055),
        CAD ("Canadian Dollar", 1.3740801402),
        CHF ("Swiss Franc", 0.9109401158),
        CNY ("Chinese Yuan", 7.2387407579),
        CZK ("Czech Koruna", 23.6688240727),
        DKK ("Danish Krone", 6.9992207996),
        EUR ("Euro", 0.9381801045),
        GBP ("British Pound Sterling", 0.8080700929),
        HKD ("Hong Kong Dollar", 7.8312614928),
        HUF ("Hungarian Forint", 369.4540417799),
        IDR ("Indonesian Rupiah", 16232.679973354),
        INR ("Indian Rupee", 83.3108514846),
        JPY ("Japanese Yen", 154.646853849),
        KRW ("South Korean Won", 1372.716400977),
        MXN ("Mexican Peso", 17.0995022105),
        MYR ("Malaysian Ringgit", 4.7823206076),
        NOK ("Norwegian Krone", 11.009121153),
        NZD ("New Zealand Dollar", 1.6949302681),
        PHP ("Philippine Peso", 57.5443475844),
        PLN ("Polish Zloty", 4.0388305094),
        RUB ("Russian Ruble", 93.2105757513),
        SAR ("Saudi Riyal", 3.75),
        SEK ("Swedish Krona", 10.9216112693),
        SGD ("Singapore Dollar", 1.3612301623),
        THB ("Thai Baht", 36.8737256523),
        TRY ("Turkish Lira", 32.5982058292),
        USD ("United States Dollar", 1.0),
        ZAR ("South African Rand", 19.1175035807);

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
