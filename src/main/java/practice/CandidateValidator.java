package practice;

import model.Candidate;

import java.util.Arrays;
import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String CORRECT_NATIONALITY = "Ukrainian";
    private static final String YEAR_SPLITTER = "-";
    private static final int CORRECT_AGE = 35;
    private static final int CORRECT_YEARS_OF_LIVING = 10;
    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(YEAR_SPLITTER);
        int yearsLiving = Arrays.stream(years).mapToInt(Integer::parseInt).
                reduce((firstYear, secondYear) -> secondYear-firstYear).orElseThrow();
        return candidate.isAllowedToVote()
                &&  candidate.getNationality().equals(CORRECT_NATIONALITY)
                && candidate.getAge() >= CORRECT_AGE
                && yearsLiving >= CORRECT_YEARS_OF_LIVING;
    }
}
