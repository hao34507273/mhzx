/*    */ package mzm.gsp.fabao;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.fabao.main.PLongjingMountReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CLongjingMountReq
/*    */   extends __CLongjingMountReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12595981;
/*    */   public int itemkey;
/*    */   public int pos;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PLongjingMountReq(roleid, this.itemkey, this.pos));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12595981;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CLongjingMountReq() {}
/*    */   
/*    */ 
/*    */   public CLongjingMountReq(int _itemkey_, int _pos_)
/*    */   {
/* 39 */     this.itemkey = _itemkey_;
/* 40 */     this.pos = _pos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.itemkey);
/* 49 */     _os_.marshal(this.pos);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.itemkey = _os_.unmarshal_int();
/* 55 */     this.pos = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CLongjingMountReq)) {
/* 65 */       CLongjingMountReq _o_ = (CLongjingMountReq)_o1_;
/* 66 */       if (this.itemkey != _o_.itemkey) return false;
/* 67 */       if (this.pos != _o_.pos) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.itemkey;
/* 76 */     _h_ += this.pos;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.itemkey).append(",");
/* 84 */     _sb_.append(this.pos).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CLongjingMountReq _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.itemkey - _o_.itemkey;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.pos - _o_.pos;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\CLongjingMountReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */