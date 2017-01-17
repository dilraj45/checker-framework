package org.checkerframework.checker.index.lowerbound;

import java.util.LinkedHashSet;
import org.checkerframework.checker.index.minlen.MinLenChecker;
import org.checkerframework.checker.index.upperbound.UpperBoundChecker;
import org.checkerframework.common.basetype.BaseTypeChecker;
import org.checkerframework.common.value.ValueChecker;
import org.checkerframework.framework.source.SuppressWarningsKeys;

/**
 * A type-checker for preventing arrays from being accessed with values that are too low. Normally
 * bundled as part of the Index Checker.
 *
 * @checker_framework.manual #index-checker Index Checker
 */
@SuppressWarningsKeys({"index", "lowerbound"})
public class LowerBoundChecker extends BaseTypeChecker {

    @Override
    protected LinkedHashSet<Class<? extends BaseTypeChecker>> getImmediateSubcheckerClasses() {
        LinkedHashSet<Class<? extends BaseTypeChecker>> checkers =
                super.getImmediateSubcheckerClasses();
        checkers.add(ValueChecker.class);
        checkers.add(MinLenChecker.class);
        if (isIndexChecker()) {
            // If running the Index Checker, then run the Upper Bound Checker as a subchecker.
            // See comment on the Index Checker for more details.
            checkers.add(UpperBoundChecker.class);
        }
        return checkers;
    }

    protected boolean isIndexChecker() {
        return false;
    }
}