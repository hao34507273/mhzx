/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.Set;
/*     */ import mzm.gsp.fight.SSynCommandRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xtable.Basic;
/*     */ 
/*     */ public class PCCommandReq extends LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private int commandtype;
/*     */   private String commandname;
/*     */   private int fighterid;
/*     */   
/*     */   public PCCommandReq(long roleid, int commandtype, String commandname, int fighterid)
/*     */   {
/*  18 */     this.roleid = roleid;
/*  19 */     this.commandname = commandname;
/*  20 */     this.commandtype = commandtype;
/*  21 */     this.fighterid = fighterid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  63 */     Fight fight = FightManager.getFightByRoleid(this.roleid);
/*  64 */     if (fight == null) {
/*  65 */       return false;
/*     */     }
/*  67 */     Set<Long> lockRoles = fight.getLockRoles();
/*  68 */     lock(Basic.getTable(), lockRoles);
/*  69 */     FightGroupRole fightGroupRole = fight.getGroupRole(this.roleid);
/*  70 */     if (fightGroupRole == null) {
/*  71 */       return false;
/*     */     }
/*  73 */     FighterRole fighterRole = fightGroupRole.getFighterRole();
/*  74 */     if (fighterRole == null) {
/*  75 */       return false;
/*     */     }
/*  77 */     Fighter fighter = fight.getFighter(this.fighterid);
/*  78 */     if (fighter == null) {
/*  79 */       return false;
/*     */     }
/*  81 */     boolean team1 = fightGroupRole.fightTeam.isActive;
/*  82 */     boolean team2 = fighter.fightGroup.fightTeam.isActive;
/*  83 */     if (this.commandtype == 1) {
/*  84 */       if (!(team1 ^ team2)) {
/*  85 */         return false;
/*     */       }
/*  87 */     } else if (this.commandtype == 0) {
/*  88 */       if ((team1 ^ team2)) {
/*  89 */         return false;
/*     */       }
/*     */     } else {
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     SSynCommandRes synCommandRes = new SSynCommandRes();
/*  96 */     synCommandRes.becommandedfighterid = this.fighterid;
/*  97 */     synCommandRes.commandfighterid = fighterRole.fighterid;
/*  98 */     synCommandRes.commandname = this.commandname;
/*  99 */     OnlineManager.getInstance().sendMulti(synCommandRes, fightGroupRole.fightTeam.getBroadcastRoles());
/* 100 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PCCommandReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */