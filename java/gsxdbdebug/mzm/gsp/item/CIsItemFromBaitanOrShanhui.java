/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.item.main.PIsItemFromBaitanOrShanhui;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CIsItemFromBaitanOrShanhui
/*    */   extends __CIsItemFromBaitanOrShanhui__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584831;
/*    */   public int itemorsiftcfgid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PIsItemFromBaitanOrShanhui(roleid, this.itemorsiftcfgid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 30 */     return 12584831;
/*    */   }
/*    */   
/*    */ 
/*    */   public CIsItemFromBaitanOrShanhui() {}
/*    */   
/*    */ 
/*    */   public CIsItemFromBaitanOrShanhui(int _itemorsiftcfgid_)
/*    */   {
/* 39 */     this.itemorsiftcfgid = _itemorsiftcfgid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.itemorsiftcfgid);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.itemorsiftcfgid = _os_.unmarshal_int();
/* 53 */     if (!_validator_()) {
/* 54 */       throw new VerifyError("validator failed");
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 60 */     if (_o1_ == this) return true;
/* 61 */     if ((_o1_ instanceof CIsItemFromBaitanOrShanhui)) {
/* 62 */       CIsItemFromBaitanOrShanhui _o_ = (CIsItemFromBaitanOrShanhui)_o1_;
/* 63 */       if (this.itemorsiftcfgid != _o_.itemorsiftcfgid) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.itemorsiftcfgid;
/* 72 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 76 */     StringBuilder _sb_ = new StringBuilder();
/* 77 */     _sb_.append("(");
/* 78 */     _sb_.append(this.itemorsiftcfgid).append(",");
/* 79 */     _sb_.append(")");
/* 80 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CIsItemFromBaitanOrShanhui _o_) {
/* 84 */     if (_o_ == this) return 0;
/* 85 */     int _c_ = 0;
/* 86 */     _c_ = this.itemorsiftcfgid - _o_.itemorsiftcfgid;
/* 87 */     if (0 != _c_) return _c_;
/* 88 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CIsItemFromBaitanOrShanhui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */