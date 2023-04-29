/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ public class GatherMapItemPVEFightContext implements FightContext
/*    */ {
/*    */   public final int mapItemCfgid;
/*    */   
/*    */   public GatherMapItemPVEFightContext(int mapItemCfgid)
/*    */   {
/* 11 */     this.mapItemCfgid = mapItemCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isRecordEnable()
/*    */   {
/* 17 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\GatherMapItemPVEFightContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */