/*    */ package mzm.gsp.addiction.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.addiction.pro.ProManager;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_UpdateOnline extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   private final int seconds;
/*    */   
/*    */   public PGM_UpdateOnline(long gmRoleid, long roleid, int seconds)
/*    */   {
/* 18 */     this.gmRoleid = gmRoleid;
/* 19 */     this.roleid = roleid;
/* 20 */     this.seconds = seconds;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     String userid = RoleInterface.getUserId(this.roleid);
/* 28 */     ProManager.updateUserInfo(userid, this.roleid, this.seconds, 3);
/*    */     
/* 30 */     notifyClient("更新成功");
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   private void notifyClient(String str)
/*    */   {
/* 36 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 37 */     messagetip.result = Integer.MAX_VALUE;
/* 38 */     messagetip.args.add(str);
/* 39 */     OnlineManager.getInstance().sendAtOnce(this.gmRoleid, messagetip);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\main\PGM_UpdateOnline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */