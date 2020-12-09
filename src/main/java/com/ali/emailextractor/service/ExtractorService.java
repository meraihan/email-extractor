package com.ali.emailextractor.service;

import com.ali.emailextractor.model.Extractor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ExtractorService {

    private static Pattern ptn =
            Pattern.compile("(\\d+x\\d+x\\d+)");
    private static Pattern ptnKg =
            Pattern.compile("(\\d+kg)");
    private static Pattern ptnPc =
            Pattern.compile("(\\d+pc)");

    public List<String> captureDimension(String largeText){
        Matcher mtch = ptn.matcher(largeText);
        List<String> ips = new ArrayList<String>();
        while(mtch.find()){
            ips.add(mtch.group());
        }
        return ips;
    }

    public List<String> captureKg(String largeText){
        Matcher mtch = ptnKg.matcher(largeText);
        List<String> ips = new ArrayList<String>();
        while(mtch.find()){
            ips.add(mtch.group());
        }
        return ips;
    }
    public List<String> capturePc(String largeText){
        Matcher mtch = ptnPc.matcher(largeText);
        List<String> ips = new ArrayList<String>();
        while(mtch.find()){
            ips.add(mtch.group());
        }
        return ips;
    }

    public String emailExtractor(String mailBody) {
        List<String> dimension = captureDimension(mailBody);
        List<String> kg = captureKg(mailBody);
        List<String> pc = capturePc(mailBody);
        String dimString = dimension.get(0);
        String kgString = kg.get(0);
        String pcString = pc.get(0);
        String result = pcString.substring(0, pcString.indexOf("pc")) + " X (" + dimString + "cm) " + kgString.substring(0, kgString.indexOf("kg")) + " kg";
        System.out.println(result);
        return result;
    }
}
