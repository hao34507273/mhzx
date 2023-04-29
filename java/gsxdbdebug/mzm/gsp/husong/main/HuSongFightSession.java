/*    */ package mzm.gsp.husong.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.confbean.SHuSongCfg;
/*    */ import mzm.gsp.activity.confbean.SHuSongConst;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import xbean.HuSongDataBean;
/*    */ 
/*    */ class HuSongFightSession extends Session
/*    */ {
/*    */   private int husongcfgid;
/*    */   
/*    */   public HuSongFightSession(long interval, long roleId, int husongcfgid)
/*    */   {
/* 18 */     super(interval, roleId);
/* 19 */     this.husongcfgid = husongcfgid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 25 */     xdb.Procedure.execute(new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */ 
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 31 */         long roleid = HuSongFightSession.this.getOwerId();
/* 32 */         if (HuSongManager.containsHuSong(roleid))
/*    */         {
/* 34 */           SHuSongCfg huSongCfg = SHuSongCfg.get(HuSongFightSession.this.husongcfgid);
/*    */           
/* 36 */           HuSongDataBean huSongDataBean = xtable.Role2husong.get(Long.valueOf(roleid));
/* 37 */           if (huSongDataBean == null)
/*    */           {
/* 39 */             return false;
/*    */           }
/* 41 */           Integer fightCount = (Integer)huSongDataBean.getParammap().get(Integer.valueOf(4));
/* 42 */           if (fightCount != null)
/*    */           {
/* 44 */             if (fightCount.intValue() >= SHuSongConst.getInstance().maxFightNum)
/*    */             {
/* 46 */               return false;
/*    */             }
/*    */           }
/* 49 */           Integer high = (Integer)huSongDataBean.getParammap().get(Integer.valueOf(6));
/* 50 */           Integer low = (Integer)huSongDataBean.getParammap().get(Integer.valueOf(5));
/* 51 */           if ((high == null) || (low == null))
/*    */           {
/* 53 */             return false;
/*    */           }
/* 55 */           long sessionid = CommonUtils.getLong(high.intValue(), low.intValue());
/* 56 */           if (sessionid != HuSongFightSession.this.getSessionId())
/*    */           {
/* 58 */             return false;
/*    */           }
/* 60 */           int index = xdb.Xdb.random().nextInt(huSongCfg.fighterids.size());
/* 61 */           int fightid = ((Integer)huSongCfg.fighterids.get(index)).intValue();
/* 62 */           HuSongFightContext fightContext = new HuSongFightContext(HuSongFightSession.this.husongcfgid);
/* 63 */           mzm.gsp.fight.main.FightInterface.startPVEFight(roleid, fightid, fightContext, FightReason.HU_SONG_FIGHT);
/*    */         }
/*    */         else
/*    */         {
/* 67 */           return false;
/*    */         }
/*    */         
/* 70 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\husong\main\HuSongFightSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */