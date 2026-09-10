package Homework.AfterLesson;

    // Класс для узла дерева
    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    // Класс для бинарного дерева поиска
    class BinarySearchTree {
        private Node root;

        // Метод для добавления числа в дерево
        public void add(int value) {
            root = addRecursive(root, value);
        }

        private Node addRecursive(Node current, int value) {
            if (current == null) {
                return new Node(value);
            }

            if (value > current.value) {
                current.left = addRecursive(current.left, value);
            } else if (value < current.value) {
                current.right = addRecursive(current.right, value);
            }

            return current;
        }

        // Метод для нахождения минимального значения
        public int findMin() {
            if (root == null) {
                throw new IllegalStateException("Дерево пустое");
            }
            return findMinRecursive(root);
        }

        private int findMinRecursive(Node current) {
            return current.left == null ? current.value : findMinRecursive(current.left);
        }
    }

    public class Main {
        public static void main(String[] args) {
            BinarySearchTree tree = new BinarySearchTree();

            // Добавляем числа в дерево
            tree.add(50);
            tree.add(30);
            tree.add(70);
            tree.add(20);
            tree.add(40);
            tree.add(60);
            tree.add(80);

            // Находим минимальное значение
            System.out.println("Минимальное значение: " + tree.findMin());
        }
    }

