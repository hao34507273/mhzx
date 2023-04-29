/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class GetKnockOutContext_GetSpecialFightZoneStage
/*    */   implements Marshal, Comparable<GetKnockOutContext_GetSpecialFightZoneStage>
/*    */ {
/*    */   public long role_id;
/*    */   public int fight_stage;
/*    */   
/*    */   public GetKnockOutContext_GetSpecialFightZoneStage() {}
/*    */   
/*    */   public GetKnockOutContext_GetSpecialFightZoneStage(long _role_id_, int _fight_stage_)
/*    */   {
/* 18 */     this.role_id = _role_id_;
/* 19 */     this.fight_stage = _fight_stage_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.role_id);
/* 28 */     _os_.marshal(this.fight_stage);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     this.role_id = _os_.unmarshal_long();
/* 34 */     this.fight_stage = _os_.unmarshal_int();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof GetKnockOutContext_GetSpecialFightZoneStage)) {
/* 41 */       GetKnockOutContext_GetSpecialFightZoneStage _o_ = (GetKnockOutContext_GetSpecialFightZoneStage)_o1_;
/* 42 */       if (this.role_id != _o_.role_id) return false;
/* 43 */       if (this.fight_stage != _o_.fight_stage) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += (int)this.role_id;
/* 52 */     _h_ += this.fight_stage;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.role_id).append(",");
/* 60 */     _sb_.append(this.fight_stage).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(GetKnockOutContext_GetSpecialFightZoneStage _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     _c_ = Long.signum(this.role_id - _o_.role_id);
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     _c_ = this.fight_stage - _o_.fight_stage;
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\GetKnockOutContext_GetSpecialFightZoneStage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */