package com.cvhau.javaexample.javatime;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class TemporalAmountNormalize {

    private static final int PATTERN_FLAG = Pattern.MULTILINE|Pattern.CASE_INSENSITIVE;

    private static final Pattern YEARS_PATTERN = Pattern.compile("([0-9]+) ?years?", PATTERN_FLAG);
    private static final Pattern MONTHS_PATTERN = Pattern.compile("([0-9]+) ?months?", PATTERN_FLAG);
    private static final Pattern WEEKS_PATTERN = Pattern.compile("([0-9]+) ?weeks?", PATTERN_FLAG);
    private static final Pattern DAYS_PATTERN = Pattern.compile("([0-9]+) ?days?", PATTERN_FLAG);
    private static final Pattern HOURS_PATTERN = Pattern.compile("([0-9]+) ?hours?", PATTERN_FLAG);
    private static final Pattern MINUTES_PATTERN = Pattern.compile("([0-9]+) ?minutes?", PATTERN_FLAG);
    private static final Pattern SECONDS_PATTERN = Pattern.compile("([0-9.]+) ?seconds?", PATTERN_FLAG);
    private static final Pattern AGO_PATTERN = Pattern.compile("ago$", PATTERN_FLAG);

    public static String normalize(String text) {
        Matcher matcher;

        String stripedText = text
                .strip()
                .replaceAll("[ \t\n\f\r\u000B\u001C\u001D\u001E\u001F]+", " ");

        StringBuilder normalized = new StringBuilder();

        if (AGO_PATTERN.matcher(stripedText).find()) {
            normalized.append("-P");
        } else {
            normalized.append("P");
        }

        if ((matcher = YEARS_PATTERN.matcher(stripedText)).find()) {
            normalized.append(matcher.group(1)).append("Y");
        }
        if ((matcher = MONTHS_PATTERN.matcher(stripedText)).find()) {
            normalized.append(matcher.group(1)).append("M");
        }
        if ((matcher = WEEKS_PATTERN.matcher(stripedText)).find()) {
            normalized.append(matcher.group(1)).append("W");
        }
        if ((matcher = DAYS_PATTERN.matcher(stripedText)).find()) {
            normalized.append(matcher.group(1)).append("D");
        }

        StringBuilder timeNormalized = new StringBuilder();
        if ((matcher = HOURS_PATTERN.matcher(stripedText)).find()) {
            timeNormalized.append(matcher.group(1)).append("H");
        }
        if ((matcher = MINUTES_PATTERN.matcher(stripedText)).find()) {
            timeNormalized.append(matcher.group(1)).append("M");
        }
        if ((matcher = SECONDS_PATTERN.matcher(stripedText)).find()) {
            String stripedDots = matcher.group(1)
                    .replaceAll("^\\.+", "0.")
                    .replaceAll("\\.+$", "");
            timeNormalized.append(stripedDots).append("S");
        }

        if (timeNormalized.length() > 0) {
            normalized.append("T").append(timeNormalized);
        }

        return normalized.toString();
    }
}
