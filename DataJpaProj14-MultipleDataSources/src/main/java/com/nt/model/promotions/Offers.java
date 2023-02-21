package com.nt.model.promotions;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MDS_OFFERS")
public class Offers implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer offerId;

	@NonNull
	@Column(length = 20)
	private String offerName;

	@NonNull
	@Column(length = 20)
	private String offerCode;

	@NonNull
	private Double discountPercentage;

	@NonNull
	private LocalDateTime expiryDate;
}
