package dev.saure;

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class Promise<T> {

    @JsFunction
    public interface FunctionParam<T, R> {
        R exec(T o);

    }

    public native <R> Promise<R> then(FunctionParam<T, R> f);

    @JsMethod(name = "catch")
    public native <R> Promise<R> error(FunctionParam<T, R> f);
}