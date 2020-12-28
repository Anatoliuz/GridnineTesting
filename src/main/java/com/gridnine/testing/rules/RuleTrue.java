package com.gridnine.testing.rules;

import com.gridnine.testing.Flight;

/**
 * Всегда верное правило
 */
public class RuleTrue implements Rule {
    @Override
    public boolean isValid(Flight flight) {
        return true;
    }
}
