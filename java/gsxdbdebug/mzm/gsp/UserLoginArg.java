/*    */ package mzm.gsp;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import org.apache.log4j.Logger;
/*    */ import org.json.JSONObject;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UserLoginArg
/*    */ {
/*    */   public final String gameAppid;
/*    */   public final int platid;
/*    */   public final boolean fakePlat;
/*    */   public final int telecomOper;
/*    */   public final String channelid;
/*    */   public final String registerChannelid;
/*    */   public final JSONObject jsonParams;
/*    */   private final JSONObject jsonLoginStateInfo;
/*    */   
/*    */   public UserLoginArg(Octets deviceInfo, Octets loginStateInfo)
/*    */   {
/* 51 */     if (deviceInfo.size() > 0)
/*    */     {
/* 53 */       String deviceInfoStr = deviceInfo.getString("UTF-8");
/* 54 */       JSONObject jsonDeviceInfo = new JSONObject(deviceInfoStr);
/* 55 */       this.gameAppid = jsonDeviceInfo.getString("gameAppid");
/* 56 */       this.platid = jsonDeviceInfo.getInt("platid");
/* 57 */       this.fakePlat = (!jsonDeviceInfo.isNull("fakePlatform"));
/* 58 */       this.telecomOper = jsonDeviceInfo.getInt("telecomOper");
/* 59 */       this.channelid = jsonDeviceInfo.getString("channelid");
/* 60 */       this.registerChannelid = jsonDeviceInfo.getString("registerChannelid");
/* 61 */       Object jsonParamsObj = jsonDeviceInfo.get("paramMap");
/* 62 */       if ((jsonParamsObj != null) && ((jsonParamsObj instanceof JSONObject)))
/*    */       {
/* 64 */         this.jsonParams = ((JSONObject)jsonParamsObj);
/*    */       }
/*    */       else
/*    */       {
/* 68 */         this.jsonParams = new JSONObject();
/* 69 */         GameServer.logger().error(String.format("UserLoginArg.<init>@json parse error|device_info=%s", new Object[] { deviceInfoStr }));
/*    */       }
/*    */     }
/*    */     else
/*    */     {
/* 74 */       this.gameAppid = "1";
/* 75 */       this.platid = 100;
/* 76 */       this.fakePlat = false;
/* 77 */       this.telecomOper = 0;
/* 78 */       this.channelid = "";
/* 79 */       this.registerChannelid = "";
/* 80 */       this.jsonParams = new JSONObject();
/*    */     }
/*    */     
/* 83 */     if (loginStateInfo.size() > 0)
/*    */     {
/* 85 */       this.jsonLoginStateInfo = new JSONObject(loginStateInfo.getString("UTF-8"));
/*    */     }
/*    */     else
/*    */     {
/* 89 */       this.jsonLoginStateInfo = new JSONObject();
/*    */     }
/*    */   }
/*    */   
/*    */   public final JSONObject getLoginStateInfo()
/*    */   {
/* 95 */     return this.jsonLoginStateInfo;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\UserLoginArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */