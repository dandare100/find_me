package za.co.fnb.findmelocator.ocep.utils;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import za.co.fnb.pe.framework.utils.CoreStringUtil;

public class StringUtil {

	public static String applyTextCamelCaseRules(String sentence) {
		if (sentence == null)
			return sentence;

		// remove leading/trailing spaces, replace double spaces with single spaces
		sentence = sentence.trim().replaceAll(" +", " ");

		// convert first letters to upper
		sentence = StringUtil.convertAllFirstLettersToUpper(sentence);

		return sentence;
	}

	public static String applyCamelCaseRules(String sentence) {
		return applyCamelCaseRules(sentence, true);
	}

	public static String applyCamelCaseRules(String sentence, boolean haveSpacesAroundReservedWords) {
		return applyCamelCaseRules(sentence, haveSpacesAroundReservedWords, true);
	}

	// Extra flag added for removal of double spaces (removal of double spaces for ATM & Branch
	// Locator caused data issues)
	public static String applyCamelCaseRules(String sentence, boolean haveSpacesAroundReservedWords, boolean removeDoubleSpaces) {
		if (sentence == null)
			return sentence;
		// remove spaces
		sentence = removeDoubleSpaces ? sentence.trim().replaceAll(" +", " ") : sentence.trim();

		// convert first letters to upper
		sentence = StringUtil.convertAllFirstLettersToUpper(sentence);

		// exclude exceptions
		StringTokenizer st = new StringTokenizer(sentence);
		while (st.hasMoreTokens()) {
			String key = st.nextToken();
			// vods exception...
			if (key.toLowerCase().indexOf("vods") > -1 || key.toLowerCase().indexOf("vds") > -1) {
				sentence = sentence.replaceAll(key, key.toUpperCase());
			}
			String space = haveSpacesAroundReservedWords ? " " : "";
			for (String EXCEPTION : EXCEPTIONS) {
				if (key.equalsIgnoreCase(EXCEPTION)) {
					sentence = sentence.replaceAll("\\s(" + key + ")\\s", " " + EXCEPTION + " ");
					sentence = sentence.replaceAll("(" + key + ")\\s", EXCEPTION + " ");
					sentence = sentence.replaceAll("(" + key + ")", space + EXCEPTION + space);
				}
			}
		}

		// HVR: Escape the | character, as it is a meta-character for regex
		sentence = sentence.replaceAll("\\|", "\\\\|");

		// convert <word+number> to uppercase
		Pattern pattern = Pattern.compile("\\w[a-z|A-Z]*\\d+[a-z|A-Z]*");
		Matcher matcher = pattern.matcher(sentence);
		while (matcher.find()) {
			sentence = sentence.trim().replaceAll(matcher.group(), matcher.group().toUpperCase());
		}

		// convert words that start with a number
		Pattern pattern2 = Pattern.compile("\\d+[a-z|A-Z]*");
		Matcher matcher2 = pattern2.matcher(sentence);
		while (matcher2.find()) {
			sentence = sentence.trim().replaceAll(matcher2.group(), matcher2.group().toUpperCase());
		}

		// HVR: Restore any | characters
		sentence = sentence.replaceAll(Pattern.quote("\\|"), "|");

		return sentence;
	}

	/**
	 * Formats a sentence into all lower case except for the first letter of each word which is converts to lower case. This is used to make a sentence that is
	 * possible all lower or upper case into a sentence that is more readable
	 *
	 * @param sentence
	 *            The sentence to be formatted
	 * @return a sentence that is formatted according to the description above
	 */
	public static final String convertAllFirstLettersToUpper(String sentence) {
		if (sentence == null)
			return sentence;
		sentence = sentence.toLowerCase();
		StringBuilder humanized = new StringBuilder();
		boolean nextToUpper = true;
		for (int x = 0; x < sentence.length(); x++) {
			char c = sentence.charAt(x);
			if (nextToUpper) {
				c = Character.toUpperCase(c);
				nextToUpper = false;
			}
			humanized.append(c);
			if (sentence.charAt(x) == '/' ||
					sentence.charAt(x) == '\\' ||
					sentence.charAt(x) == '*' ||
					sentence.charAt(x) == ' ' ||
					sentence.charAt(x) == '#' ||
					sentence.charAt(x) == ',' ||
					sentence.charAt(x) == '-' ||
					sentence.charAt(x) == '@') {
				nextToUpper = true;
			}
		}
		return humanized.toString();
	}

	public static String[] EXCEPTIONS = { "INT", "FNB", "PC", "PW", "RMB", "RMBPB", "PB", "KFC", "FNBACP", "BP", "PnP", "VoiP", "eBucks", "co", "ADSL", "za", "8.ta", "BlackBerry", "MTN", "KFC", "MyNotice", "MyMeg", "FNBCI", "USD", "GBP", "EUR", "KB",
			"MB", "GB", "TB", "SMS", "SMSs", "iPhone", "iPad", "iPod", "PEP", "OTP", "eWallet", "GEO", "HTC", "1G", "2G", "3G", "3GS", "4G", "4S", "5G", "iTunes", "eB", "CNY", "SIM", "GHS", "BoxOffice", "DStv", "GOtv", "FNBy" };

	public static String sortableASCIIString(int number) {
		return CoreStringUtil.padNumeric(number, 5);
	}
}
