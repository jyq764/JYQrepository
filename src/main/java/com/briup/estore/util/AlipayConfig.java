package com.briup.estore.util;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

public class AlipayConfig {
  /**
   * 服务网关   沙箱环境都是这个
   */
  public static String serverUrl = "https://openapi.alipaydev.com/gateway.do";
  
  /**
   * 应用id  后期可以替换成自己的id
   */
  public static String appId = "2021000119680024";
  
  /**
   *  用户私钥   后期替换成自己的私钥
   */
  public static String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCZ1ftiHNRn4jtE/U6Oj86+yQdE7zMDjaGuQ1dLr+YaVLwIxySCXMnGOgxxhYZujZ97ltEX3PJg3Jrb7gLYeBtOcI5F9PUC1SR0IkcMwHHeRUiShq2SepdhwIuVJ4bJ3oi5W8xqh71CtYqiAdk42gP62v/xty9Qe/HzroBDFrbIqUkW7OoTX8mphh7j7ZTu/gkeeTwku/DUgXDIMAs0TJwtbbYiONVNEVw5dcJN6RAszRReHVW4lc2YQW/bBroNh8nFOJH+tr2aME8uQyVK4W5vcK8Hy03IF47i7ss9uyPCV46tzMvZ3O72wp0TUAdPOUtbPoO8AabFdgSKsFSD4zs5AgMBAAECggEBAIGTjfTsV7VRB59qxdqrIvfsmGTmHlAl4kPIkSU9elI/gUrbgtMTmRmRF54fXEaOoAEX3fN9teMErqQFbPws3sNJZ21hkWbbZaM0pCgHiWIxdZmGO3mgLRa3elseOhibiwqmWh55S19/TtB7Qh7y9Fs+UEungwEGBZy+JWddIIUPUQW7Wxc+lPFdAohH1qRr7GF4KZC8d5/W59ylHiyj0el51h8PcixVpfK/Tl+3c5x5FBadUG7qAYYhMAEFj1a6is3JM8e73v3URd33aEyjyV+xuvbiQnz7WQwHRAQwoc0cGR0V3+rnI++Hfmmgloj0uyPX6yA8ZDYL2+CDZrq6YkkCgYEA43Kjb1l8JlduHYq5mEVXLPMX+ZEI9pa3H4fo8s4JoRWE2Eg0nehGYlPo7CV8VFGkzkm+QuzOz7sK98R+0tQgZpGEsnuOZ4AUgPf03a7IRyyav9tl4yB72Z6Jjs7rjiL1reet2bMvqfjjv+fQ22jivvnfrod6KIu9s5k0l7cuursCgYEArSW34FANq+jcCu7Ouis4poQob7ueYqFfsW0I0ajy+M5EYDn8t2idcZkse31iga73yAPMt8nT2EWU0sTbZTSgtZcrAOhI6Cg/Rk3XAsxRl4KFrKZsCFor+yEq3jz7gHLrF3tXTjrdGM/GvWgyebzmkg3TS3rH0pRt7kraAMtTxJsCgYAhUvCDJfc8nt6xUVvz5WTqXwuKMye/CUH3SrBksq9SfJakIaAj6p41Vdnwj2Vx7SxaVQ+dOpjqcpsexhlWxmGg5X0tsVCh9XALnUixGiSZ2P0rUvfQmTfMIKBC3ipA/vpD6ofcN5aqLp8fxNUi8HEYTf/p0EujmSXIJJBCEkK0dQKBgECKd8EQdhgng6Y7oCl7JPHE/4GusPpY5t+vIgNs86zUzl4EH3SKdW27x/38HfTzMH+JEw1LGUFbpn7uTE2sUV9/CtOawlpvbi6Zo1TyrlNInuVdX5W5bv18Pot6tdEKhSFKo5+Qh4vRH2bI6U/BnzzAFIvlJ4kSNOwHUL3NDNuTAoGBAJqprOHJod1EvYAON1V6AhgAnDKV/UMSdHLWUcuTWwSdYO+7+cvRXf7+Hr3Ynu7tvNxvjGWUY76r2nO6GsXy7JbU00IbW6Jqfr9ocAXxyQTS9Vg3XQ4LsuSfHHCHPhmTZg3Lw57zQ+dGCGDao+gs1i9tv0iOUQnnFtj2jehxn+hW";
  
  /**
   *  发送数据的格式 目前只能为json
   */
  public static String format = "json";
  
  /**
   *  设置字符集编码 目前只能为utf-8
   */
  public static String charset = "utf-8";

  /**
   *  支付宝公钥 后期替换成自己的支付宝公钥
   */
  public static String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhJ6bJNSEfjir1FOWnQeQ+KFHKn6nc29Vs4Q1GI36d83vzquFLqXzzfW5yoNY0dE9+RfzHPEy0uXZrorXPtyPIedojI/hJHh7szCzypRCukSRRSerA2PITgDHKT2VMCI7BNEMGeDQ4DGu0f5KYuizPyQQEdtodWqhGNEWoqOMESyrW08sVBrPObu7lUvAR9OrOlCfvnp/ehUP20jv0fMj3taSsPKvMSQEvN6zGsfp3PXKpGpKn96s8jMH4YDbcemC5gAU2xFJzGY57mQcl1uUnJ6GLvke7UtxQh1bN+YnQu+pZcb5J4us022Se59NmX988TfIuzF2nYD7lpLzk9KBPwIDAQAB";
  
  /**
   *  支付宝签名 目前是 RSA2
   */
  public static String signType = "RSA2";

  /**
   *  页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
   */
  public static String return_url = "http://127.0.0.1:8989/JD03_estore/index.jsp";
  
  public static AlipayClient getAlipayClient() {
      // 获得初始化的AlipayClient
      AlipayClient alipayClient = new DefaultAlipayClient
    		  (AlipayConfig.serverUrl, AlipayConfig.appId, 
    		AlipayConfig.privateKey, AlipayConfig.format, 
    		AlipayConfig.charset, AlipayConfig.publicKey, AlipayConfig.signType);
      return alipayClient;
  }

}