/*    */ package mzm.gsp.prison.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.pk.confbean.SPKConsts;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PrisonManager
/*    */ {
/*    */   static final String CHARSET = "utf-8";
/*    */   
/*    */   static boolean checkSwitchAndCross(long roleId, int status)
/*    */   {
/* 20 */     if (!OpenInterface.getOpenStatus(413))
/*    */     {
/* 22 */       return false;
/*    */     }
/* 24 */     if (!RoleStatusInterface.checkCanSetStatus(roleId, status, false))
/*    */     {
/* 26 */       return false;
/*    */     }
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   static boolean transferPrisonMap(long roleId)
/*    */   {
/* 33 */     if (RoleStatusInterface.containsStatus(roleId, 1670, true))
/*    */     {
/*    */ 
/*    */ 
/* 37 */       MapInterface.setXunLuoState(roleId, false);
/* 38 */       MapInterface.forceTransferToScene(roleId, JailWorldManager.getInstance().getWorldId(), ((Integer)JailWorldManager.getInstance().getMapCfgIds().get(0)).intValue(), SPKConsts.getInstance().WANTED_ENTER_PRISON_MAP_X, SPKConsts.getInstance().WANTED_ENTER_PRISON_MAP_Y);
/*    */       
/*    */ 
/* 41 */       RoleStatusInterface.unsetStatus(roleId, 1670);
/* 42 */       return true;
/*    */     }
/* 44 */     if (RoleStatusInterface.containsStatus(roleId, 1669, true))
/*    */     {
/*    */ 
/* 47 */       MapInterface.forceTransferToScene(roleId, MapInterface.getBigWorldid(), SPKConsts.getInstance().LEAVE_PRISON_MAP_ID);
/*    */       
/* 49 */       RoleStatusInterface.unsetStatus(roleId, 1669);
/* 50 */       return true;
/*    */     }
/*    */     
/* 53 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\main\PrisonManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */