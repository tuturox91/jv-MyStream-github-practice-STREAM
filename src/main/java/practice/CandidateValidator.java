package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SPLITERATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        int yearsInUkraine = Arrays.stream(candidate.getPeriodsInUkr()
                        .split(SPLITERATOR))
                .mapToInt(Integer::parseInt)
                .reduce((fromYear, toYear) -> toYear - fromYear).orElseThrow();

        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && yearsInUkraine >= 10;
    }
    //write your code here
}
