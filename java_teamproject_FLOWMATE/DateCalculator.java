import java.time.LocalDate;

public class DateCalculator {
	private LocalDate lastPeriodEndDate;
	private LocalDate nextPeriodStartDate;
	private LocalDate nextPeriodEndDate;
	private LocalDate fertileStartDate;
	private LocalDate fertileEndDate;
	private LocalDate ovulationDate;

    public String calculateNextMenstrualPeriod(LocalDate lastPeriodEndDate, int cyper) {
        nextPeriodStartDate = lastPeriodEndDate.plusDays(cyper); 
        nextPeriodEndDate = nextPeriodStartDate.plusDays(7); 

        String formattedStartDate = nextPeriodStartDate.toString();
        String formattedEndDate = nextPeriodEndDate.toString();

        return formattedStartDate + " ~ " + formattedEndDate;
    }
	
    public String calculateFertileWindow(LocalDate lastPeriodStartDate) {
        fertileStartDate = lastPeriodStartDate.plusDays(14); 
        fertileEndDate = lastPeriodStartDate.plusDays(18); 

        return fertileStartDate.toString() + " ~ " + fertileEndDate.toString();
    }
	

    public String calculateOvulationDate(LocalDate lastPeriodStartDate) {
        ovulationDate = lastPeriodStartDate.plusDays(16);
        return ovulationDate.toString();
    }

	public LocalDate getNextPeriodStart()
	{
		return nextPeriodStartDate;
	}

	public LocalDate getNextPeriodEnd()
	{
		return nextPeriodEndDate;
	}

	public LocalDate getFertileStart()
	{
		return fertileStartDate;
	}

	public LocalDate getFertileEnd()
	{
		return fertileEndDate;
	}

	public LocalDate getOvulation()
	{
		return ovulationDate;
	}
}
