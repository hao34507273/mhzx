/*    */ package mzm.gsp.festival.main;
/*    */ 
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ 
/*    */ public class PGM_SetFestival extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private int awardFestivalid;
/*    */   private long roleid;
/*    */   
/*    */   public PGM_SetFestival(long roleid, int awardFestivalid)
/*    */   {
/* 13 */     this.roleid = roleid;
/* 14 */     this.awardFestivalid = awardFestivalid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     boolean ret = FestivalManager.pgm_startFestivalAwardCfg(this.awardFestivalid);
/* 20 */     SGMMessageTipRes gmMessageTipRes = new SGMMessageTipRes();
/* 21 */     if (!ret) {
/* 22 */       gmMessageTipRes.result = Integer.MAX_VALUE;
/* 23 */       gmMessageTipRes.args.add(String.format("传递的参数错误,不存在的配置id=%d", new Object[] { Integer.valueOf(this.awardFestivalid) }));
/*    */     } else {
/* 25 */       gmMessageTipRes.result = Integer.MAX_VALUE;
/* 26 */       gmMessageTipRes.args.add(String.format("设置成功", new Object[0]));
/*    */     }
/* 28 */     OnlineManager.getInstance().sendAtOnce(this.roleid, gmMessageTipRes);
/* 29 */     return ret;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\festival\main\PGM_SetFestival.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */