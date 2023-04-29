/*    */ package mzm.gsp.gang;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.gang.main.PInviteJoinGangReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CInviteJoinGangReq
/*    */   extends __CInviteJoinGangReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589841;
/*    */   public long targetid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     new PInviteJoinGangReq(this);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12589841;
/*    */   }
/*    */   
/*    */ 
/*    */   public CInviteJoinGangReq() {}
/*    */   
/*    */ 
/*    */   public CInviteJoinGangReq(long _targetid_)
/*    */   {
/* 37 */     this.targetid = _targetid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.marshal(this.targetid);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.targetid = _os_.unmarshal_long();
/* 51 */     if (!_validator_()) {
/* 52 */       throw new VerifyError("validator failed");
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 58 */     if (_o1_ == this) return true;
/* 59 */     if ((_o1_ instanceof CInviteJoinGangReq)) {
/* 60 */       CInviteJoinGangReq _o_ = (CInviteJoinGangReq)_o1_;
/* 61 */       if (this.targetid != _o_.targetid) return false;
/* 62 */       return true;
/*    */     }
/* 64 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 68 */     int _h_ = 0;
/* 69 */     _h_ += (int)this.targetid;
/* 70 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 74 */     StringBuilder _sb_ = new StringBuilder();
/* 75 */     _sb_.append("(");
/* 76 */     _sb_.append(this.targetid).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CInviteJoinGangReq _o_) {
/* 82 */     if (_o_ == this) return 0;
/* 83 */     int _c_ = 0;
/* 84 */     _c_ = Long.signum(this.targetid - _o_.targetid);
/* 85 */     if (0 != _c_) return _c_;
/* 86 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\CInviteJoinGangReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */