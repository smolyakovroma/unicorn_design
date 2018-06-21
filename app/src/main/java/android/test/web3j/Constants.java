package android.test.web3j;

import android.content.Context;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.TransactionManager;

import java.util.HashMap;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Constants {


    public static final long DELAY_FOR_REST_REQUEST = 500;

    public static float balanceEth = 0l;
    public static float balanceCandy = 0l;
    public static float balanceMegaCandy = 0l;
//    public static BigInteger taxSireCandy = new BigInteger("0");
//    public static BigInteger taxSireEth = new BigInteger("0");
    //saving settings preferences
    public static final String settings_show_splash = "settings_show_splash";
    public static Context CONTEXT;

    public static Web3j web3j = null;
    public static Credentials credentials = null;
    public static TransactionManager transactionManager = null;

    public static String addressCandySale = "0xd27cc16507a20a9b2b6f2df793128504e48a2165";
//    CandySale 0xd27cc16507a20a9b2b6f2df793128504e48a2165
//
    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constants.URL.HOST_BACKEND)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    public static RestApi restApi = retrofit.create(RestApi.class);



    public static class PREF {
        public static String Current_wallet_address = "current_wallet";
        public static String Use_multiwallet = "use_multiwallet";
        public static String Recovery_File = "recovery_file";
        public static String Use_pincode = "use_pincode";
        public static String Locale = "locale";
    }

    public enum Target {
        ALL("All", 0),
        BUY("Buy", 1),
        PAIR("Pair", 2),
        FREE("Free", 3);
        private String str;
        private int index;

        Target(String str, int index) {
            this.str = str;
            this.index = index;
        }

        public static int getIndex(String str) {
            if (str.equalsIgnoreCase(ALL.toString())) return ALL.index;
            if (str.equalsIgnoreCase(BUY.toString())) return BUY.index;
            if (str.equalsIgnoreCase(PAIR.toString())) return PAIR.index;
            if (str.equalsIgnoreCase(FREE.toString())) return FREE.index;
            return 0;
        }

        @Override
        public String toString() {
            return str;
        }
    }

    public enum Sort {
        POPULAR("popular", 0),
        TOPFORSALE("expensive_candy", 1),
        TOPFORSIRE("expensive_candy_breed", 2),
        NEWEST("newest", 3);

        private String str;
        private int index;

        Sort(String str, int index) {
            this.str = str;
            this.index = index;
        }

        public static int getIndex(String str) {
            if (str.equalsIgnoreCase(POPULAR.toString())) return POPULAR.index;
            if (str.equalsIgnoreCase(TOPFORSALE.toString())) return TOPFORSALE.index;
            if (str.equalsIgnoreCase(TOPFORSIRE.toString())) return TOPFORSIRE.index;
            if (str.equalsIgnoreCase(NEWEST.toString())) return NEWEST.index;
            return 0;
        }

        @Override
        public String toString() {
            return str;
        }
    }


    public static HashMap<Integer, String> propertyMap = new HashMap<>();

    static {
        propertyMap.put(1, "Swift");
        propertyMap.put(2, "Quick");
        propertyMap.put(3, "Rapid");
        propertyMap.put(4, "Fast");
        propertyMap.put(5, "Slow");
        propertyMap.put(6, "Lazy");
        propertyMap.put(7, "Hindered");
        propertyMap.put(8, "Lethargic");
    }
//    public enum Speed {
//        SWIFT("Swift", 1),
//        QUICK("Quick", 2),
//        RAPID("Rapid", 3),
//        FAST("Fast", 4),
//        SLOW("Slow", 5),
//        LAZY("Lazy", 6),
//        HINDERED("Hindered", 7),
//        LETHARGIC("Lethargic", 8);
//
//
//        private String str;
//        private int index;
//
//        Speed(String str, int index) {
//            this.str = str;
//            this.index = index;
//        }
//
//        public static int getIndex(String str) {
//            if (str.equalsIgnoreCase(SWIFT.toString())) return SWIFT.index;
//            if (str.equalsIgnoreCase(QUICK.toString())) return QUICK.index;
//            if (str.equalsIgnoreCase(RAPID.toString())) return RAPID.index;
//            if (str.equalsIgnoreCase(FAST.toString())) return FAST.index;
//            if (str.equalsIgnoreCase(SLOW.toString())) return SLOW.index;
//            if (str.equalsIgnoreCase(LAZY.toString())) return LAZY.index;
//            if (str.equalsIgnoreCase(HINDERED.toString())) return HINDERED.index;
//            if (str.equalsIgnoreCase(LETHARGIC.toString())) return LETHARGIC.index;
//            return 0;
//        }
//
//
//        public static String getByIndex(int i) {
//
//        }
//
//        @Override
//        public String toString() {
//            return str;
//        }
//    }


    public static class URL {
        public static String PORT = "";

        //PRODUCTION

//        public static String ETH_NETWORK = "https://mainnet.infura.io/oShbYdHLGQhi0rn1audL";
//        public static String COMISSION_WALLET = "0x73246796E98b8d1991473180246290f78A569a0c";

        //TEST

        public static String HOST = "http://192.168.0.102:8080" + PORT + "/";
        //        public static String ETH_NETWORK = "http://34.240.230.188:7545";
        public static String ETH_NETWORK = "https://rinkeby.infura.io/oShbYdHLGQhi0rn1audL";
        public static String TOKEN_ETHERSCAN = "Z819WD4F144SDCJMEMY458GBZRGHT5KD3P";
        public static String HOST_BACKEND = "https://dev.core.unicorngo.io";
        public static String RENDER_API = "http://54.72.13.174:3000";
        public static String EXCHANGE_CANDY = "http://coinmarket-dev.unicorngo.io/exchange/Candy";
        public static String FIND_ALL_ADVERT = HOST + "findalladvert";
        public static String FIND_ALL_ITEM = HOST + "findallitembyid";
        public static String GET_ETH_PRICE = HOST + "getethprice";
//        public static String GET_TEST_ETH = HOST + "gettesteth/" + wallet.getAddress();
//        public static String FIND_ALL_TRANSACTION = HOST + "findalltransactionbyaddress/" + wallet.getAddress();
//        public static String FIND_ALL_TYPE = HOST + "findalltype";
//        public static String GET_STATUS = HOST + "getstatus/" + wallet.getAddress();
        public static String SAVE_TRANSACTION = HOST + "savetransaction/";
        public static String SAVE_PAID = HOST + "savepaid/";
        public static String TRANSACTION_VIEWER = "https://rinkeby.etherscan.io/tx/";
        public static String GASPRICEORACLE = "https://www.etherchain.org";
        public static String ETHERSCAN_API = "http://api-rinkeby.etherscan.io";
    }

    public static Unicorn currentUnicorn = new Unicorn();

    public static final String BDYFRM[] = {"Brawny", "Slim", "Moderate", "Plump", "Fat"};
    public static final String HOOFRM[] = {"Muscular", "Thin", "Moderate", "Plump", "Fat"};
    public static final String HEDFRM[] = {"Short", "Extruded", "Average", "Broad", "Pointed"};
    public static final String WNGFRM[] = {"Massive", "Nimble", "Spooky", "Straight", "Cute"};
    public static final String EYEFRM[] = {"Technology", "Graphic", "Anime", "Fantasy", "Spooky"};
    public static final String EARFRM[] = {"Rough", "Saggy", "Ragged", "Sharpened", "Round"};
    public static final String HRNFRM[] = {"Round", "Flat", "Helical", "Curved", "Blunt"};
    public static final String HAIFRM[] = {"Massive", "Bright", "Spooky", "Fluffy", "Exquisite"};
    public static final String TAIFRM[] = {"Massive", "Thin", "Spooky", "Fluffy", "Brushy"};
    public static final String STNFRM[] = {"Round", "Polygon", "Metallic", "Spooky", "Crystal"};

    public static final String RARITY[] = {"Common", "Uncommon", "Rare", "Epic", "Legendary"};
    public static final String RARITYPROC[] = {"Common 73.73%", "Uncommon 13.73%", "Rare 7.84%", "Epic 3.92%", "Legendary 0.78%"};

}
