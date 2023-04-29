/*    */ package mzm.gsp.fight.event;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PVEFightStartArg
/*    */ {
/*    */   public final long fightid;
/*    */   public final int fightCfgID;
/*    */   public final FightContext context;
/*    */   public final int fightReason;
/* 21 */   public final List<Long> roles = new ArrayList();
/* 22 */   public final List<Integer> monsters = new ArrayList();
/*    */   
/*    */   public PVEFightStartArg(long fightid, int fightCfgID, FightContext context, int fightReason) {
/* 25 */     this.fightid = fightid;
/* 26 */     this.fightCfgID = fightCfgID;
/* 27 */     this.context = context;
/* 28 */     this.fightReason = fightReason;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\event\PVEFightStartArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */