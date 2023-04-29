/*    */ package gnet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class RoleSimpleInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public long roleid;
/*    */   public Octets rolename;
/*    */   public int level;
/*    */   
/*    */   public RoleSimpleInfo()
/*    */   {
/* 14 */     this.rolename = new Octets();
/*    */   }
/*    */   
/*    */   public RoleSimpleInfo(long _roleid_, Octets _rolename_, int _level_) {
/* 18 */     this.roleid = _roleid_;
/* 19 */     this.rolename = _rolename_;
/* 20 */     this.level = _level_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.marshal(this.roleid);
/* 29 */     _os_.marshal(this.rolename);
/* 30 */     _os_.marshal(this.level);
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 35 */     this.roleid = _os_.unmarshal_long();
/* 36 */     this.rolename = _os_.unmarshal_Octets();
/* 37 */     this.level = _os_.unmarshal_int();
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 42 */     if (_o1_ == this) return true;
/* 43 */     if ((_o1_ instanceof RoleSimpleInfo)) {
/* 44 */       RoleSimpleInfo _o_ = (RoleSimpleInfo)_o1_;
/* 45 */       if (this.roleid != _o_.roleid) return false;
/* 46 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 47 */       if (this.level != _o_.level) return false;
/* 48 */       return true;
/*    */     }
/* 50 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 54 */     int _h_ = 0;
/* 55 */     _h_ += (int)this.roleid;
/* 56 */     _h_ += this.rolename.hashCode();
/* 57 */     _h_ += this.level;
/* 58 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 62 */     StringBuilder _sb_ = new StringBuilder();
/* 63 */     _sb_.append("(");
/* 64 */     _sb_.append(this.roleid).append(",");
/* 65 */     _sb_.append("B").append(this.rolename.size()).append(",");
/* 66 */     _sb_.append(this.level).append(",");
/* 67 */     _sb_.append(")");
/* 68 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\RoleSimpleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */