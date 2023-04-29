/*    */ package mzm.gsp.questionvoice.main.choosepolicy;
/*    */ 
/*    */ import java.util.List;
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
/*    */ public abstract class AbstractChoosePolicy<T extends IChoosePolicyArgs>
/*    */ {
/*    */   protected final int policyId;
/*    */   protected final T arg;
/*    */   
/*    */   public AbstractChoosePolicy(int policyId, T arg)
/*    */   {
/* 23 */     this.policyId = policyId;
/* 24 */     this.arg = arg;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public abstract List<Integer> getQuestionIds();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getQuestionId()
/*    */   {
/* 41 */     List<Integer> questionIds = getQuestionIds();
/* 42 */     if ((questionIds == null) || (questionIds.size() <= 0))
/*    */     {
/* 44 */       return -1;
/*    */     }
/* 46 */     return ((Integer)questionIds.get(0)).intValue();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public TreeMap<Integer, SQuestionVoiceBean> getQuestionMap()
/*    */   {
/* 56 */     SQuestionVoiceChoosePolicyCfg sQuestionVoiceChoosePolicyCfg = SQuestionVoiceChoosePolicyCfg.get(this.policyId);
/* 57 */     SQuestionVoiceCfg sQuestionVoiceCfg = SQuestionVoiceCfg.get(sQuestionVoiceChoosePolicyCfg.questionType);
/* 58 */     if (sQuestionVoiceCfg == null)
/*    */     {
/* 60 */       return new TreeMap();
/*    */     }
/* 62 */     return sQuestionVoiceCfg.id2CfgMap;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\questionvoice\main\choosepolicy\AbstractChoosePolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */