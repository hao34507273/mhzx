/*    */ package mzm.gsp.marriage;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.marriage.main.PCMarryReq;
/*    */ 
/*    */ public class CMarryReq
/*    */   extends __CMarryReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12599812;
/*    */   public static final int UNUSE_YUANBAO = 0;
/*    */   public static final int USE_YUANBAO_REPLACE_ITEM = 1;
/*    */   public int level;
/*    */   public int useyuanbao;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleid = Role.getRoleId(this);
/* 20 */     Role.addRoleProcedure(roleid, new PCMarryReq(roleid, this.level, this.useyuanbao));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12599812;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public CMarryReq() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public CMarryReq(int _level_, int _useyuanbao_)
/*    */   {
/* 42 */     this.level = _level_;
/* 43 */     this.useyuanbao = _useyuanbao_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.level);
/* 52 */     _os_.marshal(this.useyuanbao);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.level = _os_.unmarshal_int();
/* 58 */     this.useyuanbao = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CMarryReq)) {
/* 68 */       CMarryReq _o_ = (CMarryReq)_o1_;
/* 69 */       if (this.level != _o_.level) return false;
/* 70 */       if (this.useyuanbao != _o_.useyuanbao) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.level;
/* 79 */     _h_ += this.useyuanbao;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.level).append(",");
/* 87 */     _sb_.append(this.useyuanbao).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CMarryReq _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.level - _o_.level;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.useyuanbao - _o_.useyuanbao;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\CMarryReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */