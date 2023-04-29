/*    */ package mzm.gsp.chess;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.chess.main.PCChessMoveReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CChessMoveReq
/*    */   extends __CChessMoveReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12619023;
/*    */   public int from_cell_index;
/*    */   public int to_cell_index;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 0L) {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCChessMoveReq(roleId, this.from_cell_index, this.to_cell_index));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12619023;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CChessMoveReq() {}
/*    */   
/*    */ 
/*    */   public CChessMoveReq(int _from_cell_index_, int _to_cell_index_)
/*    */   {
/* 42 */     this.from_cell_index = _from_cell_index_;
/* 43 */     this.to_cell_index = _to_cell_index_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.from_cell_index);
/* 52 */     _os_.marshal(this.to_cell_index);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.from_cell_index = _os_.unmarshal_int();
/* 58 */     this.to_cell_index = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CChessMoveReq)) {
/* 68 */       CChessMoveReq _o_ = (CChessMoveReq)_o1_;
/* 69 */       if (this.from_cell_index != _o_.from_cell_index) return false;
/* 70 */       if (this.to_cell_index != _o_.to_cell_index) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.from_cell_index;
/* 79 */     _h_ += this.to_cell_index;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.from_cell_index).append(",");
/* 87 */     _sb_.append(this.to_cell_index).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CChessMoveReq _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.from_cell_index - _o_.from_cell_index;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.to_cell_index - _o_.to_cell_index;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chess\CChessMoveReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */