/*    */ package mzm.gsp.gang;
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
/*    */ 
/*    */ public class SAddGangTeamMemberBrd
/*    */   extends __SAddGangTeamMemberBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589992;
/*    */   public long teamid;
/*    */   public GangTeamMember new_member;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12589992;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SAddGangTeamMemberBrd()
/*    */   {
/* 34 */     this.new_member = new GangTeamMember();
/*    */   }
/*    */   
/*    */   public SAddGangTeamMemberBrd(long _teamid_, GangTeamMember _new_member_) {
/* 38 */     this.teamid = _teamid_;
/* 39 */     this.new_member = _new_member_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.new_member._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.teamid);
/* 49 */     _os_.marshal(this.new_member);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.teamid = _os_.unmarshal_long();
/* 55 */     this.new_member.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SAddGangTeamMemberBrd)) {
/* 65 */       SAddGangTeamMemberBrd _o_ = (SAddGangTeamMemberBrd)_o1_;
/* 66 */       if (this.teamid != _o_.teamid) return false;
/* 67 */       if (!this.new_member.equals(_o_.new_member)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.teamid;
/* 76 */     _h_ += this.new_member.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.teamid).append(",");
/* 84 */     _sb_.append(this.new_member).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SAddGangTeamMemberBrd _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = Long.signum(this.teamid - _o_.teamid);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.new_member.compareTo(_o_.new_member);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\SAddGangTeamMemberBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */