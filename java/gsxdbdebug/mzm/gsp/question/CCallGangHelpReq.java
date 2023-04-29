/*    */ package mzm.gsp.question;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.question.main.PCallGangHelpReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CCallGangHelpReq
/*    */   extends __CCallGangHelpReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12594697;
/*    */   public int questionid;
/*    */   public int pageindex;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PCallGangHelpReq(roleId, this.questionid, this.pageindex));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12594697;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CCallGangHelpReq() {}
/*    */   
/*    */ 
/*    */   public CCallGangHelpReq(int _questionid_, int _pageindex_)
/*    */   {
/* 41 */     this.questionid = _questionid_;
/* 42 */     this.pageindex = _pageindex_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.questionid);
/* 51 */     _os_.marshal(this.pageindex);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.questionid = _os_.unmarshal_int();
/* 57 */     this.pageindex = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CCallGangHelpReq)) {
/* 67 */       CCallGangHelpReq _o_ = (CCallGangHelpReq)_o1_;
/* 68 */       if (this.questionid != _o_.questionid) return false;
/* 69 */       if (this.pageindex != _o_.pageindex) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.questionid;
/* 78 */     _h_ += this.pageindex;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.questionid).append(",");
/* 86 */     _sb_.append(this.pageindex).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CCallGangHelpReq _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.questionid - _o_.questionid;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.pageindex - _o_.pageindex;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\CCallGangHelpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */