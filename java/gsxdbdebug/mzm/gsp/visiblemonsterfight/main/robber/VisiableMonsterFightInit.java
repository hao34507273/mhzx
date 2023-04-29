/*    */ package mzm.gsp.visiblemonsterfight.main.robber;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import xtable.User;
/*    */ 
/*    */ public class VisiableMonsterFightInit extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private List<Long> roleids;
/*    */   private int activityid;
/*    */   
/*    */   public VisiableMonsterFightInit(List<Long> roleids, int activityid)
/*    */   {
/* 17 */     this.roleids = roleids;
/* 18 */     this.activityid = activityid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 23 */     Map<Long, String> role2user = new HashMap();
/* 24 */     for (Iterator i$ = this.roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 25 */       role2user.put(Long.valueOf(roleid), mzm.gsp.role.main.RoleInterface.getUserId(roleid));
/*    */     }
/* 27 */     lock(User.getTable(), role2user.values());
/* 28 */     lock(xtable.Role2properties.getTable(), role2user.keySet());
/* 29 */     ActivityInterface.canJoinAndCheckInitActivityData(role2user, this.roleids, this.activityid);
/* 30 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\robber\VisiableMonsterFightInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */