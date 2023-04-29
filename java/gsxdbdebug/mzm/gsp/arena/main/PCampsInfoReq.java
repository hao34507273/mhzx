/*    */ package mzm.gsp.arena.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.arena.SCampsInfoRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Arena;
/*    */ 
/*    */ 
/*    */ public class PCampsInfoReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCampsInfoReq(long roleid)
/*    */   {
/* 19 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 24 */     SCampsInfoRes res = new SCampsInfoRes();
/* 25 */     Arena xArena = ArenaManager.getXArenaIfNotExist();
/* 26 */     for (Map.Entry<Integer, xbean.Camp> entry : xArena.getCamps().entrySet()) {
/* 27 */       int camp = ((Integer)entry.getKey()).intValue();
/* 28 */       xbean.Camp xCamp = (xbean.Camp)entry.getValue();
/* 29 */       mzm.gsp.arena.Camp campBean = ArenaManager.getCampBean(xCamp, camp);
/* 30 */       res.camps.add(campBean);
/*    */     }
/*    */     
/* 33 */     OnlineManager.getInstance().send(this.roleid, res);
/*    */     
/* 35 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\PCampsInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */