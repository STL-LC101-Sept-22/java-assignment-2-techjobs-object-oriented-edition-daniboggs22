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
        Job aJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
//TODO Use assertTrue and assertEquals statements to test that the constructor correctly
// assigns both the class and value of each field. Your test should have 5 assert statements of each type.
        assertTrue(aJob instanceof Job);
        assertTrue(aJob.getEmployer() instanceof Employer);
        assertTrue(aJob.getLocation() instanceof Location);
        assertTrue(aJob.getPositionType() instanceof PositionType);
        assertTrue(aJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(aJob.getName(), "Product tester");
        assertEquals(aJob.getEmployer().getValue(), "ACME");
        assertEquals(aJob.getLocation().getValue(), "Desert");
        assertEquals(aJob.getPositionType().getValue(), "Quality control");
        assertEquals(aJob.getCoreCompetency().getValue(), "Persistence");
    }
    @Test
    public void testJobsForEquality(){
        Job aJob = new Job("Front End Developer", new Employer("LaunchCode"), new Location("St.Louis"),
                new PositionType("Web Developer"), new CoreCompetency("Being Awesome"));
        Job jobTwo = new Job("Front End Developer", new Employer("LaunchCode"), new Location("St.Louis"),
                new PositionType("Web Developer"), new CoreCompetency("Being Awesome"));
        assertFalse(aJob.equals(jobTwo));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job aJob = new Job("Front End Developer", new Employer("LaunchCode"), new Location("St.Louis"),
                new PositionType("Web Developer"), new CoreCompetency("Being Awesome"));
      String jobFormat = aJob.toString();
      System.out.println();
        assertEquals(jobFormat.charAt(0), '\n');
        assertEquals(jobFormat.charAt(jobFormat.length()-1), '\n');
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
        Job aJob = new Job("Front End Developer", new Employer("LaunchCode"), new Location("St.Louis"),
                new PositionType("Web Developer"), new CoreCompetency(""));
        aJob.toString();
        String expected = aJob.getCoreCompetency().getValue().toString();
        assertEquals(expected,"Data not available");
    }
}

