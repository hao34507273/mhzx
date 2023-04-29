/*    */ package mzm.gsp.couple;
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
/*    */ public class SReceiveRideInviteRes
/*    */   extends __SReceiveRideInviteRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600578;
/*    */   public long sessionid;
/*    */   public long inviteroleid;
/*    */   public String inviterolename;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12600578;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SReceiveRideInviteRes()
/*    */   {
/* 35 */     this.inviterolename = "";
/*    */   }
/*    */   
/*    */   public SReceiveRideInviteRes(long _sessionid_, long _inviteroleid_, String _inviterolename_) {
/* 39 */     this.sessionid = _sessionid_;
/* 40 */     this.inviteroleid = _inviteroleid_;
/* 41 */     this.inviterolename = _inviterolename_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.sessionid);
/* 50 */     _os_.marshal(this.inviteroleid);
/* 51 */     _os_.marshal(this.inviterolename, "UTF-16LE");
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.sessionid = _os_.unmarshal_long();
/* 57 */     this.inviteroleid = _os_.unmarshal_long();
/* 58 */     this.inviterolename = _os_.unmarshal_String("UTF-16LE");
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SReceiveRideInviteRes)) {
/* 68 */       SReceiveRideInviteRes _o_ = (SReceiveRideInviteRes)_o1_;
/* 69 */       if (this.sessionid != _o_.sessionid) return false;
/* 70 */       if (this.inviteroleid != _o_.inviteroleid) return false;
/* 71 */       if (!this.inviterolename.equals(_o_.inviterolename)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += (int)this.sessionid;
/* 80 */     _h_ += (int)this.inviteroleid;
/* 81 */     _h_ += this.inviterolename.hashCode();
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(this.sessionid).append(",");
/* 89 */     _sb_.append(this.inviteroleid).append(",");
/* 90 */     _sb_.append("T").append(this.inviterolename.length()).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\couple\SReceiveRideInviteRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */