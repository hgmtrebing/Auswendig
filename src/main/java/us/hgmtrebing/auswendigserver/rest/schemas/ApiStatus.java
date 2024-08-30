package us.hgmtrebing.auswendigserver.rest.schemas;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema (description = "The status of API Operations.")
public enum ApiStatus {
    PASSED_COMPLETELY,
    PASSED_WITH_ERRORS,
    FAILED_COMPLETELY,
    UNKNOWN;

    public static ApiStatus merge(ApiStatus o1, ApiStatus o2) {

        if (o1 == PASSED_COMPLETELY && o2 == PASSED_COMPLETELY) {
            return PASSED_COMPLETELY;

        } else if (o1 == FAILED_COMPLETELY && o2 == FAILED_COMPLETELY) {
            return FAILED_COMPLETELY;

        } else if (o1 == UNKNOWN || o2 == UNKNOWN) {
            return UNKNOWN;

        } else {
            return PASSED_WITH_ERRORS;
        }
    }
}
