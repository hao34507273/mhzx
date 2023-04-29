/*    */ package mzm.gsp.questionvoice.main.choosepolicy;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Random;
/*    */ import java.util.TreeMap;
/*    */ import mzm.gsp.questionvoice.confbean.SQuestionVoiceBean;
/*    */ import mzm.gsp.questionvoice.confbean.SQuestionVoiceCfg;
/*    */ import mzm.gsp.questionvoice.confbean.SQuestionVoiceChoosePolicyCfg;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RandomAny
/*    */   extends AbstractChoosePolicy<IChoosePolicyArgs>
/*    */ {
/*    */   public RandomAny(int policyId)
/*    */   {
/* 23 */     super(policyId, SingletonArgs.DEFAULT.getArgs());
/*    */   }
/*    */   
/*    */ 
/*    */   public List<Integer> getQuestionIds()
/*    */   {
/* 29 */     SQuestionVoiceChoosePolicyCfg cfg = SQuestionVoiceChoosePolicyCfg.get(this.policyId);
/* 30 */     TreeMap<Integer, SQuestionVoiceBean> id2CfgMap = SQuestionVoiceCfg.get(cfg.questionType).id2CfgMap;
/* 31 */     List<Integer> chooseResult = new ArrayList(cfg.questionNum);
/*    */     
/* 33 */     List<Integer> questionIds = new ArrayList(id2CfgMap.keySet());
/*    */     
/* 35 */     for (int i = 0; i < cfg.questionNum; i++)
/*    */     {
/* 37 */       int randomIndex = Xdb.random().nextInt(questionIds.size());
/* 38 */       chooseResult.add(questionIds.get(randomIndex));
/*    */     }
/* 40 */     return chooseResult;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\questionvoice\main\choosepolicy\RandomAny.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */