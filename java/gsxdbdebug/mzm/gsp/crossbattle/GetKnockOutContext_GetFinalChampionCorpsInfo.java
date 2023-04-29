/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class GetKnockOutContext_GetFinalChampionCorpsInfo
/*    */   implements Marshal, Comparable<GetKnockOutContext_GetFinalChampionCorpsInfo>
/*    */ {
/*    */   public int session;
/*    */   public int activity_cfg_id;
/*    */   
/*    */   public GetKnockOutContext_GetFinalChampionCorpsInfo() {}
/*    */   
/*    */   public GetKnockOutContext_GetFinalChampionCorpsInfo(int _session_, int _activity_cfg_id_)
/*    */   {
/* 18 */     this.session = _session_;
/* 19 */     this.activity_cfg_id = _activity_cfg_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.session);
/* 28 */     _os_.marshal(this.activity_cfg_id);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     this.session = _os_.unmarshal_int();
/* 34 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof GetKnockOutContext_GetFinalChampionCorpsInfo)) {
/* 41 */       GetKnockOutContext_GetFinalChampionCorpsInfo _o_ = (GetKnockOutContext_GetFinalChampionCorpsInfo)_o1_;
/* 42 */       if (this.session != _o_.session) return false;
/* 43 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += this.session;
/* 52 */     _h_ += this.activity_cfg_id;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.session).append(",");
/* 60 */     _sb_.append(this.activity_cfg_id).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(GetKnockOutContext_GetFinalChampionCorpsInfo _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     _c_ = this.session - _o_.session;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\GetKnockOutContext_GetFinalChampionCorpsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */