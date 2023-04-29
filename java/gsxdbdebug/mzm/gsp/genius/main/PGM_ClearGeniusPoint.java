/*    */ package mzm.gsp.genius.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.genius.confbean.SGeniusConst;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.GeniusInfo;
/*    */ 
/*    */ public class PGM_ClearGeniusPoint extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   
/*    */   public PGM_ClearGeniusPoint(long gmRoleid, long roleid)
/*    */   {
/* 16 */     this.gmRoleid = gmRoleid;
/* 17 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     int level = mzm.gsp.role.main.RoleInterface.getLevel(this.roleid);
/* 24 */     if (level < SGeniusConst.getInstance().OPEN_LEVEL)
/*    */     {
/* 26 */       notifyClient(String.format("等级%d开启", new Object[] { Integer.valueOf(SGeniusConst.getInstance().OPEN_LEVEL) }));
/* 27 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 31 */     GeniusInfo xGeniusInfo = GeniusManager.getAndInitGeniusInfo(this.roleid);
/* 32 */     xGeniusInfo.setExtra_point(0);
/*    */     
/*    */ 
/* 35 */     GeniusManager.syncExtraPoint(this.roleid, 0, false);
/*    */     
/* 37 */     notifyClient("设置成功");
/* 38 */     return true;
/*    */   }
/*    */   
/*    */   private void notifyClient(String str)
/*    */   {
/* 43 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 44 */     messagetip.result = Integer.MAX_VALUE;
/* 45 */     messagetip.args.add(str);
/* 46 */     OnlineManager.getInstance().sendAtOnce(this.gmRoleid, messagetip);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genius\main\PGM_ClearGeniusPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */