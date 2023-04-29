/*    */ package mzm.gsp.worship.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.confbean.WorShipConst;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.item.event.UseGangFileItemArg;
/*    */ import mzm.gsp.item.event.UseGangFileItemEventProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.RoleWorshipInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ public class POnUseFactionFile
/*    */   extends UseGangFileItemEventProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private long factionId;
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     this.roleId = ((UseGangFileItemArg)this.arg).roleid;
/* 30 */     if (((UseGangFileItemArg)this.arg).num <= 0)
/*    */     {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     String userid = RoleInterface.getUserId(this.roleId);
/* 36 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 38 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*    */     
/* 40 */     this.factionId = GangInterface.getGangId(this.roleId);
/* 41 */     if (this.factionId <= 0L)
/*    */     {
/* 43 */       GameServer.logger().error(String.format("[worship]POnUseFactionFile.processImp@ not have faction!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*    */       
/* 45 */       return false;
/*    */     }
/* 47 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleId, WorShipConst.getInstance().activityId);
/*    */     
/* 49 */     if ((!res.isCanJoin()) && (!WorshipManager.isDebugMode()))
/*    */     {
/* 51 */       GameServer.logger().error(String.format("[worship]POnUseFactionFile.processImp@ can not join activity!|roleId=%d|reason=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(res.getReasonValue()) }));
/*    */       
/*    */ 
/* 54 */       return false;
/*    */     }
/* 56 */     RoleWorshipInfo xRoleWorshipInfo = WorshipManager.getXRoleWorshipDataIfAbsent(this.roleId, this.factionId);
/* 57 */     if (xRoleWorshipInfo.getCurfactionid() != this.factionId)
/*    */     {
/* 59 */       GameServer.logger().warn(String.format("[worship]POnUseFactionFile.processImp@ current factionId err!|roleId=%d|xdbFactionId=%d|realFactionId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(xRoleWorshipInfo.getCurfactionid()), Long.valueOf(this.factionId) }));
/*    */       
/*    */ 
/*    */ 
/* 63 */       xRoleWorshipInfo.setCurfactionid(this.factionId);
/*    */     }
/* 65 */     Map<Long, Integer> factionId2Num = xRoleWorshipInfo.getThiscycledata();
/* 66 */     Integer oldValue = (Integer)factionId2Num.get(Long.valueOf(this.factionId));
/* 67 */     if (oldValue == null)
/*    */     {
/* 69 */       oldValue = new Integer(0);
/*    */     }
/* 71 */     factionId2Num.put(Long.valueOf(this.factionId), Integer.valueOf(oldValue.intValue() + ((UseGangFileItemArg)this.arg).num));
/*    */     
/*    */ 
/* 74 */     WorshipManager.synRoleWorshipData(this.roleId, this.factionId, xRoleWorshipInfo);
/* 75 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worship\main\POnUseFactionFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */