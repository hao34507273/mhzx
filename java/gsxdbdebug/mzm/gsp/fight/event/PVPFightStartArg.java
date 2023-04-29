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
/*    */ public class PVPFightStartArg
/*    */ {
/*    */   public final long fightid;
/*    */   public final long recordid;
/*    */   public final FightContext context;
/* 34 */   public List<Long> activeRoles = new ArrayList();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 39 */   public List<Long> passiveRoles = new ArrayList();
/*    */   
/*    */   public PVPFightStartArg(long fightid, long recordid, FightContext context) {
/* 42 */     this.fightid = fightid;
/* 43 */     this.recordid = recordid;
/* 44 */     this.context = context;
/*    */   }
/*    */   
/*    */   public List<Long> getAllRoles() {
/* 48 */     List<Long> roles = new ArrayList(this.activeRoles.size() + this.passiveRoles.size());
/* 49 */     roles.addAll(this.activeRoles);
/* 50 */     roles.addAll(this.passiveRoles);
/* 51 */     return roles;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\event\PVPFightStartArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */