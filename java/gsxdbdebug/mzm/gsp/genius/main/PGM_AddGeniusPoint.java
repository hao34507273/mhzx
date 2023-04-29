/*    */ package mzm.gsp.genius.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.genius.confbean.SGeniusConst;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.GeniusInfo;
/*    */ 
/*    */ public class PGM_AddGeniusPoint extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   private final int addPoint;
/*    */   
/*    */   public PGM_AddGeniusPoint(long gmRoleid, long roleid, int addPoint)
/*    */   {
/* 17 */     this.gmRoleid = gmRoleid;
/* 18 */     this.roleid = roleid;
/* 19 */     this.addPoint = addPoint;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     int level = mzm.gsp.role.main.RoleInterface.getLevel(this.roleid);
/* 26 */     if (level < SGeniusConst.getInstance().OPEN_LEVEL)
/*    */     {
/* 28 */       notifyClient(String.format("等级%d开启", new Object[] { Integer.valueOf(SGeniusConst.getInstance().OPEN_LEVEL) }));
/* 29 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 33 */     GeniusInfo xGeniusInfo = GeniusManager.getAndInitGeniusInfo(this.roleid);
/* 34 */     int oldPoint = xGeniusInfo.getExtra_point();
/* 35 */     int endPoint = oldPoint + this.addPoint;
/* 36 */     if (endPoint < 0)
/*    */     {
/* 38 */       endPoint = 0;
/*    */     }
/* 40 */     xGeniusInfo.setExtra_point(endPoint);
/*    */     
/*    */ 
/* 43 */     GeniusManager.syncExtraPoint(this.roleid, endPoint, false);
/*    */     
/* 45 */     notifyClient("设置成功");
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   private void notifyClient(String str)
/*    */   {
/* 51 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 52 */     messagetip.result = Integer.MAX_VALUE;
/* 53 */     messagetip.args.add(str);
/* 54 */     OnlineManager.getInstance().sendAtOnce(this.gmRoleid, messagetip);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genius\main\PGM_AddGeniusPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */