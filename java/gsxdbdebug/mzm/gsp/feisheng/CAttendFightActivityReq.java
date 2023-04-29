/*    */ package mzm.gsp.feisheng;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.feisheng.fight.PCAttendFightActivity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CAttendFightActivityReq
/*    */   extends __CAttendFightActivityReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12614172;
/*    */   public int activity_cfg_id;
/*    */   public int sortid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     if (roleid < 0L)
/* 22 */       return;
/* 23 */     Role.addRoleProcedure(roleid, new PCAttendFightActivity(roleid, this.activity_cfg_id, this.sortid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12614172;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CAttendFightActivityReq() {}
/*    */   
/*    */ 
/*    */   public CAttendFightActivityReq(int _activity_cfg_id_, int _sortid_)
/*    */   {
/* 41 */     this.activity_cfg_id = _activity_cfg_id_;
/* 42 */     this.sortid = _sortid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.activity_cfg_id);
/* 51 */     _os_.marshal(this.sortid);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 57 */     this.sortid = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CAttendFightActivityReq)) {
/* 67 */       CAttendFightActivityReq _o_ = (CAttendFightActivityReq)_o1_;
/* 68 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 69 */       if (this.sortid != _o_.sortid) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.activity_cfg_id;
/* 78 */     _h_ += this.sortid;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.activity_cfg_id).append(",");
/* 86 */     _sb_.append(this.sortid).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CAttendFightActivityReq _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.sortid - _o_.sortid;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\CAttendFightActivityReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */