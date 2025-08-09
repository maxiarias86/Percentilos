package fetal.percentiles;

import org.apache.commons.math3.distribution.NormalDistribution;

/**
 * Utility methods to compute biometric percentiles based on the equations
 * described by Hadlock et al. (1984).
 */
public class PercentileCalculator {

    private static final NormalDistribution NORMAL = new NormalDistribution();

    private PercentileCalculator() {
        // Utility class
    }

    /**
     * Calculates menstrual age in weeks as a decimal value.
     */
    public static double menstrualAge(int weeks, int days) {
        return weeks + days / 7.0;
    }

    public static double hcPercentile(double ma, double hcMm) {
        double mean = (-11.48 + 1.562 * ma - 0.0002548 * Math.pow(ma, 3)) * 10;
        double sd = 9.56;
        return toPercentile(hcMm, mean, sd);
    }

    public static double bpdPercentile(double ma, double bpdMm) {
        double mean = (-19.61 + 0.7565 * ma - 0.000111 * Math.pow(ma, 3)) * 10;
        double sd = 2.32;
        return toPercentile(bpdMm, mean, sd);
    }

    public static double acPercentile(double ma, double acMm) {
        double mean = (-174.5 + 5.608 * ma - 0.000217 * Math.pow(ma, 3)) * 10;
        double sd = 14.57;
        return toPercentile(acMm, mean, sd);
    }

    public static double flPercentile(double ma, double flMm) {
        double mean = (-12.12 + 0.2467 * ma - 0.00000337 * Math.pow(ma, 3)) * 10;
        double sd = 1.75;
        return toPercentile(flMm, mean, sd);
    }

    private static double toPercentile(double measured, double mean, double sd) {
        double z = (measured - mean) / sd;
        return NORMAL.cumulativeProbability(z) * 100.0;
    }
}

