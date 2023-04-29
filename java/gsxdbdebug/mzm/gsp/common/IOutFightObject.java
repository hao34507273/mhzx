/*     */ package mzm.gsp.common;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.pubdata.ModelInfo;
/*     */ import mzm.gsp.skill.confbean.SOutFightEffectGroup;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract interface IOutFightObject
/*     */ {
/*     */   public abstract String getName();
/*     */   
/*     */   public abstract int getSex();
/*     */   
/*     */   public abstract int getLevel();
/*     */   
/*     */   public abstract int getHP();
/*     */   
/*     */   public abstract int getMP();
/*     */   
/*     */   public abstract int getOccupationId();
/*     */   
/*     */   public abstract void setHP(int paramInt);
/*     */   
/*     */   public abstract void setMP(int paramInt);
/*     */   
/*     */   public abstract void fillSelfFixFightProperty(Map<Integer, Integer> paramMap);
/*     */   
/*     */   public abstract Map<Integer, Integer> getSelfFixFightProperty();
/*     */   
/*     */   public abstract void fillOtherFightProperty(Map<Integer, Integer> paramMap);
/*     */   
/*     */   public abstract Map<Integer, Integer> getOtherFightProperty();
/*     */   
/*     */   public abstract Map<Integer, Integer> getFinalPropertyMap();
/*     */   
/*     */   public abstract void fillFinalPropertyMap(Map<Integer, Integer> paramMap);
/*     */   
/*     */   public abstract int getFinalMaxHP();
/*     */   
/*     */   public abstract int getFinalMaxMP();
/*     */   
/*     */   public abstract int getFinalPHYATK();
/*     */   
/*     */   public abstract int getFinalMAGATK();
/*     */   
/*     */   public abstract int getFinalPHYDEF();
/*     */   
/*     */   public abstract int getFinalMAGDEF();
/*     */   
/*     */   public abstract int getFinalPHYCRTRate();
/*     */   
/*     */   public abstract int getFinalMAGCRTRate();
/*     */   
/*     */   public abstract int getFinalPHYCRTVALUE();
/*     */   
/*     */   public abstract int getFinalMAGCRTVALUE();
/*     */   
/*     */   public abstract int getFinalSpeed();
/*     */   
/*     */   public abstract int getFinalSeal();
/*     */   
/*     */   public abstract int getFinalSealRst();
/*     */   
/*     */   public abstract void addPropertyValue(int paramInt1, int paramInt2);
/*     */   
/*     */   public abstract void fillModelInfo(ModelInfo paramModelInfo);
/*     */   
/*     */   public abstract List<SOutFightEffectGroup> getFighterEffect();
/*     */   
/*     */   public abstract FighterState getFighterState();
/*     */   
/*     */   public static class FighterState
/*     */   {
/*     */     public final int groupId;
/*     */     public final int state;
/*     */     
/*     */     public FighterState(int grpId, int state)
/*     */     {
/* 178 */       this.groupId = grpId;
/* 179 */       this.state = state;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\common\IOutFightObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */