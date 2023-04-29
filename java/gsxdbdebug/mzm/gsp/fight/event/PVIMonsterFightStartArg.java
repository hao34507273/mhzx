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
/*    */ public class PVIMonsterFightStartArg
/*    */ {
/*    */   public final long fightid;
/*    */   public final int fightCfgID;
/*    */   public final FightContext context;
/* 20 */   public final List<Long> roles = new ArrayList();
/* 21 */   public final List<Integer> monsters = new ArrayList();
/*    */   
/*    */   public PVIMonsterFightStartArg(long fightid, int fightCfgID, FightContext context) {
/* 24 */     this.fightid = fightid;
/* 25 */     this.fightCfgID = fightCfgID;
/* 26 */     this.context = context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\event\PVIMonsterFightStartArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */