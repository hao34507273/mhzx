/*    */ package mzm.gsp.gang;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.gang.main.PJoinGangReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CJoinGangReq
/*    */   extends __CJoinGangReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589872;
/*    */   public static final int NO_INVITER = -1;
/*    */   public long inviterid;
/*    */   public long gangid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 22 */     new PJoinGangReq(this);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 30 */     return 12589872;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public CJoinGangReq() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public CJoinGangReq(long _inviterid_, long _gangid_)
/*    */   {
/* 42 */     this.inviterid = _inviterid_;
/* 43 */     this.gangid = _gangid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.inviterid);
/* 52 */     _os_.marshal(this.gangid);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.inviterid = _os_.unmarshal_long();
/* 58 */     this.gangid = _os_.unmarshal_long();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CJoinGangReq)) {
/* 68 */       CJoinGangReq _o_ = (CJoinGangReq)_o1_;
/* 69 */       if (this.inviterid != _o_.inviterid) return false;
/* 70 */       if (this.gangid != _o_.gangid) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += (int)this.inviterid;
/* 79 */     _h_ += (int)this.gangid;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.inviterid).append(",");
/* 87 */     _sb_.append(this.gangid).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CJoinGangReq _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = Long.signum(this.inviterid - _o_.inviterid);
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = Long.signum(this.gangid - _o_.gangid);
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\CJoinGangReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */