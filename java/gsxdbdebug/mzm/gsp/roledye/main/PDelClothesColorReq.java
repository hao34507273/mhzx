/*    */ package mzm.gsp.roledye.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.npc.main.NpcInterface;
/*    */ import mzm.gsp.occupation.confbean.RoleDyeConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.roledye.SDelClothesColorRes;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.ClothColor;
/*    */ import xbean.RoleClothes;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PDelClothesColorReq extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int colorid;
/*    */   
/*    */   public PDelClothesColorReq(long roleid, int id)
/*    */   {
/* 26 */     this.roleid = roleid;
/* 27 */     this.colorid = id;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 33 */     if (!NpcInterface.checkNpcServiceIgnoreNpcLocationCond(RoleDyeConsts.getInstance().roleDyeNpcId, RoleDyeConsts.getInstance().roleDyeNpcServiceId, this.roleid))
/*    */     {
/*    */ 
/* 36 */       GameServer.logger().error(String.format("[roledye]PDelClothesColorReq.processImp@npc service is not useable|npc_id=%d|service_id=%d|role_id=%d", new Object[] { Integer.valueOf(RoleDyeConsts.getInstance().roleDyeNpcId), Integer.valueOf(RoleDyeConsts.getInstance().roleDyeNpcServiceId), Long.valueOf(this.roleid) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     if (!RoleDyeManager.isRoleDyeSwitchOpen(this.roleid, "PDelClothesColorReq.processImp"))
/*    */     {
/* 46 */       return false;
/*    */     }
/*    */     
/* 49 */     String userId = RoleInterface.getUserId(this.roleid);
/* 50 */     lock(Lockeys.get(User.getTable(), userId));
/*    */     
/* 52 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 992, true, true))
/*    */     {
/* 54 */       return false;
/*    */     }
/*    */     
/* 57 */     RoleClothes xroleCothes = RoleDyeManager.getXRoleClothesIfNotExist(this.roleid);
/* 58 */     List<ClothColor> xclothColors = xroleCothes.getClothes();
/*    */     
/* 60 */     if (this.colorid == xroleCothes.getDefid())
/*    */     {
/*    */ 
/* 63 */       RoleDyeManager.sendRoleDyeResult(this.roleid, 2);
/* 64 */       return false;
/*    */     }
/*    */     
/* 67 */     if (this.colorid == xroleCothes.getCurid())
/*    */     {
/*    */ 
/* 70 */       RoleDyeManager.sendRoleDyeResult(this.roleid, 3);
/* 71 */       return false;
/*    */     }
/*    */     
/* 74 */     for (Iterator<ClothColor> it = xclothColors.iterator(); it.hasNext();)
/*    */     {
/* 76 */       ClothColor xColor = (ClothColor)it.next();
/* 77 */       if (xColor.getId() == this.colorid)
/*    */       {
/* 79 */         it.remove();
/* 80 */         OnlineManager.getInstance().send(this.roleid, new SDelClothesColorRes(this.colorid));
/* 81 */         RoleDyeManager.tlogRoleDyeOperator(userId, this.roleid, xColor.getFashion_dress_cfg_id(), xColor.getHair(), xColor.getCloth(), RoleDyeTlogEnum.ADD);
/*    */         
/* 83 */         return true;
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 88 */     RoleDyeManager.sendRoleDyeResult(this.roleid, 1);
/*    */     
/* 90 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\roledye\main\PDelClothesColorReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */