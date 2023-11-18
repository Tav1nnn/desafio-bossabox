package br.com.otavio.desafiobossabox.model.dto;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class TagDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    @NonNull
    private String name;
}
