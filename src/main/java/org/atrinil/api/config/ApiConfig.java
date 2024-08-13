package org.atrinil.api.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties"
        ,"system:env"
        ,"file:${user.dir}/src/test/resources/api-config.properties"
})
public interface ApiConfig extends Config {

    @Key("baseurl")
    String baseUrl();

    @Key("get.single.user")
    String getSingleUserEndpoint();

    @Key("get.user.list")
    String getUserListEndpoint();
}
