/*    */ package mzm.gsp.children;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.children.main.PCChildrenChartReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CChildrenChartReq
/*    */   extends __CChildrenChartReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12609432;
/*    */   public int start_pos;
/*    */   public int end_pos;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 0L) {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCChildrenChartReq(this.start_pos, this.end_pos, roleId));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12609432;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CChildrenChartReq() {}
/*    */   
/*    */ 
/*    */   public CChildrenChartReq(int _start_pos_, int _end_pos_)
/*    */   {
/* 42 */     this.start_pos = _start_pos_;
/* 43 */     this.end_pos = _end_pos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.start_pos);
/* 52 */     _os_.marshal(this.end_pos);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.start_pos = _os_.unmarshal_int();
/* 58 */     this.end_pos = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CChildrenChartReq)) {
/* 68 */       CChildrenChartReq _o_ = (CChildrenChartReq)_o1_;
/* 69 */       if (this.start_pos != _o_.start_pos) return false;
/* 70 */       if (this.end_pos != _o_.end_pos) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.start_pos;
/* 79 */     _h_ += this.end_pos;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.start_pos).append(",");
/* 87 */     _sb_.append(this.end_pos).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CChildrenChartReq _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.start_pos - _o_.start_pos;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.end_pos - _o_.end_pos;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\CChildrenChartReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */