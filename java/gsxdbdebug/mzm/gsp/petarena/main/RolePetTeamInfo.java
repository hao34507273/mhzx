/*    */ package mzm.gsp.petarena.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import mzm.gsp.petarena.OpponentInfo;
/*    */ 
/*    */ public class RolePetTeamInfo
/*    */   implements PetTeamInfo
/*    */ {
/*    */   public final long roleid;
/*    */   public final int avatar;
/*    */   public final int avatarFrame;
/*    */   public final String name;
/*    */   public final int level;
/*    */   public final int occupation;
/*    */   public final int gender;
/*    */   public final int score;
/*    */   
/*    */   public RolePetTeamInfo(long roleid, int avatar, int avatarFrame, String name, int level, int occupation, int gender, int score)
/*    */   {
/* 21 */     this.roleid = roleid;
/* 22 */     this.avatar = avatar;
/* 23 */     this.avatarFrame = avatarFrame;
/* 24 */     this.name = name;
/* 25 */     this.level = level;
/* 26 */     this.occupation = occupation;
/* 27 */     this.gender = gender;
/* 28 */     this.score = score;
/*    */   }
/*    */   
/*    */ 
/*    */   public int getScore()
/*    */   {
/* 34 */     return this.score;
/*    */   }
/*    */   
/*    */ 
/*    */   public OpponentInfo getOpponentInfo()
/*    */   {
/* 40 */     OpponentInfo opponentInfo = new OpponentInfo();
/* 41 */     opponentInfo.avatar = this.avatar;
/* 42 */     opponentInfo.avatar_frame = this.avatarFrame;
/* 43 */     opponentInfo.gender = ((byte)this.gender);
/* 44 */     opponentInfo.level = this.level;
/*    */     try
/*    */     {
/* 47 */       opponentInfo.name.setString(this.name, "UTF-8");
/*    */     }
/*    */     catch (UnsupportedEncodingException e) {}
/*    */     
/*    */ 
/* 52 */     opponentInfo.occupation = this.occupation;
/* 53 */     opponentInfo.roleid = this.roleid;
/* 54 */     opponentInfo.score = this.score;
/* 55 */     return opponentInfo;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\RolePetTeamInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */