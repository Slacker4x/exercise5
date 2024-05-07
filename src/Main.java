import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Scanner scanner = new Scanner(System.in);

        // Ввод первой даты
        System.out.println("Введите дату в формате dd.MM.yyyy:");
        String inputDate1 = scanner.next();
        Date date1 = sdf.parse(inputDate1);

        // Увеличение даты на 45 дней
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        cal.add(Calendar.DATE, 45);
        System.out.println("Дата после увеличения на 45 дней: " + sdf.format(cal.getTime()));

        // Сдвиг даты на начало года
        cal.setTime(date1);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println("Дата после сдвига на начало года: " + sdf.format(cal.getTime()));

        // Увеличение даты на 10 рабочих дней
        int workDays = 10;
        int daysAdded = 0;
        while (daysAdded < workDays) {
            cal.add(Calendar.DATE, 1);
            if (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                daysAdded++;
            }
        }
        System.out.println("Дата после увеличения на 10 рабочих дней: " + sdf.format(cal.getTime()));

        // Ввод второй даты
        System.out.println("Введите вторую дату в формате dd.MM.yyyy:");
        String inputDate2 = scanner.next();
        Date date2 = sdf.parse(inputDate2);

        // Подсчет количества рабочих дней между двумя датами
        int workDaysCount = 0;
        cal.setTime(date1);
        while (cal.getTime().before(date2)) {
            if (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                workDaysCount++;
            }
            cal.add(Calendar.DATE, 1);
        }
        System.out.println("Количество рабочих дней между введенными датами: " + workDaysCount);
    }
}