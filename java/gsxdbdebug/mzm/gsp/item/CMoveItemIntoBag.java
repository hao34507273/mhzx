/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.item.main.PMoveItemIntoBag;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CMoveItemIntoBag
/*    */   extends __CMoveItemIntoBag__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584805;
/*    */   public int srckey;
/*    */   public int storageid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PMoveItemIntoBag(roleid, this.srckey, this.storageid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 30 */     return 12584805;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CMoveItemIntoBag() {}
/*    */   
/*    */ 
/*    */   public CMoveItemIntoBag(int _srckey_, int _storageid_)
/*    */   {
/* 40 */     this.srckey = _srckey_;
/* 41 */     this.storageid = _storageid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.srckey);
/* 50 */     _os_.marshal(this.storageid);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.srckey = _os_.unmarshal_int();
/* 56 */     this.storageid = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof CMoveItemIntoBag)) {
/* 66 */       CMoveItemIntoBag _o_ = (CMoveItemIntoBag)_o1_;
/* 67 */       if (this.srckey != _o_.srckey) return false;
/* 68 */       if (this.storageid != _o_.storageid) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.srckey;
/* 77 */     _h_ += this.storageid;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.srckey).append(",");
/* 85 */     _sb_.append(this.storageid).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CMoveItemIntoBag _o_) {
/* 91 */     if (_o_ == this) return 0;
/* 92 */     int _c_ = 0;
/* 93 */     _c_ = this.srckey - _o_.srckey;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.storageid - _o_.storageid;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CMoveItemIntoBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */