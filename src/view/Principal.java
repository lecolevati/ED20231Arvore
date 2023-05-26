package view;

import model.Arvore;

public class Principal {

	public static void main(String[] args) {
		int[] vetor = {108, 130, 127, 10, 0, 13, 131, 184, 26, 2, 14, 158, 144, 69, 79, 111};
		Arvore arvore = new Arvore();
		for (int i : vetor) {
			arvore.insert(i);
		}
		try {
			arvore.prefixSearch();
			System.out.println();
			arvore.infixSearch();
			System.out.println();
			arvore.postfixSearch();
			System.out.println();
			System.out.println("==================");
			arvore.search(158);
			arvore.remove(144);
			arvore.remove(127);
			arvore.remove(10);
			arvore.remove(130);
			System.out.println("========================");
			arvore.infixSearch();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println();
	}

}
