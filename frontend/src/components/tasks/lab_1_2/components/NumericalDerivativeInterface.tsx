export interface TabularFunctionInterface {
    nodes: Map<number, number>;
}

export interface NumericalDerivativeInterface {
    tabularFunctionInterface: TabularFunctionInterface;
    x: number;
}