/*     */ package mzm.gsp.award.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.SMutiRoleAwardEndRes;
/*     */ import mzm.gsp.award.event.MultiRoleSelectArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MultiRoleAwardCache;
/*     */ import xbean.MultiRoleAwardContext;
/*     */ import xbean.MultiRoleAwards;
/*     */ import xtable.Multiroleaward;
/*     */ import xtable.Multiroleawardcontext;
/*     */ import xtable.Role2multiroleaward;
/*     */ 
/*     */ public class PCTakeMultiAwardReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long awardUUid;
/*     */   private int index;
/*     */   private long roleid;
/*     */   
/*     */   public PCTakeMultiAwardReq(long roleid, long awardUUid, int index)
/*     */   {
/*  28 */     this.awardUUid = awardUUid;
/*  29 */     this.index = index;
/*  30 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     MultiRoleAwards xMultiRoleAwards = Role2multiroleaward.get(Long.valueOf(this.roleid));
/*  37 */     if (xMultiRoleAwards == null)
/*     */     {
/*  39 */       return false;
/*     */     }
/*  41 */     if (!xMultiRoleAwards.getAwards().contains(Long.valueOf(this.awardUUid)))
/*     */     {
/*  43 */       return false;
/*     */     }
/*  45 */     MultiRoleAwardCache xRoleAwardCache = Multiroleaward.get(Long.valueOf(this.awardUUid));
/*  46 */     if (xRoleAwardCache == null)
/*     */     {
/*  48 */       if (GameServer.logger().isDebugEnabled())
/*  49 */         GameServer.logger().debug("PCTakeMultiAwardReq奖励已经发放完成了!!!");
/*  50 */       return false;
/*     */     }
/*  52 */     if (xRoleAwardCache.getIndexmap().containsKey(Integer.valueOf(this.index)))
/*     */     {
/*  54 */       RoleAwardManager.sendNormalRet(this.roleid, 1, true, new String[0]);
/*  55 */       return false;
/*     */     }
/*  57 */     if (!xRoleAwardCache.getRoles().contains(Long.valueOf(this.roleid)))
/*     */     {
/*  59 */       GameServer.logger().error("PCTakeMultiAwardReq奖励中不包含玩家,roleid:" + this.roleid);
/*  60 */       return false;
/*     */     }
/*  62 */     if (xRoleAwardCache.getOperroleids().contains(Long.valueOf(this.roleid)))
/*     */     {
/*  64 */       return false;
/*     */     }
/*  66 */     if ((mzm.gsp.team.main.TeamInterface.getTeamCapacity() <= this.index) || (this.index < 0))
/*     */     {
/*  68 */       if (GameServer.logger().isDebugEnabled())
/*  69 */         GameServer.logger().debug("PCTakeMultiAwardReq奖励中没有该位置的奖励,位置index:" + this.index);
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     mzm.gsp.tlog.TLogArg tLogArg = xRoleAwardCache.getTlogarg();
/*     */     
/*  75 */     MultiRoleAwardContext xmulMultiRoleAwardContext = Multiroleawardcontext.get(Long.valueOf(this.awardUUid));
/*  76 */     MultiRoleSelectAwardContext context = null;
/*  77 */     if (xmulMultiRoleAwardContext != null)
/*     */     {
/*  79 */       context = xmulMultiRoleAwardContext.getContext();
/*     */     }
/*     */     
/*  82 */     RoleAwardManager.awardMultiAwardRole(this.roleid, this.awardUUid, xRoleAwardCache, context, this.index, tLogArg);
/*     */     
/*  84 */     if (xRoleAwardCache.getOperroleids().size() == xRoleAwardCache.getRoles().size())
/*     */     {
/*     */ 
/*  87 */       final List<Long> allRoleList = new java.util.ArrayList();
/*  88 */       allRoleList.addAll(xRoleAwardCache.getRoles());
/*  89 */       xdb.Procedure.execute(new mzm.gsp.util.LogicProcedure()
/*     */       {
/*     */ 
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/*  95 */           lock(Role2multiroleaward.getTable(), allRoleList);
/*  96 */           for (Iterator i$ = allRoleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */             
/*  98 */             MultiRoleAwards xMultiRoleAwards = Role2multiroleaward.get(Long.valueOf(roleid));
/*  99 */             if (xMultiRoleAwards != null)
/*     */             {
/* 101 */               xMultiRoleAwards.getAwards().remove(Long.valueOf(PCTakeMultiAwardReq.this.awardUUid));
/* 102 */               if (xMultiRoleAwards.getAwards().size() <= 0)
/*     */               {
/* 104 */                 Role2multiroleaward.remove(Long.valueOf(roleid));
/*     */               }
/*     */             }
/*     */           }
/* 108 */           return true;
/*     */         }
/*     */         
/* 111 */       });
/* 112 */       SMutiRoleAwardEndRes sAwardEndRes = new SMutiRoleAwardEndRes();
/* 113 */       RoleAwardManager.fillNotAwardBean(sAwardEndRes.index2award, xRoleAwardCache);
/* 114 */       sAwardEndRes.awarduuid = this.awardUUid;
/* 115 */       OnlineManager.getInstance().sendMulti(sAwardEndRes, xRoleAwardCache.getRoles());
/*     */       
/* 117 */       Multiroleaward.remove(Long.valueOf(this.awardUUid));
/* 118 */       Multiroleawardcontext.remove(Long.valueOf(this.awardUUid));
/*     */       
/* 120 */       Map<Long, mzm.gsp.award.MultiRoleAwardBean> awrardRoles = new java.util.HashMap();
/* 121 */       RoleAwardManager.fillAwardRole(awrardRoles, xRoleAwardCache);
/* 122 */       MultiRoleSelectArg multiRoleSelectArg = new MultiRoleSelectArg(awrardRoles, xRoleAwardCache.getRoles(), context);
/* 123 */       TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.award.event.MultiRoleSelectAwardEnd(), multiRoleSelectArg);
/*     */     }
/* 125 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\main\PCTakeMultiAwardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */