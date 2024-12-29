package com.aky.lostfound;

import com.aky.lostfound.dto.ClaimItemDto;
import com.aky.lostfound.entity.ClaimItem;
import com.aky.lostfound.entity.LostItem;
import com.aky.lostfound.repository.ClaimItemRepository;
import com.aky.lostfound.repository.LostItemRepository;
import com.aky.lostfound.service.ClaimItemService;
import com.aky.lostfound.service.LostItemService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class LostfoundApplicationTests {
	@Autowired
	private LostItemService lostItemService;

	@MockBean
	private LostItemRepository lostItemRepository;

	@Autowired
	private ClaimItemService claimItemservice;

	@MockBean
	private ClaimItemRepository claimItemRepository;

	@Test
	public void viewAllClaimTest(){
		when(claimItemRepository.findAll()).thenReturn(Stream.of
				(new ClaimItem("Laptop",1,"Taxi","1001"),
				 new ClaimItem("Headphones",2,"Railway station","1001"),
				 new ClaimItem("Jewels",4,"Airport","1001")).collect(Collectors.toList()));
		assertEquals(3,claimItemservice.viewAllClaim().size());
	}

	@Test
	public void claimByUserIdTest(){

		List<ClaimItem> claimItems = new ArrayList<>();
		claimItems.add(new ClaimItem("Laptop",1,"Taxi","1001"));
		claimItems.add(new ClaimItem("Headphones",2,"Railway station","1001"));
		claimItems.add(new ClaimItem("Jewels",4,"Airport","1001"));

		List<ClaimItemDto> claimItemsDto = new ArrayList<>();
		claimItemsDto.add(new ClaimItemDto("Laptop",1,"Taxi","1001","1001UserName"));
		claimItemsDto.add(new ClaimItemDto("Headphones",2,"Railway station","1001", "1001UserName"));
		claimItemsDto.add(new ClaimItemDto("Jewels",4,"Airport","1001", "1001UserName"));

		when(claimItemRepository.saveAll(claimItems)).thenReturn(claimItems);
		assertEquals("claimed sucessfully",claimItemservice.claimByUserId("1001",claimItemsDto));

	}

    @Test
    public void viewAllTest(){

		when(lostItemRepository.findAll()).thenReturn(Stream.of
				       (new LostItem("Jewels",4,"Airport"),
						new LostItem("Laptop",1,"Taxi"),
						new LostItem("Headphones",2,"Railway station")
				).collect(Collectors.toList()));

		assertEquals(3,lostItemService.viewAll().size());
	}
}
