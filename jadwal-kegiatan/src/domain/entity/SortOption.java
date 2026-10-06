package domain.entity;

import java.util.Comparator;
import java.util.List;

/**
 * Kriteria pengurutan kegiatan.
 * Pengurutan hari mengikuti urutan pekan (Senin → Minggu), bukan abjad.
 */
public enum SortOption {
    /** Urutkan berdasarkan hari (Senin → Minggu), lalu waktu. */
    DAY(Comparator.comparingInt((Activity a) -> DayOrder.rankOf(a.getDay()))
            .thenComparing(Activity::getTime)),

    /** Urutkan berdasarkan waktu (paling pagi dulu). */
    TIME(Comparator.comparing(Activity::getTime)),

    /** Judul dari A ke Z (case-insensitive). */
    TITLE_ASC(Comparator.comparing(Activity::getTitle, String.CASE_INSENSITIVE_ORDER)),

    /** Judul dari Z ke A (case-insensitive). */
    TITLE_DESC(Comparator.comparing(Activity::getTitle, String.CASE_INSENSITIVE_ORDER).reversed());

    private final Comparator<Activity> comparator;

    SortOption(Comparator<Activity> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Activity> comparator() {
        return comparator;
    }

    /** Pemetaan nama hari ke peringkat dalam sepekan. Hari tak dikenal diletakkan paling akhir. */
    private static class DayOrder {
        private static final List<String> DAYS =
                List.of("senin", "selasa", "rabu", "kamis", "jumat", "sabtu", "minggu");

        static int rankOf(String day) {
            int index = DAYS.indexOf(day.trim().toLowerCase());
            return index < 0 ? DAYS.size() : index;
        }
    }
}

