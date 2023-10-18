/* generated using openapi-typescript-codegen -- do no edit */
/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { ValidateTokenRequest } from '../models/ValidateTokenRequest';
import type { ValidateTokenResponse } from '../models/ValidateTokenResponse';

import type { CancelablePromise } from '../core/CancelablePromise';
import { OpenAPI } from '../core/OpenAPI';
import { request as __request } from '../core/request';

export class TokenValidatorService {

    /**
     * validate token.
     * @param requestBody
     * @returns ValidateTokenResponse successful operation
     * @throws ApiError
     */
    public static validate(
        requestBody: ValidateTokenRequest,
    ): CancelablePromise<ValidateTokenResponse> {
        return __request(OpenAPI, {
            method: 'POST',
            url: '/api/validate',
            body: requestBody,
            mediaType: 'application/json',
            errors: {
                400: `Invalid username supplied`,
                404: `User not found`,
            },
        });
    }

}
