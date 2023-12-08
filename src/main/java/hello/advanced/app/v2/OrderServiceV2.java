package hello.advanced.app.v2;
import hello.advanced.hellotrace.HelloTraceV2;
import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class OrderServiceV2 {
    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 trace;

    public void orderItem(TraceId traceId, String itemId) {

        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId,"OrderService.request()");
            orderRepository.save(status.getTraceId(),itemId);
            trace.end(status);

        } catch (Exception e) {
            trace.exception(status, e);
            throw e; // 예외를 반드시 던져줘야함
        }
    }
}
