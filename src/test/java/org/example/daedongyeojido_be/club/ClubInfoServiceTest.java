//package org.example.daedongyeojido_be.club;
//
//import org.example.daedongyeojido_be.domain.club.domain.Club;
//import org.example.daedongyeojido_be.domain.club.exception.ClubNotFoundException;
//import org.example.daedongyeojido_be.domain.club.presentation.dto.response.ClubInfoResponse;
//import org.example.daedongyeojido_be.domain.club.repository.ClubRepository;
//import org.example.daedongyeojido_be.domain.club.service.ClubInfoService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.BDDMockito.given;
//
//@ExtendWith(MockitoExtension.class)
//class ClubInfoServiceTest {
//
//    @Mock
//    private ClubRepository clubRepository;
//
//       @InjectMocks
//    private ClubInfoService clubInfoService;
//
//    @Test
//    void shouldReturnClubInfo_whenClubExists() {
//        // Given
//        Club club = new Club(1L, "Coding Club", "Best coders", "Learn coding", "image.jpg", "banner.jpg");
//        given(clubRepository.findByClubName(String.valueOf(1L))).willReturn(Optional.of(club));
//
//        // When
//        ClubInfoResponse response = clubInfoService.getClubInfo(String.valueOf(1L));
//
//        // Then
//        assertThat(response.clubName()).isEqualTo("Coding Club");
//        assertThat(response.title()).isEqualTo("Best coders");
//    }
//
//    @Test
//    void shouldThrowException_whenClubNotFound() {
//        // Given
//        given(clubRepository.findByClubName(String.valueOf(99L))).willReturn(Optional.empty());
//
//        // When / Then
//        assertThrows(ClubNotFoundException.class, () -> clubInfoService.getClubInfo(String.valueOf(99L)));
//    }
//}
