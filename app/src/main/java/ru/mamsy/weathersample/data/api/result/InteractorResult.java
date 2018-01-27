package ru.mamsy.weathersample.data.api.result;

/**
 * @author Maxim Berezin
 */
public class InteractorResult {
    private final ResultStatus status;

    public InteractorResult(ResultStatus status) {
        this.status = status;
    }

    public ResultStatus getStatus() {
        return status;
    }

    public boolean isOk() {
        return ResultStatus.OK == status;
    }
}
