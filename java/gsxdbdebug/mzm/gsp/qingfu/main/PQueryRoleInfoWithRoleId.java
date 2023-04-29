/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.qingfu.confbean.SQingfuCfg;
/*    */ import mzm.gsp.role.main.Role;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import openau.QueryRoleInfoWithRoleIdArg;
/*    */ import openau.QueryRoleInfoWithRoleIdRes;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PQueryRoleInfoWithRoleId
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final QueryRoleInfoWithRoleIdArg arg;
/*    */   private final QueryRoleInfoWithRoleIdRes res;
/*    */   
/*    */   public PQueryRoleInfoWithRoleId(QueryRoleInfoWithRoleIdArg arg, QueryRoleInfoWithRoleIdRes res)
/*    */   {
/* 23 */     this.arg = arg;
/* 24 */     this.res = res;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/*    */     try
/*    */     {
/* 32 */       long roleId = this.arg.roleid;
/* 33 */       String platId = this.arg.platid.getString("UTF-8");
/* 34 */       String payPlatId = this.arg.payplatid.getString("UTF-8");
/* 35 */       String gameOrderId = this.arg.gameorderid.getString("UTF-8");
/* 36 */       String productId = this.arg.productid.getString("UTF-8");
/* 37 */       int cfgId = QingfuManager.getCfgIdByProductId(payPlatId, productId);
/* 38 */       SQingfuCfg cfg = SQingfuCfg.get(cfgId);
/*    */       
/* 40 */       Role role = RoleInterface.getRole(roleId, false);
/* 41 */       String userId = role.getUserId();
/* 42 */       this.res.account = Octets.wrap(userId, "UTF-8");
/* 43 */       this.res.zoneid = CommonUtils.getZoneId(userId);
/* 44 */       this.res.productamount = cfg.buyAmount;
/* 45 */       this.res.rolename = Octets.wrap(role.getName(), "UTF-8");
/* 46 */       this.res.rolelevel = role.getLevel();
/*    */       
/* 48 */       OctetsStream os = new OctetsStream();
/* 49 */       os.marshal(roleId).marshal(cfgId);
/* 50 */       this.res.serverext = os;
/* 51 */       this.res.retcode = 0;
/*    */       
/* 53 */       GameServer.logger().info(String.format("PQueryRoleInfoWithRoleId@query role info with role id success|roleid=%d|userid=%s|platid=%s|pay_platid=%s|game_order_id=%s|productid=%s|cfgid=%d|product_amount=%d", new Object[] { Long.valueOf(roleId), userId, platId, payPlatId, gameOrderId, productId, Integer.valueOf(cfgId), Integer.valueOf(cfg.buyAmount) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 58 */       return true;
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 62 */       this.res.retcode = 4;
/*    */       
/* 64 */       throw e;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\PQueryRoleInfoWithRoleId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */