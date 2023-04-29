/*    */ package mzm.gsp.husong.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.SHuSongRes;
/*    */ import mzm.gsp.activity.confbean.SHuSongCfg;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import xbean.HuSongDataBean;
/*    */ import xtable.Role2husong;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     long roleid = ((Long)this.arg).longValue();
/* 18 */     if ((!OpenInterface.getOpenStatus(5)) || (OpenInterface.isBanPlay(roleid, 5)))
/*    */     {
/*    */ 
/* 21 */       HuSongManager.unsetRoleHuSongStatus(roleid);
/* 22 */       return true;
/*    */     }
/*    */     
/* 25 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/* 26 */     lock(User.getTable(), java.util.Arrays.asList(new String[] { userid }));
/* 27 */     HuSongDataBean xHuSongDataBean = Role2husong.get(Long.valueOf(roleid));
/* 28 */     if (xHuSongDataBean == null)
/*    */     {
/* 30 */       return true;
/*    */     }
/*    */     
/* 33 */     HuSongManager.syncHusongData(userid, roleid, xHuSongDataBean);
/*    */     
/* 35 */     if (!HuSongManager.containsHuSong(roleid))
/*    */     {
/* 37 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 41 */     Integer husongCfgid = (Integer)xHuSongDataBean.getParammap().get(Integer.valueOf(1));
/* 42 */     if (husongCfgid == null)
/*    */     {
/* 44 */       HuSongManager.unsetRoleHuSongStatus(roleid);
/* 45 */       return true;
/*    */     }
/*    */     
/* 48 */     SHuSongCfg huSongCfg = SHuSongCfg.get(husongCfgid.intValue());
/* 49 */     if (huSongCfg == null)
/*    */     {
/* 51 */       HuSongManager.unsetRoleHuSongStatus(roleid);
/* 52 */       return true;
/*    */     }
/*    */     
/* 55 */     int husongCoupleNpcCfgid = HuSongManager.getHusongCoupleNpcCfgidAndSetMapRoleHuSongState(roleid, huSongCfg);
/*    */     
/* 57 */     SHuSongRes huSongRes = new SHuSongRes();
/* 58 */     huSongRes.husongcfgid = husongCfgid.intValue();
/* 59 */     huSongRes.husong_couple_npc_cfgid = husongCoupleNpcCfgid;
/* 60 */     OnlineManager.getInstance().send(roleid, huSongRes);
/*    */     
/* 62 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\husong\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */