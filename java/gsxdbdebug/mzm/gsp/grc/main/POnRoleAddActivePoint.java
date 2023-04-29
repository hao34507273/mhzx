/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.active.event.ActiveArg;
/*    */ import mzm.gsp.active.main.ActiveInterface;
/*    */ import mzm.gsp.role.main.Role;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnRoleAddActivePoint extends mzm.gsp.active.event.AddActivePointProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*    */     
/* 19 */     long roleid = ((ActiveArg)this.arg).roleid;
/* 20 */     String userid = RoleInterface.getUserId(roleid);
/* 21 */     String openid = CommonUtils.getOpenId(userid);
/* 22 */     Role role = RoleInterface.getRole(roleid, true);
/* 23 */     if (role == null)
/*    */     {
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     int point = ActiveInterface.getTotalActiveValue(roleid);
/* 29 */     RoleVitalityInfo vitalityInfo = new RoleVitalityInfo();
/* 30 */     vitalityInfo.roleid = roleid;
/* 31 */     vitalityInfo.name.setString(role.getName(), "UTF-8");
/* 32 */     vitalityInfo.level = role.getLevel();
/* 33 */     vitalityInfo.gender = ((byte)role.getGender());
/* 34 */     vitalityInfo.occupation = role.getOccupationId();
/* 35 */     vitalityInfo.fight = RoleInterface.getFightValue(roleid);
/* 36 */     vitalityInfo.zoneid = CommonUtils.getZoneId(role.getUserId());
/*    */     
/* 38 */     vitalityInfo.time = now;
/* 39 */     vitalityInfo.vitality = point;
/*    */     
/* 41 */     OctetsStream osContext = new OctetsStream();
/* 42 */     osContext.marshal(1);
/* 43 */     if (!GrcManager.updateRoleVitalityInfo(openid, vitalityInfo, osContext))
/*    */     {
/* 45 */       GameServer.logger().error(String.format("[recall]POnRoleAddActivePoint.processImp@send failed|roleid=%d|openid=%s", new Object[] { Long.valueOf(roleid), openid }));
/*    */       
/* 47 */       return false;
/*    */     }
/* 49 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\POnRoleAddActivePoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */