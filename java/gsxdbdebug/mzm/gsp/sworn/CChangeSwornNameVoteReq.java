/*    */ package mzm.gsp.sworn;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.sworn.main.PChangeSwornNameVoteReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CChangeSwornNameVoteReq
/*    */   extends __CChangeSwornNameVoteReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12597797;
/*    */   public static final int VOTE_AGREE = 1;
/*    */   public static final int VOTE_NOTAGREE = 2;
/*    */   public int votevalue;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PChangeSwornNameVoteReq(roleid, this.votevalue));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12597797;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public CChangeSwornNameVoteReq() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public CChangeSwornNameVoteReq(int _votevalue_)
/*    */   {
/* 41 */     this.votevalue = _votevalue_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.votevalue);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.votevalue = _os_.unmarshal_int();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof CChangeSwornNameVoteReq)) {
/* 64 */       CChangeSwornNameVoteReq _o_ = (CChangeSwornNameVoteReq)_o1_;
/* 65 */       if (this.votevalue != _o_.votevalue) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.votevalue;
/* 74 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuilder _sb_ = new StringBuilder();
/* 79 */     _sb_.append("(");
/* 80 */     _sb_.append(this.votevalue).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CChangeSwornNameVoteReq _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.votevalue - _o_.votevalue;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\CChangeSwornNameVoteReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */