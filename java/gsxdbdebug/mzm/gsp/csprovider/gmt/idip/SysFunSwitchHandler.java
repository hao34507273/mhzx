/*    */ package mzm.gsp.csprovider.gmt.idip;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class SysFunSwitchHandler
/*    */   implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp) throws Exception
/*    */   {
/* 18 */     int open = Integer.parseInt((String)params.get(0));
/* 19 */     int moduleid = Integer.parseInt((String)params.get(1));
/* 20 */     int funid = Integer.parseInt((String)params.get(2));
/*    */     
/* 22 */     int parameter1 = Integer.parseInt((String)params.get(3));
/* 23 */     int parameter2 = Integer.parseInt((String)params.get(4));
/* 24 */     int parameter3 = Integer.parseInt((String)params.get(5));
/*    */     
/* 26 */     List<Integer> ps = new ArrayList();
/* 27 */     if (parameter1 > 0)
/*    */     {
/* 29 */       ps.add(Integer.valueOf(parameter1));
/*    */     }
/* 31 */     if (parameter2 > 0)
/*    */     {
/* 33 */       ps.add(Integer.valueOf(parameter2));
/*    */     }
/* 35 */     if (parameter3 > 0)
/*    */     {
/* 37 */       ps.add(Integer.valueOf(parameter3));
/*    */     }
/*    */     
/* 40 */     OpenInterface.setOpenStatus(moduleid, funid, ps, open == 1);
/*    */     
/* 42 */     rsp.retcode = Retcode.SUCCESS.value;
/* 43 */     Response response = new Response();
/* 44 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 46 */     GameServer.logger().info(String.format("[gmt]SysFunSwitchHandler.execute@sys fun switch done|switch=%d|moduleid=%d|funid=%d|parameter1=%d|parameter2=%d|parameter3=%d", new Object[] { Integer.valueOf(open), Integer.valueOf(moduleid), Integer.valueOf(funid), Integer.valueOf(parameter1), Integer.valueOf(parameter2), Integer.valueOf(parameter3) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\SysFunSwitchHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */