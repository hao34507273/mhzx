/*    */ package mzm.gsp.husong.main;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.SHuSongCfg;
/*    */ import mzm.gsp.map.event.ArraivedAtNPCArg;
/*    */ import mzm.gsp.map.event.ArraivedAtNPCProcedure;
/*    */ import xbean.HuSongDataBean;
/*    */ import xtable.Role2husong;
/*    */ 
/*    */ public class POnArraivedAtNPC extends ArraivedAtNPCProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     long roleid = ((ArraivedAtNPCArg)this.arg).roleId;
/* 14 */     int npcid = ((ArraivedAtNPCArg)this.arg).npcId;
/* 15 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/* 16 */     lock(xtable.User.getTable(), java.util.Arrays.asList(new String[] { userid }));
/* 17 */     if (HuSongManager.containsHuSong(roleid))
/*    */     {
/*    */ 
/* 20 */       HuSongDataBean xHuSongDataBean = Role2husong.get(Long.valueOf(roleid));
/* 21 */       int husongCfgid = ((Integer)xHuSongDataBean.getParammap().get(Integer.valueOf(1))).intValue();
/* 22 */       SHuSongCfg huSongCfg = SHuSongCfg.get(husongCfgid);
/* 23 */       if (huSongCfg.handupNPCid != npcid)
/*    */       {
/* 25 */         return false;
/*    */       }
/* 27 */       HuSongManager.finishHusong(userid, roleid, xHuSongDataBean, huSongCfg);
/*    */     }
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\husong\main\POnArraivedAtNPC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */