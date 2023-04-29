/*    */ package com.goldhuman.service.mzminterfaces;
/*    */ 
/*    */ import java.lang.management.ManagementFactory;
/*    */ import javax.management.MBeanServer;
/*    */ import javax.management.ObjectName;
/*    */ 
/*    */ abstract class GameControlMBeanRegister
/*    */ {
/*    */   public boolean registerMBean()
/*    */   {
/*    */     try
/*    */     {
/* 13 */       MBeanServer server = ManagementFactory.getPlatformMBeanServer();
/* 14 */       ObjectName configname = new ObjectName("IWEB:type=GameControl");
/* 15 */       server.registerMBean(this, configname);
/* 16 */       return true;
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 20 */       e.printStackTrace();
/*    */     }
/* 22 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\com\goldhuman\service\mzminterfaces\GameControlMBeanRegister.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */