/*    */ package mzm.gsp.grc.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.grc.event.GetBindVitalityInfoDoneArg;
/*    */ import mzm.gsp.grc.event.GetBindVitalityInfoDoneProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnGetBindVitalityInfoDone extends GetBindVitalityInfoDoneProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     Octets octets = ((GetBindVitalityInfoDoneArg)this.arg).context;
/* 16 */     OctetsStream os = new OctetsStream(octets);
/* 17 */     GetBindVitalityInfoContext context = new GetBindVitalityInfoContext();
/* 18 */     context.unmarshal(os);
/*    */     
/* 20 */     int count = context.count;
/* 21 */     long roleid = context.roleid;
/*    */     
/* 23 */     int retcode = ((GetBindVitalityInfoDoneArg)this.arg).retcode;
/* 24 */     String openid = ((GetBindVitalityInfoDoneArg)this.arg).openid;
/* 25 */     if (retcode == 0)
/*    */     {
/* 27 */       String userid = RoleInterface.getUserId(roleid);
/* 28 */       GetBindVitalityInfoResponse response = ((GetBindVitalityInfoDoneArg)this.arg).response;
/* 29 */       GrcManager.syncBindVitalityInfo(userid, roleid, null, response.role_vitality_info, response.recall_bind_info, response.back_bind_info);
/*    */       
/*    */ 
/* 32 */       GameServer.logger().info(String.format("[recall]POnGetBindVitalityInfoDone.processImp@success|retcode=%d|openid=%s|roleid=%d|count=%d", new Object[] { Integer.valueOf(retcode), openid, Long.valueOf(roleid), Integer.valueOf(count) }));
/*    */       
/*    */ 
/*    */ 
/* 36 */       return true;
/*    */     }
/*    */     
/* 39 */     GameServer.logger().error(String.format("[recall]POnGetBindVitalityInfoDone.processImp@failed|retcode=%d|openid=%s|roleid=%d|count=%d", new Object[] { Integer.valueOf(retcode), openid, Long.valueOf(roleid), Integer.valueOf(count) }));
/*    */     
/*    */ 
/*    */ 
/* 43 */     if (retcode == 8)
/*    */     {
/* 45 */       if (count >= 3)
/*    */       {
/* 47 */         return false;
/*    */       }
/*    */       
/* 50 */       context.count = (count + 1);
/* 51 */       OctetsStream osContext = new OctetsStream();
/* 52 */       context.marshal(osContext);
/* 53 */       if (!GrcManager.getBindVitalityInfo(openid, osContext))
/*    */       {
/* 55 */         GameServer.logger().error(String.format("[recall]POnGetBindVitalityInfoDone.processImp@send msg failed|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*    */         
/* 57 */         return false;
/*    */       }
/* 59 */       return true;
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\main\POnGetBindVitalityInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */