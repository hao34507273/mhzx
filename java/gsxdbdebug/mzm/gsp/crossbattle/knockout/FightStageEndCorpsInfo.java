/*    */ package mzm.gsp.crossbattle.knockout;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.pubdata.ModelInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FightStageEndCorpsInfo
/*    */ {
/*    */   public long corpsId;
/*    */   public String corpsName;
/*    */   public int corpsZoneId;
/*    */   public int corpsBadgeId;
/*    */   public List<CorpsMemberInfoObj> corpsMemberSet;
/*    */   
/*    */   public FightStageEndCorpsInfo()
/*    */   {
/* 33 */     this.corpsMemberSet = new ArrayList();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static class CorpsMemberInfoObj
/*    */   {
/*    */     public long roleId;
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */     public int gender;
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */     public int occupation;
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */     public String roleName;
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */     public int avatarId;
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */     public int roleLevel;
/*    */     
/*    */ 
/*    */ 
/*    */     public int roleFightValue;
/*    */     
/*    */ 
/*    */ 
/* 75 */     public ModelInfo modelInfo = new ModelInfo();
/*    */     public int duty;
/*    */     public int joinTime;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\FightStageEndCorpsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */