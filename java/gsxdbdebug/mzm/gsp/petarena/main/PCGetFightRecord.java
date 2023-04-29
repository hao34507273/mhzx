/*    */ package mzm.gsp.petarena.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.petarena.FightRecordData;
/*    */ import mzm.gsp.petarena.SGetFightRecordSuccess;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.PetArenaFightRecordInfo;
/*    */ import xbean.PetArenaInfo;
/*    */ import xdb.Lockeys;
/*    */ 
/*    */ public class PCGetFightRecord extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCGetFightRecord(long roleid)
/*    */   {
/* 21 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     if (!PetArenaManager.canDoAction(this.roleid, 2117))
/*    */     {
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     if (!PetArenaManager.isFunOpen(this.roleid))
/*    */     {
/* 34 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 38 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/* 39 */     lock(Lockeys.get(xtable.User.getTable(), userid));
/* 40 */     lock(Lockeys.get(xtable.Basic.getTable(), Long.valueOf(this.roleid)));
/*    */     
/* 42 */     PetArenaInfo xPetArenaInfo = xtable.Role2petarenainfo.get(Long.valueOf(this.roleid));
/* 43 */     if (xPetArenaInfo == null)
/*    */     {
/* 45 */       GameServer.logger().error(String.format("[petarena]PCGetFightRecord.processImp@xbean is null|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/* 47 */       return false;
/*    */     }
/*    */     
/* 50 */     SGetFightRecordSuccess rsp = new SGetFightRecordSuccess();
/* 51 */     for (PetArenaFightRecordInfo xFightRecordInfo : xPetArenaInfo.getRecords())
/*    */     {
/* 53 */       rsp.records.add(buildFightRecordData(xFightRecordInfo));
/*    */     }
/* 55 */     OnlineManager.getInstance().send(this.roleid, rsp);
/*    */     
/* 57 */     GameServer.logger().info(String.format("[petarena]PCGetFightRecord.processImp@get success|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/* 58 */     return true;
/*    */   }
/*    */   
/*    */   private FightRecordData buildFightRecordData(PetArenaFightRecordInfo xFightRecordInfo)
/*    */   {
/* 63 */     FightRecordData data = new FightRecordData();
/* 64 */     long roleid = xFightRecordInfo.getRoleid();
/* 65 */     data.roleid = roleid;
/* 66 */     data.fight_time = ((int)TimeUnit.MILLISECONDS.toSeconds(xFightRecordInfo.getTime()));
/*    */     
/* 68 */     data.recordid = xFightRecordInfo.getRecordid();
/* 69 */     data.is_win = xFightRecordInfo.getIs_win();
/* 70 */     data.new_rank = xFightRecordInfo.getNew_rank();
/* 71 */     data.old_rank = xFightRecordInfo.getOld_rank();
/* 72 */     data.record_type = xFightRecordInfo.getRecord_type();
/*    */     
/* 74 */     if (roleid > 0L)
/*    */     {
/* 76 */       data.avatar = xFightRecordInfo.getAvatar();
/* 77 */       data.avatar_frame = xFightRecordInfo.getAvatar_frame();
/*    */       try
/*    */       {
/* 80 */         data.name.setString(xFightRecordInfo.getName(), "UTF-8");
/*    */       }
/*    */       catch (UnsupportedEncodingException e) {}
/*    */       
/*    */ 
/* 85 */       data.gender = ((byte)xFightRecordInfo.getGender());
/* 86 */       data.occupation = xFightRecordInfo.getOccupation();
/*    */     }
/* 88 */     return data;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\PCGetFightRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */