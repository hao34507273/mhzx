/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import org.json.JSONArray;
/*    */ import org.json.JSONException;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PReportTlog
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final Octets tlogName;
/*    */   private final Octets tlogContent;
/*    */   
/*    */   public PReportTlog(long roleId, Octets tlogName, Octets tlogContent)
/*    */   {
/* 25 */     this.roleId = roleId;
/* 26 */     this.tlogName = tlogName;
/* 27 */     this.tlogContent = tlogContent;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 33 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 203, true))
/*    */     {
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     String tlogName = this.tlogName.getString("UTF-8");
/* 39 */     String tlogContent = this.tlogContent.getString("UTF-8");
/*    */     
/* 41 */     if ((tlogName.indexOf('|') != -1) || (tlogContent.indexOf('|') != -1))
/*    */     {
/* 43 */       GameServer.logger().error(String.format("[online]PReportTlog.processImp@tlog_name or tlog_content contains brvbar|tlog_name=\"%s\"|tlog_content=\"%s\"", new Object[] { tlogName, tlogContent }));
/*    */       
/*    */ 
/*    */ 
/* 47 */       return false;
/*    */     }
/*    */     
/* 50 */     String userId = RoleInterface.getUserId(this.roleId);
/* 51 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/* 52 */     StringBuilder sbLog = new StringBuilder();
/* 53 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 54 */     sbLog.append(userId).append('|');
/* 55 */     sbLog.append(this.roleId).append('|');
/* 56 */     sbLog.append(String.valueOf(roleLevel));
/*    */     
/* 58 */     JSONArray jsonArgs = null;
/*    */     try
/*    */     {
/* 61 */       jsonArgs = new JSONArray(tlogContent);
/*    */     }
/*    */     catch (JSONException e)
/*    */     {
/* 65 */       GameServer.logger().error(String.format("[online]PReportTlog.processImp@tlog content json exception|role_id=%d|tlog_name=\"%s\"|tlog_content=\"%s\"", new Object[] { Long.valueOf(this.roleId), tlogName, tlogContent }));
/*    */       
/*    */ 
/*    */ 
/* 69 */       return false;
/*    */     }
/*    */     
/* 72 */     int len = jsonArgs.length();
/* 73 */     for (int i = 0; i < len; i++)
/*    */     {
/* 75 */       sbLog.append('|');
/* 76 */       sbLog.append(jsonArgs.getString(i));
/*    */     }
/* 78 */     return TLogManager.getInstance().addLog(this.roleId, tlogName, sbLog.toString());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\PReportTlog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */