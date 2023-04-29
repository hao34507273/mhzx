/*    */ package mzm.gsp.lifeskill;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.lifeskill.main.PMakeWuQiFuReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CMakeWuQIFuReq
/*    */   extends __CMakeWuQIFuReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589061;
/*    */   public int skillbagid;
/*    */   public int itemid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PMakeWuQiFuReq(roleId, this.skillbagid, this.itemid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12589061;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CMakeWuQIFuReq() {}
/*    */   
/*    */ 
/*    */   public CMakeWuQIFuReq(int _skillbagid_, int _itemid_)
/*    */   {
/* 41 */     this.skillbagid = _skillbagid_;
/* 42 */     this.itemid = _itemid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.skillbagid);
/* 51 */     _os_.marshal(this.itemid);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.skillbagid = _os_.unmarshal_int();
/* 57 */     this.itemid = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CMakeWuQIFuReq)) {
/* 67 */       CMakeWuQIFuReq _o_ = (CMakeWuQIFuReq)_o1_;
/* 68 */       if (this.skillbagid != _o_.skillbagid) return false;
/* 69 */       if (this.itemid != _o_.itemid) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.skillbagid;
/* 78 */     _h_ += this.itemid;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.skillbagid).append(",");
/* 86 */     _sb_.append(this.itemid).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CMakeWuQIFuReq _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.skillbagid - _o_.skillbagid;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.itemid - _o_.itemid;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lifeskill\CMakeWuQIFuReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */