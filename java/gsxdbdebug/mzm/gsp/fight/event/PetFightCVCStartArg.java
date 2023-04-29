/*    */ package mzm.gsp.fight.event;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PetFightCVCStartArg
/*    */ {
/*    */   public final long fightid;
/*    */   public final FightContext context;
/* 13 */   public List<Long> activeRoles = new ArrayList();
/* 14 */   public List<Long> passiveRoles = new ArrayList();
/*    */   
/*    */   public PetFightCVCStartArg(long fightid, FightContext context) {
/* 17 */     this.fightid = fightid;
/* 18 */     this.context = context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\event\PetFightCVCStartArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */