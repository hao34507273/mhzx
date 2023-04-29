/*    */ package mzm.gsp.csprovider.gmt.idip.generalcmd;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.achievement.main.AchievementInterface;
/*    */ import mzm.gsp.achievement.main.AchievementInterface.ChangeParamResult;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipGmtUtil;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipHandler;
/*    */ import mzm.gsp.csprovider.gmt.idip.Response;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class SetRoleAchievementProgressHandler implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 21 */     long roleid = Long.parseLong((String)params.get(0));
/* 22 */     int goalCfgid = Integer.parseInt((String)params.get(1));
/* 23 */     int size = Integer.parseInt((String)params.get(2));
/*    */     
/* 25 */     if ((size > 7) || (size < 0))
/*    */     {
/* 27 */       int retcode = Retcode.SUCCESS.value;
/* 28 */       rsp.retcode = retcode;
/* 29 */       Response response = IdipGmtUtil.getResponse(retcode, "param size invalid");
/* 30 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 32 */       GameServer.logger().error(String.format("[gmt]SetRoleAchievementProgressHandler.execute@param size invalid|roleid=%d|goal_cfgid=%d|size=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(goalCfgid), Integer.valueOf(size) }));
/*    */       
/*    */ 
/*    */ 
/* 36 */       return;
/*    */     }
/*    */     
/* 39 */     List<Integer> newParams = new ArrayList();
/* 40 */     for (int i = 0; i < size; i++)
/*    */     {
/* 42 */       newParams.add(Integer.valueOf(Integer.parseInt((String)params.get(3 + i))));
/*    */     }
/*    */     
/* 45 */     AchievementInterface.ChangeParamResult changeParamResult = AchievementInterface.changeAchievementParam(roleid, goalCfgid, newParams);
/* 46 */     if (changeParamResult != AchievementInterface.ChangeParamResult.SUCCESS)
/*    */     {
/* 48 */       int retcode = Retcode.SUCCESS.value;
/* 49 */       rsp.retcode = retcode;
/* 50 */       Response response = IdipGmtUtil.getResponse(retcode, "failed");
/* 51 */       rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */       
/* 53 */       GameServer.logger().error(String.format("[gmt]SetRoleAchievementProgressHandler.execute@failed|roleid=%d|goal_cfgid=%d|retcode=%d|params=%s", new Object[] { Long.valueOf(roleid), Integer.valueOf(goalCfgid), Integer.valueOf(changeParamResult.value), newParams.toString() }));
/*    */       
/*    */ 
/*    */ 
/* 57 */       return;
/*    */     }
/*    */     
/* 60 */     rsp.retcode = Retcode.SUCCESS.value;
/* 61 */     Response response = new Response();
/* 62 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 64 */     GameServer.logger().info(String.format("[gmt]SetRoleAchievementProgressHandler.execute@success|roleid=%d|goal_cfgid=%d|params=%s", new Object[] { Long.valueOf(roleid), Integer.valueOf(goalCfgid), newParams.toString() }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\SetRoleAchievementProgressHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */