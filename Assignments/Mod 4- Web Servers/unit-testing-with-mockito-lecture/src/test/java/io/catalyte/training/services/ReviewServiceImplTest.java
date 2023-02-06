package io.catalyte.training.services;

import io.catalyte.training.domains.Review;
import io.catalyte.training.exceptions.ServerError;
import io.catalyte.training.repositories.ReviewRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataAccessResourceFailureException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ReviewServiceImplTest {

  @InjectMocks
  ReviewServiceImpl reviewService;

  @Mock
  ReviewRepo mockReviewRepo;

  @BeforeEach
  public void before() {
    MockitoAnnotations.openMocks(this);

    when(mockReviewRepo.findById(any(String.class)))
        .thenReturn(Optional.of(new Review()));
  }

  @Test
  public void givenReviewId_whenFindById_thenReturnReview() {
    Review review = reviewService.getReviewById("");
    assertNotNull(review);
  }

  @Test
  public void givenIdThatDoesNotExist_whenFindById_thenReturnNull() {
    when(mockReviewRepo.findById(any(String.class)))
        .thenReturn(Optional.empty());

    Review review = reviewService.getReviewById("");
    assertNull(review);
  }

  @Test
  public void givenServerError_whenFindById_thenThrowException() {
    when(mockReviewRepo.findById(any(String.class))).thenThrow(
        DataAccessResourceFailureException.class);
    assertThrows(ServerError.class,
        () -> reviewService.getReviewById(""));
  }
}