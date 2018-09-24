package com.stonehouse.capricorn.jsoup;

import com.stonehouse.capricorn.jdbc.Dao;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

/**
 * @author Libin
 */
public class AreaUtil {
    public static final Map<Integer, String> map = new HashMap<>();

    private static final Map<String, String> sqlMap = new HashMap<>();

    static {
        // 省/直辖市
        map.put(1, "province");
        // 市
        map.put(2, "city");
        // 区/县
        map.put(3, "county");
        // 街道/镇/乡
        map.put(4, "country");
        // 居委会/村委会
        map.put(5, "village");

        sqlMap.put("province", "insert into province values(?,?,?)");
        sqlMap.put("city", "insert into city values(?,?,?)");
        sqlMap.put("county", "insert into county values(?,?,?)");
        sqlMap.put("town", "insert into town values(?,?,?)");
        sqlMap.put("village", "insert into village values(?,?,?,?)");
    }

    public static Document connect(String url) throws IOException {
        return Jsoup.connect(url).get();

    }

    public static String getRootUrl(String url) {
        return url.substring(0, url.lastIndexOf("/") + 1);
    }

    public static void parse(String url) throws IOException {
        List<String> provinceList = new ArrayList<>();
        Document doc = connect(url);
        String rootUrl = getRootUrl(url);
        Elements elements = doc.select(".provincetr>td>a");
        Iterator<Element> elementList = elements.listIterator();
        System.out.println(elements.size());
        while (elementList.hasNext()) {
            Element e = elementList.next();
            String name = e.text();
            String href = e.attr("href");
            String code = href.substring(0, 2);
            provinceList.add(rootUrl + href);
            if (new Dao().insert(sqlMap.get("province"), code, name, rootUrl + href)) {
                System.out.println(name + " 写入成功");
            } else {
                System.err.println("写入失败");
            }
        }
        System.out.println("省" + provinceList.size());
        for (String href : provinceList) {
            System.out.println(href);
        }

    }


    public static void parseCity(String url, String province) throws IOException {
        String select = ".citytr";
        System.out.println("市" + url);
        String rootUrl = getRootUrl(url);
        Document doc = connect(url);
        Elements elements = doc.select(select);
        Elements item;
        String code, name, href;
        for (Element element : elements) {
            item = element.select("td>a");
            code = item.get(0).text();
            name = item.get(1).text();
            href = item.get(0).attr("href");
//            if (new Dao().insert(sqlMap.get("city"), code, name, province)) {
//                System.out.println(name + " 写入成功");
//            } else {
//                System.err.println("写入失败");
//            }
            parseCounty(rootUrl + href, code);
        }
    }


    public static void parseCounty(String url, String city) throws IOException {
        String select = ".countytr";
        System.out.println("区县" + url);
        String rootUrl = getRootUrl(url);
        Document doc = connect(url);
        Elements elements = doc.select(select);
        Elements item;
        String code, name, href;
        for (Element element : elements) {
            item = element.select("td>a");
            code = item.get(0).text();
            name = item.get(1).text();
            href = item.get(0).attr("href");
//            if (new Dao().insert(sqlMap.get("county"), code, name, city)) {
//                System.out.println(name + " 写入成功");
//            } else {
//                System.err.println("写入失败");
//            }
            parseTown(rootUrl + href, code);
        }
    }

    public static void parseTown(String url, String county) throws IOException {
        String select = ".towntr";
        System.out.println("城镇" + url);
        String rootUrl = getRootUrl(url);
        Document doc = connect(url);
        Elements elements = doc.select(select);
        Elements item;
        String code, name, href;
        for (Element element : elements) {
            item = element.select("td>a");
            code = item.get(0).text();
            name = item.get(1).text();
            href = item.get(0).attr("href");
//            if (new Dao().insert(sqlMap.get("town"), code, name, county)) {
//                System.out.println(name + " 写入成功");
//            } else {
//                System.err.println("写入失败");
//            }
            parseVillage(rootUrl + href, code);
        }
    }

    public static void parseVillage(String url, String town) throws IOException {
        String select = ".villagetr";
        System.out.println("村委会" + url);
        Document doc = connect(url);
        Elements elements = doc.select(select);
        Elements item;
        String code, name, ruralCode;
        for (Element element : elements) {
            item = element.select("td");
            code = item.get(0).text();
            ruralCode = item.get(1).text();
            name = item.get(2).text();
//            if (new Dao().insert(sqlMap.get("village"), code, name, ruralCode, town)) {
//                System.out.println(name + " 写入成功");
//            } else {
//                System.err.println("写入失败");
//            }
        }
    }

    public static void main(String[] args) {
        String url = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2017/index.html";
        try {
            parse(url);
            System.out.println("处理成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
