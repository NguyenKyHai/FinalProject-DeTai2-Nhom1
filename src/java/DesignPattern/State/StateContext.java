package DesignPattern.State;

public class StateContext {

    private IState state;

    public void setState(IState state) {
        this.state = state;
    }

    public int applyState() {
        return this.state.stateHandle();
    }

//    public static void main(String[] args) {
//        StateContext context = new StateContext();
//        context.setState(new DaGiao());
//        int state = context.applyState();
//        System.out.println(state);
//    }
}
