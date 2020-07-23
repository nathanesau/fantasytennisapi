package com.tennis.fantasytennisapi.service;

import com.tennis.fantasytennisapi.request.Bracket;

public interface DrawService {
    
    // return "OK" if successful
    String addBracket(Bracket bracket);

    Bracket getBracket();

}