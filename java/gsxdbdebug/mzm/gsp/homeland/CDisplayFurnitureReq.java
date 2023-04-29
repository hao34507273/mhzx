/*    */ package mzm.gsp.homeland;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.homeland.main.PDisplayFurnitureReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CDisplayFurnitureReq
/*    */   extends __CDisplayFurnitureReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605457;
/*    */   public long furnitureuuid;
/*    */   public DisplayFurnitureInfo furnitureinfo;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleId, new PDisplayFurnitureReq(roleId, this.furnitureuuid, this.furnitureinfo));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12605457;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CDisplayFurnitureReq()
/*    */   {
/* 36 */     this.furnitureinfo = new DisplayFurnitureInfo();
/*    */   }
/*    */   
/*    */   public CDisplayFurnitureReq(long _furnitureuuid_, DisplayFurnitureInfo _furnitureinfo_) {
/* 40 */     this.furnitureuuid = _furnitureuuid_;
/* 41 */     this.furnitureinfo = _furnitureinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     if (!this.furnitureinfo._validator_()) return false;
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.furnitureuuid);
/* 51 */     _os_.marshal(this.furnitureinfo);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.furnitureuuid = _os_.unmarshal_long();
/* 57 */     this.furnitureinfo.unmarshal(_os_);
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CDisplayFurnitureReq)) {
/* 67 */       CDisplayFurnitureReq _o_ = (CDisplayFurnitureReq)_o1_;
/* 68 */       if (this.furnitureuuid != _o_.furnitureuuid) return false;
/* 69 */       if (!this.furnitureinfo.equals(_o_.furnitureinfo)) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += (int)this.furnitureuuid;
/* 78 */     _h_ += this.furnitureinfo.hashCode();
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.furnitureuuid).append(",");
/* 86 */     _sb_.append(this.furnitureinfo).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CDisplayFurnitureReq _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = Long.signum(this.furnitureuuid - _o_.furnitureuuid);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.furnitureinfo.compareTo(_o_.furnitureinfo);
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\CDisplayFurnitureReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */