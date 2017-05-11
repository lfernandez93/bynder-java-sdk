/**
 * Copyright (c) 2017 Bynder B.V. All rights reserved.
 * <p>
 * Licensed under the MIT License. See LICENSE file in the project root for full license
 * information.
 */
package com.bynder.sdk.query;

/**
 * Query with the information to finalise a completely uploaded file.
 */
public class FinaliseUploadQuery {

	/**
	 * Upload id for the file being uploaded.
	 */
	@ApiField(name = "id")
	private String uploadId;

	/**
	 * Target id in the authorisation information returned
	 *
	 */
	@ApiField(name = "targetid")
	private String targetId;

	/**
	 * Base location of the uploaded file.
	 */
	@ApiField(name = "s3_filename")
	private String s3Filename;

	/**
	 * Total number of chunks uploaded.
	 */
	@ApiField(name = "chunks")
	private int chunks;

	/**
	 * original fileName uploaded
	 */
	@ApiField(name = "original_filename")
	private String originalFileName;

	public FinaliseUploadQuery(final String uploadId, final String targetId, final String s3Filename, final int chunks,final String originalFileName) {
		this.uploadId = uploadId;
		this.targetId = targetId;
		this.s3Filename = s3Filename;
		this.chunks = chunks;
		this.originalFileName = originalFileName;
	}

	public String getUploadId() {
		return uploadId;
	}

	public String getTargetId() {
		return targetId;
	}

	public String getS3Filename() {
		return s3Filename;
	}

	public int getChunks() {
		return chunks;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}
}
