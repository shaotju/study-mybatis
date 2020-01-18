package canger.study;

public class TestIdeaEvaluate  {
    public static void main(String[] args) {
        TestIdeaEvaluate testIdeaEvaluate = new TestIdeaEvaluate();
        testIdeaEvaluate.say();
    }

    public static void print(){
        System.out.println("Test print");
    }

    private String name = "Default name";
    private String work = "Test Idea Evaluate with break point";

    public void say(){
        System.out.println("I am " + name + " My work is " + work);
    }
    @Override
    public String toString() {
        return "TestIdeaEvaluate{" +
                "name='" + name + '\'' +
                ", work='" + work + '\'' +
                '}';
    }
}
