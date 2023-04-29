/*    */ package mzm.gsp.cat;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.cat.main.PCCatRename;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CCatRename
/*    */   extends __CCatRename__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605706;
/*    */   public Octets cat_name;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 1L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCCatRename(roleId, this.cat_name));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12605706;
/*    */   }
/*    */   
/*    */ 
/*    */   public CCatRename()
/*    */   {
/* 38 */     this.cat_name = new Octets();
/*    */   }
/*    */   
/*    */   public CCatRename(Octets _cat_name_) {
/* 42 */     this.cat_name = _cat_name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.cat_name);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.cat_name = _os_.unmarshal_Octets();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CCatRename)) {
/* 65 */       CCatRename _o_ = (CCatRename)_o1_;
/* 66 */       if (!this.cat_name.equals(_o_.cat_name)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.cat_name.hashCode();
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append("B").append(this.cat_name.size()).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\CCatRename.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */