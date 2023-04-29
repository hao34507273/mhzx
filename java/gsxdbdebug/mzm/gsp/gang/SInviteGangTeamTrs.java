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
/*    */ public class SInviteGangTeamTrs
/*    */   extends __SInviteGangTeamTrs__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589995;
/*    */   public long inviter_id;
/*    */   public long gang_teamid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12589995;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SInviteGangTeamTrs() {}
/*    */   
/*    */ 
/*    */   public SInviteGangTeamTrs(long _inviter_id_, long _gang_teamid_)
/*    */   {
/* 37 */     this.inviter_id = _inviter_id_;
/* 38 */     this.gang_teamid = _gang_teamid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.inviter_id);
/* 47 */     _os_.marshal(this.gang_teamid);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.inviter_id = _os_.unmarshal_long();
/* 53 */     this.gang_teamid = _os_.unmarshal_long();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SInviteGangTeamTrs)) {
/* 63 */       SInviteGangTeamTrs _o_ = (SInviteGangTeamTrs)_o1_;
/* 64 */       if (this.inviter_id != _o_.inviter_id) return false;
/* 65 */       if (this.gang_teamid != _o_.gang_teamid) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.inviter_id;
/* 74 */     _h_ += (int)this.gang_teamid;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.inviter_id).append(",");
/* 82 */     _sb_.append(this.gang_teamid).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SInviteGangTeamTrs _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.inviter_id - _o_.inviter_id);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = Long.signum(this.gang_teamid - _o_.gang_teamid);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\SInviteGangTeamTrs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */