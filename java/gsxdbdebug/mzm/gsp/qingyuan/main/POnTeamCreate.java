/*    */ package mzm.gsp.qingyuan.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.buff.main.BuffInterface;
/*    */ import mzm.gsp.qingyuan.confbean.QingYuanConsts;
/*    */ import mzm.gsp.team.event.TeamCreateArg;
/*    */ import mzm.gsp.team.event.TeamCreateProcedure;
/*    */ import mzm.gsp.team.event.TeamMember;
/*    */ import xtable.Role2qingyuan;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnTeamCreate extends TeamCreateProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 22 */     if (((TeamCreateArg)this.arg).members.size() < 2)
/*    */     {
/* 24 */       return true;
/*    */     }
/* 26 */     Map<Long, List<Long>> qingYuanRelationMap = new HashMap();
/*    */     
/* 28 */     for (TeamMember teamMember : ((TeamCreateArg)this.arg).members)
/*    */     {
/* 30 */       if (teamMember.status == 0)
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 35 */         long roleId = teamMember.roleid;
/* 36 */         List<Long> xQingYuanRoleList = Role2qingyuan.selectQing_yuan_role_list(Long.valueOf(roleId));
/* 37 */         if (xQingYuanRoleList != null)
/*    */         {
/* 39 */           qingYuanRelationMap.put(Long.valueOf(roleId), xQingYuanRoleList);
/*    */         }
/*    */       }
/*    */     }
/* 43 */     if (qingYuanRelationMap.isEmpty())
/*    */     {
/* 45 */       return true;
/*    */     }
/*    */     
/* 48 */     Set<Long> roleIdSet = new HashSet();
/* 49 */     for (Iterator i$ = qingYuanRelationMap.entrySet().iterator(); i$.hasNext();) { entry = (Map.Entry)i$.next();
/*    */       
/* 51 */       List<Long> qingYuanRoleList = (List)entry.getValue();
/* 52 */       for (i$ = qingYuanRoleList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */         
/* 54 */         if (qingYuanRelationMap.containsKey(Long.valueOf(roleId)))
/*    */         {
/* 56 */           roleIdSet.add(Long.valueOf(roleId));
/* 57 */           roleIdSet.add(entry.getKey());
/*    */         }
/*    */       }
/*    */     }
/*    */     Map.Entry<Long, List<Long>> entry;
/*    */     Iterator i$;
/* 63 */     if (roleIdSet.isEmpty())
/*    */     {
/* 65 */       return true;
/*    */     }
/* 67 */     Set<String> userIdSet = new HashSet();
/* 68 */     for (Iterator i$ = roleIdSet.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 70 */       userIdSet.add(mzm.gsp.role.main.RoleInterface.getUserId(roleId));
/*    */     }
/*    */     
/* 73 */     lock(User.getTable(), userIdSet);
/* 74 */     lock(xtable.Role2properties.getTable(), roleIdSet);
/*    */     
/* 76 */     for (Iterator i$ = roleIdSet.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */       
/* 78 */       BuffInterface.installBuff(roleid, QingYuanConsts.getInstance().qingYuanRelationTeamBuffId);
/*    */     }
/* 80 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyuan\main\POnTeamCreate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */