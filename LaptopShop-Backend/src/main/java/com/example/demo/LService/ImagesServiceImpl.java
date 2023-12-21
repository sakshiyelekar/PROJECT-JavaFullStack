package com.example.demo.LService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.LEntity.Images;
import com.example.demo.LRepository.ImagesRepository;


@Service
public class ImagesServiceImpl implements ImagesService {
    private final ImagesRepository imagesRepository;

    @Autowired
    public ImagesServiceImpl(ImagesRepository imagesRepository) {
        this.imagesRepository = imagesRepository;
    }

    @Override
    public Images saveImages(Images images) {
        return imagesRepository.save(images);
    }

    @Override
    public List<Images> getAllImages() {
        return imagesRepository.findAll();
    }

    @Override
    public Images getImagesById(Long id) {
        return imagesRepository.findById(id).orElse(null);
    }

    @Override
    public Images updateImages(Long id, Images images) {
        Images existingImages = imagesRepository.findById(id).orElse(null);
        if (existingImages != null) {
        	existingImages.setImage1(images.getImage1());
        	existingImages.setImage2(images.getImage2());
        	existingImages.setImage3(images.getImage3());
        	existingImages.setImage4(images.getImage4());
        	existingImages.setImage5(images.getImage5());

            return imagesRepository.save(existingImages);
        }
        return null;
    }

    @Override
    public Images deleteImages(Long id) {
        imagesRepository.deleteById(id);
		return null;
    }
}