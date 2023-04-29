/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.item.main.PFixEquipment;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CFixEquipment
/*    */   extends __CFixEquipment__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584748;
/*    */   public int desequipbagid;
/*    */   public int desequipkey;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PFixEquipment(roleid, this.desequipbagid, this.desequipkey));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 30 */     return 12584748;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CFixEquipment() {}
/*    */   
/*    */ 
/*    */   public CFixEquipment(int _desequipbagid_, int _desequipkey_)
/*    */   {
/* 40 */     this.desequipbagid = _desequipbagid_;
/* 41 */     this.desequipkey = _desequipkey_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.desequipbagid);
/* 50 */     _os_.marshal(this.desequipkey);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.desequipbagid = _os_.unmarshal_int();
/* 56 */     this.desequipkey = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof CFixEquipment)) {
/* 66 */       CFixEquipment _o_ = (CFixEquipment)_o1_;
/* 67 */       if (this.desequipbagid != _o_.desequipbagid) return false;
/* 68 */       if (this.desequipkey != _o_.desequipkey) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.desequipbagid;
/* 77 */     _h_ += this.desequipkey;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.desequipbagid).append(",");
/* 85 */     _sb_.append(this.desequipkey).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CFixEquipment _o_) {
/* 91 */     if (_o_ == this) return 0;
/* 92 */     int _c_ = 0;
/* 93 */     _c_ = this.desequipbagid - _o_.desequipbagid;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.desequipkey - _o_.desequipkey;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CFixEquipment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */