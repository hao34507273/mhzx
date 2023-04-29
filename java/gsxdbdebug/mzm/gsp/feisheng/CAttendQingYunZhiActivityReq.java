/*    */ package mzm.gsp.feisheng;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.feisheng.qingyunzhi.PCAttendQingYunZhiActivity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CAttendQingYunZhiActivityReq
/*    */   extends __CAttendQingYunZhiActivityReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12614163;
/*    */   public int activity_cfg_id;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     if (roleid < 0L)
/* 22 */       return;
/* 23 */     Role.addRoleProcedure(roleid, new PCAttendQingYunZhiActivity(roleid, this.activity_cfg_id));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12614163;
/*    */   }
/*    */   
/*    */ 
/*    */   public CAttendQingYunZhiActivityReq() {}
/*    */   
/*    */ 
/*    */   public CAttendQingYunZhiActivityReq(int _activity_cfg_id_)
/*    */   {
/* 40 */     this.activity_cfg_id = _activity_cfg_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.activity_cfg_id);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof CAttendQingYunZhiActivityReq)) {
/* 63 */       CAttendQingYunZhiActivityReq _o_ = (CAttendQingYunZhiActivityReq)_o1_;
/* 64 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     int _h_ = 0;
/* 72 */     _h_ += this.activity_cfg_id;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.activity_cfg_id).append(",");
/* 80 */     _sb_.append(")");
/* 81 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CAttendQingYunZhiActivityReq _o_) {
/* 85 */     if (_o_ == this) return 0;
/* 86 */     int _c_ = 0;
/* 87 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 88 */     if (0 != _c_) return _c_;
/* 89 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\CAttendQingYunZhiActivityReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */