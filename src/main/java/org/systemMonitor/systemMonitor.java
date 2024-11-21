package org.systemMonitor;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.software.os.OperatingSystem;


import java.util.Arrays;

public class systemMonitor {

    public static void main(String[] args) {
        // Tworzenie obiektu SystemInfo
        SystemInfo systemInfo = new SystemInfo();

        // Informacje o CPU i RAM
        CentralProcessor processor = systemInfo.getHardware().getProcessor();
        GlobalMemory memory = systemInfo.getHardware().getMemory();

        // Informacje o systemie operacyjnym
        OperatingSystem os = systemInfo.getOperatingSystem();

        // Wyświetlanie użycia CPU
        System.out.println("CPU Usage: " + Arrays.toString(processor.getSystemLoadAverage(3)));

        // Wyświetlanie RAM
        System.out.println("RAM Usage: " + (memory.getAvailable() / 1_000_000) + " MB / " + (memory.getTotal() / 1_000_000) + " MB");

        // Wyświetlanie uptime
        System.out.println("System Uptime: " + os.getSystemUptime() / 3600 + " hours");
    }
}
