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
/*    */ public class PVCFightStartArg
/*    */ {
/*    */   public final long fightid;
/*    */   public final FightContext context;
/* 17 */   public List<Long> activeRoles = new ArrayList();
/* 18 */   public List<Long> passiveRoles = new ArrayList();
/*    */   
/*    */   public PVCFightStartArg(long fightid, FightContext context) {
/* 21 */     this.fightid = fightid;
/* 22 */     this.context = context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\event\PVCFightStartArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */