/*    */ package mzm.gsp.planttree;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.planttree.main.PCGetPlantTreeDetailInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetPlantTreeDetailInfoReq
/*    */   extends __CGetPlantTreeDetailInfoReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12611602;
/*    */   public long owner_id;
/*    */   public int activity_cfg_id;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     if (roleid < 0L)
/* 22 */       return;
/* 23 */     Role.addRoleProcedure(roleid, new PCGetPlantTreeDetailInfo(roleid, this.owner_id, this.activity_cfg_id));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12611602;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGetPlantTreeDetailInfoReq() {}
/*    */   
/*    */ 
/*    */   public CGetPlantTreeDetailInfoReq(long _owner_id_, int _activity_cfg_id_)
/*    */   {
/* 41 */     this.owner_id = _owner_id_;
/* 42 */     this.activity_cfg_id = _activity_cfg_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.owner_id);
/* 51 */     _os_.marshal(this.activity_cfg_id);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.owner_id = _os_.unmarshal_long();
/* 57 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CGetPlantTreeDetailInfoReq)) {
/* 67 */       CGetPlantTreeDetailInfoReq _o_ = (CGetPlantTreeDetailInfoReq)_o1_;
/* 68 */       if (this.owner_id != _o_.owner_id) return false;
/* 69 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += (int)this.owner_id;
/* 78 */     _h_ += this.activity_cfg_id;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.owner_id).append(",");
/* 86 */     _sb_.append(this.activity_cfg_id).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetPlantTreeDetailInfoReq _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = Long.signum(this.owner_id - _o_.owner_id);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\CGetPlantTreeDetailInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */