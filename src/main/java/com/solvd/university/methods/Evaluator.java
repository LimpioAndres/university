package com.solvd.university.methods;

import com.solvd.university.classes.SportsArena;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Evaluator {
    public List<SportsArena> evaluate (List<SportsArena> listArena, Predicate<SportsArena> eval){
        List<SportsArena> newList = new ArrayList<>();

        listArena.stream().forEach((iteratorSports)-> {
            if(eval.test(iteratorSports)){
                newList.add(iteratorSports);
            }
        });
        return newList;
    }
}
