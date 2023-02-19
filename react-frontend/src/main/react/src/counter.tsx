import React, {useEffect, useState} from "react";
import {createRoot, Root} from "react-dom/client";

interface CounterState {
    message: string;
    count: number;
}

type CounterStateUpdater = (state: CounterState) => void;

const Counter = (props: { state: CounterState, updateState: CounterStateUpdater }) => {
    // The counter state in the props should always replace the one held in React
    // It is up to the GWT side to make sure it is not falsely overwritten
    const [state, setState] = useState(props.state);
    useEffect(() => {
        setState(props.state)
    }, [props])

    // Whenever the state is updated, propagate it to the GWT side
    useEffect(() => {
        props.updateState(state)
    }, [state])

    // Standard react example component
    const increment = () => setState({...state, count: state.count + 1})

    return (<>
        <h1>{state.message}</h1>
        <h2>Count: {state.count}</h2>
        <button onClick={increment}>Increment</button>
    </>)
};

/**
 * CounterComponent wraps the React component and handles the React Root functionality
 *
 * This could also be done on GWT side by exposing `createRoot` and the `Root` class. But then JSX can't be used
 * anymore, which makes the use much easier
 */
export default class CounterComponent {
    private root: Root;

    constructor(element: HTMLElement) {
        this.root = createRoot(element)
    }

    public render(state: CounterState, updateState: CounterStateUpdater): void {
        this.root.render(<Counter state={state} updateState={updateState}/>)
    }

    public destroy(): void {
        this.root.unmount()
    }
}
