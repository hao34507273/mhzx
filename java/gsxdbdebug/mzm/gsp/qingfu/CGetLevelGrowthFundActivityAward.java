/*    */ package mzm.gsp.qingfu;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.qingfu.main.PCGetLevelGrowthFundActivityAward;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetLevelGrowthFundActivityAward
/*    */   extends __CGetLevelGrowthFundActivityAward__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588811;
/*    */   public int activity_id;
/*    */   public int sort_id;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 1L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PCGetLevelGrowthFundActivityAward(roleId, this.activity_id, this.sort_id));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12588811;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGetLevelGrowthFundActivityAward() {}
/*    */   
/*    */ 
/*    */   public CGetLevelGrowthFundActivityAward(int _activity_id_, int _sort_id_)
/*    */   {
/* 41 */     this.activity_id = _activity_id_;
/* 42 */     this.sort_id = _sort_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.activity_id);
/* 51 */     _os_.marshal(this.sort_id);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.activity_id = _os_.unmarshal_int();
/* 57 */     this.sort_id = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CGetLevelGrowthFundActivityAward)) {
/* 67 */       CGetLevelGrowthFundActivityAward _o_ = (CGetLevelGrowthFundActivityAward)_o1_;
/* 68 */       if (this.activity_id != _o_.activity_id) return false;
/* 69 */       if (this.sort_id != _o_.sort_id) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.activity_id;
/* 78 */     _h_ += this.sort_id;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.activity_id).append(",");
/* 86 */     _sb_.append(this.sort_id).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetLevelGrowthFundActivityAward _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.activity_id - _o_.activity_id;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.sort_id - _o_.sort_id;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\CGetLevelGrowthFundActivityAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */