package org.launchcode.techjobs.oo.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;
import static org.junit.Assert.*;


/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        String spec = "Test the empty job constructor: the ids of two new job objects should not be equal.";
        Job test_job = new Job();
        Job job_two = new Job();
        assertNotEquals(spec, test_job.getId(), job_two.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        String spec = "Test the full job constructor: the classes and values are set correctly";
        Job aJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
//TODO Use assertTrue and assertEquals statements to test that the constructor correctly
// assigns both the class and value of each field. Your test should have 5 assert statements of each type.
        assertTrue(aJob instanceof Job);
        assertTrue(aJob.getEmployer() instanceof Employer);
        assertTrue(aJob.getLocation() instanceof Location);
        assertTrue(aJob.getPositionType() instanceof PositionType);
        assertTrue(aJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(spec, aJob.getName(), "Product tester");
        assertEquals(spec, aJob.getEmployer().getValue(), "ACME");
        assertEquals(spec, aJob.getLocation().getValue(), "Desert");
        assertEquals(spec, aJob.getPositionType().getValue(), "Quality control");
        assertEquals(spec, aJob.getCoreCompetency().getValue(), "Persistence");
    }
    @Test
    public void testJobsForEquality(){
        String spec = "Two job objects are Not equal if all fields are identical except their id values.";
        Job aJob = new Job("Front End Developer", new Employer("LaunchCode"), new Location("St.Louis"),
                new PositionType("Web Developer"), new CoreCompetency("Being Awesome"));
        Job jobTwo = new Job("Front End Developer", new Employer("LaunchCode"), new Location("St.Louis"),
                new PositionType("Web Developer"), new CoreCompetency("Being Awesome"));
        assertNotEquals(spec, aJob, jobTwo);
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        String spec = "toString method starts and ends with a new line";
        Job aJob = new Job("Front End Developer", new Employer("LaunchCode"), new Location("St.Louis"),
                new PositionType("Web Developer"), new CoreCompetency("Being Awesome"));
      String jobFormat = aJob.toString();
        assertEquals(jobFormat.substring(0,1), '\n');
        assertEquals(jobFormat.substring(jobFormat.length()-1,jobFormat.length()), '\n');
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job aJob = new Job("Front End Developer", new Employer("LaunchCode"), new Location("St.Louis"),
                new PositionType("Web Developer"), new CoreCompetency("Being Awesome"));
        String jobFormat = aJob.toString();
        assertEquals(jobFormat,  "\n" + "\nName: " + aJob.getName() +
      "\nEmployer: " + aJob.getEmployer().getValue() +
        "\nLocation: " + aJob.getLocation().getValue() +
       "\nPosition Type: " + aJob.getPositionType().getValue() +
        "\nCore Competency: " + aJob.getCoreCompetency().getValue() + "\n");
    }
   //TODO If a field is empty, the method should add, 'Data not available' after the label.
   @Test
    public void testToStringHandlesEmptyField() {
        String spec = "If a field is empty 'Data not available' is included after the label";
        Job aJob = new Job("Front End Developer", new Employer("LaunchCode"), new Location("St.Louis"),
                new PositionType("Web Developer"), new CoreCompetency(""));
        aJob.toString();
        String expected = aJob.getCoreCompetency().getValue().toString();
       System.out.println(expected);
        assertEquals(expected,"Data not available");

    }

}

