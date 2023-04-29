/*    */ package mzm.gsp.qingyunzhi.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.qingyunzhi.confbean.QingConsts;
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import mzm.gsp.role.event.RoleLevelUpProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.Progress;
/*    */ import xbean.QingData;
/*    */ import xtable.Role2qingyun;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLevelUp
/*    */   extends RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     long roleId = ((RoleLevelUpArg)this.arg).roleId;
/* 21 */     int roleLevel = RoleInterface.getLevel(roleId);
/*    */     
/* 23 */     QingData xQingData = Role2qingyun.get(Long.valueOf(roleId));
/* 24 */     if (xQingData == null)
/*    */     {
/* 26 */       return false;
/*    */     }
/* 28 */     Map<Integer, Progress> p = xQingData.getType2progress();
/* 29 */     if (roleLevel >= QingConsts.getInstance().NORMAL_OPEN_LEVEL)
/*    */     {
/* 31 */       checkFristOpen(roleId, p, 1);
/*    */     }
/* 33 */     if (roleLevel >= QingConsts.getInstance().ELITE_OPEN_LEVEL)
/*    */     {
/* 35 */       checkFristOpen(roleId, p, 2);
/*    */     }
/* 37 */     if (roleLevel >= QingConsts.getInstance().HERO_OPEN_LEVEL)
/*    */     {
/* 39 */       checkFristOpen(roleId, p, 3);
/*    */     }
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   private void checkFristOpen(long roleId, Map<Integer, Progress> p, int xType)
/*    */   {
/* 46 */     Progress xProgress = (Progress)p.get(Integer.valueOf(xType));
/* 47 */     if (checkAndSetProgress(xProgress))
/*    */     {
/* 49 */       RoleQingManager.synQingSingleProcess(roleId, xProgress, xType);
/*    */     }
/*    */   }
/*    */   
/*    */   private boolean checkAndSetProgress(Progress xProgress)
/*    */   {
/* 55 */     int chapter = xProgress.getChapter();
/* 56 */     int section = xProgress.getSection();
/* 57 */     if ((chapter == 0) && (section == 0))
/*    */     {
/* 59 */       return true;
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyunzhi\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */