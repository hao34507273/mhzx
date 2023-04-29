/*    */ package mzm.gsp.huanhun;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.huanhun.main.PCheckXItemInfoReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CCheckXItemInfoReq
/*    */   extends __CCheckXItemInfoReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584451;
/*    */   public long roleidchecked;
/*    */   public int itemindex;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleid = Role.getRoleId(this);
/* 20 */     if (roleid < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleid, new PCheckXItemInfoReq(roleid, this.roleidchecked, this.itemindex));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12584451;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CCheckXItemInfoReq() {}
/*    */   
/*    */ 
/*    */   public CCheckXItemInfoReq(long _roleidchecked_, int _itemindex_)
/*    */   {
/* 41 */     this.roleidchecked = _roleidchecked_;
/* 42 */     this.itemindex = _itemindex_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.roleidchecked);
/* 51 */     _os_.marshal(this.itemindex);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.roleidchecked = _os_.unmarshal_long();
/* 57 */     this.itemindex = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CCheckXItemInfoReq)) {
/* 67 */       CCheckXItemInfoReq _o_ = (CCheckXItemInfoReq)_o1_;
/* 68 */       if (this.roleidchecked != _o_.roleidchecked) return false;
/* 69 */       if (this.itemindex != _o_.itemindex) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += (int)this.roleidchecked;
/* 78 */     _h_ += this.itemindex;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.roleidchecked).append(",");
/* 86 */     _sb_.append(this.itemindex).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CCheckXItemInfoReq _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = Long.signum(this.roleidchecked - _o_.roleidchecked);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.itemindex - _o_.itemindex;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\CCheckXItemInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */