package usecase;

import domain.entity.Activity;
import domain.entity.SortOption;
import domain.repository.IActivityRepository;
import java.util.List;
import java.util.Optional;

/** Use case jadwal kegiatan. Tidak melakukan I/O. */
public class ActivityUseCase {
    private final IActivityRepository activityRepository;

    public ActivityUseCase(IActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    public Activity addActivity(String title, String day, String time) {
        return activityRepository.save(title, day, time);
    }

    public boolean removeActivity(int id) {
        return activityRepository.deleteById(id);
    }

    /**
     * Mengubah judul, hari, dan/atau waktu kegiatan.
     * Parameter {@code null} berarti field tersebut tidak diubah.
     *
     * @return true jika kegiatan ditemukan dan diperbarui
     */
    public boolean updateActivity(int id, String title, String day, String time) {
        Optional<Activity> found = activityRepository.findById(id);
        if (found.isEmpty()) {
            return false;
        }

        Activity activity = found.get();
        if (title != null) {
            activity.changeTitle(title);
        }
        if (day != null) {
            activity.changeDay(day);
        }
        if (time != null) {
            activity.changeTime(time);
        }

        activityRepository.update(activity);
        return true;
    }

    /** Mencari kegiatan berdasarkan judul (case-insensitive). */
    public List<Activity> searchActivities(String keyword) {
        String lowerKeyword = keyword.toLowerCase();
        return activityRepository.findAll().stream()
                .filter(activity -> activity.getTitle().toLowerCase().contains(lowerKeyword))
                .toList();
    }

    public List<Activity> sortActivities(SortOption option) {
        return activityRepository.findAll().stream()
                .sorted(option.comparator())
                .toList();
    }
}
