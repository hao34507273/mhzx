/*    */ package mzm.gsp.partner;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.partner.main.PChangeZhenFaReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CChangeZhenFaReq
/*    */   extends __CChangeZhenFaReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588042;
/*    */   public int lineupnum;
/*    */   public int zhenfaid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PChangeZhenFaReq(roleId, this.lineupnum, this.zhenfaid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12588042;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CChangeZhenFaReq() {}
/*    */   
/*    */ 
/*    */   public CChangeZhenFaReq(int _lineupnum_, int _zhenfaid_)
/*    */   {
/* 41 */     this.lineupnum = _lineupnum_;
/* 42 */     this.zhenfaid = _zhenfaid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.lineupnum);
/* 51 */     _os_.marshal(this.zhenfaid);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.lineupnum = _os_.unmarshal_int();
/* 57 */     this.zhenfaid = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CChangeZhenFaReq)) {
/* 67 */       CChangeZhenFaReq _o_ = (CChangeZhenFaReq)_o1_;
/* 68 */       if (this.lineupnum != _o_.lineupnum) return false;
/* 69 */       if (this.zhenfaid != _o_.zhenfaid) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.lineupnum;
/* 78 */     _h_ += this.zhenfaid;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.lineupnum).append(",");
/* 86 */     _sb_.append(this.zhenfaid).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CChangeZhenFaReq _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.lineupnum - _o_.lineupnum;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.zhenfaid - _o_.zhenfaid;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\CChangeZhenFaReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */