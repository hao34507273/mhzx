/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
/*    */ import mzm.gsp.confConverter.ConfManager;
/*    */ 
/*    */ class QingfuArgs
/*    */ {
/*  8 */   private static QingfuArgs instance = new QingfuArgs();
/*    */   
/*    */ 
/*    */ 
/* 12 */   public static QingfuArgs getInstance() { return instance; }
/*    */   
/*    */   @XStreamAsAttribute
/* 15 */   java.util.Map<String, Integer> channels = new java.util.HashMap();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static void init()
/*    */   {
/* 23 */     instance = (QingfuArgs)ConfManager.getInstance().getconf("mzm.gsp.qingfu.main.QingfuArgs");
/* 24 */     if (instance == null)
/*    */     {
/* 26 */       throw new RuntimeException("找不到登陆程序配置：mzm.gsp.qingfu.main.QingfuArgs");
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\QingfuArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */