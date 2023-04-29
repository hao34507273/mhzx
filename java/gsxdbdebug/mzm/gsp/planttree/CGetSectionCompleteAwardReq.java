/*    */ package mzm.gsp.planttree;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.planttree.main.PCGetSectionCompleteAward;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetSectionCompleteAwardReq
/*    */   extends __CGetSectionCompleteAwardReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12611599;
/*    */   public int activity_cfg_id;
/*    */   public int section_id;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     if (roleid < 0L)
/* 22 */       return;
/* 23 */     Role.addRoleProcedure(roleid, new PCGetSectionCompleteAward(roleid, this.activity_cfg_id, this.section_id));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12611599;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGetSectionCompleteAwardReq() {}
/*    */   
/*    */ 
/*    */   public CGetSectionCompleteAwardReq(int _activity_cfg_id_, int _section_id_)
/*    */   {
/* 42 */     this.activity_cfg_id = _activity_cfg_id_;
/* 43 */     this.section_id = _section_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.activity_cfg_id);
/* 52 */     _os_.marshal(this.section_id);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 58 */     this.section_id = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CGetSectionCompleteAwardReq)) {
/* 68 */       CGetSectionCompleteAwardReq _o_ = (CGetSectionCompleteAwardReq)_o1_;
/* 69 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 70 */       if (this.section_id != _o_.section_id) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.activity_cfg_id;
/* 79 */     _h_ += this.section_id;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.activity_cfg_id).append(",");
/* 87 */     _sb_.append(this.section_id).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetSectionCompleteAwardReq _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.section_id - _o_.section_id;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\CGetSectionCompleteAwardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */