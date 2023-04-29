/*    */ package mzm.gsp.qingfu;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.qingfu.main.PCGetAccumTotalCostActivityAward;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetAccumTotalCostActivityAward
/*    */   extends __CGetAccumTotalCostActivityAward__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588823;
/*    */   public int activity_cfgid;
/*    */   public int sortid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 1L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCGetAccumTotalCostActivityAward(roleId, this.activity_cfgid, this.sortid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12588823;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGetAccumTotalCostActivityAward() {}
/*    */   
/*    */ 
/*    */   public CGetAccumTotalCostActivityAward(int _activity_cfgid_, int _sortid_)
/*    */   {
/* 42 */     this.activity_cfgid = _activity_cfgid_;
/* 43 */     this.sortid = _sortid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.activity_cfgid);
/* 52 */     _os_.marshal(this.sortid);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.activity_cfgid = _os_.unmarshal_int();
/* 58 */     this.sortid = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CGetAccumTotalCostActivityAward)) {
/* 68 */       CGetAccumTotalCostActivityAward _o_ = (CGetAccumTotalCostActivityAward)_o1_;
/* 69 */       if (this.activity_cfgid != _o_.activity_cfgid) return false;
/* 70 */       if (this.sortid != _o_.sortid) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.activity_cfgid;
/* 79 */     _h_ += this.sortid;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.activity_cfgid).append(",");
/* 87 */     _sb_.append(this.sortid).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetAccumTotalCostActivityAward _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.activity_cfgid - _o_.activity_cfgid;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.sortid - _o_.sortid;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\CGetAccumTotalCostActivityAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */