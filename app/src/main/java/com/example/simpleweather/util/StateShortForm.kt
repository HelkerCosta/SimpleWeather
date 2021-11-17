package com.example.simpleweather.util


fun convert(state: String): String {

    val statesHashMap = HashMap<String, String>()
    statesHashMap["Alabama"] = "AL"
    statesHashMap["Alaska"] = "AK"
    statesHashMap["American Samoa"] = "AS"
    statesHashMap["Arizona"] = "AZ"
    statesHashMap["Arkansas"] = "AR"
    statesHashMap.put("Armed Forces (AE)","AE")
    statesHashMap.put("Armed Forces Americas","AA")
    statesHashMap.put("Armed Forces Pacific","AP")
    statesHashMap.put("British Columbia","BC")
    statesHashMap.put("California","CA")
    statesHashMap.put("Colorado","CO")
    statesHashMap.put("Connecticut","CT")
    statesHashMap.put("Delaware","DE")
    statesHashMap.put("District Of Columbia","DC")
    statesHashMap.put("Florida","FL")
    statesHashMap.put("Georgia","GA")
    statesHashMap.put("Guam","GU")
    statesHashMap.put("Hawaii","HI")
    statesHashMap.put("Idaho","ID")
    statesHashMap.put("Illinois","IL")
    statesHashMap.put("Indiana","IN")
    statesHashMap.put("Iowa","IA")
    statesHashMap.put("Kansas","KS")
    statesHashMap.put("Kentucky","KY")
    statesHashMap.put("Louisiana","LA")
    statesHashMap.put("Maine","ME")
    statesHashMap.put("Maryland","MD")
    statesHashMap.put("Massachusetts","MA")
    statesHashMap.put("Michigan","MI")
    statesHashMap.put("Minnesota","MN")
    statesHashMap.put("Mississippi","MS")
    statesHashMap.put("Missouri","MO")
    statesHashMap.put("Montana","MT")
    statesHashMap.put("Nebraska","NE")
    statesHashMap.put("Nevada","NV")
    statesHashMap.put("New Hampshire","NH")
    statesHashMap.put("New Jersey","NJ")
    statesHashMap.put("New Mexico","NM")
    statesHashMap.put("New York","NY")
    statesHashMap.put("North Carolina","NC")
    statesHashMap.put("North Dakota","ND")
    statesHashMap.put("Ohio","OH")
    statesHashMap.put("Oklahoma","OK")
    statesHashMap.put("Oregon","OR")
    statesHashMap.put("Pennsylvania","PA")
    statesHashMap.put("Puerto Rico","PR")
    statesHashMap.put("Rhode Island","RI")
    statesHashMap.put("South Carolina","SC")
    statesHashMap.put("South Dakota","SD")
    statesHashMap.put("Tennessee","TN")
    statesHashMap.put("Texas","TX")
    statesHashMap.put("Utah","UT")
    statesHashMap.put("Vermont","VT")
    statesHashMap.put("Virgin Islands","VI")
    statesHashMap.put("Virginia","VA")
    statesHashMap.put("Washington","WA")
    statesHashMap.put("West Virginia","WV")
    statesHashMap.put("Wisconsin","WI")
    statesHashMap.put("Wyoming","WY")

    if(statesHashMap.containsKey(state)){
        return statesHashMap[state]!!
    }

    return state
}

