/*    */ package mzm.gsp.questionvoice.main.choosepolicy;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import java.util.TreeMap;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.questionvoice.confbean.SQuestionVoiceBean;
/*    */ import mzm.gsp.questionvoice.confbean.SQuestionVoiceCfg;
/*    */ import mzm.gsp.questionvoice.confbean.SQuestionVoiceChoosePolicyCfg;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RandomDiff
/*    */   extends AbstractChoosePolicy<IChoosePolicyArgs>
/*    */ {
/*    */   public RandomDiff(int policyId)
/*    */   {
/* 23 */     super(policyId, SingletonArgs.DEFAULT.getArgs());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public List<Integer> getQuestionIds()
/*    */   {
/* 30 */     SQuestionVoiceChoosePolicyCfg cfg = SQuestionVoiceChoosePolicyCfg.get(this.policyId);
/* 31 */     TreeMap<Integer, SQuestionVoiceBean> id2CfgMap = SQuestionVoiceCfg.get(cfg.questionType).id2CfgMap;
/* 32 */     if (cfg.questionNum > id2CfgMap.size())
/*    */     {
/* 34 */       GameServer.logger().error(String.format("[questionvoice]RandomDiff@question less|need=%d|total=%d", new Object[] { Integer.valueOf(cfg.questionNum), Integer.valueOf(id2CfgMap.size()) }));
/*    */       
/* 36 */       return Collections.EMPTY_LIST;
/*    */     }
/* 38 */     List<Integer> questionIds = new ArrayList(id2CfgMap.keySet());
/* 39 */     Collections.shuffle(questionIds);
/* 40 */     return questionIds.subList(0, cfg.questionNum - 1);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\questionvoice\main\choosepolicy\RandomDiff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */