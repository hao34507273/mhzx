/*    */ package mzm.gsp.award;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class RoleInfo
/*    */   implements Marshal
/*    */ {
/*    */   public long roleid;
/*    */   public String rolename;
/*    */   
/*    */   public RoleInfo()
/*    */   {
/* 15 */     this.rolename = "";
/*    */   }
/*    */   
/*    */   public RoleInfo(long _roleid_, String _rolename_) {
/* 19 */     this.roleid = _roleid_;
/* 20 */     this.rolename = _rolename_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.marshal(this.roleid);
/* 29 */     _os_.marshal(this.rolename, "UTF-16LE");
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 34 */     this.roleid = _os_.unmarshal_long();
/* 35 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 40 */     if (_o1_ == this) return true;
/* 41 */     if ((_o1_ instanceof RoleInfo)) {
/* 42 */       RoleInfo _o_ = (RoleInfo)_o1_;
/* 43 */       if (this.roleid != _o_.roleid) return false;
/* 44 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 45 */       return true;
/*    */     }
/* 47 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 51 */     int _h_ = 0;
/* 52 */     _h_ += (int)this.roleid;
/* 53 */     _h_ += this.rolename.hashCode();
/* 54 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 58 */     StringBuilder _sb_ = new StringBuilder();
/* 59 */     _sb_.append("(");
/* 60 */     _sb_.append(this.roleid).append(",");
/* 61 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 62 */     _sb_.append(")");
/* 63 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\RoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */