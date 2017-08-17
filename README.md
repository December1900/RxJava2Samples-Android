# RxJava 2 for Android by Samples
## How to use RxJava 2.x in your application
Add this in your build.gradle
> compile 'io.reactivex.rxjava2:rxjava:2.1.3'

Don't forget to add RxAndroid also
> compile 'io.reactivex.rxjava2:rxandroid:2.0.1'

I'm also using Retrofit, so add the following
> compile 'com.squareup.retrofit2:retrofit:2.3.0'

## What RxJava 2.x differs from RxJava 1.x
|RxJava 1.x|RxJava 2.x|
|---|---|
|About `backpressure` ![](http://on-img.com/chart_image/59955604e4b0a6812c100916.png)|About `backpressure` ![](http://on-img.com/chart_image/5995587ae4b0b83fa260c4e9.png)
|when create Observable, callback `Observable.onSubscribe()`|when create Observable, callback `ObservableEmitter<>` and directly `throws Exception`|
|when create Observer, callback `onNext(),onError(),onCompleted()`, use `CompositeSubscription`|when create Observer, callback `onNext(),onError(),onComplete(),onSubscribe()`, use `CompositeDisposable`|
|To simplify subscribe, `Fun1, Fun2, Observable`|To simplify subscribe, `Function, BiFunction, Consumer, BiConsumer`|

## Operators :
+ `Interval` —> create an Observable that emits a sequence of integers spaced by a particular time interval
+ `Map` -> transform the items emitted by an Observable by applying a function to each item
+ `FlatMap` -> transform the items emitted by an Observable into Observables, then flatten the emissions from those into a single Observable
+ `Concat` -> emit the emissions from two or more Observables without interleaving them
+ `Zip` -> combine the emissions of multiple Observables together via a specified function and emit single items for each combination based on the results of this function
+ `Filter` -> emit only those items from an Observable that pass a predicate test
+ `Take` -> emit only the first n items emitted by an Observable
+ `Reduce` -> apply a function to each item emitted by an Observable, sequentially, and emit the final value
+ `Skip` -> suppress the first n items emitted by an Observable
+ `Buffer` -> periodically gather items emitted by an Observable into bundles and emit these bundles rather than emitting the items one at a time
+ `Replay` -> ensure that all observers see the same sequence of emitted items, even if they subscribe after the Observable has begun emitting items
+ `Merge` -> combine multiple Observables into one by merging their emissions

## Examples present in this project
+ **[RxConcatActivity](https://github.com/December1900/RxJava2Samples-Android/blob/master/app/src/main/java/net/december1900/rxjava2samples_android/ui/operators/RxConcatActivity.java)** -> Use `Concat` operator combined with `Retrofit2`
+ **[RxDisposableActivity](https://github.com/December1900/RxJava2Samples-Android/blob/master/app/src/main/java/net/december1900/rxjava2samples_android/ui/operators/RxDisposableActivity.java)** -> Use `CompositeDisposable`
+ **[RxFlatMapActivity](https://github.com/December1900/RxJava2Samples-Android/blob/master/app/src/main/java/net/december1900/rxjava2samples_android/ui/operators/RxFlatMapActivity.java)** -> Use `FlatMap` operator and `From` operator
+ **[RxMapActivity](https://github.com/December1900/RxJava2Samples-Android/blob/master/app/src/main/java/net/december1900/rxjava2samples_android/ui/operators/RxMapActivity.java)** -> Use `Map` operator
