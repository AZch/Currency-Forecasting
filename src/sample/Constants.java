package sample;

/**
 * Констаты программ:
 * 1) файлы с данными для чтения
 * 2) файл для экспорта данных
 * 3) результирующее сообщение
 * 4) задание комиссии в долях от 1
 * 5) сообщения для вывода пользователю
 * 6) возвращяемые коды
 * 7) имена и описание методов
 * 8) данные XML без названия методов
 */
public class Constants {
    // файлы с данными для чтения
    static final String WAY_START_DATA = "startData.txt";
    static final String OTHER_FILE_DATA = "data.txt";

    // файл для экспорта данных
    static final String FILE_TO_EXPORT = "export.txt";
    static final Boolean IS_APPEND_EXPORT = true;

    // результирующее сообщение
    public static final String bay_res = "Стоит брать";
    public static final String dont_bay_res = "Брать определенно не стоит";
    public static final String dont_know_bay_res = "Не знаю, стоит ли брать";

    // задание комиссии в долях от 1
    public static final Double commission = 0.1;

    // сообщения для вывода пользователю
    static final String EXPORT_DATA = "Даннные экспортированны!";
    static final String EXPORT_METHOD = "Метод экспортирован!";
    static final String GOOD_START_WORK = "Программа готова к работе!";
    static final String GOOD_LOAD_DATA = "Данные успешно загружены!";
    static final String GOOD_CREATE = "Метод создан успешно!";
    static final String GOOD_CALC = "Успешное вычисление!";
    static final String DATA_CLEAR = "Данные очищены!";
    static final String ERROR_WRITE_FILE = "При записи в файл произошла ошибка!";
    static final String WRITE_FILE = "Успешная запись в файл!";
    static final String ERROR_LOAD_XML = "Не удалось совершить загрузку из XML файла!";
    static final String COMPLETE_XML_LOAD = "Загрузка из XML файла прошла успешно!";
    static final String ERROR_DELETE = "Ошибка при удалении!";
    static final String COMPLETE_DELETE = "Удаление прошло успешно!";

    // возвращяемые коды
    static final int NORNAL_WRITE = 0;
    static final int ERROR_WRITE = -1;

    // имена и описание методов
    // Паритет пакупательной способности
    public static final String NAME_PPP = "Паритет пакупательной способности";
    public static final String NAME_XML_PPP = "PurchPowerParity";
    public static final String DESC_PPP = "Одним из важнейших экономических показателей государства является его ВВП.\n" +
            "Оптимальный вариант для подсчета мирового ВВП базируется на коэффициентах сравнения покупательской способности валют.\n" +
            "Значения этих коэффициентов определяются отношением цен покупательских корзин различных государств.\n" +
            "К примеру, карандаш в Канаде должен стоить столько же сколько стоит такой же карандаш в США, \n" +
            "с учётом обменного курса и исключая затраты на обменную операцию и транспортировку, то есть не должно быть поводов для спекуляций. \n" +
            "Следовательно из теории ППС, обменный курс должен изменяться таким образом, чтобы компенсировать рост цен из-за инфляции. \n" +
            "То есть, если цены в США в ближайший год должны вырасти на 4%, в то время как в Канаде на 2%, то инфляционный дифференциал составит: \n" +
            "4% - 2% = 2%, а значит темпы роста цен в США окажутся быстрее, чем такие же в Канаде.\n" +
            " Следовательно, согласно принципу паритета покупательной способности, американский доллар должен обесцениться приблизительно на 2% для того, \n" +
            "чтобы цены на товары в двух странах оставались относительно одинаковыми. Например, если обменный курс равнялся 90 американским центам за канадский доллар, \n" +
            "то согласно методу ППС, прогнозируемый курс составит:\n" +
            "(1 + 0,02) x (0,90 долл США за 1 канадский долл) = 0,918 долл США за 1 канадский долл\n" +
            "Это означает, что курс канадского доллара должен вырасти до 91,8 американского цента за доллар.\n";
    // Экономическая модель
    public static final String NAME_ECONOMIC = "Экономическая модель";
    public static final String NAME_XML_ECONOMIC = "EconomicModel";
    public static final String DESC_ECONOMIC = "Данная модель связывает обменный курс конкретной валюты со всеми факторами, влияющими, по мнению трейдера, на ее движение. \n" +
            "Обычно при построении эконометрической модели используются величины из экономической теории. \n" +
            "Однако в подсчеты может быть добавлена любая переменная, которая, как считается, оказывает сильное влияние на обменный курс.\n" +
            "Проведя детальный анализ, он должен определить:\n" +
            "•\tКакие именно показатели задействовать в расчётах;\n" +
            "•\tКакой вид должна иметь зависимость между отобранными показателями.\n" +
            "Например, разработчику прогнозов для одной из канадских компаний было поручено составить прогноз курса USD/CAD на ближайший год.\n" +
            "После тщательных исследований и анализа в качестве ключевых отбираются следующие факторы: \n" +
            "дифференциал процентных ставок США и Канады (INT), разница между темпами роста ВВП (GDP) и разница между темпами роста доходов населения в обеих странах (IGR). \n" +
            "Тогда эконометрическая модель будет выглядеть следующим образом:\n" +
            "USD/CAD (1 год) = z + a(INT) + b(GDP) + c(IGR)\n" +
            "Не вдаваясь в подробности касательно принципов построения уравнения, \n" +
            "после получения модели можно просто подставить переменные INT, GDP и IGR и получить необходимый прогноз. \n" +
            "Коэффициенты a, b и c определяют, насколько сильно каждый из перечисленных факторов влияет на обменный курс и направление движение \n" +
            "(в зависимости от того, значение коэффициента отрицательное или положительное).\n";
    // Метод сближения
    public static final String NAME_APPROACH = "Метод сближения";
    public static final String NAME_XML_APPROACH = "ApproachMethod";
    public static final String DESC_APPROACH = "Метод сближения (расхождения) показателя среднего движения валютного курса (MACD) \n" +
            "представляет собой метод технического анализа с помощью МACD-гистограммы. \n" +
            "График индикатора MACD состоит из двух линий, пересечение которых дает сигналы аналитикам и практикам рынка: \n" +
            "сплошная линия (быстрая) – собственно линия MACD, а пунктирная линия – сигнальная (медленная). \n" +
            "Линия MACD образуется двумя экспоненциальными показателями среднего движения курса. \n" +
            "Она реагирует на изменения цен довольно быстро. Сигнальная линия представляет собой более длительный временной период. \n" +
            "МАCD-гистограмма показывает, как участники рынка доминируют на рынке и какова сила их психологического настроя. \n" +
            "МАCD-гистограмма равна MACD-линии минус сигнальная линия. Данная разница изображается на графике в виде вертикалей, \n" +
            "откладываемых от нулевого уровня. Если быстрая линия выше сигнальной, то значение гистограммы положительно и откладывается вверх от горизонтального уровня. \n" +
            "Если быстрая линия расположена ниже медленной, то МАCD-гистограмма дает отрицательное значение и изображается ниже горизонтальной оси. \n";
    // Моментум
    public static final String NAME_MOMENTUM = "Моментум";
    public static final String NAME_XML_MOMENTUM = "Momentum";
    public static final String DESC_MOMENTUM = "Моментум (М0) отслеживает ускорение тренда, рост или снижение скорости его движения. \n" +
            "Каждое значение моментума вычисляется как разница между значениями курса через определенный временной интервал:\n" +
            "M0 = Pc - Pn, \n" +
            "где Рс – курс закрытия сегодня; Рn – курс закрытия п дней назад.\n" +
            "Моментум положителен, если сегодня курс выше, отрицателен – если ниже. \n" +
            "Он равняется нулю, если курс не изменился. Наклон линии, соединяющей моментумы каждого дня, показывает – растет моментум или падает. \n" +
            "Когда график моментума достигает нового максимума, это означает настрой рынка на дальнейшее повышение валютного курса. \n" +
            "Если валютный курс растет, а график моментума начинает падать, то это \"предупреждение\", что \"вершина\" тренда близка. \n" +
            "То же самое происходит при движении курса вниз\n";

    // данные XML без названия методов
    public static final String NAME = "name";
    public static final String DESC = "description";
    public static final String WHAT_AFTER_PERIOD = "WhatAfterPeriod";
    public static final String RATES = "StartRates";
    public static final String PARAMETRS = "parametrs";
    public static final String DATA_CLASS = "Data";
    public static final String CORRECT_DATA_CLASS = "CorrectData";
    public static final String NUM_DATA = "num";
    public static final String COURSE_N = "CourseN";
}
