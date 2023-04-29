/*    */ package mzm.gsp.homeland.mysteryvisitor;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MysteryVisitorInterface
/*    */ {
/*    */   public static void addMysteryVisitorIntoCourtyard(long roleid, long worldid, int mapCfgid)
/*    */   {
/* 22 */     MysteryVisitorManager.addMysteryVisitorIntoCourtyard(roleid, worldid, mapCfgid);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void removeMysteryVisitorByRoleid(long roleid)
/*    */   {
/* 33 */     MysteryVisitorManager.removeMysteryVisitorByRoleid(roleid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\mysteryvisitor\MysteryVisitorInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */