/*     */ package mzm.gsp.petarena.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.petarena.PetFightInfo;
/*     */ import mzm.gsp.petarena.SGetFightDataSuccess;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PetArenaFightInfo;
/*     */ import xbean.PetArenaFightRecordInfo;
/*     */ 
/*     */ public class PCGetFightData extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long recordid;
/*     */   
/*     */   public PCGetFightData(long roleid, long recordid)
/*     */   {
/*  20 */     this.roleid = roleid;
/*  21 */     this.recordid = recordid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  27 */     if (!PetArenaManager.canDoAction(this.roleid, 2117))
/*     */     {
/*  29 */       return false;
/*     */     }
/*     */     
/*  32 */     if (!PetArenaManager.isFunOpen(this.roleid))
/*     */     {
/*  34 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  38 */     xbean.PetArenaInfo xPetArenaInfo = xtable.Role2petarenainfo.get(Long.valueOf(this.roleid));
/*  39 */     if (xPetArenaInfo == null)
/*     */     {
/*  41 */       GameServer.logger().error(String.format("[petarena]PCGetFightData.processImp@system error|roleid=%d|record=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.recordid) }));
/*     */       
/*     */ 
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     PetArenaFightRecordInfo xTargetArenaFightRecordInfo = null;
/*  48 */     for (PetArenaFightRecordInfo xFightRecordInfo : xPetArenaInfo.getRecords())
/*     */     {
/*  50 */       if (xFightRecordInfo.getRecordid() == this.recordid)
/*     */       {
/*  52 */         xTargetArenaFightRecordInfo = xFightRecordInfo;
/*     */       }
/*     */     }
/*  55 */     if (xTargetArenaFightRecordInfo == null)
/*     */     {
/*  57 */       GameServer.logger().error(String.format("[petarena]PCGetFightData.processImp@record not found|roleid=%d|record=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.recordid) }));
/*     */       
/*     */ 
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     SGetFightDataSuccess rsp = new SGetFightDataSuccess();
/*  64 */     if (xTargetArenaFightRecordInfo.getRecord_type() == 0)
/*     */     {
/*  66 */       rsp.active_name.setString(RoleInterface.getName(this.roleid), "UTF-8");
/*  67 */       rsp.passive_name.setString(xTargetArenaFightRecordInfo.getName(), "UTF-8");
/*     */     }
/*     */     else
/*     */     {
/*  71 */       rsp.active_name.setString(xTargetArenaFightRecordInfo.getName(), "UTF-8");
/*  72 */       rsp.passive_name.setString(RoleInterface.getName(this.roleid), "UTF-8");
/*     */     }
/*  74 */     for (PetArenaFightInfo xPetArenaFightInfo : xTargetArenaFightRecordInfo.getActivie_pet_infos())
/*     */     {
/*  76 */       rsp.active_infos.add(buildFightRecordData(xPetArenaFightInfo));
/*     */     }
/*  78 */     for (PetArenaFightInfo xPetArenaFightInfo : xTargetArenaFightRecordInfo.getPassive_pet_infos())
/*     */     {
/*  80 */       rsp.passive_infos.add(buildFightRecordData(xPetArenaFightInfo));
/*     */     }
/*  82 */     mzm.gsp.online.main.OnlineManager.getInstance().send(this.roleid, rsp);
/*     */     
/*  84 */     GameServer.logger().error(String.format("[petarena]PCGetFightData.processImp@success|roleid=%d|record=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.recordid) }));
/*     */     
/*  86 */     return true;
/*     */   }
/*     */   
/*     */   private PetFightInfo buildFightRecordData(PetArenaFightInfo xPetArenaFightInfo)
/*     */   {
/*  91 */     PetFightInfo data = new PetFightInfo();
/*  92 */     data.damage = xPetArenaFightInfo.getDamage();
/*  93 */     data.monster_cfgid = xPetArenaFightInfo.getMonster_cfgid();
/*     */     try
/*     */     {
/*  96 */       data.name.setString(xPetArenaFightInfo.getName(), "UTF-8");
/*     */     }
/*     */     catch (java.io.UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/* 101 */     data.pet_cfgid = xPetArenaFightInfo.getPet_cfgid();
/* 102 */     data.petid = xPetArenaFightInfo.getPetid();
/* 103 */     data.position = xPetArenaFightInfo.getPosition();
/* 104 */     return data;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\PCGetFightData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */