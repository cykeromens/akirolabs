/* generated using openapi-typescript-codegen -- do no edit */
/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { GenerateTokenRequest } from '../models/GenerateTokenRequest';
import type { GenerateTokenResponse } from '../models/GenerateTokenResponse';

import type { CancelablePromise } from '../core/CancelablePromise';
import { OpenAPI } from '../core/OpenAPI';
import { request as __request } from '../core/request';

export class TokenGeneratorService {

    /**
     * generate token with digits.
     * @param requestBody
     * @returns GenerateTokenResponse successful operation
     * @throws ApiError
     */
    public static generate(
        requestBody: GenerateTokenRequest,
    ): CancelablePromise<GenerateTokenResponse> {
        return __request(OpenAPI, {
            method: 'POST',
            url: '/api/generate',
            body: requestBody,
            mediaType: 'application/json',
            errors: {
                400: `Invalid username supplied`,
                404: `User not found`,
            },
        });
    }

}
