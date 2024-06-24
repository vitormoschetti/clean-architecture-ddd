package br.com.cleanarch.infra.portfolio.entity;

import br.com.cleanarch.infra.converter.UUIDToStringConverter;
import br.com.cleanarch.infra.shared.entity.AuditEntity;
import br.com.cleanarch.infra.shared.entity.IEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "portfolio")
@Entity(name = "portfolioEntity")
public class PortfolioEntity implements IEntity {

    @Id
    @Column(name = "id")
    @Convert(converter = UUIDToStringConverter.class)
    private UUID id;

    @Column(name = "customerId", nullable = false)
    private Long customerId;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private Set<PortfolioItemEntity> items = new HashSet<>();

    @Embedded
    private AuditEntity audit;


}
