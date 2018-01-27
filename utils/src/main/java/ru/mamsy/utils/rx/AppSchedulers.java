package ru.mamsy.utils.rx;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Static factory methods for returning standard Scheduler instances.
 */
public class AppSchedulers {

    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors(); // количество доступных ядер процессора
    private static final int CORE_POOL_SIZE = CPU_COUNT + 1; // количество потоков для работы
    private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1; // максимальное количество потоков для работы
    private static final int KEEP_ALIVE = 1;

    private static final Executor NETWORK_EXECUTOR = new ThreadPoolExecutor(
            CORE_POOL_SIZE,
            MAXIMUM_POOL_SIZE,
            KEEP_ALIVE,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(128), // количество задач очереди
            r -> new Thread(r, "NetworkThread"));

    private static final ExecutorService DB_EXECUTOR = Executors.newSingleThreadExecutor(r -> new Thread(r, "DbThread"));
    private static final Scheduler DB_SCHEDULER = Schedulers.from(DB_EXECUTOR);
    private static final Scheduler NETWORK_SCHEDULER = Schedulers.from(NETWORK_EXECUTOR);

    /**
     * Возвращает Scheduler для работы с БД.
     */
    public static Scheduler db() {
        return DB_SCHEDULER;
    }

    /**
     * Возвращает Scheduler для работы с сетью.
     */
    public static Scheduler network() {
        return NETWORK_SCHEDULER;
    }
}
