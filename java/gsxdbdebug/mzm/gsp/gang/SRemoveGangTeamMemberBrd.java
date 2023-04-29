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
/*    */ public class SRemoveGangTeamMemberBrd
/*    */   extends __SRemoveGangTeamMemberBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590008;
/*    */   public long teamid;
/*    */   public long memberid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590008;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SRemoveGangTeamMemberBrd() {}
/*    */   
/*    */ 
/*    */   public SRemoveGangTeamMemberBrd(long _teamid_, long _memberid_)
/*    */   {
/* 37 */     this.teamid = _teamid_;
/* 38 */     this.memberid = _memberid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.teamid);
/* 47 */     _os_.marshal(this.memberid);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.teamid = _os_.unmarshal_long();
/* 53 */     this.memberid = _os_.unmarshal_long();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SRemoveGangTeamMemberBrd)) {
/* 63 */       SRemoveGangTeamMemberBrd _o_ = (SRemoveGangTeamMemberBrd)_o1_;
/* 64 */       if (this.teamid != _o_.teamid) return false;
/* 65 */       if (this.memberid != _o_.memberid) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.teamid;
/* 74 */     _h_ += (int)this.memberid;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.teamid).append(",");
/* 82 */     _sb_.append(this.memberid).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SRemoveGangTeamMemberBrd _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.teamid - _o_.teamid);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = Long.signum(this.memberid - _o_.memberid);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\SRemoveGangTeamMemberBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */