/*    */ package mzm.gsp;
/*    */ 
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ public class GetServerZoneids
/*    */ {
/*    */   private static Logger logger;
/*    */   
/*    */   private static void usage()
/*    */   {
/* 12 */     System.err.println("Usage: java <xdb.xml>");
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private static void initLogger()
/*    */   {
/* 20 */     System.out.println("configuring log4j with log4j.merge.xml");
/* 21 */     org.apache.log4j.xml.DOMConfigurator.configure("log4j.merge.xml");
/* 22 */     logger = Logger.getLogger("root");
/*    */   }
/*    */   
/*    */   public static Logger logger()
/*    */   {
/* 27 */     if (logger == null)
/*    */     {
/* 29 */       initLogger();
/*    */     }
/*    */     
/* 32 */     return logger;
/*    */   }
/*    */   
/*    */   public static void main(String[] args)
/*    */   {
/* 37 */     if (args.length != 1)
/*    */     {
/* 39 */       usage();
/*    */       
/* 41 */       System.exit(1);
/*    */     }
/*    */     
/*    */ 
/* 45 */     initLogger();
/*    */     
/*    */ 
/*    */     try
/*    */     {
/* 50 */       String xdbXml = args[0];
/*    */       
/* 52 */       logger.info("[merge]GetServerZoneids.main@start xdb ...");
/*    */       
/* 54 */       Xdb.getInstance().setConf(new xdb.XdbConf(xdbXml));
/* 55 */       Xdb.getInstance().start();
/*    */       
/* 57 */       logger.info("[merge]GetServerZoneids.main@start xdb done");
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 61 */       logger.error("[merge]GetServerZoneids.main@start xdb error", e);
/*    */       
/* 63 */       System.exit(2);
/*    */     }
/*    */     
/*    */     try
/*    */     {
/* 68 */       if (!new PGetServerZoneids().call())
/*    */       {
/* 70 */         logger.error("[merge]GetServerZoneids.main@get zoneids failed");
/*    */         
/* 72 */         System.exit(3);
/*    */       }
/*    */       return;
/*    */     }
/*    */     finally {
/* 77 */       logger.info("[merge]GetServerZoneids.main@stop xdb ...");
/*    */       try
/*    */       {
/* 80 */         Xdb.getInstance().stop();
/*    */       }
/*    */       catch (Exception e)
/*    */       {
/* 84 */         logger.error("[merge]GetServerZoneids.main@stop xdb error", e);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\GetServerZoneids.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */