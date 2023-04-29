/*    */ package mzm.gsp.petarena;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SGetDefendPetTeamSuccess
/*    */   extends __SGetDefendPetTeamSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12628242;
/*    */   public long target_roleid;
/*    */   public int rank;
/*    */   public PetArenaTeamInfo team_info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12628242;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetDefendPetTeamSuccess()
/*    */   {
/* 35 */     this.team_info = new PetArenaTeamInfo();
/*    */   }
/*    */   
/*    */   public SGetDefendPetTeamSuccess(long _target_roleid_, int _rank_, PetArenaTeamInfo _team_info_) {
/* 39 */     this.target_roleid = _target_roleid_;
/* 40 */     this.rank = _rank_;
/* 41 */     this.team_info = _team_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     if (!this.team_info._validator_()) return false;
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.target_roleid);
/* 51 */     _os_.marshal(this.rank);
/* 52 */     _os_.marshal(this.team_info);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.target_roleid = _os_.unmarshal_long();
/* 58 */     this.rank = _os_.unmarshal_int();
/* 59 */     this.team_info.unmarshal(_os_);
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SGetDefendPetTeamSuccess)) {
/* 69 */       SGetDefendPetTeamSuccess _o_ = (SGetDefendPetTeamSuccess)_o1_;
/* 70 */       if (this.target_roleid != _o_.target_roleid) return false;
/* 71 */       if (this.rank != _o_.rank) return false;
/* 72 */       if (!this.team_info.equals(_o_.team_info)) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += (int)this.target_roleid;
/* 81 */     _h_ += this.rank;
/* 82 */     _h_ += this.team_info.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.target_roleid).append(",");
/* 90 */     _sb_.append(this.rank).append(",");
/* 91 */     _sb_.append(this.team_info).append(",");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\SGetDefendPetTeamSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */