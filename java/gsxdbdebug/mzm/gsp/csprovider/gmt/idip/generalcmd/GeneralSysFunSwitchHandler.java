/*    */ package mzm.gsp.csprovider.gmt.idip.generalcmd;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import csprovider.DataBetweenCspAndGame_Re;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.csprovider.gmt.GmtCmdManager;
/*    */ import mzm.gsp.csprovider.gmt.idip.IdipHandler;
/*    */ import mzm.gsp.csprovider.gmt.idip.Response;
/*    */ import mzm.gsp.csprovider.main.Retcode;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class GeneralSysFunSwitchHandler
/*    */   implements IdipHandler
/*    */ {
/*    */   public void execute(List<String> params, DataBetweenCspAndGame_Re rsp)
/*    */     throws Exception
/*    */   {
/* 21 */     int Switch = Integer.valueOf((String)params.get(0)).intValue();
/* 22 */     int moduleID = Integer.valueOf((String)params.get(1)).intValue();
/* 23 */     int FUNID = Integer.valueOf((String)params.get(2)).intValue();
/* 24 */     int parameter1 = Integer.valueOf((String)params.get(3)).intValue();
/* 25 */     int parameter2 = Integer.valueOf((String)params.get(4)).intValue();
/* 26 */     int parameter3 = Integer.valueOf((String)params.get(5)).intValue();
/*    */     
/* 28 */     boolean isOpen = Switch == 1;
/* 29 */     List<Integer> ps = new ArrayList();
/* 30 */     if (parameter1 > 0)
/*    */     {
/* 32 */       ps.add(Integer.valueOf(parameter1));
/*    */     }
/* 34 */     if (parameter2 > 0)
/*    */     {
/* 36 */       ps.add(Integer.valueOf(parameter2));
/*    */     }
/* 38 */     if (parameter3 > 0)
/*    */     {
/* 40 */       ps.add(Integer.valueOf(parameter3));
/*    */     }
/*    */     
/* 43 */     OpenInterface.setOpenStatus(moduleID, FUNID, ps, isOpen);
/*    */     
/* 45 */     rsp.retcode = Retcode.SUCCESS.value;
/* 46 */     Response response = new Response();
/* 47 */     rsp.repdata.setString(response.toString(), GmtCmdManager.ENCODING);
/*    */     
/* 49 */     GameServer.logger().info(String.format("[gmt]GeneralSysFunSwitchHandler.execute@sys_fun_switch done|switch=%d|moduleId=%d|FUNID=%d|parameter1=%d|parameter2=%d|parameter3=%d", new Object[] { Integer.valueOf(Switch), Integer.valueOf(moduleID), Integer.valueOf(FUNID), Integer.valueOf(parameter1), Integer.valueOf(parameter2), Integer.valueOf(parameter3) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\gmt\idip\generalcmd\GeneralSysFunSwitchHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */