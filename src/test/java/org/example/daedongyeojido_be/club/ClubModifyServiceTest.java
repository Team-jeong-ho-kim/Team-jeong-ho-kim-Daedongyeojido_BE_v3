//package org.example.daedongyeojido_be.club;
//
//import org.example.daedongyeojido_be.domain.club.domain.Club;
//import org.example.daedongyeojido_be.domain.club.exception.ClubNotFoundException;
//import org.example.daedongyeojido_be.domain.club.presentation.dto.request.ModifyClubRequest;
//import org.example.daedongyeojido_be.domain.club.repository.ClubRepository;
//import org.example.daedongyeojido_be.domain.club.service.ClubModifyService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//
//
//import java.util.Optional;
//
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.verify;
//import static org.assertj.core.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.*;
//@ExtendWith(MockitoExtension.class)
//class ClubModifyServiceTest {
//
//    @Mock
//    private ClubRepository clubRepository;
//
//    @InjectMocks
//    private ClubModifyService clubModifyService;
//
//    @Test
//    void shouldModifyClub_whenClubExists() {
//        // Given
//        Club club = new Club(1L, "Old Club", "Old Title", "Old Intro", "old_image.jpg", "old_banner.jpg");
//        ModifyClubRequest request = new ModifyClubRequest(1L, "New Club", "New Title", "New Intro", "new_image.jpg", "new_banner.jpg");
//
//        given(clubRepository.findByClubName(1L)).willReturn(Optional.of(club));
//
//        // When
//        clubModifyService.modifyClub(request);
//
//        // Then
//        verify(clubRepository).findByClubName(String.valueOf(1L));
//        assertThat(club.getClubName()).isEqualTo("New Club");
//        assertThat(club.getTitle()).isEqualTo("New Title");
//    }
//
//    @Test
//    void shouldThrowException_whenClubNotFound() {
//        // Given
//        ModifyClubRequest request = new ModifyClubRequest(99L, "Club", "Title", "Intro", "image.jpg", "banner.jpg");
//        given(clubRepository.findByClubName(String.valueOf(1L))).willReturn(Optional.empty());
//
//        // When / Then
//        assertThrows(ClubNotFoundException.class, () -> clubModifyService.modifyClub(request));
//    }
//}
