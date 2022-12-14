package moji1;

/**
 * しりとり用単語格納クラス
 * @author  b1021008 MeiInoue
 * 
 */
public class Tango implements Comparable<Tango> {

	private String kanji;
	private String kana;
	
	public Tango(String kanji, String kana) {
		this.kanji = kanji;

		// convert small hiragana to big ones
		String sml = "ぁぃぅぇぉっゃゅょ";
		String big = "あいうえおつやゆよ";
		for(int j = 0; j < sml.length(); ++j)
			this.kana = kana.replace(sml.charAt(j), big.charAt(j));
	}
	
	public String getKanji() {
		return kanji;
	}
	
	public String getKana() {
		return kana;
	}

	@Override
	public int compareTo(Tango o) {
		// TODO Auto-generated method stub
		return this.kana.compareTo(o.getKana());
	}
	
	public String toString() {
		return "「" + kana + "（" + kanji + "）」";
	}
}
