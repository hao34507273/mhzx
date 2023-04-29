/*    */ package mzm.gsp.paraselene.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Paraselene;
/*    */ import xtable.Role2paraselene;
/*    */ 
/*    */ public class PLeavefuben extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public PLeavefuben(long roleid)
/*    */   {
/* 17 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     Long teamId = TeamInterface.getTeamidByRoleid(this.roleid, false);
/*    */     
/* 25 */     if ((teamId == null) || (!TeamInterface.isTeamMemberNormal(this.roleid)))
/*    */     {
/* 27 */       ParaseleneManager.transferToWorld(this.roleid);
/* 28 */       RoleStatusInterface.unsetStatus(this.roleid, 12);
/*    */       
/* 30 */       Paraselene paraselene = Role2paraselene.get(Long.valueOf(this.roleid));
/* 31 */       if (paraselene != null)
/*    */       {
/* 33 */         paraselene.setRecentlayer(0);
/*    */       }
/* 35 */       return true;
/*    */     }
/*    */     
/* 38 */     if (TeamInterface.isTeamLeader(teamId.longValue(), this.roleid, false))
/*    */     {
/* 40 */       List<Long> roleList = TeamInterface.getNormalRoleList(this.roleid);
/* 41 */       lock(xtable.Role2properties.getTable(), roleList);
/*    */       
/* 43 */       ParaseleneManager.transferToWorld(this.roleid);
/* 44 */       RoleStatusInterface.unsetStatus(roleList, 12);
/* 45 */       for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */         
/* 47 */         Paraselene paraselene = Role2paraselene.get(Long.valueOf(roleid));
/* 48 */         if (paraselene != null)
/*    */         {
/* 50 */           paraselene.setRecentlayer(0);
/*    */         }
/*    */       }
/*    */       
/*    */ 
/* 55 */       return true;
/*    */     }
/* 57 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\PLeavefuben.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */