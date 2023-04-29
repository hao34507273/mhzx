/*    */ package mzm.gsp.homeland;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.homeland.main.PSellFurnitureReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CSellFurnitureReq
/*    */   extends __CSellFurnitureReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605454;
/*    */   public long furnitureuuid;
/*    */   public int furnitureid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleId, new PSellFurnitureReq(roleId, this.furnitureid, this.furnitureuuid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12605454;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CSellFurnitureReq() {}
/*    */   
/*    */ 
/*    */   public CSellFurnitureReq(long _furnitureuuid_, int _furnitureid_)
/*    */   {
/* 39 */     this.furnitureuuid = _furnitureuuid_;
/* 40 */     this.furnitureid = _furnitureid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.furnitureuuid);
/* 49 */     _os_.marshal(this.furnitureid);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.furnitureuuid = _os_.unmarshal_long();
/* 55 */     this.furnitureid = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CSellFurnitureReq)) {
/* 65 */       CSellFurnitureReq _o_ = (CSellFurnitureReq)_o1_;
/* 66 */       if (this.furnitureuuid != _o_.furnitureuuid) return false;
/* 67 */       if (this.furnitureid != _o_.furnitureid) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.furnitureuuid;
/* 76 */     _h_ += this.furnitureid;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.furnitureuuid).append(",");
/* 84 */     _sb_.append(this.furnitureid).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CSellFurnitureReq _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = Long.signum(this.furnitureuuid - _o_.furnitureuuid);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.furnitureid - _o_.furnitureid;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\CSellFurnitureReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */