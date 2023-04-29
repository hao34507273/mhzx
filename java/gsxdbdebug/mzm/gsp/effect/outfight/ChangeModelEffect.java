/*    */ package mzm.gsp.effect.outfight;
/*    */ 
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ import mzm.gsp.effect.outfight.event.EffectInstallModelChange;
/*    */ import mzm.gsp.effect.outfight.event.EffectInstallModelChangeArg;
/*    */ import mzm.gsp.effect.outfight.event.EffectUnstallModelChange;
/*    */ import mzm.gsp.effect.outfight.event.EffectUnstallModelChangeArg;
/*    */ import mzm.gsp.role.main.RoleOneByOneManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChangeModelEffect
/*    */   extends OutFightEffect
/*    */ {
/*    */   private int changeModelId;
/*    */   
/*    */   public boolean attach(IOutFightObject target)
/*    */   {
/* 22 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean detach(IOutFightObject target)
/*    */   {
/* 28 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public ChangeModelEffect(int changeModelId)
/*    */   {
/* 36 */     setChangModelId(changeModelId);
/*    */   }
/*    */   
/*    */   public int getChangModelId()
/*    */   {
/* 41 */     return this.changeModelId;
/*    */   }
/*    */   
/*    */   public void setChangModelId(int changeModelId)
/*    */   {
/* 46 */     this.changeModelId = changeModelId;
/*    */   }
/*    */   
/*    */   public void changeRoleModel(long roleId)
/*    */   {
/* 51 */     TriggerEventsManger.getInstance().triggerEvent(new EffectInstallModelChange(), new EffectInstallModelChangeArg(roleId, getChangModelId()), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void unChangeRoleModel(long roleId)
/*    */   {
/* 58 */     TriggerEventsManger.getInstance().triggerEvent(new EffectUnstallModelChange(), new EffectUnstallModelChangeArg(roleId, getChangModelId()), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\ChangeModelEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */