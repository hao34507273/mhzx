/*    */ package mzm.gsp.effect.outfight;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AddMoveSpeedEffect
/*    */   extends OutFightEffect
/*    */ {
/*    */   private final int addRate;
/*    */   
/*    */   public boolean attach(IOutFightObject target)
/*    */   {
/* 18 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean detach(IOutFightObject target)
/*    */   {
/* 24 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public AddMoveSpeedEffect(int addRate)
/*    */   {
/* 31 */     this.addRate = addRate;
/*    */   }
/*    */   
/*    */   public void addMoveSpeed(long roleid)
/*    */   {
/* 36 */     MapInterface.addRoleSpeedPercentAdded(roleid, this.addRate, null);
/* 37 */     GameServer.logger().info(String.format("[effect]AddMoveSpeedEffect.addMoveSpeed@add move speed|roleid=%d|rate=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(this.addRate) }));
/*    */   }
/*    */   
/*    */ 
/*    */   public void reduceMoveSpeed(long roleid)
/*    */   {
/* 43 */     MapInterface.addRoleSpeedPercentAdded(roleid, -this.addRate, null);
/* 44 */     GameServer.logger().info(String.format("[effect]AddMoveSpeedEffect.reduceMoveSpeed@reduce move speed|roleid=%d|rate=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(this.addRate) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\AddMoveSpeedEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */