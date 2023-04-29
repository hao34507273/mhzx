/*     */ package mzm.gsp.crosscompete.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.crosscompete.Against;
/*     */ import mzm.gsp.crosscompete.AgainstFaction;
/*     */ import mzm.gsp.crosscompete.SAgainstListRes;
/*     */ import mzm.gsp.crosscompete.SSignedUpFactionListRes;
/*     */ import mzm.gsp.crosscompete.SignedUpFaction;
/*     */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*     */ import mzm.gsp.gang.main.Gang;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.CrossCompete;
/*     */ import xbean.CrossCompeteAgainst;
/*     */ import xbean.CrossCompeteMatch;
/*     */ import xbean.CrossCompeteSignUp;
/*     */ import xbean.FactionCrossCompete;
/*     */ 
/*     */ public class PFactionListReq extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PFactionListReq(long roleid)
/*     */   {
/*  34 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if (!OpenInterface.getOpenStatus(408)) {
/*  41 */       CrossCompeteManager.logError("PFactionListReq.processImp@cross compete not open|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*     */ 
/*  44 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  48 */     CrossCompete xCrossCompete = CrossCompeteManager.getXCrossCompete(false);
/*     */     
/*     */ 
/*  51 */     long activityStartTime = ActivityInterface.getActivityStartTime(SCrossCompeteConsts.getInstance().Activityid);
/*     */     
/*  53 */     int stage = ActivityInterface.getActivityStage(SCrossCompeteConsts.getInstance().Activityid);
/*     */     
/*     */ 
/*     */ 
/*  57 */     if ((stage == 0) || (stage == 1))
/*     */     {
/*  59 */       SSignedUpFactionListRes signedUpListRes = new SSignedUpFactionListRes();
/*     */       
/*  61 */       if (xCrossCompete != null)
/*     */       {
/*  63 */         for (Map.Entry<Long, CrossCompeteSignUp> entry : xCrossCompete.getSignup_factions().entrySet()) {
/*  64 */           long factionid = ((Long)entry.getKey()).longValue();
/*  65 */           CrossCompeteSignUp xSignUp = (CrossCompeteSignUp)entry.getValue();
/*  66 */           if (xSignUp.getTime() >= activityStartTime)
/*     */           {
/*     */ 
/*     */ 
/*  70 */             Gang faction = GangInterface.getGang(factionid, false);
/*  71 */             if (faction != null)
/*     */             {
/*     */ 
/*     */ 
/*  75 */               String leaderName = RoleInterface.getName(faction.getBangZhuId());
/*     */               
/*  77 */               SignedUpFaction factionBean = new SignedUpFaction();
/*  78 */               CrossCompeteManager.fillSignedUpFactionBean(factionBean, factionid, faction.getName(), faction.getDisplayid(), faction.getBangZhuId(), leaderName);
/*     */               
/*     */ 
/*  81 */               signedUpListRes.factions.add(factionBean);
/*     */             }
/*     */           }
/*     */         } }
/*  85 */       OnlineManager.getInstance().send(this.roleid, signedUpListRes);
/*     */     }
/*     */     else {
/*  88 */       SAgainstListRes res = new SAgainstListRes();
/*     */       Iterator i$;
/*  90 */       if (xCrossCompete != null) {
/*  91 */         Iterator<Map.Entry<CrossCompeteMatch, CrossCompeteAgainst>> iter = xCrossCompete.getAgainsts().entrySet().iterator();
/*     */         
/*     */ 
/*  94 */         while (iter.hasNext()) {
/*  95 */           Map.Entry<CrossCompeteMatch, CrossCompeteAgainst> entry = (Map.Entry)iter.next();
/*  96 */           CrossCompeteMatch cMatch = (CrossCompeteMatch)entry.getKey();
/*  97 */           CrossCompeteAgainst xAgainst = (CrossCompeteAgainst)entry.getValue();
/*     */           
/*  99 */           Against againstBean = new Against();
/* 100 */           CrossCompeteManager.fillAgainstBean(againstBean, cMatch, xAgainst);
/*     */           
/* 102 */           res.against_list.add(againstBean);
/*     */         }
/*     */         
/* 105 */         for (i$ = xCrossCompete.getSignup_factions().keySet().iterator(); i$.hasNext();) { long factionid = ((Long)i$.next()).longValue();
/* 106 */           FactionCrossCompete xFaction = CrossCompeteManager.getXFactionCrossCompete(factionid, false);
/*     */           
/* 108 */           if (xFaction != null)
/*     */           {
/*     */ 
/* 111 */             if (xFaction.getOpponent() == 0L) {
/* 112 */               Gang faction = GangInterface.getGang(factionid, false);
/* 113 */               if (faction != null)
/*     */               {
/*     */ 
/* 116 */                 AgainstFaction factionBean = new AgainstFaction();
/* 117 */                 factionBean.factionid = factionid;
/* 118 */                 factionBean.faction_name = faction.getName();
/* 119 */                 factionBean.faction_level = faction.getLevel();
/* 120 */                 factionBean.server_level = ServerInterface.getCurrentServerLevel();
/* 121 */                 factionBean.member_count = faction.getMemberSize();
/*     */                 
/* 123 */                 res.miss_turn_list.add(factionBean);
/*     */               }
/*     */             } }
/*     */         }
/*     */       }
/* 128 */       OnlineManager.getInstance().send(this.roleid, res);
/*     */     }
/*     */     
/* 131 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\PFactionListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */