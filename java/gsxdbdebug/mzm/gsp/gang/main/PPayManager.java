/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.gang.confbean.SGangConst;
/*    */ import mzm.gsp.mail.main.MailInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class PPayManager
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int gold;
/*    */   private final String gangName;
/*    */   private final String dutyName;
/*    */   private final long gangid;
/*    */   private final long gangDisplayId;
/*    */   
/*    */   PPayManager(long roleid, int gold, String gangName, String dutyName, long gangid, long gangDisplayId)
/*    */   {
/* 30 */     this.roleid = roleid;
/* 31 */     this.gold = gold;
/* 32 */     this.gangName = gangName;
/* 33 */     this.dutyName = dutyName;
/* 34 */     this.gangid = gangid;
/* 35 */     this.gangDisplayId = gangDisplayId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 41 */     RoleInterface.addGold(this.roleid, this.gold, new TLogArg(LogReason.GANG_PAY_MANAGER));
/*    */     
/* 43 */     List<String> contentArgs = new ArrayList();
/* 44 */     contentArgs.add(this.gangName);
/* 45 */     contentArgs.add(this.dutyName);
/* 46 */     contentArgs.add(String.valueOf(this.gold));
/*    */     
/* 48 */     MailInterface.synBuildAndSendMail(this.roleid, SGangConst.getInstance().PAY_MAIL, null, contentArgs, new TLogArg(LogReason.GANG_LIHE_ADD, SGangConst.getInstance().PAY_MAIL));
/*    */     
/*    */ 
/* 51 */     StringBuilder tLogStr = new StringBuilder();
/*    */     
/* 53 */     tLogStr.append(GameServerInfoManager.getHostIP()).append("|").append(RoleInterface.getUserId(this.roleid)).append("|").append(this.roleid).append("|").append(RoleInterface.getLevel(this.roleid)).append("|").append(this.gangid).append("|").append(this.gold).append("|").append(this.dutyName).append("|").append(this.gangDisplayId);
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 61 */     TLogManager.getInstance().addLog(this.roleid, "GangPayMember", tLogStr.toString());
/*    */     
/* 63 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PPayManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */