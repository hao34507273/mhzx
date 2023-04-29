/*    */ package mzm.gsp.npc.main;
/*    */ 
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ public class NpcFightContext implements FightContext {
/*    */   public final int npcid;
/*    */   public final int mapcfgid;
/*    */   
/*    */   public NpcFightContext(int mapcfgid, int npcid) {
/* 10 */     this.mapcfgid = mapcfgid;
/* 11 */     this.npcid = npcid;
/*    */   }
/*    */   
/*    */   public boolean isRecordEnable()
/*    */   {
/* 16 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\main\NpcFightContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */