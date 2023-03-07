package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job(){
        id = nextId;
        nextId ++;
    }
    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency){
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    //TODO code toString() method to pass the first test
    //TODO see if I can create a loop to go through each field in the job object, get the label and add the data for the
    //field


    public String toString() {

//TODO rework the fields with if statements += this.getId() if the field is not empty. if empty, add "Data not available"
        //TODO add all of the fields together to return to user.
        String jobFormat = " ";
        String errMsg = "Data not available";

        if (name.equals("")) {
              name = errMsg;
        }
        if (employer.getValue().equals("") || employer.getValue() == null) {
          employer.setValue(errMsg);
        }
        if(location.getValue().equals("") || location.getValue() == null){
            location.setValue(errMsg);
        }
        if(positionType.getValue().equals("") || positionType.getValue() == null) {
            positionType.setValue(errMsg);
        }
        if(coreCompetency.getValue().equals("") || coreCompetency.getValue() == null) {
            coreCompetency.setValue("Data not available");
        }

        String idField = "ID: " + this.getId();
        String nameField = "\nName: " + this.getName();
        String employerField = "\nEmployer: " + this.getEmployer().getValue();
        String locationField = "\nLocation: " + this.getLocation().getValue();
        String positionTypeField = "\nPosition Type: " + this.getPositionType().getValue();
        String coreCompetencyField = "\nCore Competency: " + this.getCoreCompetency().getValue();

        jobFormat = "\n" + idField + nameField + employerField + locationField + positionTypeField + coreCompetencyField + "\n";
        return jobFormat;
        }

    }



