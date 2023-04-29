/*    */ package mzm.gsp.homeland;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.homeland.main.PTransferMaidToReq;
/*    */ import mzm.gsp.map.Location;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CTransferMaidToReq
/*    */   extends __CTransferMaidToReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605505;
/*    */   public ArrayList<Location> locations;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleId, new PTransferMaidToReq(roleId, this.locations));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12605505;
/*    */   }
/*    */   
/*    */ 
/*    */   public CTransferMaidToReq()
/*    */   {
/* 35 */     this.locations = new ArrayList();
/*    */   }
/*    */   
/*    */   public CTransferMaidToReq(ArrayList<Location> _locations_) {
/* 39 */     this.locations = _locations_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (Location _v_ : this.locations)
/* 44 */       if (!_v_._validator_()) return false;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.compact_uint32(this.locations.size());
/* 50 */     for (Location _v_ : this.locations) {
/* 51 */       _os_.marshal(_v_);
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 58 */       Location _v_ = new Location();
/* 59 */       _v_.unmarshal(_os_);
/* 60 */       this.locations.add(_v_);
/*    */     }
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof CTransferMaidToReq)) {
/* 71 */       CTransferMaidToReq _o_ = (CTransferMaidToReq)_o1_;
/* 72 */       if (!this.locations.equals(_o_.locations)) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += this.locations.hashCode();
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.locations).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\CTransferMaidToReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */