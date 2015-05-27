package Tree;

public class AVL {
	private Node root;
	static boolean h = false; // czy była zmiana wysokoci drzewa
	// wartoci wskanika wyważenia drzewa
	static final int L = -1; // lewe wyższe
	static final int R = 0; // równowaga
	static final int P = 1; // prawe wyższe

	public AVL() {
		root = null;
	}

	public Integer find(Integer x) {
		Node t = search(x);
		return t != null ? t.value : null;
	}

	private Node search(Integer value) {
		Node node = root;
		int cmp = 0;
		while (node != null && (cmp = value.compareTo(node.value)) != 0) {
			node = cmp < 0 ? node.left : node.right;
		}
		return node;
	}

	public void insert(Integer x) {
		root = insert(x, root);
	}

	protected Node insert(Integer x, Node t) {
		if (t == null) {
			t = new Node(x);
			h = true;
		} else {
			int cmp = x.compareTo(t.value);
			if (cmp < 0) {
				t.left = insert(x, t.left);
				if (h)
					t = insertBalanceLeft(t);
			} else if (cmp > 0) {
				t.right = insert(x, t.right);
				if (h)
					t = insertBalanceRight(t);
			} else
				throw new DuplicateItemException(x.toString());
		}
		return t;
	}

	// Wyważanie węzła w przypadku gdy urosło lewe poddrzewo
	// h=true - wysokoć drzewa uległa zmianie false-nie zmieniła sie
	Node insertBalanceLeft(Node t) {
		switch (t.balance) {
		case P:
			t.balance = R;
			h = false;
			break;
		case R:
			t.balance = L;
			break;
		case L:
			if (t.left.balance == L) {
				t.balance = R;
				t = RotRight(t);
			} else {
				t = RotLeftRight(t);
				t.right.balance = t.balance == L ? P : R;
				t.left.balance = t.balance == P ? L : R;
			}
			t.balance = R;
			h = false;
		}
		return t;
	}

	// WyważPrawe patrz WywazLewe
	Node insertBalanceRight(Node t) {
		switch (t.balance) {
		case L:
			t.balance = R;
			h = false;
			break;
		case R:
			t.balance = P;
			break;
		case P:
			if (t.right.balance == P) {
				t.balance = R;
				t = RotLeft(t);
			} else {
				t = RotRightLeft(t);
				t.left.balance = t.balance == P ? L : R;
				t.right.balance = t.balance == L ? P : R;
			}
			t.balance = R;
			h = false;

		}
		return t;
	}

	// Prosta zamiana wezla z jego lewym potomkiem
	Node RotRight(Node t) {
		Node t1 = t.left;
		t.left = t1.right;
		t1.right = t;
		return t1;
	}

	// Prosta zamiana wezla z jego prawym potomkiem
	Node RotLeft(Node t) {
		Node t1 = t.right;
		t.right = t1.left;
		t1.left = t;
		return t1;
	}

	// Podwojna rotacja LewoPrawo:
	// 1. lewy potomek wezla ze swoim prawym potomkiem
	// 2. wezel z lewym potomkiem(po zamianie 1.)
	Node RotLeftRight(Node t) {
		t.left = RotLeft(t.left);
		return RotRight(t);
	}

	// rotacja PrawoLewo - Symetryczna do rotacji LewoPrawo
	Node RotRightLeft(Node t) {
		t.right = RotRight(t.right);
		return RotLeft(t);
	}

	public void delete(Integer x) {
		root = delete(x, root);
	}

	protected Node delete(Integer x, Node t) {
		if (t == null)
			throw new ItemNotFoundException(x.toString());
		else {
			int cmp = x.compareTo(t.value);
			if (cmp < 0) {
				t.left = delete(x, t.left);
				if (h)
					t = deleteBalanceLeft(t);
			} else if (cmp > 0) {
				t.right = delete(x, t.right);
				if (h)
					t = deleteBalanceRight(t);
			} else if (t.left != null && t.right != null) {
				t.right = detachMin(t.right, t);
				if (h)
					t = deleteBalanceRight(t);
			} else {
				h = true;
				t = (t.left != null) ? t.left : t.right;
			}
		}
		return t;
	}

	// zastšpienie elementu jego następnikiem i usunięcie następnika
	protected Node detachMin(Node t, Node del) {
		if (t.left != null) {
			t.left = detachMin(t.left, del);
			if (h)
				t = deleteBalanceLeft(t);
		} else {
			del.value = t.value;
			h = true;
			t = t.right;
		}
		return t;
	}

	// Wywazanie wezla gdy skrocone zostalo lewe poddrzewo

	Node deleteBalanceLeft(Node t) {
		switch (t.balance) {
		case L:
			t.balance = R;
			break;
		case R:
			t.balance = P;
			h = false;
			break;
		case P:
			if (t.right.balance == L) {
				t = RotRightLeft(t);
				t.left.balance = t.balance == P ? L : R;
				t.right.balance = t.balance == L ? P : R;
				t.balance = R;
			} else {
				t = RotLeft(t);
				if (t.balance == R) {
					t.left.balance = P;
					t.balance = L;
					h = false;
				} else {
					t.left.balance = R;
					t.balance = R;
				}
			}
		}
		return t;
	}

	// Prawe poddrzewo uleglo skroceniu
	Node deleteBalanceRight(Node t) {
		switch (t.balance) {
		case P:
			t.balance = R;
			break;
		case R:
			t.balance = L;
			h = false;
			break;
		case L:
			if (t.left.balance == P) {
				t = RotLeftRight(t);
				t.right.balance = t.balance == L ? P : R;
				t.left.balance = t.balance == P ? L : R;
				t.balance = R;
			} else {
				t = RotRight(t);
				if (t.balance == R) {
					t.right.balance = L;
					t.balance = P;
					h = false;
				} else {
					t.right.balance = R;
					t.balance = R;
				}
			}
		}
		return t;
	}

	// prosty wydruk struktury drzewa
	public String toString() {
		return toString(root, 0);
	}

	private String toString(Node t, int pos) {
		String result = "";
		String spaces = "                                                                                                                                                                                                     ";
		if (t != null)
			result = result + toString(t.right, pos + 4)
					+ spaces.substring(0, pos)
					+ String.format("%s/%s", t.value, t.writeBalance())
					+ toString(t.left, pos + 4);
		else
			result = result + String.format("%n");
		return result;
	}

	// wydruk nie wymagajšcy łamania karku przy czytaniu
	int max(int x, int y) {
		return x > y ? x : y;
	}

	int height(Node t) {
		return t == null ? 0 : max(height(t.left), height(t.right)) + 1;
	}

	public String printTree() {
		class QueueElement {
			Node el;
			int level;
			int pos;
			int delta;

			QueueElement(Node e, int lev, int p, int del) {
				el = e;
				level = lev;
				pos = p;
				delta = del;
			}
		}
		;
		QueueElement[] q = new QueueElement[200];
		String result = "";
		int last = 0;
		int pos0 = 1;
		for (int i = 0; i < height(root); i++)
			pos0 *= 2;
		pos0 = pos0 * 3;
		if (root != null) {
			q[0] = new QueueElement(root, 0, pos0, pos0);
			for (int i = 0; i <= last; i++) {
				if (q[i].el.left != null)
					q[++last] = new QueueElement(q[i].el.left, q[i].level + 1,
							q[i].pos - q[i].delta / 2, q[i].delta / 2);
				if (q[i].el.right != null)
					q[++last] = new QueueElement(q[i].el.right, q[i].level + 1,
							q[i].pos + q[i].delta / 2, q[i].delta / 2);
			}

			result = result
					+ spaces(pos0 - 3)
					+ String.format(" %2s/%s ", q[0].el.value,
							q[0].el.writeBalance());
			for (int i = 1; i <= last; i++)
				if (q[i - 1].level < q[i].level)
					result = result
							+ String.format("%n")
							+ spaces(q[i].pos - 3)
							+ String.format(" %2s/%s ", q[i].el.value,
									q[i].el.writeBalance());
				else
					result = result
							+ spaces(q[i].pos - q[i - 1].pos - 6)
							+ String.format(" %2s/%s ", q[i].el.value,
									q[i].el.writeBalance());
			result = result + String.format("%n%n");
		}
		return result;
	}

	private String spaces(int n) {
		String res = "";
		for (int i = 0; i < n; i++)
			res += " ";
		return res;
	}

	public class DuplicateItemException extends RuntimeException {
		public DuplicateItemException(String message) {
			super(message);
		}
	}

	public class ItemNotFoundException extends RuntimeException {
		public ItemNotFoundException(String message) {
			super(message);
		}
	}

	class Node {
		Integer value;
		int balance;
		Node left;
		Node right;

		Node(Integer x) {
			value = x;
			balance = R;
			left = right = null;
		}

		String writeBalance() {
			return balance == 1 ? "L" : balance == 2 ? "R" : "P";
		}
	}

}