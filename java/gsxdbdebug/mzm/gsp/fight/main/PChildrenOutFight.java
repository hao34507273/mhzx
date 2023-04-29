/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.children.main.ChildrenInterface;
/*    */ import mzm.gsp.children.main.ChildrenOutFightObj;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Role2properties;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class PChildrenOutFight
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long childrenid;
/*    */   private final int cutCharacter;
/*    */   
/*    */   public PChildrenOutFight(long roleid, long childrenid, int cutCharacter)
/*    */   {
/* 53 */     this.roleid = roleid;
/* 54 */     this.childrenid = childrenid;
/* 55 */     this.cutCharacter = cutCharacter;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 60 */     lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/* 61 */     ChildrenOutFightObj childrenOutFightObj = ChildrenInterface.getChildrenOutFightObj(this.roleid, this.childrenid);
/* 62 */     if (childrenOutFightObj != null) {
/* 63 */       childrenOutFightObj.setFightFlag(false);
/* 64 */       childrenOutFightObj.addCharater(-this.cutCharacter, 1);
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PChildrenOutFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */