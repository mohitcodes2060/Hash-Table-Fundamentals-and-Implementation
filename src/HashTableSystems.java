import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class HashTableSystems {

    public static void main(String[] args) {

        System.out.println("===== HASH TABLE SYSTEMS PROJECT =====\n");

        problem1();
        problem2();
        problem3();
        problem4();
        problem5();
        problem6();
        problem7();
        problem8();
        problem9();
        problem10();

    }

    // ---------------------------------------------------
    // PROBLEM 1: Username Availability Checker
    // ---------------------------------------------------
    static void problem1() {

        System.out.println("\n--- Problem 1: Username Availability ---");

        HashMap<String,Integer> users = new HashMap<>();
        HashMap<String,Integer> attempts = new HashMap<>();

        users.put("john_doe",101);
        users.put("admin",102);

        checkAvailability("john_doe",users,attempts);
        checkAvailability("jane_smith",users,attempts);

        System.out.println("Most attempted username: "+getMostAttempted(attempts));
    }

    static boolean checkAvailability(String username,
                                     HashMap<String,Integer> users,
                                     HashMap<String,Integer> attempts){

        attempts.put(username,attempts.getOrDefault(username,0)+1);

        if(users.containsKey(username)){
            System.out.println(username+" not available");
            System.out.println("Suggestions: "+suggestAlternatives(username));
            return false;
        }

        System.out.println(username+" available");
        return true;
    }

    static List<String> suggestAlternatives(String username){
        List<String> suggestions = new ArrayList<>();
        suggestions.add(username+"1");
        suggestions.add(username+"2");
        suggestions.add(username.replace("_","."));
        return suggestions;
    }

    static String getMostAttempted(HashMap<String,Integer> attempts){

        String popular="";
        int max=0;

        for(String key:attempts.keySet()){
            if(attempts.get(key)>max){
                max=attempts.get(key);
                popular=key;
            }
        }
        return popular;
    }


    // ---------------------------------------------------
    // PROBLEM 2: Flash Sale Inventory
    // ---------------------------------------------------
    static void problem2(){

        System.out.println("\n--- Problem 2: Flash Sale Inventory ---");

        HashMap<String,Integer> stock = new HashMap<>();
        LinkedHashMap<Integer,String> waitingList = new LinkedHashMap<>();

        stock.put("IPHONE15_256GB",2);

        purchaseItem("IPHONE15_256GB",123,stock,waitingList);
        purchaseItem("IPHONE15_256GB",456,stock,waitingList);
        purchaseItem("IPHONE15_256GB",789,stock,waitingList);

        System.out.println("Waiting list: "+waitingList);
    }

    static synchronized void purchaseItem(String product,int userId,
                                          HashMap<String,Integer> stock,
                                          LinkedHashMap<Integer,String> waitingList){

        int available = stock.getOrDefault(product,0);

        if(available>0){
            stock.put(product,available-1);
            System.out.println("User "+userId+" purchased. Remaining: "+(available-1));
        }else{
            waitingList.put(userId,product);
            System.out.println("User "+userId+" added to waiting list");
        }
    }



    // ---------------------------------------------------
    // PROBLEM 3: DNS Cache with TTL
    // ---------------------------------------------------

    static void problem3(){

        System.out.println("\n--- Problem 3: DNS Cache ---");

        DNSCache cache = new DNSCache();

        cache.resolve("google.com");
        cache.resolve("google.com");

        cache.printStats();
    }

    static class DNSEntry{
        String ip;
        long expiry;

        DNSEntry(String ip,long ttl){
            this.ip=ip;
            this.expiry=System.currentTimeMillis()+ttl;
        }
    }

    static class DNSCache{

        HashMap<String,DNSEntry> cache = new HashMap<>();
        int hits=0;
        int misses=0;

        String resolve(String domain){

            if(cache.containsKey(domain)){
                DNSEntry e = cache.get(domain);

                if(System.currentTimeMillis()<e.expiry){
                    hits++;
                    System.out.println("Cache HIT "+e.ip);
                    return e.ip;
                }
            }

            misses++;

            String ip="172.217."+new Random().nextInt(255)+"."+new Random().nextInt(255);
            cache.put(domain,new DNSEntry(ip,5000));

            System.out.println("Cache MISS "+ip);
            return ip;
        }

        void printStats(){
            int total = hits+misses;
            double hitRate = (total==0)?0:(hits*100.0/total);
            System.out.println("Hit Rate: "+hitRate+"%");
        }
    }


    // ---------------------------------------------------
    // PROBLEM 4: Plagiarism Detector
    // ---------------------------------------------------

    static void problem4(){

        System.out.println("\n--- Problem 4: Plagiarism Detector ---");

        String doc1 = "this is a simple plagiarism detection example";
        String doc2 = "this is a plagiarism detection system example";

        int n = 3;

        Set<String> grams1 = generateNGrams(doc1,n);
        Set<String> grams2 = generateNGrams(doc2,n);

        grams1.retainAll(grams2);

        System.out.println("Matching ngrams: "+grams1.size());
    }

    static Set<String> generateNGrams(String text,int n){

        String[] words = text.split(" ");
        Set<String> grams = new HashSet<>();

        for(int i=0;i<=words.length-n;i++){

            StringBuilder sb = new StringBuilder();

            for(int j=0;j<n;j++){
                sb.append(words[i+j]).append(" ");
            }

            grams.add(sb.toString());
        }

        return grams;
    }



    // ---------------------------------------------------
    // PROBLEM 5: Website Analytics
    // ---------------------------------------------------

    static void problem5(){

        System.out.println("\n--- Problem 5: Analytics Dashboard ---");

        HashMap<String,Integer> pageViews = new HashMap<>();
        HashMap<String,Set<String>> uniqueVisitors = new HashMap<>();
        HashMap<String,Integer> trafficSources = new HashMap<>();

        processEvent("/news","user1","google",pageViews,uniqueVisitors,trafficSources);
        processEvent("/news","user2","facebook",pageViews,uniqueVisitors,trafficSources);
        processEvent("/sports","user1","direct",pageViews,uniqueVisitors,trafficSources);

        System.out.println("Page views: "+pageViews);
        System.out.println("Sources: "+trafficSources);
    }

    static void processEvent(String url,String user,String source,
                             HashMap<String,Integer> pageViews,
                             HashMap<String,Set<String>> uniqueVisitors,
                             HashMap<String,Integer> trafficSources){

        pageViews.put(url,pageViews.getOrDefault(url,0)+1);

        uniqueVisitors.putIfAbsent(url,new HashSet<>());
        uniqueVisitors.get(url).add(user);

        trafficSources.put(source,trafficSources.getOrDefault(source,0)+1);
    }


    // ---------------------------------------------------
    // PROBLEM 6: Rate Limiter
    // ---------------------------------------------------

    static void problem6(){

        System.out.println("\n--- Problem 6: Rate Limiter ---");

        RateLimiter limiter = new RateLimiter(5);

        for(int i=0;i<7;i++){
            System.out.println("Request "+i+" allowed: "+limiter.allow("client1"));
        }
    }

    static class RateLimiter{

        int limit;
        HashMap<String,Integer> counts = new HashMap<>();

        RateLimiter(int limit){
            this.limit=limit;
        }

        boolean allow(String client){

            int c = counts.getOrDefault(client,0);

            if(c>=limit){
                return false;
            }

            counts.put(client,c+1);
            return true;
        }
    }



    // ---------------------------------------------------
    // PROBLEM 7: Autocomplete
    // ---------------------------------------------------

    static void problem7(){

        System.out.println("\n--- Problem 7: Autocomplete ---");

        HashMap<String,Integer> queries = new HashMap<>();

        queries.put("java tutorial",100);
        queries.put("javascript",90);
        queries.put("java download",80);

        String prefix="jav";

        for(String q:queries.keySet()){
            if(q.startsWith(prefix)){
                System.out.println(q+" "+queries.get(q));
            }
        }
    }



    // ---------------------------------------------------
    // PROBLEM 8: Parking Lot with Open Addressing
    // ---------------------------------------------------

    static void problem8(){

        System.out.println("\n--- Problem 8: Parking System ---");

        ParkingLot lot = new ParkingLot(10);

        lot.park("ABC123");
        lot.park("XYZ999");
        lot.park("AAA111");

        lot.print();
    }

    static class ParkingLot{

        String[] table;

        ParkingLot(int size){
            table = new String[size];
        }

        int hash(String plate){
            return Math.abs(plate.hashCode()) % table.length;
        }

        void park(String plate){

            int index = hash(plate);

            while(table[index]!=null){
                index=(index+1)%table.length;
            }

            table[index]=plate;
            System.out.println("Parked "+plate+" at "+index);
        }

        void print(){
            System.out.println(Arrays.toString(table));
        }
    }



    // ---------------------------------------------------
    // PROBLEM 9: Two Sum Transactions
    // ---------------------------------------------------

    static void problem9(){

        System.out.println("\n--- Problem 9: Two Sum ---");

        int[] nums={500,300,200};

        int target=500;

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){

            int comp=target-nums[i];

            if(map.containsKey(comp)){
                System.out.println("Pair: "+nums[i]+" + "+comp);
            }

            map.put(nums[i],i);
        }
    }



    // ---------------------------------------------------
    // PROBLEM 10: Multi Level Cache
    // ---------------------------------------------------

    static void problem10(){

        System.out.println("\n--- Problem 10: Multi-Level Cache ---");

        LinkedHashMap<String,String> L1 = new LinkedHashMap<>(10,0.75f,true);
        HashMap<String,String> L2 = new HashMap<>();

        L2.put("video123","SSD_DATA");

        getVideo("video123",L1,L2);
        getVideo("video123",L1,L2);
    }

    static void getVideo(String id,
                         LinkedHashMap<String,String> L1,
                         HashMap<String,String> L2){

        if(L1.containsKey(id)){
            System.out.println("L1 Cache HIT");
            return;
        }

        if(L2.containsKey(id)){
            System.out.println("L2 Cache HIT -> promoting to L1");
            L1.put(id,L2.get(id));
            return;
        }

        System.out.println("Database HIT");
    }

}