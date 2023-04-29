/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.map.main.scene.Position;
/*    */ import mzm.gsp.marriage.SMarraigeParadePostion;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import xbean.MarriageParade;
/*    */ import xbean.MarriageParades;
/*    */ 
/*    */ public class PCMarriageParadePosition extends mzm.gsp.util.LogicProcedure implements mzm.gsp.map.main.MapCallback<Map<Long, Position>>
/*    */ {
/*    */   private final long reqRoleid;
/*    */   private int paradecfgid;
/*    */   
/*    */   public PCMarriageParadePosition(long roleid)
/*    */   {
/* 20 */     this.reqRoleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 25 */     if ((!OpenInterface.getOpenStatus(128)) || (OpenInterface.isBanPlay(this.reqRoleid, 128)))
/*    */     {
/* 27 */       OpenInterface.sendBanPlayMsg(this.reqRoleid, 128);
/* 28 */       return false;
/*    */     }
/* 30 */     MarriageParades xMarriageParades = xtable.Marriageparade.get(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/* 31 */     if ((xMarriageParades == null) || (xMarriageParades.getMarriageparades().size() <= 0)) {
/* 32 */       sendPostionMsg(0, new Position(-1, -1, 0, 0));
/* 33 */       return true;
/*    */     }
/* 35 */     MarriageParade xMarriageParade = (MarriageParade)xMarriageParades.getMarriageparades().get(0);
/* 36 */     long roleid1 = xMarriageParade.getRoleid1();
/* 37 */     this.paradecfgid = xMarriageParade.getLevel();
/* 38 */     mzm.gsp.map.main.MapInterface.getRolePosition(roleid1, this);
/* 39 */     return true;
/*    */   }
/*    */   
/*    */   private void sendPostionMsg(int paradeCfgid, Position position) {
/* 43 */     SMarraigeParadePostion marraigeParadePostion = new SMarraigeParadePostion();
/* 44 */     marraigeParadePostion.location.x = position.getX();
/* 45 */     marraigeParadePostion.location.y = position.getY();
/* 46 */     marraigeParadePostion.paradecfgid = paradeCfgid;
/* 47 */     OnlineManager.getInstance().send(this.reqRoleid, marraigeParadePostion);
/*    */   }
/*    */   
/*    */   public boolean isCallInProcedure()
/*    */   {
/* 52 */     return true;
/*    */   }
/*    */   
/*    */   public boolean onResult(Map<Long, Position> result)
/*    */   {
/* 57 */     Iterator i$ = result.entrySet().iterator(); if (i$.hasNext()) { Map.Entry<Long, Position> entry = (Map.Entry)i$.next();
/* 58 */       Position position = (Position)entry.getValue();
/* 59 */       sendPostionMsg(this.paradecfgid, position);
/*    */     }
/*    */     
/* 62 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\PCMarriageParadePosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */