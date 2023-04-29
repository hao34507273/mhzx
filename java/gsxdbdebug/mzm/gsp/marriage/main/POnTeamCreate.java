/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.marriage.confbean.SMarriageConsts;
/*    */ import mzm.gsp.team.event.TeamCreateArg;
/*    */ import mzm.gsp.team.event.TeamMember;
/*    */ 
/*    */ public class POnTeamCreate extends mzm.gsp.team.event.TeamCreateProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     if (((TeamCreateArg)this.arg).members.size() <= 2) {
/* 17 */       return false;
/*    */     }
/* 19 */     Map<Long, Long> marriageNormalMap = new HashMap();
/* 20 */     for (TeamMember teamMember : ((TeamCreateArg)this.arg).members) {
/* 21 */       long roleid = teamMember.roleid;
/* 22 */       if (teamMember.status == 0) {
/* 23 */         Long marriageId = xtable.Role2marriage.select(Long.valueOf(roleid));
/* 24 */         if (marriageId != null) {
/* 25 */           xbean.Marriage xMarriage = xtable.Marriage.select(marriageId);
/* 26 */           long otherroleid = xMarriage.getRoleida();
/* 27 */           if (otherroleid == roleid) {
/* 28 */             otherroleid = xMarriage.getRoleidb();
/*    */           }
/* 30 */           marriageNormalMap.put(Long.valueOf(roleid), Long.valueOf(otherroleid));
/*    */         }
/*    */       }
/*    */     }
/* 34 */     Iterator<Map.Entry<Long, Long>> iterator = marriageNormalMap.entrySet().iterator();
/* 35 */     while (iterator.hasNext()) {
/* 36 */       Map.Entry<Long, Long> entry = (Map.Entry)iterator.next();
/* 37 */       if (!marriageNormalMap.containsKey(entry.getValue()))
/* 38 */         iterator.remove();
/*    */     }
/*    */     Iterator i$;
/* 41 */     if (marriageNormalMap.size() > 0) {
/* 42 */       Set<Long> keySet = marriageNormalMap.keySet();
/* 43 */       lock(xtable.Role2buff.getTable(), keySet);
/* 44 */       for (i$ = keySet.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 45 */         mzm.gsp.buff.main.BuffInterface.installBuff(roleid, SMarriageConsts.getInstance().coupleInteamBuffid);
/*    */       }
/*    */     }
/* 48 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\POnTeamCreate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */