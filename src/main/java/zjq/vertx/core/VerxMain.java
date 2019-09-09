package zjq.vertx.core;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

/**
 * vertx建立web服务
 * 
 * @author zhangjq
 * @date 2018年12月14日下午7:36:52
 *
 **/
public class VerxMain extends AbstractVerticle {

	@Override
	public void start() throws Exception {
		this.vertx.createHttpServer().requestHandler(req -> {
			req.response().putHeader("content-type", "text/html").end("hello vertx");
		}).listen(8080, res -> {
			if (res.succeeded()) {
				System.out.println("server is now on");
			} else {
				System.out.println("server failed");
			}
		});
	}

	@Override
	public void stop() throws Exception {
		super.stop();
	}

	public static void main(String[] args) throws Exception {
		Vertx.vertx().deployVerticle(new VerxMain());
	}

}
