package com.example.response

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_EMPTY)
class GenericResponse {
    var errorId: String? = ""
    var message: String? = "";
    var error: String? = "";
    var status: Int? = 0;

    constructor(errorId: String?,
                message: String?,
                error: String?,
                status: Int?, ) {
        this.errorId = errorId;
        this.message = message;
        this.error = error;
        this.status = status;
    }

    constructor(message: String?,
                error: String?,
                status: Int?,) {
        this.message = message;
        this.error = error;
        this.status = status;
    }

    constructor(message: String?,
                status: Int?,) {
        this.message = message;
        this.status = status;
    }

}