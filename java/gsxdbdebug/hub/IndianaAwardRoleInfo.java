/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class IndianaAwardRoleInfo implements Marshal
/*    */ {
/*    */   public long roleid;
/*    */   public Octets role_name;
/*    */   
/*    */   public IndianaAwardRoleInfo()
/*    */   {
/* 15 */     this.role_name = new Octets();
/*    */   }
/*    */   
/*    */   public IndianaAwardRoleInfo(long _roleid_, Octets _role_name_) {
/* 19 */     this.roleid = _roleid_;
/* 20 */     this.role_name = _role_name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.marshal(this.roleid);
/* 29 */     _os_.marshal(this.role_name);
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 34 */     this.roleid = _os_.unmarshal_long();
/* 35 */     this.role_name = _os_.unmarshal_Octets();
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 40 */     if (_o1_ == this) return true;
/* 41 */     if ((_o1_ instanceof IndianaAwardRoleInfo)) {
/* 42 */       IndianaAwardRoleInfo _o_ = (IndianaAwardRoleInfo)_o1_;
/* 43 */       if (this.roleid != _o_.roleid) return false;
/* 44 */       if (!this.role_name.equals(_o_.role_name)) return false;
/* 45 */       return true;
/*    */     }
/* 47 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 51 */     int _h_ = 0;
/* 52 */     _h_ += (int)this.roleid;
/* 53 */     _h_ += this.role_name.hashCode();
/* 54 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 58 */     StringBuilder _sb_ = new StringBuilder();
/* 59 */     _sb_.append("(");
/* 60 */     _sb_.append(this.roleid).append(",");
/* 61 */     _sb_.append("B").append(this.role_name.size()).append(",");
/* 62 */     _sb_.append(")");
/* 63 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\IndianaAwardRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */