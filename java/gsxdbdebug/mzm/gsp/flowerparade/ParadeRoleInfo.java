/*    */ package mzm.gsp.flowerparade;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class ParadeRoleInfo implements Marshal
/*    */ {
/*    */   public long roleid;
/*    */   public String rolename;
/*    */   
/*    */   public ParadeRoleInfo()
/*    */   {
/* 13 */     this.rolename = "";
/*    */   }
/*    */   
/*    */   public ParadeRoleInfo(long _roleid_, String _rolename_) {
/* 17 */     this.roleid = _roleid_;
/* 18 */     this.rolename = _rolename_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 26 */     _os_.marshal(this.roleid);
/* 27 */     _os_.marshal(this.rolename, "UTF-16LE");
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 32 */     this.roleid = _os_.unmarshal_long();
/* 33 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 38 */     if (_o1_ == this) return true;
/* 39 */     if ((_o1_ instanceof ParadeRoleInfo)) {
/* 40 */       ParadeRoleInfo _o_ = (ParadeRoleInfo)_o1_;
/* 41 */       if (this.roleid != _o_.roleid) return false;
/* 42 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 43 */       return true;
/*    */     }
/* 45 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 49 */     int _h_ = 0;
/* 50 */     _h_ += (int)this.roleid;
/* 51 */     _h_ += this.rolename.hashCode();
/* 52 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 56 */     StringBuilder _sb_ = new StringBuilder();
/* 57 */     _sb_.append("(");
/* 58 */     _sb_.append(this.roleid).append(",");
/* 59 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 60 */     _sb_.append(")");
/* 61 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\flowerparade\ParadeRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */