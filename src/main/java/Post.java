import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ip",
        "hostname",
        "city",
        "region",
        "country",
        "loc",
        "org",
        "postal",
        "timezone",
        "readme"
})
public class Post {

    @JsonProperty("ip")
    private String ip;
    @JsonProperty("hostname")
    private String hostname;
    @JsonProperty("city")
    private String city;
    @JsonProperty("region")
    private String region;
    @JsonProperty("country")
    private String country;
    @JsonProperty("loc")
    private String loc;
    @JsonProperty("org")
    private String org;
    @JsonProperty("postal")
    private String postal;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("readme")
    private String readme;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ip")
    public String getIp() {
        return ip;
    }

    @JsonProperty("ip")
    public void setIp(String ip) {
        this.ip = ip;
    }

    @JsonProperty("hostname")
    public String getHostname() {
        return hostname;
    }

    @JsonProperty("hostname")
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("loc")
    public String getLoc() {
        return loc;
    }

    @JsonProperty("loc")
    public void setLoc(String loc) {
        this.loc = loc;
    }

    @JsonProperty("org")
    public String getOrg() {
        return org;
    }

    @JsonProperty("org")
    public void setOrg(String org) {
        this.org = org;
    }

    @JsonProperty("postal")
    public String getPostal() {
        return postal;
    }

    @JsonProperty("postal")
    public void setPostal(String postal) {
        this.postal = postal;
    }

    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("readme")
    public String getReadme() {
        return readme;
    }

    @JsonProperty("readme")
    public void setReadme(String readme) {
        this.readme = readme;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Point{" +
                "ip='" + ip + '\'' +
                ", country='" + country + '\'' +
                ", org='" + org + '\'' +
                '}';
    }
}