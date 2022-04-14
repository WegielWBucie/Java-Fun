import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

public class Clock
{
    public static void clock()
    {
        System.out.println("""
                Choose the action:\s
                1=> Time\s
                2=> Time zone\s
                3=> Stopwatch\s
                _________________________________________________________""");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1 -> {
                currentTime();
                clock();
            }
            case 2 -> {
                timeZone();
                clock();
            }
            case 3 -> {
                stopwatch(0);
                clock();
            }
        }
    }
    public static void currentTime()
    {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        Date trialDate = calendar.getTime();
        System.out.println(trialDate);
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.systemDefault());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy HH:mm:ss");
        System.out.println(localDateTime);
        System.out.println(localDateTime.format(dateTimeFormatter));

    }
    public static void timeZone()
    {
        Set<String> set = Calendar.getAvailableCalendarTypes();
        set.forEach((s) -> {
            System.out.println(s);});
        TimeZone timeZone = TimeZone.getDefault();
        String name = timeZone.getDisplayName();
        System.out.println("Display name for default time zone: " + name);
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        System.out.println(calendar.getTime());
        LocalDate date = LocalDate.now();
        System.out.println(date);
        System.out.println(date.format(DateTimeFormatter.ISO_ORDINAL_DATE));
        /*
        String[] id = TimeZone.getAvailableIDs();
        System.out.println("In TimeZone class available Ids are: ");
        for (int i=0; i<id.length; i++){
            System.out.println(id[i]);
        }
        */
    }
    private static void stopwatch(double basic)
    {
        try {
            System.out.println("Enter anything to start or 'back' to get back.");
            Scanner scanner = new Scanner(System.in);
            String start = scanner.nextLine();
            if(start.toLowerCase().trim().equals("back"))
                clock();
            else
            {
                if(start.toLowerCase().trim().equals("restart")) {
                    basic = 0;
                    System.out.println("Enter anything to start or 'back' to get back.");
                }
                double startTime = System.currentTimeMillis();
                System.out.println("Enter anything to stop.");
                String stop = scanner.next();
                double endTime = System.currentTimeMillis();
                double executionTime = (endTime - startTime) / 1000;
                executionTime += basic;
                //System.out.println(executionTime%3600); System.out.println((int)((executionTime%3600)/60)); String timeItTook = numberFormat.format(executionTime);
                NumberFormat secondsFormat = new DecimalFormat("#0.000");
                if (executionTime < 60)
                {
                    if ((int) (executionTime) == 1)
                        System.out.println("Time: " + secondsFormat.format(executionTime) + " second.");
                    else
                        System.out.println("Time: " + secondsFormat.format(executionTime) + " seconds.");
                }
                else if (executionTime >= 60 && executionTime < 3600)
                {
                    if ((int) (executionTime / 60) == 1)
                        System.out.println("Time: " + (int) (executionTime / 60) + " minute and " + secondsFormat.format(executionTime % 60) + " seconds.");
                    else
                        System.out.println("Time: " + (int) (executionTime / 60) + " minutes and " + secondsFormat.format(executionTime % 60) + " seconds.");
                }
                else if (executionTime >= 3600 && executionTime < 86_400)
                {
                    if ((int) (executionTime / 60) == 1)
                        System.out.println("Time: " + (int) (executionTime / 3600) + " hours " + (int) ((executionTime % 3600) / 60) + " minute and " + secondsFormat.format(executionTime % 60) + " seconds.");
                    else
                        System.out.println("Time: " + (int) (executionTime / 3600) + " hours " + (int) ((executionTime % 3600) / 60) + " minutes and " + secondsFormat.format(executionTime % 60) + " seconds.");
                }
                stopwatch(executionTime);
            }
        }
        catch (Exception exception) {
            Desktop.setChoice();
        }
    }
    public static void timer()
    {
        System.out.println("Enter start time: ");
        Scanner scanner = new Scanner(System.in);
        String startTime = scanner.nextLine();
        List<Integer>time = new ArrayList<>();
        for(int i=startTime.length()-1; i>=0; i--)
        {
            while(startTime.charAt(i) != ':')
                i--;
            //
        }
    }
}