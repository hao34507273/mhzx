/*     */ package mzm.gsp.wanted.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.pk.confbean.SPKConsts;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.wanted.SNotifyNPCStartWanted;
/*     */ import mzm.gsp.wanted.SWantedRoleError;
/*     */ import xbean.WantedInfo;
/*     */ import xtable.Role2wantedinfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NPCWantedSession
/*     */   extends Session
/*     */ {
/*     */   private final int fightId;
/*     */   
/*     */   public NPCWantedSession(long interval, long roleId, int fightId)
/*     */   {
/*  36 */     super(interval, roleId);
/*  37 */     this.fightId = fightId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/*  43 */     new NPCWantedProcedure().execute();
/*     */   }
/*     */   
/*     */   class NPCWantedProcedure extends LogicProcedure
/*     */   {
/*     */     NPCWantedProcedure() {}
/*     */     
/*     */     protected boolean processImp() throws Exception {
/*  51 */       long wantedRoleId = NPCWantedSession.this.getOwerId();
/*     */       
/*     */ 
/*  54 */       WantedInfo xWantedInfo = Role2wantedinfo.get(Long.valueOf(wantedRoleId));
/*     */       
/*  56 */       if (WantedPageManager.getInstance().containsRecord(Long.valueOf(wantedRoleId)))
/*     */       {
/*     */ 
/*  59 */         WantedPageManager.getInstance().deleteRecordFromList(Long.valueOf(wantedRoleId));
/*  60 */         if (OpenInterface.getOpenStatus(412))
/*     */         {
/*     */ 
/*  63 */           SNotifyNPCStartWanted notifyNPCStartWanted = new SNotifyNPCStartWanted();
/*  64 */           notifyNPCStartWanted.rolename.setString(RoleInterface.getName(wantedRoleId), "utf-8");
/*  65 */           OnlineManager.getInstance().sendAll(notifyNPCStartWanted);
/*     */         }
/*     */       }
/*     */       
/*  69 */       SWantedRoleError wantedRoleError = new SWantedRoleError();
/*  70 */       wantedRoleError.rolename.setString(RoleInterface.getName(wantedRoleId), "utf-8");
/*  71 */       if (!WantedManager.checkCanBeWantedByNPC(wantedRoleId, xWantedInfo, 0L, wantedRoleError, false))
/*     */       {
/*  73 */         if ((xWantedInfo != null) && (OnlineManager.getInstance().isOnline(wantedRoleId)))
/*     */         {
/*  75 */           NPCWantedSession npcWantedSession = new NPCWantedSession(TimeUnit.MINUTES.toSeconds(SPKConsts.getInstance().NPC_ARREST_INTERVAL_MINUTES), wantedRoleId, NPCWantedSession.this.fightId);
/*     */           
/*     */ 
/*  78 */           xWantedInfo.setSessionid(npcWantedSession.getSessionId());
/*  79 */           return true;
/*     */         }
/*     */         
/*     */ 
/*  83 */         Session.removeSession(xWantedInfo.getSessionid(), wantedRoleId);
/*  84 */         xWantedInfo.setSessionid(0L);
/*  85 */         return true;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  91 */       if (OpenInterface.getOpenStatus(412))
/*     */       {
/*  93 */         long fightRoleId = wantedRoleId;
/*  94 */         TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(wantedRoleId);
/*  95 */         if ((teamInfo != null) && (teamInfo.getTeamNormalList().contains(Long.valueOf(wantedRoleId))))
/*     */         {
/*  97 */           fightRoleId = teamInfo.getLeaderId();
/*     */         }
/*  99 */         FightInterface.startPVEFight(fightRoleId, NPCWantedSession.this.fightId, new WantedPVEFightContext(wantedRoleId, NPCWantedSession.this.fightId), 26, FightReason.WANTED_FIGHT_PVE);
/*     */       }
/*     */       
/*     */ 
/* 103 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\main\NPCWantedSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */