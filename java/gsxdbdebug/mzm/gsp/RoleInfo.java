/*    */ package mzm.gsp;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class RoleInfo implements Marshal
/*    */ {
/*    */   public CreateRoleArg basic;
/*    */   public long roleid;
/*    */   public long expiretime;
/*    */   public int delendtime;
/*    */   public long qqid;
/*    */   
/*    */   public RoleInfo()
/*    */   {
/* 16 */     this.basic = new CreateRoleArg();
/* 17 */     this.roleid = -1L;
/*    */   }
/*    */   
/*    */   public RoleInfo(CreateRoleArg _basic_, long _roleid_, long _expiretime_, int _delendtime_, long _qqid_) {
/* 21 */     this.basic = _basic_;
/* 22 */     this.roleid = _roleid_;
/* 23 */     this.expiretime = _expiretime_;
/* 24 */     this.delendtime = _delendtime_;
/* 25 */     this.qqid = _qqid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     if (!this.basic._validator_()) return false;
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 34 */     _os_.marshal(this.basic);
/* 35 */     _os_.marshal(this.roleid);
/* 36 */     _os_.marshal(this.expiretime);
/* 37 */     _os_.marshal(this.delendtime);
/* 38 */     _os_.marshal(this.qqid);
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 43 */     this.basic.unmarshal(_os_);
/* 44 */     this.roleid = _os_.unmarshal_long();
/* 45 */     this.expiretime = _os_.unmarshal_long();
/* 46 */     this.delendtime = _os_.unmarshal_int();
/* 47 */     this.qqid = _os_.unmarshal_long();
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 52 */     if (_o1_ == this) return true;
/* 53 */     if ((_o1_ instanceof RoleInfo)) {
/* 54 */       RoleInfo _o_ = (RoleInfo)_o1_;
/* 55 */       if (!this.basic.equals(_o_.basic)) return false;
/* 56 */       if (this.roleid != _o_.roleid) return false;
/* 57 */       if (this.expiretime != _o_.expiretime) return false;
/* 58 */       if (this.delendtime != _o_.delendtime) return false;
/* 59 */       if (this.qqid != _o_.qqid) return false;
/* 60 */       return true;
/*    */     }
/* 62 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 66 */     int _h_ = 0;
/* 67 */     _h_ += this.basic.hashCode();
/* 68 */     _h_ += (int)this.roleid;
/* 69 */     _h_ += (int)this.expiretime;
/* 70 */     _h_ += this.delendtime;
/* 71 */     _h_ += (int)this.qqid;
/* 72 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 76 */     StringBuilder _sb_ = new StringBuilder();
/* 77 */     _sb_.append("(");
/* 78 */     _sb_.append(this.basic).append(",");
/* 79 */     _sb_.append(this.roleid).append(",");
/* 80 */     _sb_.append(this.expiretime).append(",");
/* 81 */     _sb_.append(this.delendtime).append(",");
/* 82 */     _sb_.append(this.qqid).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\RoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */