/*    */ package mzm.gsp.changemodelcard.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import mzm.gsp.changemodelcard.confbean.SCardLevelBean;
/*    */ import mzm.gsp.changemodelcard.confbean.SCardLevelCfg;
/*    */ import mzm.gsp.changemodelcard.confbean.SClassLevelBean;
/*    */ import mzm.gsp.changemodelcard.confbean.SClassLevelCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChangeModelCardCfgManager
/*    */ {
/*    */   static SCardLevelBean getCardLevelCfg(int cardCfgId, int cardLevel)
/*    */   {
/* 20 */     SCardLevelCfg sCardLevelCfg = SCardLevelCfg.get(cardCfgId);
/* 21 */     if (null == sCardLevelCfg)
/*    */     {
/* 23 */       return null;
/*    */     }
/* 25 */     return (SCardLevelBean)sCardLevelCfg.level2Bean.get(Integer.valueOf(cardLevel));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static SClassLevelBean getClassLevelCfg(int classType, int classLevel)
/*    */   {
/* 37 */     SClassLevelCfg sClassLevelCfg = SClassLevelCfg.get(classType);
/* 38 */     if (null == sClassLevelCfg)
/*    */     {
/* 40 */       return null;
/*    */     }
/* 42 */     return (SClassLevelBean)sClassLevelCfg.level2Bean.get(Integer.valueOf(classLevel));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\main\ChangeModelCardCfgManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */