/*    */ package mzm.gsp.questionvoice.main.choosepolicy;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.TreeMap;
/*    */ import mzm.gsp.questionvoice.confbean.SQuestionVoiceBean;
/*    */ import mzm.gsp.questionvoice.confbean.SQuestionVoiceCfg;
/*    */ import mzm.gsp.questionvoice.confbean.SQuestionVoiceChoosePolicyCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ByCfgOrderCircle
/*    */   extends AbstractChoosePolicy<ByCfgOrderCircleArgs>
/*    */ {
/*    */   public ByCfgOrderCircle(int policyId, ByCfgOrderCircleArgs arg)
/*    */   {
/* 24 */     super(policyId, arg);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public List<Integer> getQuestionIds()
/*    */   {
/* 31 */     SQuestionVoiceChoosePolicyCfg cfg = SQuestionVoiceChoosePolicyCfg.get(this.policyId);
/* 32 */     TreeMap<Integer, SQuestionVoiceBean> id2CfgMap = SQuestionVoiceCfg.get(cfg.questionType).id2CfgMap;
/*    */     
/* 34 */     List<Integer> chooseResult = new ArrayList(cfg.questionNum);
/*    */     
/*    */ 
/* 37 */     int lastQuestionCfgId = ((ByCfgOrderCircleArgs)this.arg).getLastQuestionCfgId();
/*    */     
/* 39 */     int nextQuestionCfgId = 0;
/*    */     
/* 41 */     for (int i = 0; i < cfg.questionNum; i++)
/*    */     {
/*    */ 
/* 44 */       if (lastQuestionCfgId <= 0)
/*    */       {
/* 46 */         List<Integer> questionIds = new ArrayList(id2CfgMap.keySet());
/* 47 */         Collections.shuffle(questionIds);
/* 48 */         nextQuestionCfgId = ((Integer)questionIds.get(0)).intValue();
/*    */ 
/*    */       }
/*    */       else
/*    */       {
/* 53 */         Map.Entry<Integer, SQuestionVoiceBean> entry = id2CfgMap.ceilingEntry(Integer.valueOf(lastQuestionCfgId + 1));
/* 54 */         if (entry == null)
/*    */         {
/* 56 */           nextQuestionCfgId = ((Integer)id2CfgMap.firstKey()).intValue();
/*    */         }
/*    */         else
/*    */         {
/* 60 */           nextQuestionCfgId = ((Integer)entry.getKey()).intValue();
/*    */         }
/*    */       }
/* 63 */       lastQuestionCfgId = nextQuestionCfgId;
/* 64 */       chooseResult.add(Integer.valueOf(nextQuestionCfgId));
/*    */     }
/* 66 */     return chooseResult;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\questionvoice\main\choosepolicy\ByCfgOrderCircle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */