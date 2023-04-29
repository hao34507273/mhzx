/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.online.event.PlayerEnterProtectProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import openau.DataBetweenAuanyAndOthersReq;
/*    */ 
/*    */ public class POnRoleLogoff
/*    */   extends PlayerEnterProtectProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 16 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 18 */       return false;
/*    */     }
/*    */     
/* 21 */     if (QingfuManager.isMidasMode)
/*    */     {
/* 23 */       long roleid = ((Long)this.arg).longValue();
/* 24 */       String userid = RoleInterface.getUserId(((Long)this.arg).longValue());
/* 25 */       DataBetweenAuanyAndOthersReq req = new DataBetweenAuanyAndOthersReq();
/* 26 */       req.direction = 3;
/* 27 */       req.account = Octets.wrap(userid, "utf-8");
/* 28 */       req.zoneid = CommonUtils.getZoneId(userid);
/* 29 */       req.roleid = roleid;
/* 30 */       req.reqtype = 768;
/*    */       
/*    */ 
/* 33 */       QingfuManager.notifyAuany(userid, req);
/*    */     }
/*    */     
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */