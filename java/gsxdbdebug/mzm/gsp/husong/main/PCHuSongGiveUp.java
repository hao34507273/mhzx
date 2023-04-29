/*    */ package mzm.gsp.husong.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.activity.SEndHuSongRes;
/*    */ import mzm.gsp.activity.confbean.SHuSongCfg;
/*    */ import mzm.gsp.husong.event.HuSongArg;
/*    */ import mzm.gsp.husong.event.HuSongEvent;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.HuSongDataBean;
/*    */ 
/*    */ public class PCHuSongGiveUp extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public PCHuSongGiveUp(long roleid)
/*    */   {
/* 18 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     HuSongDataBean xHuSongDataBean = xtable.Role2husong.get(Long.valueOf(this.roleid));
/* 25 */     if (xHuSongDataBean == null)
/*    */     {
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     Integer husongCfgid = (Integer)xHuSongDataBean.getParammap().get(Integer.valueOf(1));
/* 31 */     if (husongCfgid == null)
/*    */     {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     SHuSongCfg huSongCfg = SHuSongCfg.get(husongCfgid.intValue());
/* 37 */     if (huSongCfg == null)
/*    */     {
/* 39 */       return false;
/*    */     }
/* 41 */     xHuSongDataBean.getParammap().clear();
/*    */     
/*    */ 
/* 44 */     HuSongManager.unsetRoleHuSongStatus(this.roleid, huSongCfg.HuSongType);
/*    */     
/* 46 */     SEndHuSongRes endHuSongRes = new SEndHuSongRes();
/* 47 */     endHuSongRes.husongcfgid = huSongCfg.id;
/* 48 */     endHuSongRes.ret = 2;
/* 49 */     OnlineManager.getInstance().send(this.roleid, endHuSongRes);
/*    */     
/* 51 */     HuSongEvent huSongEvent = new HuSongEvent();
/* 52 */     HuSongArg huSongArg = new HuSongArg(this.roleid, false, husongCfgid.intValue());
/* 53 */     TriggerEventsManger.getInstance().triggerEvent(huSongEvent, huSongArg);
/*    */     
/* 55 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\husong\main\PCHuSongGiveUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */