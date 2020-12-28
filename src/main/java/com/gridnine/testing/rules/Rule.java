package com.gridnine.testing.rules;

import com.gridnine.testing.Flight;

public interface Rule {
    boolean isValid(Flight flight);

}
