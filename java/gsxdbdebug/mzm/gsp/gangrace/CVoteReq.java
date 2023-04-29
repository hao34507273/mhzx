/*    */ package mzm.gsp.gangrace;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.gangrace.main.PVoteReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CVoteReq
/*    */   extends __CVoteReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12602119;
/*    */   public int playeridx;
/*    */   public int votecount;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PVoteReq(roleid, this.playeridx, this.votecount));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12602119;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CVoteReq() {}
/*    */   
/*    */ 
/*    */   public CVoteReq(int _playeridx_, int _votecount_)
/*    */   {
/* 39 */     this.playeridx = _playeridx_;
/* 40 */     this.votecount = _votecount_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.playeridx);
/* 49 */     _os_.marshal(this.votecount);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.playeridx = _os_.unmarshal_int();
/* 55 */     this.votecount = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CVoteReq)) {
/* 65 */       CVoteReq _o_ = (CVoteReq)_o1_;
/* 66 */       if (this.playeridx != _o_.playeridx) return false;
/* 67 */       if (this.votecount != _o_.votecount) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.playeridx;
/* 76 */     _h_ += this.votecount;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.playeridx).append(",");
/* 84 */     _sb_.append(this.votecount).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CVoteReq _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.playeridx - _o_.playeridx;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.votecount - _o_.votecount;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangrace\CVoteReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */