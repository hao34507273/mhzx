/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FurnitureInfo;
/*     */ import xbean.HomeInfo;
/*     */ import xbean.HomeOperate;
/*     */ import xbean.HomeOwners;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2homeinfo;
/*     */ import xtable.Role2properties;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnRoleLogin extends PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  27 */     long roleId = ((Long)this.arg).longValue();
/*     */     
/*  29 */     String userid = RoleInterface.getUserId(roleId);
/*     */     
/*  31 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*     */ 
/*  34 */     long partenerRoleId = MarriageInterface.getMarriedRoleid(roleId);
/*     */     
/*  36 */     boolean ret = true;
/*  37 */     if (partenerRoleId == -1L)
/*     */     {
/*  39 */       Lockeys.lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*  40 */       Lockeys.lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId) }));
/*     */       
/*  42 */       HomeOperate xHomeOperate = HomelandManager.getXHomeOperate(roleId);
/*     */       
/*  44 */       HomelandManager.initHomeOperateCount(roleId, xHomeOperate, now);
/*  45 */       HomelandManager.sendSSynOwnFurnitureRes(roleId, xHomeOperate);
/*     */       
/*  47 */       HomeInfo xHomeInfo = Role2homeinfo.get(Long.valueOf(roleId));
/*     */       
/*  49 */       if (xHomeInfo == null)
/*     */       {
/*  51 */         String logString = String.format("[home]POnRoleLogin.processImp@xHomeInfo is null, no home|roleId=%d", new Object[] { Long.valueOf(roleId) });
/*     */         
/*  53 */         HomelandManager.logger.info(logString);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*  58 */         fixWallPapreAndFloortie(roleId, xHomeInfo, xHomeOperate);
/*  59 */         if (xHomeInfo.getIsmainhome())
/*     */         {
/*     */ 
/*     */ 
/*  63 */           xHomeInfo.setIsmainhome(false);
/*     */           
/*  65 */           List<Integer> furnitureIds = new ArrayList();
/*  66 */           for (FurnitureInfo xFurnitureInfo : xHomeInfo.getPartnerdisplayfurniture().values())
/*     */           {
/*  68 */             furnitureIds.add(Integer.valueOf(xFurnitureInfo.getFurnitureid()));
/*     */           }
/*  70 */           xHomeInfo.getPartnerdisplayfurniture().clear();
/*     */           
/*  72 */           String logString = String.format("[home]POnRoleLogin.processImp@fix role home,set main false|roleId=%d|clearPartnerIds=%s", new Object[] { Long.valueOf(roleId), furnitureIds.toString() });
/*     */           
/*     */ 
/*     */ 
/*  76 */           HomelandManager.logger.warn(logString);
/*     */         }
/*     */         
/*     */ 
/*  80 */         long worldId = HomelandManager.getHomeWorldId(roleId, -1L);
/*  81 */         HomeInfoWrapper homeInfoWrapper = new HomeInfoWrapper(xHomeInfo, worldId, roleId, -1L);
/*  82 */         HomelandManager.cutHomeCleanliness(homeInfoWrapper, now);
/*     */         
/*  84 */         HomelandManager.sendSSynHomelandRes(roleId, true, xHomeInfo, xHomeOperate);
/*     */       }
/*     */       
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  91 */       String partnerUserId = RoleInterface.getUserId(partenerRoleId);
/*  92 */       Lockeys.lock(User.getTable(), Arrays.asList(new String[] { userid, partnerUserId }));
/*  93 */       Lockeys.lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId), Long.valueOf(partenerRoleId) }));
/*     */       
/*  95 */       HomeOperate xMainHomeOperate = HomelandManager.getXHomeOperate(roleId);
/*  96 */       HomeOperate xPartnerHomeOperate = HomelandManager.getXHomeOperate(partenerRoleId);
/*     */       
/*  98 */       HomelandManager.initHomeOperateCount(roleId, xMainHomeOperate, now);
/*  99 */       HomelandManager.initHomeOperateCount(partenerRoleId, xPartnerHomeOperate, now);
/*     */       
/* 101 */       HomeInfo xHomeInfoSelf = Role2homeinfo.get(Long.valueOf(roleId));
/* 102 */       HomeInfo xHomeInfoPartner = Role2homeinfo.get(Long.valueOf(partenerRoleId));
/*     */       
/* 104 */       if ((xHomeInfoSelf == null) && (xHomeInfoPartner == null))
/*     */       {
/* 106 */         String logString = String.format("[home]POnRoleLogin.processImp@xHomeInfo is null, no home|roleId=%d|partenerRoleId=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(partenerRoleId) });
/*     */         
/*     */ 
/*     */ 
/* 110 */         HomelandManager.logger.info(logString);
/*     */         
/* 112 */         ret = false;
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/* 117 */       else if (xHomeInfoSelf == null)
/*     */       {
/* 119 */         long worldId = HomelandManager.getHomeWorldId(partenerRoleId, roleId);
/* 120 */         HomeInfoWrapper homeInfoWrapper = new HomeInfoWrapper(xHomeInfoPartner, worldId, partenerRoleId, roleId);
/* 121 */         HomelandManager.cutHomeCleanliness(homeInfoWrapper, now);
/*     */         
/* 123 */         if (!xHomeInfoPartner.getIsmainhome())
/*     */         {
/*     */ 
/* 126 */           fixData(xHomeInfoPartner, xPartnerHomeOperate, null, xMainHomeOperate);
/*     */           
/* 128 */           HomelandManager.sendSSynOwnFurnitureRes(partenerRoleId, xPartnerHomeOperate);
/* 129 */           HomelandManager.sendSSynHomelandRes(partenerRoleId, true, xHomeInfoPartner, xPartnerHomeOperate);
/*     */           
/* 131 */           String logString = String.format("[home]POnRoleLogin.processImp@fix role home,set partner role home to main true|roleId=%d|partenerRoleId=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(partenerRoleId) });
/*     */           
/*     */ 
/*     */ 
/* 135 */           HomelandManager.logger.warn(logString);
/*     */         }
/*     */         
/*     */ 
/* 139 */         fixWallPapreAndFloortie(partenerRoleId, xHomeInfoPartner, xPartnerHomeOperate);
/* 140 */         HomelandManager.sendSSynOwnFurnitureRes(roleId, xMainHomeOperate);
/* 141 */         HomelandManager.sendSSynHomelandRes(roleId, false, xHomeInfoPartner, xMainHomeOperate);
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/* 146 */       else if (xHomeInfoSelf.getIsmainhome())
/*     */       {
/* 148 */         fixWallPapreAndFloortie(roleId, xHomeInfoSelf, xMainHomeOperate);
/* 149 */         long worldId = HomelandManager.getHomeWorldId(roleId, partenerRoleId);
/* 150 */         HomeInfoWrapper homeInfoWrapper = new HomeInfoWrapper(xHomeInfoSelf, worldId, roleId, partenerRoleId);
/* 151 */         HomelandManager.cutHomeCleanliness(homeInfoWrapper, now);
/* 152 */         HomelandManager.sendSSynOwnFurnitureRes(roleId, xMainHomeOperate);
/* 153 */         HomelandManager.sendSSynHomelandRes(roleId, true, xHomeInfoSelf, xMainHomeOperate);
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/* 158 */       else if (xHomeInfoPartner == null)
/*     */       {
/* 160 */         fixWallPapreAndFloortie(roleId, xHomeInfoSelf, xMainHomeOperate);
/* 161 */         repairRoleData(xHomeInfoSelf, xMainHomeOperate, roleId, null, xPartnerHomeOperate, partenerRoleId, now);
/*     */         
/* 163 */         String logString = String.format("[home]POnRoleLogin.processImp@fix role home,set self role home to main true at line 168|roleId=%d|partenerRoleId=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(partenerRoleId) });
/*     */         
/*     */ 
/*     */ 
/* 167 */         HomelandManager.logger.warn(logString);
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/* 172 */       else if (xHomeInfoPartner.getIsmainhome())
/*     */       {
/* 174 */         fixWallPapreAndFloortie(partenerRoleId, xHomeInfoPartner, xPartnerHomeOperate);
/* 175 */         long worldId = HomelandManager.getHomeWorldId(partenerRoleId, roleId);
/* 176 */         HomeInfoWrapper homeInfoWrapper = new HomeInfoWrapper(xHomeInfoPartner, worldId, partenerRoleId, roleId);
/*     */         
/*     */ 
/* 179 */         HomelandManager.cutHomeCleanliness(homeInfoWrapper, now);
/* 180 */         HomelandManager.sendSSynOwnFurnitureRes(roleId, xMainHomeOperate);
/* 181 */         HomelandManager.sendSSynHomelandRes(roleId, false, xHomeInfoPartner, xMainHomeOperate);
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/* 186 */       else if (xHomeInfoPartner.getHomelevel() == xHomeInfoSelf.getHomelevel())
/*     */       {
/* 188 */         if (RoleInterface.getGender(roleId) == 1)
/*     */         {
/*     */ 
/* 191 */           repairRoleData(xHomeInfoSelf, xMainHomeOperate, roleId, xHomeInfoPartner, xPartnerHomeOperate, partenerRoleId, now);
/*     */           
/*     */ 
/* 194 */           String logString = String.format("[home]POnRoleLogin.processImp@fix role home,set self role home to main true at line 194|roleId=%d|partenerRoleId=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(partenerRoleId) });
/*     */           
/*     */ 
/*     */ 
/* 198 */           HomelandManager.logger.warn(logString);
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 203 */           repairRoleData(xHomeInfoPartner, xPartnerHomeOperate, partenerRoleId, xHomeInfoSelf, xMainHomeOperate, roleId, now);
/*     */           
/* 205 */           String logString = String.format("[home]PPOnRoleLogin.processImp@fix role home,set partner role home to main true at line 206|roleId=%d|partenerRoleId=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(partenerRoleId) });
/*     */           
/*     */ 
/*     */ 
/* 209 */           HomelandManager.logger.warn(logString);
/*     */         }
/*     */         
/*     */ 
/*     */       }
/* 214 */       else if (xHomeInfoPartner.getHomelevel() > xHomeInfoSelf.getHomelevel())
/*     */       {
/*     */ 
/* 217 */         repairRoleData(xHomeInfoPartner, xPartnerHomeOperate, partenerRoleId, xHomeInfoSelf, xMainHomeOperate, roleId, now);
/*     */         
/*     */ 
/* 220 */         String logString = String.format("[home]POnRoleLogin.processImp@fix role home,set partner role home to main true at line 220|roleId=%d|partenerRoleId=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(partenerRoleId) });
/*     */         
/*     */ 
/*     */ 
/* 224 */         HomelandManager.logger.warn(logString);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 229 */         repairRoleData(xHomeInfoSelf, xMainHomeOperate, roleId, xHomeInfoPartner, xPartnerHomeOperate, partenerRoleId, now);
/*     */         
/* 231 */         String logString = String.format("[home]POnRoleLogin.processImp@fix role home,set self role home to main true at line 231|roleId=%d|partenerRoleId=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(partenerRoleId) });
/*     */         
/*     */ 
/*     */ 
/* 235 */         HomelandManager.logger.warn(logString);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 246 */     new CheckHomeStatePro(roleId).execute();
/* 247 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void fixData(HomeInfo xMain, HomeOperate xMainFurnitures, HomeInfo xVice, HomeOperate xViceFurnitures)
/*     */   {
/* 257 */     xMain.setIsmainhome(true);
/*     */     
/* 259 */     HomelandManager.moveAllFurnitureFromHome2Bag(xMain, true, xMainFurnitures, false);
/* 260 */     HomelandManager.moveAllFurnitureFromHome2Bag(xMain, false, xViceFurnitures, false);
/*     */     
/* 262 */     HomelandManager.computeFurnitureFengShui(xMain);
/* 263 */     CourtYardManager.computeFurnitureBeautiful(xMain);
/* 264 */     if (xVice != null)
/*     */     {
/* 266 */       xVice.setIsmainhome(false);
/* 267 */       xVice.getPartnerdisplayfurniture().clear();
/* 268 */       HomelandManager.moveAllFurnitureFromHome2Bag(xVice, true, xViceFurnitures, false);
/*     */       
/* 270 */       HomelandManager.computeFurnitureFengShui(xVice);
/* 271 */       CourtYardManager.computeFurnitureBeautiful(xVice);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void repairRoleData(HomeInfo xMain, HomeOperate xMainFurnitures, long mainRoleId, HomeInfo xVice, HomeOperate xViceFurnitures, long viceRoleId, long now)
/*     */     throws java.io.UnsupportedEncodingException
/*     */   {
/* 281 */     fixWallPapreAndFloortie(mainRoleId, xMain, xMainFurnitures);
/* 282 */     fixData(xMain, xMainFurnitures, xVice, xViceFurnitures);
/*     */     
/* 284 */     long worldId = HomelandManager.getHomeWorldId(mainRoleId, viceRoleId);
/* 285 */     HomeInfoWrapper homeInfoWrapper = new HomeInfoWrapper(xMain, worldId, mainRoleId, viceRoleId);
/*     */     
/* 287 */     HomelandManager.cutHomeCleanliness(homeInfoWrapper, now);
/*     */     
/* 289 */     HomelandManager.sendSSynOwnFurnitureRes(mainRoleId, xMainFurnitures);
/* 290 */     HomelandManager.sendSSynHomelandRes(mainRoleId, true, xMain, xMainFurnitures);
/*     */     
/* 292 */     HomelandManager.sendSSynOwnFurnitureRes(viceRoleId, xViceFurnitures);
/* 293 */     HomelandManager.sendSSynHomelandRes(viceRoleId, false, xMain, xViceFurnitures);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void fixWallPapreAndFloortie(long roleId, HomeInfo xHomeInfo, HomeOperate xHomeOperate)
/*     */   {
/* 301 */     HomelandManager.initWallPaperAndFloortie(roleId, xHomeInfo, xHomeOperate);
/*     */   }
/*     */   
/*     */   private static class CheckHomeStatePro extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     
/*     */     public CheckHomeStatePro(long roleId)
/*     */     {
/* 310 */       this.roleId = roleId;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 318 */       long roleInWorld = MapInterface.getRoleWorldInstanceId(this.roleId);
/* 319 */       long globalWorldId = mzm.gsp.GameServerInfoManager.toGlobalId(roleInWorld);
/*     */       
/* 321 */       HomeOwners xHomeOwners = xtable.Homeworld2roles.select(Long.valueOf(globalWorldId));
/* 322 */       if (xHomeOwners == null)
/*     */       {
/* 324 */         RoleStatusInterface.unsetStatus(this.roleId, 34);
/*     */       }
/*     */       else
/*     */       {
/* 328 */         long homeCreatorRole = xHomeOwners.getCreatorroleid();
/* 329 */         HomeInfoWrapper homeInfoWrapper = HomelandManager.selectHomeInfoWrapper(homeCreatorRole);
/* 330 */         if (homeInfoWrapper != null)
/*     */         {
/* 332 */           HomelandManager.sendSInHomeRes(this.roleId);
/* 333 */           RoleStatusInterface.setStatus(this.roleId, 34, false);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 339 */       Integer state = xtable.Role2homeoperate.selectHomestate(Long.valueOf(this.roleId));
/* 340 */       if ((state != null) && (state.intValue() == 2))
/*     */       {
/* 342 */         HomeInfo xHomeInfo = Role2homeinfo.select(Long.valueOf(this.roleId));
/* 343 */         HomelandRankManager.getInstance().rank(new RoleHomelandChart(this.roleId, HomelandManager.getHomelandPoint(xHomeInfo)));
/*     */       }
/*     */       
/*     */ 
/* 347 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */