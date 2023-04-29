/*    */ package mzm.gsp.multixml.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.multixml.confbean.SMultiXMLCfg;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MultiXMLManager
/*    */ {
/*    */   static void init()
/*    */   {
/* 16 */     OpenInterface.setOpenDefaultStatus(141, false);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isMultiXMLFunOpen()
/*    */   {
/* 25 */     if (!OpenInterface.getOpenStatus(141))
/*    */     {
/* 27 */       return false;
/*    */     }
/* 29 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static int getXMLDateType()
/*    */   {
/* 39 */     if (!isMultiXMLFunOpen())
/* 40 */       return 0;
/* 41 */     SMultiXMLCfg multiXMLCfg = (SMultiXMLCfg)SMultiXMLCfg.getAll().get(Integer.valueOf((int)GameServerInfoManager.getLocalId()));
/* 42 */     if (multiXMLCfg != null)
/* 43 */       return multiXMLCfg.xml_data_type;
/* 44 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\multixml\main\MultiXMLManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */