/*    */ package mzm.gsp.husong.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.fight.event.PVEFightEndArg;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import xbean.HuSongDataBean;
/*    */ 
/*    */ public class POnPVEFightEnd extends mzm.gsp.fight.event.PVEFightEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     if ((((PVEFightEndArg)this.arg).context instanceof HuSongFightContext))
/*    */     {
/* 14 */       HuSongFightContext huSongFightContext = (HuSongFightContext)((PVEFightEndArg)this.arg).context;
/* 15 */       long roleid = ((Long)((PVEFightEndArg)this.arg).roleList.get(0)).longValue();
/* 16 */       HuSongDataBean xHuSongDataBean = xtable.Role2husong.get(Long.valueOf(roleid));
/* 17 */       if (!HuSongManager.containsHuSong(roleid))
/*    */       {
/* 19 */         return false;
/*    */       }
/* 21 */       Integer fightCount = (Integer)xHuSongDataBean.getParammap().get(Integer.valueOf(4));
/* 22 */       if (fightCount == null)
/*    */       {
/* 24 */         fightCount = Integer.valueOf(0);
/*    */       }
/* 26 */       xHuSongDataBean.getParammap().put(Integer.valueOf(4), fightCount = Integer.valueOf(fightCount.intValue() + 1));
/* 27 */       if (!((PVEFightEndArg)this.arg).isPlayerWin)
/*    */       {
/* 29 */         Integer failTime = (Integer)xHuSongDataBean.getParammap().get(Integer.valueOf(3));
/* 30 */         if (failTime == null)
/*    */         {
/* 32 */           failTime = Integer.valueOf(0);
/*    */         }
/* 34 */         xHuSongDataBean.getParammap().put(Integer.valueOf(3), failTime = Integer.valueOf(failTime.intValue() + 1));
/*    */       }
/* 36 */       if (fightCount.intValue() < mzm.gsp.activity.confbean.SHuSongConst.getInstance().maxFightNum)
/*    */       {
/* 38 */         int sec = HuSongCfgManager.getHusongFightSec();
/* 39 */         HuSongFightSession session = new HuSongFightSession(sec, roleid, huSongFightContext.husongcfgid);
/* 40 */         long sessionid = session.getSessionId();
/* 41 */         int high = CommonUtils.getLongHigh(sessionid);
/* 42 */         int low = CommonUtils.getLongLow(sessionid);
/* 43 */         xHuSongDataBean.getParammap().put(Integer.valueOf(6), Integer.valueOf(high));
/* 44 */         xHuSongDataBean.getParammap().put(Integer.valueOf(5), Integer.valueOf(low));
/*    */       }
/*    */     }
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\husong\main\POnPVEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */