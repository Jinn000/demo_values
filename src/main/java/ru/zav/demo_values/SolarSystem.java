package ru.zav.demo_values;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class SolarSystem {
    private final SpaceObject mLargestPlanet;
    private final SpaceObject mSmallestPlanet;

    public SolarSystem(@Qualifier("planet")SpaceObject large_planet, @Qualifier("gasplanet") SpaceObject small_planet){
        mLargestPlanet = large_planet;
        mSmallestPlanet = small_planet;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(mLargestPlanet.toString());
        sb.append("\n");
        sb.append(mSmallestPlanet.toString());
        return sb.toString();
    }
}

@Component("planet")
@Scope("prototype")
@PropertySource("classpath:values.properties")
class Planet implements SpaceObject{
    @Value("${name0}")
    String mName;
    @Value("${orbit0}")
    long mOrbit;

    @Override
    public String toString(){
        return String.format("%s : %d", this.getName(), this.getOrbit());
    }

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public long getOrbit() {
        return mOrbit;
    }
}
@Component("gasplanet")
@Scope("prototype")
class GasPlanet extends Planet{
    @Value("${density0}")
    long mDensity;

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(" : ");
        sb.append(mDensity);
        return sb.toString();
    }
}
