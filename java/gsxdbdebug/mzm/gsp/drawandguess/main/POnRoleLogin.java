/*    */ package mzm.gsp.drawandguess.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.drawandguess.AnswerInfo;
/*    */ import mzm.gsp.drawandguess.RoleGetJifenInfo;
/*    */ import mzm.gsp.drawandguess.SSynAnswerInfoList;
/*    */ import mzm.gsp.drawandguess.SSynDrawAndGuessQuestionInfo;
/*    */ import mzm.gsp.drawandguess.SSynDrawLineInfoList;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import xbean.DrawAndGuessInfo;
/*    */ import xtable.Drawandguess_info;
/*    */ import xtable.Role2drawandguess_info;
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 26 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 32 */     Long drawandguessId = Role2drawandguess_info.get(Long.valueOf(roleId));
/* 33 */     if (drawandguessId == null)
/*    */     {
/* 35 */       return true;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 42 */     DrawAndGuessInfo drawAndGuessInfo = Drawandguess_info.get(drawandguessId);
/* 43 */     if (drawAndGuessInfo == null)
/*    */     {
/* 45 */       if (RoleStatusInterface.containsStatus(roleId, 1211)) {
/* 46 */         RoleStatusInterface.unsetStatus(roleId, 1211);
/*    */       }
/* 48 */       Role2drawandguess_info.remove(Long.valueOf(roleId));
/* 49 */       return true;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 55 */     if ((drawAndGuessInfo.getContext() == null) || (!(drawAndGuessInfo.getContext() instanceof DrawAndGuessContext)))
/*    */     {
/* 57 */       return false;
/*    */     }
/* 59 */     DrawAndGuessContext drawAndGuessContext = (DrawAndGuessContext)drawAndGuessInfo.getContext();
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 64 */     SSynDrawAndGuessQuestionInfo sSynDrawAndGuessQuestionInfo = new SSynDrawAndGuessQuestionInfo();
/* 65 */     sSynDrawAndGuessQuestionInfo.drawerid = drawAndGuessInfo.getDrawer_id();
/* 66 */     sSynDrawAndGuessQuestionInfo.roleid_list.addAll(drawAndGuessInfo.getAll_roleids());
/* 67 */     sSynDrawAndGuessQuestionInfo.questioncfgid = drawAndGuessInfo.getCfg_id();
/* 68 */     sSynDrawAndGuessQuestionInfo.timestamp = TimeUnit.MILLISECONDS.toSeconds(drawAndGuessInfo.getStart_time());
/* 69 */     sSynDrawAndGuessQuestionInfo.sessionid = drawAndGuessInfo.getSession_id();
/* 70 */     sSynDrawAndGuessQuestionInfo.sendtype = 0;
/* 71 */     Map<Long, Integer> jifenInfo = drawAndGuessContext.getJifenInfo();
/* 72 */     for (Map.Entry<Long, Integer> entry : jifenInfo.entrySet())
/*    */     {
/* 74 */       sSynDrawAndGuessQuestionInfo.jifen_list.add(new RoleGetJifenInfo(((Long)entry.getKey()).longValue(), ((Integer)entry.getValue()).intValue()));
/*    */     }
/*    */     
/* 77 */     OnlineManager.getInstance().send(roleId, sSynDrawAndGuessQuestionInfo);
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 82 */     SSynAnswerInfoList sSynAnswerInfoList = new SSynAnswerInfoList();
/* 83 */     for (Iterator i$ = drawAndGuessInfo.getSuc_roleidsAsData().iterator(); i$.hasNext();) { long successRoleId = ((Long)i$.next()).longValue();
/*    */       
/* 85 */       sSynAnswerInfoList.answerinfo_list.add(new AnswerInfo(successRoleId, "", 1));
/*    */     }
/*    */     
/* 88 */     sSynAnswerInfoList.answerinfo_list.addAll(drawAndGuessContext.getAnswerQueue());
/* 89 */     OnlineManager.getInstance().send(roleId, sSynAnswerInfoList);
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 94 */     SSynDrawLineInfoList sSynDrawLineInfoList = new SSynDrawLineInfoList();
/* 95 */     sSynDrawLineInfoList.drawlineinfo_list.addAll(drawAndGuessContext.getDrawInfoMap().values());
/* 96 */     OnlineManager.getInstance().send(roleId, sSynDrawLineInfoList);
/*    */     
/* 98 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */