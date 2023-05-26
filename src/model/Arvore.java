package model;

public class Arvore implements IArvore {

	No raiz;

	public Arvore() {
		raiz = null;
	}

	@Override
	public void insert(int valor) {
		No no = new No();
		no.dado = valor;
		no.esquerda = null;
		no.direita = null;
		insertLeaf(no, raiz);
	}

	private void insertLeaf(No no, No raizSubArvore) {
		if (raiz == null) {
			raiz = no;
		} else if (no.dado < raizSubArvore.dado) {
			if (raizSubArvore.esquerda == null) {
				raizSubArvore.esquerda = no;
			} else {
				insertLeaf(no, raizSubArvore.esquerda);
			}
		} else if (no.dado >= raizSubArvore.dado) {
			if (raizSubArvore.direita == null) {
				raizSubArvore.direita = no;
			} else {
				insertLeaf(no, raizSubArvore.direita);
			}
		}
	}

	@Override
	public void search(int valor) throws Exception {
		try {
			No no = nodeSearch(raiz, valor);
			int level = nodeLevel(raiz, valor);
			System.out.println("Valor: "+no.dado+" - Nível: "+level);
		} catch(Exception e) {
			throw new Exception("Valor não encontrado");
		}
	}

	private int nodeLevel(No raizSubArvore, int valor) throws Exception {
		if (raiz == null) {
			throw new Exception("Arvore Vazia !!");
		} else if (raizSubArvore.dado > valor) {
			return 1 + nodeLevel(raizSubArvore.esquerda, valor);
		} else if (raizSubArvore.dado < valor) {
			return 1 + nodeLevel(raizSubArvore.direita, valor);
		} else {
			return 0;
		}
	}

	private No nodeSearch(No raizSubArvore, int valor) throws Exception {
		if (raiz == null) {
			throw new Exception("Arvore Vazia !!");
		} else if (raizSubArvore.dado > valor) {
			return nodeSearch(raizSubArvore.esquerda, valor);
		} else if (raizSubArvore.dado < valor) {
			return nodeSearch(raizSubArvore.direita, valor);
		} else {
			return raizSubArvore;
		}
	}

	@Override
	public void remove(int valor) throws Exception {
		try {
			removeChild(raiz, valor);
		} catch (Exception e) {
			throw new Exception("CValor não encontrado");
		}
	}

	private No removeChild(No raizSubArvore, int valor) throws Exception {
		if (raiz == null) { //Inicio da busca
			throw new Exception("Arvore Vazia !!");
		} else if (raizSubArvore.dado > valor) {
			raizSubArvore.esquerda = removeChild(raizSubArvore.esquerda, valor);
		} else if (raizSubArvore.dado < valor) {
			raizSubArvore.direita =  removeChild(raizSubArvore.direita, valor);
		} else { //Encontrei o nó
			if (raizSubArvore.esquerda == null &&
				raizSubArvore.direita == null) { //Folha
				raizSubArvore = null;
			} else if (raizSubArvore.esquerda == null) { //Filho à direita
				raizSubArvore = raizSubArvore.direita;
			} else if (raizSubArvore.direita == null) { //Filho à esquerda
				raizSubArvore = raizSubArvore.esquerda;
			} else { //Dois filhos
				No no = raizSubArvore.esquerda;
				while (no.direita != null) {
					no = no.direita;
				}
				raizSubArvore.dado = no.dado;
				no.dado = valor;
				raizSubArvore.esquerda = 
						removeChild(raizSubArvore.esquerda, valor);
			}
		}
		return raizSubArvore;
	}

	@Override
	public void prefixSearch() throws Exception {
		prefix(raiz);
	}

	private void prefix(No raizSubArvore) throws Exception {
		if (raiz == null) {
			throw new Exception("Arvore Vazia !!!");
		} else {
			System.out.print(raizSubArvore.dado + " ");
			if (raizSubArvore.esquerda != null) {
				prefix(raizSubArvore.esquerda);
			}
			if (raizSubArvore.direita != null) {
				prefix(raizSubArvore.direita);
			}
		}
		
	}

	@Override
	public void infixSearch() throws Exception {
		infix(raiz);
	}

	private void infix(No raizSubArvore) throws Exception {
		if (raiz == null) {
			throw new Exception("Arvore Vazia !!!");
		} else {
			if (raizSubArvore.esquerda != null) {
				infix(raizSubArvore.esquerda);
			}
			System.out.print(raizSubArvore.dado + " ");
			if (raizSubArvore.direita != null) {
				infix(raizSubArvore.direita);
			}
		}
	}

	@Override
	public void postfixSearch() throws Exception {
		postfix(raiz);
	}

	private void postfix(No raizSubArvore) throws Exception {
		if (raiz == null) {
			throw new Exception("Arvore Vazia !!!");
		} else {
			if (raizSubArvore.esquerda != null) {
				postfix(raizSubArvore.esquerda);
			}
			if (raizSubArvore.direita != null) {
				postfix(raizSubArvore.direita);
			}
			System.out.print(raizSubArvore.dado + " ");
		}
		
	}
	
	

}
