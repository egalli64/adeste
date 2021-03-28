package adeste.svc;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import adeste.dao.Course;
import adeste.dao.CourseRepo;

@Service
public class CourseSvc {
    private static final Logger log = LogManager.getLogger(CourseSvc.class);

    private CourseRepo repo;

    public CourseSvc(CourseRepo repo) {
        this.repo = repo;
    }

    public Optional<Course> getLatest() {
        log.traceEntry();
        return repo.findFirstByOrderByLastDesc();
    }
}
