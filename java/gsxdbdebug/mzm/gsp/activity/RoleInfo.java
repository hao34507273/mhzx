/*    */ package mzm.gsp.activity;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class RoleInfo implements Marshal
/*    */ {
/*    */   public String rolename;
/*    */   
/*    */   public RoleInfo()
/*    */   {
/* 12 */     this.rolename = "";
/*    */   }
/*    */   
/*    */   public RoleInfo(String _rolename_) {
/* 16 */     this.rolename = _rolename_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 20 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 24 */     _os_.marshal(this.rolename, "UTF-16LE");
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 29 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 34 */     if (_o1_ == this) return true;
/* 35 */     if ((_o1_ instanceof RoleInfo)) {
/* 36 */       RoleInfo _o_ = (RoleInfo)_o1_;
/* 37 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 38 */       return true;
/*    */     }
/* 40 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 44 */     int _h_ = 0;
/* 45 */     _h_ += this.rolename.hashCode();
/* 46 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 50 */     StringBuilder _sb_ = new StringBuilder();
/* 51 */     _sb_.append("(");
/* 52 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 53 */     _sb_.append(")");
/* 54 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\RoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */