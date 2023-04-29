/*    */ package mzm.gsp.mounts;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class PassiveSkillInfo
/*    */   implements Marshal, Comparable<PassiveSkillInfo>
/*    */ {
/*    */   public int current_passive_skill_cfg_id;
/*    */   public int refresh_passive_skill_cfg_id;
/*    */   
/*    */   public PassiveSkillInfo() {}
/*    */   
/*    */   public PassiveSkillInfo(int _current_passive_skill_cfg_id_, int _refresh_passive_skill_cfg_id_)
/*    */   {
/* 18 */     this.current_passive_skill_cfg_id = _current_passive_skill_cfg_id_;
/* 19 */     this.refresh_passive_skill_cfg_id = _refresh_passive_skill_cfg_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.current_passive_skill_cfg_id);
/* 28 */     _os_.marshal(this.refresh_passive_skill_cfg_id);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     this.current_passive_skill_cfg_id = _os_.unmarshal_int();
/* 34 */     this.refresh_passive_skill_cfg_id = _os_.unmarshal_int();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof PassiveSkillInfo)) {
/* 41 */       PassiveSkillInfo _o_ = (PassiveSkillInfo)_o1_;
/* 42 */       if (this.current_passive_skill_cfg_id != _o_.current_passive_skill_cfg_id) return false;
/* 43 */       if (this.refresh_passive_skill_cfg_id != _o_.refresh_passive_skill_cfg_id) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += this.current_passive_skill_cfg_id;
/* 52 */     _h_ += this.refresh_passive_skill_cfg_id;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.current_passive_skill_cfg_id).append(",");
/* 60 */     _sb_.append(this.refresh_passive_skill_cfg_id).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(PassiveSkillInfo _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     _c_ = this.current_passive_skill_cfg_id - _o_.current_passive_skill_cfg_id;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     _c_ = this.refresh_passive_skill_cfg_id - _o_.refresh_passive_skill_cfg_id;
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\PassiveSkillInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */