/*    */ package mzm.gsp.pk;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.pk.main.PUseRevengeItem;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CUseRevengeItemReq
/*    */   extends __CUseRevengeItemReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12619791;
/*    */   public int bag_id;
/*    */   public int grid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleId, new PUseRevengeItem(roleId, this.bag_id, this.grid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12619791;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CUseRevengeItemReq() {}
/*    */   
/*    */ 
/*    */   public CUseRevengeItemReq(int _bag_id_, int _grid_)
/*    */   {
/* 39 */     this.bag_id = _bag_id_;
/* 40 */     this.grid = _grid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.bag_id);
/* 49 */     _os_.marshal(this.grid);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.bag_id = _os_.unmarshal_int();
/* 55 */     this.grid = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CUseRevengeItemReq)) {
/* 65 */       CUseRevengeItemReq _o_ = (CUseRevengeItemReq)_o1_;
/* 66 */       if (this.bag_id != _o_.bag_id) return false;
/* 67 */       if (this.grid != _o_.grid) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.bag_id;
/* 76 */     _h_ += this.grid;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.bag_id).append(",");
/* 84 */     _sb_.append(this.grid).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CUseRevengeItemReq _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.bag_id - _o_.bag_id;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.grid - _o_.grid;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\CUseRevengeItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */