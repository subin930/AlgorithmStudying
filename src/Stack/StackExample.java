package Stack;

public class StackExample {
    public static void main(String[] args) throws Exception {
        Stack stack = new Stack();

        stack.push(0);
        stack.push(1);
        stack.push(2);

        System.out.println(stack.pop().data);
        System.out.println(stack.peek().data);
        System.out.println(stack.pop().data);
        System.out.println(stack.pop().data);
        System.out.println(stack.isEmpty());
    }
}
