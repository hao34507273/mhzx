/*    */ package mzm.gsp.addiction.pro;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import gnet.link.Onlines;
/*    */ import jsonio.JsonStream;
/*    */ import mzm.gsp.addiction.pro.core.GeneralPkgReq;
/*    */ import mzm.gsp.addiction.pro.core.PkgHead;
/*    */ import mzm.gsp.grc.main.GrcInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ProManager
/*    */ {
/*    */   public static PkgHead getHeader(String reqInfo)
/*    */   {
/* 16 */     JsonStream js = new JsonStream(reqInfo);
/* 17 */     PkgHead header = new PkgHead();
/* 18 */     js.unmarshal("common_msg", header);
/* 19 */     return header;
/*    */   }
/*    */   
/*    */   public static boolean queryGameConfig()
/*    */   {
/* 24 */     PkgHead header = PkgHead.create(1);
/* 25 */     GameConfInfoReq body = new GameConfInfoReq();
/* 26 */     GeneralPkgReq req = new GeneralPkgReq(header, body);
/* 27 */     OctetsStream context = new OctetsStream();
/* 28 */     context.marshal(0);
/* 29 */     return GrcInterface.antiAddictProxy(req.toString(), context);
/*    */   }
/*    */   
/*    */   public static void queryUserInfo(String userid, long roleid)
/*    */   {
/* 34 */     PkgHead header = PkgHead.create(userid, 2);
/* 35 */     if (header == null)
/*    */     {
/* 37 */       return;
/*    */     }
/*    */     
/* 40 */     String openid = Onlines.getInstance().findOpenid(userid);
/* 41 */     GetUserInfoReq body = new GetUserInfoReq();
/* 42 */     body.account_id = openid;
/* 43 */     body.character_id = String.valueOf(roleid);
/* 44 */     body.access_token = Onlines.getInstance().findOpenKey(userid);
/*    */     
/* 46 */     GeneralPkgReq req = new GeneralPkgReq(header, body);
/* 47 */     OctetsStream context = new OctetsStream();
/* 48 */     context.marshal(0);
/* 49 */     GrcInterface.antiAddictProxy(req.toString(), context);
/*    */   }
/*    */   
/*    */   public static void updateUserInfo(String userid, long roleid, int seconds, int msgType)
/*    */   {
/* 54 */     PkgHead header = PkgHead.create(userid, msgType);
/* 55 */     if (header == null)
/*    */     {
/* 57 */       return;
/*    */     }
/*    */     
/* 60 */     String openid = Onlines.getInstance().findOpenid(userid);
/* 61 */     UpdateUserInfoReq body = new UpdateUserInfoReq();
/* 62 */     body.account_id = openid;
/* 63 */     body.character_id = String.valueOf(roleid);
/* 64 */     body.this_period_time = seconds;
/*    */     
/* 66 */     GeneralPkgReq req = new GeneralPkgReq(header, body);
/* 67 */     OctetsStream context = new OctetsStream();
/* 68 */     context.marshal(0);
/* 69 */     GrcInterface.antiAddictProxy(req.toString(), context);
/*    */   }
/*    */   
/*    */   public static void reportRemind(String userid, long roleid, int type, long time)
/*    */   {
/* 74 */     PkgHead header = PkgHead.create(userid, 8);
/* 75 */     if (header == null)
/*    */     {
/* 77 */       return;
/*    */     }
/*    */     
/* 80 */     String openid = Onlines.getInstance().findOpenid(userid);
/* 81 */     RemindInfo remindInfo = new RemindInfo();
/* 82 */     remindInfo.account_id = openid;
/* 83 */     remindInfo.character_id = String.valueOf(roleid);
/* 84 */     remindInfo.report_type = type;
/* 85 */     remindInfo.report_time = time;
/*    */     
/* 87 */     ReportRemindBatchReq body = new ReportRemindBatchReq();
/* 88 */     body.addRemindInfo(remindInfo);
/*    */     
/* 90 */     GeneralPkgReq req = new GeneralPkgReq(header, body);
/* 91 */     OctetsStream context = new OctetsStream();
/* 92 */     context.marshal(0);
/* 93 */     GrcInterface.antiAddictProxy(req.toString(), context);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\pro\ProManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */