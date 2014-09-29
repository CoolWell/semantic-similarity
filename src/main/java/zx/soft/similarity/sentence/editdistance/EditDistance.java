package zx.soft.similarity.sentence.editdistance;

import zx.soft.similarity.Similarityable;

/**
 * 编辑距离的父类，定义了其中的主要行为
 * 
 */
public abstract class EditDistance implements Similarityable {

	public abstract double getEditDistance(SuperString<? extends EditUnit> S, SuperString<? extends EditUnit> T);

	@Override
	public double getSimilarity(String s1, String s2) {
		SuperString<WordEditUnit> S = SuperString.createWordSuperString(s1);
		SuperString<WordEditUnit> T = SuperString.createWordSuperString(s2);

		return 1 - (getEditDistance(S, T)) / (Math.max(S.length(), T.length()));
	}

}
