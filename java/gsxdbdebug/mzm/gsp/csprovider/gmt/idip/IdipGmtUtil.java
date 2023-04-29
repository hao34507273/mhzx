/*    */ package mzm.gsp.csprovider.gmt.idip;
/*    */ 
/*    */ import jsonio.JsonMarshal;
/*    */ import jsonio.JsonStream;
/*    */ 
/*    */ public class IdipGmtUtil
/*    */ {
/*    */   public static long getRoleid(String str)
/*    */   {
/* 10 */     long roleNo = Long.parseLong(str);
/* 11 */     return roleNo;
/*    */   }
/*    */   
/*    */   public static String toString(JsonMarshal jm)
/*    */   {
/* 16 */     JsonStream js = new JsonStream();
/* 17 */     jm.marshal(js);
/* 18 */     return js.toString();
/*    */   }
/*    */   
/*    */   public static Response getResponse(int retcode, String msg)
/*    */   {
/* 23 */     Response rsp = new Response();
/* 24 */     rsp.retcode = retcode;
/* 25 */     rsp.msg = msg;
/* 26 */     return rsp;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\IdipGmtUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */