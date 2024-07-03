# Minimal Project to Demo The Nested Config Problem

## Description of the problem

We are migrating from KAPT to KSP (see build.gradle.kts), but have noticed that once KSP is implemented, Micronaut does not correctly honor the @ConfigurationProperties
in certain circumstances.

We have noticed that if we have a config item uses `@ConfigurationProperties` to override what the property is called in the application.yml (ie to something that wouldn't 
be the default anyway) then it will be correctly set, but that any values nested underneath this item will not be set. Strangely this does not affect nested objects,
just nested values.

If an additional config line is added to the application.yml that matches the name of the property then the values will be successfully looked up, but from the overridden 
path, not the path that matches the name. If the path that matches the name is removed then the lookup will fail.


## Temp Workaround

As a temporary workaround we can rename all of our config to match the config in the yml, but we'd prefer to not have to do this.


## How To Recreate Problem.

* Run `DemoTest`, this will successfully run all tests, confirming that the config was correctly populated.
* Refactor line 8 of Configuration.kt, renaming `levelOne` to be `levelOnez`. This shouldn't have any effect as the `@ConfigurationProperties` on line 9 will tell Micronaut
the name of the config key to look for in the `application.yml`
* Rerun `DemoTest`, this will fail in a way that confirms that the nested values are not being set and the nested objects are. (we believe this is a bug)
* Uncomment line 6 of the application.yaml and rerun `DemoTest` this will work. 

