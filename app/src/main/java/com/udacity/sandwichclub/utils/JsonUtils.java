package com.udacity.sandwichclub.utils;

import android.support.annotation.NonNull;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
* Jason Sample
* {\"name\":{\
* "mainName\":\"Ham and cheese           sandwich\",\
* "alsoKnownAs\":[]
* },\"
* placeOfOrigin\":\"\",\"
* description\":\"A ham and cheese            sandwich is a common type of sandwich. It is made by putting cheese and sliced ham
            between two slices of bread. The bread is sometimes buttered and/or toasted. Vegetables
            like lettuce, tomato, onion or pickle slices can also be included. Various kinds of
            mustard and mayonnaise are also            common.\",\
 "image\":\"https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG\",\
 "ingredients\":[\"Sliced
            bread\",\"Cheese\",\"Ham\"]}
* */

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {


        JSONObject JASONSanwitch , name ;
        JSONArray alsoKnownAs , ingredienst ;
        String  nameSrting= null , OriginSrting = null, descripionSrting= null ,imageString = null;

        List<String> AlsoknownAsList = new ArrayList<String>(),
                IngerdientsList =new ArrayList<String>();
        try {
            JASONSanwitch = new JSONObject(json);
            name = JASONSanwitch.getJSONObject("name");
            nameSrting = name.getString("mainName");
            alsoKnownAs = name.getJSONArray("alsoKnownAs");
            OriginSrting = JASONSanwitch.getString("placeOfOrigin");
            descripionSrting= JASONSanwitch.getString("description");

            imageString = JASONSanwitch.getString("image");
            ingredienst = JASONSanwitch.getJSONArray("ingredients");

            int i;
            if (ingredienst==null ) IngerdientsList.add("Not available");
            else
            for ( i= 0; i < ingredienst.length(); i++) {
                IngerdientsList.add(ingredienst.get(i).toString() );

            }
            if (alsoKnownAs==null) AlsoknownAsList.add("Not available");
            else
            for ( i= 0; i < alsoKnownAs.length(); i++) {
                AlsoknownAsList.add(alsoKnownAs.getString(i));
            }


                if (nameSrting==null||nameSrting.length()==0)
                    nameSrting="Not Available";
                if (imageString==null||imageString.length()==0)
                    imageString="Not Available";
                if (OriginSrting==null||OriginSrting.length()==0)
                    OriginSrting="Not Available";
                if (descripionSrting==null||descripionSrting.length()==0)
                    descripionSrting="Not Available";


        } catch (JSONException e) {
            e.printStackTrace();
        }

        //    public Sandwich(String mainName, List<String> alsoKnownAs, String placeOfOrigin, String description, String image, List<String> ingredients) {

    return new Sandwich(nameSrting, AlsoknownAsList, OriginSrting,descripionSrting, imageString, IngerdientsList);

        }
}
