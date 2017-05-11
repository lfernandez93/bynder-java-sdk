/**
 * Copyright (c) 2017 Bynder B.V. All rights reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for full license
 * information.
 */
package com.bynder.sdk.service.impl;

import java.util.List;
import java.util.Map;

import com.bynder.sdk.api.BynderApi;
import com.bynder.sdk.model.*;
import com.bynder.sdk.query.MediaDownloadQuery;
import com.bynder.sdk.query.MediaInfoQuery;
import com.bynder.sdk.query.MediaPropertiesQuery;
import com.bynder.sdk.query.MediaQuery;
import com.bynder.sdk.query.MetapropertyQuery;
import com.bynder.sdk.query.UploadQuery;
import com.bynder.sdk.service.AssetBankService;
import com.bynder.sdk.service.upload.FileUploader;
import com.bynder.sdk.util.Utils;

import io.reactivex.Observable;
import retrofit2.Response;

/**
 * Implementation of {@link AssetBankService}.
 */
public class AssetBankServiceImpl implements AssetBankService {

    /**
     * Instance of {@link BynderApi} which handles the HTTP communication with the Bynder API.
     */
    private final BynderApi bynderApi;
    /**
     * Instance to upload files to Bynder.
     */
    private final FileUploader fileUploader;

    /**
     * Initialises a new instance of the class.
     *
     * @param bynderApi Instance to handle the HTTP communication with the Bynder API.
     */
    public AssetBankServiceImpl(final BynderApi bynderApi) {
        this.bynderApi = bynderApi;
        this.fileUploader = new FileUploader(bynderApi);
    }

    /**
     * Check {@link AssetBankService} for more information.
     */
    @Override
    public Observable<Response<List<Brand>>> getBrands() {
        return bynderApi.getBrands();
    }

    /**
     * Check {@link AssetBankService} for more information.
     */
    @Override
    public Observable<Response<List<Tag>>> getTags() {
        return bynderApi.getTags();
    }

    /**
     * Check {@link AssetBankService} for more information.
     */
    @Override
    public Observable<Response<Map<String, Metaproperty>>> getMetaproperties(final MetapropertyQuery metapropertyQuery) throws IllegalAccessException {
        Map<String, String> params = Utils.getApiParameters(metapropertyQuery);
        return bynderApi.getMetaproperties(params);
    }

    /**
     * Check {@link AssetBankService} for more information.
     */
    @Override
    public Observable<Response<List<Media>>> getMediaList(final MediaQuery mediaQuery) throws IllegalAccessException {
        Map<String, String> params = Utils.getApiParameters(mediaQuery);
        return bynderApi.getMediaList(params);
    }

    /**
     * Check {@link AssetBankService} for more information.
     */
    @Override
    public Observable<Response<Media>> getMediaInfo(final MediaInfoQuery mediaInfoQuery) throws IllegalAccessException {
        Map<String, String> params = Utils.getApiParameters(mediaInfoQuery);
        return bynderApi.getMediaInfo(params);
    }

    /**
     * Check {@link AssetBankService} for more information.
     */
    @Override
    public Observable<Response<DownloadUrl>> getMediaDownloadUrl(final MediaDownloadQuery mediaDownloadQuery) {
        if (mediaDownloadQuery.getMediaItemId() == null) {
            return bynderApi.getMediaDownloadUrl(mediaDownloadQuery.getMediaId());
        } else {
            return bynderApi.getMediaDownloadUrl(mediaDownloadQuery.getMediaId(), mediaDownloadQuery.getMediaItemId());
        }
    }

    /**
     * Check {@link AssetBankService} for more information.
     */
    @Override
    public Observable<Response<Void>> setMediaProperties(final MediaPropertiesQuery mediaPropertiesQuery) throws IllegalAccessException {
        Map<String, String> params = Utils.getApiParameters(mediaPropertiesQuery);
        return bynderApi.setMediaProperties(params);
    }

    /**
     * Check {@link AssetBankService} for more information.
     */
    @Override
    public Observable<Response<SavedMediaResponse>> uploadFile(final UploadQuery uploadQuery) {
        return fileUploader.uploadFile(uploadQuery);
    }
}
