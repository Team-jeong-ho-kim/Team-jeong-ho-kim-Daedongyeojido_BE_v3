//package org.example.daedongyeojido_be.club;
//
//import org.example.daedongyeojido_be.domain.club.domain.Club;
//import org.example.daedongyeojido_be.domain.club.presentation.dto.response.AllClubResponse;
//import org.example.daedongyeojido_be.domain.club.repository.ClubRepository;
//import org.example.daedongyeojido_be.domain.club.service.ClubAllInfoService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.BDDMockito.given;
//
//@ExtendWith(MockitoExtension.class)
//class ClubAllInfoServiceTest {
//
//    @Mock
//    private ClubRepository clubRepository;
//
//    @InjectMocks
//    private ClubAllInfoService clubAllInfoService;
//
//    @Test
//    void shouldReturnAllClubs() {
//        // Given
//        Club club1 = new Club(1L, "Club One", "Title One", "Intro One", "image1.jpg", "banner1.jpg");
//        Club club2 = new Club(2L, "Club Two", "Title Two", "Intro Two", "image2.jpg", "banner2.jpg");
//        given(clubRepository.findAll()).willReturn(List.of(club1, club2));
//
//        // When
//        List<AllClubResponse> responses = clubAllInfoService.getAllClubs();
//
//        // Then
//        assertThat(responses).hasSize(2);
//        assertThat(responses.get(0).clubName()).isEqualTo("Club One");
//        assertThat(responses.get(1).clubName()).isEqualTo("Club Two");
//    }
//}
