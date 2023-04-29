/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import grc.QQVipInfo;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.grc.SReportQQVipPayInfoResp;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnCheckQQVipPlayInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int vipFlag;
/*    */   private final byte isNew;
/*    */   private final Map<Integer, QQVipInfo> qqVipInfos;
/*    */   
/*    */   public POnCheckQQVipPlayInfo(long roleid, int vipFlag, byte isNew, Map<Integer, QQVipInfo> qqVipInfos)
/*    */   {
/* 22 */     this.roleid = roleid;
/* 23 */     this.vipFlag = vipFlag;
/* 24 */     this.isNew = isNew;
/* 25 */     this.qqVipInfos = qqVipInfos;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     if (!GrcManager.isOpenPrivilege(this.roleid))
/*    */     {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     String userid = RoleInterface.getUserId(this.roleid);
/* 37 */     GrcManager.updateQQVipInfos(userid, this.roleid, this.qqVipInfos);
/*    */     
/* 39 */     if (!GrcManager.tryAwardForQQVipPrivilege(userid, this.roleid))
/*    */     {
/* 41 */       return false;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 52 */     SReportQQVipPayInfoResp resp = new SReportQQVipPayInfoResp();
/* 53 */     resp.retcode = 0;
/* 54 */     resp.vip_flag = this.vipFlag;
/* 55 */     resp.is_new = this.isNew;
/* 56 */     OnlineManager.getInstance().send(this.roleid, resp);
/*    */     
/* 58 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\POnCheckQQVipPlayInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */