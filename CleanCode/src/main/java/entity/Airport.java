package main.java.entity;

import main.java.entity.plane.ExperimentalPlane;
import main.java.entity.plane.MilitaryPlane;
import main.java.entity.plane.PassengerPlane;
import main.java.entity.plane.Plane;
import main.java.entity.type.MilitaryType;


import java.util.*;


public class Airport {
    private List<? extends Plane> planes;

    public void setPlanes(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        List<PassengerPlane> passengerPlanes = new ArrayList<>();
        for (Plane plane : this.planes) {
            if (plane instanceof PassengerPlane) {
                passengerPlanes.add((PassengerPlane) plane);
            }
        }

        return passengerPlanes;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : this.planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            }
        }

        return militaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        PassengerPlane planeWithMaxCapacity = getPassengerPlanes().get(0);

        for (PassengerPlane passengerPlane : getPassengerPlanes()) {
            if (passengerPlane.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlane;
            }
        }

        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();

        for (MilitaryPlane militaryPlane : getMilitaryPlanes()) {
            if (militaryPlane.getMilitaryType() == MilitaryType.TRANSPORT) {
                transportMilitaryPlanes.add(militaryPlane);
            }
        }

        return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();

        for (MilitaryPlane militaryPlane : getMilitaryPlanes()) {
            if (militaryPlane.getMilitaryType() == MilitaryType.BOMBER) {
                bomberMilitaryPlanes.add(militaryPlane);
            }
        }

        return bomberMilitaryPlanes;

    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();

        for (Plane plane : this.planes) {
            if (plane instanceof ExperimentalPlane) {
                experimentalPlanes.add((ExperimentalPlane) plane);
            }
        }

        return experimentalPlanes;
    }

    @Override
    public String toString() {
        return "by.epam.aircompany.entity.airport.Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

    public Airport sortByMaxDistance() {
        planes.sort(new Comparator<Plane>() {
            public int compare(Plane object1, Plane object2) {
                return object1.getMaxFlightDistance() - object2.getMaxFlightDistance();
            }
        });

        return this;
    }

    /**
     * Sorts by max speed
     * @return by.epam.aircompany.entity.airport.Airport
     */
    public Airport sortByMaxSpeed() {
        planes.sort(new Comparator<Plane>() {
            public int compare(Plane object1, Plane object2) {
                return object1.getMaxSpeed() - object2.getMaxSpeed();
            }
        });

        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        planes.sort(new Comparator<Plane>() {
            public int compare(Plane object1, Plane object2) {
                return object1.getMaxLoadCapacity() - object2.getMaxLoadCapacity();
            }
        });

        return this;
    }
}