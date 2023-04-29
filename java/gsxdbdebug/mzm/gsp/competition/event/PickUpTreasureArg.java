/*    */ package mzm.gsp.competition.event;
/*    */ 
/*    */ import mzm.gsp.competition.main.CompetitionInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PickUpTreasureArg
/*    */ {
/*    */   public final long roleid;
/*    */   public final int treasureMapItemid;
/*    */   
/*    */   public PickUpTreasureArg(long roleid, int treasureMapItemid)
/*    */   {
/* 16 */     this.roleid = roleid;
/* 17 */     this.treasureMapItemid = treasureMapItemid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isCopper()
/*    */   {
/* 25 */     return CompetitionInterface.isCopperTreasure(this.treasureMapItemid);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isSilver()
/*    */   {
/* 33 */     return CompetitionInterface.isSilverTreasure(this.treasureMapItemid);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isGold()
/*    */   {
/* 41 */     return CompetitionInterface.isGoldTreasure(this.treasureMapItemid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\event\PickUpTreasureArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */