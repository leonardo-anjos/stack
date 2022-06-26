package stack;

public class Principal {

	public Principal() {
		Stack p1;

		p1 = new Stack();
		p1.push(12);
		p1.push(36);
		p1.push(27);
		p1.push(36);
		p1.push(23);

		// System.out.println(this.ehEspelhada(p1));
		// System.out.println(this.maiorValor(p1));
		// System.out.println(this.media(p1));
		// this.removerElemento(p1, 26);
		// this.substituirElemento(p1, 55, 3);
		// this.print(p1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Principal app = new Principal();
	}

	// Lista 1 - Exerc�cio 4
	/*
	 * Implemente um m�todo que elimine de um Pilha todas as ocorr�ncias de um
	 * determinado elemento
	 */
	public void removerElemento(Stack p, int valor) {
		Stack aux = new Stack();

		// Copiar os valores de p para a pilha aux, com
		// exce��o do valor recebido
		while (!p.empty()) {
			int t = p.pop();
			if (t != valor) {
				aux.push(t);
			}
		}

		// Copiar de volta para p os valores da aux
		while (!aux.empty()) {
			p.push(aux.pop());
		}
	}

	// Lista 1 - Exerc�cio 2
	/*
	 * Escreva um algoritmo que forne�a o maior entre os elementos de uma Pilha
	 */
	public int maiorValor(Stack p) {
		int maior = p.top();
		Stack aux = new Stack();

		// Copiando os valores de p em aux (invertidos)
		// e encontrando o maior valor
		while (!p.empty()) {
			int t = p.pop();
			if (t > maior)
				maior = t;
			aux.push(t);
		}

		// Copiando de volta os valores de aux para p
		while (!aux.empty()) {
			p.push(aux.pop());
		}

		return maior;
	}

	/*
	 * Escreva um algoritmo que forne�a a m�dia aritm�tica dos elementos de uma
	 * Pilha
	 */
	public float media(Stack p) {
		float soma = 0;
		Stack aux = new Stack();

		// Copiando os valores de p em aux (invertidos)
		// e encontrando a soma dos valores
		while (!p.empty()) {
			int t = p.pop();
			soma = soma + t;
			aux.push(t);
		}

		// Copiando de volta os valores de aux para p
		while (!aux.empty()) {
			p.push(aux.pop());
		}

		return soma / p.size();
	}

	// Cria uma c�pia da pilha p recebida
	public Stack clonar(Stack p) {
		Stack aux = new Stack();
		Stack clone = new Stack();

		// Copiando os valores de p em aux (invertidos)
		while (!p.empty()) {
			aux.push(p.pop());
		}

		// Copiando os valores de aux para p e clone
		while (!aux.empty()) {
			int t = aux.pop();
			p.push(t);
			clone.push(t);
		}

		return clone;
	}

	/*
	 * Construa um m�todo que receba uma pilha qualquer e verifique se a mesma
	 * obedece a seguinte condi��o: o primeiro elemento (topo) � igual a �ltimo, o
	 * segundo � igual ao pen�ltimo e assim por diante. Retorne true caso isso
	 * ocorra.
	 */
	public boolean ehEspelhada(Stack p) {
		// Clonar a pilha pilha
		Stack clone = this.clonar(p);

		// Verifico se a pilha j� est� vazia
		if (clone.empty() == true)
			return false;

		Stack aux = new Stack();

		// Mover para a pilha aux a metade superior da p.
		// Se o tamanho de p for �mpar, removemos a metade+1.
		while (clone.size() > aux.size()) {
			aux.push(clone.pop());
		}

		// Descartar o topo da aux se os tamanhos forem diferentes
		if (aux.size() != clone.size()) {
			aux.pop();
		}

		// Desempilhar p e aux e comparar cada valor removido
		while (!clone.empty()) {
			if (clone.pop() != aux.pop()) {
				return false;
			}
		}

		return true;
	}

	// Construa um m�todo para remover um elemento de
	// determinada posi��o p da pilha, onde p � passado como
	// argumento para o m�todo
	public void removerElementoPos(Stack p, int pos) {
		Stack aux = new Stack();

		// Verifico se a pilha j� est� vazia
		if (p.empty() == true)
			return;

		// Verifico se a posi��o � v�lida
		if (pos < 0 || pos >= p.size())
			return;

		// Desempilhar todos os elementos de p at� a posi��o
		// pos
		while (p.size() > pos) {
			aux.push(p.pop());
		}

		// Remove do aux o elemento desejado
		aux.pop();

		// Reempilhar na pilha p todos os elementos de aux
		while (aux.empty() == false) {
			p.push(aux.pop());
		}
	}

	// Substituir um elemento de determinada posi��o da pilha
	public void substituirElemento(Stack p, int elem, int pos) {
		Stack aux = new Stack();

		// Verifico se a pilha j� est� vazia
		if (p.empty() == true)
			return;

		// Verifico se a posi��o � v�lida
		if (pos < 0 || pos >= p.size())
			return;

		// Desempilhando os elementos at� a posi��o pos
		while (p.size() > pos) {
			aux.push(p.pop());
		}

		// Empilhar o elemento recebido
		p.push(elem);

		// Descarta o elemento que estava na posi��o pos originalmente
		aux.pop();

		// Reempilhando a p a partir da aux
		while (aux.empty() == false) {
			p.push(aux.pop());
		}
	}

	// Incluir um elemento em determinada posi��o da pilha
	public void inserirElemento(Stack p, int elem, int pos) {
		Stack aux = new Stack();

		// Verifico se a pilha j� est� cheia
		if (p.full() == true)
			return;

		// Verifico se a posi��o � v�lida
		if (pos < 0 || pos > p.size())
			return;

		// Desempilhando os elementos at� a posi��o pos
		while (p.size() > pos) {
			aux.push(p.pop());
		}

		// Empilhar o elemento recebido
		p.push(elem);

		// Reempilhando a p a partir da aux
		while (aux.empty() == false) {
			p.push(aux.pop());
		}
	}

	// Imprimir os valores da pilha
	public void print(Stack p) {
		Stack aux = new Stack();

		// Desempilhando toda a p na aux
		while (p.empty() == false) {
			aux.push(p.pop());
		}

		// Reempilhando toda a p a partir da aux
		while (aux.empty() == false) {
			System.out.print(aux.top() + "-");
			p.push(aux.pop());
		}
	}
}
