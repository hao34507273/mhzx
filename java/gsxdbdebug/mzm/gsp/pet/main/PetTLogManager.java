/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PetTLogManager
/*    */ {
/*    */   private static final String TLOG_PET_MODEL_CHANGED = "PetModelChanged";
/*    */   
/*    */   static enum PetModelChangedType
/*    */   {
/* 25 */     SWITCH_MODEL, 
/*    */     
/* 27 */     DELETE_MODEL;
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     private PetModelChangedType() {}
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void tlogPetModelChanged(long roleId, long petId, int usedItemCfgId, int targetItemCfgId, PetModelChangedType type)
/*    */   {
/* 42 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 43 */     String userid = RoleInterface.getUserId(roleId);
/* 44 */     int rolelevel = RoleInterface.getLevel(roleId);
/* 45 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Long.valueOf(petId), Integer.valueOf(usedItemCfgId), Integer.valueOf(targetItemCfgId), Integer.valueOf(type.ordinal()) });
/*    */     
/* 47 */     TLogManager.getInstance().addLog(userid, "PetModelChanged", logStr);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PetTLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */