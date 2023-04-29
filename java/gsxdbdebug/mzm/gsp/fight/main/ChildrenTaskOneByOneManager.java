/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.util.TaskOneByOne;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChildrenTaskOneByOneManager
/*    */   extends TaskOneByOne
/*    */ {
/* 13 */   static final ChildrenTaskOneByOneManager oneByOne = new ChildrenTaskOneByOneManager();
/*    */   
/*    */   static void asyncChildInFight(long roleid, long childrenid) {
/* 16 */     oneByOne.add(new PChildrenInFight(roleid, childrenid));
/*    */   }
/*    */   
/*    */   static void asyncChildOutFight(long roleid, long childrenid, int cutCharacter) {
/* 20 */     oneByOne.add(new PChildrenOutFight(roleid, childrenid, cutCharacter));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\ChildrenTaskOneByOneManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */