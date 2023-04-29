/*    */ package mzm.gsp.visiblemonsterfight.main.robber;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.visiblemonsterfight.confbean.SGangRobberConst;
/*    */ import xtable.User;
/*    */ 
/*    */ public class GangRobberInitProcedure extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private List<Long> allRoles;
/*    */   
/*    */   public GangRobberInitProcedure(List<Long> teamRoles)
/*    */   {
/* 17 */     this.allRoles = teamRoles;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 22 */     Map<Long, String> role2user = new HashMap();
/* 23 */     for (Iterator i$ = this.allRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 24 */       role2user.put(Long.valueOf(roleid), mzm.gsp.role.main.RoleInterface.getUserId(roleid));
/*    */     }
/* 26 */     lock(User.getTable(), role2user.values());
/* 27 */     lock(xtable.Role2activity.getTable(), this.allRoles);
/* 28 */     ActivityInterface.canJoinAndCheckInitActivityData(role2user, this.allRoles, SGangRobberConst.getInstance().ACTIVITYID);
/*    */     
/* 30 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\robber\GangRobberInitProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */