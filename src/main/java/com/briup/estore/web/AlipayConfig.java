package com.briup.estore.web;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

public class AlipayConfig {
	public static String serverUrl = "https://openapi.alipaydev.com/gateway.do";
	public static String appId = "2016103000779787";
	
	public static String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCUJ2LzwrsqUfxH7DU5luvt3kaj+KtVVHzUkbcOMJLas+7cTBkXprnia+37rWDPw9ARRwMttJIqUmnDLdoI86Pv3v8rK+G0pcKJ0RjGnxMZ8eTq0WTHgsKBtkS3miqjJWgY4CbSWUBTNW/Xzte7Y71Gq/H8AWqWaGZy75i8CZc6XB6xQjw4wQUElAtB7aPCE4L5wyPi+M0VYBiisBBvmPtdHrEAOp8VDSfhmtWa9RpUsXIMIbPjS4i64keOblAhc2B6NMFq68d3kZAegmplgwjiR6HlM5RlhdAE0a56ma9o9PRmccRh/ncq+pfT6aSOtCE4l0Zmk2aBjBo3VTVg7XgRAgMBAAECggEAYVsIgVqDl6nMeI7V4wQ0AVnBXdr469fbN+yRODffKOx4mDdBffNHz2xRNMOYDK+GOPRLOGuiaUFC0sl8r8k6/1OwpnPtm8IZdmr7NvotmS0F2vDCowBgRNC7k1MxlYftQft6R1vzEzrYRh5cUX2XUauIFqvvmOr996VO3rIGuIfyvO4fCG7AOnq1Dphvy2Ey6z+k/8MAjsxIlIGW3YIje7A3KUgoS94ii2UVEe3t4tFxZ5UL+HhhzQAgVTMNdLcDPOIMmh4Y/IgwKxEBk3M8xYuwabzmtVH8Ce3hrp6YXBYzfk2xF9jUIeguL/wm+wpWc8MpqwFOoXem87V5BVtTYQKBgQDbL5tJ5Fq22ly7hya8y4W7Lz17s5Bjp9mF/8UvmJS25afDhhtlMFi0IHn6QQzQcq9CT0ji1l/eE3rfUv8EPcScIGxQdPH+Ir5nHhcl0KjjtNvtSNS9TrzG+1Ja6c079nRoSqeGG19UwmrnrKmGWuwnw4DP+5J0Y3xXsRmL7YM9fQKBgQCtCZg6g8cKPL66EQhfATNCBDb51CBOBodTUwAdg3HgKZhdlzrJZu50b1MAMDg0qz28XQVm6Sg88spxuS98WWbvgeZYLwmXhpWGWzrjiv3VeIHXsqduHDbeABsSMsr1hI7K4Md6Dh1tsgUWt2Y3Mno5pN7vBzQzQ1fKiojEk3P5JQKBgQDGlKsslydY4x2BCUGfawUOQg6CNH1szHXXYZNVO/gAfLEyBB5t3w9+oq3gfW8Oq9j9SrfOTEsu+JcqHhfNz+iBSx7XBhz5EqFO64QtTo61PvbCVGnp2ZxO6wQCOjEnUnLEyl5csg/8yufwXg55G4c5v3bE+DgIGtpc2Kc8j0OIQQKBgEf5gbR1M8lyUvMaOp0p5qRDFIr+TSGnXYqvL5EXJ7rSEmp7iRxVEEKmO6QMapSd1eQP3TtdKDuR0dtT6AiVN1fQdHuhtR+t/2wPboNPQR4WLgwGZ9ZJLhlRefEr53gQV0TUEqUWUe9a6Pr19jJncKehiIlsOa5JCK9ayGDb5JVxAoGAItcOJ0g6ssxxKaSJ4et3LgufrVJv7/RU69ukMZV65aub/uVgTG3cOCZYqjn3S6Y9DGQ3eCceAfCsUhCtgIA92N5xS4kg2NjZ5S47XWB3G4GHvJPZ16RvUNpu300zqV96EFIn2g6g2No9HyU71R5r/z7I7eM9MTSFxJkz3l9ecH0=";
	
	public static String format = "json";
	
	public static String charset = "utf-8";
	
	public static String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn7nrXQgl81EyqMywJIxtxGF71UEkis/Uvdp5HI2FfxWhb7kkktBMzFhm53IE4xaWfqHkn+QOAib3L7SBYNUP6ft/2tfZSQBoK8jWs1V95vnwwEh4NvmUinQjswqkwqiEgVTAmvCgnR60h1R2qL3lFGUiGTP3Ge6y6pnwiUulpHlTeWtFbZn9egoChaAN0G3BRt1uUDwlxJb4iZa4By4J4oecpZMSq/TwVf3HJTRm6xb+7x7j9kWZGesP+qv1DafMu3tku/CwMxBxqN7a/moFrYSpCTIs31x9T8xqwCAbIGz8v/S0Pbb+X5TdxK1+4zJsiOL2pRPgepRdMPe0zYfDoQIDAQAB";
	
	public static String signType = "RSA2";
	
	public static String return_url ="http://127.0.0.1:8888/estore_3/toOrderSure";
	
	public static AlipayClient getAlipayClient() {
		AlipayClient alipayClient = new DefaultAlipayClient(serverUrl, appId, privateKey, format, charset, publicKey, signType);
		
		return alipayClient;
	}
}
