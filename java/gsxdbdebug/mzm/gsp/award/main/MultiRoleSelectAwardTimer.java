/*    */ package mzm.gsp.award.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.award.SMutiRoleAwardEndRes;
/*    */ import mzm.gsp.award.event.MultiRoleSelectArg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import xbean.MultiRoleAwardCache;
/*    */ import xbean.MultiRoleAwardContext;
/*    */ import xbean.MultiRoleAwards;
/*    */ import xtable.Multiroleaward;
/*    */ 
/*    */ public class MultiRoleSelectAwardTimer extends Session
/*    */ {
/* 20 */   private List<Long> allroles = new ArrayList();
/*    */   
/*    */   public MultiRoleSelectAwardTimer(long interval, long awardUuid, List<Long> allRoles)
/*    */   {
/* 24 */     super(interval, awardUuid);
/* 25 */     this.allroles.addAll(allRoles);
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 31 */     xdb.Procedure.execute(new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */ 
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 37 */         long awardUUid = MultiRoleSelectAwardTimer.this.getOwerId();
/* 38 */         lock(xtable.Role2jiuxiao.getTable(), MultiRoleSelectAwardTimer.this.allroles);
/* 39 */         MultiRoleAwardCache multiRoleAwardCache = Multiroleaward.get(Long.valueOf(awardUUid));
/*    */         
/* 41 */         if (multiRoleAwardCache == null)
/*    */         {
/* 43 */           return false;
/*    */         }
/* 45 */         if (multiRoleAwardCache.getOperroleids().size() == multiRoleAwardCache.getRoles().size())
/*    */         {
/* 47 */           return false;
/*    */         }
/*    */         
/* 50 */         mzm.gsp.tlog.TLogArg tLogArg = multiRoleAwardCache.getTlogarg();
/*    */         
/* 52 */         MultiRoleAwardContext xmulMultiRoleAwardContext = xtable.Multiroleawardcontext.get(Long.valueOf(awardUUid));
/* 53 */         MultiRoleSelectAwardContext context = null;
/* 54 */         if (xmulMultiRoleAwardContext != null)
/*    */         {
/* 56 */           context = xmulMultiRoleAwardContext.getContext();
/*    */         }
/*    */         
/* 59 */         List<Long> notOperatorRoleids = new ArrayList();
/* 60 */         for (Iterator i$ = multiRoleAwardCache.getRoles().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */           
/* 62 */           if (!multiRoleAwardCache.getOperroleids().contains(Long.valueOf(roleid)))
/*    */           {
/* 64 */             notOperatorRoleids.add(Long.valueOf(roleid));
/*    */           }
/*    */         }
/* 67 */         for (int i = 0; i < multiRoleAwardCache.getAwarditemids().size(); i++)
/*    */         {
/* 69 */           if (!multiRoleAwardCache.getIndexmap().containsKey(Integer.valueOf(i)))
/*    */           {
/* 71 */             if (notOperatorRoleids.size() > 0)
/*    */             {
/* 73 */               long notAwardRoleid = ((Long)notOperatorRoleids.remove(0)).longValue();
/* 74 */               RoleAwardManager.awardMultiAwardRole(notAwardRoleid, awardUUid, multiRoleAwardCache, context, i, tLogArg);
/*    */             }
/*    */           }
/*    */         }
/*    */         
/*    */ 
/* 80 */         SMutiRoleAwardEndRes sAwardEndRes = new SMutiRoleAwardEndRes();
/* 81 */         RoleAwardManager.fillNotAwardBean(sAwardEndRes.index2award, multiRoleAwardCache);
/* 82 */         sAwardEndRes.awarduuid = awardUUid;
/* 83 */         OnlineManager.getInstance().sendMulti(sAwardEndRes, multiRoleAwardCache.getRoles());
/*    */         
/*    */ 
/* 86 */         for (Iterator i$ = multiRoleAwardCache.getRoles().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */           
/* 88 */           MultiRoleAwards multiRoleAwards = xtable.Role2multiroleaward.get(Long.valueOf(roleid));
/* 89 */           if (multiRoleAwards != null)
/*    */           {
/* 91 */             multiRoleAwards.getAwards().remove(Long.valueOf(awardUUid));
/* 92 */             if (multiRoleAwards.getAwards().size() <= 0)
/*    */             {
/* 94 */               xtable.Role2multiroleaward.remove(Long.valueOf(roleid));
/*    */             }
/*    */           }
/*    */         }
/* 98 */         Multiroleaward.remove(Long.valueOf(awardUUid));
/*    */         
/* :0 */         xtable.Multiroleawardcontext.remove(Long.valueOf(awardUUid));
/*    */         
/* :2 */         Map<Long, mzm.gsp.award.MultiRoleAwardBean> awrardRoles = new java.util.HashMap();
/* :3 */         RoleAwardManager.fillAwardRole(awrardRoles, multiRoleAwardCache);
/* :4 */         MultiRoleSelectArg multiRoleSelectArg = new MultiRoleSelectArg(awrardRoles, multiRoleAwardCache.getRoles(), context);
/*    */         
/* :6 */         TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.award.event.MultiRoleSelectAwardEnd(), multiRoleSelectArg);
/* :7 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\main\MultiRoleSelectAwardTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */