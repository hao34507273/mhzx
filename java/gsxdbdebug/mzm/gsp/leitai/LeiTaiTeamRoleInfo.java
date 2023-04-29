/*    */ package mzm.gsp.leitai;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class LeiTaiTeamRoleInfo implements Marshal
/*    */ {
/*    */   public LeiTaiRoleInfo roleinfo;
/*    */   public int num;
/*    */   
/*    */   public LeiTaiTeamRoleInfo()
/*    */   {
/* 13 */     this.roleinfo = new LeiTaiRoleInfo();
/*    */   }
/*    */   
/*    */   public LeiTaiTeamRoleInfo(LeiTaiRoleInfo _roleinfo_, int _num_) {
/* 17 */     this.roleinfo = _roleinfo_;
/* 18 */     this.num = _num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     if (!this.roleinfo._validator_()) return false;
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.roleinfo);
/* 28 */     _os_.marshal(this.num);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 33 */     this.roleinfo.unmarshal(_os_);
/* 34 */     this.num = _os_.unmarshal_int();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof LeiTaiTeamRoleInfo)) {
/* 41 */       LeiTaiTeamRoleInfo _o_ = (LeiTaiTeamRoleInfo)_o1_;
/* 42 */       if (!this.roleinfo.equals(_o_.roleinfo)) return false;
/* 43 */       if (this.num != _o_.num) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += this.roleinfo.hashCode();
/* 52 */     _h_ += this.num;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.roleinfo).append(",");
/* 60 */     _sb_.append(this.num).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\leitai\LeiTaiTeamRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */