package elisa.kulturservice.service;

import elisa.kulturservice.model.Review;
import elisa.kulturservice.repository.ReviewRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ReviewService implements IReviewService{

    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Set<Review> findAll() {
        Set<Review> reviews = new HashSet<>();
        reviewRepository.findAll().forEach(reviews::add);
        return reviews;
    }

    @Override
    public Review save(Review object) {
        return reviewRepository.save(object);
    }

    @Override
    public void delete(Review object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Review> findById(Long aLong) {
        return reviewRepository.findById(aLong);
    }
}
