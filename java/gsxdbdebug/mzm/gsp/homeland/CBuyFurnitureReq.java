/*    */ package mzm.gsp.homeland;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.homeland.main.PBuyFurnitureReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CBuyFurnitureReq
/*    */   extends __CBuyFurnitureReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605451;
/*    */   public int furnitureid;
/*    */   public int count;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleId, new PBuyFurnitureReq(roleId, this.furnitureid, this.count));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12605451;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CBuyFurnitureReq() {}
/*    */   
/*    */ 
/*    */   public CBuyFurnitureReq(int _furnitureid_, int _count_)
/*    */   {
/* 39 */     this.furnitureid = _furnitureid_;
/* 40 */     this.count = _count_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.furnitureid);
/* 49 */     _os_.marshal(this.count);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.furnitureid = _os_.unmarshal_int();
/* 55 */     this.count = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CBuyFurnitureReq)) {
/* 65 */       CBuyFurnitureReq _o_ = (CBuyFurnitureReq)_o1_;
/* 66 */       if (this.furnitureid != _o_.furnitureid) return false;
/* 67 */       if (this.count != _o_.count) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.furnitureid;
/* 76 */     _h_ += this.count;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.furnitureid).append(",");
/* 84 */     _sb_.append(this.count).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CBuyFurnitureReq _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.furnitureid - _o_.furnitureid;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.count - _o_.count;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\CBuyFurnitureReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */