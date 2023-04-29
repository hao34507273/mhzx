/*    */ package mzm.gsp.homeland.mysteryvisitor;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import mzm.gsp.homeland.confbean.SMysteryVisitorNPCIdCfg;
/*    */ import mzm.gsp.homeland.main.HomelandInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.task.main.TaskNpcLibIdHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MysteryVisitorTaskNpcLibIdHandler
/*    */   implements TaskNpcLibIdHandler
/*    */ {
/*    */   public boolean isNearByNpc(long roleId, int npcLibId)
/*    */   {
/* 20 */     if (SMysteryVisitorNPCIdCfg.get(npcLibId) == null)
/*    */     {
/* 22 */       return false;
/*    */     }
/* 24 */     int currentYardMapCfgid = HomelandInterface.getCurrentYardMapId(roleId);
/* 25 */     if (currentYardMapCfgid < 0)
/*    */     {
/* 27 */       return false;
/*    */     }
/* 29 */     SMysteryVisitorNPCIdCfg cfg = SMysteryVisitorNPCIdCfg.get(npcLibId);
/* 30 */     if (!cfg.npcids.containsKey(Integer.valueOf(currentYardMapCfgid)))
/*    */     {
/* 32 */       return false;
/*    */     }
/* 34 */     return MapInterface.isNearByNPC(roleId, ((Integer)cfg.npcids.get(Integer.valueOf(currentYardMapCfgid))).intValue());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\mysteryvisitor\MysteryVisitorTaskNpcLibIdHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */