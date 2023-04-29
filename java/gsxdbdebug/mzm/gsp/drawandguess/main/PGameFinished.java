/*    */ package mzm.gsp.drawandguess.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.drawandguess.SSynAnswerDrawAndGuessFinished;
/*    */ import mzm.gsp.drawandguess.event.DrawAndGuessFinishArg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.DrawAndGuessInfo;
/*    */ import xtable.Drawandguess_info;
/*    */ import xtable.Role2drawandguess_info;
/*    */ 
/*    */ public class PGameFinished extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long drawandguessId;
/*    */   private final List<Long> memberIds;
/*    */   
/*    */   public PGameFinished(long drawandguessId, List<Long> memberIds)
/*    */   {
/* 19 */     this.drawandguessId = drawandguessId;
/* 20 */     this.memberIds = memberIds;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     xdb.Lockeys.lock(Role2drawandguess_info.getTable(), this.memberIds);
/*    */     
/* 29 */     DrawAndGuessInfo drawAndGuessInfo = Drawandguess_info.get(Long.valueOf(this.drawandguessId));
/* 30 */     if (drawAndGuessInfo != null)
/*    */     {
/*    */ 
/* 33 */       IDrawAndGuessContext context = drawAndGuessInfo.getContext();
/* 34 */       context.addJifen(drawAndGuessInfo.getDrawer_id(), drawAndGuessInfo.getSuc_roleidsAsData());
/*    */       
/* 36 */       TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.drawandguess.event.DrawAndGuessFinish(), new DrawAndGuessFinishArg(drawAndGuessInfo.getDrawer_id(), drawAndGuessInfo.getAll_roleidsAsData(), drawAndGuessInfo.getSuc_roleidsAsData(), context));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 41 */       DrawAndGuessManager.removeAllDrawAndGuessRoles(drawAndGuessInfo.getAll_roleids());
/* 42 */       Drawandguess_info.remove(Long.valueOf(this.drawandguessId));
/*    */       
/*    */ 
/* 45 */       SSynAnswerDrawAndGuessFinished res = new SSynAnswerDrawAndGuessFinished();
/* 46 */       res.rightanswer = DrawAndGuessManager.getAnswer(drawAndGuessInfo.getCfg_id());
/* 47 */       OnlineManager.getInstance().sendMulti(res, drawAndGuessInfo.getAll_roleidsAsData());
/*    */       
/*    */ 
/* 50 */       DrawAndGuessTLogManager.tlogDrawAndGuessFinished(this.drawandguessId, drawAndGuessInfo.getCfg_id(), drawAndGuessInfo.getDrawer_id(), drawAndGuessInfo.getAll_roleidsAsData(), drawAndGuessInfo.getSuc_roleidsAsData(), context.getJifenInfo());
/* 51 */       return true;
/*    */     }
/*    */     
/* 54 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\main\PGameFinished.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */