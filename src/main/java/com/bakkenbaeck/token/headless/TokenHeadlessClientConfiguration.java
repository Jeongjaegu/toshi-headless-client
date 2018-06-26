package com.bakkenbaeck.token.headless;


public final class TokenHeadlessClientConfiguration {
    private String server;
    private String toshi_id_service_url;
    private String toshi_exchange_service_url;
    private String toshi_ethereum_service_url;
    private String network;
    private String networkId;
    private String seed;
    private String store;
    private String username;
    private String name;
    private String about;
    private String avatar;
    private Boolean is_public;
    private RedisConfiguration redis;
    private StorageConfiguration storage;

    private String stripQuotes(String input) {
        if (input != null && ((input.startsWith("\"") && input.endsWith("\"")) || (input.startsWith("'") && input.endsWith("'")))) {
            input = input.substring(1, input.length() - 1);
        }
        return input;
    }

    private String getEnvVariable(String name) {
        String value = System.getenv(name);
        if (value == null && name.startsWith("TOSHI_")) {
            value = System.getenv("TOKEN_" + name.substring(6));
        }
        return value;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getSeed() {
        if (this.seed == null) {
            String seed = this.getEnvVariable("TOSHI_APP_SEED");
            this.seed = stripQuotes(seed);
        }
        return this.seed;
    }

    public void setSeed(String seed) {
        this.seed = stripQuotes(seed);
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getUsername() {
        if (this.username == null) {
            String username = this.getEnvVariable("TOSHI_APP_USERNAME");
            this.username = stripQuotes(username);
        }
        return this.username;
    }

    public void setUsername(String username) {
        this.username = stripQuotes(username);
    }

    public String getName() {
        if (this.name == null) {
            String name = this.getEnvVariable("TOSHI_APP_NAME");
            this.name = stripQuotes(name);
        }
        return this.name;
    }

    public void setName(String name) {
        this.name = stripQuotes(name);
    }

    public String getAbout(){
        if (this.about == null) {
            String about = this.getEnvVariable("TOSHI_APP_ABOUT");
            this.about = stripQuotes(about);
        }
        return this.about;
    }

    public void setAbout(String about) {
        this.about = stripQuotes(about);
    }

    public String getAvatar() {
        return (avatar != null) ? avatar : this.getEnvVariable("TOSHI_APP_AVATAR");
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public RedisConfiguration getRedis() {
        return redis;
    }

    public void setRedis(RedisConfiguration redis) {
        this.redis = redis;
    }

    public StorageConfiguration getStorage() {
        return storage;
    }

    public void setStorage(StorageConfiguration storage) {
        this.storage = storage;
    }

    public String getNetwork() {
        return this.network;
    }

    public void setNetwork(String network) {
        if (network == null) { return; }
        if (network.startsWith("$")) {
            network = this.getEnvVariable(network.substring(1));
        }
        this.network = stripQuotes(network);
    }

    public String getNetworkId() {
        return this.networkId;
    }

    public void setNetworkId(String networkId) {
        if (networkId == null) { return; }
        if (networkId.startsWith("$")) {
            networkId = this.getEnvVariable(networkId.substring(1));
        }
        this.networkId = stripQuotes(networkId);
    }

    public String getToshi_id_service_url() {
        return toshi_id_service_url;
    }

    public void setToshi_id_service_url(String toshi_id_service_url) {
        this.toshi_id_service_url = toshi_id_service_url;
    }


    public String getToshi_exchange_service_url() {
        return toshi_exchange_service_url;
    }

    public void setToshi_exchange_service_url(String toshi_exchange_service_url) {
        this.toshi_exchange_service_url = toshi_exchange_service_url;
    }

    public String getToshi_ethereum_service_url() {
        return toshi_ethereum_service_url;
    }

    public void setToshi_ethereum_service_url(String toshi_ethereum_service_url) {
        this.toshi_ethereum_service_url = toshi_ethereum_service_url;
    }

    public void setIs_public(Boolean is_public) {
        this.is_public = is_public;
    }

    public Boolean getIs_public() {
        return this.isPublic();
    }

    public void setPublic(Boolean is_public) {
        this.is_public = is_public;
    }

    public Boolean isPublic() {
        if (is_public != null) {
            return is_public;
        }
        String pub = System.getenv("TOSHI_APP_IS_PUBLIC");
        if (pub == null) {
            return false;
        }
        pub = pub.toLowerCase();
        if (pub.equals("") || pub.equals("0") || pub.equals("false") || pub.equals("f")) {
            return false;
        }
        return true;
    }
}
