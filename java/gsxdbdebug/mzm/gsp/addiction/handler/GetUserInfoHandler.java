/*     */ package mzm.gsp.addiction.handler;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import jsonio.JsonStream;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.addiction.pro.GetUserInfoResp;
/*     */ import mzm.gsp.addiction.pro.core.CommRsp;
/*     */ import mzm.gsp.grc.main.GrcInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.OnlineInfo;
/*     */ 
/*     */ public class GetUserInfoHandler implements Handler
/*     */ {
/*     */   public void handle(String data)
/*     */   {
/*  19 */     CommRsp commRsp = new CommRsp();
/*  20 */     JsonStream js = new JsonStream(data);
/*  21 */     js.unmarshal("comm_rsp", commRsp);
/*     */     
/*  23 */     if (commRsp.ret != 0)
/*     */     {
/*  25 */       GameServer.logger().error(String.format("[addiction]GetUserInfoHandler.handle@get user info handler error|ret=%d|error_msg=%s", new Object[] { Integer.valueOf(commRsp.ret), commRsp.err_msg }));
/*     */       
/*     */ 
/*  28 */       return;
/*     */     }
/*     */     
/*  31 */     GetUserInfoResp userInfo = new GetUserInfoResp();
/*  32 */     js.unmarshal("user_info", userInfo);
/*     */     
/*  34 */     new POnQueryUserInfo(userInfo.account_id, Long.parseLong(userInfo.character_id), userInfo.is_adult, userInfo.accumu_time, userInfo.age).execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onFailed(int retCode, String queryInfo, Octets context)
/*     */   {
/*  41 */     OctetsStream stream = new OctetsStream(context);
/*  42 */     int count = 0;
/*     */     try
/*     */     {
/*  45 */       count = stream.unmarshal_int();
/*     */     }
/*     */     catch (MarshalException e) {}
/*     */     
/*     */ 
/*     */ 
/*  51 */     if (count == 0)
/*     */     {
/*  53 */       stream.clear();
/*  54 */       stream.marshal(1);
/*  55 */       GrcInterface.antiAddictProxy(queryInfo, stream);
/*     */     }
/*  57 */     GameServer.logger().error(String.format("[addiction]GetUserInfoHandler.onFailed@handle failed|count=%d|retcode=%d|query_info=%s", new Object[] { Integer.valueOf(count), Integer.valueOf(retCode), queryInfo }));
/*     */   }
/*     */   
/*     */ 
/*     */   private static class POnQueryUserInfo
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final String openid;
/*     */     private final long roleid;
/*     */     private final int isAdult;
/*     */     private final int accumuTime;
/*     */     private final int age;
/*     */     
/*     */     public POnQueryUserInfo(String openid, long roleid, int isAdult, int accumuTime, int age)
/*     */     {
/*  72 */       this.openid = openid;
/*  73 */       this.roleid = roleid;
/*  74 */       this.isAdult = isAdult;
/*  75 */       this.accumuTime = accumuTime;
/*  76 */       this.age = age;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  82 */       OnlineInfo xOnlineInfo = xtable.Role2onlineinfo.get(Long.valueOf(this.roleid));
/*  83 */       if (xOnlineInfo == null)
/*     */       {
/*  85 */         GameServer.logger().error(String.format("[addiction]POnQueryUserInfo.processImp@logic error|openid=%s|roleid=%d|is_adult=%d|accumu_time=%d|age=%d", new Object[] { this.openid, Long.valueOf(this.roleid), Integer.valueOf(this.isAdult), Integer.valueOf(this.accumuTime), Integer.valueOf(this.age) }));
/*     */         
/*     */ 
/*     */ 
/*  89 */         return false;
/*     */       }
/*     */       
/*  92 */       xOnlineInfo.setIs_adult(this.isAdult);
/*  93 */       xOnlineInfo.setAccumu_time(this.accumuTime);
/*  94 */       xOnlineInfo.setAge(this.age);
/*     */       
/*  96 */       GameServer.logger().info(String.format("[addiction]POnQueryUserInfo.processImp@query user info success|openid=%s|roleid=%d|is_adult=%d|accumu_time=%d|age=%d", new Object[] { this.openid, Long.valueOf(this.roleid), Integer.valueOf(this.isAdult), Integer.valueOf(this.accumuTime), Integer.valueOf(this.age) }));
/*     */       
/*     */ 
/*     */ 
/* 100 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\handler\GetUserInfoHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */