package com.example.safekorea.DTO;

import java.time.LocalDateTime;

import com.example.safekorea.domain.entity.Board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class BoardDTO {

	private Long id;
	private String writer;
	private String title;
	private String content;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	
	public Board toEntity() {
		Board build = Board.builder()
				.id(id)
				.writer(writer)
				.title(title)
				.content(content)
				.build();
		return build;
	}
	
	@Builder
	public BoardDTO(Long id, String title, String content, String writer,LocalDateTime createdDate , LocalDateTime modifiedDate) {
		this.id = id;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		
	}
}
