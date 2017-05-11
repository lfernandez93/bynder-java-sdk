/**
 * Copyright (c) 2017 Bynder B.V. All rights reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for full license
 * information.
 */
package com.bynder.sdk.query;

/**
 * Query with the information to upload a file.
 */
public class UploadQuery {

    /**
     * File path of the file we want to upload.
     */
    private String filepath;
    /**
     * Brand id where we want to store the file.
     */
    private String brandId;
    /**
     * Media id. If specified it will add the media asset file as new version of the specified
     * media. Otherwise a new media asset will be added to the asset bank.
     */
    private String mediaId;
    /**
     *  Flags if the media asset should be sent to the waiting room.
     */
    private Boolean audit;

    /**
     * The file name of the asset, will become s3 original fileName
     */
    private String fileName;

    public UploadQuery(final String filepath, final String brandId,final String fileName) {
        this.filepath = filepath;
        this.brandId = brandId;
        this.fileName = fileName;
    }

    public String getFilepath() {
        return filepath;
    }

    public String getBrandId() {
        return brandId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public UploadQuery setMediaId(final String mediaId) {
        this.mediaId = mediaId;
        return this;
    }

    public Boolean isAudit() {
        return audit;
    }

    public UploadQuery setAudit(final Boolean audit) {
        this.audit = audit;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
