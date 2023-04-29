/*    */ package mzm.gsp.guaji.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.guaji.SChangeSwitchSuccess;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.DoublePoint;
/*    */ 
/*    */ public class PCChangeSwitch extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int type;
/*    */   private final byte open;
/*    */   
/*    */   public PCChangeSwitch(long roleid, int type, byte open)
/*    */   {
/* 17 */     this.roleid = roleid;
/* 18 */     this.type = type;
/* 19 */     this.open = open;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     if (!GuajiManager.isDoublePointSwitchFunOpen(this.roleid))
/*    */     {
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     if ((this.type != 1) && (this.type != 2))
/*    */     {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     if ((this.open != 0) && (this.open != 1))
/*    */     {
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     DoublePoint xDoublePoint = xtable.Role2doublepoint.get(Long.valueOf(this.roleid));
/* 41 */     if (xDoublePoint == null)
/*    */     {
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     if (this.open == 1)
/*    */     {
/* 48 */       xDoublePoint.getSwitches().remove(Integer.valueOf(this.type));
/*    */     }
/*    */     else
/*    */     {
/* 52 */       xDoublePoint.getSwitches().add(Integer.valueOf(this.type));
/*    */     }
/*    */     
/* 55 */     SChangeSwitchSuccess resp = new SChangeSwitchSuccess();
/* 56 */     resp.open = this.open;
/* 57 */     resp.switch_type = this.type;
/* 58 */     OnlineManager.getInstance().send(this.roleid, resp);
/*    */     
/* 60 */     GameServer.logger().info(String.format("[guaji]PCChangeSwitch.processImp@change switch success|roleid=%d|type=%d|open=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.type), Byte.valueOf(this.open) }));
/*    */     
/*    */ 
/*    */ 
/* 64 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guaji\main\PCChangeSwitch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */