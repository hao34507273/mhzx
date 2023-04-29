/*     */ package mzm.gsp.prison.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.fight.event.PVEFightEndArg;
/*     */ import mzm.gsp.fight.event.PVEFightEndProcedure;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pk.confbean.SPKConsts;
/*     */ import mzm.gsp.prison.SNotifyJailBreakResult;
/*     */ import mzm.gsp.prison.SNotifyJailDeliveryResult;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import xbean.PrisonInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2prisoninfo;
/*     */ 
/*     */ public class POnPVEFightEnd extends PVEFightEndProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  26 */     if ((((PVEFightEndArg)this.arg).fightReason == FightReason.JAIL_BREAK_FIGHT_PVE.value) && ((((PVEFightEndArg)this.arg).context instanceof JailBreakPVEFightContext)))
/*     */     {
/*  28 */       SNotifyJailBreakResult notifyJailBreakResult = new SNotifyJailBreakResult();
/*  29 */       notifyJailBreakResult.result = 2;
/*     */       
/*  31 */       List<Long> notEscapeRoles = ((PVEFightEndArg)this.arg).notEscapeRoles();
/*     */       
/*     */ 
/*  34 */       lock(Basic.getTable(), ((PVEFightEndArg)this.arg).roleList);
/*     */       Iterator i$;
/*  36 */       Iterator i$; if (((PVEFightEndArg)this.arg).isPlayerWin)
/*     */       {
/*  38 */         notifyJailBreakResult.result = 1;
/*     */         
/*  40 */         for (i$ = notEscapeRoles.iterator(); i$.hasNext();) { long rid = ((Long)i$.next()).longValue();
/*     */           
/*  42 */           PrisonInterface.letRoleOutOfJail(rid, SPKConsts.getInstance().JAIL_BREAK_MAIL_ID, new ArrayList(), new ArrayList(), new TLogArg(LogReason.JAIL_BREAK_MAIL));
/*     */           
/*     */ 
/*  45 */           Octets octets = new Octets();
/*  46 */           octets.setString(RoleInterface.getName(rid), "utf-8");
/*  47 */           notifyJailBreakResult.namelist.add(octets);
/*     */         }
/*     */         
/*     */       }
/*     */       else
/*     */       {
/*  53 */         for (Iterator i$ = notEscapeRoles.iterator(); i$.hasNext();) { long rid = ((Long)i$.next()).longValue();
/*     */           
/*  55 */           PrisonInfo xPrisonInfo = Role2prisoninfo.get(Long.valueOf(rid));
/*  56 */           if (xPrisonInfo != null)
/*     */           {
/*  58 */             xPrisonInfo.setJailaction(1);
/*     */           }
/*     */         }
/*  61 */         for (i$ = ((PVEFightEndArg)this.arg).roleList.iterator(); i$.hasNext();) { long rid = ((Long)i$.next()).longValue();
/*     */           
/*  63 */           Octets octets = new Octets();
/*  64 */           octets.setString(RoleInterface.getName(rid), "utf-8");
/*  65 */           notifyJailBreakResult.namelist.add(octets);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*  70 */       if (!((PVEFightEndArg)this.arg).roleList.isEmpty())
/*     */       {
/*  72 */         PrisonTlogManager.tlogJailBreak(((PVEFightEndArg)this.arg).roleList, ((JailBreakPVEFightContext)((PVEFightEndArg)this.arg).context).fightId, ((PVEFightEndArg)this.arg).isPlayerWin ? 1 : 2);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*  77 */       OnlineManager.getInstance().sendAll(notifyJailBreakResult);
/*  78 */       return true;
/*     */     }
/*     */     
/*  81 */     if ((((PVEFightEndArg)this.arg).fightReason == FightReason.JAIL_DELIVERY_FIGHT_PVE.value) && ((((PVEFightEndArg)this.arg).context instanceof JailDeliveryPVEFightContext)))
/*     */     {
/*  83 */       SNotifyJailDeliveryResult notifyJailDeliveryResult = new SNotifyJailDeliveryResult();
/*  84 */       notifyJailDeliveryResult.result = 2;
/*     */       
/*  86 */       List<Long> notEscapeRoles = ((PVEFightEndArg)this.arg).notEscapeRoles();
/*     */       
/*  88 */       StringBuilder mailContentParamBuilder = new StringBuilder();
/*     */       
/*     */ 
/*  91 */       JailDeliveryPVEFightContext jailDeliveryPVEFightContext = (JailDeliveryPVEFightContext)((PVEFightEndArg)this.arg).context;
/*  92 */       Set<Long> roleIdsToLock = new java.util.HashSet();
/*  93 */       roleIdsToLock.addAll(((PVEFightEndArg)this.arg).roleList);
/*  94 */       roleIdsToLock.add(Long.valueOf(jailDeliveryPVEFightContext.savedId));
/*     */       
/*  96 */       lock(Basic.getTable(), roleIdsToLock);
/*     */       
/*  98 */       notifyJailDeliveryResult.name.setString(RoleInterface.getName(jailDeliveryPVEFightContext.savedId), "utf-8");
/*     */       
/*     */ 
/* 101 */       if (((PVEFightEndArg)this.arg).isPlayerWin)
/*     */       {
/* 103 */         notifyJailDeliveryResult.result = 1;
/* 104 */         int notEscapedSize = notEscapeRoles.size();
/* 105 */         for (int i = 0; i < notEscapedSize; i++)
/*     */         {
/* 107 */           long rid = ((Long)notEscapeRoles.get(i)).longValue();
/* 108 */           Octets octets = new Octets();
/* 109 */           String roleName = RoleInterface.getName(rid);
/* 110 */           octets.setString(roleName, "utf-8");
/* 111 */           notifyJailDeliveryResult.namelist.add(octets);
/* 112 */           mailContentParamBuilder.append(roleName);
/* 113 */           if (i != notEscapedSize - 1)
/*     */           {
/* 115 */             mailContentParamBuilder.append("、");
/*     */           }
/*     */         }
/*     */         
/* 119 */         PrisonInterface.letRoleOutOfJail(jailDeliveryPVEFightContext.savedId, SPKConsts.getInstance().JAIL_DELIVERY_MAIL_ID, new ArrayList(), java.util.Collections.singletonList(mailContentParamBuilder.toString()), new TLogArg(LogReason.JAIL_DELIVERY_MAIL));
/*     */ 
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 126 */         PrisonInfo xPrisonInfo = Role2prisoninfo.get(Long.valueOf(jailDeliveryPVEFightContext.savedId));
/* 127 */         if (xPrisonInfo != null)
/*     */         {
/* 129 */           xPrisonInfo.setJailaction(1);
/*     */         }
/*     */         
/* 132 */         int roleListSize = ((PVEFightEndArg)this.arg).roleList.size();
/* 133 */         for (int i = 0; i < roleListSize; i++)
/*     */         {
/* 135 */           long rid = ((Long)((PVEFightEndArg)this.arg).roleList.get(i)).longValue();
/* 136 */           Octets octets = new Octets();
/* 137 */           String roleName = RoleInterface.getName(rid);
/* 138 */           octets.setString(roleName, "utf-8");
/* 139 */           notifyJailDeliveryResult.namelist.add(octets);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 144 */       if (!((PVEFightEndArg)this.arg).roleList.isEmpty())
/*     */       {
/* 146 */         PrisonTlogManager.tlogJailDelivery(((PVEFightEndArg)this.arg).roleList, jailDeliveryPVEFightContext.savedId, jailDeliveryPVEFightContext.fightId, ((PVEFightEndArg)this.arg).isPlayerWin ? 1 : 2);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 152 */       OnlineManager.getInstance().sendAll(notifyJailDeliveryResult);
/* 153 */       return true;
/*     */     }
/* 155 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\main\POnPVEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */