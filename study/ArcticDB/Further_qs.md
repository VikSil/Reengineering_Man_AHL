* From the docs:
https://docs.arcticdb.io/latest/#versioning


> Please note that you can also pass a datetime into any as_of argument, which will result in reading the last version earlier than the datetime passed.

? Can this be achieved with the nanosecond Unix timestamp that is returned when a version of a symbol is created? Python datetime only has precision up to miliseconds. And `datetime.fromtimestamp()` can only take Unix timestamp up to second precision. Miliseconds could be added by `datetime.timedelta`.
pd.Timestamp has microsecond precision.

* Is it possible to make a static library dynamic? (Probably not)

* The Note [here](https://docs.arcticdb.io/latest/faq/#how-does-arcticdb-handle-concurrent-writers) needs a link.

* typo in https://docs.arcticdb.io/latest/tutorials/fundamentals/

    lib = ac.get_library['library'] # should be regular brackets