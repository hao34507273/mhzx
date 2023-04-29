/*    */ package mzm.gsp.fight.event;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ 
/*    */ public class PVPFightFailArg
/*    */ {
/*    */   public final FightContext context;
/* 11 */   public List<Long> activeRoles = new ArrayList();
/* 12 */   public List<Long> passiveRoles = new ArrayList();
/*    */   
/*    */   public PVPFightFailArg(FightContext context) {
/* 15 */     this.context = context;
/*    */   }
/*    */   
/*    */   public List<Long> getAllRoles() {
/* 19 */     List<Long> roles = new ArrayList(this.activeRoles.size() + this.passiveRoles.size());
/* 20 */     roles.addAll(this.activeRoles);
/* 21 */     roles.addAll(this.passiveRoles);
/* 22 */     return roles;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\event\PVPFightFailArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */