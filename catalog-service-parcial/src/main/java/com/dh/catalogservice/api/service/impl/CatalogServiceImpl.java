package com.dh.catalogservice.api.service.impl;

import com.dh.catalogservice.api.service.CatalogService;
import com.dh.catalogservice.api.service.MovieFeignClient;
import com.dh.catalogservice.domain.model.dto.CatalogWS;
import com.dh.catalogservice.domain.model.dto.MovieWS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CatalogServiceImpl implements CatalogService {

	public static Logger LOG = LoggerFactory.getLogger(CatalogService.class);

	private final MovieFeignClient movieFeignClient;


	@Autowired
	public CatalogServiceImpl(MovieFeignClient movieFeignClient) {
		this.movieFeignClient = movieFeignClient;

	}

	@Override
	public CatalogWS findCatalogByGenre(String genre) {
		ResponseEntity<List<MovieWS>> movieResponse = movieFeignClient.findMovieByGenre(genre);
		LOG.info("Puerto de la Instancia: " + movieResponse.getHeaders().get("port"));
		if (movieResponse.getStatusCode().is2xxSuccessful())
			return new CatalogWS(genre, movieResponse.getBody());
		return null;
	}
}

