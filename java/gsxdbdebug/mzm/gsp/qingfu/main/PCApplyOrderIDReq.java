/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import gnet.GDeliveryManager;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.qingfu.confbean.SQingfuCfg;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import openau.ApplyOrderId;
/*    */ import openau.ApplyOrderIdArg;
/*    */ import org.apache.log4j.Logger;
/*    */ import org.json.JSONObject;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCApplyOrderIDReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int cfgid;
/*    */   private final Octets appid;
/*    */   private final Octets ext;
/*    */   
/*    */   public PCApplyOrderIDReq(long roleId, int cfgid, Octets appid, Octets ext)
/*    */   {
/* 28 */     this.roleId = roleId;
/* 29 */     this.appid = appid;
/* 30 */     this.cfgid = cfgid;
/* 31 */     this.ext = ext;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 37 */     if (!QingfuManager.canDoAction(this.roleId, 311))
/*    */     {
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     SQingfuCfg cfg = SQingfuCfg.get(this.cfgid);
/* 43 */     if (cfg == null)
/*    */     {
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     String userId = RoleInterface.getUserId(this.roleId);
/* 49 */     if (userId == null)
/*    */     {
/* 51 */       return false;
/*    */     }
/*    */     
/* 54 */     ApplyOrderIdArg arg = new ApplyOrderIdArg();
/* 55 */     arg.appid = this.appid;
/* 56 */     arg.account = Octets.wrap(userId, "UTF-8");
/* 57 */     arg.roleid = this.roleId;
/* 58 */     arg.zoneid = CommonUtils.getZoneId(userId);
/* 59 */     arg.productid = Octets.wrap(cfg.productId, "UTF-8");
/* 60 */     arg.productamount = cfg.buyAmount;
/* 61 */     if (QingfuManager.isMidasMode)
/*    */     {
/* 63 */       JSONObject jsonMidasInfo = new JSONObject();
/* 64 */       jsonMidasInfo.put("cfgid", cfg.id);
/* 65 */       jsonMidasInfo.put("cashamount", cfg.gainYuanbao);
/* 66 */       jsonMidasInfo.put("genamount", cfg.commonPresentYuanbao);
/* 67 */       jsonMidasInfo.put("firstsave_genamount", cfg.activityPresentYuanbao);
/* 68 */       if ((cfg.productServiceType != 0) && (cfg.productServiceId > 0))
/*    */       {
/* 70 */         jsonMidasInfo.put("servicetype", cfg.productServiceType);
/* 71 */         jsonMidasInfo.put("serviceid", cfg.productServiceId);
/* 72 */         jsonMidasInfo.put("durationdays", cfg.productServiceDurationDays);
/*    */       }
/* 74 */       arg.reserved2.setString(jsonMidasInfo.toString(), "UTF-8");
/*    */     }
/* 76 */     arg.clientext = this.ext;
/* 77 */     OctetsStream os = new OctetsStream();
/* 78 */     os.marshal(this.roleId);
/* 79 */     os.marshal(this.cfgid);
/* 80 */     arg.serverext = os;
/* 81 */     ApplyOrderId rpc = new ApplyOrderId(arg);
/* 82 */     boolean result = GDeliveryManager.getInstance().send(rpc);
/* 83 */     if (!result)
/*    */     {
/* 85 */       GameServer.logger().error(String.format("PCApplyOrderIDReq@send rpc to auany failure|roleid=%d|cfgid=%s|appid=%s|ext=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.cfgid), this.appid.getString("UTF-8"), this.ext.getString("UTF-8") }));
/*    */       
/*    */ 
/*    */ 
/* 89 */       QingfuManager.onApplyOrderTimeout(arg);
/*    */     }
/*    */     
/* 92 */     GameServer.logger().info(String.format("PCApplyOrderIDReq@send rpc to auany success|roleid=%d|cfgid=%s|appid=%s|ext=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.cfgid), this.appid.getString("UTF-8"), this.ext.getString("UTF-8") }));
/*    */     
/*    */ 
/*    */ 
/* 96 */     return result;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\PCApplyOrderIDReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */