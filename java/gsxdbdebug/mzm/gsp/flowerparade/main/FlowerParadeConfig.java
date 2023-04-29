/*    */ package mzm.gsp.flowerparade.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ public class FlowerParadeConfig
/*    */ {
/*  8 */   public static int REST_ZONE_WIDTH = 48;
/*    */   
/*    */   public static void init(Map<String, String> args)
/*    */   {
/* 12 */     REST_ZONE_WIDTH = Integer.parseInt((String)args.get("restZoneWidth"));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\flowerparade\main\FlowerParadeConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */